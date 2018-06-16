package Servlet.film;

import utils.DeleteVoice;
import utils.InsertVoice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FilmVoiceChangeServlet")

public class FilmVoiceChangeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int affectRows;
        String resultInfo;

        String id = request.getParameter("id");
        String filmID = request.getParameter("FilmID");
        String voiceName = request.getParameter("Filmvoice");

        if(id.equals("1")){         //添加旁白
            InsertVoice insertVoice = new InsertVoice(voiceName,filmID);
            insertVoice.executeInsert();
            affectRows = insertVoice.getAffectRows();
            if(affectRows>0)
                resultInfo = "Insert Successfully!";
            else
                resultInfo = "Insert Failed!";
            request.setAttribute("affectRows",affectRows);
            request.setAttribute("updateInfo",resultInfo);
            request.getRequestDispatcher("/film/FilmOtherChangeQuery.jsp").forward(request,response);
        }
        else if(id.equals("2")){    //删除旁白
            DeleteVoice deleteVoice = new DeleteVoice(filmID,voiceName);
            deleteVoice.executeDelete();
            affectRows = deleteVoice.getAffectRows();

            if(affectRows>0)
                resultInfo = "Delete Successfully!";
            else
                resultInfo = "Delete Failed!";
            request.setAttribute("affectRows",affectRows);
            request.setAttribute("updateInfo",resultInfo);
            request.getRequestDispatcher("/film/FilmOtherChangeQuery.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
