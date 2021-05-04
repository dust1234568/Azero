<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardView</title>
<script type="text/javascript">
	
	function delView(obj) {
		
	}
	
	function backToList(obj) {
		obj.action="boardList.bizpoll";
		obj.submit();
	}
	
</script>
</head>
<body>
	<h1 style="text-align: center;">게시글</h1>
	<form action="boardView.bizpoll" name="articleForm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${sessionScope.loginUser.id}">
		<table border="0" align="center">
			<tr>
				<td align="right">글 제목 : </td>
				<td colspan="2"><input type="text" size="67" maxlength="500" name="subject" readonly="readonly" value="${boardView.subject}"></td>
			</tr>
			<tr>
				<td align="right">글 내용 : </td>
				<td colspan="2"><input name="content" size="67" readonly="readonly" value="${boardView.content}"></td>
			</tr>
			<tr>
				<td align="right">이미지 : </td>
				<td><img id="preview" alt="preview" src="images/board/${boardView.articleNo}/${boardView.fileName}" width="200" height="200"></td>
			</tr>
			<tr>
				<td align="right">작성일자 : </td>
				<td align="left" colspan="2"><input name="sysdate" readonly="readonly" value="${boardView.reg_date}"></td>
			</tr>
			<tr>
				<td align="right"></td>
				<td colspan="2">
					<c:choose>
						<c:when test="${sessionScope.loginUser.id}=${document.articleForm.id}">
							<input type="submit" value="수정">
							<input type="button" value="삭제" onclick="delView(this.form);">
						</c:when>
					</c:choose>
					<input type="button" value="목록" onclick="backToList(this.form);">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ include file="../footer.jsp"%>