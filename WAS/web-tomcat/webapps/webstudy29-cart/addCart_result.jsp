<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	if(confirm("Cart에 추가! Cart로 이동하시겠습니까?")){
		location.href = "cart.jsp";
	}
	else{
		location.href = "index.jsp";
	}
</script>