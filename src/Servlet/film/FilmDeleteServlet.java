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

        //影响行数，即删除的行数
        int affectRows;

        if(!filmName.equals("")){
            DeleteFilm deleteFilm = new DeleteFilm(filmID, filmName);
            affectRows = deleteFilm.executeDelete();
            if(affectRows >0)
                this.resultInfo = "Delete Successfully!";
            else
                this.resultInfo = filmID + " " + filmName + " doesn't exists!";
            request.setAttribute("affectRows", affectRows);
            request.setAttribute("resultInfo",this.resultInfo);
        }
        else{
            DeleteFilm deleteFilm = new DeleteFilm(filmID);
            affectRows = deleteFilm.executeDelete();
            if(affectRows >0)
                this.resultInfo = "Delete Successfully!";
            else
                this.resultInfo = filmID + " " + filmName + " doesn't exists!";
            request.setAttribute("affectRows", affectRows);
            request.setAttribute("resultInfo",this.resultInfo);
            request.getRequestDispatcher("film/alterFilmIndex.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
