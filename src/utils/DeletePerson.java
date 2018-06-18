package utils;
import database.DBOperator;
public class DeletePerson {
    private String personID;
    private String personName;
    private String sql;

    public DeletePerson(String personID,String personName){
        this.personID = personID;
        this.personName = personName;
        this.sql = "delete from Person where PersonID='" + personID + "' ;";
    }

    public DeletePerson(String firmID){
        this.personID = personID;
        this.sql = "delete from Person where PersonID='" + personID + "' ;";
    }

    public int executeDelete(){
        int affectRows;
        String username = "root";
        String password = "123456";
        DBOperator dbOperator = new DBOperator(username,password);
        affectRows = dbOperator.update(this.sql);
        return affectRows;
    }
}
