<%@ taglib prefix="jap" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.List" %>
<%@ page import="org.gitshu.entity.MailEntity" %>
<%@ page import="java.sql.Date" %><%--
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

    <script src="${pageContext.request.contextPath}/static/js/inbox_validation.js"></script>
    <title>GitSHU 收件箱</title>
</head>
<body>
<div id="cover" style="width: 100%;height: 100%;background-color: rgba(0,0,0,0.3);z-index: 1000;display: block;position: absolute;visibility: hidden;"></div>
<jap:include value="/components/banner.jsp"/>
<jap:include value="/components/mail_menu_left.jsp"/>
<s:action name="inbox" namespace="/mail"/>
<div style="position: absolute;left: 35%;top: 15%;width: 53%;">
    <h1>收件箱</h1>
    <h3><small>———————————————————————————————————————————</small></h3>
    <div id="inbox_content_show" style="visibility: hidden;">
        <div class="panel panel-info"style=" position:absolute; top: 15%;left: 1%; width: 80%;z-index: 1013;">
            <div class="panel panel-heading">信件内容</div>
            <div class="panel panel-body">
                <label id="inbox_content_show_body"></label>
            </div>
            <div class="panel panel-footer" style="text-align: center;">
                <button id="close" class="btn btn-link"><span class="glyphicon glyphicon-remove-circle"></span></button>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Table -->
        <table class="table table-striped">
            <tr>
                <td><strong>序号</strong></td>
                <td><strong>收件人</strong></td>
                <td><strong>发送时间</strong></td>
                <td><strong>发送内容</strong></td>
                <td><strong>状态</strong></td>

            </tr>
            <%
                int index = 0;
                String s;
                List<?> inbox = (List<?>) request.getAttribute("inbox");
                if (inbox == null) {
                    out.println("<tr><td colspan='5'  style=\"text-align: center;\">尚未收到邮件</td></tr>");
                }
                else {
                    for (Object mailObj : inbox) {
                        s = "" + (index++);
                        out.println("<tr>");
                        MailEntity mailEntity = (MailEntity) mailObj;
                        out.println("<td>" + s + "</td>");
                        out.println("<td>" + mailEntity.getUserByAuthor().getUsername() + "</td>");
                        out.println("<td>" + new Date(mailEntity.getCreateTime().getTime())  + "</td>");
                        out.println("<td><button id='" + mailEntity.getId() +"' class = 'btn btn-success'>查看</button></td>");
                        if(mailEntity.getIsRead() == 0)
                        {
                            out.println("<td>" + "未读" + "</td>");
                        }
                        else
                        {
                            out.println("<td>" + "已读" + "</td>");
                        }
                        out.println("</tr>");
                    }
                }
            %>
        </table>
    </div>
</div>
</body>
</html>
