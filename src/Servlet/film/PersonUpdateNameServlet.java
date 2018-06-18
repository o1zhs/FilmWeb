package Servlet.film;
import Bean.Person;
import utils.UpdatePerson_name;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "PersonUpdateNameServlet")
public class PersonUpdateNameServlet extends HttpServlet{
    private int affectRows;
    private String updateInfo;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String personID = request.getParameter("PersonID");
        String personName = request.getParameter("PersonName");
        Person person = new Person(personID,personName,null,null,null,null);
        UpdatePerson_name updatePerson = new UpdatePerson_name(person);
        this.affectRows = updatePerson.executeUpdate();
        if(affectRows>0)
            updateInfo = "Update successfully!";
        else
            updateInfo = "Update failed!";
        request.setAttribute("affectRows",affectRows);
        request.setAttribute("updateInfo",updateInfo);
        request.getRequestDispatcher("person/person_update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
