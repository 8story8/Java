<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="javax.sql.*, model.*, java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dbcp test</title>
<style>
	table{
		border:1px dotted black;
		text-align:center;
	}
	
	tr, th, td{
		border:1px dotted black;
		padding:20px;
	}
</style>
</head>
<body>
DBCP로부터 Connection을 빌려온다.<br>
<%
DataSource dataSource = DataSourceManager.getInstance().getDataSource();
Connection con1 = dataSource.getConnection();
%>
<%=con1 %><br>
Connection(Pool 활용 O) 클래스명 : <%=con1.getClass() %>
<%
	con1.close();   // 소멸이 아니라 dbcp로 반납한다는 의미
%>
<hr>
ref) 기존 Connection 클래스명을 출력<br>
<%
Connection con2 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
%>
<%=con2 %><br>
Connection(Pool 활용 X) 클래스명 : <%=con2.getClass() %>
<%
	con2.close();   // 소멸이 아니라 dbcp로 반납한다는 의미
%>
<hr>
<%ArrayList<CarVO> list = CarDAO.getInstance().getAllCarList();%>
	<table>
		<tr>
			<th>carNo</th><th>carModel</th><th>carPrice</th>
		</tr>
		
		<%for(CarVO vo : list){%>
		<tr>
			<td><%=vo.getCarNo() %></td><td><%=vo.getCarModel() %></td><td><%=vo.getCarPrice() %></td>
		</tr>
		<%} %>
		
	</table>
</body>
</html>