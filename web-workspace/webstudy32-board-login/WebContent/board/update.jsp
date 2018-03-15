<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/board.css" type="text/css">
</head>
<body>
<jsp:include page="/template/header.jsp"/>
<hr>	
<form method=post action="DispatcherServlet">
	<input type=hidden name="command" value="update"></input>	
	<table class="content">
	<tr>
		<td>
			<table>
				<tr>
					<td>
					글번호: <input type=text name=no value="${requestScope.bvo.no}" readonly></input>
					| 타이틀:<input type=text name=title value="${requestScope.bvo.title}"></input>					
					</td>
				<tr>
					<td>						
	<textarea rows="15" cols="75" name="content">${requestScope.bvo.content}</textarea>
					</td>
				</tr>
				<tr>
				<td valign="middle">						
					<input type="submit" value="수정하기" class="action"></input>			
					</td>				
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>	
</body>
</html>