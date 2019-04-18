<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=yes">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="telephone=no" name="format-detection">
<meta content="-1" http-equiv="Expires">
<meta content="no-cache" http-equiv="Cache-Control">
<meta content="no-cache" http-equiv="Pragma">
<meta name="theme-color" content="#ffffff">
<meta name="full-screen" content="true" />
<meta name="screen-orientation" content="portrait"/>
<meta name="x5-fullscreen" content="true" />
<meta name="360-fullscreen" content="true" />
<link rel="stylesheet" href="./css/style.css?Version=<%=(new java.util.Date()).toLocaleString()+1%>">
<script>
    _resize();
    window.addEventListener('resize', _resize, false);
    function _resize() {
        var html = document.documentElement;
        var windowWidth = html.clientWidth;
        if(windowWidth > 750){
            windowWidth = 750;
        }
        html.style.fontSize = windowWidth / 7.5 + 'px';
    }
</script>
<head>
	<title></title>
</head>
<body>
<span></span>
<div class='header-content'>
	<form class='z-form' action="/subLogin" method="post">
			<input class='z-input' name='name' type="text" value="admin">
			<input class='z-input' name='password' type="password">
			<button class='z-btn' type="submit">提交</button>
	</form>
</div>
</body>
</html>