package utils;

import Bean.Film;
import database.DBOperator;

public class InsertFilm {
    private Film film;
    private String sql;
    private String preSql;
    private int IntID;

    private Boolean isTrue;
    private Boolean isExisted;
    private String errorInfo;

    private DBOperator dbOperator;



    public InsertFilm(Film film,int IntID){
        this.film = film;
        this.IntID = IntID;
        this.sql = "insert into Film (FilmID, FirmID, FilmName, FilmYear, FilmLength, FilmPlot, IntID) values" +
                " ('" + this.film.getFilmID() + "', '" + this.film.getFilmName() + "', '";
        this.preSql = "select FirmID from Firm where FirmName='" + this.film.getPublishFirm() + "' ;";
        this.isTrue = true;
        this.isExisted = false;
        this.errorInfo = null;

        String username = "film";
        String password = "123456";
        this.dbOperator = new DBOperator(username,password);

        this.preCheck();
        if(this.isExisted){
            this.isTrue = false;
            this.errorInfo = "This film is already existed!";
        }
    }

    /**
     * 执行插入电影
     * @return affectRows
     */
    public int executeInsert(){
        int affectRows;
        String firmID = this.dbOperator.preQuery(this.preSql,"FirmID");
        this.setSql(firmID);
        affectRows = this.dbOperator.update(this.sql);
        return affectRows;
    }

    /**
     * 构造SQL语句
     * @param firmID
     */
    public void setSql(String firmID) {
        this.sql = "insert into Film (FilmID, FirmID, FilmName, FilmYear, FilmLength, FilmPlot, IntID) values" +
                " ('" + this.film.getFilmID() + "', '" + firmID + "', '" + this.film.getFilmName() + "', '" +
                this.film.getPublishYear() + "', '" + this.film.getLength() + "', '" + this.film.getPlot() +  "', '"
                + String.valueOf(this.IntID) + "');";
    }


    private void preCheck(){
        String filmName = film.getFilmName();
        String checkSql = "select * from Film where FilmName='" + filmName + "';";
        this.isExisted = this.dbOperator.checkExisted(checkSql);
    }

    public Boolean getTrue() {
        return isTrue;
    }

    public Boolean getExisted() {
        return isExisted;
    }

    public String getErrorInfo() {
        return errorInfo;
    }
}
