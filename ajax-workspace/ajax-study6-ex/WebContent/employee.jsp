<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>employee</title>
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
	var empNo = document.getElementById("empNoInfo");
	
	if(empNo.value == ""){
		document.getElementById("empInfo").innerHTML = "";
		return;
	}
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var json = JSON.parse(xhr.responseText);
			var info = "";
			info += "<tr>";
			info += "<td>" + json.ename + "</td>";
			info += "<td>" + json.sal + "</td>";
			info += "<td>" + json.dname + "</td>";
			info += "<td>" + json.loc + "</td>";
			info += "</tr>";
			
			document.getElementById("empInfo").innerHTML = info;
		}
	}
	
	xhr.open("get", "DispatcherServlet?command=empAndDept&empNo="+empNo.value);
	xhr.send(null);
}
</script>
</head>
<body>
<select id = "empNoInfo" onchange = "startAjax()">
	<option value = "">-사원번호-</option>
	<c:forEach items = "${requestScope.empNoList}" var = "empNoList">
		<option value = "${empNoList}">${empNoList}</option>
	</c:forEach>
</select><br><br><br><br>
<table>	
	<thead>
		<tr>
			<th>사원명</th><th>월급</th><th>부서명</th><th>지역</th>
		</tr>
	</thead>
	<tbody id = "empInfo"></tbody>
</table>
</body>
</html>