# 后台API

## 1.Bean

### 1）public class Actor

​	该类封装某一演员在某一电影内的饰演情况，不针对所有电影和所有演员；

~~~java
参数列表：
	private String name;				//演员姓名
    private String actFilm;				//所演电影名称
    private List<String> role;			//该电影中的角色清单

方法列表：
返回类型			方法名及参数表
String		       getActFilm()				//返回当前电影名称
String			   getName()				//返回当前演员姓名
List<String>	   getRole()				//返回演员在该电影中的角色清单
~~~



### 2）public class Film

​	该类封装一部电影所涉及到的所有信息，包括编号、名称、发行年份、发行公司、电影时长、电影类别、导演表、演员表、旁白表、电影情节。

~~~java
参数列表：
	private String filmID;         								//电影编号
    private String filmName;        							//电影名称
    private String publishYear;     							//发行年份
    private String publishFirm;    								//发行公司
    private String firmID;          							//发行公司ID
    private String length;          							//电影时长
    private List<String> categoryList = new ArrayList<>();      //电影类别
    private List<Person> director;      						//导演
    private List<Person> actor;         						//演员
    private List<Person> voice;         						//旁白
    private String plot;            							//电影情节
    
方法列表：
返回类型			方法名及参数表
String			   getFilmID()				//返回当前电影ID
String			   getFilmName()			//返回当前电影名称
String			   getPublishYear()			//返回当前电影的出品年份
String			   getPublishFirm()			//返回当前电影的出品公司
String			   getLength()				//返回当前电影的时长
String			   getPlot()				//返回当前电影的情节简介
List<String>	   getCategoryList()		//返回当前电影的类别列表
List<Person>	   getDirector()			//返回当前电影的导演列表
List<Person>	   getActor()				//返回当前电影的演员列表
List<Person>	   getVoice()				//返回当前电影的旁边列表
~~~



### 3）public class Firm

​	该类封装一家电影出品公司的所有信息，包括公司ID，公司名称，公司所在城市和公司出品的电影列表。

~~~java
参数列表：
	private String firmID;										//出品公司ID
    private String firmName;									//出品公司名称
    private String city;										//出品公司所在城市
    private List<String> filmNamelist = new ArrayList<>();		//公司出品的电影名称列表
    
方法列表：
返回类型			方法名及参数表
String			   getFirmID()				//返回当前公司的ID
String			   getFirmName()			//返回当前公司的名称
String			   getCity()				//返回当前公司所在城市
List<String>	   getFilmNameList()		//返回公司出品的电影名称列表
~~~



### 4）public class Person

​	该类封装了一个人的所有信息，包括导演信息、演员信息、旁白信息和人的ID、姓名、生日。

~~~java
参数列表:
	private String personID;
    private String name;
    private String birth;

    private String[] director;
    private String[] voice;
    private List<Actor> actors; //用于查询一个演员演过的所有电影及角色
    private Actor actor;        //用于查询某一部电影内的演员所有角色

方法列表：
返回类型			方法名及参数表
String			   getPersonID()				//返回当前人物ID
String			   getName()					//返回当前人物姓名
String			   getBirth()					//返回当前人物生日
String[]		   getDirector()				//返回导演过的电影名称列表
String[]		   getVoice()					//返回旁白过的电影名称列表
List<Actor>		   getActors()					//返回演过的电影及角色列表
Actor			   getActor()					//返回某一部电影内的Actor对象
void			   setActors()					//设置演过的电影及角色列表
void 		   	   setActor()					//设置某一部电影内的Actor对象
~~~



## 2.Database

### 	1）public class DBOperator

​	该类封装了本项目用到的很多数据库操作，包括增、删、改、查等，但不构造SQL语句，只接受SQL语句并进行相应的操作。

~~~java
参数列表：
	private String user;					//登录数据库所用的用户名
    private String password;				//登录数据库所用的口令

    private Connection conn;				//数据库连接
    private Statement statement;			//执行SQL语句的Statement对象

    public String operateObject;			//在进行查询时用于判断查询结果种类的字符串
    //操作对象,film:查Film实体，person:查Person实体，firm:查Firm实体，actor:查Actor关系，
    // director:查Director关系，voice:查Voice关系，category:查类别关系
    //queryID:预查询当前ID最大值

    private List<Person> personList = new ArrayList<>();		//人物列表
    private List<Film> filmList = new ArrayList<>();			//电影列表
    private List<Firm> firmList = new ArrayList<>();			//公司列表
    private List<String> categoryList = new ArrayList<>();		//类别列表
    private Firm firm;											//单独查询某公司时使用的公司对象
    private int queryID;										//用于预查询各类ID
    
方法列表：
返回类型			方法名及参数表
Connection		   getSqlConnection()				//获取数据库连接
Statement		   getStatement()					//新建一个Statement并返回
void			   query(String sql)				//执行传入的查询SQL语句，并根据类的															operateObject参数获取结果赋值到类中的对应list
int				   update(String sql)				//执行传入的增、删、改SQL语句，返回改变行数
String			   preQuery(String sql,String object)
    												//表的预查询函数,在执行操作前预先获取ID对应的													 Name或Name对应的ID
void			   close()							//关闭SQL连接和Statement
List<Person>	   getResultPerson(ResultSet resultSet)
    												//获取查询人物结果函数
List<Person>	   getPersonList()					//获取当前人物list
List<Film>		   getFilmList()					//获取当前电影list
List<Firm>		   getFirmList()					//获取当前公司list
Firm			   getFirm()						//获取当前单独查询的公司
int				   getQueryID()						//获取当前预查询的ID
List<String>	   getCategoryList()				//获取当前类别list
~~~

