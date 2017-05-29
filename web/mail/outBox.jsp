<%@ page import="org.gitshu.entity.MailEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Date" %>
<%@ taglib prefix="jap" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Pealing
  Date: 2017/5/29
  Time: 23:48
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
    <title>GitSHU 收件箱</title>
</head>
<body>
<jap:include value="/components/banner.jsp"/>
<jap:include value="/components/mail_menu_left.jsp"/>
<s:action name="outbox" namespace="/mail"/>
<div style="position: absolute;left: 35%;top: 15%;width: 53%;">
    <h1>发件箱</h1>
    <h3><small>———————————————————————————————————————————</small></h3>
    <div class="panel panel-default">
        <!-- Table -->
        <table class="table table-striped">
            <tr>
                <td><strong>序号</strong></td>
                <td><strong>收件人</strong></td>
                <td><strong>发送时间</strong></td>
                <td><strong>发送内容</strong></td>

            </tr>
            <%
                int index = 0;
                String s;
                List<?> outbox = (List<?>) request.getAttribute("outbox");
                if (outbox == null) {
                    out.println("<tr><td colspan='4'  style=\"text-align: center;\">尚未发送邮件</td></tr>");
                }
                else {
                    for (Object mailObj : outbox) {
                        s = "" + (index++);
                        out.println("<tr>");
                        MailEntity mailEntity = (MailEntity) mailObj;
                        out.println("<td>" + s + "</td>");
                        out.println("<td>" + mailEntity.getUserByReceiver().getUsername() + "</td>");
                        out.println("<td>" + new Date(mailEntity.getCreateTime().getTime())  + "</td>");
                        out.println("<td>" + mailEntity.getContent() + "</td>");
                        out.println("</tr>");
                    }
                }
            %>
        </table>
    </div>
</div>
</body>
</html>
