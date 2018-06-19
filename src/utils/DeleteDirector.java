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
        if(this.isExisted){
            this.isTrue = true;
        }
        else{
            //表中不存在要删除的记录
            this.isTrue = false;
        }


    }

    public void executeDelete(){
        //执行删除
        String sql1 = "delete from Director where PersonID='" + this.directorID + "' and FilmID='"
                + this.filmID + "' ;";
        this.affectRows = this.dbOperator.update(sql1);
    }

    private void preCheck(){
        String sql = "select * from Person where PersonName='" + this.directorName + "';";
        this.isExisted = this.dbOperator.checkExisted(sql);
        if(this.isExisted){
            //导演Person已存在
            //先预查询导演的PersonID
            String sql0 = "select PersonID from Person where PersonName='" + this.directorName + "' ;";
            this.directorID = this.dbOperator.preQuery(sql0,"PersonID");
        }
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
