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
            if(insertVoice.getTrue()){
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
            else{
                Boolean isExisted = null;
                if(!insertVoice.getExisted()){
                    isExisted = false;      //插入的旁白Person尚不存在Person表中
                }
                else if(insertVoice.getSame()){
                    isExisted = true;       //Voice表中已存在与即将插入的旁白完全相同的记录
                }
                request.setAttribute("isExisted",isExisted);
                request.setAttribute("isTrue",insertVoice.getTrue());
                request.setAttribute("errorOperation","Insert");
                request.setAttribute("errorObject","Voice");
                request.getRequestDispatcher("/film/ErrorOutput.jsp").forward(request,response);
            }
        }
        else if(id.equals("2")){    //删除旁白
            DeleteVoice deleteVoice = new DeleteVoice(filmID,voiceName);
            if(deleteVoice.getTrue()){
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
            else{
                Boolean isExisted = deleteVoice.getExisted();    //表中不存在要删除的记录
                request.setAttribute("isExisted",isExisted);
                request.setAttribute("isTrue",deleteVoice.getTrue());
                request.setAttribute("errorOperation","Delete");
                request.setAttribute("errorObject","Voice");
                request.getRequestDispatcher("/film/ErrorOutput.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
