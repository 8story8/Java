<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>상품 등록 완료</h3>
상품명 : ${name}<br>
<a href = "${pageContext.request.contextPath}/fileDownload.do?fileName=${fileName}">${fileName}</a>
상품 이미지 : <img src = "${pageContext.request.contextPath}/resources/upload/${fileName}">
