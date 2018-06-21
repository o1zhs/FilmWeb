package Servlet.film;

import Bean.Film;
import utils.UpdateFilm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FilmUpdateServlet")
public class FilmUpdateServlet extends HttpServlet {
    private String updateInfo;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filmID = request.getParameter("FilmID");
        String filmName = request.getParameter("FilmName");
        String date =  request.getParameter("date");
        String filmLength = request.getParameter("FilmLength");
        String firmName = request.getParameter("Firm");
        String filmPlot = request.getParameter("FilmPlot");

        Film film = new Film(filmID,filmName,date,firmName,filmLength,
                null,null,null,null,filmPlot);
        UpdateFilm updateFilm = new UpdateFilm(film);
        if(updateFilm.getTrue()){
            int affectRows = updateFilm.executeUpdate();
            if(affectRows>0)
                updateInfo = "Update successfully!";
            else
                updateInfo = "Update failed!";
            request.setAttribute("affectRows",affectRows);
            request.setAttribute("updateInfo",updateInfo);
            request.getRequestDispatcher("film/RightOutput.jsp").forward(request,response);
        }
        else{
            Boolean isExisted = null;
            if(!updateFilm.getExisted())
                isExisted = false;
            else if(updateFilm.getSame()){
                isExisted = true;
            }
            request.setAttribute("isExisted",isExisted);
            request.setAttribute("isTrue",updateFilm.getTrue());
            request.setAttribute("errorOperation","Insert");
            request.setAttribute("errorObject","Film");
            request.getRequestDispatcher("/film/ErrorOutput.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
