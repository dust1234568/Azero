<%@page import="com.bizpoll.dto.MemberDTO"%>
<%@page import="com.bizpoll.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
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
	String address = mDto.getAddress();
	String phone = mDto.getPhone();
	String zipNum = mDto.getZip_num();
	
%>
	<article>
		<h1>회원 정보 수정</h1>
		<form action="mypages.bizpoll" method="post">
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
			<fieldset>
					<legend></legend>
					<label>Zip Code</label>
					<input type="text" value="<%=zipNum %>" name="zipNum" size="10">
					<input type="button" value="주소 수정" class="dup" onclick="post_zip();"><br>
					<label>Address</label>
					<input type="text" value="<%=address %>" name="addr1" size="50"><br>
					<input type="text" name="addr2" size="25"><br>
					<label>Phone Number</label>
					<input type="text" value="<%=phone %>" name="phone">
				</fieldset>
			<div id="buttons">
				<input type="submit" value="수정" class="submit">
				<input type="button" value="확인" class="cancel" onclick="location='index.bizpoll'">
			</div>
		</form>
	</article>
<%@ include file="../footer.jsp" %>
</body>
</html>