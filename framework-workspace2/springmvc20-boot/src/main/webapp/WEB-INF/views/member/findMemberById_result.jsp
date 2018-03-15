<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<h3>회원 관리 검색 결과</h3>
<c:choose>
	<c:when test="${result != null}">
		${result}
	</c:when>
	<c:otherwise>
		검색 결과 정보가 존재하지 않습니다!
	</c:otherwise>
</c:choose>
