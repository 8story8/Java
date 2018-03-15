<%@page import="model.MemberDAO"%>
<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
MemberVO mvo = MemberDAO.getInstance().login(id, pw);%>
<%if(mvo != null){%>
	<%session.setAttribute("memberVO", mvo);%>
	<%=mvo.getId() %>님 Login OK!<br>
	<a href = "cafe.jsp">카페 가기</a><hr>
	<a href = "index.jsp">홈으로</a>
<% }else{%>
	<script>
		alert("Login Failure!");
		location.href = "index.jsp";
	</script>
<%}%>
</body>
</html>