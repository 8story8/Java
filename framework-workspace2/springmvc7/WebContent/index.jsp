<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#regForm").submit(function(){
			if ($("#regForm :input[name=name]").val() == "") {
				alert("상품명을 입력하세요!");
				return false;
			} else if ($("#regForm :input[name=maker]").val() == "") {
				alert("제조사를 입력하세요!");
				return false;
			} else if ($("#regForm :input[name=price]").val() == "") {
				alert("가격을 입력하세요!");
				return false;
			} else if (isNaN($("#regForm :input[name=price]").val())) {
				alert("가격을 숫자로 입력하세요!");
				return false;
			}

		});
		$("#findForm").submit(function() {
			if ($("#findForm :input[name=word]").val() == "") {
				alert("검색어를 입력하세요!");
				return false;
			}
		});
	});
</script>
</head>
<body>
*상품 등록*<hr>
<form id="regForm" action="product.do" method="post">
<input type="hidden" name="command" value="register">
상품명 : <input type="text" name="name"><br>
제조사 : <input type="text" name="maker"><br>
가격 : <input type="text" name="price"><br>	
<input type="submit" value="상품등록">
</form>
<hr>
+상품 검색+ <br>
<form id="findForm" action="product.do">
	<select name="command">
		<option value="findProductByName">상품명</option>
		<option value="findProductByMaker">제조사</option>
	</select>
	<input type="text" name="word">
	<input type="submit" value="검색">
</form>
</body>
</html>












