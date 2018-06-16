package Servlet.film;

import utils.UpdateFilmActor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FilmActorUpdateServlet")
public class FilmActorUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String updateInfo;
        int affectRows;

        String filmID = request.getParameter("FilmID");
        String actorName0 = request.getParameter("Filmactor0");
        String actorName1 = request.getParameter("Filmactor1");
        String actorRole0 = request.getParameter("Filmrole0");
        String actorRole1 = request.getParameter("Filmrole1");

        UpdateFilmActor updateFilmActor = new UpdateFilmActor(filmID,actorName0,actorName1,actorRole0,actorRole1);
        updateFilmActor.executeUpdate();
        affectRows = updateFilmActor.getAffectRows();
        if(affectRows>0)
            updateInfo = "Update Successfully!";
        else
            updateInfo = "Update Failed!";
        request.setAttribute("affectRows",affectRows);
        request.setAttribute("updateInfo",updateInfo);
        request.getRequestDispatcher("/film/FilmOtherChangeQuery.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request,response);
    }
}
