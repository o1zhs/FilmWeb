package utils;

import Bean.Firm;
import database.DBOperator;

import java.util.ArrayList;
import java.util.List;

public class QueryFirm {

    private Firm firm;
    private String firmName;
    private String username = "root";
    private String password = "reku3in5";
    private String sql;

    private List<String> filmNameList = new ArrayList<>();

    public QueryFirm(String firmName){
        this.firmName = firmName;
        this.sql = "select * from Firm where FirmName='" + firmName + "' ;";
    }

    public void executeQuery(){
        DBOperator dbOperator = new DBOperator(this.username,this.password,"firm");
        dbOperator.query(this.sql);
        this.firm = dbOperator.getFirm();
    }


    public Firm getFirm() {
        return firm;
    }
}
