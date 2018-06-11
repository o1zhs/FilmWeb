package utils;


import Bean.Film;
import Bean.Firm;
import Bean.Person;

/**
 * Query 查询类
 * 1）处理查询的request参数
 * 2）生成对应的SQL语句
 */
public class Query {

    private String tableName;
    private String username;
    private String password;

    private String sql;             //查询对应的sql语句

    private Film film;
    private Firm firm;
    private Person person;

    //全查询
    public Query(String tableName, String username, String password, Firm firm, Film film, Person person){

    }

    //电影查询对应的构造函数
    public Query(String tableName, String username, String password, String filmName){
        this.tableName = tableName;
        this.username = username;
        this.password = password;
        this.sql = "select * from Film where FilmName=" + filmName + " ;";
    }

    //发行公司对应的构造函数
    public Query(String tableName, String username, String password, Firm firm){
        this.tableName = tableName;
        this.username = username;
        this.password = password;
        this.firm = firm;
    }

    //人物查询对应的构造函数
    public Query(String tableName, String username, String password, Person person){
        this.tableName = tableName;
        this.username = username;
        this.password = password;
        this.person = person;
    }

    /**
     * 查询电影名 SQL语句生成函数
     * @param filmName
     * @return querySQL
     */
    public String queryFilmName(String filmName){
        //查询电影的基本信息
        String querySQL = "select * from Film ";
        if(filmName != null){
            querySQL = querySQL + "where FileName=" + filmName + " ;";
        }
        else{
            querySQL = querySQL + ";";
        }
        return querySQL;
    }

    /**
     * 查询电影的演员 SQL语句生成函数
     * @param filmID
     * @return  querySQL
     */
    public String queryFilmActor(String filmID){
        //查询对应电影的演员
        String querySQL = "select * from Actor ";
        if(filmID != null){
            querySQL = querySQL + "where FilmID=" + filmID + " ;";
        }
        else{
            querySQL = querySQL + ";";
        }
        return querySQL;
    }




    public String getSql() {
        return sql;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
