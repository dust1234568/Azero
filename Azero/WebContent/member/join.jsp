<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="js/member.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#idChk").blur(function(){
			/* alert("포커스 읽음"); */
			var id = $("#idChk").val();
			
			if (id == "") {
				$("#idChk").val("필수 입력 항목입니다.").css("background-color","red");
			} else {
				$("#idChk").css("background-color","white");
				$.ajax({
					type : "POST",
					url : "id_check_form.bizpoll",
					dataType : "json",
					data : "id=" + id,
					success : function(data) {
						/* alert("data.message" + data.message); */
						if (data.message == "1") {
							$("#message").html("사용 불가능 아이디 입니다.").css("color","red");
							$("#reid").val("-1");
						} else {
							$("#message").html("사용 가능 아이디 입니다.").css("color","blue");
							$("#reid").val("1");
						}
					},
					fail : function() {
						alert("error");
						
					}
				});
			}
		});
	});
</script>
	<article>
		<h2>Join Us</h2>
		<form action="join.Azero" id="join" method="post" name="frm">
			<fieldset>
				<legend>Basic Info</legend>
				<label>User ID</label>
				<!-- <input type="text" name="id" size="12"> -->
				<input type="text" name="id" id="idChk">&nbsp;<span id="message"></span>
				<input type="hidden" name="reid" id="reid"><br>
				<!-- <input type="button" value="중복 체크" class="dup" onclick="idcheck();"><br> -->
				<label>Password</label>
				<input type="password" name="pwd"><br>
				<label>Retype Password</label>
				<input type="password" name="pwdCheck"><br>
				<label>Name</label>
				<input type="text" name="name"><br>
				<label>Email</label>
				<input type="text" name="email">
			</fieldset>
			<fieldset>
				<legend>Optional</legend>
				<label>Zip Code</label>
				<input type="text" name="zipNum" size="10">
				<input type="button" value="주소찾기" class="dup" onclick="post_zip();"><br>
				<label>Address</label>
				<input type="text" name="addr1" size="50"><br>
				<input type="text" name="addr2" size="25"><br>
				<label>Phone Number</label>
				<input type="text" name="phone">
			</fieldset>
			<div id="buttons">
				<input type="button" value="회원가입" class="submit" onclick="go_save();">
				<input type="reset" value="취소" class="cancel">
			</div>
		</form>
	</article>
