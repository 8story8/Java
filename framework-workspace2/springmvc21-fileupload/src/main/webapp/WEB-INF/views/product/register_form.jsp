<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>상품 등록 폼</h3>
<%-- 파일 업로드시에 enctype과 method post를 확인해야함 --%>
<form enctype="multipart/form-data" action = "${pageContext.request.contextPath}/registerProduct.do" method = "post">
	상품명 <input type = "text" name = "name"><br>
	이미지 <input type = "file" name = "uploadFile"><br>
	<input type = "submit" value = "등록">
</form>