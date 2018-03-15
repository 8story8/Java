<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="model.MemberDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%     String id=request.getParameter("id");		 
		  boolean flag=MemberDAO.getInstance().checkId(id);
		  String message=null;
		  String color=null;
		  
		  if(flag){
			  color="orange";
			  message=id+"는 사용불가!";
		  }
		  else{
			  color="yellow";
			  message=id+"는 사용가능";
		  }
	%>
<script type="text/javascript">
	function closeWindow(result){
		var registerForm = window.opener.document.registerForm;
		//alert(result);
		if(result=="true"){//사용불가일 경우 본 창의 아이디를 지운 후 포커스 준다
			registerForm.id.value="";
			registerForm.flag.value="";
			registerForm.id.focus();			
		}else{// 사용가능할 경우 본 창의 패스워드에 포커스를 준다. 
			//of.flag.value=of.id.value;
			//또는 아래처럼 
			registerForm.flag.value="<%=id%>";
			registerForm.pw.focus();
		}		
	}
</script>
</head>

<body bgcolor="<%=color %>" onunload="closeWindow('<%=flag%>')">	
	<%=message %><br><br>
	<input type="button" value="확인" onclick="javascript:self.close()">
</body>
</html>














