function testSrc(){
	alert("거지야");
}

function checkForm(){
	/* 
	var menu = document.menuForm.menu;
	var count = document.menuForm.count;
	
	for(var i = 0 ; i < menu.length; i++){
		if(menu[i].checked){
			if(count.value == ""){
				alert("수량을 입력하세요!");
				return false;
			}
			else if(isNaN(count.value)){
				alert("숫자로 입력하세요!");
				return false;
			}
			else{
				return true;
			}
		}
		else{
			alert("메뉴를 선택하세요!");
			return false;
		}
	} 
	*/
	
	var mf = document.menuForm;
	var flag = false;
	
	for(var i = 0; i < mf.menu.length; i++){
		if(mf.menu[i].checked){
			flag = true;
			break;
		}
	}
	
	if(flag == false){
		alert("메뉴를 선택하세요!");
		return false;
	}
	
	if(mf.count.value == ""){
		alert("수량을 입력하세요!");
		return false;
	}
	
	if(isNaN(mf.count.value)){
		alert("숫자로 입력하세요!");
		return false;
	}
}