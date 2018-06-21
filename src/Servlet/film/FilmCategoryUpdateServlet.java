package Servlet.film;

import utils.UpdateFilmCategory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FilmCategoryUpdateServlet")
public class FilmCategoryUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int affectRows;
        String updateInfo;

        String filmID = request.getParameter("FilmID");
        String category0 = request.getParameter("Filmkind_cpre");
        String category1 = request.getParameter("Filmkind_clate");

        UpdateFilmCategory updateFilmCategory = new UpdateFilmCategory(filmID,category0,category1);
        updateFilmCategory.executeUpdate();
        affectRows = updateFilmCategory.getAffectRows();
        if(affectRows>0)
            updateInfo = "Update Successfully!";
        else
            updateInfo = "Update Failed!";
        request.setAttribute("affectRows",affectRows);
        request.setAttribute("updateInfo",updateInfo);
        request.getRequestDispatcher("/film/RightOutput.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
