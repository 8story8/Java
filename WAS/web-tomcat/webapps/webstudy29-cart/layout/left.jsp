<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %> 
 <c:choose>
 	<c:when test="${sessionScope.mvo == null}">
 	<div class = "left">
		<form method = "post" action="DispatcherServlet">
			<table class = "loginTable">
				<tr>
					<th>아이디</th>
					<td><input type = "text" name = "id" size = "8"></td>
					<input type="hidden" name="command" value="login">
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type = "password" name = "pw" size = "8"></td>
				</tr>
				<tr>
					<td colspan = "2" align = "right"><input type = "submit" value = "로그인"></td>
				</tr>
			</table>
			</form>
		</div>
 	</c:when>
 	<c:otherwise>
 		<div class = "left">
			${sessionScope.mvo.name}님 Login<br>
 			<a href = "DispatcherServlet?command=logout">Logout</a><br>
 			<a href = "item_register.jsp">상품 등록</a>
		</div>
 	</c:otherwise>
 </c:choose> 
	