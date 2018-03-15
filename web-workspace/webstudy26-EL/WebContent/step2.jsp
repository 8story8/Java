<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL param test</title>
</head>
<body>
<a href = "step1.jsp">step1으로 이동</a><br><br>
<b>1. 기존 방식으로 Parameter 출력</b><br>
<%=request.getParameter("memberName") %><br>   <%--null 출력 O--%>
<%=request.getParameter("age") + 1%>   <%--문자열로 인식 211--%>
<br><br><hr><br>
<b>2. EL로 Parameter 출력</b><br>
${param.memberName}<br>   <%--null 출력 X--%>
${param.age + 1}   <%--자동 형변환 22--%>
<br><br><hr><br>
<form action = "step3.jsp">
	<input type = "checkbox" name = "org" value ="Jin">Jin<br>
	<input type = "checkbox" name = "org" value ="Bourbon">Bourbon<br>
	<input type = "checkbox" name = "org" value ="Vermouth">Vermouth<br>
	<input type = "submit" value = "step3에서 호출">
</form>
</body>
</html>