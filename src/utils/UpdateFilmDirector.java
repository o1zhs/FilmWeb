package utils;

import database.DBOperator;

public class UpdateFilmDirector {

    private String filmID;
    private String directorName0;   //旧的导演PersonName
    private String directorName1;   //新的导演PersonName
    private String directorID0;    //旧的导演PersonID
    private String directorID1;    //新的导演PersonID
    private DBOperator dbOperator;


    private int affectRows;
    private Boolean isTrue;
    private Boolean isExisted;
    private Boolean isSame;

    public UpdateFilmDirector(String filmID,String directorName0,String directorName1){
        this.filmID = filmID;
        this.directorName0 = directorName0;
        this.directorName1 = directorName1;
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
        //执行修改
        String sql = "update Director set PersonID='" + this.directorID1 + "' where FilmID='" + this.filmID
                + "' and PersonID='" + this.directorID0 + "' ;" ;
        this.affectRows = this.dbOperator.update(sql);
    }

    private void preCheck0(){
        String sql0 = "select PersonID from Person where PersonName='" + this.directorName0 + "' ;";
        String sql1 = "select PersonID from Person where PersonName='" + this.directorName1 + "' ;";
        if(this.dbOperator.checkExisted(sql0)&&this.dbOperator.checkExisted(sql1)){
            //旧导演Person和新导演Person都存在的前提下，判断Director表是否存在旧导演
            this.directorID0 = this.dbOperator.preQuery(sql0,"PersonID");    //旧的导演PersonID
            this.directorID1 = this.dbOperator.preQuery(sql1,"PersonID");    //新的导演PersonID
            //检查要修改的记录是否存在
            String sql2 = "select * from Director where PersonID='" + this.directorID0 + "' and FilmID='" + this.filmID + "' ;";
            this.isExisted = this.dbOperator.checkExisted(sql2);
        }
    }

    private void preCheck1(){
        //查询是否已经有完全相同的记录存在
        String sql = "select * from Director where FilmID='" + this.filmID + "' and PersonID='" + this.directorID1 + "' ;";
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
