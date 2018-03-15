<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.mvo != null}">
		    &nbsp; <a href = "${pageContext.request.contextPath}/index.jsp">홈</a> | <a href = "${pageContext.request.contextPath}/board/write.jsp">글쓰기</a> | ${sessionScope.mvo.name}님 | <a href = "${pageContext.request.contextPath}/DispatcherServlet?command=logout">로그아웃</a>
	</c:when>
	<c:otherwise>
		<form action="DispatcherServlet" method="post">
			<input type="hidden" name="command" value="login"> 
			&nbsp; 아이디 <input type="text" name="mid"> 
			&nbsp; 비밀번호 <input type="password" name="mpass"> 
			&nbsp; <input type="submit" value="로그인">
		</form>
	</c:otherwise>
</c:choose>


