package Servlet.film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.ActorQuery;
import Bean.Film;
import database.DB;

@WebServlet(name = "actorQueryServlet")
public class actorQueryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("actorName");
        String sql = "SELECT Actor.Role, Film.FilmName, Person.PersonName, Person.PersonBirth FROM Actor JOIN Film USING (FilmID) JOIN Person USING (PersonID) WHERE Person.PersonName = ?";
        try {
            DB db = new DB();
//            System.out.println(sql);
            PreparedStatement result = db.getpreparedstatement(sql);
            result.setString(1,name);
            ResultSet rs = result.executeQuery();
            List<ActorQuery> information = new ArrayList<>();
            while(rs.next())
            {
                ActorQuery actorQuery = new ActorQuery(
                        rs.getString("Role"),
                        rs.getString("FilmName"),
                        rs.getString("PersonName"),
                        rs.getString("PersonBirth"));

                information.add(actorQuery);
//                System.out.println(rs.getString("PersonName"));
//                System.out.println(rs.getString("PersonBirth"));
//                System.out.println(rs.getString("FilmName"));
//                System.out.println(rs.getString("Role"));
                System.out.println(actorQuery.getPersonName());
                System.out.println(actorQuery.getPersonBirth());
                System.out.println(actorQuery.getFilmName());
                System.out.println(actorQuery.getRole());
            }
            System.out.println(information.size());
            request.setAttribute("information", information);
            request.getRequestDispatcher("/film/actorQueryResult.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
