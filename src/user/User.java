package user;

/**
 * 普通用户类
 *
 */
public class User {

    private String username;        //用户名
    private String password;        //口令


//    private String DBuser = "normaluser";       //普通用户的数据库用户名口令组(filmsystem数据库）
//    private String DBpassword = "123456";
    private String DBuser = "user1";       //普通用户的数据库用户名口令组(film数据库)
    private String DBpassword = "123456";

    public User(String username, String password ){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
