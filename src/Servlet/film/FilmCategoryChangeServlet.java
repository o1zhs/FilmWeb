package Servlet.film;

import utils.DeleteFilmCategory;
import utils.InsertFilmCategory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FilmCategoryChangeServlet")
public class FilmCategoryChangeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int affectRows;
        String resultInfo;

        String id = request.getParameter("id");
        String filmCategory = request.getParameter("Filmkind");
        String filmID = request.getParameter("FilmID");

        if(id.equals("1")) {        //添加类别
            InsertFilmCategory insertFilmCategory = new InsertFilmCategory(filmID,filmCategory);
            insertFilmCategory.executeInsert();
            affectRows = insertFilmCategory.getAffectRows();
            if(affectRows>0)
                resultInfo = "Insert Successfully!";
            else
                resultInfo = "Insert Failed!";
            request.setAttribute("affectRows",affectRows);
            request.setAttribute("resultInfo",resultInfo);
            request.getRequestDispatcher("/film/RightOutput.jsp").forward(request,response);
        }
        else if(id.equals("2")){    //删除类别
            DeleteFilmCategory deleteFilmCategory = new DeleteFilmCategory(filmID,filmCategory);
            deleteFilmCategory.executeDelete();
            affectRows = deleteFilmCategory.getAffectRows();
            if(affectRows>0)
                resultInfo = "Delete Successfully!";
            else
                resultInfo = "Delete Failed!";
            request.setAttribute("affectRows",affectRows);
            request.setAttribute("resultInfo",resultInfo);
            request.getRequestDispatcher("/film/RightOutput.jsp").forward(request,response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
