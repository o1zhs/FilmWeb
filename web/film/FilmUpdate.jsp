<%@ page import="Bean.Film" %>
<%@ page import="java.util.List" %>
<%@ page import="Bean.Person" %>
<%@ page import="Bean.Firm" %>
<%@ page import="database.DBOperator" %><%--
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
    String username = "film";
    String password = "123456";
    String operateObject2 = "firmIndex";
    String sql2 = "select * from Firm order by FirmID + 0";
    DBOperator dbOperator2 = new DBOperator(username,password,operateObject2);
    dbOperator2.query(sql2);

    List<Firm> firmList = dbOperator2.getFirmList();
    String abc = request.getParameter("abc");
    String FilmID = request.getParameter("FilmID");
    String FilmName = request.getParameter("FilmName");
    Object object = request.getAttribute("filmList");
    List<Film> filmList = null;
    if(object instanceof List) {
        filmList = (List<Film>) object;
    }
    String filmname = "";
    String filmyear = "";
    String filmlength = "";
    String filmfirm = "";
    String filmplot = "";
    List<Person> filmvoice = null;
    for(Film film:filmList) {
        filmname = film.getFilmName();
        filmyear = film.getPublishYear();
        filmlength = film.getLength();
        filmfirm = film.getPublishFirm();
        filmplot = film.getPlot();
        filmvoice = film.getVoice();
    }
    if(abc.equals("1")){
%>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend style="text-align: center;">电影名字</legend>
</fieldset>
<ul class="layui-timeline" style="margin-left: 120px;">
    <li class="layui-timeline-item">
        <i class="layui-icon layui-timeline-axis"></i>
        <div class="layui-timeline-content layui-text">
            <div class="layui-timeline-title">电影名称：<%=filmname%></div>
        </div>
    </li>
</ul>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend style="text-align: center;">改名字</legend>
</fieldset>
<form id="filmform" class="layui-form layui-form-pane" action="/FilmUpdate" method="post">
    <div class="layui-inline">
        <label class="layui-form-label">新名字</label>
        <div class="layui-input-inline">
            <input type="tel" name="FilmName" placeholder="请输入新电影名" required lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div style="text-align: center">
        <button type="submit" class="layui-btn layui-btn-radius" style="margin-top: 30px;" onclick="">修改</button>
    </div></form>
<%
    }
    else if(abc.equals("2"))
    {
        %>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend style="text-align: center;">电影日期</legend>
</fieldset>
<ul class="layui-timeline" style="margin-left: 120px;">
    <li class="layui-timeline-item">
        <i class="layui-icon layui-timeline-axis"></i>
        <div class="layui-timeline-content layui-text">
            <div class="layui-timeline-title">电影日期：<%=filmyear%></div>
        </div>
    </li>
</ul>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend style="text-align: center;">改日期</legend>
</fieldset>
<form id="filmform" class="layui-form layui-form-pane" action="/FilmUpdate" method="post">
    <div class="layui-inline">
        <label class="layui-form-label">新日期</label>
        <div class="layui-input-inline">
            <input type="text" name="date" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div style="text-align: center">
        <button type="submit" class="layui-btn layui-btn-radius" style="margin-top: 30px;" onclick="">修改</button>
    </div></form>
<%
    }
    else if (abc.equals("3")) {
        %>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend style="text-align: center;">电影时长</legend>
</fieldset>
<ul class="layui-timeline" style="margin-left: 120px;">
<li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis"></i>
    <div class="layui-timeline-content layui-text">
        <div class="layui-timeline-title">电影时长：<%=filmlength%>分钟</div>
    </div>
</li>
</ul>
<form id="filmform" class="layui-form layui-form-pane" action="/FilmUpdate" method="post">
<div class="layui-form-item">
    <label class="layui-form-label">新时长</label>
    <div class="layui-input-inline">
        <input type="number" name="FilmLength" lay-verify="required" placeholder="请输入时长" autocomplete="off" class="layui-input">
    </div>
</div>
    <div style="text-align: center">
        <button type="submit" class="layui-btn layui-btn-radius" style="margin-top: 30px;" onclick="">修改</button>
    </div></form>
<%
    }
    else if (abc.equals("4"))
    {
        %>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend style="text-align: center;">出品公司</legend>
</fieldset>
<ul class="layui-timeline" style="margin-left: 120px;">
<li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis"></i>
    <div class="layui-timeline-content layui-text">
        <div class="layui-timeline-title">出品公司：<%=filmfirm%></div>
    </div>
</li>
    </ul>
<form id="filmform" class="layui-form layui-form-pane" action="/FilmUpdate" method="post">
<div class="layui-form-item">
    <label class="layui-form-label">出品公司</label>
    <div class="layui-input-inline">
        <select name="Firm" lay-filter="aihao">
            <option value="" selected=""></option>
            <%
                for (Firm firmIndex: firmList){
                    String FirmName = firmIndex.getFirmName();
            %>
            <option value="<%=FirmName%>"><%=FirmName%></option>
            <%
                }
            %>
        </select>
    </div>
</div>
    <div style="text-align: center">
        <button type="submit" class="layui-btn layui-btn-radius" style="margin-top: 30px;" onclick="">修改</button>
    </div></form>
<%
    } else if(abc.equals("5")) {
        %>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend style="text-align: center;">电影简介</legend>
</fieldset>
<ul class="layui-timeline" style="margin-left: 120px;">
    <li class="layui-timeline-item">
        <i class="layui-icon layui-timeline-axis"></i>
        <div class="layui-timeline-content layui-text">
            <div class="layui-timeline-title">电影简介：</div>
            <%=filmplot%>
        </div>
    </li>
</ul>
<form id="filmform" class="layui-form layui-form-pane" action="/FilmUpdate" method="post">
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">新简介</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" name="FilmPlot" class="layui-textarea"></textarea>
        </div>
    </div>
    <div style="text-align: center">
    <button type="submit" class="layui-btn layui-btn-radius" style="margin-top: 30px;" onclick="">修改</button>
    </div>
</form>
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
<script src="../layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');


    });
</script>
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

