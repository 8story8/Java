<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward test</title>
</head>
<body>
<%
	int code = Integer.parseInt(request.getParameter("code"));
	if(code < 19){
%>		
	<h2>Code가 <%=code %>인 조직원입니다.</h2>
<% }else{%>
	<jsp:forward page = "org_page.jsp">
		<jsp:param value="7" name="command"/>
	</jsp:forward>
<%} %>
</body>
</html>