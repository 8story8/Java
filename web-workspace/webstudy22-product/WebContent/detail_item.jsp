<%@page import="model.ItemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 정보</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<%ItemVO ivo = (ItemVO) request.getAttribute("ivo");%>
<script>
	function deleteItem(){
		if(confirm("상품을 삭제하시겠습니까?")){
			location.href = "DispatcherServlet?command=delete&itemNo=<%=ivo.getItemNo()%>";
		}
	}
</script>
</head>
<body>
<a href = "index.jsp">Home</a> &nbsp;&nbsp; <a href = "DispatcherServlet?command=list">상품 목록</a><hr>
<table>
	<tr>
		<td>상품번호</td>
		<td><%=ivo.getItemNo() %></td>
	</tr>
	<tr>
		<td>상품명</td>
		<td><%=ivo.getItemName() %></td>
	</tr>
	<tr>
		<td>제조사</td>
		<td><%=ivo.getItemMaker() %></td>
	</tr>
	<tr>
		<td>가격</td>
		<td><%=ivo.getItemPrice() %></td>
	</tr>
	<tr>
		<td>등록일시</td>
		<td><%=ivo.getItemDate() %></td>
	</tr>
	<tr>
		<td colspan = "2" align = "center"><input type = "button" value = "삭제" onclick = "deleteItem()"></td>
	</tr>
</table>
</body>
</html>