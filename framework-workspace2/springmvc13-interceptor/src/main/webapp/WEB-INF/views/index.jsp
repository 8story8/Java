<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 관리</title>
</head>
<body>
	<h3>Annotation 기반 SpringMVC 회원 관리(총 회원수 ${totalMemberCount}명)</h3>
	<form action="findMemberById.do">
		ID <input type="text" name="id"> <input type="submit"
			value="검색">
	</form>
	<%--   MemberController   MemberService(Interface)   MemberDAO(Interface)
		  회원 정보가 있으면 views/findMemberById_ok.jsp
		  없으면 views/findMemberById_fail.jsp
		  alert후 index로 이동
--%>
	<hr>
	<a href="getAddressKind.do">주소로 회원 검색</a>
	<%-- address.jsp에서 select option으로 회원이 사는 주소의 종류를 제공한다. --%>
	<hr>
	<%-- 
		로그인 상태이면
		~님 로그인
		로그아웃
		
		비로그인 상태이면
		로그인폼을 제공한다.
--%>
	<c:choose>
		<c:when test="${sessionScope.mvo !=null}">
			${sessionScope.mvo.name}님 로그인<br>
			<a href="logout.do">로그아웃</a>
			<br>
			<a href="member_cafe.do">카페가기</a>
			<br>
			<%-- 카페에서는 판교에 사는 아이유님 카페입장을 환영합니다. --%>
			<a href = "member_updateView.do">회원정보 수정</a>
			<%-- 
				MemberController updateView()
												   |				MemberController
										    update.jsp ---> updateMember()
										    							  |
										    					 update_result.jsp		
			--%>
		</c:when>
		<c:otherwise>
			<%-- post 방식만 실행 가능하게 Controller에서 처리한다. --%>
			<form method="post" action="login.do">
				ID <input type="text" name="id"><br>
				PW <input type="password" name="password"><br> 
				<input type="submit" value="로그인">
			</form><hr>
			<a href = "registerView.do">회원가입</a>
		</c:otherwise>
	</c:choose>
</body>
</html>