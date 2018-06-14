package utils;

import database.DBOperator;

public class DeleteDirector {
    private String filmID;
    private String directorName;
    private String directorID;

    private int affectRows;

    DBOperator dbOperator;

    public DeleteDirector(String filmID,String directorName){
        this.filmID = filmID;
        this.directorName = directorName;
        this.dbOperator = new DBOperator("root1","L90efcad1");
    }

    public void executeDelete(){
        //预查询要删除导演的PersonID
        String sql0 = "select PersonID from Person where PersonName='" + this.directorName + "' ;";
        this.directorID = this.dbOperator.preQuery(sql0,"PersonID");

        //执行删除
        String sql1 = "delete from Director where PersonID='" + this.directorID + "' and FilmID='"
                + this.filmID + "' ;";
        this.affectRows = this.dbOperator.update(sql1);
    }

    public int getAffectRows() {
        return affectRows;
    }
}
