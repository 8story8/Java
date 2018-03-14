<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이템 등록 Form</title>
<link type="text/css" href="css/home.css" rel="stylesheet" />
</head>
<body>
<div class = "container">
		<jsp:include page = "layout/header.jsp"></jsp:include>
		<jsp:include page = "layout/left.jsp"></jsp:include>
		<div class = "main">
		<form action = "DispatcherServlet" method = "post">
		<input type = "hidden" name = "command" value = "register">
			<table class = "listTable">
				<tr>
					<td>Name</td>
					<td><input type = "text" name = "name" size = "10"></td>
				</tr>
				<tr>
					<td>Maker</td>
					<td><input type = "text" name = "maker" size = "10"></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type = "text" name = "price" size = "10"></td>
				</tr>
				<tr>
					<td>Detail</td>
					<td><input type = "text" name = "detail" size = "20"></td>
				</tr>
				<tr>
					<td colspan = "2"><input type = "submit" value = "상품 등록"></td>
				</tr>
			</table>
		</form>
		</div>
		<jsp:include page = "layout/footer.jsp"></jsp:include>
	</div>
</body>
</html>