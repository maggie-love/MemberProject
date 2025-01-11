<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../style.css"><!-- html指令 -->
</head>
<body>
<div id="title"><jsp:include page="/title.jsp"/></div><!-- java指的是webapp -->
<div id="content">
<h1>會員管理</h1>
<a href="../LogoutController">登出</a> <!-- 網頁用../回 -->
</div>
<div id="footer"><jsp:include page="/footer.jsp"/></div>
</body>
</html>