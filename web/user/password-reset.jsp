<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="jap" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Pealing
  Date: 2017/5/28
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.10.2.min.js"></script>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/npm.js"></script>

    <script src="${pageContext.request.contextPath}/static/js/Password_validation.js"></script>
    <title>GitSHU 修改密码</title>
</head>
<body>
<jap:include value="/components/banner.jsp"/>
<jap:include value="/components/user_menu_left.jsp"/>
<div style="position: absolute;left: 35%;top: 15%;width: 53%;">
    <h1>修改密码</h1>
    <h3>
        <small>———————————————————————————————————————————</small>
    </h3>
    <form id="changepwd_form" action="<s:url namespace="/user" action="resetPassword"/>" method="post">
        <div class="form-group">
            <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
            <label>Old password</label>
            <input type="password" class="form-control validate[required]" id="oldPassword" name="oldPassword" placeholder=""/>
            <div style="margin-top: 2%; color: palevioletred; font-size: 15px;"
                 id="CheckPassword"></div>
        </div>
        <div class="form-group">
            <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
            <label>New password</label>
            <input type="password" class="form-control validate[required]" id="newPassword" name="newPassword" placeholder=""/>
        </div>
        <div class="form-group">
            <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
            <label>Confirm new password</label>
            <input type="password" class="form-control validate[required,equals[newPassword]]" id="conf_new_pwd" placeholder=""/>
        </div>
        <button id="changepwd_submit" type="submit" class="btn btn-info">Update password</button>
    </form>
</div>

</body>
</html>
