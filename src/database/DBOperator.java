package database;


import Bean.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * 数据库操作类
 */
public class DBOperator {
    private String user;
    private String password;

    private Connection conn;
    private Statement statement;

    public String operateObject;
    //操作对象,film:查Film实体，person:查Person实体，firm:查Firm实体，actor:查Actor关系，
    // director:查Director关系，voice:查Voice关系，category:查类别关系
    //queryID:预查询当前ID最大值

    private List<Person> personList = new ArrayList<>();
    private List<Film> filmList = new ArrayList<>();
    private List<Firm> firmList = new ArrayList<>();
    private List<String> categoryList = new ArrayList<>();
    private List<ActorQuery> actorQueryList = new ArrayList<>();
    private Firm firm;
    private int queryID;

    /**
     * 查询所用构造函数
     * @param user
     * @param password
     * @param operateObject
     */
    public DBOperator(String user, String password,String operateObject){
        this.user = "film";
        this.password = "123456";
        this.operateObject = operateObject;
    }

    /**
     * 普通构造函数
     * @param user
     * @param password
     */
    public DBOperator(String user,String password){
        this.user = "film";
        this.password = "123456";
    }

    public Connection getSqlConnection(){
        Connection sqlConnection = null;
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String url = "jdbc:mysql://120.25.249.73:3306/film??useSSL=false&useUnicode=true&characterEncoding=UTF-8&useServerPrepStmts=true";
            sqlConnection = DriverManager.getConnection(url,this.user,this.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sqlConnection;
    }

    /**
     * 获取Statement
     * @return statement
     * @throws SQLException
     */
    public Statement getStatement(){
        Statement statement = null;
        if(conn == null){
            conn = getSqlConnection();
        }
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    /**
     * 执行查询sql语句
     * @param sql
     */
    public void query(String sql){
        System.out.println(sql);
        ResultSet resultSet = null;
        if(this.statement == null)
            this.statement = getStatement();

        Statement stmt = getStatement();        //新建独立的stmt，方便在一次获取查询结果内再进行其他查询
        try {
            resultSet = this.statement.executeQuery(sql);
            //查询电影，返回结果为电影基本信息和出品公司名称，然后再查对应的类别、演员、导演、旁白
            if(resultSet == null){
                System.out.println("执行查询结果集为空");
            }
            switch (this.operateObject) {
                case "film":
                    while (resultSet.next()) {
                        String filmID = resultSet.getString("FilmID");
                        String firmName = resultSet.getString("FirmName");
                        String filmName = resultSet.getString("FilmName");
                        String filmYear = resultSet.getString("FilmYear");
                        String filmLength = resultSet.getString("FilmLength");
                        String filmPlot = resultSet.getString("FilmPlot");

                        System.out.println("名称：" + filmName);
                        System.out.println("时长：" + filmLength + " min");
                        System.out.println("发行年份：" + filmYear);
                        System.out.println("情节：" + filmPlot);

                        String sql1 = "select DYLB_LB from Category where FilmID='" + filmID + "' ;";
                        String sql2 = "select Person.* from Film,Actor,Person " +
                                "where Film.FilmID='" + filmID + "' and Film.FilmID=Actor.FilmID and Actor.PersonID=Person.PersonID " +
                                "group by Person.PersonID;";
                        String sql3 = "select Person.* from Film,Director,Person " +
                                "where Film.FilmID='" + filmID + "' and Film.FilmID=Director.FilmID and Director.PersonID=Person.PersonID ;";
                        String sql4 = "select Person.* from Film,Voice,Person " +
                                "where Film.FilmID='" + filmID + "' and Film.FilmID=Voice.FilmID and Voice.PersonID=Person.PersonID ;";

                        System.out.println(sql1);
                        System.out.println(sql2);
                        System.out.println(sql3);
                        System.out.println(sql4);

                        List<String> categoryList = new ArrayList<>();
                        ResultSet resultSet1 = stmt.executeQuery(sql1);
                        while (resultSet1.next()) {
                            String category = resultSet1.getString("DYLB_LB");
                            categoryList.add(category);
                        }
                        List<Person> actorList;
                        ResultSet resultSet2 = stmt.executeQuery(sql2);
                        actorList = getResultPerson(resultSet2);

                        List<Person> directorList;
                        ResultSet resultSet3 = stmt.executeQuery(sql3);
                        directorList = getResultPerson(resultSet3);

                        List<Person> voiceList;
                        ResultSet resultSet4 = stmt.executeQuery(sql4);
                        voiceList = getResultPerson(resultSet4);

                        ResultSet resultSet5;
                        for (Person person : actorList) {
                            String sql5 = "select Role from Actor where PersonID='" + person.getPersonID()
                                    + "' and FilmID='" + filmID + "' ;";
                            resultSet5 = stmt.executeQuery(sql5);
                            List<String> role = new ArrayList<>();
                            while (resultSet5.next()) {
                                role.add(resultSet5.getString("Role"));
                            }
                            Actor actor = new Actor(person.getName(), filmName, role);
                            person.setActor(actor);
                        }
                        Film film = new Film(filmID, filmName, filmYear, firmName, filmLength,
                                categoryList, directorList, actorList, voiceList, filmPlot);
                        this.filmList.add(film);
                    }
                    break;
                //类别列表查询
                case "categoryList":
                    while (resultSet.next()) {
                        String category = resultSet.getString("DYLB_LB");
                        this.categoryList.add(category);
                    }
                    break;
                //ID预查询
                case "queryID":
                    resultSet.next();
                    this.queryID = resultSet.getInt("max(IntID)");
                    break;
                //粗略查询电影信息
                case "filmIndex":
                    while (resultSet.next()) {
                        String filmID = resultSet.getString("FilmID");
                        String firmName = resultSet.getString("FirmName");
                        String filmName = resultSet.getString("FilmName");
                        String filmYear = resultSet.getString("FilmYear");
                        String filmLength = resultSet.getString("FilmLength");
                        String filmPlot = resultSet.getString("FilmPlot");

                        Film film = new Film(filmID, filmName, filmYear, firmName, filmLength, null, null,
                                null, null, filmPlot);
                        this.filmList.add(film);
                    }
                    break;
                //查询人列表
                case "Person":
                    while (resultSet.next()) {
                        String PersonID = resultSet.getString("PersonID");
                        String PersonName = resultSet.getString("PersonName");
                        String PersonBirth = resultSet.getString("PersonBirth");
                        Person person = new Person(PersonID, PersonName, PersonBirth, null, null, null);
                        this.personList.add(person);
                    }
                    break;
                //查询出品公司
                case "firm":
                    while (resultSet.next()) {
                        String firmID = resultSet.getString("FirmID");
                        String firmName = resultSet.getString("FirmName");
                        String firmCity = resultSet.getString("FirmCity");

                        List<String> filmNameList = new ArrayList<>();
                        String sql1 = "select FilmName from Film where FirmID='" + firmID + "' ;";
                        ResultSet resultSet1 = stmt.executeQuery(sql1);
                        while (resultSet1.next()) {
                            String filmName = resultSet1.getString("FilmName");
                            filmNameList.add(filmName);
                        }
                        this.firm = new Firm(firmID, firmName, firmCity, filmNameList);
                    }
                    break;
                //粗略查询所有公司
                case "firmIndex":
                    while (resultSet.next()) {
                        String firmID = resultSet.getString("FirmID");
                        String firmName = resultSet.getString("FirmName");
                        String firmCity = resultSet.getString("FirmCity");
                        Firm firm = new Firm(firmID, firmName, firmCity, null);
                        this.firmList.add(firm);
                    }
                case "Actor":
                    while(resultSet.next()){
                        String personName = resultSet.getString("PersonName");
                        String birth = resultSet.getString("PersonBirth");
                        String film = resultSet.getString("FilmName");
                        String role = resultSet.getString("Role");

                        ActorQuery actorQuery = new ActorQuery(role,film,personName,birth);
                        this.actorQueryList.add(actorQuery);
                    }
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(stmt != null){       //单独关闭stmt
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.close();
    }
    /**
     * 执行更新sql语句
     * @param sql
     * @return
     */
    public int update(String sql) {
        System.out.println(sql);
        int result = 0;
        try {
            this.statement = getStatement();
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
        return result;
    }

    /**
     * 表的预查询函数
     * 在执行操作前预先获取ID对应的Name或Name对应的ID
     * @param sql
     * @return preString
     */
    public String preQuery(String sql,String object){
        System.out.println(sql);
        if(this.statement == null)
            this.statement = getStatement();
        String preString = null;
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                preString = resultSet.getString(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preString;
    }

    /**
     * 预查询函数，在插入和修改前检查是否有重复记录
     * 同时用于，在修改和删除前检查修改和删除的对象是否不存在
     * @param sql
     * @return isExisted
     */
    public Boolean checkExisted(String sql){
        Boolean isExisted = false;
        Statement stmt = this.getStatement();
        try {
            ResultSet resultSet = stmt.executeQuery(sql);
            if(resultSet.next()){
                isExisted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExisted;
    }

//    /**
//     *
//     * @param sql
//     * @return isExisted
//     */
//    public Boolean checkNotExisted(String sql){
//        Boolean isExisted = false;
//        Statement stmt = this.getStatement();
//        try {
//            ResultSet resultSet = stmt.executeQuery(sql);
//            if(resultSet.next()){
//                isExisted = true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            stmt.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return isExisted;
//    }


    /**
     * 关闭SQL连接和Statement
     */
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

    /**
     *
     * @param resultSet
     * @return personList
     * @throws SQLException
     */
    //获取查询人物结果函数
    private List<Person> getResultPerson(ResultSet resultSet) throws SQLException {
        List<Person> personList = new ArrayList<>();
        while(resultSet.next()){
            String personName = resultSet.getString("PersonName");
            String personID = resultSet.getString("PersonID");
            String personBirth = resultSet.getString("PersonBirth");
            Person person = new Person(personID,personName,personBirth,null,null,null);
            personList.add(person);
        }
        return personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public List<Firm> getFirmList() {
        return firmList;
    }

    public Firm getFirm() {
        return firm;
    }

    public int getQueryID() {
        return queryID;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public List<ActorQuery> getActorQueryList() {
        return actorQueryList;
    }
}
