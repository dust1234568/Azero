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
					url : "id_check_form.Azero",
					dataType : "json",
					data : "id=" + id,
					success : function(data) {
						/* alert("data.message" + data.message); */
						if (data.message == "1") {
							$("#message").html("사용 불가능 아이디 입니다.").css("color","red");
							$("#reid").val("-1");
						} else {
							$("#message").html("사용 가능 아이디 입니다.").css("color","green");
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
	
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#preview").attr("src", e.target.result);
			}
			
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
	<article>
		<h2>Join Us</h2>
		<form action="join.Azero" id="join" method="post" name="frm">
			<fieldset>
				<img id="preview" alt="preview" src="#" width="100" height="100" border="50%">
				<legend>Sign Up</legend>
				<label>User ID</label>
				<input type="text" name="id" id="idChk">&nbsp;<span id="message"></span>
				<input type="hidden" name="reid" id="reid"><br>
				<label>Password</label>
				<input type="password" name="pwd"><br>
				<label>Retype Password</label>
				<input type="password" name="pwdCheck"><br>
				<label>Email</label>
				<input type="text" name="email" ><br>
				<label>Profile Photo</label>
				<input type="file" name="filename" onchange="readURL(this);">
			</fieldset>
			<div id="buttons">
				<input type="button" value="회원가입" class="submit" onclick="go_save();">
				<input type="reset" value="취소" class="cancel">
			</div>
		</form>
	</article>
