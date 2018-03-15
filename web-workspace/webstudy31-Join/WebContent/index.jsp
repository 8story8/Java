<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:forward page="DispatcherServlet">
	<jsp:param value="empList" name="command"/>
</jsp:forward>