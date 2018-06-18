package database;

import user.Manager;
import user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBLogin {

    private String username;
    private String password;
    private Boolean isManager;

    private static String url="jdbc:mysql://localhost:3306/FilmSystemUser?useSSL=false&useUnicode=true&amp;characterEncoding=UTF-8";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String DBusername1 = "root";
    private static String DBpassword1 = "reku3in5";

    private String tableName;
    private Connection conn;
    private Statement statement;
    private ResultSet rs;
    private Boolean nullFlag;

    private Manager manager = null;
    private User user = null;

    public DBLogin(String username, String password,Boolean isManager){
        this.username = username;
        this.password = password;
        this.isManager = isManager;
        this.nullFlag = false;
    }

    public Connection getSqlConnection(){
        Connection sqlConnection = null;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            sqlConnection = DriverManager.getConnection(url,DBusername1,DBpassword1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sqlConnection;
    }

    /**
     * 获取Statement
     * @return
     * @throws SQLException
     */
    public Statement getStatement(){
        if(conn == null){
            conn = getSqlConnection();
        }
        if(statement == null){
            try {
                statement = conn.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return statement;
    }

    /**
     * 执行查询sql语句
     * @param sql
     * @return
     */
    public void query(String sql) throws SQLException {
        ResultSet resultSet = null;
        Statement statement = getStatement();
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //查询结果不为空，即该用户名存在
        if(resultSet.next()){
            if(isManager){
                String managerName = resultSet.getString("username");
                String managerPW = resultSet.getString("password");
                this.manager = new Manager(managerName,managerPW);
            }
            else{
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                this.user = new User(username,password);
            }
            nullFlag = false;
        }
        //查询结果为空
        else
            nullFlag = true;
    }

    public int update(String sql){
        int result = 0;
        Statement stat = getStatement();
        try {
            result = stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void close() {
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Manager getManager() {
        return manager;
    }

    public User getUser() {
        return user;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getNullFlag() {
        return nullFlag;
    }
}
