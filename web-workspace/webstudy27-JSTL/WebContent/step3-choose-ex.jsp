<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step3-choose-ex</title>
</head>
<body>
<form action = "step4-choose-result.jsp">
	이름 <input type = "text" name = "userName"><br>
	나이 <input type = "text" name = "userAge"><br>
	<input type = "submit" value = "전송">
</form>
<%--
	step4-choose-result.jsp
	19세 이상이면
	~님 ~세 성인입니다.
	13세 이상 19세 미만이면
	~님 ~세 청소년입니다.
	1세 이상 13세 미만이면
	~님 ~세 어린이입니다.
	0세 미만이면
	~님 사람이 아닙니다.
 --%>
</body>
</html>