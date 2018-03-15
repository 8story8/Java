<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/broker.css" type="text/css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
<title>주식 거래</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#logoutBtn").click(function(){
			if(confirm("로그아웃하시겠습니까?")){
				location.href="logout.do";
			}
		});
		
		$("#tradeBtn").click(function(){						
			var symbol = $(":input[name=symbol]:checked").val();
			var tradeType = $(":input[name=tradeType]:checked").val();
			var quantity = $("#quantity").val();	
			
			if(symbol == undefined){
				alert("주식을 선택하세요!");
				return;
			}
			else if(tradeType == undefined){
				alert("거래 방식을 선택하세요!");
				return;
			}
			else if(quantity == ""){
				alert("수량을 입력하세요!");
				return;
			}
			else if(isNaN(quantity)){
				alert("수량을 숫자로 입력하세요!");
				return;
			}	
		
			// 주식 매도시 데이터 체크를 jQuery에서 미리 한다. 	
	 		if(tradeType == "sell"){				
				var sharesQuantity = 0;
				
				// sharesView 테이블의 첫 번째 td 중 매도 주식이 존재하는 지를 확인
				var targetShares = $("#sharesView tr td:first-child").filter(":contains('"+ symbol + "')");
				
				if(targetShares.length != 1){	   // 해당 주식을 보유하고 있지 않으면
					alert("매도하려는 "+ symbol + " 주식을 보유하고 있지 않습니다!");
					$("#reset").click();
					return;
				}
				else{   // 해당 주식을 보유하고 있으면
					sharesQuantity = parseInt(targetShares.next().text());
				
					if(parseInt(quantity) > sharesQuantity){
						alert(symbol + " 주식 보유량보다 매도량이 많습니다!");
						$("#reset").click();
						return;
					} 
				}				
			} 
		
	 		$.ajax({
				type:"POST",
				url:"trade.do",				
				data:$("#tradeForm").serialize() + "&id = ${sessionScope.cvo.id}",
				dataType:"json",   
				success:function(result){ 					
					if(result.error == "fail"){
						alert(result.message);					
					}
					else{
						var newInfo = "";
						
						$.each(result, function(index, sh){
							 newInfo += "<tr><td>" + sh.symbol + "</td>";
							 newInfo += "<td>" + sh.quantity + "</td>";
							 newInfo += "<td>" + sh.totalPrice + "</td></tr>";
						});
						
						$("#sharesView").html(newInfo);
					}
					$("#reset").click();
				}   // success
		  	});   // ajax 			 	 			
		 });   // click			
});   // ready
</script>
</head>
<body>
	<c:import url = "header.jsp"></c:import>
	<h3>Stock Market</h3>
<form id="tradeForm">
	<table>
		<c:forEach items="${requestScope.stockList}" var="stock">
			<tr>
				<td><input type="radio" name="symbol" value="${stock.symbol}"></td>
				<td>${stock.symbol}</td>
				<td>${stock.price }</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${sessionScope.cvo != null}">
       	<input type = "radio" name = "tradeType" value = "buy"> 매수
		<input type = "radio" name = "tradeType" value = "sell"> 매도<br>
	 	수량 : <input type="text" size=5  name="quantity" id="quantity">	
		<input type = "button" value = "거래하기" id = "tradeBtn">
		<input type="reset" id="reset" value=reset><br>
		
		<table>
			<thead>
				<tr>
					<td>주식명</td>
					<td>수량</td>
					<td>총액</td>
				</tr>
			</thead>		
			<tbody id = "sharesView">
				<c:forEach items = "${requestScope.sharesList}" var = "share">
					<tr>
						<td>${share.symbol}</td>
						<td>${share.quantity}</td>
						<td>${share.totalPrice}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
	</c:if>	
</form>	
</body>
</html>