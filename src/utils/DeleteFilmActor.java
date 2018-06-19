package utils;

import database.DBOperator;

public class DeleteFilmActor {
    private String filmID;
    private String actorName;
    private String actorID;
    private String role;

    private int affectRows;

    private Boolean isTrue;
    private Boolean isExisted;

    DBOperator dbOperator;

    public DeleteFilmActor(String filmID,String actorName,String role){
        this.filmID = filmID;
        this.actorName = actorName;
        this.role = role;
        this.dbOperator = new DBOperator("film","123456");

        this.isExisted = false;
        this.isTrue = false;

        preCheck();
        this.isTrue = this.isExisted;
    }

    public void executeDelete(){
        //预查询要删除演员的PersonID


        String sql1 = "delete from Actor where PersonID='" + this.actorID + "' and FilmID='"
                + this.filmID + "' and Role='" + this.role + "';";
        this.affectRows = this.dbOperator.update(sql1);
    }

    private void preCheck(){
        Boolean recordExisted = false;
        String sql0 = "select PersonID from Person where PersonName='" + this.actorName + "' ;";
        this.isExisted = this.dbOperator.checkExisted(sql0);
        if(this.isExisted){
            //演员Person已存在
            //先预查询演员的PersonID
            this.actorID = this.dbOperator.preQuery(sql0,"PersonID");
            //检查要删除的记录是否存在
            String sql1 = "select * from Actor where PersonID='" + this.actorID + "' and FilmID='"
                    + this.filmID + "' and Role='" + this.role + "';";
            recordExisted = this.dbOperator.checkExisted(sql1);
        }
        this.isExisted = recordExisted;
    }


    public int getAffectRows() {
        return affectRows;
    }

    public Boolean getTrue() {
        return isTrue;
    }

    public Boolean getExisted() {
        return isExisted;
    }
}
