<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%PersonVO pvo = new PersonVO(); 
    	pvo.setName("Kir");
    	pvo.setCar(new CarVO("Porsche", 4000));
    	request.setAttribute("person", pvo);
    	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl set</title>
</head>
<body>
모델명 : ${requestScope.person.car.model}<br>
소유주 : ${requestScope.person.name}<br>
<hr>
<c:set value = "${requestScope.person}" var = "p"/>
모델명 : ${p.car.model}<br>
소유주 : ${p.name}<br>
<c:set value = "${requestScope.person.car}" var = "c"/>
가격 : ${c.price}

</body>
</html>