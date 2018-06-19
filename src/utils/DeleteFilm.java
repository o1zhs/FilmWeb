package utils;

import database.DBOperator;

public class DeleteFilm {

    private String filmID;
    private String filmName;
    private String sql;

    private Boolean isTrue;
    private Boolean isExisted;
    private String errorInfo;

    private DBOperator dbOperator;

    public DeleteFilm(String filmID){
        this.filmID = filmID;
        this.sql = "delete from Film where FilmID='" + filmID + "' ;";

        String username = "film";
        String password = "123456";
        this.dbOperator = new DBOperator(username,password);

        this.preCheck();
        if(!this.isExisted){
            this.isTrue = false;
            this.errorInfo = "The film to be deleted doesn't exist!";
        }
    }

    public DeleteFilm(String filmID,String filmName){
        this.filmID = filmID;
        this.filmName = filmName;
        this.sql = "delete from Film where FilmID='" + filmID + "' ;";

        String username = "film";
        String password = "123456";
        this.dbOperator = new DBOperator(username,password);

        this.preCheck();
        if(!this.isExisted){
            this.isTrue = false;
            this.errorInfo = "The film to be deleted doesn't exist!";
        }
    }

    public int executeDelete(){
        int affectRows = this.dbOperator.update(this.sql);
        return affectRows;
    }

    private void preCheck(){
        String checkSql = "select * from Film where FilmID='" + this.filmID + "';";
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
