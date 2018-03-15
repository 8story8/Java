<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function logout(){
		location.href = "logout.jsp";
}
</script>
</head>
<body>
<%--로그인 상태가 아니면 로그인 폼을 제공
	   로그인 상태이면 송중기님 로그인--%>
	   
	   <%-- <%HttpSession session = request.getSession(false);%> --%>
	   <%-- <%if(session == null) {%> --%>
<%if(session.getAttribute("id") == null){%>
<form method = "post" action = "login_action.jsp">
<table cellpadding = "15">
	<tr>
	<td>ID</td><td><input type = "text"  name = "id" require = "required"></td>
	</tr>
	<tr>
	<td>PW</td><td><input type = "password"  name = "pw" require = "required"></td>
	</tr>
</table>
<input type = "submit" value = "로그인">
	<%}else{%>
	<%=session.getAttribute("id") %>님 로그인 &nbsp;<input type = "submit" value = "로그아웃" onclick = "logout()">
	<%} %>
</form>
</body>
</html>