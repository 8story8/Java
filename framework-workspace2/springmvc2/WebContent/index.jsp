<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>springmvc2</title>
</head>
<body>
springmvc2 <br><br>
<a href="my.kosta">MyController test</a>
<!-- 	1. spring 설정 파일 
		2. 요청하면 controller.MyController 실행 후 
		3. result.jsp가 응답 
 -->
 <form action="findMember.kosta">
 ID <input type="text" name="memberId">
 <input type="submit" value="검색">
 </form>
 <!-- 	아이디 입력 후 검색을 누르면 
 		/response/find_ok.jsp 에서  java  임경수 구미 
 		/response/find_fail.jsp 에서는 검색 결과 없음 
 		
 		FindMemberController 에서는 MemberService 타입의 구현체를 
 		DI 로 확보한다 ( 생성자 주입 ) 
 		이를 이용해 검색 성공 여부를 판단하여 응답하도록 처리한다 
  -->
</body>
</html>



















