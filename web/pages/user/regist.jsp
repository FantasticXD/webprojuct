<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>小番茄协会注册页面</title>
   <%@include file="/pages/common/head.jsp"%>
    <script>

        $(function () {
            var pet = /^\w{5,12}$/;

            var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
            $("#sub_btn").click(function () {
                var username = $("#username").val();
                if (!pet.test(username)) {
                    $("span.errorMsg").text("用户名格式错误");
                    return false;
                }
                $("span.errorMsg").text("");

                var password = $("#password").val();
                if (!pet.test(password)) {
                    $("span.errorMsg").text("密码格式错误");
                    return false;
                }
                $("span.errorMsg").text("");

                var repassword = $("#repwd").val();
                if (repassword != password) {
                    $("span.errorMsg").text("前后密码不一致");
                    return false;
                }
                $("span.errorMsg").text("");

                var email = $("#email").val();
                if (!emailPatt.test(email)) {
                    $("span.errorMsg").text("电子邮件格式错误");
                    return false;
                }
                $("span.errorMsg").text("");

                var codeText = $("#code").val();

                codeText = $.trim(codeText);
                if (codeText == null || codeText == "") {
                    $("span.errorMsg").text("验证码不能为空！");
                    return false;
                }
                $("span.errorMsg").text("");
            });
        });


    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>

</head>

<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册小番茄协会会员</h1>
                    <span class="errorMsg"><%=request.getAttribute("msg")==null? "":request.getAttribute("msg")%></span>
                </div>
                <div class="form">
                    <form action="UserServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username"
                        value="<%=request.getAttribute("username")==null? "":request.getAttribute("username")%>"
                        />
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"
                               value="<%=request.getAttribute("password")==null? "":request.getAttribute("password")%>" />
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"
                        value="<%=request.getAttribute("password")==null? "":request.getAttribute("password")%>"

                        />
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email"
                               value="<%=request.getAttribute("email")==null? "":request.getAttribute("email")%>"
                        />
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 150px;" id="code" name="code"/>
                        <img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/bottom.jsp"%>
</body>
</html>