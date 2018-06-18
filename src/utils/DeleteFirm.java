package utils;

import database.DBOperator;

public class DeleteFirm {

    private String firmID;
    private String firmName;
    private String sql;

    public DeleteFirm(String firmID){
        this.firmID = firmID;
        this.sql = "delete from Firm where FirmID='" + firmID + "' ;";
    }

    public DeleteFirm(String firmID,String firmName){
        this.firmID = firmID;
        this.firmName = firmName;
        this.sql = "delete from Firm where FirmID='" + firmID + "' ;";
    }

    public int executeDelete(){
        int affectRows;
        String username = "film";
        String password = "123456";
        DBOperator dbOperator = new DBOperator(username,password);
        affectRows = dbOperator.update(this.sql);
        return affectRows;
    }
}
