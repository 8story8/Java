<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript">
	var xhr;
	
	function startAjax(){
		xhr = new XMLHttpRequest();   // ajax 통신 객체 생성
	
		var id = document.getElementById("memberId");
		var checkResult = document.getElementById("checkResult");
		
		if(id.value.length == 0){
			checkResult.innerHTML = "";
		}
		else if(id.value.length >= 4 && id.value.length <= 10){
			xhr.open("get", "DispatcherServlet?command=memberIdCheck&id="+id.value);
			xhr.send(null); 
			xhr.onreadystatechange = function(){   // 응답시 실행할 함수 등록
				if(xhr.status == 200 && xhr.readyState == 4){
				     if(xhr.responseText == "false"){
				    	 checkResult.innerHTML = "사용 가능한 아이디입니다!";
				    	 checkResult.style.color = "green";
				     }
				     else{
				    	 checkResult.innerHTML = "이미 존재하는 아이디입니다!";
				    	 checkResult.style.color = "red";
				     }
				}
			}
		}
		else{
			checkResult.innerHTML = "아이디는 4자 이상 10자 이하입니다!";
			checkResult.style.color = "red";
		}
	}
	
	function checkForm(){
		var checkResult = document.getElementById("checkResult");
		
		if(checkResult.innerHTML != "사용 가능한 아이디입니다!"){
			return false;		
		}	
	}
</script>
</head>
<body>
<a href="index.jsp">홈</a><hr>
<h3>회원가입</h3>
		<form method="post" name="registerForm" action="DispatcherServlet" onsubmit="return checkForm()">
		<input type="hidden" name="command" value="register">
		아이디 : <input type="text" name="id" id="memberId" required="required" onkeyup="startAjax()">
		<span id = "checkResult"></span>	
		<br>패스워드 : <input type="password" name="password" required="required">		
		<br>이름 : <input type="text" name="name" required="required">	
		<br>주소 : <input type="text" name="address" required="required">	
		<br><input type="submit" value="회원가입">
		</form>
		
		<%--
			MemberIdCheckController
			아이디가 4자 이상 10자 이하일때만 가입 가능
			반드시 중복을 확인해서 아이디가 사용 가능일때만 회원가입이 되도록 한다.
			
			입력한 아이디가 4자 이상 10자 이하가 아닐때는 
			span checkResult 영역에 아이디는 4자 이상 10자 이하이어야 합니다.
			4자 이상 10자 이하일 때는 사용 가능 or 사용 불가
		--%>
</body>
</html>







