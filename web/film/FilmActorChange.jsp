<%@ page import="Bean.Film" %>
<%@ page import="Bean.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="Bean.Actor" %><%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2018/6/10
  Time: 下午7:26
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
    <script src="js/jquery-3-2-1.js"></script>
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
                <li id="logout"><a href="" style="">退出登录</a></li>
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
    String ID = request.getParameter("FilmID");
    String FilmName = request.getParameter("FilmName");
    Object object = request.getAttribute("filmList");
    List<Film> filmList = null;
    if(object instanceof List) {
        filmList = (List<Film>) object;
    }
    //按名称查询电影的信息
    if(filmList.isEmpty()){
%>
<h1>对不起没有此记录</h1>
<%
}
else{
    String filmname = "";
    String filmyear = "";
    String filmlength = "";
    String filmfirm = "";
    List<Person> filmactor = null;
    List<Person> filmdirector = null;
    List<String> filmcategory = null;
    String filmplot = "";
    List<Person> filmvoice = null;
    for(Film film:filmList) {
        filmname = film.getFilmName();
        filmyear = film.getPublishYear();
        filmlength = film.getLength();
        filmfirm = film.getPublishFirm();
        filmactor = film.getActor();
        filmdirector = film.getDirector();
        filmcategory = film.getCategoryList();
        filmplot = film.getPlot();
        filmvoice = film.getVoice();
    }
%>
<div class="layui-container">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend style="text-align: center;">电影查询结果</legend>
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
    </ul>
    <div style="text-align: center;">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
            <legend style="text-align: center;">删除记录</legend>
        </fieldset>
        <form class="layui-form layui-form-pane" action="/FilmActorChange" method="post" name="role1">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label"><font clolor="gray">选择演员</font></label>
                    <div class="layui-input-inline">
                        <select id="deteleperson" name="Filmactor" required lay-verify="required">
                            <option value="" selected=""></option>
                            <%
                                for (Person film_actor:filmactor){
                                    String Person_name = film_actor.getName();
                            %>
                            <option value="<%=Person_name%>"><%=Person_name%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">选择角色</label>
                    <div class="layui-input-inline">
                        <div class="layui-input-inline">
                            <select id="delaterole" name="Filmrole" required lay-verify="required">
                                <option value="" selected=""></option>
                                <%
                                    for (Person film_actor:filmactor){
                                        String Person_name = film_actor.getName();  //演员姓名
                                        Actor filma = film_actor.getActor();        //获取演员饰演的角色
                                        List<String> filmal = filma.getRole();      //遍历演员饰演的角色
                                        for (String filmall:filmal){                //获取演员饰演的角色的String

                                %>
                                <option value="<%=filmall%>"><%=filmall%></option>
                                <p></p>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div align="center">
                <input type="hidden" name="FilmID">
                <input type="hidden" name="label">
                <input type="hidden" name="FilmName">
                <input type="hidden" name="id">
                <button type="submit" class="layui-btn layui-btn-radius" style="margin-top: 30px;" onclick="this.form.id.value='2';this.form.FilmID.value='<%=ID%>';this.form.label.value='2';this.form.FilmName.value='<%=FilmName%>';javascript:return p_del()">删除</button>
            </div>
        </form>
        </br>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
            <legend style="text-align: center;">添加记录</legend>
        </fieldset>
        <form class="layui-form layui-form-pane" action="/FilmActorChange" method="post" name="role1">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">输入演员</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="Filmactor" required lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入演员">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">输入角色</label>
                    <div class="layui-input-inline">
                        <input type="text" name="Filmrole" required lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入角色">
                    </div>
                </div>
            </div>
            <div align="center">
                <input type="hidden" name="FilmID">
                <input type="hidden" name="label">
                <input type="hidden" name="FilmName">
                <input type="hidden" name="id">
                <button type="submit" class="layui-btn layui-btn-radius" style="margin-top: 30px;" onclick="this.form.id.value='1';this.form.FilmID.value='<%=ID%>';this.form.label.value='2';this.form.FilmName.value='<%=FilmName%>'">添加</button>
            </div>
        </form>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
            <legend style="text-align: center;">修改演员或角色</legend>
        </fieldset>
        <form class="layui-form layui-form-pane" action="/FilmActorUpdate" method="post">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label"><font clolor="gray">选择原始演员</font></label>
                    <div class="layui-input-inline">
                        <select name="Filmactor0" required lay-verify="required">
                            <option value="" selected=""></option>
                            <%
                                for (Person film_actor:filmactor){
                                    String Person_name = film_actor.getName();
                            %>
                            <option value="<%=Person_name%>"><%=Person_name%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">选择原始角色</label>
                    <div class="layui-input-inline">
                        <div class="layui-input-inline">
                            <select name="Filmrole0" required lay-verify="required">
                                <option value="" selected=""></option>
                                <%
                                    for (Person film_actor:filmactor){
                                        String Person_name = film_actor.getName();  //演员姓名
                                        Actor filma = film_actor.getActor();        //获取演员饰演的角色
                                        List<String> filmal = filma.getRole();      //遍历演员饰演的角色
                                        for (String filmall:filmal){                //获取演员饰演的角色的String

                                %>
                                <option value="<%=filmall%>"><%=filmall%></option>
                                <p></p>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">输入演员</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="Filmactor1" required lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入修改后的演员">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">输入角色</label>
                    <div class="layui-input-inline">
                        <input type="text" name="Filmrole1" required lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入修改后的角色">
                    </div>
                </div>
            </div>
            <div align="center">
                <input type="hidden" name="FilmID" value="1">
                <input type="hidden" name="label">
                <input type="hidden" name="FilmName">
                <button type="submit" class="layui-btn layui-btn-radius" style="margin-top: 30px;" onclick="this.form.FilmID.value='<%=ID%>';this.form.label.value='2';this.form.FilmName.value='<%=FilmName%>'">修改</button>
            </div>
        </form>
        <%
            }
        %>
        </br>
        </br>
        <button id="" class="layui-btn layui-btn-radius" onclick="window.location.href='/film/FilmOtherChangeQuery.jsp'">返回</button>
    </div>
</div>
<script language=javascript>
    function p_del() {
        var msg = "您真的确定要删除吗？\n\n请确认！";
        if (confirm(msg)==true){
            return true;
        }else{
            return false;
        }
    }
</script>
<script type="text/javascript">
    function findjc(){
        var person_name = $('#deleteperson option:selected').val();
        $.ajax({
            url:"/FilmQuery",
            type:"post",
            dataType:"html",
            timeout:"1000",
            data:{cityname:cityname},
            success:function(data){

                $("#jcname option").remove();
                var jc=data.split(",");
                for ( var i = 0; i < jc.length; i++) {
                    var jcName = jc[i];
                    $("#jcname").append(
                        "<option value="+jcName+">"
                        + jcName + "</option>");
                }

            },
            error : function(XMLResponse) {
                alert(XMLResponse.responseText);
            }
        });
    }
</script>
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
