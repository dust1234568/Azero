<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<article>
		<h1>로그인</h1>
		<form action="login.Azero" method="post">
			<fieldset>
				<legend></legend>
				<label>User ID</label>
				<input name="id" type="text">
				<label>Password</label>
				<input name="pwd" type="password">
			</fieldset>
			<div id="buttons">
				<input type="submit" value="로그인" class="submit">
				<input type="button" value="회원가입" class="cancel" onclick="location='contract.Azero'">
				<input type="button" value="아이디 / 비밀번호 찾기" class="submit" onclick="location='find_id_form.Azero'">
			</div>
		</form>
	</article>
	
</body>
</html>