<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카페</title>
</head>
<body>
<% MemberVO mvo = (MemberVO) session.getAttribute("memberVO"); %>
 <%=mvo.getAddr() %>에 사는 <%=mvo.getName() %>님 카페 입장 환영!
 <a href = "logout.jsp">로그아웃</a><hr>
 <a href = "index.jsp">홈으로</a>
</body>
</html>
















