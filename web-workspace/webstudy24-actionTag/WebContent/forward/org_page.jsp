<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>간부 홈페이지</title>
<style>
	body{
		background-color: black;
	}
	
	h2, h4{
		color: white;
	}
</style>
</head>
<body>
<h2>Code가 <%=request.getParameter("code") %>인 조직 간부입니다.</h2>
<h4>Command는 <%=request.getParameter("command") %>입니다.</h4>
</body>
</html>