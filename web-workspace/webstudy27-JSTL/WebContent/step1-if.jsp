<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step1-if</title>
</head>
<body>
<c:if test = "true">
	true이므로 실행이 된다.
</c:if>
<c:if test = "false">
	false이므로 실행이 안된다.
</c:if>
<hr>
<a href = "step1-if.jsp?nick=Jin&age=28">현재 페이지를 다시 호출한다.</a><br>
<c:if test = "${param.nick=='Jin' && param.age < 30}">
	${param.nick}은 ${param.age}세입니다.
</c:if>
</body>
</html>