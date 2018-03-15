<%@page import="model.MemberVO"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");%>
<%HashMap<String, MemberVO> hm = (HashMap<String, MemberVO>)application.getAttribute("map");%>
<%String id = request.getParameter("id"); %>
<%String pw = request.getParameter("pw"); %>

<%--전달받은 아이디와 패스워드가 
	   ServletContext의 map 정보에 있는 회원정보 아이디와 패스워드가 일치하면,
	   <a>Home</a>
	   송중기님 로그인 성공
	   or
	   아이디가 없거나 아이디에 따른 패스워드가 일치하지 않으면,
	   로그인 실패 alert후 index.jsp로 이동
	   --%>
	   
	   <a href = "index.jsp">Home</a><br>
	   	<%if(hm.containsKey(id) && hm.get(id).getPassword().equals(pw)){ %>
	   	<%session.setAttribute("id", hm.get(id).getName());%>
		  	<%=hm.get(id).getName()%>님 로그인 성공
	   <%} else{%>
	   		<script>
	   			alert("로그인 실패");
	   			location.href = "index.jsp";
	   		</script>
	   <%} %>
	   
	   
</body>
</html>