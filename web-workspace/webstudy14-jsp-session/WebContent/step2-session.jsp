<%@page import ="model.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 내장 객체 session</title>
</head>
<body>
<%MemberVO mvo = (MemberVO) session.getAttribute("memberVO");%>
<%--Session에 MemberVO 정보가 있으면 아래와 같이 출력
	   Session에 있는 회원 정보
	   아이디 : java   이름 : Kir   주소 : 도쿄
	   Session에 MemberVO 정보가 없으면 아래와 같이 출력
	   Session에 회원 정보가 없습니다. alert후
	   step1-session.jsp로 이동시킨다. --%>
<%if(mvo != null){%>	   
  		아이디 : <%=mvo.getId() %><br>
	   이름 : <%=mvo.getName() %><br>
	   주소 : <%=mvo.getAddress() %><br>
	   <a href = "step3-session.jsp">step3-session으로 이동</a>
<% } else{%>
	<script>
		alert("Session에 회원 정보가 없습니다!");  
		location.href = "step1-session.jsp";
	</script>
<%} %>
</body>
</html>