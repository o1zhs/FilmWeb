function htmlEntities(str) {
    return String(str).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;').replace(/'/g,'&apos;');
}
function show_result(){
    $("#result-notification").slideToggle();
    $("#submit-key").attr('disabled',false);
}
function check_flag(str,title) {
    var xmlhttp;
    var result;
    if (str=="")
    {
        document.getElementById("txtHint").innerHTML="";
        return;
    }
    if (window.XMLHttpRequest)
    {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            result = xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET","/afctf/members/check_flag.php?flag="+str+"&title="+title,false);
    xmlhttp.send();
    return result;
}

function showSovler(title) {
    var xmlhttp;
    var html;
    if (window.XMLHttpRequest)
    {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            html = xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET","/afctf/members/taskSolver.php?title="+title,false);
    xmlhttp.send();
    return html;
}

function tab(title,point,description,link,solved_num) {
    title = htmlEntities(title);
    point = htmlEntities(point);
    description = htmlEntities(description);
    description = description.replace(/&lt;br&gt;/g,"<br>");
    link = htmlEntities(link);
    solved_num = htmlEntities(solved_num);
    layer.tab({
        type:0,
        btn: 0,
        shadeClose:true,
        area: ['500px'],
        success:function (layero,index) {
            //对原始layer弹出层进行处理
            //处理标签栏
            $(".layui-layer-title").css({
                "background-color":"#FFF",
                "padding":"10px",
                "color":"#212529",
                "font-weight":"400"
            });
            //处理关闭按钮
            $(".layui-layer-setwin").css("padding","10px");
            //处理layer-content外边距
            $(".layui-layer-content").css("padding-left","0px");
            $(".layui-layer-content").css("padding-right","0px");
            // //禁止出现滚动条
            // $(".layui-layer-content").css("overflow","visible");
            $("#submit-key").click(function () {
                $(this).attr('disabled',true);
                var flagvalue = document.getElementById("answer-input").value;
                var status = check_flag(flagvalue,title);
                if(status == '0'){
                    //flag错误
                    $("#result-notification").removeClass("alert-normal-correct");
                    $("#result-notification").addClass("alert-normal-incorrect");
                    $("#result-message").removeClass("result-message-correct");
                    $("#result-message").addClass("result-message-incorrect");
                    document.getElementById('result-message').innerHTML = 'Incorrect';
                    $("#result-notification").slideToggle();
                    setTimeout('show_result()',2500);
                }
                else if(status == '1'){
                    //flag正确
                    $("#result-notification").removeClass("alert-normal-incorrect");
                    $("#result-notification").addClass("alert-normal-correct");
                    $("#result-message").removeClass("result-message-incorrect");
                    $("#result-message").addClass("result-message-correct");
                    document.getElementById('result-message').innerHTML = 'Correct';
                    $("#result-notification").slideToggle();
                    setTimeout('show_result()',2500);
                }
                else if(status == '2'){
                    // 已经答对了
                    $("#result-notification").addClass("alert-normal-solved");
                    $("#result-message").addClass("result-message-solved");
                    document.getElementById('result-message').innerHTML = 'You already solved this';
                    $("#result-notification").slideToggle();
                    setTimeout('show_result()',2500);
                }
                else if(status == '3'){
                    // 提交次数超限制
                    layer.msg('一个小时内只能提交20次flag', {
                      icon: 5,
                      time: 1500 //2秒关闭（如果不配置，默认是3秒）
                    }, function(){
                      window.location.href="#";
                    });
                }
                else if(status == '4'){
                    // 提交次数超限制
                    layer.msg('比赛已结束，flag提交功能已关闭！', {
                      icon: 5,
                      time: 1500 //2秒关闭（如果不配置，默认是3秒）
                    }, function(){
                      window.location.href="#";
                    });
                }
            });

        },
        tab: [{
            title: 'Challenge',
            content: '<div class ="modal-dialog" role="document">\n' +
            '    <div class="modal-content">\n' +
            '        <div class="modal-body">\n' +
            '            <div role="tabpanel">\n' +
            '                <div class="tab-content">\n' +
            '                    <div role="tabpanel" class="tab-pane fade show active" id="challenge">\n' +
            '                        <h2 class="chal-ttile">'+title+'</h2>\n' +
            '                        <h3 class="chal-point">'+point+'</h3>\n' +
            '                        <div class="chal-description">\n' +
            '                        <span class="chal-description" id="try"><p>'+description+'</p>\n' +
            '</span>\n' +
            '                        \n' +
            '                        </div>\n' +

            '                        <div class="link">\n' +
            '   \n' +
            '                            <div class="col-md-4 col-sm-4 col-xs-12 file-button-wrapper d-block">\n' +
            '                                <a id="link-font" href='+link+' target="_blank">点击这里，开始你的比赛！</a>\n' +
            '                            </div>\n' +
            '                            \n' +
            '                        </div>\n' +
            '\n' +
            '                        <div class="submit-row">\n' +
            '                            <div class="flag-form">\n' +
            '                                <input class="flag-control" name="answer" id="answer-input" placeholder="Flag" type="text">\n' +
            '                                <input id="chal-id" value="2" type="hidden">\n' +
            '                            </div>\n' +
            '                            <div class="flag-submit">\n' +
            '                                <button type="submit" id="submit-key" tabindex="5" class="flag-submit-control flag-submit-control-secondary">Submit</button>\n' +
            '                            </div>\n' +
            '                        </div>\n' +
            '                        <div class="row notification-row">\n' +
            '                            <div class="col-md-12">\n' +
            '                                <div id="result-notification" class="alert-normal alert-normal-incorrect" role="alert" style="display: none">\n' +
            '                                  <strong id="result-message" class="result-message-incorrect">Incorrect</strong>\n' +
            '                                </div>\n' +
            '                            </div>\n' +
            '                        </div>\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '        </div>\n' +
            '    </div>\n' +
            '</div>'
        },  {
            title: solved_num+' Solves',
            content: showSovler(title),
        }]
    });
}


