<%@page import="model.MemberDAO"%>
<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정결과</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String addr = request.getParameter("addr");
boolean flag = MemberDAO.getInstance().updateMember(id, pw, name, addr);%>
<%if(flag == true){
session.setAttribute("memberVO", new MemberVO(id, pw, name, addr));
MemberVO mvo = (MemberVO) session.getAttribute("memberVO");%>
<a href = "index.jsp">홈으로</a><hr>
<%=mvo.getName() %>님 회원정보를 수정하였습니다!<br>
수정 정보<br>
아이디 : <%=mvo.getId()%><br>
비밀번호 : <%=mvo.getPw()%><br>
이름 : <%=mvo.getName()%><br>
주소 : <%=mvo.getAddr()%><br>
<%} else{%>
<script>
	alert("회원정보 수정란을 입력해주세요!");
	location.href = "update.jsp";
</script>
<%} %>
</body>
</html>