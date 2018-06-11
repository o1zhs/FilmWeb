package user;

public class Manager {
    /**
     * 管理员用户类
     *
     */
    private String username;             //管理员姓名
    private String password;         //管理员口令

//    private String DBuser = "root1";          //管理员数据库用户名口令组(filmsystem数据库)
//    private String DBpassword = "L90efcad1";

    private String DBuser = "root1";            //管理员数据库用户名口令组(film数据库)
    private String DBpassword = "L90efcad1";

    public Manager(String managerName, String managerPW) {
        this.username = managerName;
        this.password = managerPW;
    }



    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDBuser() {
        return DBuser;
    }

    public String getDBpassword() {
        return DBpassword;
    }
}
