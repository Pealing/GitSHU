<%--
  Created by IntelliJ IDEA.
  User: Pealing
  Date: 2017/5/29
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script stc="js/npm.js
    "></script>

    <!--表单验证-->
    <link href="${pageContext.request.contextPath}/static/css/validationEngine.jquery.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery.validationEngine-zh_CN.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery.validationEngine.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/main_validation.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>GitSHU Menu</title>
</head>
<body>
<div id="Menu" class="list-group" style="position: absolute; left:10%;top: 15%;width: 20%;">
    <div class="panel panel-default">
        <div class="panel-heading">GitSHU</div>
        <div class="list-group" style="margin: 0 auto;">
            <a href="${pageContext.request.contextPath}/mail/inBox.jsp" class="list-group-item">收件箱</a>
            <a href="${pageContext.request.contextPath}/mail/outBox.jsp" class="list-group-item">发件箱</a>
            <a href="${pageContext.request.contextPath}/mail/sendMail.jsp" class="list-group-item">写邮件</a>
        </div>
    </div>
</div>

</body>
</html>
