<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*"%>
<%  
		request.setCharacterEncoding("utf-8");
		Enumeration enu=request.getParameterNames();
%>
    
<section id="page2" data-role="page" data-theme="b">
	<header data-role="header">
		<a href="#page1" data-rel="back" data-role="button" 
		data-icon="arrow-l" data-iconpos="notext"></a>
		<h1>jQuery Mobile</h1>		
	</header>
	<div class="content" data-role="content">
		<h3>전송받은 데이터 목록</h3>
		<ul data-role="listview">
<%     while(enu.hasMoreElements()){ %>
			<li><a href="#">
			<%=request.getParameter(enu.nextElement().toString()) %></a>
			</li>
<%		} %>		
		</ul>
	</div>
	<footer data-role="footer"><h1>form data 처리</h1></footer>
</section>












