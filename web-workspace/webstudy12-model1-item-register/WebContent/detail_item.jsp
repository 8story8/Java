<%@page import="model.ItemVO"%>
<%@page import="model.ItemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이템 상세</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
<h3>아이템 상세  <a href = "index.jsp">Home</a></h3>
<% 
String itemNo = request.getParameter("itemNo");
ItemVO vo=ItemDAO.getInstance().findItemByNo(itemNo);
%>
<table>
	<tr>
		<td>NO</td><td><%=vo.getItemNo() %></td>
	</tr>
	<tr>
		<td>Name</td><td><%=vo.getName() %></td>
	</tr>
	<tr>
		<td>Maker</td><td><%=vo.getMaker() %></td>
	</tr>
	<tr>
		<td>Price</td><td><%=vo.getPrice() %></td>
	</tr>
</table>
</body>
</html>









