<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#ajaxBtn1").click(function(){
			//alert(1);
			$.ajax({
				type:"post",
				url:"testJSONObject.do",
				dataType:"json",
				success:function(data){
					alert(data.id+" "+data.name);
				}
			});//ajax
		});//click
		$("#ajaxBtn2").click(function(){			
			$.ajax({
				type:"post",
				url:"testJSONArray.do",
				dataType:"json",
				success:function(data){
					for(var i=0;i<data.length;i++)
					alert(data[i]);
				}
			});//ajax
		});//click
	});//ready
</script>
<title>index</title>
</head>
<body>
<h3>Spring Annotation Controller Test</h3>
<a href="hello.do">hello.do test</a><br>
<a href="bye.do">bye.do test</a><br>
<a href="getParam.do?id=java&name=호겸">getParam.do test</a><br>
<form method="post" action="registerPerson.do">
	아이디 <input type="text" name="id"><br>
	이름 <input type="text" name="name"><br>
	<input type="submit" value="전송">
</form>
<br>
<%-- post 방식으로 전송할 때만 동작되는 지 여부를 테스트 --%>
<form method="post" action="login.do">
	아이디 <input type="text" name="id"><br>
	패스워드 <input type="password" name="password"><br>
	<input type="submit" value="전송">
</form>
<br>
<%-- PersonVO has a CarVO  테스트 --%>
<form method="post" action="register2.do">
	아이디 <input type="text" name="id"><br>
	이름 <input type="text" name="name"><br>
	차모델 <input type="text" name="carVO.model"><br>
	차가격<input type="text" name="carVO.price"><br>
	<input type="checkbox" name="menu" value="피자">피자<br>
	<input type="checkbox" name="menu" value="족발">족발<br>
	<input type="checkbox" name="menu" value="맥주">맥주<br>
	<input type="submit" value="전송">
</form>
<br>
<input type="button" value="AjaxJSONObject Test" id="ajaxBtn1"><br>
<input type="button" value="AjaxJSONArray Test" id="ajaxBtn2"><br>
</body>
</html>



























