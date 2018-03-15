<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이템 등록</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
<form method="post" action="register_action.jsp">
상품명 <input type="text" name="name" required="required"><br>
제조사 <input type="text" name="maker" required="required"><br>
가 격&nbsp;&nbsp;&nbsp;<input type="text" name="price" required="required"><br>
<input type="submit" value="등록하기">
</form>
</body>
</html>