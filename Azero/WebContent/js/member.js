/**
 *  약관 동의함 일경우 "join_frm.bizpoll"로 보내고 submit으로 데이터를 전송
 */
function go_next() {
	if (document.frm.okon1[0].checked == true) {
		document.frm.action = "join_form.Azero";
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
	
	var url ="id_check_form.Azero?id=" + document.frm.id.value;
	
	var w = 400;
	var h = 200;
	
	var LeftPosition = (screen.width-w)/2;
	var TopPosition = (screen.height-h)/2;
	
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=" + w + ", height=" + h + ", top= " + TopPosition + ", left= " + LeftPosition);
}

function post_zip() {
	var url = "find_zip_num.Azero";
	
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=300 top=300, left=300 ");
}

function go_save() {
	if (document.frm.id.value == "") {
		alert("아이디를 입력해 주세요.");
		document.frm.id.focus();
//	} else if (document.frm.id.value != "-1") {
//		document.frm.reid.focus();
//	} else if (document.frm.id.value != document.frm.reid.value) {
//		alert("아이디 중복체크를 해 주세요.");
	} else if (document.frm.pwd.value == "") {
		alert("비밀번호를 입력해 주세요.");
		document.frm.pwd.focus();
	} else if (document.frm.pwd.value != document.frm.pwdCheck.value) {
		alert("비밀번호가 일치 하지 않습니다.");
		document.frm.pwd.focus();
	} else if (document.frm.name.value == "") {
		alert("이름을 입력해 주세요.");
		document.frm.name.focus();
	} else if (document.frm.email.value == "") {
		alert("이메일을 입력해 주세요.");
		document.frm.email.focus();
	} else {
		document.frm.action = "join.Azero";
		document.frm.submit();
	}
	
}








