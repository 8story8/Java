
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
<c:choose>
<c:when test="${requestScope.flag==false}">		
			alert("비밀번호가 일치하지 않습니다!");				
</c:when>	
<c:otherwise>
			if(confirm("수정하시겠습니까?"))
			opener.location.href = "${pageContext.request.contextPath}/DispatcherServlet?command=updateView&no=${param.no}";						
</c:otherwise>	
</c:choose>
	self.close();
</script>






