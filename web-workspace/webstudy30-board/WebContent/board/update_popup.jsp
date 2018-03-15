<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/board.css" type="text/css">
<script type="text/javascript">
function updateAction(){
	var pass=document.updateCheckForm.password.value;
	if(pass==""){
		alert("패스워드를 입력하세요!");
	}else{
		document.updateCheckForm.submit();
	}	
}
</script>
</head>
<body>
<form  action="${pageContext.request.contextPath}/DispatcherServlet" name="updateCheckForm" method="post">
<input type="hidden" name="command" value="updateCheckPassword">
<input type="hidden" name="no" value="${param.no}">
패스워드 : <input type=password name=password></input><br></br>
<input type=button value=수정하기 onclick="updateAction()"></input>
<input type=button value=창끄기 onclick='javascript:self.close()'>
</form>
</body>
</html>




















