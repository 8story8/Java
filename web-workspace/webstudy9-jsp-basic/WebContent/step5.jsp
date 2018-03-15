<%@page import="model.PersonVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP에서 ArrayList 연습</title>
</head>
<body>
<% ArrayList<PersonVO> al = new ArrayList<PersonVO>();
	 al.add(new PersonVO("Kaze", 27));
	 al.add(new PersonVO("Akai", 28));
	 al.add(new PersonVO("Bourbon", 29));
%>
<table border = "1" cellpadding="10">
	<thead>
	<tr>
		<th>이름</th><th>나이</th>
	</tr>
	</thead>
	<tbody>
	<%for(int i = 0; i < al.size(); i++){%>
			<tr>
				<td><%=al.get(i).getName() %></td>
				<td><%=al.get(i).getAge() %></td>
			</tr>
	<%}%>
	</tbody>
</table>
</body>
</html>