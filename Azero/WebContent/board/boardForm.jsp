<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#preview").attr("src", e.target.result);
			}
			
			reader.readAsDataURL(input.files[0]);
		}
	}
	
	function backToList(obj) {
		obj.action="boardList.bizpoll";
		obj.submit();
	}
</script>
</head>
<body>
	<h1 style="text-align: center;">새글 쓰기</h1>
	<form action="boardAdd.bizpoll" name="articleForm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${sessionScope.loginUser.id}">
		<table border="0" align="center">
			<tr>
				<td align="right">글 제목 : </td>
				<td colspan="2"><input type="text" size="67" maxlength="500" name="subject"></td>
			</tr>
			<tr>
				<td align="right">글 내용 : </td>
				<td colspan="2"><textarea name="content" rows="10" cols="65"></textarea></td>
			</tr>
			<tr>
				<td align="right">이미지파일 첨부 : </td>
				<td>
					<input type="file" name="filename" onchange="readURL(this);">
				</td>
				<td><img id="preview" alt="preview" src="#" width="200" height="200"></td>
			</tr>
			<tr>
				<td align="right"></td>
				<td colspan="2">
					<input type="submit" value="글쓰기">
					<input type="button" value="목록보기" onclick="backToList(this.form);">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ include file="../footer.jsp"%>