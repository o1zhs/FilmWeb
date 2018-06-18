package Servlet.category;

import database.DBOperator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryUpdateServlet")
public class CategoryUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category0 = request.getParameter("kindc_pre");
        String category1 = request.getParameter("kindc_late");
        String username = "film";
        String password = "123456";
        DBOperator dbOperator = new DBOperator(username,password);
        String sql = "update CategoryList set DYLB_LB='" + category1 + "' where DYLB_LB='" + category0 + "';";
        int affectRows;
        String updateInfo;

        affectRows = dbOperator.update(sql);
        if(affectRows>0)
            updateInfo = "Insert Successfully!";
        else
            updateInfo = "Insert Failed!";
        request.setAttribute("affectRows",affectRows);
        request.setAttribute("insertInfo",updateInfo);
        request.getRequestDispatcher("/film/changeindex.html").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request,response);
    }
}
