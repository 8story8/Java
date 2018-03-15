<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function registerData(){
		var registerForm = document.registerForm;	
		
		if(registerForm.flag.value! = registerForm.id.value){
			alert("인증받은 아이디가 아닙니다!");
			return false;		
		}	
	}
	
	function checkId(){
		var id = document.registerForm.id.value;
		
		if(id == ""){
			alert("아이디를 입력하세요!");			
		}
		else{
			window.open("idcheck.jsp?id=" + id, "popup",
			"width=200,height=200,top=150,left=400");
		}
	}
</script>
</head>
<body>
<h3>회원가입</h3>
		<form method="post" name="registerForm" action="register_action.jsp"
		onsubmit="return registerData()">
		아이디 : <input type="text" name="id" required="required">	
		<input type="button" value="중복확인" onclick="checkId()">		
		<br>패스워드 : <input type="password" name="pw" required="required">		
		<br>이름 : <input type="text" name="name" required="required">	
		<br>주소 : <input type="text" name="addr" required="required">
		<input type="hidden" name="flag"  value="">		
		<br><input type="submit" value="회원가입">
		</form>
</body>
</html>







