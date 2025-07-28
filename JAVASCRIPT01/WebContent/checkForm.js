/** 
 * join.html 파일의 입력 유효성 검사를 진행하는 js file
 * <input> 데이터를 모두 입력했는지 여부
 * 입력된 데이터 조건 검사
 * 비밀번호와 비밀번호 확인 일치 여부
 * 라디오버튼 체크박스 체크 여부
 */

// 태그가 모두 준비되고 나서 유효성 검사
window.onload = function() {
	//var form_var = document.getElementById('joinForm');
	document.getElementById('joinForm').onsubmit = function() {
		
		var name = document.getElementById('name');
		if (name.value == "") {
			alert("성명을 입력하세요.");
			name.focus();
			return false;
		}
		
		var id = document.getElementById('id');
		if (id.value == "") {
			alert("아이디를 입력하세요.");
			id.focus();
			return false;
		}
		if (id.value.length < 6 || 10 < id.value.length) {
			alert("아이디는 6~10자로 입력하세요. ");
			id.value = "";
			id.focus();
			return false;
		}
		
		var password = document.getElementById('password');
		var passwordCheck = document.getElementById('passwordCheck');
		if (password.value.length < 10 || 20 < password.value.length) {
			alert("비밀번호는 10~20자로 입력하세요. ");
			password.value = "";
			passwordCheck.value = "";
			password.focus();
			return false;
		}
		if (password.value != passwordCheck.value) {
			alert("비밀번호가 일치하지 않습니다.");
			passwordCheck.value = "";
			passwordCheck.focus();
			return false;
		}
		
		var job = document.getElementById('job');
		if (job.selectedIndex == 0) {
			alert("직업을 선택하세요.");
			return false;
		}
		
		var check = false;
		for (var i = 0; i < joinForm.emailRcv.length; i++)
			if (joinForm.emailRcv[i].checked)
				check = true;
		
		if (check == false) {
			alert("이메일 수신여부를 선택하세요.");
			return false;
		}
		
		var agreement1 = document.getElementById('agreement1');
		var agreement2 = document.getElementById('agreement2');
		if (agreement1.checked == false || agreement2.checked == false) {
			alert("모두 동의해야 합니다. ");
			return false;
		}
		
	}; //onsubmit 끝
	
}; //window.onload 끝