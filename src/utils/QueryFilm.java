package utils;

import Bean.Film;
import Bean.Firm;
import database.DBOperator;

import java.util.ArrayList;
import java.util.List;

public class QueryFilm {

    private Boolean isName;
    private String sql="select Film.*,Firm.FirmName from Film,Firm ";

    private List<Film> filmList = new ArrayList<>();

    //电影名称查询构造函数
    public QueryFilm(String filmString,Boolean isName){
        this.isName = isName;

        //连接查询，直接查出电影基本信息和出品公司名字
        if(isName)
            this.sql = this.sql + " where FilmName='" + filmString + "' and Film.FirmID=Firm.FirmID ;";
        else    //连接查询，直接查出指定类别的电影基本信息和出品公司名字
            this.sql = "select Film.*,Firm.FirmName from Film,Category,Firm " +
                    "where Film.FirmID=Firm.FirmID and Film.FilmID=Category.FilmID and Category.DYLB_LB='" + filmString + "' ;" ;

        //System.out.println(this.sql);
    }

    public void executeQuery(){
        String username = "root1";
        String password = "L90efcad1";
        DBOperator dbOperator = new DBOperator(username, password,"film");
        dbOperator.query(this.sql);
        System.out.println(this.sql);
        this.filmList = dbOperator.getFilmList();
    }


    public List<Film> getFilmList() {
        for(Film film:this.filmList){
            System.out.println("名称：" + film.getFilmName());
            System.out.println("时长：" + film.getLength()+" min");
            System.out.println("发行年份：" + film.getPublishYear());
            System.out.println("情节：" + film.getPlot());
        }
        return this.filmList;
    }

    public Boolean getName() {
        return isName;
    }
}
