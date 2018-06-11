package Servlet.firm;

import utils.DeleteFirm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FirmDeleteServlet")
public class FirmDeleteServlet extends HttpServlet {

    private int affectRows;
    private String deleteInfo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firmID = request.getParameter("FirmID");
        String firmName = request.getParameter("FirmName");
        if(!firmName.equals("")){
            DeleteFirm deleteFirm = new DeleteFirm(firmID,firmName);
            this.affectRows = deleteFirm.executeDelete();
            if(this.affectRows>0)
                this.deleteInfo = "Delete successfully!";
            else
                this.deleteInfo = "Delete failed";
            request.setAttribute("affectRows",affectRows);
            request.setAttribute("deleteInfo",deleteInfo);
            request.getRequestDispatcher("film/firm_delete.jsp").forward(request,response);
        }
        else {
            DeleteFirm deleteFirm = new DeleteFirm(firmID);
            this.affectRows = deleteFirm.executeDelete();
            if(this.affectRows>0)
                this.deleteInfo = "Delete successfully!";
            else
                this.deleteInfo = "Delete failed";
            request.setAttribute("affectRows",affectRows);
            request.setAttribute("deleteInfo",deleteInfo);
            request.getRequestDispatcher("film/firm_delete.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
