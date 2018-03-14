<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSONArray</title>
<style type="text/css">
	table{
		border-collapse: collapse;
	}
	table, th, td{
		border : 1px dotted black;
	}
	th, td{
		padding: 15px;
	}
</style>
<script type="text/javascript">
	var xhr;
	function startAjax(){
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				// alert(xhr.responseText);
				var json = JSON.parse(xhr.responseText);
				alert(json.deptNo + "   " + json.dname + "   " + json.location);
				}
			}
		
		xhr.open("get", "JSONTestServlet");
		xhr.send(null);
	}
</script>
</head>
<body>
	<input type = "button" value = "확인" onclick = "startAjax()">
</body>
</html>