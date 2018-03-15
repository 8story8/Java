<%@page import="model.ItemVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
	<a href = "index.jsp">Home</a> &nbsp;&nbsp; <a href = "register_item.jsp">상품 등록</a><hr>
	<%
		ArrayList<ItemVO> list = (ArrayList<ItemVO>) request.getAttribute("list");
		
		if(list.isEmpty() == false){
	%>		
			<table>
				<%for(int i = 0; i < list.size(); i++){ %>
				<tr>
					<td><%=list.get(i).getItemNo() %></td>
					<td><a href = "DispatcherServlet?command=find&itemNo=<%=list.get(i).getItemNo()%>"><%=list.get(i).getItemName() %></a></td>
					<td><%=list.get(i).getItemDate() %></td>
				</tr>
				<%}%>
			</table>
	<%} else{%>
			등록된 상품 정보가 없습니다!
	<%} %>
</body>
</html>