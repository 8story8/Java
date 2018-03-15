<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<h3>파일 업로드 완료</h3>
<c:forEach items = "${nameList}" var = "fileName">
	<a href = "${pageContext.request.contextPath}/fileDownload.do?fileName=${fileName}">${fileName}</a><br>
</c:forEach>