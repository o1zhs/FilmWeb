package utils;

import database.DBOperator;

public class UpdateFilmActor {

    private String filmID;
    private String actorName0;   //旧的演员PersonName
    private String actorName1;   //新的演员PersonName

    private String role0;   //旧的角色
    private String role1;   //新的角色
    private int affectRows;

    private DBOperator dbOperator;
    public UpdateFilmActor(String filmID,String actorName0,String actorName1,String role0
        ,String role1){
        this.filmID = filmID;
        this.actorName0 = actorName0;
        this.actorName1 = actorName1;
        this.role0 = role0;
        this.role1 = role1;
        this.dbOperator = new DBOperator("film","123456");
    }

    public void executeUpdate(){
        String sql0 = "select PersonID from Person where PersonName='" + this.actorName0 + "' ;";
        String sql1 = "select PersonID from Person where PersonName='" + this.actorName1 + "' ;";

        String actorID0 = this.dbOperator.preQuery(sql0,"PersonID");    //旧的演员PersonID
        String actorID1 = this.dbOperator.preQuery(sql1,"PersonID");    //新的演员PersonID

        String sql = "update Actor set PersonID='" + actorID1 + "' and Role='" + this.role1
                + "' where FilmID='" + this.filmID + "' and PersonID='" + actorID0 + "' and" +
                " Role='" + this.role0 + "';";
        affectRows = dbOperator.update(sql);
    }


    public int getAffectRows() {
        return affectRows;
    }
}
