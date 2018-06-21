package Servlet.film;

import Bean.Film;
import com.sun.org.apache.xpath.internal.operations.Bool;
import utils.QueryFilm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FilmQueryServlet")
public class FilmQueryServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String filmName = request.getParameter("FilmName");
        String filmCategory = request.getParameter("kind");
        String ID = request.getParameter("abc");
        System.out.println("查询电影了！************************************");

        if(filmName != null && ID == null) {
            System.out.println("按照名称查询电影");
            QueryFilm queryFilm = new QueryFilm(filmName, true);
            queryFilm.executeQuery();
            List<Film> filmList = queryFilm.getFilmList();
            request.setAttribute("filmList", filmList);
            for(Film film:filmList){
                System.out.println("名称：" + film.getFilmName());
                System.out.println("时长：" + film.getLength()+" min");
                System.out.println("发行年份：" + film.getPublishYear());
                System.out.println("情节：" + film.getPlot());
            }
            System.out.println("输出结束");
            request.getRequestDispatcher("/film/filmNameQueryResult.jsp").forward(request,response);
        }
        else if(filmCategory != null) {
            System.out.println("按照类别查询电影");
            QueryFilm queryFilm = new QueryFilm(filmCategory,false);
            queryFilm.executeQuery();
            List<Film> filmList = queryFilm.getFilmList();
            request.setAttribute("filmList", filmList);
            request.getRequestDispatcher("/film/filmCategoryQueryResult.jsp").forward(request,response);
        }
        else if(ID != null && filmName != null){
            switch (ID) {
                case "1": {
                    QueryFilm queryFilm = new QueryFilm(filmName, true);
                    queryFilm.executeQuery();
                    List<Film> filmList = queryFilm.getFilmList();
                    request.setAttribute("filmList", filmList);
                    request.getRequestDispatcher("/film/FilmDirectorChange.jsp").forward(request, response);
                    break;
                }
                case "2": {
                    QueryFilm queryFilm = new QueryFilm(filmName, true);
                    queryFilm.executeQuery();
                    List<Film> filmList = queryFilm.getFilmList();
                    request.setAttribute("filmList", filmList);
                    request.getRequestDispatcher("/film/FilmActorChange.jsp").forward(request, response);
                    break;
                }
                case "3": {
                    QueryFilm queryFilm = new QueryFilm(filmName, true);
                    queryFilm.executeQuery();
                    List<Film> filmList = queryFilm.getFilmList();
                    request.setAttribute("filmList", filmList);
                    request.getRequestDispatcher("/film/FilmVoiceChange.jsp").forward(request, response);
                    break;
                }
                case "4": {
                    QueryFilm queryFilm = new QueryFilm(filmName, true);
                    queryFilm.executeQuery();
                    List<Film> filmList = queryFilm.getFilmList();
                    request.setAttribute("filmList", filmList);
                    request.getRequestDispatcher("/film/FilmKindChange.jsp").forward(request, response);
                    break;
                }
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
