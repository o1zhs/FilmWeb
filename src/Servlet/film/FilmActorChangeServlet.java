package Servlet.film;

import utils.DeleteFilmActor;
import utils.InsertFilmActor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 电影演员增删服务Servlet
 *
 */
@WebServlet(name = "FilmActorChangeServlet")
public class FilmActorChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String filmID = request.getParameter("FilmID");
        String actorName = request.getParameter("Filmactor");
        String actorRole = request.getParameter("Filmrole");



        String resultInfo;
        int affectRows;
        if(id.equals("1")){         //1、添加演员
            InsertFilmActor insertFilmActor = new InsertFilmActor(filmID,actorName,actorRole);
            if(insertFilmActor.getTrue()){
                insertFilmActor.executeInsert();
                affectRows = insertFilmActor.getAffectRows();
                if(affectRows >0)
                    resultInfo = "Insert Successfully!";
                else
                    resultInfo = "Insert Failed!";
                request.setAttribute("affectRows", affectRows);
                request.setAttribute("resultInfo", resultInfo);
                request.getRequestDispatcher("/film/RightOutput.jsp").forward(request,response);
            }
            else{
                Boolean isExisted = null;
                if(!insertFilmActor.getExisted()){
                    isExisted = false;      //插入的演员Person尚不存在Person表中
                }
                else if(insertFilmActor.getSame()){
                    isExisted = true;       //Director表中已存在与即将插入的导演完全相同的记录
                }
                request.setAttribute("isExisted",isExisted);
                request.setAttribute("isTrue",insertFilmActor.getTrue());
                request.setAttribute("errorOperation","Insert");
                request.setAttribute("errorObject","Actor");
                request.getRequestDispatcher("/film/ErrorOutput.jsp").forward(request,response);
            }

        }
        else if(id.equals("2")){    //2、删除演员
            DeleteFilmActor deleteFilmActor = new DeleteFilmActor(filmID,actorName,actorRole);
            if(deleteFilmActor.getTrue()){
                deleteFilmActor.executeDelete();
                affectRows = deleteFilmActor.getAffectRows();
                if(affectRows >0)
                    resultInfo = "Delete Successfully!";
                else
                    resultInfo = "Delete Failed!";
                request.setAttribute("affectRows", affectRows);
                request.setAttribute("resultInfo", resultInfo);
                request.getRequestDispatcher("/film/RightOutput.jsp").forward(request,response);
            }
            else{
                Boolean isExisted = deleteFilmActor.getExisted();    //表中不存在要删除的记录
                request.setAttribute("isExisted",isExisted);
                request.setAttribute("isTrue",deleteFilmActor.getTrue());
                request.setAttribute("errorOperation","Delete");
                request.setAttribute("errorObject","Actor");
                request.getRequestDispatcher("/film/ErrorOutput.jsp").forward(request,response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
