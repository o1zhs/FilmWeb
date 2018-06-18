package utils;

import database.DBOperator;

public class UpdateFilmCategory {

    private String filmID;
    private String category0;
    private String category1;
    private DBOperator dbOperator;

    private int affectRows;

    public UpdateFilmCategory(String filmID,String category0,String category1){
        this.filmID = filmID;
        this.category0 = category0;     //旧的电影类别
        this.category1 = category1;     //新的电影类别
        this.dbOperator = new DBOperator("root1","L90efcad1");
    }

    public void executeUpdate(){
        String sql = "update Category set DYLB_LB='" + this.category1 + "' where FilmID='" + this.filmID
                + "' and DYLB_LB='" + this.category0 + "';";
        this.affectRows = this.dbOperator.update(sql);
    }

    public int getAffectRows() {
        return affectRows;
    }
}
