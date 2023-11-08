<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Post, java.util.List" %>
<%
	//ユーザ情報取得
	User loginUser = (User) session.getAttribute("loginUser");
	//投稿リスト取得
	List<Post> postList =
		(List<Post>) application.getAttribute("postList");
	//エラーメッセージ取得
	String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>micro blog</title>
</head>
<body>
<h1>main</h1>
<p>
user : <%= loginUser.getName() %>
<a href="/microblog/Logout">logout</a>
</p>
<p>
<a href="/microblog/Main">Reload</a>
</p>
<form action="/microblog/Main" method="post">
<input type="text" name="text">
<input type="submit" value="submit">
</form>
<% if (errorMsg != null) { %>
<p><%= errorMsg %></p>
<% } %>
<% for(Post post : postList) {%>
	<p><%= post.getUserName() %> : <%= post.getText() %></p>
<% } %>
</body>
</html>