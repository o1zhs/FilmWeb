package utils;
import Bean.Person;
import database.DBOperator;
public class InsertPerson {
    private Person person;
    private String sql;
    private String preSql;
    private int IntID;

    public InsertPerson(Person person){
        this.person = person;
        this.sql = "insert into Person (PersonName, PersonBirth) values" +
                " ('" + this.person.getName() + "', '" + this.person.getBirth() + "', '";
    }

    public int executeInsert(){
        int affectRows;
        String username = "film";
        String password = "123456";
        DBOperator dbOperator = new DBOperator(username,password);
        affectRows = dbOperator.update(this.sql);
        return affectRows;
    }

    public void setSql(String firmID) {
        this.sql = "insert into Person (PersonName, PersonBirth) values" +
                " ('" + this.person.getName() + "', '" + this.person.getBirth() + "', '";
    }
}
