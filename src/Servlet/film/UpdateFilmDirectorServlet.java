package Servlet.film;

import utils.UpdateFilmDirector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateFilmDirectorServlet")
public class UpdateFilmDirectorServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int affectRows;
        String updateInfo;

        String filmID = request.getParameter("FilmID");
        String directorName0 = request.getParameter("Filmdirector_cpre");
        String directorName1 = request.getParameter("Filmdirector_clate");
        UpdateFilmDirector updateFilmDirector = new UpdateFilmDirector(filmID,directorName0,directorName1);
        updateFilmDirector.executeUpdate();
        affectRows = updateFilmDirector.getAffectRows();
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
