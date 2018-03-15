<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원검색</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
<a href="index.jsp">홈</a><hr>
	<form name="findForm" method="get" action="DispatcherServlet">
		<input type="hidden" name="command" value="findMemberById"> 		
		아이디 : <input type="text" name="memberId" required="required"> 
		<input type="submit" value="검색">
	</form>
</body>
</html>











