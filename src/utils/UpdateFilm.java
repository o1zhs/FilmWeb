package utils;


import Bean.Film;
import database.DBOperator;

public class UpdateFilm {

    private Film film;
    private String sql;
    private String preSql;

    public UpdateFilm(Film film){
        this.film = film;
        this.sql = "update Film set FilmName='" + film.getFilmName() +"',FilmYear='" + film.getPublishYear() +
            "',FilmLength='" + film.getLength() + "',FilmPlot='" + film.getPlot() + "',FirmID='";
        this.preSql = "select FirmID from Firm where FirmName='" + film.getPublishFirm() + "' ;";
    }

    public int executeUpdate(){
        String username = "root1";
        String password = "L90efcad1";
        int affectRows;
        DBOperator dbOperator = new DBOperator(username,password);
        String firmID = dbOperator.preQuery(this.preSql,"FirmID");
        this.sql = this.sql + firmID + "' where FilmID='" + film.getFilmID() + "' ;";
        affectRows = dbOperator.update(this.sql);
        return affectRows;
    }
}
