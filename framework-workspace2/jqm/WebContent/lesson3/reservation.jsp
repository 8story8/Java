<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8"> 
    <title>jQuery Mobile Application</title>
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.0.1/jquery.mobile-1.0.1.min.css" />
	<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.0.1/jquery.mobile-1.0.1.min.js"></script>
  </head>
  <body>
<section id="result" data-role="page">
    <header data-role="header">
      <h1>jQuery Mobile</h1>
    </header>
    <!-- 연동페이지 적용해본다 -->
    <div class="content" data-role="content">
    	<p>${param.restaurant } 예약 완료</p>    	
    </div>
    <footer data-role="footer">
      <h1> KOSTA</h1>
    </footer>
  </section>
</body>
</html>