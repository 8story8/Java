<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 수정</title>
</head>
<body>
<a href = "index.do">Home</a>
<form action = "member_updateMember.do" method = "post">
ID	<input type = "text" name = "id" value = "${sessionScope.mvo.id}" readonly="readonly"><br>
PW <input type = "password" name = "password" value = "${sessionScope.mvo.password}"><br>
Name <input type = "text" name = "name" value = "${sessionScope.mvo.name}"><br>
Address <input type = "text" name = "address" value = "${sessionScope.mvo.address}"><br>
<input type = "submit" value = "수정">
</form>
</body>
</html>