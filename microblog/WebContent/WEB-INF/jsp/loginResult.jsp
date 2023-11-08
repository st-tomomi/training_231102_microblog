<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>micro blog</title>
</head>
<body>
<% if(loginUser != null) { %>
	<p>Login successful</p>
	<p>user : <%= loginUser.getName() %></p>
	<a href="/microblog/Main">posts</a>
<% } else { %>
	<p>Login failed</p>
	<a href="/microblog/">return to TOP</a>
<% } %>
</body>
</html>