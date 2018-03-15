<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 폼</title>
</head>
<body>
<form action = "findMemberById_action.jsp" method = "get">
	아이디 <input type = "text" name = "id">
	<input type = "submit" value = "검색">
</form>
</body>
</html>