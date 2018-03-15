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
<c:choose>
	<c:when test="${empty requestScope.memberList}">
		List is empty!
	</c:when>
	<c:otherwise>
		List is not empty!<br>
		회원수 : ${fn:length(memberList)}
	</c:otherwise>
</c:choose>
</body>
</html>