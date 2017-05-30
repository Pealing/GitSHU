<%@ taglib prefix="jap" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Pealing
  Date: 2017/5/30
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GitSHU 代码仓库</title>
</head>
<body>
<jap:include value="/components/banner.jsp"/>
<div class="panel panel-default" style="position: fixed;width: 100%;height: 100%;margin-top: 4.5%;">
    <div class="panel-heading">
        <div style="display: inline;">
            <span class="glyphicon glyphicon-user"></span>
            <label id="createUser">cpx</label>
            <label>/</label>
        </div>
        <div style="display: inline;">
            <span class="glyphicon glyphicon-file"></span>
            <label id="profileName">Opencv</label>
        </div>
    </div>
    <div class="panel-body">
        <div class="panel panel-info" style="margin-left: 15%;width: 70%;">
            <div class="panel panel-heading">
                <div>
                    <span class="glyphicon glyphicon-map-marker"></span>
                    <lable id="roadName">听说这个地方是个路径名啊</lable>
                </div>
            </div>
            <div class="panel panel-body">这里可以放文件说明，如果不要的话直接把div删除、</div>
            <table class="table table-striped  table-hover">
                <tr>
                    <th><strong>第一列高越是头猪</strong></th>
                    <th><strong>第二列PX是小仙女</strong></th>
                    <th><strong>第三列是猪爱小仙女</strong></th>
                    <th><strong>第四列是......</strong></th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
