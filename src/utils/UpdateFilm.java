package utils;


import Bean.Film;
import database.DBOperator;

public class UpdateFilm {

    private Film film;
    private String sql;
    private String preSql;

    private Boolean isTrue;
    private Boolean isExisted;      //修改前的记录是否存在
    private Boolean isSame;         //修改后的记录是否已经存在
    private String firmID;

    private DBOperator dbOperator;

    public UpdateFilm(Film film){
        this.film = film;
        this.sql = "update Film set FilmName='" + film.getFilmName() +"',FilmYear='" + film.getPublishYear() +
            "',FilmLength='" + film.getLength() + "',FilmPlot='" + film.getPlot() + "',FirmID='";
        this.preSql = "select FirmID from Firm where FirmName='" + film.getPublishFirm() + "' ;";

        this.isTrue = false;
        this.isExisted = true;
        this.isSame = false;
        String username = "film";
        String password = "123456";
        this.dbOperator = new DBOperator(username,password);

        this.preCheck();
        if(!this.isSame&&this.isExisted){
            this.isTrue = true;
        }
    }

    public int executeUpdate(){
        int affectRows;
        this.sql = this.sql + this.firmID + "' where FilmID='" + film.getFilmID() + "' ;";
        affectRows = this.dbOperator.update(this.sql);
        return affectRows;
    }


    private void preCheck(){
        //预查询公司ID
        this.firmID = this.dbOperator.preQuery(this.preSql,"FirmID");
        String checkSql0 = "select * from Film where FilmID='" + this.film.getFilmID() + "';";
        this.isExisted = this.dbOperator.checkExisted(checkSql0);
        String checkSql1 = "select * from Film where FilmName='" + this.film.getFilmName() + "' and " +
                "FirmID='" + this.firmID + "' and FilmYear='" + film.getPublishYear() + "' and FilmLength='" +
                film.getLength() + "' and FilmPlot='" + this.film.getPlot() + "';";
        this.isSame = this.dbOperator.checkExisted(checkSql1);
    }

    public Boolean getTrue() {
        return isTrue;
    }

    public Boolean getExisted() {
        return isExisted;
    }

    public Boolean getSame() {
        return isSame;
    }
}
