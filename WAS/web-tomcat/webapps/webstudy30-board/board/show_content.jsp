<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세게시물보기</title>
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/css/board.css">
<script type="text/javascript">
function sendList(){
	location.href="${pageContext.request.contextPath}/DispatcherServlet?command=list";
}	
function winOpen(kind){	
	window.open("${pageContext.request.contextPath}/board/"+kind+"_popup.jsp?no=${requestScope.bvo.no }","popup",
			"resizable=true,toolbar=no,width=300,height=200,left=150,top=150");
}
</script>
</head>
<body>
<jsp:include page="/template/header.jsp" />
 <table class="content">
		<tr>
			<td>NO : ${requestScope.bvo.no } </td>
			<td colspan="2">${requestScope.bvo.title} </td>
		</tr>
		<tr>
			<td>작성자 :  ${requestScope.bvo.writer }</td>
			<td> ${requestScope.bvo.timePosted }</td>
			<td>조회수 : ${requestScope.bvo.hits }</td>
		</tr>
		<tr>
			<td colspan="3">
			<pre>${requestScope.bvo.content}</pre>
			</td>
		</tr>
		<tr>
			<td valign="middle" align="center" colspan="3">
			 <img class="action" src="${pageContext.request.contextPath}/img/list_btn.jpg" onclick="sendList()" >
			 <img class="action"  onclick="winOpen('delete')" 	src="${pageContext.request.contextPath}/img/delete_btn.jpg" > 
			 <img class="action"  onclick="winOpen('update')"  src="${pageContext.request.contextPath}/img/modify_btn.jpg" ></td>
		</tr>
	</table>
</body>
</html>





