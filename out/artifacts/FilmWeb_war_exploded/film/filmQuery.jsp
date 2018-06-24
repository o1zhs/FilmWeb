<%@ page import="database.DBOperator" %>
<%@ page import="java.util.List" %>
<%@ page import="Bean.Film" %>
<%@ page import="Bean.Person" %>
<%--
  Created by IntelliJ IDEA.
  User: liu
  Date: 2018/5/30
  Time: 下午9:33
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
<div id="navigation-block">
    <h1>电影查询</h1>
    <ul id="sliding-navigation">
        <li class="sliding-element"><a href="filmQuery.jsp" style="font-size:20px; font-family:verdana">电影</a></li>
        <li class="sliding-element"><a href="actorQuery.jsp" style="font-size:20px; font-family:verdana">演员</a></li>
        <li class="sliding-element"><a href="directorQuery.jsp" style="font-size:20px; font-family:verdana">导演</a></li>
        <li class="sliding-element"><a href="voice_Query.jsp" style="font-size:20px; font-family:verdana">旁白</a></li>
        <li class="sliding-element"><a href="firmQuery.jsp" style="font-size:20px; font-family:verdana">发行公司</a></li>
        <li class="sliding-element"><a href="../index.jsp" style="font-size:20px; font-family:verdana">返回</a></li>
    </ul>
</div>
<%
    String username = "film";
    String password = "123456";
    String operateObject = "categoryList";
    String sql = "select * from CategoryList";

    DBOperator dbOperator = new DBOperator(username,password,operateObject);
    dbOperator.query(sql);

    List<String> category = dbOperator.getCategoryList();
%>
<div class="div-right1">
    <form>
        <input type="radio" name="xx" value="fname" onclick="clickRadioValue()"><font color="gray">按照名称查询</font>
        <input type="radio" name="xx" value="ftype" onclick="clickRadioValue()"><font color="gray">按照类别查询</font>
    </form>
    </br>
    <div id = "test">
        <form id="fn" action="/FilmQuery" style="visibility:hidden" class="layui-form layui-form-pane" method="post">
            <div class="layui-form-item">
                <label class="layui-form-label"><font color="gray">电影名称</font></label>
                <div class="layui-input-inline">
                    <input name="FilmName" required lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
                </div>
            </div>
            <td colspan="2" style="text-align:center">
                <button type="submit" class="layui-btn layui-btn-primary layui-btn-radius div-right3">查询</button>
            </td>
        </form>
        <form id="ft" action="/FilmQuery" style="visibility:hidden" class="layui-form layui-form-pane" method="post">
            <div class="layui-form-item">
                <label class="layui-form-label"><font clolor="gray">电影类别</font></label>
                <div class="layui-input-inline">
                    <select name="kind" required lay-verify="required">
                        <option value="" selected=""></option>
                        <%
                            for (String kind:category){
                        %>
                        <option value="<%=kind%>"><%=kind%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
            </div>
            <tr>
                <td colspan="2" style="text-align:center">
                    <button  type="submit" class="layui-btn layui-btn-primary layui-btn-radius div-right3">查询</button>
                </td>
            </tr>
        </form>
    </div>
    <form id="tj" style="visibility:hidden">
    </form>
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