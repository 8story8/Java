<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- spring security custom tag를 사용하기 위한 선언 --%>
<%@taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>   
 <sec:authorize ifAnyGranted="ROLE_MEMBER,ROLE_ADMIN">
 <form method="post" action="${pageContext.request.contextPath}/updateMemberAction.do">
		<input type="hidden" name="command" value="update">
		아이디 : <input type="text" name="id" value="<sec:authentication property="principal.id"/>" readonly>
		<br>패스워드 : <input type="text" name="password" >	
		<br>이름 : <input type="text" name="name" 
		value="<sec:authentication property="principal.name"/>" >	
		<br>주소 : <input type="text" name="address" 
		value="<sec:authentication property="principal.address"/>" >	
		<br><input type="submit" value="회원정보수정">
		</form>
</sec:authorize>
<h3>회원정보수정</h3>
		
