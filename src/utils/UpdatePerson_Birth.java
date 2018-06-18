package utils;

import Bean.Person;
import database.DBOperator;

public class UpdatePerson_Birth {
    private Person person;
    private String sql;

    public UpdatePerson_Birth(Person person){
        this.person = person;
        this.sql = "update Person set PersonBirth='" + this.person.getBirth() +
                " where PersonID='" + this.person.getPersonID() + "'; ";
    }

    public int executeUpdate(){
        int affectRows;
        String username = "root";
        String password = "123456";
        DBOperator dbOperator = new DBOperator(username,password);
        affectRows = dbOperator.update(this.sql);
        return affectRows;
    }
}
