<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>상품 등록 폼</h3>
<%-- 파일 업로드시에 enctype과 method post를 확인해야함 --%>
<form enctype="multipart/form-data" action = "${pageContext.request.contextPath}/multi_fileupload.do" method = "post">
	사용자명 <input type = "text" name = "userInfo"><br>
	파일1 <input type = "file" name = "file[0]"><br>
	파일2 <input type = "file" name = "file[1]"><br>
	파일3 <input type = "file" name = "file[2]"><br>
	<input type = "submit" value = "등록">
</form>