<%@ page import="database.DBOperator" %>
<%@ page import="java.util.List" %>
<%@ page import="Bean.Firm" %>
<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2018/6/10
  Time: 下午7:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html>
<head>
    <title>人物信息管理</title>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1/demo.css">
    <script type="text/javascript" src="jquery-easyui-1/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1/jquery.easyui.min.js"></script>
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
</div>.

<!--<div class="layui-container">
<table class="layui-hide" id="test"></table>
<script src="../layui/layui.js" charset="utf-8"></script>
layui.use('table', function(){
  var table = layui.table;

  table.render({
    elem: '#test'
    ,url:'user'
    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    ,cols: [[
      {field:'id', width:80, title: 'ID', sort: true}
      ,{field:'username', width:80, title: '用户名'}
      ,{field:'sex', width:80, title: '性别', sort: true}
      ,{field:'city', width:80, title: '城市'}
      ,{field:'sign', title: '签名', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
      ,{field:'experience', title: '积分', sort: true}
      ,{field:'score', title: '评分', sort: true}
      ,{field:'classify', title: '职业'}
      ,{field:'wealth', width:137, title: '财富', sort: true}
    ]]
  });
});
</script>
</div>-->
<%
    String username = "film";
    String password = "123456";
    String operateObject = "firmIndex";
    String sql = "select * from Firm order by FirmID + 0";

    DBOperator dbOperator = new DBOperator(username,password,operateObject);
    dbOperator.query(sql);

    List<Firm> firmList = dbOperator.getFirmList();
%>
<div class="maincontainer" style="margin-left: 120px;margin-right: 20px">
    <div class="layui-row">
        <div class="layui-col-xs6">
            </br>
            <table class="easyui-datagrid" title="公司信息" style="width:600px;height:400px;"
                   data-options="singleSelect:true,collapsible:true,method:'get'">
                <thead>
                <tr>
                    <th data-options="field:'itemid',width:80,align:'center'">公司编号</th>
                    <th data-options="field:'productid',width:180,align:'center'">公司名称</th>
                    <th data-options="field:'listprice',width:100,align:'center'">所在城市</th>
                    <th data-options="field:'listid',width:80,align:'center'">删除操作</th>
                    <th data-options="field:'list1',width:100,align:'center'">改名字或城市</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Firm firmIndex: firmList){
                        String FirmID = firmIndex.getFirmID();
                        String FirmName = firmIndex.getFirmName();
                        String FirmCity = firmIndex.getCity();
                %>
                <tr>
                    <td><%=FirmID%></td>
                    <td><%=FirmName%></td>
                    <td><%=FirmCity%></td>
                    <td>
                        <form action="/FirmDelete" method="post">
                            <input type="hidden" name="mark">
                            <input type="hidden" name="FirmID">
                            <input type="hidden" name="FirmName">
                            <button type="submit" onclick="this.form.mark.value='5';this.form.FirmID.value='<%=FirmID%>';this.form.FirmName.value='<%=FirmName%>';javascript:return p_del()">删除记录</button>
                        </form>
                    </td>
                    <td>
                        <form action="FirmCityNamechange.jsp">
                            <input type="hidden" name="mark">
                            <input type="hidden" name="firm_num_upn">
                            <input type="hidden" name="city">
                            <input type="hidden" name="name">
                            <button type="submit" onclick="this.form.mark.value='5';this.form.firm_num_upn.value='<%=FirmID%>';this.form.name.value='<%=FirmName%>';this.form.city.value='<%=FirmCity%>'">修改</button>
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
        <div class="layui-col-xs6" style="margin-top: 20px">
            <form class="layui-form layui-form-pane" action="/FirmInsert" method="post">
                <fieldset class="layui-elem-field layui-field-title">
                    <legend>添加公司</legend>
                </fieldset>
                <div class="layui-form-item">
                    <label class="layui-form-label">公司名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="FirmName" required lay-verify="required" placeholder="请输入公司名称" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">所在城市</label>
                    <div class="layui-input-inline">
                        <input onkeyup="value=value.replace(/[\d]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[\d]/g,''))" type="text" name="city" required lay-verify="required" placeholder="请输入所在城市" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div align="" style="margin-left: 100px;">
                    <input type="hidden" name="mark">
                    <button type="submit" class="layui-btn layui-btn-primary layui-btn-radius" onclick="this.form.mark.value='5'">添加记录</button>
                </div>
            </form>
            <p></p>
<!--
            <form class="layui-form layui-form-pane" action="/FirmUpdate" method="post">
                <fieldset class="layui-elem-field layui-field-title">
                    <legend>修改名称和城市</legend>
                </fieldset>
                <div class="layui-form-item">
                    <label class="layui-form-label">公司编号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="firm_num_upn" required lay-verify="required" placeholder="请输入公司编号" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">公司名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="firm_name_up" required lay-verify="required" placeholder="请输入公司名称" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">所在城市</label>
                    <div class="layui-input-inline">
                        <input type="text" name="city" required lay-verify="required" placeholder="请输入所在城市" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div align="" style="margin-left: 100px;">
                    <input type="hidden" name="mark">
                    <button type="submit" class="layui-btn layui-btn-primary layui-btn-radius" onclick="this.form.mark.value='5'">修改记录</button>
                </div>
            </form>
            -->
        </div>
    </div>
</div>
</br>
</br>
<div style="text-align: center;">
    <button id="2" class="layui-btn layui-btn-primary layui-btn-radius" onclick="window.location.href='changeindex.html'">返回</button>
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
