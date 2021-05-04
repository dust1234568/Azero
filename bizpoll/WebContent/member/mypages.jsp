<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
</head>
<body>
	<div>
		회원 정보 수정 <input type="button" value="수정" class="submit" onclick="location='memupdates.bizpoll'">
		회원 탈퇴 <input type="button" value="탈퇴" class="submit" onclick="location='memdeletes.bizpoll'">
	</div>
	<%@ include file="../footer.jsp" %>
</body>
</html>