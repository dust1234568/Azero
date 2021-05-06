<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search my profile</title>
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
	
	table#zipcode {
		border-collapse: collapse;
		border-top: 3px solid #fff;
		border-bottom: 3px solid #fff;
		width: 100%;
		margin-top: 15px;
	}
	
	table#zipcode th, table#zipcode td {
		text-align: center;
		border-bottom: 1px dotted #fff;
		color: #808080;
	}
	
	table th, td {
		padding: 10px;
	}
	
	table#zipcode a {
		display: block;
		height: 20px;
		text-decoration: none;
		color: #808080;
		padding: 10px;
	}
	
	table#zipcode a:hover {
		color: #F90;
		font-weight: bold;
	}
	
</style>
<script type="text/javascript">
	function result(zipNum, sido, gugun, dong, bunji) {
		opener.document.frm.zipNum.value = zipNum;
		opener.document.frm.addr1.value = sido + " " +  gugun + " " + dong + " " + bunji;
		self.close();
	}
</script>
</head>
<body>
	<div id="popup">
		<h1>아이디 찾기</h1>
		<form action="findidform.Azero" name="frm" method="post">
			Email :  <input type="text" name="email">
			<input type="submit" value="찾기" class="submit">
		</form>
		<table id="zipcode">
			<tr>
				<th>주소</th>
			</tr>
			<c:forEach items="${MemList.email }" var=MemberDTO">
				<tr>
					<td>
						<input type="text" id="email" >
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>











