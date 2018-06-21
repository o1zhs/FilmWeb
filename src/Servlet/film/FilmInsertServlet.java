package Servlet.film;

import Bean.Film;
import utils.IDGenerator;
import utils.InsertFilm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FilmInsertServlet")
public class FilmInsertServlet extends HttpServlet {
    private int affectRows;
    private String insertInfo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        IDGenerator idGenerator = new IDGenerator("Film");
        idGenerator.queryID();
        String filmID = idGenerator.getRealID();
        int IntID = idGenerator.getIntID();
        String filmName = request.getParameter("FilmName");
        String date = request.getParameter("date");
        String filmLength = request.getParameter("FilmLength");
        String firmName = request.getParameter("Firm");
        String filmPlot = request.getParameter("FilmPlot");
        

        Film film = new Film(filmID,filmName,date,firmName,filmLength,
                    null,null,null,null,filmPlot);
        InsertFilm insertFilm = new InsertFilm(film,IntID);
        if(insertFilm.getTrue()){
            this.affectRows = insertFilm.executeInsert();
            if(this.affectRows>0)
                this.insertInfo = "Insert successfully!";
            else
                this.insertInfo = "Insert failed;";
            request.setAttribute("affectRows",this.affectRows);
            request.setAttribute("insertInfo",this.insertInfo);
            request.getRequestDispatcher("/film/RightOutput.jsp").forward(request,response);
        }
        else {
            Boolean isTrue = insertFilm.getTrue();
            Boolean isExisted = insertFilm.getExisted();
            request.setAttribute("isTrue",isTrue);
            request.setAttribute("isExisted",isExisted);
            request.setAttribute("errorOperation","Insert");
            request.setAttribute("errorObject","Film");
            request.getRequestDispatcher("/film/ErrorOutput.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
