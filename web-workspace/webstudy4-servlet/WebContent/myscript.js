function checkForm1(){
	var memId = document.registerForm.memId.value;
	var memPass = document.registerForm.memPass.value;
	var confirmPass = document.registerForm.confirmPass.value;
	var blood = document.registerForm.blood.value;
	var gender = document.registerForm.gender.value;
	
	if(memId.length < 3 || memId.length > 10){
		alert("아이디는 3자 이상 10자 이하입니다. 다시 입력해주세요!");
		return false;
	}
	
	if(memPass.length < 5){
		alert("비밀번호는 5자 이상입니다. 다시 입력해주세요!");
		return false;
	}
	
	if(memPass != confirmPass){
		alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요!");
		return false;
	}
	
	if(gender == ""){
		alert("성별을 입력해주세요!");
		return false;
	}
	
	if(blood == ""){
		alert("혈액형을 입력해주세요!");
		return false;
	}
}

function checkForm2(){
	var userAge = document.EnterForm.userAge.value;
	
	if(isNaN(userAge)){
		alert("나이는 숫자로 입력하세요!");
		return false;
	}
}