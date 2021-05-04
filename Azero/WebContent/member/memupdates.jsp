<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.dust.dto.MemberDTO"%>
<%@page import="com.dust.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Update</title>
</head>
<body>

<%
	String userId = session.getAttribute("loginUser").toString();
	MemberDAO mDao = MemberDAO.getInstance();
	MemberDTO mDto = mDao.getMember(userId);
	
	String id = mDto.getId();
	String pwd = mDto.getPwd();
	String name = mDto.getName();
	String email = mDto.getEmail();
	
%>
	<article>
		<h1>회원 정보 수정</h1>
		<form action="mypages.Azero" method="post">
			<fieldset>
				<legend></legend>
				<label>User ID</label>
				<input name="id" type="text" value="<%=id %>" readonly="readonly"><br>
				<label>Password</label>
				<input name="pwd" type="password"><br>
				<label>New Password</label>
				<input name="pwd" type="password"><br>
				<label>New Password Check</label>
				<input name="repwd" type="password"><br>
				<label>Name</label>
				<input name="irum" type="text" value="<%=name %>" readonly="readonly"><br>
				<label>Email</label>
				<input name="email" type="text" value="<%=email %>"><br>
			</fieldset>
			<div id="buttons">
				<input type="submit" value="수정" class="submit">
				<input type="button" value="확인" class="cancel" onclick="location='index.Azero'">
			</div>
		</form>
	</article>
</body>
</html>