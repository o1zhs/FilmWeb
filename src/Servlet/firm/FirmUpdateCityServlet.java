package Servlet.firm;

import Bean.Firm;
import utils.UpdateFirmCity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FirmUpdateCityServlet")
public class FirmUpdateCityServlet extends HttpServlet {
    private int affectRows;
    private String updateInfo;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String firmID = request.getParameter("firm_num_upn");
        String city = request.getParameter("firm_city_up");

        Firm firm = new Firm(firmID, null, city, null);
        UpdateFirmCity updateFirm = new UpdateFirmCity(firm);
        this.affectRows = updateFirm.executeUpdate();
        if (affectRows > 0)
            updateInfo = "Update successfully!";
        else
            updateInfo = "Update failed!";
        request.setAttribute("affectRows", affectRows);
        request.setAttribute("updateInfo", updateInfo);
        request.getRequestDispatcher("film/RightOutput.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
