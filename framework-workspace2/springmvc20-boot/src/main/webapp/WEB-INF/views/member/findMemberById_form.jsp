<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>회원 관리 검색폼</h3>
<form action = "${pageContext.request.contextPath}/findMemberById.do">
	아이디 <input type = "text" name = "id">
	<input type = "submit" value = "검색">
</form>