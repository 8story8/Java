<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#listBtn").click(function(){
		location.href = "carList.do";
	});
});
</script>
</head>
<body>
<h3>자동차 총 ${totalCarCount}대</h3>
<input type = "button" value = "자동차 목록 보기" id = "listBtn">
<%--carList.jsp에서 전체 자동차 목록을 제공한다.--%>
</body>
</html>