<%--
  Created by IntelliJ IDEA.
  User: Lodour
  Date: 17/5/27
  Time: 00:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>SSH测试</title>
</head>
<body>
    <%
    if ("".equals(session.getAttribute("username"))) {
        response.sendRedirect("/user/login.jsp");
    } else {
        response.sendRedirect("/user/profiles.jsp");
    }
%>
</html>
