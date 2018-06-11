package utils;

import Bean.Firm;
import database.DBOperator;

public class InsertFirm {
    private Firm firm;
    private String sql;

    public InsertFirm(Firm firm){
        this.firm = firm;
        this.sql = "insert into Firm (FirmID, FirmName, FirmCity) values ('" + this.firm.getFirmID() + "', '"
            + this.firm.getFirmName() + "', '" + this.firm.getCity() + "');";
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
