package utils;

import Bean.Film;
import database.DBOperator;

public class InsertFilm {
    private Film film;
    private String sql;
    private String preSql;
    private int IntID;

    public InsertFilm(Film film,int IntID){
        this.film = film;
        this.IntID = IntID;
        this.sql = "insert into Film (FilmID, FirmID, FilmName, FilmYear, FilmLength, FilmPlot, IntID) values" +
                " ('" + this.film.getFilmID() + "', '" + this.film.getFilmName() + "', '";
        this.preSql = "select FirmID from Firm where FirmName='" + this.film.getPublishFirm() + "' ;";
    }

    public int executeInsert(){
        int affectRows;
        String username = "film";
        String password = "123456";
        DBOperator dbOperator = new DBOperator(username,password);
        String firmID = dbOperator.preQuery(this.preSql,"FirmID");
        this.setSql(firmID);
        affectRows = dbOperator.update(this.sql);
        return affectRows;
    }

    public void setSql(String firmID) {
        this.sql = "insert into Film (FilmID, FirmID, FilmName, FilmYear, FilmLength, FilmPlot, IntID) values" +
                " ('" + this.film.getFilmID() + "', '" + firmID + "', '" + this.film.getFilmName() + "', '" +
                this.film.getPublishYear() + "', '" + this.film.getLength() + "', '" + this.film.getPlot() +  "', '"
                + String.valueOf(this.IntID) + "');";
    }
}
