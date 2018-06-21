package utils;

import Bean.Firm;
import database.DBOperator;

public class UpdateFirmName {
    private Firm firm;
    private String sql;

    public UpdateFirmName(Firm firm){
        this.firm = firm;
        this.sql = "update Firm set FirmName='" + this.firm.getFirmName() + "' where FirmID='" + this.firm.getFirmID() + "'; ";
    }

    public int executeUpdate(){
        int affectRows;
        String username = "film";
        String password = "123456";
        DBOperator dbOperator = new DBOperator(username,password);
        affectRows = dbOperator.update(this.sql);
        return affectRows;
    }
}
