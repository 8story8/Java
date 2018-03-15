<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>step2-select-onchange</title>
<script>
	function sendData(){
		// alert("옵션 선택");
		if(document.lineForm.line.value != ""){
			// form action에 명시된 서버 프로그램으로 전송된다.
			if(confirm(document.lineForm.line.value + "호선을 전송하시겠습니까?")){
				document.lineForm.submit();
			}
			else{
				document.lineForm.reset();
			}
		}
	}
</script>
</head>
<body>
<form name = "lineForm" action = "step2-select-action.jsp">
	<select name = "line" onchange = "sendData()">
		<option value = "">--호선--</option>
	<%for(int i = 1; i <= 9; i++){ %>
		<option value ="<%=i%>"><%=i %>호선</option>
	<%}%>
	</select>
</form>
</body>
</html>