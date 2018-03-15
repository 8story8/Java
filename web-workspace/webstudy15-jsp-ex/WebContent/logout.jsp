<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	alert("<%=session.getAttribute("id")%>님 로그아웃");
	<%session.invalidate();%>
	location.href = "index.jsp";
</script>