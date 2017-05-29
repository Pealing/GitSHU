<%@ taglib prefix="jap" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Pealing
  Date: 2017/5/29
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.10.2.min.js"></script>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script stc="js/npm.js"></script>

    <!--表单验证-->
    <link href="${pageContext.request.contextPath}/static/css/validationEngine.jquery.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery.validationEngine-zh_CN.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery.validationEngine.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/sendmail_validation.js"></script>

    <title>GitSHU 发送邮件</title>
</head>
<body>
<jap:include value="/components/banner.jsp"/>
<jap:include value="../components/mail_menu_left.jsp"/>
<div style="position: absolute;left: 35%;top: 15%;width: 53%;">
    <h1>写信</h1>
    <h3><small>———————————————————————————————————————————</small></h3>
    <form id="sendMail_form" action="<s:url namespace="/mail" action="sendMail"/>" method="post">
        <div class="form-group">
            <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
            <label>Receiver</label>
            <input type="text" class="form-control validate[required]" id="sendMail_receiver" name="username" placeholder=""/>
        </div>
        <div class="form-group">
            <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
            <label>Content</label>
            <textarea id="sendMail_content" name="content" class="form-control  validate[required]" rows="3"></textarea>
        </div>
        <button id="sendMail_submit" type="submit" class="btn btn-success">Send</button>
        <button id="sendMail_reset" class="btn btn-danger">Reset</button>
    </form>
</div>

</body>
</html>
