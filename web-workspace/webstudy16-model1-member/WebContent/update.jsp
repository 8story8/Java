<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>회원정보 수정</title>
		</head>
			<body>
			<%MemberVO mvo = (MemberVO) session.getAttribute("memberVO"); %>
			<a href = "index.jsp">홈으로</a><hr>
			<form action = "update_action.jsp" method = "post">
				아이디 <input type = "text" name = "id" value = "<%=mvo.getId()%>" readonly><br>
패스워드 <input type = "text" name = "pw" value = "<%=mvo.getPw()%>" ><br>
이름 <input type = "text" name = "name"  value ="<%=mvo.getName()%>" ><br>
주소 <input type = "text" name = "addr"  value ="<%=mvo.getAddr()%>"><br>
<input type = "submit" value = "회원정보 수정">
</form>
</body>
</html>