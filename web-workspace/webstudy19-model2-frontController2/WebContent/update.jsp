<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
forward와 redirect 이동 방식 복습
 --%>
<form method = "post" action = "DispatcherServlet">
	닉네임 <input type = "text" name = "nickName">
	<input type = "hidden" name = "command" value = "update">
	<input type = "submit" value = "수정">
</form>
</body>
</html>