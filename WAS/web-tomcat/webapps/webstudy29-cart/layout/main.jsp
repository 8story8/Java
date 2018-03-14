<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<div class = "main">
	<table class = "listTable">
		<tr>
			<th>No</th><th>Name</th><th>Maker</th>
		</tr>
		<c:forEach items = "${requestScope.list}"  var = "itemList">
		<tr>
			<td><a href ="DispatcherServlet?command=find&itemNo=${itemList.itemNo}">${itemList.itemNo}</a></td>
			<td>${itemList.itemName}</td>
			<td>${itemList.itemMaker}</td>
		</tr>
		</c:forEach>
	</table>
</div>


