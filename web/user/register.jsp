<%--
  Created by IntelliJ IDEA.
  User: Pealing
  Date: 2017/5/28
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="jap" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>GitSHU 用户注册</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.10.2.min.js"></script>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script stc="js/npm.js"></script>

    <!--表单验证-->
    <link href="${pageContext.request.contextPath}/static/css/validationEngine.jquery.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery.validationEngine-zh_CN.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery.validationEngine.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/main_validation.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>GitSHU 用户注册</title>
</head>
<body>
<jap:include value="/components/banner.jsp"/>

<div style="position: absolute; left: 20%;top: 20%;width: 60%;">
    <h1>Join GitSHU</h1>
    <h3 style="margin-bottom: 5%;">
        <small>The best way to design, build, and ship software.</small>
    </h3>
    <form id="signup_form" action="<s:url namespace="/user" action="register"/>" method="post">
        <div class="form-group">
            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
            <label>Username</label>
            <input name="username" type="text" class="form-control validate[required]" id="signup_username"
                   placeholder="Username">
            <div style="margin-top: 2%; font-size: 15px;" id="CheckUser"></div>
        </div>
        <div class="form-group">
            <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
            <label>Password</label>
            <input name="password" type="password" class="form-control validate[required]" id="signup_password"
                   placeholder="Password">
        </div>
        <div class="form-group">
            <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
            <label>Confirm password</label>
            <input type="password" class="form-control validate[required,equals[signup_password]]"
                   id="signup_conf_password" placeholder="Confirm Password">
        </div>

        <div class="form-group">
            <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
            <label>Realname</label>
            <input name="realName" type="text" class="form-control validate[required]" id="signup_realname"
                   placeholder="Realname">
        </div>
        <div class="form-group">
            <span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
            <label>Gender</label>
            <div class="radio">
                <label>
                    <input type="radio" name="gender" id="Man" value="0" checked>男
                </label>
                <label style="margin-left: 10px;">
                    <input type="radio" name="gender" id="Woman" value="1" checked>女
                </label>
                <label style="margin-left: 10px;">
                    <input type="radio" name="gender" id="Scrit" value="2" checked>保密
                </label>
            </div>
        </div>
        <div class="form-group">
            <span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span>
            <label>Phone:</label>
            <input type="text" class="form-control" id="signup_phonr" placeholder="telphone">
        </div>
        <div class="form-group">
            <span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
            <label>E-mail:</label>
            <input type="email" class="form-control validate[required]" id="exampleInputEmail1" placeholder="E-mail">
        </div>
        <div class="form-group">
            <span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
            <label>Introduction</label>
            <textarea class="form-control" rows="3"></textarea>
        </div>
        <button id="register_submit" type="submit" class="btn btn-default">Submit</button>
    </form>
</div>
</body>
</html>

