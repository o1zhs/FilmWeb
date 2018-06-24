<%@ page import="com.sun.org.apache.xpath.internal.operations.Bool" %><%--
  Created by IntelliJ IDEA.
  User: liu
  Date: 2018/5/30
  Time: 下午9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html>
<head>
    <title>用户-查询页面</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/sliding_effect.js"></script>
    <script type="application/javascript" src="../layui/layui.all.js"></script>
    <link href="../layui/css/layui.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="../afctf/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="../afctf/css/reser.css" rel="stylesheet" type="text/css" media="all" />
    <link href="../afctf/css/countdown.css" rel="stylesheet" type="text/css" media="all" />
    <link href="../afctf/css/challenge.css" rel="stylesheet" type="text/css" media="all" />
    <script src="../afctf/js/jquery-3.3.1.min.js"></script>
    <script src="../afctf/js/layer.js"></script>
    <script src="../afctf/js/echarts.min.js"></script>
    <script src="../afctf/js/utils.js"></script>
    <script src="../afctf/js/challenge.js"></script>
    <script src="../afctf/js/inputLimit.js"></script>
    <script type="text/javascript" src="js/clickradio.js"></script>
    <script type="text/javascript" src="../value_js/jquery.min.2.0.js"></script>
</head>
<body>
<div class="bh">
    <div class="header">
        <div class="logo">
            <h1><a href=""><img src="../img/logo.png" alt=""></a></h1>
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
                <li id="logout"><a href="../login.jsp" style="">退出登录</a></li>
            </ul>
        </div>
        <div class='cssmenu' style="margin-left: 0;flex: 0 0 4.5%;max-width: 10%;display: block;width: 100%">
            <ul>
                <li><a href="" style="border-bottom: 0px"><img src="user.png" alt=""></a></li>
            </ul>
        </div>
    </div>
</div>
<%
    Boolean isExisted = (Boolean) request.getAttribute("isExisted");
    String errorObject = (String) request.getAttribute("errorObject");
    String errorOperation = (String) request.getAttribute("errorOperation");

    String errorInfo;
    if(isExisted){
        errorInfo = errorOperation + errorObject + "在表内有重复！";
        %>
<h1><%=errorInfo%></h1>
        <%
    }
    else{
        errorInfo = errorOperation + errorObject + "人物不存在！";
        %>
<h1><%=errorInfo%></h1>
<%
    }
%>
<%
    String label = request.getParameter("label");
    String mark = request.getParameter("mark");
    String FilmName = request.getParameter("FilmName");
    String ID = request.getParameter("FilmID");
    if(label != null){
%>
<div>
    <div style="text-align: center;">
        <form action="/FilmQuery" method="post">
            <input type="hidden" name="FilmName">
            <input type="hidden" name="abc">
            <input type="hidden" name="FilmID">
            <button type="submit" class="layui-btn layui-btn-radius" onclick="this.form.FilmName.value='<%=FilmName%>';this.form.abc.value='<%=label%>';this.form.FilmID.value='<%=ID%>'">返回</button>
        </form>
    </div>
</div>
<%
}
else if(mark != null && mark.equals("1")){
%>
<div>
    <div style="text-align: center;">
        <button type="submit" class="layui-btn layui-btn-radius" onclick="window.location.href='/film/film_insert.jsp'">返回</button>
    </div>
</div>
<%
}
else if(mark != null && mark.equals("2")){
%>
<div>
    <div style="text-align: center;">
        <button type="submit" class="layui-btn layui-btn-radius" onclick="window.location.href='/film/film_delete.jsp'">返回</button>
    </div>
</div>
<%
}
else if(mark != null && mark.equals("3")){
%>
<div>
    <div style="text-align: center;">
        <button type="submit" class="layui-btn layui-btn-radius" onclick="window.location.href='/film/film_update.jsp'">返回</button>
    </div>
</div>
<%
}
else if(mark != null && mark.equals("4")) {
%>
<div>
    <div style="text-align: center;">
        <button type="submit" class="layui-btn layui-btn-radius" onclick="window.location.href='/film/PersonIndex.jsp'">返回</button>
    </div>
</div>
<%
}
else if(mark != null && mark.equals("5")) {
%>
<div>
    <div style="text-align: center;">
        <button type="submit" class="layui-btn layui-btn-radius" onclick="window.location.href='/film/FirmIndex.jsp'">返回</button>
    </div>
</div>
<%
}
else if(mark != null && mark.equals("6")) {
%>
<div>
    <div style="text-align: center;">
        <button type="submit" class="layui-btn layui-btn-radius" onclick="window.location.href='/film/KindManage.jsp'">返回</button>
    </div>
</div>
<%
    }
%>
<div class="maincontainer">
    <script src='../afctf/js/TweenMax.min.js'></script>
    <script src="../afctf/js/index.js"></script>
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
<script type="text/javascript" color="0,0,139" count="175" opacity="0.5" src="../canvas-nest.min.js"></script>
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
