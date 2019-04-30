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
<a id='open'>切换</a>
	<div id=loginForm class='z-form' action="/subLogin" method="post">
			<input class='z-input' name='name' type="text" value="zhong">
			<input class='z-input' name='password' type="password">
			<button id=login class='z-btn'>提交</button>
	</div>
	<div id=registForm class='z-form' action="/regist" method="post">
			<input class='z-input' name='name' type="text" value="zhong">
			<input class='z-input' name='password' type="password">
			<button id=regist class='z-btn'>注册</button>
	</div>
</div>
</body>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/ajaxUntil.js"></script>
<script src="../../js/md5.js"></script>
<script type="text/javascript">
$(function(){
    $('#login').click(function(){
        
        var name=$("#loginForm > input:nth-child(1)").val();
        
        var password=$("#loginForm > input:nth-child(2)").val();
        ajaxUntil.sendPost('/subLogin',{'name':name,'password':hex_md5(password)},function(res){
            console.log(res);
        })
    })
    $('#regist').click(function(){
        
        var name=$("#registForm > input:nth-child(1)").val();
        
        var password=$("#registForm > input:nth-child(2)").val();
        ajaxUntil.sendPost('/regist',{'name':name,'password':hex_md5(password)},function(res){
            console.log(res);
        })
    })
    document.getElementById('registForm').style.display='none';
    document.getElementById('loginForm').style.display='inline-block'
        document.getElementById('open').addEventListener('click',function(){
            if(document.getElementById('loginForm').style.display=='inline-block'){
                document.getElementById('loginForm').style.display='none';
                document.getElementById('registForm').style.display='inline-block'
            }else{
            	
                document.getElementById('loginForm').style.display='inline-block';
                document.getElementById('registForm').style.display='none'
            }
        })
})
</script>
</html>