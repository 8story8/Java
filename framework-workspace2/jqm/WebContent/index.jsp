<!--  에뮬레이터에서 직접 아이피를 입력해서 확인해본다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 인코딩 지정 -->
<meta charset="UTF-8">
</head>
<body>
<%
String userAgentTmp = request.getHeader("user-agent");
String userAgent = userAgentTmp.toLowerCase();//소문자로 변경
System.out.println(userAgent);
if(userAgent.contains("mobile")||userAgent.contains("android")||userAgent.contains(("iphone"))||userAgent.contains(("ipad"))||userAgent.contains(("ipod"))||userAgent.contains(("blackberry"))){
	System.out.println("모바일 접근");
	request.getRequestDispatcher("mobile/m_index.jsp").forward(request, response);
}
%> PC 접속 메인페이지
</body>
</html>




