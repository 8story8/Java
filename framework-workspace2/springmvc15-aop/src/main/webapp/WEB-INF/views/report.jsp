<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색어 통계</title>
<style>
table th, td {
	padding: 10px;
	text-align: center;
	border: 2px dotted black;
}
</style>
</head>
<body>
	<a href="home.do">Home</a>
	<hr>

	<table>
		<thead>
			<tr>
				<th>순위</th>
				<th>검색어</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rvo}" var = "rvo">
				<tr>
					<td>${rvo.RANK}</td>
					<td>${rvo.KEYWORD}</td>
					<td>${rvo.COUNT}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>