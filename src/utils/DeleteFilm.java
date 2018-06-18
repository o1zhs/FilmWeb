package utils;

import database.DBOperator;

public class DeleteFilm {

    private String filmID;
    private String filmName;

    private String sql;

    public DeleteFilm(String filmID){
        this.filmID = filmID;
        this.sql = "delete from Film where FilmID='" + filmID + "' ;";
    }

    public DeleteFilm(String filmID,String filmName){
        this.filmID = filmID;
        this.filmName = filmName;
        this.sql = "delete from Film where FilmID='" + filmID + "' ;";
    }

    public int executeDelete(){
        String username = "film";
        String password = "123456";
        DBOperator dbOperator = new DBOperator(username, password,"film");
        int affectRows = dbOperator.update(this.sql);
        return affectRows;
    }



}
