<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>회원 관리</title>
	</head>
		<body>
			<h3>Model 1 회원 관리</h3>
 			<%
 				MemberVO mvo=(MemberVO) session.getAttribute("memberVO");
 			
 				if(mvo == null)
 				{
 			%>
					<a href="findMemberById.jsp">아이디로 회원 검색</a><br>
					<a href="findMemberByAddress.jsp">주소로 회원 검색</a><br>
					<a href = "login.jsp">로그인</a><br>
					<a href = "register.jsp">회원가입</a>
			<%} else{%>
					<a href="findMemberById.jsp">아이디로 회원 검색</a><br>
					<a href="findMemberByAddress.jsp">주소로 회원 검색</a><br>
					<%=mvo.getName() %>님 로그인<br>
					 <a href = "logout.jsp">로그아웃</a><br>
	 				<a href = "update.jsp">회원정보 수정</a><br>
 					<a href = "cafe.jsp">카페 가기</a>
			<%} %>
		</body>
</html>