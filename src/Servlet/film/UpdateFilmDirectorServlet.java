package Servlet.film;

import utils.UpdateFilmDirector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateFilmDirectorServlet")
public class UpdateFilmDirectorServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int affectRows;
        String updateInfo;

        String filmID = request.getParameter("FilmID");
        String directorName0 = request.getParameter("Filmdirector_cpre");
        String directorName1 = request.getParameter("Filmdirector_clate");
        UpdateFilmDirector updateFilmDirector = new UpdateFilmDirector(filmID,directorName0,directorName1);
        if(updateFilmDirector.getTrue()){
            updateFilmDirector.executeUpdate();
            affectRows = updateFilmDirector.getAffectRows();
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
            if(!updateFilmDirector.getExisted()){   //插入的或者原对象不存在
                isExisted = false;
            }
            else if(updateFilmDirector.getSame()){  //Director表中已存在修改结果的记录，重复
                isExisted = true;
            }
            request.setAttribute("isExisted",isExisted);
            request.setAttribute("isTrue",updateFilmDirector.getTrue());
            request.setAttribute("errorOperation","Update");
            request.setAttribute("errorObject","Director");
            request.getRequestDispatcher("/film/ErrorOutput.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request,response);
    }
}
