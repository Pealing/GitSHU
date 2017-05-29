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
    <title>GitSHU 个人信息</title>
</head>
<body>
<jap:include value="/components/banner.jsp"/>
<div>
    <div id="ueserinfo" style="position: absolute;left: 10%;top: 20%;width: 20%;">
        <div style="width: 100%;">
            <img src="${pageContext.request.contextPath}/static/image/avatar.jpg" style="width: 200px;height: 200px;"/>
        </div>
        <div>
            <h3 id=profile_username>用户名称</h3>
            <div>
                <span class="glyphicon glyphicon-phone"></span> 1871772398<br>
                <span class="glyphicon glyphicon-envelope" style="margin-top: 3%;"></span> pealing@shu.edu.cn
            </div>
        </div>
    </div>
</div>

<div id="profile_list" style="position: absolute;right: 10%;top: 20%; width: 55%;">
    <div class="row">
        <div class="col-md-5 list-group-item" style="margin-left: 3%;">
            <div style="margin:3% auto;"><a href="http://www.baidu.com" style="margin-top: 10%;">The opencv</a></div>
            <p style="color: #777;font-size: 80%;">OpenCv的项目</p>
        </div>
        <div class="col-md-5 list-group-item" style="margin-left: 3%;">.col-md-6</div>
    </div>
</div>
</body>
</html>
