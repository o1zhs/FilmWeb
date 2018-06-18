package Servlet.category;

import database.DBOperator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryDeleteServlet")
public class CategoryDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("kind_delete");

        String username = "film";
        String password = "123456";
        DBOperator dbOperator = new DBOperator(username,password);
        String sql = "delete from CategoryList where DYLB_LB='" + category + "' ;";
        int affectRows;
        String deleteInfo;

        affectRows = dbOperator.update(sql);
        if(affectRows>0)
            deleteInfo = "Insert Successfully!";
        else
            deleteInfo = "Insert Failed!";
        request.setAttribute("affectRows",affectRows);
        request.setAttribute("insertInfo",deleteInfo);
        request.getRequestDispatcher("/film/changeindex.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request,response);
    }
}
