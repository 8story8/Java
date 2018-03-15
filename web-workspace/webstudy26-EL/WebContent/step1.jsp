<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CarDAO"%>
<%@page import="model.CarVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
</head>
<body>
<% CarVO car = new CarVO("1", "Sonata", "200"); 
request.setAttribute("cvo", car);
%>
<b>1. 기존 방식으로 request cvo에서 model명을 출력</b><br>
<%
	CarVO vo = (CarVO) request.getAttribute("cvo");
%>
모델명 : <%=vo.getCarModel() %>
<br><br><hr><br>
<b>2. EL로 request cvo에서 model명을 출력</b><br>
모델명 : ${requestScope.cvo.carModel}
<br><br><hr><br>
<%
	ArrayList<CarVO> list = CarDAO.getInstance().getAllCarList();
	session.setAttribute("carList", list);
%>
<b>3. 기존 방식으로 Session의 carList 첫 번째 Index의 모델과 가격을 출력</b><br>
<%
	ArrayList<CarVO> carList = (ArrayList<CarVO>) session.getAttribute("carList");
	CarVO vo1 = carList.get(0);
%>
모델명 : <%=vo1.getCarModel() %><br>
가격 : <%=vo1.getCarPrice() %>
<br><br><hr><br>
<b>4. EL 방식으로 Session의 carList 첫 번째 Index의 모델과 가격을 출력</b><br>
모델명 : ${carList[0].carModel}<br>
가격 : ${carList[0].carPrice}
<br><br><hr><br>
<%
	HashMap<String, CarVO> map = new HashMap<String, CarVO>();
	map.put("a", new CarVO("1", "Porsche", "200"));
	session.setAttribute("carMap", map);
%>
<b>5. 기존 방식으로 Session의 carMap의 a key의 car model명을 출력</b><br>
<%
	HashMap<String, CarVO> rm = (HashMap<String, CarVO>) session.getAttribute("carMap");
%>
모델명 : <%=rm.get("a").getCarModel() %>
<br><br><hr><br>
<b>6. EL 방식으로 Session의 carMap의 a key의 car model명을 출력</b><br>
모델명 : ${sessionScope.carMap.a.carModel }
<br><br><hr>
<a href = "step2.jsp?memberName=bourbon&age=27">step2로 이동</a>
</body>
</html>