<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
<%  String id=request.getParameter("id");
	  String name=request.getParameter("name");
	  if(id==null&&name==null){
%>		<script type="text/javascript">
			alert("아이디 이름 둘 다 없음!");
			location.href="step2-link.jsp";
		</script>
<%  }	  
	  if(id!=null){
%>
		아이디 <%=id %> 
<%	  } 
	  if(name!=null){
%>		
		이름 <%=name %>
<%  } %>
</body>
</html>