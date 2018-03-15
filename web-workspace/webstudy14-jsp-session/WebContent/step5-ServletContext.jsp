<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step5-ServletContext.jsp</title>
</head>
<body>
<b>JSP에서는 ServletContext 객체를 반환받아 application(내장 객체) 변수명에 할당한다.</b>
<br>
<%=application.getContextPath()%>
<br><br>
<b>ServletContext 초기 Parameter 관리자 이메일</b>
<br>
<%=application.getInitParameter("adminEmail") %>
<br><br>
<b>ServletContext에 저장된 정보를 반환</b>
<br>
<%=application.getAttribute("memberInfo") %>
</body>
</html>