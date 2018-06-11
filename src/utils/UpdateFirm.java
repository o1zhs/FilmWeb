package utils;

import Bean.Firm;
import database.DBOperator;

public class UpdateFirm {
    private Firm firm;
    private String sql;

    public UpdateFirm(Firm firm){
        this.firm = firm;
        this.sql = "update Firm set FirmName='" + this.firm.getFirmName() + "', city='" + this.firm.getCity() + "'" +
                " where FirmID='" + this.firm.getFirmID() + "'; ";
    }

    public int executeUpdate(){
        int affectRows;
        String username = "root1";
        String password = "L90efcad1";
        DBOperator dbOperator = new DBOperator(username,password);
        affectRows = dbOperator.update(this.sql);
        return affectRows;
    }
}
