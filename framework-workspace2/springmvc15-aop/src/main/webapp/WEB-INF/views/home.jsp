<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery.min.js"></script> 
<meta charset="UTF-8">
<title>홈</title>
<script>
	$(document).ready(function(){
		$("#searchBtn").click(function(){
			var type = $(":input[name=type]").is(":checked");
			var search = $(":input[name=keyword]").val();
			if(type == false){
				alert("검색 조건을 선택해주세요!");
			}
			
			if(search == ""){
				alert("검색어를 입력해주세요!");
			}
			
			if(type == true && search !== ""){
				$("#searchForm").submit();
			}
		});
	});
</script>
</head>
<body>
<h3>상품 서비스</h3><br>
<form method = "post" action = "registerProduct.do">
	상품명 <input type = "text" name = "name" required = "required"><br>
	제조사 <input type = "text" name = "maker" required = "required"><br>
	가격 <input type = "text" name = "price" required = "required"><br>
	<input type = "submit" value = "상품등록">
</form>
<br><br><br>
<form method = "post" action = "findProductListByType.do" id = "searchForm">
	<input type = "radio" name = "type" value = "findProductListByName">상품명<br>
	<input type = "radio" name = "type" value = "findProductListByMaker">제조사<br>
	<input type = "search" name = "keyword" size = "8">
	<input type = "button" value = "검색" id = "searchBtn">
</form>
<h3>회원 서비스 등 여러 검색 서비스가 있다고 가정한다.</h3>
<br><br><br>
<a href = "report.do">검색어 통계 보기</a>
</body>
</html>