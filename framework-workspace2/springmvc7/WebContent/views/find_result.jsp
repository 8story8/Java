<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp">홈으로</a><br><br>
<hr>
+검색 결과+ <hr>

<table border=2>
<thead>
<tr><th>ID</th><th>NAME</th><th>MAKER</th><th>PRICE</th></tr>
</thead>
<tbody>
<c:forEach items="${requestScope.list }" var="vo">
<tr>
	<td>${vo.id}</td><td>${vo.name}</td>
	<td>${vo.maker}</td><td>${vo.price}</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>