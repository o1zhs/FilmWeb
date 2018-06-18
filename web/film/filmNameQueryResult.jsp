<%@ page import="database.DBOperator" %>
<%@ page import="java.util.List" %>
<%@ page import="Servlet.film.FilmQueryServlet" %>
<%@ page import="Bean.Film" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.Person" %>
<%@ page import="Bean.Actor" %>
<%@ page import="com.sun.jdi.event.StepEvent" %>
<%--
  Created by IntelliJ IDEA.
  User: liu
  Date: 2018/5/30
  Time: 下午9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>电影信息管理系统</title>
    <script type="application/javascript" src="layui/layui.all.js"></script>
    <link href="layui/css/layui.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="afctf/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="afctf/css/reser.css" rel="stylesheet" type="text/css" media="all" />
    <link href="afctf/css/countdown.css" rel="stylesheet" type="text/css" media="all" />
    <link href="afctf/css/challenge.css" rel="stylesheet" type="text/css" media="all" />
    <script src="afctf/js/jquery-3.3.1.min.js"></script>
    <script src="afctf/js/layer/layer.js"></script>
    <script src="afctf/js/echarts.min.js"></script>
    <script src="afctf/js/utils.js"></script>
    <script src="afctf/js/challenge.js"></script>
    <script src="afctf/js/inputLimit.js"></script>
    <script type="text/javascript" src="value_js/jquery.min.2.0.js"></script>
    <style>
        .window{
            text-align: center;
            width: 500px;
            position: absolute;
            margin-left: -285px;
            margin-top: -125px;
            top: 45%;
            left: 53%;
            display: block;
            z-index: 2000;
            background: #fff;
            padding: 200;
        }
    </style>
</head>
<body>
<div class="bh">
    <div class="header">
        <div class="logo">
            <h1><a href=""><img src="img/logo.png" alt=""></a></h1>
        </div>
        <div class='cssmenu' style="margin-left: 0;flex: 0 0 70%;max-width: 50%;display: block;width: 100%">
            <div class="title">
                <br/>
                <h1>电&nbsp;&nbsp;影&nbsp;&nbsp;信&nbsp;&nbsp;息&nbsp;&nbsp;管&nbsp;&nbsp;理&nbsp;&nbsp;系&nbsp;&nbsp;统</h1>
            </div>
        </div>
        <div class='cssmenu' style="margin-left: 0;flex: 0 0 20%;max-width: 20%;display: block;width: 100%">
            <ul>
                <li id="username"><span style="margin-right:20px;max-width:120px;display:block;overflow:hidden;">用户昵称</span>
                </li>
                <li><span>/</span></li>
                <li id="logout"><a href="login.jsp" style="">退出登录</a></li>
            </ul>
        </div>
        <div class='cssmenu' style="margin-left: 0;flex: 0 0 4.5%;max-width: 10%;display: block;width: 100%">
            <ul>
                <li><a href="" style="border-bottom: 0px"><img src="/film/user.png" alt=""></a></li>
            </ul>
        </div>
    </div>
</div>
<%
    Object object = request.getAttribute("filmList");
    List<Film> filmList = new ArrayList<>();
    if(object instanceof List) {
        filmList = (List<Film>) object;
    }
    //按名称查询电影的信息
    for(Film film:filmList){
        String filmname = film.getFilmName();
        String filmyear = film.getPublishYear();
        String filmlength = film.getLength();
        String filmfirm = film.getPublishFirm();
        List<Person> filmactor = film.getActor();
        List<Person> filmdirector = film.getDirector();
        List<String> filmcategory = film.getCategoryList();
        String filmplot = film.getPlot();
        List<Person> filmvoice = film.getVoice();
%>
<div class="layui-container">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend style="margin-left: 500px;">电影查询结果</legend>
    </fieldset>
    <ul class="layui-timeline" style="margin-left: 120px;">
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">电影名称：<%=filmname%></div>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">出品日期：<%=filmyear%></div>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">电影时长：<%=filmlength%>分钟</div>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">出品公司：<%=filmfirm%></div>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">电影导演：</div>
                <%
                    for (Person film_director:filmdirector){
                        String Person_name = film_director.getName();
                %>
                <%=Person_name%>
                <p></p>
                <%
                    }
                %>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">电影演员：</div>
                <%
                    for (Person film_actor:filmactor){
                        String Person_name = film_actor.getName();  //演员姓名
                        Actor filma = film_actor.getActor();        //获取演员饰演的角色
                        List<String> filmal = filma.getRole();      //遍历演员饰演的角色
                        for (String filmall:filmal){                //获取演员饰演的角色的String

                %>
                <%=Person_name%> 饰演 <%=filmall%>
                <p></p>
                <%
                    }
                    }
                %>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">电影旁白：</div>
                <%
                    for (Person film_voice:filmvoice){
                        String Person_name = film_voice.getName();
                %>
                <%=Person_name%>
                <p></p>
                <%
                    }
                %>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">电影类别：</div>
                <%
                    for (String film_category:filmcategory){
                %>
                <%=film_category%>
                <p></p>
                <%
                    }
                %>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">电影简介：</div>
                <%=filmplot%>
            </div>
        </li>
    </ul>
    <%
        }
    %>
    <div style="text-align: center;">
        <button id="" class="layui-btn layui-btn-radius" onclick="window.location.href='/film/queryindex.jsp'">返回</button>
    </div>
</div>

<div class="maincontainer">
    <script src='afctf/js/TweenMax.min.js'></script>
    <script src="afctf/js/index.js"></script>
</div>
<div class="ftr1-bg">
    <div class="wrap">
        <div class="footer1">
            <p class="link">
            <span>
            开发人员：<a>张浩森 陈炫宇 牟育霆 廖贝尔</a>
            <br>
            平台开发：<a href="https://www.abigale.xin/">Abigale</a>
            </span>
            </p>
        </div>
    </div>
</div>
<script type="text/javascript" color="0,0,139" count="175" opacity="0.5" src="canvas-nest.min.js"></script>
<script type="text/javascript">
    /* 鼠标特效 */
    var a_idx = 0;
    // jQuery(document).ready(function($) {
    document.ready = function() {
        $("body").click(function(e) {
            var a = new Array("富强", "民主", "文明", "和谐", "自由", "平等", "公正" ,"法治", "爱国", "敬业", "诚信", "友善");
            var $i = $("<span/>").text(a[a_idx]);
            a_idx = (a_idx + 1) % a.length;
            var x = e.pageX,
                y = e.pageY;
            $i.css({
                "z-index": 999999999999999999999999999999999999999999999999999999999999999999999,
                "top": y - 20,
                "left": x,
                "position": "absolute",
                "font-weight": "bold",
                "font-size": "14px",
                "color": "#ff0000"
            });
            $("body").append($i);
            $i.animate({
                    "top": y - 180,
                    "opacity": 0
                },
                1500,
                function() {
                    $i.remove();
                });
        });
    };
</script>
</body>
</html>