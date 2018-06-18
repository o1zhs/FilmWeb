package Servlet.film;

import database.DBOperator;

public class DeleteFilmActor {
    private String filmID;
    private String actorName;
    private String actorID;
    private String role;

    private int affectRows;

    DBOperator dbOperator;

    public DeleteFilmActor(String filmID,String actorName,String role){
        this.filmID = filmID;
        this.actorName = actorName;
        this.role = role;
        this.dbOperator = new DBOperator("root","reku3in5");
    }

    public void executeDelete(){
        //预查询要删除导演的PersonID
        String sql0 = "select PersonID from Person where PersonName='" + this.actorName + "' ;";
        this.actorID = this.dbOperator.preQuery(sql0,"PersonID");

        String sql1 = "delete from Actor where PersonID='" + this.actorID + "' and FilmID='"
                + this.filmID + "' and Role='" + this.role + "';";
        this.affectRows = this.dbOperator.update(sql1);
    }

    public int getAffectRows() {
        return affectRows;
    }
}
