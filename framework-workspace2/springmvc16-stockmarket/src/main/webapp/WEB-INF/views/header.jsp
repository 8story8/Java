<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.cvo==null}">
		<form method="post" action="login.do">
			아이디 <input type="text" name="id"> &nbsp;&nbsp; 
			비밀번호 <input type="password" name="password"> 
			<input type="submit" value="로그인">
		</form>
	</c:when>
	<c:otherwise>
		${sessionScope.cvo.address}에 사는 ${sessionScope.cvo.name}님 
		<input type="button" id="logoutBtn" value="로그아웃">
	</c:otherwise>
</c:choose>
