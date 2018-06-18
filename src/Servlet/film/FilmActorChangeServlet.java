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
        String id = request.getParameter("id");
        String filmID = request.getParameter("FilmID");
        String actorName = request.getParameter("Filmactor");
        String actorRole = request.getParameter("FilmRole");



        String resultInfo;
        int affectRows;
        if(id.equals("1")){         //1、添加演员
            InsertFilmActor insertFilmActor = new InsertFilmActor(filmID,actorName,actorRole);
            insertFilmActor.executeInsert();
            affectRows = insertFilmActor.getAffectRows();
            if(affectRows >0)
                resultInfo = "Insert Successfully!";
            else
                resultInfo = "Insert Failed!";
            request.setAttribute("affectRows", affectRows);
            request.setAttribute("resultInfo", resultInfo);
            request.getRequestDispatcher("/film/FilmOtherChangeQuery.jsp").forward(request,response);
        }
        else if(id.equals("2")){    //2、删除演员
            DeleteFilmActor deleteFilmActor = new DeleteFilmActor(filmID,actorName,actorRole);
            deleteFilmActor.executeDelete();
            affectRows = deleteFilmActor.getAffectRows();
            if(affectRows >0)
                resultInfo = "Delete Successfully!";
            else
                resultInfo = "Delete Failed!";
            request.setAttribute("affectRows", affectRows);
            request.setAttribute("resultInfo", resultInfo);
            request.getRequestDispatcher("/film/FilmOtherChangeQuery.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
