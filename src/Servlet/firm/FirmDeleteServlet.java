package Servlet.firm;

import utils.DeleteFirm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FirmDeleteServlet")
public class FirmDeleteServlet extends HttpServlet {

    private int affectRows;
    private String deleteInfo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String firmID = request.getParameter("FirmID");
        String firmName = request.getParameter("FirmName");

        Boolean isTrue = true;        //是否正确
        Boolean isExisted;        //是否重复，1为重复，0为对象不存在
        String errorObject;    //出错对象，如Film,Person
        String errorOperation;            //操作类型，判断不成功的是插入、修改、删除的哪一个
        // JDBC 驱动名及数据库 URL
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://120.25.249.73:3306/film??useSSL=false&useUnicode=true&characterEncoding=UTF-8&useServerPrepStmts=true";

        // 数据库的用户名与密码，需要根据自己的设置
        String USER = "film";
        String PASS = "123456";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 打开一个连接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql1;
            sql1 = "select FirmID from Firm";
            ResultSet rs1 = stmt.executeQuery(sql1);
            //创建取结果的列表，之所以使用列表，不用数组，因为现在还不知道结果有多少，不能确定数组长度，所有先用list接收，然后转为数组
            List<String> list1 = new ArrayList<String>();
            while (rs1.next()) {//如果有数据，取第一列添加如list
                list1.add(rs1.getString(1));
            }
            String[] arr1 = new String[list1.size()];//创建一个和list长度一样的数组
            if (list1 != null && list1.size() > 0) {//如果list中存入了数据，转化为数组

                for (int i = 0; i < list1.size(); i++) {
                    arr1[i] = list1.get(i);//数组赋值了。
                }
            }
            int mark1 = 0;
            for (int i = 0; i < list1.size(); i++) {
                if (firmID.equals(arr1[i]))
                    break;
                else
                    mark1++;
            }
            if (mark1 == list1.size()) {
                isTrue = false;        //是否正确
                isExisted = false;        //是否重复，1为重复，0为对象不存在
                errorObject = "Firm";    //出错对象，如Film,Person
                errorOperation = "Delete";
                request.setAttribute("isExisted", isExisted);
                request.setAttribute("errorObject", errorObject);
                request.setAttribute("errorOperation", errorOperation);
            }
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
        request.setAttribute("isTrue", isTrue);
        if (isTrue) {
            if(!firmName.equals("")){
                DeleteFirm deleteFirm = new DeleteFirm(firmID,firmName);
                this.affectRows = deleteFirm.executeDelete();
                if(this.affectRows>0)
                    this.deleteInfo = "Delete successfully!";
                else
                    this.deleteInfo = "Delete failed";
                request.setAttribute("affectRows",affectRows);
                request.setAttribute("deleteInfo",deleteInfo);
                request.getRequestDispatcher("film/RightOutput.jsp").forward(request,response);
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
                request.getRequestDispatcher("film/RightOutput.jsp").forward(request,response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
