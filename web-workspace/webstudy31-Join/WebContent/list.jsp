<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmpList</title>
<style>
	table, th, td{
		border:1px dotted black;
		text-align:center;
	}
	
	th, td{
		padding:20px;
	}
</style>
</head>
<body>
<table>
	<tr>
		<th>사원번호</th><th>사원명</th><th>부서명</th>
	</tr>
<c:forEach items = "${requestScope.empList}" var = "empList">
	<tr>
		<td><a href = "DispatcherServlet?command=empDetail&empNo=${empList.empno}">${empList.empno}</a></td><td>${empList.ename}</td><td>${empList.deptVO.dname}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>