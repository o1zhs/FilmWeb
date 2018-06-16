package Servlet.film;

import utils.DeleteDirector;
import utils.InsertDirector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 电影导演增删服务servlet
 */
@WebServlet(name = "FilmDiretorChangeServlet")
public class FilmDiretorChangeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String filmID = request.getParameter("FilmID");
        String directorName = request.getParameter("Filmdirector");

        String resultInfo;
        int affectRows;
        if(id.equals("1")){         //添加导演
            InsertDirector insertDirector = new InsertDirector(filmID,directorName);
            insertDirector.executeInsert();
            affectRows = insertDirector.getAffectRows();
            if(affectRows >0)
                resultInfo = "Insert Successfully!";
            else
                resultInfo = "Insert Failed!";
            request.setAttribute("affectRows", affectRows);
            request.setAttribute("resultInfo", resultInfo);
            request.getRequestDispatcher("/film/FilmOtherChangeQuery.jsp").forward(request,response);
        }
        else if(id.equals("2")){    //删除导演
            DeleteDirector deleteDirector = new DeleteDirector(filmID,directorName);
            deleteDirector.executeDelete();
            affectRows = deleteDirector.getAffectRows();
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
