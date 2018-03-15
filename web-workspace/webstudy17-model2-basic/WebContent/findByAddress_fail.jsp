<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
<%String addr = (String) request.getAttribute("addr"); %>
		alert("<%=addr %>에 사는 회원은 없습니다!");
		location.href = "index.jsp";
</script>
</head>
<body>
</body>
</html>