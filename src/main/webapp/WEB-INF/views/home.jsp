<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<span class='header-title'>某某平台</span>
<form action="/subLogin" method="post">
		<input name='name' type="text" value="admin">
		<input name='password' type="password">
		<input type="submit" value="提交">
</form>
</body>
</html>