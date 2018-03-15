<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>springmvc MultiActionController 활용</title>
</head>
<body>
springmvc MultiActionController 활용 <br><br>
<a href="test.do">test</a><br><br>
<!-- 
		MultiActionController를 상속받은 MemberController를
		테스트 
 -->
 <a href="member.do?command=insert">회원등록</a><br>
 <a href="member.do?command=update">회원수정</a><br>
 <form action="member.do" method="post">
 아이디 <input type="text" name="id"><br>
 패스워드 <input type="password" name="password"><br>
 이름 <input type="text" name="name"><br>
 주소 <input type="text" name="address"><br>
 <input type="hidden" name="command" value="register">
  <input type="submit" value="등록">
 </form>
 <hr>
 <a href="car.do?command=findCar"> CarController test</a>
</body>
</html>
















