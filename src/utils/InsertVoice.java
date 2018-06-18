package utils;

import database.DBOperator;

public class InsertVoice {
    private String voiceName;
    private String filmID;
    private String voiceID;

    private int affectRows;

    DBOperator dbOperator;


    public InsertVoice(String voiceName,String filmID){
        this.voiceName = voiceName;
        this.filmID = filmID;
        this.dbOperator = new DBOperator("film","123456");
    }

    public void executeInsert(){
        //假设旁白Person已存在
        //先预查询旁白的PersonID
        String sql0 = "select PersonID from Person where PersonName='" + this.voiceName + "' ;";
        this.voiceID = this.dbOperator.preQuery(sql0,"PersonID");

        //插入旁白关系表
        String sql1 = "Insert into Voice (PersonID,FilmID) values ('" + this.voiceID + "', '"
                + this.filmID + "');";
        this.affectRows = this.dbOperator.update(sql1);
    }

    public int getAffectRows() {
        return affectRows;
    }
}
