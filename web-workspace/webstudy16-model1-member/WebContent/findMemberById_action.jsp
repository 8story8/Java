<%@page import="model.MemberDAO"%>
<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 검색 결과</title>
</head>
<body>
<%
String id = request.getParameter("id");
MemberVO mvo = MemberDAO.getInstance().findMemberById(id);
if(mvo != null){
%>
	<%=mvo.getName() %>님 회원정보입니다!<hr>
	아이디 : <%=mvo.getId() %><br>
	이름 : <%=mvo.getName() %><br>
	주소 : <%=mvo.getAddr() %><br>
<%} else{%>
	<script type="text/javascript">
 		alert("<%=id%> 아이디에 해당하는 회원은 존재하지 않습니다!");
 		location.href="index.jsp";
 	</script>
<%} %>
</body>
</html>