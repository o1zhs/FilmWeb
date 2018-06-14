package utils;

import database.DB;
import database.DBOperator;

public class InsertFilmCategory {
    private String filmID;
    private String category;
    private DBOperator dbOperator;

    private int affectRows;

    public InsertFilmCategory(String filmID,String category){
        this.filmID = filmID;
        this.category = category;
        this.dbOperator = new DBOperator("root1","L90efcad1");
    }

    public void executeInsert(){
        String sql = "insert into Category (DYLB_LB, FilmID) values ('" + this.category + "', '" +this.filmID + "');";
        this.affectRows = this.dbOperator.update(sql);
    }

    public int getAffectRows() {
        return affectRows;
    }
}
