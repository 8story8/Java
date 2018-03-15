<%@page import="model.ItemVO"%>
<%@page import="model.ItemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 등록 처리</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
<a href="index.jsp">Home</a>
<br><br>
<%  request.setCharacterEncoding("utf-8");     
	 String name=request.getParameter("name");
	 String maker=request.getParameter("maker");
	 int price=Integer.parseInt(request.getParameter("price"));
	 ItemVO itemVO = new ItemVO(name, maker, price);
	 ItemDAO.getInstance().registerItem(itemVO);	 
%>  <%=name %> 아이템이 등록되었습니다
</body>
</html>










