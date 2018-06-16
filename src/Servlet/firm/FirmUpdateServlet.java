package Servlet.firm;

import Bean.Firm;
import utils.UpdateFilm;
import utils.UpdateFirm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FirmUpdateServlet")
public class FirmUpdateServlet extends HttpServlet {
    private int affectRows;
    private String updateInfo;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firmID = request.getParameter("firm_num_upn");
        String firmName = request.getParameter("firm_name_up");
        String city = request.getParameter("city");
        Firm firm = new Firm(firmID,firmName,city,null);
        UpdateFirm updateFirm = new UpdateFirm(firm);
        this.affectRows = updateFirm.executeUpdate();
        if(affectRows>0)
            updateInfo = "Update successfully!";
        else
            updateInfo = "Update failed!";
        request.setAttribute("affectRows",affectRows);
        request.setAttribute("updateInfo",updateInfo);
        request.getRequestDispatcher("film/firm_update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
