<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %> 
<c:choose>
 	<c:when test="${sessionScope.mvo == null}">
 		<div class = "header">
		<a href = "index.jsp">Model2 상품 관리</a>
		</div>
 	</c:when>
 	<c:otherwise>
 		<div class = "header">
			<a href = "index.jsp">Model2 상품 관리</a>&nbsp;&nbsp;&nbsp;<a href = "cart.jsp">장바구니 보기</a>
		</div>
 	</c:otherwise>
</c:choose>
