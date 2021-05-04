<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<style type="text/css">
	body {
		background-color: #fff;
		font-family: Verdana;
	}
	
	#popup {
		padding: 0 10px;
	}
	
	#popup h1 {
		font-family: Arial, Helvetica, sans-serif;
		font-size: 45px;
		color: #808080;
		font-weight: normal;
	}
</style>
<script type="text/javascript">
	function backToPage(obj) {
		obj.action="mypages.Azero";
		obj.submit();
	}
</script>
</head>
<body>
	<div id="popup">
		<h1>회원 탈퇴</h1>
		<form action="mem_delete_pop.Azero" name="frm" method="post">
			ID : <input type="text" name="id">
			PW : <input type="text" name="pw">
			<input type="submit" value="삭제" class="submit">
			<input type="button" value="취소" onclick="backToPage(this.form);">
		</form>
	</div>
</body>
</html>

