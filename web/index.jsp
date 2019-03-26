<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String basePath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<%= basePath + "/css/index.css" %>">
</head>
<body>
	<div class="login">
        <img src="<c:url value="/image/logo.png" />" alt="智游">
        <p>智游客户关系管理系统</p>
        <form action="<c:url value="/user/login" />" method="post">
            <div>
                <input type="text" id="username" name="username" value="${param.username}" placeholder="请输入用户名">
            </div>
            <div>
                <input type="password" id="password" name="password" value="${param.password}" placeholder="请输入密码">
            </div>
            <div>
            	<%--<p class="error-message">${param.errorMessage}</p>--%>
            	<p class="error-message">${requestScope.errorMessage}</p>
                <input type="submit" value="登录">
            </div>
        </form>
    </div>
    <script>
    	if (window.top !== window) {
    		window.top.location.reload();
    	}
    </script>
</body>
</html>