# FilmApp

## 1、项目分工说明：

​	陈炫宇——后台服务以及数据库（电影、类别、出品公司）；

​	张浩森——前端页面；

​	牟育霆——后台服务以及数据库（人物）；

​	廖贝尔——数据库结构设计、导入数据。

## 2、遇到的问题：

1）tomcat传输中文为乱码：在servlet中设置字符集编码格式即可转为中文，代码为

~~~java
request.setCharacterEncoding("utf-8");
~~~

2）关于实体表自动生成ID：在实体表中加入一列类型为int的、与varchar型ID等值的整数（假设该属性为ID数），每次插入新数据需要生成新的ID时，先查询该列找到最大整数，并基于该最大整数加1，获得新的ID数，实际ID即为ID数转为字符型，然后将它们同其他数据一并插入表中。

3）java.sql.SQLException: Operation not allowed after ResultSet closed——JDBC操作MySQL数据库：

​	一个stmt多个rs进行操作.那么从stmt得到的rs1,必须马上操作此rs1后,才能去得到另外的rs2,再对rs2操作.不能互相交替使用,会引起rs已经关闭错误——Operation not allowed after ResultSet closed.

​	一个stmt最好对应一个rs, 如果用一个时间内用一个stmt打开两个rs同时操作，会出现这种情况.编写这样的代码的操作原则是：
所以解决此类问题:

　　1.就多创建几个stmt,一个stmt对应一个rs;

　　2.若用一个stmt对应多个rs的话,那只能得到一个rs后就操作,处理完第一个rs后再处理其他的,如上"正确代码".# Refer_git
