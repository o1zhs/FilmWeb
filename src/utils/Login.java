package utils;

import database.DBLogin;
import user.Manager;
import user.User;

import java.sql.SQLException;

/**
 * 登录类
 * username, password, isManager
 * 用户名，口令，管理员标志位
 */

public class Login {

    private String username;
    private String password;
    private boolean isManager = false;
    private DBLogin dbLogin;

    private String sql;
    private Manager manager;
    private User user;
    public Boolean isCorrect = false;       //验证正确标志位

    public String errorInfo;                //错误信息收集

    public Login(String username, String password, Boolean isManager){
        this.username = username;
        this.password = password;
        this.isManager = isManager;
        this.errorInfo = "";
        if(isManager)
            sql = "SELECT * FROM manager where username=" + this.username + " ;";    //如果是管理员则查管理员表
        else
            sql = "SELECT * FROM user where username="+ this.username + " ;";           //如果是普通用户则查普通用户表
        this.dbLogin = new DBLogin(username,password,isManager);
        this.check();
    }

    public void check(){
        try {
            this.dbLogin.query(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(!this.dbLogin.getNullFlag()){            //查询结果不为空
            if(isManager){                          //如果是管理员
                this.manager = this.dbLogin.getManager();
                if(username.equals(manager.getUsername())&&password.equals(manager.getPassword()))  //管理员用户名密码组判断正确
                    isCorrect = true;
                else{
                    //判断错误
                    isCorrect = false;
                    this.errorInfo = this.errorInfo + "Manager " + username + "'s password doesn't match!";
                }
            }
            else{                                   //如果是普通用户
                this.user = this.dbLogin.getUser();
                if(username.equals(user.getUsername())&&password.equals(user.getPassword()))            //普通用户 用户名密码组判断正确
                    isCorrect = true;
                else{
                    //判断错误
                    isCorrect = false;
                    this.errorInfo = this.errorInfo + "User " + username + "'s password doesn't match!";
                }

            }
        }
        else{                                       //查询结果为空
            this.isCorrect = false;
            if(isManager){

                this.errorInfo = this.errorInfo + "Manager " + username +" doesn't exist!";
            }
            else{
                this.errorInfo = this.errorInfo + "User "+ username +" doesn't exist!";
            }
        }
    }

    public boolean isManager() {
        return isManager;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Manager getManager(){
        return manager;
    }

    public User getUser() {
        return user;
    }
}
