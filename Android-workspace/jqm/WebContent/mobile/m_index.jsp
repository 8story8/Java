<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--   html5 형식으로 모바일 페이지 레이아웃을 정의
	    하나의 html 문서에서 여러 페이지를 정의해보자 
	    data-role이 page 인 영역 태그를 여러개 작성하면 된다. 
	    <section data-role="page" id="page1"></section>
	    위 형식으로 여러개 작성 
	    
	    페이지 사이 이동 -> <a href="#page1">첫번째 페이지로</a>
	    즉 링크에서 페이지 아이디를 명시하면 된다. 
  -->

<!DOCTYPE html>
<html>
<head>
<!-- 인코딩 지정 -->
<meta charset="UTF-8">
<!-- viewport: 모바일스크린에서 사용자가 실제로 보는 작은 창
      width=device-width : 기기의 전체 폭 
      initial-scale=1.0 : 원본 그대로 렌더링(표현)한다.        
 -->
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>Insert title here</title>
<!-- jquery mobile 페이지 레이아웃과 스타일을 정의 -->
<link rel="stylesheet"
  href="http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.css" />
<!-- jquery library -->
<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
<!-- jquery mobile library -->
<script src="http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.js"></script>
</head>
<body>
<!-- 첫번째 페이지 시작  -->
<section data-role="page" id="page1">
	<header data-role="header">
		<h1>jQuery Mobile1</h1>
	</header>
	<div class="content" data-role="content">
	<p>첫번째 페이지</p> 
	<!-- 두번째 페이지 이동 링크 작성 -->
	<p><a href="#page2" >두번째로 이동</a></p>
	</div>
	<footer data-role="footer">
		<h1>kosta</h1>
	</footer>
</section>
<!-- 첫번째 페이지 끝  -->
<section data-role="page" id="page2">
	<header data-role="header">
		<h1>jQuery Mobile2</h1>
	</header>
	<div class="content" data-role="content">
	<p>두번째 페이지</p>
	<!-- 첫번째 페이지 이동 링크 작성 -->
	<p><a href="#page1" >첫번째로 이동</a></p>
	</div>
	<footer data-role="footer">
		<h1>KOSTA</h1>
	</footer>
</section>
</body>
</html>