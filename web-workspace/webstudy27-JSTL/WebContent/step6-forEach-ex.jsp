<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.*, java.util.*"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%ArrayList<MemberVO> list = new ArrayList<MemberVO>();
	list.add(new MemberVO("kir", "1234", "1", "도쿄"));
	list.add(new MemberVO("kid", "4321", "2", "판교"));
	list.add(new MemberVO("jin", "abcd", "3", "도쿄"));
	request.setAttribute("memberList", list);
	request.setAttribute("address", "도쿄");
%>
<html>
<head>
<meta charset="UTF-8">
<title>jstl forEach test</title>
<style>
	table{
		border-collapse: collapse;
		text-align:center;
	}
	table, th, td{
		border: 1px solid black;
	}
	th, td{
		padding: 15px;
	}
</style>
</head>
<body>
<table>
	<tr>
		<th>번호</th><th>아이디</th><th>이름</th><th>주소</th>
	</tr>
	<c:forEach items = "${requestScope.memberList}" var = "person" varStatus="order">
		<c:if test="${person.address == requestScope.address}">
			<tr>
				<td>${order.count}</td>
				<td>${person.id}</td>
				<td>${person.name}</td>
				<td>${person.address}</td>
			</tr>
		</c:if>
	</c:forEach>
</table>
</body>
</html>