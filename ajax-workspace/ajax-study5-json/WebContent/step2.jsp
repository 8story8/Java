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
					var result = "";
					for(var i = 0; i < arr.length; i++){
						result += i + ". " + arr[i] + "&nbsp;&nbsp;&nbsp;";
					}
					
					document.getElementById("result").innerHTML = result;
				}
			}
			
			xhr.open("get", "JSONArrayServlet");
			xhr.send(null);
		}
</script>
</head>
<body>
<input type = "button" value = "JSONArray Test" onclick = "startAjax()"><br><br>
<span id = "result"></span>
</body>
</html>