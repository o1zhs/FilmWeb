package utils;

import database.DBOperator;

public class InsertDirector {
    private String filmID;
    private String directorName;
    private String directorID;
    private int affectRows;

    private Boolean isTrue;
    private Boolean isExisted;
    private Boolean isSame;

    DBOperator dbOperator;

    public InsertDirector(String filmID,String directorName){
        this.filmID = filmID;
        this.directorName = directorName;
        this.dbOperator = new DBOperator("film","123456");

        this.isExisted = true;
        this.isSame = false;

        this.preCheck0();
        if(this.isExisted){
            this.preCheck1();
            if(this.isSame)
                this.isTrue = false;
        }
        else{
            this.isTrue = false;
        }
    }

    public void executeInsert(){
        //插入导演关系表
        String sql1 = "Insert into Director (PersonID,FilmID) values ('" + this.directorID + "', '"
                + this.filmID + "');";
        this.affectRows = this.dbOperator.update(sql1);
    }

    private void preCheck0(){
        String sql = "select PersonID from Person where PersonName='" + this.directorName + "' ;";
        this.isExisted = this.dbOperator.checkExisted(sql);
        if(this.isExisted){
            //导演Person已存在
            //先预查询导演的PersonID
            this.directorID = this.dbOperator.preQuery(sql,"PersonID");
        }
    }

    public void preCheck1(){
        //查询是否已经有完全相同的记录存在
        String sql = "select * from Director where FilmID='" + this.filmID + "' and PersonID='" + this.directorID
                + "';";
        this.isSame = this.dbOperator.checkExisted(sql);
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

    public Boolean getSame() {
        return isSame;
    }
}
