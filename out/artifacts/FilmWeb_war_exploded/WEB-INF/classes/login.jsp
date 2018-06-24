<%--
  Created by IntelliJ IDEA.
  User: liu
  Date: 2018/5/30
  Time: 下午9:04
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
    <title>登录</title>
    <script type="application/javascript" src="layui/layui.all.js"></script>
    <link href="layui/css/layui.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="afctf/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="afctf/css/reser.css" rel="stylesheet" type="text/css" media="all" />
    <link href="afctf/css/countdown.css" rel="stylesheet" type="text/css" media="all" />
    <link href="afctf/css/challenge.css" rel="stylesheet" type="text/css" media="all" />
    <script src="afctf/js/jquery-3.3.1.min.js"></script>
    <script src="afctf/js/layer.js"></script>
    <script src="afctf/js/echarts.min.js"></script>
    <script src="afctf/js/utils.js"></script>
    <script src="afctf/js/challenge.js"></script>
    <script src="afctf/js/inputLimit.js"></script>
    <script src="film/js/clickradio.js"></script>
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
            z-index: 0;
            background: #fff;

        }
    </style>
</head>
<!--<body style="background: #f1f1f1;">-->
<div class="bh">
    <div class="header">
        <div class="logo">
            <h1><a href="login.jsp"><img src="img/logo.png" alt=""></a></h1>
        </div>
        <div class='cssmenu' style="margin-left: 0;flex: 0 0 70%;max-width: 50%;display: block;width: 100%">
            <div class="title">
                <br/>
                <h1>电&nbsp;&nbsp;影&nbsp;&nbsp;信&nbsp;&nbsp;息&nbsp;&nbsp;管&nbsp;&nbsp;理&nbsp;&nbsp;系&nbsp;&nbsp;统</h1>
            </div>
        </div>
        <div class='cssmenu' style="margin-left: 0;flex: 0 0 20%;max-width: 20%;display: block;width: 100%">
        </div>
        <div class='cssmenu' style="margin-left: 0;flex: 0 0 4.5%;max-width: 10%;display: block;width: 100%">
        </div>
    </div>
</div>
<!-- 表单选项 -->
<body style="background: #f1f1f1">
<div class="window">
    <div class="title">
        <h1>登录页</h1>
    </div>
    <form action = "${pageContext.request.contextPath}/Login" class="layui-form" method="post" >
        <!-- 用户名 -->
        <div class="layui-input-inline">
            <div class="layui-form-item" style="margin-right: 100px;margin-top: 20px;">
                <label class="layui-form-label">用户名：</label>
                <div class="layui-input-block">
                    <input type="text" name="username" required lay-verify="required" placeholder="请输入用户名" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
        </div>
        <!-- 密码 -->
        <div class="layui-input-inline">
            <div class="layui-form-item" style="margin-right: 100px;margin-top: 20px;">
                <label class="layui-form-label">密码：</label>
                <div class="layui-input-block">
                    <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
        </div>
        <!-- 确认密码 -->
        <div style="text-align: center;">
            <input type="submit" class="layui-btn layui-btn-normal"  value="登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;陆"/>
        </div>
        <hr style="width: 100%"/>
        <input type="radio" name="xx" value="fname" onclick="clickRadioValue()"><a>普通登陆</a>
        <input type="radio" name="xx" value="ftype" onclick="clickRadioValue()"><a>管理员登陆</a>
        <br>
            </br>
            <a href="register.jsp">没有账号？立即注册&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
            <a href="alterPW.jsp">忘记密码？</a>
    </form>
    <br/>
</div>
<script src="layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['form','layer','jquery'], function () {

        // 操作对象
        var form = layui.form;
        var $ = layui.jquery;
        form.on('submit(login)',function (data) {
            // console.log(data.field);
            $.ajax({
                url:'login.php',
                data:data.field,
                dataType:'text',
                type:'post',
                success:function (data) {
                    if (data == '1'){
                        location.href = "";
                    }else{
                        layer.msg('登录名或密码错误');
                    }
                }
            })
            return false;
        })

    });
</script>
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
