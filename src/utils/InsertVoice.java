package utils;

import database.DBOperator;

public class InsertVoice {
    private String voiceName;
    private String filmID;
    private String voiceID;
    private int affectRows;

    private Boolean isTrue;
    private Boolean isExisted;
    private Boolean isSame;

    DBOperator dbOperator;


    public InsertVoice(String voiceName,String filmID){
        this.voiceName = voiceName;
        this.filmID = filmID;
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
    }

    public void executeInsert(){
        //假设旁白Person已存在


        //插入旁白关系表
        String sql1 = "Insert into Voice (PersonID,FilmID) values ('" + this.voiceID + "', '"
                + this.filmID + "');";
        this.affectRows = this.dbOperator.update(sql1);
    }

    private void preCheck0(){
        String sql0 = "select PersonID from Person where PersonName='" + this.voiceName + "' ;";
        this.isExisted = this.dbOperator.checkExisted(sql0);
        if(this.isExisted){
            //旁白Person已存在
            //预查询旁白的PersonID
            this.voiceID = this.dbOperator.preQuery(sql0,"PersonID");
        }
    }

    private void preCheck1(){
        //查询是否已经有完全相同的记录存在
        String sql = "select * from Voice where FilmID='" + this.filmID + "' and PersonID='" + this.voiceID
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
