package Servlet.film;

import Bean.ActorQuery;
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

import Bean.DirectorQuery;
import user.User;

@WebServlet(name = "directorQueryServlet")
public class directorQueryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("directorname");
        String sql = "SELECT Person.PersonName, Person.PersonBirth, Film.FilmName  FROM Person JOIN Director USING (PersonID) JOIN Film USING (FilmID) WHERE Person.PersonName = ?";
        try {
            DB db = new DB();
//            System.out.println(sql);
            PreparedStatement result = db.getpreparedstatement(sql);
            result.setString(1,name);
            ResultSet rs = result.executeQuery();
            List<DirectorQuery> information = new ArrayList<>();
            while(rs.next())
            {
                DirectorQuery directorQuery = new DirectorQuery(rs.getString("PersonName"),
                        rs.getString("PersonBirth"),
                        rs.getString("FilmName"));

                information.add(directorQuery);
                System.out.println(rs.getString("PersonName"));
                System.out.println(rs.getString("PersonBirth"));
                System.out.println(rs.getString("FilmName"));
            }
            System.out.println(information.size());
            Boolean isNull = true;
            if(information.size()>0)
                isNull = false;
            request.setAttribute("isNull",isNull);
            request.setAttribute("information", information);
            request.getRequestDispatcher("/film/directorQueryResult.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
