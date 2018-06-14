package utils;

import database.DBOperator;

public class UpdateFilmDirector {

    private String filmID;
    private String directorName0;   //旧的导演PersonName
    private String directorName1;   //新的导演PersonName
    private DBOperator dbOperator;

    private int affectRows;

    public UpdateFilmDirector(String filmID,String directorName0,String directorName1){
        this.filmID = filmID;
        this.directorName0 = directorName0;
        this.directorName1 = directorName1;
        this.dbOperator = new DBOperator("root1","L90efcad1");
    }

    public void executeUpdate(){
        String sql0 = "select PersonID from Person where PersonName='" + this.directorName0 + "' ;";
        String sql1 = "select PersonID from Person where PersonName='" + this.directorName1 + "' ;";

        String directorID0 = this.dbOperator.preQuery(sql0);    //旧的导演PersonID
        String directorID1 = this.dbOperator.preQuery(sql1);    //新的导演PersonID

        String sql = "update Director set PersonID='" + directorID1 + "' where FilmID='" + this.filmID
                + "' and PersonID='" + directorID0 + "' ;" ;
        this.affectRows = this.dbOperator.update(sql);
    }


    public int getAffectRows() {
        return affectRows;
    }
}
