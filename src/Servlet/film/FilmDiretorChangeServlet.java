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
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String filmID = request.getParameter("FilmID");
        String directorName = request.getParameter("Filmdirector");

        String resultInfo;
        int affectRows;
        if(id.equals("1")){         //添加导演
            InsertDirector insertDirector = new InsertDirector(filmID,directorName);
            if(insertDirector.getTrue()){
                insertDirector.executeInsert();
                affectRows = insertDirector.getAffectRows();
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
                if(!insertDirector.getExisted()){
                    isExisted = false;      //插入的导演Person尚不存在Person表中
                }
                else if(insertDirector.getSame()){
                    isExisted = true;       //Director表中已存在与即将插入的导演完全相同的记录
                }
                request.setAttribute("isExisted",isExisted);
                request.setAttribute("isTrue",insertDirector.getTrue());
                request.setAttribute("errorOperation","Insert");
                request.setAttribute("errorObject","Director");
                request.getRequestDispatcher("/film/ErrorOutput.jsp").forward(request,response);
            }

        }
        else if(id.equals("2")){    //删除导演
            DeleteDirector deleteDirector = new DeleteDirector(filmID,directorName);
            if(deleteDirector.getTrue()){
                deleteDirector.executeDelete();
                affectRows = deleteDirector.getAffectRows();
                if(affectRows >0)
                    resultInfo = "Delete Successfully!";
                else
                    resultInfo = "Delete Failed!";
                request.setAttribute("affectRows", affectRows);
                request.setAttribute("resultInfo", resultInfo);
                request.getRequestDispatcher("/film/RightOutput.jsp").forward(request,response);
            }
            else{
                Boolean isExisted = deleteDirector.getExisted();    //表中不存在要删除的记录
                request.setAttribute("isExisted",isExisted);
                request.setAttribute("isTrue",deleteDirector.getTrue());
                request.setAttribute("errorOperation","Delete");
                request.setAttribute("errorObject","Director");
                request.getRequestDispatcher("/film/ErrorOutput.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
