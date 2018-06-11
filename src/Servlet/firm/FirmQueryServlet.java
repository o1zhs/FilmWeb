package Servlet.firm;

import Bean.Firm;
import utils.QueryFirm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FirmQueryServlet")
public class FirmQueryServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String firmName = request.getParameter("FirmName");
        QueryFirm queryFirm = new QueryFirm(firmName);
        queryFirm.executeQuery();
        Firm firm = queryFirm.getFirm();
        request.setAttribute("Firm", firm);
        request.getRequestDispatcher("/film/firmQueryResult.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
