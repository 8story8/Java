<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
springmvc fileupload <br><br>
<%-- 파일업로드의 폼은 반드시!!!!! post 전송방식
	   enctype="multipart/form-data" 속성을 부여해야 함
 --%>
<form action="${pageContext.request.contextPath}/multi_fileupload.do" enctype="multipart/form-data" method="post">
<input type="text" name="userInfo"><br>
<input type="file" name="file[0]"><br>
<input type="file" name="file[1]"><br>
<input type="file" name="file[2]"><br>
<input type="submit" value="파일업로드"><br>
</form>










