<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2018/6/10
  Time: 下午7:27
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
    <link href="../layui/css/layui.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="../afctf/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="../afctf/css/reser.css" rel="stylesheet" type="text/css" media="all" />
    <link href="../afctf/css/countdown.css" rel="stylesheet" type="text/css" media="all" />
    <link href="../afctf/css/challenge.css" rel="stylesheet" type="text/css" media="all" />
    <script src="../afctf/js/jquery-3.3.1.min.js"></script>
    <script src="../afctf/js/layer/layer.js"></script>
    <script src="../afctf/js/echarts.min.js"></script>
    <script src="../afctf/js/utils.js"></script>
    <script src="../afctf/js/challenge.js"></script>
    <script src="../afctf/js/inputLimit.js"></script>
    <script type="text/javascript" src="../value_js/jquery.min.2.0.js"></script>
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
                <li id="logout"><a href="../login.html" style="">退出登录</a></li>
            </ul>
        </div>
        <div class='cssmenu' style="margin-left: 0;flex: 0 0 4.5%;max-width: 10%;display: block;width: 100%">
            <ul>
                <li><a href="" style="border-bottom: 0px"><img src="user.png" alt=""></a></li>
            </ul>
        </div>
    </div>
</div>
<div class="layui-container">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend style="text-align: center;">电影查询结果</legend>
    </fieldset>
    <ul class="layui-timeline" style="margin-left: 120px;">
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">电影名称：邱轶昊的大学生活</div>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">电影导演：张浩森</div>
            </div>
        </li>
    </ul>
    <div style="text-align: center;">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
            <legend style="text-align: center;">添加导演或删除导演</legend>
        </fieldset>
        <form id="filmform" class="layui-form layui-form-pane" action="" onsubmit="">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">输入导演</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="Filmdirector" placeholder="请输入导演" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
            <div align="center">
                <input type="hidden" id="abc" name="abc" value="1">
                <input type="hidden" id="FilmID1" name="FilmID" value="1">
                <button id="1" type="submit" value="01" class="layui-btn layui-btn-radius" style="margin-top: 30px;" onclick="this.form.abc.value='1';this.form.FilmID1.value=''">添加导演</button>
                <button id="2" type="submit" value="02" class="layui-btn layui-btn-radius" style="margin-top: 30px;" onclick="this.form.abc.value='2';this.form.FilmID1.value=''">删除导演</button>
            </div>
        </form>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
            <legend style="text-align: center;">修改导演</legend>
        </fieldset>
        <form class="layui-form layui-form-pane" action="" onsubmit="">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">输入导演</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="Filmdirector_cpre" placeholder="请输入要修改的导演" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">修改导演</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="Filmdirector_clate" placeholder="请输入修改后的导演" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
            <div align="center">
                <input type="hidden" id="FilmID2" name="FilmID" value="1">
                <button id="3" type="submit" value="03" class="layui-btn layui-btn-radius" style="margin-top: 30px;" onclick="this.form.abc.value='3';this.form.FilmID1.value=''">修改导演</button>
            </div>
        </form>
    </div>
    </br>
    <div style="text-align: center;">
        <button id="" class="layui-btn layui-btn-radius" onclick="window.location.href='FilmOtherChangeQuery.jsp'">返回</button>
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
