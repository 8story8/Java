<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
	table th, td{
		padding:10px;
		text-align: center;
		border: 2px dotted black;
	}
</style>
<meta charset="UTF-8">
<title>상품 목록 보기</title>
</head>
<body>
<a href = "home.do">Home</a><hr>
<c:choose>
	<c:when test="${lvo == 'isEmpty'}">
		<b>검색 정보가 존재하지 않습니다!</b>
	</c:when>
	<c:otherwise>
		<table>
			<thead>
				<tr>
					<th>아이디</th><th>상품명</th><th>제조사</th><th>가격</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lvo}" var = "lvo">
					<tr>
						<td>${lvo.id}</td>
						<td>${lvo.name}</td>
						<td>${lvo.maker}</td>
						<td>${lvo.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
</body>
</html>