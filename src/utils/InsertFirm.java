package utils;

import Bean.Firm;
import database.DBOperator;

public class InsertFirm {
    private Firm firm;
    private String sql;
    private int IntID;

    public InsertFirm(Firm firm,int IntID){
        this.firm = firm;
        this.IntID = IntID;
        this.sql = "insert into Firm (FirmID, FirmName, FirmCity, IntID) values ('" + this.firm.getFirmID() + "', '"
            + this.firm.getFirmName() + "', '" + this.firm.getCity() + "', '" + this.IntID +  "');";
    }

    public int executeInsert(){
        String username = "root1";
        String password = "L90efcad1";
        int affectRows;
        DBOperator dbOperator = new DBOperator(username,password);
        affectRows = dbOperator.update(this.sql);
        return affectRows;
    }


}
