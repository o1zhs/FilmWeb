package utils;

import database.DBOperator;

public class InsertDirector {
    private String filmID;
    private String directorName;
    private String directorID;

    private int affectRows;

    DBOperator dbOperator;

    public InsertDirector(String filmID,String directorName){
        this.filmID = filmID;
        this.directorName = directorName;
        this.dbOperator = new DBOperator("root1","L90efcad1");
    }

    public void executeInsert(){
        //假设导演Person已存在
        //先预查询导演的PersonID
        String sql0 = "select PersonID from Person where PersonName='" + this.directorName + "' ;";
        this.directorID = this.dbOperator.preQuery(sql0);

        //插入导演关系表
        String sql1 = "Insert into Director (PersonID,FilmID) values ('" + this.directorID + "', '"
                + this.filmID + "');";
        this.affectRows = this.dbOperator.update(sql1);
    }

    public int getAffectRows() {
        return affectRows;
    }
}
