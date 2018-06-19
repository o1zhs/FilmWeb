package utils;

import database.DBOperator;

public class DeleteVoice {
    private String filmID;
    private String voiceName;
    private String voiceID;
    private int affectRows;

    private Boolean isTrue;
    private Boolean isExisted;

    DBOperator dbOperator;

    public DeleteVoice(String filmID,String voiceName){
        this.filmID = filmID;
        this.voiceName = voiceName;
        this.dbOperator = new DBOperator("film","123456");

        this.isExisted = false;
        this.isTrue = false;
        preCheck();
        this.isTrue = this.isExisted;
    }

    public void executeDelete(){
        //执行删除
        String sql1 = "delete from Voice where PersonID='" + this.voiceID + "' and FilmID='"
                + this.filmID + "' ;";
        this.affectRows = this.dbOperator.update(sql1);
    }

    private void preCheck(){
        String sql0 = "select PersonID from Person where PersonName='" + this.voiceName + "' ;";
        this.isExisted = this.dbOperator.checkExisted(sql0);
        if(this.isExisted){
            //旁白Person已存在
            //预查询旁白的PersonID
            this.voiceID = this.dbOperator.preQuery(sql0,"PersonID");
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
