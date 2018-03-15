<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자동차 목록</title>
</head>
<body>
<a href = "home.do">Home</a><hr>
<table cellpadding = "10" border = "1">
	<thead>
		<tr>
			<th>No</th><th>Model</th><th>Price</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${carList}" var="list">
			<tr>
				<td>${list.no}</td><td>${list.model}</td><td>${list.price}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>