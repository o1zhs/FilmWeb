package utils;

import database.DBOperator;

public class DeleteVoice {
    private String filmID;
    private String voiceName;
    private String voiceID;

    private int affectRows;

    DBOperator dbOperator;

    public DeleteVoice(String filmID,String voiceName){
        this.filmID = filmID;
        this.voiceName = voiceName;
        this.dbOperator = new DBOperator("root1","L90efcad1");
    }

    public void executeDelete(){
        //预查询要删除旁白的PersonID
        String sql0 = "select PersonID from Person where PersonName='" + this.voiceName + "' ;";
        this.voiceID = this.dbOperator.preQuery(sql0,"PersonID");

        //执行删除
        String sql1 = "delete from Voice where PersonID='" + this.voiceID + "' and FilmID='"
                + this.filmID + "' ;";
        this.affectRows = this.dbOperator.update(sql1);
    }

    public int getAffectRows() {
        return affectRows;
    }
}
