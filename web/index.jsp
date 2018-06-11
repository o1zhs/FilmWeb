<%--
  Created by IntelliJ IDEA.
  User: liu
  Date: 2018/5/16
  Time: 下午7:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html>
<head>
  <title>用户-查询主页</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="film/css/style.css" />
  <script type="text/javascript" src="film/js/jquery.js"></script>
  <script type="text/javascript" src="film/js/sliding_effect.js"></script>
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
  <script type="text/javascript" src="value_js/jquery.min.2.0.js"></script>
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
        <li id="logout"><a href="../login.html" style="">退出登录</a></li>
      </ul>
    </div>
    <div class='cssmenu' style="margin-left: 0;flex: 0 0 4.5%;max-width: 10%;display: block;width: 100%">
      <ul>
        <li><a href="" style="border-bottom: 0px"><img src="film/user.png" alt=""></a></li>
      </ul>
    </div>
  </div>
</div>
</div>


<div class="layui-carousel" id="test10">
  <div carousel-item="">
    <div><img src="img/2.jpg"></div>
    <div><img src="img/1.jpg"></div>
    <div><img src="img/back02_02.jpg"></div>
    <div><img src="img/5.png"></div>
    <div><img src="img/logo的副本.png"></div>
    <div><img src="img/3.png"></div>
    <div><img src="img/xyf.jpg"></div>
  </div>
</div>
<div class="layui-container">
  <h1 style="text-align: center; margin-top: 50px;">欢&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;迎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;来&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;到&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;影&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;信&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;统</h1>
  </br>
  <button class="layui-btn layui-btn-lg layui-btn-radius layui-btn-normal" style="margin-left: 415px; margin-top:30px;" onclick="window.location.href='film/queryindex.jsp'">进入查询页面</button>
  <button class="layui-btn layui-btn-lg layui-btn-radius layui-btn-normal" style="margin-top:30px;" onclick="window.location.href='film/changeindex.html'">进入修改页面</button>
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
                "z-index": 9,
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
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['carousel', 'form'], function(){
        var carousel = layui.carousel
            ,form = layui.form;

        //常规轮播
        carousel.render({
            elem: '#test1'
            ,arrow: 'always'
        });

        //改变下时间间隔、动画类型、高度
        carousel.render({
            elem: '#test2'
            ,interval: 1800
            ,anim: 'fade'
            ,height: '120px'
        });

        //设定各种参数
        var ins3 = carousel.render({
            elem: '#test3'
        });
        //图片轮播
        carousel.render({
            elem: '#test10'
            ,width: '1400px'
            ,height: '440px'
            ,interval: 3000
        });

        //事件
        carousel.on('change(test4)', function(res){
            console.log(res)
        });

        var $ = layui.$, active = {
            set: function(othis){
                var THIS = 'layui-bg-normal'
                    ,key = othis.data('key')
                    ,options = {};

                othis.css('background-color', '#5FB878').siblings().removeAttr('style');
                options[key] = othis.data('value');
                ins3.reload(options);
            }
        };

        //监听开关
        form.on('switch(autoplay)', function(){
            ins3.reload({
                autoplay: this.checked
            });
        });

        $('.demoSet').on('keyup', function(){
            var value = this.value
                ,options = {};
            if(!/^\d+$/.test(value)) return;

            options[this.name] = value;
            ins3.reload(options);
        });

        //其它示例
        $('.demoTest .layui-btn').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });
    });
</script>
</body>
</html>
