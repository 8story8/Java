<%@page import ="model.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step1-session.jsp</title>
</head>
<body>
<%--JSP가 Java(Servlet)로 Web Container가 생성할 때,
       기본적으로 request, session, ServletConfig, ServletContext 객체를 생성하여
       변수에 저장하므로 별도의 생성은 필요없다. --%>
<%=request %><br>
<%=session%><br>
<%=config %><br>
<%=application%><br>
<%--Session에 정보를 할당 --%>
<%session.setAttribute("memberVO", new MemberVO("java", "abcd", "Kir", "도쿄")); %>
<hr>
step1-session.jsp에서 Session에 회원 정보를 할당<br>
<a href = "step2-session.jsp"> step2에서 확인</a>
</body>
</html>