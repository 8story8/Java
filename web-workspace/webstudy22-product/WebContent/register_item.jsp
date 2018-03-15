<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
<a href = "index.jsp">Home</a>&nbsp;&nbsp;
<a href = "DispatcherServlet?command=list">상품 목록</a><hr>

<form action = "DispatcherServlet" method = "post">
	<input type = "hidden" name = "command" value = "register">
	상품명 &nbsp; <input type = "text" name = "name"><br>
	제조사 &nbsp; <input type = "text" name = "maker"><br>
	가 격 &nbsp; &nbsp; <input type = "text" name = "price"><br>
	<input type = "submit" value = "등록">
</form>

</body>
</html>