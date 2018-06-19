package utils;

import database.DBOperator;

public class UpdateFilmVoice {
    private String filmID;
    private String voiceName0;   //旧的旁白PersonName
    private String voiceName1;   //新的旁白PersonName
    private String voiceID0;    //旧的旁白PersonID
    private String voiceID1;    //新的旁白PersonID
    private DBOperator dbOperator;

    private int affectRows;
    private Boolean isTrue;
    private Boolean isExisted;
    private Boolean isSame;

    public UpdateFilmVoice(String filmID,String voiceName0,String voiceName1){
        this.filmID = filmID;
        this.voiceName0 = voiceName0;
        this.voiceName1 = voiceName1;
        this.dbOperator = new DBOperator("root1","L90efcad1");

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

        String sql = "update Voice set PersonID='" + this.voiceID1 + "' where FilmID='" + this.filmID
                + "' and PersonID='" + this.voiceID0 + "' ;" ;
        this.affectRows = this.dbOperator.update(sql);
    }

    private void preCheck0(){
        String sql0 = "select PersonID from Person where PersonName='" + this.voiceName0 + "' ;";
        String sql1 = "select PersonID from Person where PersonName='" + this.voiceName1 + "' ;";

        if(this.dbOperator.checkExisted(sql0)&&this.dbOperator.checkExisted(sql1)){
            //旧导演Person和新导演Person都存在的前提下，判断Director表是否存在旧导演
            this.voiceID0 = this.dbOperator.preQuery(sql0,"PersonID");    //旧的旁白PersonID
            this.voiceID1 = this.dbOperator.preQuery(sql1,"PersonID");    //新的旁白PersonID

            String sql2 = "select * from Voice where PersonID='" + this.voiceID0 + "' ;";
            this.isExisted = this.dbOperator.checkExisted(sql2);
        }
    }

    private void preCheck1(){
        //查询是否已经有完全相同的记录存在
        String sql = "select * from Voice where FilmID='" + this.filmID + "' and PersonID='" + this.voiceID1 + "' ;";
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
