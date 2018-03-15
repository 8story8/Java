<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request getParameterValues(), paramValues</title>
</head>
<body>
<%-- <%=request.getParameter("org")%> --%>
<%
	String oa[] = request.getParameterValues("org");
%>
<%=oa[0] %>, <%=oa[1] %>, <%=oa[2] %>
<br><br><hr><br>
${paramValues.org[0]}, ${paramValues.org[1]}, ${paramValues.org[2]} 
</body>
</html>