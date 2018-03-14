<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax</title>
<script type="text/javascript">
	var xhr;

	function startAjax() {
		xhr = new XMLHttpRequest(); // ajax 통신 객체 생성

		var deptNo = document.getElementById("deptNo");
		if (deptNo.value == "") {
			alert("부서번호를 선택하세요!");
			return; // 함수 실행 중단
		} 
		
		xhr.open("post", "DeptServlet");
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); // ajax post 방식일 때 Content Type을 지정해야 한다.
		xhr.send("deptNo=" + deptNo.value);

		xhr.onreadystatechange = function() { // 응답시 실행할 함수 등록
			if (xhr.status == 200 && xhr.readyState == 4) {
				document.getElementById("deptInfo").innerHTML = xhr.responseText;
			}
		}

	}
</script>
</head>
<body>
	<select id="deptNo" onchange="startAjax()">
		<option value="">--부서번호--</option>
		<option value="10">10</option>
		<option value="20">20</option>
		<option value="30">30</option>
	</select>
	<span id="deptInfo"></span>
</body>
</html>