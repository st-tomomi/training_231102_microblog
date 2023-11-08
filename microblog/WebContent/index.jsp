<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>micro blog</title>
</head>
<body>
<h1>What's up?</h1>
<form action="/microblog/Login" method="post">
user name : <input type="text" name="name"><br>
password : <input type="password" name="pass"><br>
<input type="submit" value="login">
</form>
</body>
</html>