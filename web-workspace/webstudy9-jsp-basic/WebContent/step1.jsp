<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<!--이 부분은 HTML 주석-->
<%--이 부분은 JSP 주석--%>
<h3>JSP 기본 문법 Test</h3>
<% // scriptlet : Java Code 영역
	/*
	for문을 이용해 1부터 100까지 화면에 출력해본다.
	*/
	for(int i = 1; i <= 100; i++){
		out.println("<font color = mediumblue size = 5>" + i + " </font>");
	}
%>
<%--아래와 같은 형식의 코딩을 권장한다.--%>
<%--expression 태그를 이용해 표현--%>
<hr>
<% for(int i = 1; i <= 100; i++){ %>
<font color = "mediumblue" size = "5"><%=i %></font>
<%}%>
<hr>
Variable Test <br>
<% int age = 22; %> <%--Local Variable로 선언된다.--%>
<%! int money; %> <%--Instance Variable로 선언된다.--%>
money <%=money %> age <%=age %>
</body>
</html>