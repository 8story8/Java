<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.*, java.util.*"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri ="http://java.sun.com/jsp/jstl/functions" %>
	<%ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		list.add(new MemberVO("kir", "1234", "1", "도쿄"));
		list.add(new MemberVO("kid", "4321", "2", "판교"));
		list.add(new MemberVO("jin", "abcd", "3", "도쿄"));
		request.setAttribute("memberList", list);
		request.setAttribute("address", "도쿄");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%ArrayList<MemberVO> mlist = (ArrayList<MemberVO>) request.getAttribute("memberList"); %>
<%=list.size() %><br>
EL로 list.size() 호출<br>
<%-- ${requestScope.memberList.size} --%>
List 길이 : ${fn:length(memberList)}<br>
첫 번째 요소의 이름 길이 : ${fn:length(memberList[0].name)}<br>
주소 이름 길이 : ${fn:length(address)}<br>
공란 제거후 주소 이름 길이 : ${fn:length(fn:trim(address))}<br><br>
특정 문자열이 존재한지 확인 : ${fn:contains(address, '도')}<br>
특정 문자열로 시작하는지 확인 : ${fn:startsWith(fn:trim(address), '미')}<br><br><br>
<%--jsp:include와 같은 역할--%>
<c:import url = "http://www.google.co.kr"></c:import>
</body>
</html>