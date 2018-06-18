package utils;

import database.DBOperator;

public class DeleteFilmCategory {
    private String filmID;
    private String category;
    private DBOperator dbOperator;

    private int affectRows;

    public DeleteFilmCategory(String filmID,String category){
        this.filmID = filmID;
        this.category = category;
        this.dbOperator = new DBOperator("root1","L90efcad1");
    }

    public int getAffectRows() {
        return affectRows;
    }

    public void executeDelete(){
        String sql = "delete from Category where FilmID='" + this.filmID + "' and DYLB_LB='"
                + this.category + "' ;";
        this.affectRows = this.dbOperator.update(sql);
    }

}
