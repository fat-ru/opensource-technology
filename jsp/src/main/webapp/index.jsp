<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 演示</title>
</head>
<body>
<h2>你好，JSP！</h2>

<p>这是一个简单的 JSP 页面。</p>

<!-- 脚本段：这里的代码在服务器上运行 -->
<%
    String message = "这是一个来自 Java 变量的消息。";
    int a = 10;
    int b = 20;
%>

<!-- 表达式部分 -->
<p>来自 Java 的消息: <strong><%= message %></strong></p>
<p>计算结果: 10 + 20 = <strong><%= a + b %></strong></p>

<hr>
<p>你的 IP 地址是 (通过 JSP 隐式对象获取): <%= request.getRemoteAddr() %></p>
<p>当前时间: <%= new java.util.Date() %></p>

</body>
</html>