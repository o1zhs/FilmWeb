package Servlet.film;


import Bean.Person;
import utils.IDGenerator;
import utils.InsertPerson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "personInsertServlet")
public class personInsertServlet extends HttpServlet{
    private int affectRows;
    private String insertInfo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        IDGenerator idGenerator = new IDGenerator("Person");
        idGenerator.queryID();
        String filmID = idGenerator.getRealID();
        int IntID = idGenerator.getIntID();
        String PersonName = request.getParameter("PersonName");
        String PersonBirth = request.getParameter("PersonBirth");


        Person person = new Person("",PersonName,PersonBirth,
                null,null,null);
        InsertPerson insertPerson = new InsertPerson(person);
        this.affectRows = insertPerson.executeInsert();
        if(this.affectRows>0)
            this.insertInfo = "Insert successfully!";
        else
            this.insertInfo = "Insert failed;";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

