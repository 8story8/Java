<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소로 회원 검색</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#address").change(function(){
			var address = $(this).val();
			var memberInfo = $("#memberInfo");
			
			if(address == ""){
				memberInfo.empty();
			}   // if
			else{
				memberInfo.empty();
				$.ajax({
					type : "post",
					url : "findMemberByAddress.do",
					dataType : "json",
					data : {"address":address},
					success : function(data){
						for(var i = 0; i < data.length; i++){
							memberInfo.append("<tr>");
							memberInfo.append("<td>" + data[i].id + "</td>");
							memberInfo.append("<td>" + data[i].name + "</td>");
							memberInfo.append("</tr>");
						}   // for
					}   // success
				});   // ajax
			}   // else
		});   // change
	});   // ready
</script>
</head>
<body>
<a href = "index.do">Home</a><hr>
	<select id = "address">
		<option value = "">---</option>
		<c:forEach items="${list}" var = "list">
			<option value = "${list}">${list}</option>
		</c:forEach>
	</select>
	<hr>
 	<table cellpadding = "10" border = "1">
 		<thead>
 			<th>ID</th><th>Name</th>
 		</thead>
 		<tbody id = "memberInfo" align = "center">
 		</tbody>
	</table>
</body>
</html>