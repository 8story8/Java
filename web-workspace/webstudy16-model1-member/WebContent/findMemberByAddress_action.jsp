<%@page import="model.MemberDAO"%>
<%@page import="model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 결과 출력</title>
<style>
table, tr, th, td{
	border:1px dotted black;
}
td{
	padding:15px;
}
</style>
</head>
<body>
<%String addr = request.getParameter("addr");
     ArrayList<MemberVO> list = new ArrayList<MemberVO>();
     list = MemberDAO.getInstance().findMemberByAddress(addr);%>
     <%if(list.size() == 0){%>
    	 <script>
			alert("<%=addr%>에 사는 회원은 없습니다!");
			location.href = "index.jsp";
		</script>
     <%} else{%>
     	<table>
			<tr>
				<th>아이디</th><th>이름</th>
			</tr>
			<%for(int i = 0; i < list.size(); i++){%>
				<tr>
					<td><%=list.get(i).getId() %></td>
					<td><%=list.get(i).getName() %></td>
				</tr>
			<%}%>	
		</table>
		<%} %>
</body>
</html>