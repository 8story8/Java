<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/board.css" type="text/css">
<script type="text/javascript">
function sendList(){
	location.href="${pageContext.request.contextPath}/DispatcherServlet?command=list";
}	
function check(kind){	
	if(confirm("해당 게시물을 " + kind + "하시겠습니까?")){
		if(kind == "삭제"){
			location.href = "${pageContext.request.contextPath}/DispatcherServlet?command=delete&no=${requestScope.bvo.no}"
		}
		else if(kind == "수정"){
			location.href = "${pageContext.request.contextPath}/DispatcherServlet?command=updateView&no=${requestScope.bvo.no}"
		}
	}
}
</script>
</head>
<body>
<jsp:include page="/template/header.jsp"/>
<hr>
	<table class="content">
		<tr>
			<td>NO : ${requestScope.bvo.no} </td>
			<td colspan="2">${requestScope.bvo.title} </td>
		</tr>
		<tr>
			<td>작성자 : ${requestScope.bvo.mvo.name}</td>
			<td>${requestScope.bvo.timePosted}</td>
			<td>조회수 : ${requestScope.bvo.hits}</td>
		</tr>
		<tr>
			<td colspan="3">
			<pre>${requestScope.bvo.content}</pre>
			</td>
		</tr>
		<tr>
			<td valign="middle" align="center" colspan="3">
			 <!-- <img class="action" src=list_btn.jpg">	 -->	
			 
			 <img class="action" src="${pageContext.request.contextPath}/img/list_btn.jpg" onclick="sendList()" >
			 <c:if test="${sessionScope.mvo.name == requestScope.bvo.mvo.name}">
			 <img class="action"  onclick="check('삭제')" 	src="${pageContext.request.contextPath}/img/delete_btn.jpg" > 
			 <img class="action"  onclick="check('수정')"  src="${pageContext.request.contextPath}/img/modify_btn.jpg" >
			 </c:if>	 
			 </td>
		</tr>
	</table>
</body>
</html>