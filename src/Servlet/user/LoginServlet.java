package Servlet.user;

import user.Manager;
import user.User;
import utils.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private Boolean isManager=false;
    public String loginInfo = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //创建新的登录对象
        Login login = new Login(username,password,true);
        if(login.isCorrect){
            this.loginInfo = "Login Successfully!";

        }
        else {
            this.loginInfo = login.errorInfo;
        }
        request.setAttribute("isCorrect",login.isCorrect);
        request.setAttribute("loginInfo",this.loginInfo);
        request.getRequestDispatcher("/login.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
