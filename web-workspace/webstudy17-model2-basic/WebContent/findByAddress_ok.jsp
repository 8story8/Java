<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%ArrayList<String> list = (ArrayList<String>) request.getAttribute("list"); %>
<%String addr = (String) request.getAttribute("addr");%>
<body>
	<b><%=addr %>에 사는 회원 명단</b><br>
	
	<%for(int i = 0; i < list.size(); i++){%>
		<%=list.get(i)%><br>
	<% }%>
</body>
</html>