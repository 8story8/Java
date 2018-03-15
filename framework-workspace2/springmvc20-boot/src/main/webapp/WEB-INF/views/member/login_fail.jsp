<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("입력하신 회원 정보가 올바르지 않습니다!");
	location.href = "${pageContext.request.contextPath}/home.do";
</script>