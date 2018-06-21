package Servlet.film;

import utils.DeleteFilm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FilmDeleteServlet")
public class FilmDeleteServlet extends HttpServlet {

    private String resultInfo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String filmName = request.getParameter("FilmName");
        String filmID = request.getParameter("FilmID");

        DeleteFilm deleteFilm;

        //影响行数，即删除的行数
        int affectRows;
        if(filmName != null)
            deleteFilm = new DeleteFilm(filmID, filmName);
        else
            deleteFilm = new DeleteFilm(filmID);

        if(deleteFilm.getTrue()){
            affectRows = deleteFilm.executeDelete();
            if(affectRows >0)
                this.resultInfo = "Delete Successfully!";
            else
                this.resultInfo = filmID + " " + filmName + " doesn't exists!";
            request.setAttribute("affectRows", affectRows);
            request.setAttribute("resultInfo",this.resultInfo);
            request.getRequestDispatcher("film/RightOutput.jsp").forward(request,response);
        }
        else{
            request.setAttribute("errorObject","Film");
            request.setAttribute("errorOperation","Delete");
            request.setAttribute("isTrue",deleteFilm.getTrue());
            request.setAttribute("isExisted",deleteFilm.getExisted());
            request.getRequestDispatcher("/film/ErrorOutput.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
