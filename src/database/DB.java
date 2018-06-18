package database;

import java.sql.*;

public class DB {
    private static String url = "jdbc:mysql://wulasite.me:3306/film?useSSL=false&useUnicode=true&characterEncoding=UTF-8&useServerPrepStmts=true";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String DBusername1 = "film";
    private static String DBpassword1 = "123456";
    private Connection conn;
    private Statement statement;


    public Connection getSqlConnection() {
        Connection sqlConnection = null;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            sqlConnection = DriverManager.getConnection(this.url, this.DBusername1, this.DBpassword1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sqlConnection;
    }

    /**
     * 获取Statement
     *
     * @return statement
     * @throws SQLException
     */
    public Statement getStatement() {
        if (conn == null) {
            conn = getSqlConnection();
        }
        if (statement == null) {
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
     *
     * @param sql
     * @return ResultSet
     */
    public ResultSet query(String sql) throws SQLException {
        ResultSet resultSet = null;
        Statement statement = getStatement();
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * 预编译sql语句
     *
     * @param sql
     * @return Result
     */
    public PreparedStatement getpreparedstatement(String sql) throws SQLException {

        PreparedStatement pstmt = null;
        if (conn == null) {
            conn = getSqlConnection();
        }
        if (pstmt == null) {
            try {
                pstmt = conn.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pstmt;
    }
}