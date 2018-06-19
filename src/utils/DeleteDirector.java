package utils;

import database.DBOperator;

public class DeleteDirector {
    private String filmID;
    private String directorName;
    private String directorID;
    private int affectRows;

    private Boolean isTrue;
    private Boolean isExisted;

    DBOperator dbOperator;

    public DeleteDirector(String filmID,String directorName){
        this.filmID = filmID;
        this.directorName = directorName;
        this.dbOperator = new DBOperator("film","123456");

        this.isExisted = false;
        this.isTrue = false;
        preCheck();
        this.isTrue = this.isExisted;

    }

    public void executeDelete(){
        //执行删除
        String sql1 = "delete from Director where PersonID='" + this.directorID + "' and FilmID='"
                + this.filmID + "' ;";
        this.affectRows = this.dbOperator.update(sql1);
    }

    private void preCheck(){
        Boolean recordExisted = false;
        String sql = "select * from Person where PersonName='" + this.directorName + "';";
        this.isExisted = this.dbOperator.checkExisted(sql);
        if(this.isExisted){
            //导演Person已存在
            //先预查询导演的PersonID
            String sql0 = "select PersonID from Person where PersonName='" + this.directorName + "' ;";
            this.directorID = this.dbOperator.preQuery(sql0,"PersonID");
            //检查要删除的记录是否存在
            String sql1 = "select * from Director where PersonID='" + this.directorID + "' and FilmID='"
                    + this.filmID + "' ;";
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
