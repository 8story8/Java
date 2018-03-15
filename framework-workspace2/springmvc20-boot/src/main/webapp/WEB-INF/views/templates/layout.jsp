<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri = "http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery.min.js"></script>
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/resources/css/home.css">
<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/resources/css/home2.css">
</head>
<body>
<nav class="navbar navbar-inverse"><tiles:insertAttribute name = "header"/></nav>
<div class="container-fluid text-center">
  		<div class="row content">
  		 	<div class="col-sm-2 sidenav"><tiles:insertAttribute name = "left"/></div>
  			<div class="col-sm-8 text-left"><tiles:insertAttribute name = "main"/></div>
			<div class="col-sm-2 sidenav"><tiles:insertAttribute name = "right"/></div>
  		</div>
</div>
<footer class="container-fluid text-center"><tiles:insertAttribute name = "footer"/></footer>
</body>
</html>