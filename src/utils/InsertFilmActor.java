package utils;

import database.DBOperator;

public class InsertFilmActor {
    private String filmID;
    private String actorName;
    private String actorID;
    private String role;
    private int affectRows;

    private Boolean isTrue;
    private Boolean isExisted;
    private Boolean isSame;

    DBOperator dbOperator;

    public InsertFilmActor(String filmID,String actorName,String role){
        this.actorName = actorName;
        this.filmID = filmID;
        this.role = role;
        this.dbOperator = new DBOperator("film","123456");

        this.isTrue = false;
        this.isExisted = true;
        this.isSame = false;

        this.preCheck0();
        if(this.isExisted){
            this.preCheck1();
            if(!this.isSame)
                this.isTrue = true;
        }
        else{
            this.isTrue = false;
        }
    }

    public void executeInsert(){
        //执行插入
        String sql1 = "insert into Actor (PersonID,FilmID,Role) values ('" + this.actorID + "', '"
                + this.filmID + "', '" + this.role + "');";
        this.affectRows = this.dbOperator.update(sql1);
    }

    private void preCheck0(){
        String sql0 = "select PersonID from Person where PersonName='" + this.actorName + "' ;";
        this.isExisted = this.dbOperator.checkExisted(sql0);
        if(this.isExisted){
            //演员Person已存在
            //先预查询演员的PersonID
            this.actorID = this.dbOperator.preQuery(sql0,"PersonID");
        }
    }

    private void preCheck1(){
        //查询是否已经有完全相同的记录存在
        String sql = "select * from Actor where FilmID='" + this.filmID + "' and PersonID='" + this.actorID
                + "' and Role='" + this.role + "';";
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
