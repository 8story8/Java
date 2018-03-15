<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.*, controller.*"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>car list page</title>
<style>
	 table{
  border-collapse: collapse; 
 }
 table,th,td{
  border: 1px solid black;
 }
 td,th{
  padding: 15px;
 }
 /* 한번도 클릭하지 않은 링크    */
a:LINK{ 
  color: #888; 
  text-decoration: none;
 }
 /* 마우스 오버시 색상 변경 */
 a:HOVER {
  color:#ffcc00;
  text-decoration: none;
 }
 /* 한번 이상 방문한 링크 색상 및 언더라인 생기지 않게 함 */
 a:VISITED {
  color:#FAAC58;
  text-decoration: none;
</style>
</head>
<body>
<h3>car list</h3>
<table>
	<tr>
		<th>순번</th><th>모델명</th><th>가격</th>
	</tr>
	<c:forEach items = "${requestScope.listVO.carList}"  var = "carlist"  varStatus = "order" >
	<tr>
		<td>${order.count}</td><td>${carlist.model}</td><td>${carlist.price}</td>
	</tr>
	</c:forEach>
</table>
<br>
<c:forEach var = "pageNo" begin = "${requestScope.listVO.pagingBean.startPage}" end = "${requestScope.listVO.pagingBean.endPage}">
		<c:choose>
			<c:when test="${pageNo == requestScope.listVO.pagingBean.nowPage}">
				${pageNo}
			</c:when>
			<c:otherwise>
				<a href = "#">${pageNo}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</body>
</html>