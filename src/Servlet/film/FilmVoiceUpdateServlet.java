package Servlet.film;

import utils.UpdateFilmVoice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FilmVoiceUpdateServlet")
public class FilmVoiceUpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int affectRows;
        String updateInfo;

        String filmID = request.getParameter("FilmID");
        String voiceName0 = request.getParameter("Filmvoice_cpre");
        String voiceName1 = request.getParameter("Filmvoice_clate");

        UpdateFilmVoice updateFilmVoice = new UpdateFilmVoice(filmID,voiceName0,voiceName1);
        updateFilmVoice.executeUpdate();
        affectRows = updateFilmVoice.getAffectRows();
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
