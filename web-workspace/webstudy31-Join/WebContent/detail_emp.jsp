<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmpDetail</title>
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
		<td>사원번호</td><td>${requestScope.evo.empno}</td>
	</tr>
	<tr>
		<td>사원명</td><td>${requestScope.evo.ename}</td>
	</tr>
	<tr>
		<td>월급</td><td>${requestScope.evo.salary}</td>
	</tr>
	<tr>
		<td>부서번호</td><td>${requestScope.evo.deptVO.deptno}</td>
	</tr>
	<tr>
		<td>지역</td><td>${requestScope.evo.deptVO.loc}</td>
	</tr>
	<tr>
		<td>전화번호</td><td>${requestScope.evo.deptVO.tel}</td>
	</tr>
</table>
</body>
</html>