package Servlet.user;

import database.DBLogin;
import user.Manager;
import utils.Register;

import java.io.IOException;

public class RegisterServlet extends javax.servlet.http.HttpServlet {

    public String registerInfo = "";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //获取用户名密码
        String username = request.getParameter("user");
        String password = request.getParameter("password");

        //新建管理员用户(暂定)
        Register register = new Register(username,password,true);
        if(!register.getExistedFlag()){
            //注册成功
            register.executeRegister();
            registerInfo = "Register Successfully!";
        }
        else{
            //注册失败，返回错误信息
            registerInfo = register.errorInfo;
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
