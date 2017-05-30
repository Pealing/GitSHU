<%--
  Created by IntelliJ IDEA.
  User: Pealing
  Date: 2017/5/28
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.10.2.min.js"></script>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>GitSHU Banner</title>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="/index.jsp">Git SHU</a>
        <ul class="nav navbar-nav navbar-right">
            <%
                if (!"".equals(session.getAttribute("username"))) {
            %>
            <li><a href="../profile/profiles.jsp">返回主页</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                   aria-expanded="false"><span class="glyphicon glyphicon-plus"></span><span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="../user/profiles-edit.jsp">修改个人信息</a></li>
                    <li><a href="../user/password-reset.jsp">修改密码</a></li>
                    <li><a href="../mail/sendMail.jsp">站内信</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">One more separated link</a></li>
                </ul>
            </li>
            <li>
                <a href="<s:url namespace="/user" action="logout"/>">注销</a>
            </li>
            <%
            } else {
            %>
            <li>
                <a href="login.jsp">登录</a>
            </li>

            <li>
                <a href="register.jsp">注册</a>
            </li>
            <%
                }
            %>
        </ul>
        <form class="navbar-form navbar-left">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1"><span
                        class="glyphicon glyphicon-search"></span></span>
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
</nav>
</body>
</html>
