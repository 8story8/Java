<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${sessionScope.mvo != null}">
		<script>
			location.href = "${pageContext.request.contextPath}/index.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("아이디 또는 비밀번호가 일치하지 않습니다!");
			location.href = "${pageContext.request.contextPath}/index.jsp";
		</script>
	</c:otherwise>
</c:choose>
