<%@ page import="org.gitshu.entity.ProjectEntity" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="jap" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Pealing
  Date: 2017/5/28
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<s:action name="userEntitySet" namespace="/user"/>
<s:action name="projectListJoined" namespace="/project"/>

<jsp:useBean id="userEntity" scope="request" type="org.gitshu.entity.UserEntity"/>
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
                <span class="glyphicon glyphicon-phone"></span> ${userEntity.mobile}<br>
                <span class="glyphicon glyphicon-envelope" style="margin-top: 3%;"></span> ${userEntity.email}
            </div>
        </div>
    </div>
</div>
<%--<script>--%>
<%--location.href = '123';--%>
<%--</script>--%>
<div id="profile_list" style="position: absolute;right: 10%;top: 20%; width: 55%;">
    <%
        List<ProjectEntity> project = (List<ProjectEntity>) request.getAttribute("projects");
        if (project == null)
            out.println("<h3>您当前还没有项目！</h3>");
        else {
            for (int i = 0; i < project.size() - 1; i += 2) {
    %>
    <div class="row" style="margin-top: 3%;">
        <div class="col-md-5 list-group-item" style=" margin-left: 3%;">
            <div style="margin:3% auto;">
                <%
                    out.println("<a href=\"/workflow/workflowView.jsp?projectId=" + project.get(i).getId() + "\"style=\"margin-top: 10%;\">" + project.get(i).getTitle() + "</a>");
                    out.println(" <p style=\"color: #777;font-size: 80%;\">" + project.get(i).getInfo() + "</p>");
                    out.println(" <p style=\"color: #333;font-size: 80%;\">" + new Date(project.get(i).getCreateTime().getTime()) + "</p>");
                %>
            </div>
        </div>
        <div class="col-md-5 list-group-item" style="margin-left: 3%;">
            <div style="margin:3% auto;">
                <%
                    out.println("<a href=\"/workflow/workflowView.jsp?projectId=" + project.get(i + 1).getId() + "\"style=\"margin-top: 10%;\">" + project.get(i + 1).getTitle() + "</a>");
                    out.println(" <p style=\"color: #777;font-size: 80%;\">" + project.get(i + 1).getInfo() + "</p>");
                    out.println(" <p style=\"color: #333;font-size: 80%;\">" + new Date(project.get(i + 1).getCreateTime().getTime()) + "</p>");
                %>
            </div>
        </div>
    </div>
    <%
        }
        if (project.size() % 2 != 0) {
    %>
    <div class="row" style="margin-top: 3%;">
        <div class="col-md-5 list-group-item" style="margin-left: 3%;">
            <div style="margin:3% auto;">
                <%
                    out.println("<a href=\"/workflow/workflowView.jsp?projectId=" + project.get(project.size() - 1).getId() + "\"style=\"margin-top: 10%;\">" + project.get(project.size() - 1).getTitle() + "</a>");
                    out.println(" <p style=\"color: #777;font-size: 80%;\">" + project.get(project.size() - 1).getInfo() + "</p>");
                    out.println(" <p style=\"color: #333;font-size: 80%;\">" + new Date(project.get(project.size() - 1).getCreateTime().getTime()) + "</p>");
                %>
            </div>
        </div>
    </div>
    <%
            }
        }
    %>


</div>
</body>
</html>
