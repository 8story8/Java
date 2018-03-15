<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이템 상세 정보</title>
<link type="text/css" href="css/home.css" rel="stylesheet" />
<script>
	function checkCart() {
		if (confirm("Shopping Cart에 담으시겠습니까?")) {
			location.href = "DispatcherServlet?command=cart&itemNo=${requestScope.ivo.itemNo}";
		}
	}
</script>
</head>
<body>
	<div class="container">
		<jsp:include page="layout/header.jsp"></jsp:include>
		<jsp:include page="layout/left.jsp"></jsp:include>
		<div class="main">
			<table class="listTable">
				<tr>
					<td>No</td>
					<td>${requestScope.ivo.itemNo}</td>
				</tr>
				<tr>
					<td>Name</td>
					<td>${requestScope.ivo.itemName}</td>
				</tr>
				<tr>
					<td>Maker</td>
					<td>${requestScope.ivo.itemMaker}</td>
				</tr>
				<tr>
					<td>Price</td>
					<td>${requestScope.ivo.itemPrice}</td>
				</tr>
				<tr>
					<td>Detail</td>
					<td>${requestScope.ivo.itemDetail}</td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="장바구니 담기" onclick = "checkCart()"></td>
				</tr>
			</table>
		</div>
		<jsp:include page="layout/footer.jsp"></jsp:include>
	</div>
</body>
</html>