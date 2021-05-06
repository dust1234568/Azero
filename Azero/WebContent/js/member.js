/**
 *  약관 동의함 일경우 "join_frm.bizpoll"로 보내고 submit으로 데이터를 전송
 */
function go_next() {
	if (document.frm.okon1[0].checked == true) {
		document.frm.action = "joinform.Azero";
		document.frm.submit();
	} else if (document.frm.okon1[1].checked == true) {
		alert("약관에 동의하여야 합니다.");
	}
		
}

function idcheck() {
	if (document.frm.id.value == "") {
		alert("dd");
		document.frm.id.focus();
		return;
	}
	
	var url ="idcheckform.Azero?id=" + document.frm.id.value;
	
	var w = 400;
	var h = 200;
	
	var LeftPosition = (screen.width-w)/2;
	var TopPosition = (screen.height-h)/2;
	
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=" + w + ", height=" + h + ", top= " + TopPosition + ", left= " + LeftPosition);
}



function go_save() {
	if (document.frm.id.value == "") {
		alert("아이디를 입력해 주세요.");
		document.frm.id.focus();
	} else if (document.frm.pwd.value == "") {
		alert("비밀번호를 입력해 주세요.");
		document.frm.pwd.focus();
	} else if (document.frm.pwd.value != document.frm.pwdCheck.value) {
		alert("비밀번호가 일치 하지 않습니다.");
		document.frm.pwd.focus();
	} else if (document.frm.email.value == "") {
		alert("Email을 입력해 주세요.");
		document.frm.email.focus();
	} else if (document.frm.filename.value == "") {
		alert("프로필 사진을 넣어 주세요.");
		document.frm.filename.focus();
	} else {
		alert("회원 가입이 완료 되었습니다")
		document.frm.action = "join.Azero";
		document.frm.submit();
	}
	
}








