<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<link type="text/css" href="css/home.css" rel="stylesheet" />
<script>
	function deleteItem(itemNo){
		location.href = "DispatcherServlet?command=delete&itemNo="+itemNo;
	}
</script>
</head>
<body>
	<div class="container">
		<jsp:include page="layout/header.jsp"></jsp:include>
		<jsp:include page="layout/left.jsp"></jsp:include>
		<div class="main">

			<table class="listTable">
				<caption>Shopping Cart</caption>
				<c:set var="sum" value="0" />
				<c:forEach items="${sessionScope.cartList}" var="cartList">
					<tr>
						<td>${cartList.itemNo}</td>
						<td>${cartList.itemName}</td>
						<td>${cartList.itemMaker}</td>
						<td>${cartList.itemPrice}</td>
						<td><input type="button" value="삭제" onclick = "deleteItem(${cartList.itemNo})"></td>
						<c:set var="sum" value="${sum + cartList.itemPrice}" />
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5">총액 : ${sum}</td>
				</tr>
			</table>
		</div>
		<jsp:include page="layout/footer.jsp"></jsp:include>
	</div>
</body>
</html>