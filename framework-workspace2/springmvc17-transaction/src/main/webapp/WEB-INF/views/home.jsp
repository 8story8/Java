<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<%--
	id로 회원 검색
	find_member_result.jsp에서 ~ 아이디에 대한 검색 결과
--%>
<form action="findMemberById.do">
	아이디 <input type = "text" name = "id">
	<input type = "submit" value = "회원검색">
</form>
<hr>
<%--MemberController - MemberService - PointDAO --%>
<form action="findPointById.do">
	아이디 <input type = "text" name = "id">
	<input type = "submit" value = "포인트정보검색">
</form>
<hr>
<%--
	MemberController - MemberService
							   register(mvo, pvo){ 
							   			                  -> MemberDAO
							   				              -> PointDAO
							   }
			 |
	 register_result.jsp : 회원 등록 및 포인트 등록 완료, 결과는 sql에서 확인
--%>
<form method = "post" action="register.do">
	아이디 <input type = "text" name = "id"><br>
	비밀번호 <input type = "password" name = "password"><br>
 	이름 <input type = "text" name = "name"><br>
	주소 <input type = "text" name = "address"><br>
	포인트 <input type = "text" name = "point"><br>
	포인트타입 <input type = "text" name = "pointType"><br>
	<input type = "submit" value = "등록">
</form>
</body>
</html>