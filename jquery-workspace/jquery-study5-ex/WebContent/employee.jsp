<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>employee</title>
<script src="//code.jquery.com/jquery.min.js"></script>
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
$(document).ready(function(){
	$("#empNoInfo").change(function(){
		if($(this).val() == ""){
			$("#empInfo").empty();	
		}
		else{
			$.ajax({
				type:"get",
				url:"DispatcherServlet?command=empAndDept&empNo="+$(this).val(),
				dataType:"json",
				async:"true",
				success:function(data){
					$("#empInfo").append("<tr>");
					$("#empInfo").append("<td>" + data.ename + "</td>");
					$("#empInfo").append("<td>" + data.sal + "</td>");
					$("#empInfo").append("<td>" + data.dname + "</td>");
					$("#empInfo").append("<td>" + data.loc + "</td>");
					$("#empInfo").append("</tr>");
				}
			});
		}
	});
	
	// 이벤트 적용이 안된다.
	// 처음 페이지 로드(document ready) 시점에
	// 해당 요소는 존재하지 않으므로 이 경우에는
	// jQuery의 on을 이용해 등록해야 한다.
	$("#empInfo").on("click", "td", function(){
		alert($(this).text());
	});
});
</script>
</head>
<body>
<select id = "empNoInfo">
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