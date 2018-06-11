package Servlet.firm;

import Bean.Firm;
import utils.IDGenerator;
import utils.InsertFilm;
import utils.InsertFirm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FirmInsertServlet")
public class FirmInsertServlet extends HttpServlet {
    private int affectRows;
    private String insertInfo;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDGenerator idGenerator = new IDGenerator("Firm");

        String firmID = request.getParameter("FirmID");
        String firmName = request.getParameter("FirmName");
        String city = request.getParameter("city");
        if(!firmID.equals("")){
            Firm firm = new Firm(firmID,firmName,city,null);
            InsertFirm insertFirm = new InsertFirm(firm);
            this.affectRows = insertFirm.executeInsert();
            if(this.affectRows>0)
                this.insertInfo = "Insert successfully!";
            else
                this.insertInfo = "Insert failed!";

            request.setAttribute("affectRows",affectRows);
            request.setAttribute("insertInfo",insertInfo);
            request.getRequestDispatcher("film/firm_insert.jsp").forward(request,response);
        }
        else{

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
