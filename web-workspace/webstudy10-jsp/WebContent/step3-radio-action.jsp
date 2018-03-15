<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		 request.setCharacterEncoding("utf-8");
	
	     String friend = request.getParameter("friend");     
	     String friendPicture = null;
	     
	     if(friend.equals("루피"))
	     {
	    	 friendPicture = "a";
	     }
	     else if(friend.equals("뽀로로"))
	     {
	    	 friendPicture = "b";
	     }
	     else if(friend.equals("쵸파"))
	     {
	    	 friendPicture = "c";
	     }
	%>
	<img src = "picture/<%=friendPicture%>.jpg">
</body>
</html>