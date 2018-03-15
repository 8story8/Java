<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#id").keyup(function(){
			var id = $(this).val();
			if(id.length == 0){
				$("#idCheckResult").html("");
			}
			else if(id.length < 4 ||  id.length > 10){
				$("#idCheckResult").css("background", "pink");
				$("#idCheckResult").html("4자 이상 10자 이하만 가능");
			}
			else{
				$.ajax({
					type:"post",
					url:"idCheck.do",
					data:{"id":id},
					success:function(data){
						if(data == 0){
							$("#idCheckResult").css("background", "yellow");
							$("#idCheckResult").html(id + " 사용 가능");
						}
						else{
							$("#idCheckResult").css("background", "red");
							$("#idCheckResult").html(id + " 사용 불가");
						}
					}
				});
			}
		});
		
		$("#registerBtn").click(function(){
			if($("#idCheckResult").text().endsWith("사용 가능")){
				return true;	
			}
			else{
				alert("아이디 중복 확인하세요!");
				document.registerForm.reset();
				$("#idCheckResult").html("");
				return false;
			}
		});
	});
</script>
</head>
<body>
<a href = "index.do">Home</a><hr>
<form action = "registerMember.do" method = "post"  name = "registerForm">
	ID <input type = "text" name = "id" id = "id"><span id = "idCheckResult"></span><br>
	PW <input type = "password" name = "password" ><br>
	Name <input type = "text" name = "name" ><br>
	Address <input type = "text" name = "address" ><br>
	<input type = "submit" value = "가입하기" id = "registerBtn">
</form>
</body>
</html>