package utils;

import database.DBOperator;

public class UpdateFilmVoice {
    private String filmID;
    private String voiceName0;   //旧的旁白PersonName
    private String voiceName1;   //新的旁白PersonName
    private DBOperator dbOperator;

    private int affectRows;

    public UpdateFilmVoice(String filmID,String voiceName0,String voiceName1){
        this.filmID = filmID;
        this.voiceName0 = voiceName0;
        this.voiceName1 = voiceName1;
        this.dbOperator = new DBOperator("root1","L90efcad1");

    }

    public void executeUpdate(){
        String sql0 = "select PersonID from Person where PersonName='" + this.voiceName0 + "' ;";
        String sql1 = "select PersonID from Person where PersonName='" + this.voiceName1 + "' ;";

        String voiceID0 = this.dbOperator.preQuery(sql0,"PersonID");    //旧的旁白PersonID
        String voiceID1 = this.dbOperator.preQuery(sql1,"PersonID");    //新的旁白PersonID

        String sql = "update Voice set PersonID='" + voiceID1 + "' where FilmID='" + this.filmID
                + "' and PersonID='" + voiceID0 + "' ;" ;
        this.affectRows = this.dbOperator.update(sql);
    }

    public int getAffectRows() {
        return affectRows;
    }
}
