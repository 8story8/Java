<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model2 Architecture(MVC)</title>
</head>
<body>
<a href = "find.jsp">검색 서비스</a><br>
<a href = "insert.jsp">등록 서비스</a><br>
<a href = "findByAddress.jsp">주소 검색 서비스</a><br>
<a href = "update.jsp">수정 서비스</a><br><br>
<img src = "frontController2.jpg" alt = "frontController2">
<%--
	insert.jsp -- InsertServlet -- MockDAO
						   |
						   |   redirect 방식
						   |
				    insert_result.jsp
				    
	findByAddress.jsp -- FindByAddressServlet -- MockDAO
							   			   |
						   		  findByAddress_ok.jsp : 목록을 제공
						   				   |
				    			  findByAddress_fail.jsp : 판교에 사는 회원 없음 alert후,
				    			  								 index.jsp로 이동
 --%>
</body>
</html>