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
		var address = document.addressForm.address;
		
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var memberObj = JSON.parse(xhr.responseText);
				var info = "";
				for(var i = 0; i < memberObj.length; i++){
					info += "<tr>";
					info += "<td>";
					info += memberObj[i].id;
					info += "</td>";
					info += "<td>";
					info += memberObj[i].name;
					info += "</td>";
					info += "</tr>";
				}
				document.getElementById("memberInfo").innerHTML = info;
			}
		}
		
		xhr.open("get", "FindMemberListServlet?address="+address.value);
		xhr.send(null);
	}
</script>
</head>
<body>
	<form name = "addressForm">
	<input type = "radio" name = "address" value = "판교" onchange = "startAjax()">판교<br>
	<input type = "radio" name = "address" value = "종로" onchange = "startAjax()">종로<br>
	</form>
	<br><br><br>
	<table>
		<thead>
			<tr>
				<th>아이디</th><th>이름</th>
			</tr>
		</thead>
		<tbody id = "memberInfo">
		</tbody>
	</table>
</body>
</html>