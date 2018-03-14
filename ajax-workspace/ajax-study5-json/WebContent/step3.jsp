<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSONArray</title>
<script type="text/javascript">
	var xhr;
	function startAjax(){
		xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var arr = JSON.parse(xhr.responseText);
				for(var i = 0; i < arr.length; i++){
					alert(arr[i].model + " " + arr[i].price);
				}
			}
		}
		
		xhr.open("get", "JSONArrayServlet2");
		xhr.send(null);
	}
</script>
</head>
<body>
<input type="button" value ="JSONArray Test" onclick = "startAjax()">
</body>
</html>