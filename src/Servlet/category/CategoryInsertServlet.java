package Servlet.category;

import database.DBOperator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryInsertServlet")
public class CategoryInsertServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("kind");
        String username = "film";
        String password = "123456";
        DBOperator dbOperator = new DBOperator(username,password);
        String sql = "insert into CategoryList (DYLB_LB) values ('" + category + "');";
        int affectRows;
        String insertInfo;
        affectRows = dbOperator.update(sql);
        if(affectRows>0)
            insertInfo = "Insert Successfully!";
        else
            insertInfo = "Insert Failed!";
        request.setAttribute("affectRows",affectRows);
        request.setAttribute("insertInfo",insertInfo);
        request.getRequestDispatcher("/film/changeindex.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
