<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Boot JSP Demo</title>
</head>
<body>
<h1>欢迎来到 Spring Boot JSP 页面</h1>

<p>消息: <strong>${message}</strong></p>

<hr>

<h2>待办列表:</h2>
<ul>
    <c:forEach var="item" items="${tasks}">
        <li>${item}</li>
    </c:forEach>
</ul>
</body>
</html>