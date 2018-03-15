<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>radio</title>
<script>
function checkForm(){
	var friend = document.friendForm.friend;
	var flag = false;
	for(var i = 0; i < friend.length; i++){
		if(friend[i].checked){
			flag = true;
		}
	}
	
	if(flag == false){
		alert("친구를 선택하세요!");
		return flag;
	}
}

</script>
</head>
<body>
<form method = "post" action = "step3-radio-action.jsp" name = "friendForm" onsubmit = "return checkForm()">
<input type = "radio" name = "friend" value = "루피">루피<br>
<input type = "radio" name = "friend" value = "뽀로로">뽀로로<br>
<input type = "radio" name = "friend" value = "쵸파">쵸파<br>
<input type = "submit" value = "선택">
</form>
</body>
</html>