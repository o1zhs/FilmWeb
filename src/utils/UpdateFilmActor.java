package utils;

import database.DBOperator;

public class UpdateFilmActor {

    private String filmID;
    private String actorName0;   //旧的演员PersonName
    private String actorName1;   //新的演员PersonName
    private String actorID0;     //旧的演员PersonID
    private String actorID1;     //新的演员PersonID

    private String role0;   //旧的角色
    private String role1;   //新的角色
    private int affectRows;
    private Boolean isTrue;
    private Boolean isExisted;
    private Boolean isSame;

    private DBOperator dbOperator;
    public UpdateFilmActor(String filmID,String actorName0,String actorName1,String role0
        ,String role1){
        this.filmID = filmID;
        this.actorName0 = actorName0;
        this.actorName1 = actorName1;
        this.role0 = role0;
        this.role1 = role1;
        this.dbOperator = new DBOperator("film","123456");

        this.isTrue = false;
        this.isExisted = false;
        this.isSame = true;

        this.preCheck0();
        if(this.isExisted){
            this.preCheck1();
            if(!this.isSame)
                this.isTrue = true;
        }
    }

    public void executeUpdate(){


        String sql = "update Actor set PersonID='" + actorID1 + "' and Role='" + this.role1
                + "' where FilmID='" + this.filmID + "' and PersonID='" + actorID0 + "' and" +
                " Role='" + this.role0 + "';";
        affectRows = dbOperator.update(sql);
    }

    private void preCheck0(){
        String sql0 = "select PersonID from Person where PersonName='" + this.actorName0 + "' ;";
        String sql1 = "select PersonID from Person where PersonName='" + this.actorName1 + "' ;";
        if(this.dbOperator.checkExisted(sql0)&&this.dbOperator.checkExisted(sql1)){
            //旧演员Person和新演员Person都存在的前提下，判断Director表是否存在旧导演
            this.actorID0 = this.dbOperator.preQuery(sql0,"PersonID");    //旧的演员PersonID
            this.actorID1 = this.dbOperator.preQuery(sql1,"PersonID");    //新的演员PersonID
            //检查要修改的演员记录是否存在
            String sql2 = "select * from Actor where PersonID='" + this.actorID0 + "' and FilmID='" + this.filmID + "' " +
                    " and Role='" + this.role0 +";";
            this.isExisted = this.dbOperator.checkExisted(sql2);
        }
    }

    private void preCheck1(){
        //查询是否已经有与修改后的记录完全相同的记录存在
        String sql ="select * from Actor where FilmID='" + this.filmID + "' and PersonID='" + this.actorID1 +
                "' and Role='" + this.role1 + "' ;";
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
