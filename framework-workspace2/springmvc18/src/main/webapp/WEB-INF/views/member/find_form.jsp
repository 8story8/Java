<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>회원 검색폼 화면</h3>
<%-- 
	Controller에서는 아이디가 bourbon이면 아무로 토오루 Tokyo로 응답하고,
	그렇지 않으면 검색 정보가 없습니다로 응답한다.
	views/member/findMemberById_result.jsp(Tiles 적용)
--%>
<form action = "${pageContext.request.contextPath}/findMemberById.do">
	아이디 <input type = "text" name = "id">
	<input type = "submit" value = "검색">
</form>