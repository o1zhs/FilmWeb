package utils;

import database.DBOperator;

public class InsertFilmActor {
    private String filmID;
    private String actorName;
    private String actorID;
    private String role;

    private int affectRows;

    DBOperator dbOperator;

    public InsertFilmActor(String filmID,String actorName,String role){
        this.actorName = actorName;
        this.filmID = filmID;
        this.role = role;
        this.dbOperator = new DBOperator("root1","L90efcad1");
    }

    public void executeInsert(){
        //假设演员Person已存在
        //先预查询演员的PersonID
        String sql0 = "select PersonID from Person where PersonName='" + this.actorName + "' ;";
        this.actorID = this.dbOperator.preQuery(sql0,"PersonID");

        String sql1 = "insert into Actor (PersonID,FilmID,Role) values ('" + this.actorID + "', '"
                + this.filmID + "', '" + this.role + "');";
        this.affectRows = this.dbOperator.update(sql1);
    }
    public int getAffectRows() {
        return affectRows;
    }
}
