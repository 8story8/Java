<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json(javascript object notation)</title>
<script>
var xhr;
function startAjax(){
	xhr = new XMLHttpRequest();   // ajax 통신 객체 생성
	
	var memberId = document.getElementById("memberId");
	var nameView =  document.getElementById("nameView");
	var addressView = document.getElementById("addressView");
	if(memberId.value == ""){
		nameView.innerHTML = "";
		addressView.innerHTML = "";
		return;   // 함수 실행 중단
	}
	
	xhr.onreadystatechange = function(){   // 응답시 실행할 함수 등록
		if(xhr.status == 200 && xhr.readyState == 4){
			 var memberObj = JSON.parse(xhr.responseText);
		     nameView.innerHTML = memberObj.name;
		     addressView.innerHTML = memberObj.address;
		}
	}
	
	xhr.open("get","FindMemberByIdServlet?memberId="+memberId.value);
	xhr.send(null); 
}
</script>
</head>
<body>
<select id = "memberId" onchange = "startAjax()">
	<option value = "">---</option>
	<option value = "java">java</option>
	<option value = "spring">spring</option>
	<option value = "ajax">ajax</option>
</select>
<hr><br><br>
회원 이름 <span id = "nameView"></span> <br>
주소 <span id = "addressView"></span>
</body>
</html>