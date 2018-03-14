<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax</title>
<script type="text/javascript">
	var xhr;
	
	function startAjax(){
		xhr = new XMLHttpRequest();   // ajax 통신 객체 생성
		
		var id = document.getElementById("memberId");
		if(id.value == ""){
			alert("아이디를 입력하세요!");
			id.focus();
			return;   // 함수 실행 중단
		}
		
		xhr.open("post", "AjaxMemberServlet");
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");   // ajax post 방식일 때 Content Type을 지정해야 한다.
		xhr.send("id="+ id.value);
		
		xhr.onreadystatechange = function(){   // 응답시 실행할 함수 등록
			if(xhr.status == 200 && xhr.readyState == 4){
			     document.getElementById("resultView").innerHTML = xhr.responseText;
			}
		}
	}
</script>
</head>
<body>
<input type = "text" id = "memberId">
<input type = "button" value = "검색" onclick = "startAjax()">
<span id = "resultView"></span>
</body>
</html>