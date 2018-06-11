package utils;

import database.DBOperator;

public class IDGenerator {
    private int intID;
    private String realID;
    private String sql;
    private String tableName;

    public IDGenerator(String tableName){
        this.tableName = tableName;
        this.sql = "select max(IntID) from " + this.tableName + ";";
    }

    public void queryID(){
        String username = "root1";
        String password = "L90efcad1";
        DBOperator dbOperator = new DBOperator(username,password,"queryID");
        dbOperator.query(this.sql);
        this.intID = dbOperator.getQueryID()+1;
        this.realID = String.valueOf(this.intID);
    }

    public int getIntID() {
        return intID;
    }

    public String getRealID() {
        return realID;
    }
}
