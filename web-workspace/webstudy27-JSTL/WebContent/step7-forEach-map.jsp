<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*, model.*"%>
    <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step7-forEach-map.jsp</title>
</head>
<body>
<%
	LinkedHashMap<String, MemberVO> map = new LinkedHashMap<String, MemberVO>();  	
	MemberVO vo1 = new MemberVO("Java", "1234", "JDBC", "미국");
	MemberVO vo2 = new MemberVO("C", "4321", "ProC", "영국");
	MemberVO vo3 = new MemberVO("C++", "abcd", "???", "독일");
	map.put(vo1.getId(), vo1);
	map.put(vo2.getId(), vo2);
	map.put(vo3.getId(), vo3);
	session.setAttribute("memberMap", map);
%>
<b>1. scriptlet으로 key, value(name, address)를 출력</b><br><br>
<%LinkedHashMap<String, MemberVO> reMap = (LinkedHashMap<String, MemberVO>)session.getAttribute("memberMap"); %>
<%
	Iterator<String> it = reMap.keySet().iterator();
	while(it.hasNext()){
		String key = it.next();
	%>
	key : <%=key%>
	value : <%=reMap.get(key).getName() %>, <%=reMap.get(key).getAddress() %><br>
	<%} %>
<hr>
<b>2. JSTL forEach로 map의 key와 value 출력</b><br><br>
<c:forEach items = "${sessionScope.memberMap}" var = "m">
	key : ${m.key}, value : ${m.value.name}, ${m.value.address}<br>
</c:forEach>
</body>
</html>