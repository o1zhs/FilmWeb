package Servlet.film;
import utils.DeleteFirm;
import utils.DeletePerson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PersonDeleteServlet")
public class PersonDeleteServlet extends HttpServlet {
    private int affectRows;
    private String deleteInfo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String personID = request.getParameter("PersonID");
        String personName = request.getParameter("PersonName");
        if(!personName.equals("")){
            DeletePerson deletePerson = new DeletePerson(personID,personName);
            this.affectRows = deletePerson.executeDelete();
            if(this.affectRows>0)
                this.deleteInfo = "Delete successfully!";
            else
                this.deleteInfo = "Delete failed";
            request.setAttribute("affectRows",affectRows);
            request.setAttribute("deleteInfo",deleteInfo);
            request.getRequestDispatcher("person/person_delete.jsp").forward(request,response);
        }
        else {
            DeletePerson deletePerson = new DeletePerson(personID);
            this.affectRows = deletePerson.executeDelete();
            if(this.affectRows>0)
                this.deleteInfo = "Delete successfully!";
            else
                this.deleteInfo = "Delete failed";
            request.setAttribute("affectRows",affectRows);
            request.setAttribute("deleteInfo",deleteInfo);
            request.getRequestDispatcher("person/person_delete.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
