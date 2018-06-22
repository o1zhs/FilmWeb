package Servlet.film;

import Bean.VoiceQuery;
import com.sun.org.apache.xpath.internal.operations.Bool;
import database.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Bean.VoiceQuery;
import user.User;

@WebServlet(name = "voiceQueryServlet")
public class voiceQueryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("voicename");
        String sql = "SELECT Person.PersonName, Person.PersonBirth, Film.FilmName  FROM Person JOIN Voice USING (PersonID) JOIN Film USING (FilmID) WHERE Person.PersonName = ?";
        try {
            DB db = new DB();
//            System.out.println(sql);
            PreparedStatement result = db.getpreparedstatement(sql);
            result.setString(1,name);
            ResultSet rs = result.executeQuery();
            List<VoiceQuery> information = new ArrayList<>();
            while(rs.next())
            {
                VoiceQuery voiceQuery = new VoiceQuery(rs.getString("PersonName"),
                        rs.getString("PersonBirth"),
                        rs.getString("FilmName"));

                information.add(voiceQuery);
                System.out.println(rs.getString("PersonName"));
                System.out.println(rs.getString("PersonBirth"));
                System.out.println(rs.getString("FilmName"));
            }
            Boolean isNull = false;
            if(information.size()>0)
                isNull = true;
            request.setAttribute("isNull",isNull);
            request.setAttribute("information", information);
            request.getRequestDispatcher("/film/voice_QueryResult.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
