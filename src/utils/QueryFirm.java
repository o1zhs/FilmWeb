package utils;

import Bean.Firm;
import database.DBOperator;

import java.util.ArrayList;
import java.util.List;

public class QueryFirm {

    private Firm firm;
    private String firmName;
    private String username = "";
    private String password = "reku3in5";
    private String sql;

    private List<String> filmNameList = new ArrayList<>();

    public QueryFirm(String firmName){
        this.firmName = firmName;
        this.sql = "select * from Firm where FirmName='" + firmName + "' ;";
        System.out.println(this.sql);
    }

    public void executeQuery(){
        DBOperator dbOperator = new DBOperator(this.username,this.password,"firm");
        dbOperator.query(this.sql);
        this.firm = dbOperator.getFirm();
        System.out.println("公司ID：" + this.firm.getFirmID());
        System.out.println("公司名称：" + this.firm.getFirmName());
        System.out.println("公司所在地：" + this.firm.getCity());
        System.out.println("公司出品电影：");
        for(String filmName1:this.firm.getFilmNamelist()){
            System.out.println(filmName1);
        }
    }


    public Firm getFirm() {
        return firm;
    }
}
