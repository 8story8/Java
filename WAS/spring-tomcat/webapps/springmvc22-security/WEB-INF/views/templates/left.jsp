<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- spring security custom tag를 사용하기 위한 선언 --%>
<%@taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
<script type="text/javascript">
	$(document).ready(function(){	
		$("#findForm").submit(function(){			
			if($("#findForm :input[name=id]").val()==""){
				alert("아이디를 입력하세요!");
				return false;
			}			
		});
	});
</script>    
<form id="findForm" action="${pageContext.request.contextPath}/findMemberById.do">
	아이디 <input type="text" name="id" size="5">
	<input type="submit" value="검색">
</form>
<br>
<%-- 
 ifAllGranted 속성: 사용자가 나열된 모든 권한에 해당할 경우 태그 안에 포함된 내용을 보여준다.
 ifAnyGranted 속성: 사용자가 나열된 권한 중 한가지에라도 해당할 경우 태그 안에 포함된 내용을 보여준다.
 ifNotGranted 속성: 사용자가 나열된 권한 중 한가지에라도 해당할 경우 태그 안에 포함된 내용을 보여주지 않는다.

Spring Security를 이용하면 Authentication Bean 이 생성
로그인 한 사용자의 정보는 Authentication 객체의 principal property
 --%>
<sec:authorize ifNotGranted="ROLE_MEMBER">
<a href="${pageContext.request.contextPath}/addressList.do">주소검색페이지로</a><br><br> 
<form action="${pageContext.request.contextPath}/login.do" method="post" id="loginForm">
 아이디 <input type="text" name="id" size="10"><br>
 패스워드 <input type="password" name="password" size="10"><br>
 <input type="submit" value="로그인">
 </form>
 <a href="${pageContext.request.contextPath}/member/registerForm.do">회원가입</a><br>
</sec:authorize>
<sec:authorize ifAnyGranted="ROLE_MEMBER,ROLE_ADMIN">
 <sec:authentication property="principal.name"/>님 <br>
 <a href="${pageContext.request.contextPath}/enterCafe.do">카페가기</a><br>
 <a href="${pageContext.request.contextPath}/logout.do">로그아웃</a><br>
 <a href="${pageContext.request.contextPath}/updateForm.do">회원정보수정</a>
</sec:authorize>
 <br><br>
 파일업로드테스트 <br>
 <a href="${pageContext.request.contextPath}/product/registerProductForm_FileUpload.do">상품등록(파일업로드)</a><br>
<a href="${pageContext.request.contextPath}/product/multifileupload_form.do">멀티파일업로드</a><br>
<!-- FileUploadController에서 처리한다 -->
 
 
 