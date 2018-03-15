<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.PersonVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP에서 VO 객체 사용</title>
</head>
<body>
<% PersonVO pvo = new PersonVO("Kir", 25); %>
<table border = "1" cellpadding="10">
	<thead>
		<tr>
			<th>이름</th><th>나이</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><%=pvo.getName() %></td><td><%=pvo.getAge() %></td>
		</tr>
	</tbody>
</table>
</body>
</html>