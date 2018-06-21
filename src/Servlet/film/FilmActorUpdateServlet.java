package Servlet.film;

import utils.UpdateFilmActor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FilmActorUpdateServlet")
public class FilmActorUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String updateInfo;
        int affectRows;

        String filmID = request.getParameter("FilmID");
        String actorName0 = request.getParameter("Filmactor0");
        String actorName1 = request.getParameter("Filmactor1");
        String actorRole0 = request.getParameter("Filmrole0");
        String actorRole1 = request.getParameter("Filmrole1");

        UpdateFilmActor updateFilmActor = new UpdateFilmActor(filmID,actorName0,actorName1,actorRole0,actorRole1);
        if(updateFilmActor.getTrue()){
            updateFilmActor.executeUpdate();
            affectRows = updateFilmActor.getAffectRows();
            if(affectRows>0)
                updateInfo = "Update Successfully!";
            else
                updateInfo = "Update Failed!";
            request.setAttribute("affectRows",affectRows);
            request.setAttribute("updateInfo",updateInfo);
            request.getRequestDispatcher("/film/RightOutput.jsp").forward(request,response);
        }
        else{
            Boolean isExisted = null;
            if(!updateFilmActor.getExisted()){   //插入的或者原对象不存在
                isExisted = false;
            }
            else if(updateFilmActor.getSame()){  //Director表中已存在修改结果的记录,重复
                isExisted = true;
            }
            request.setAttribute("isExisted",isExisted);
            request.setAttribute("isTrue",updateFilmActor.getTrue());
            request.setAttribute("errorOperation","Update");
            request.setAttribute("errorObject","Actor");
            request.getRequestDispatcher("/film/ErrorOutput.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request,response);
    }
}
