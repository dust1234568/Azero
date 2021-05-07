<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link href="css/shopping.css" rel="stylesheet">
<script type="text/javascript" src="js/member.js"></script>
<!-- <script type="text/javascript" src="js/mypage.js"></script> -->
</head>
<body>
<div id="wrap" style="background-color: #EBEBEB">
	<header>
		<div id="logo">
			<a href="index.Azero"><img alt="" src="img/main.png" width="180" height="100"></a>
		</div>
		<nav id="catagory_menu">
			<ul>
				<c:choose>
					<c:when test="${empty sessionScope.loginUser}">
						<li><a href="loginform.Azero">LOGIN</a></li>
						<li>|</li>
						<li><a href="contract.Azero">JOIN</a></li>
					</c:when>
					<c:otherwise>
						<li style="width: 30px; height: 30px">
							<img alt="" src="img/core-img/favicon.png" width="30" height="30">
						</li>
						<li style="color: orange">
							${sessionScope.loginUser.id }(${sessionScope.loginUser.email })
						</li>
						<li><a href="logout.Azero">LOGOUT</a></li>
						<li>|</li>
						<li><a href="mypages.Azero">MY PAGE</a></li>
					</c:otherwise>
				</c:choose>
				<li>|</li>
				<li><a href="tabboard.Azero">고객센터</a></li>
			</ul>
		</nav>
	</header>
</div>
	<%-- <div id="member">
		<a href="member.bizpoll">login</a>
	</div>

	<form action="index.jsp" method="post">
	ID : <input type="text" name="input"/><br>
	PW : <input type="password"><br>
	<a href="member.bizpoll?id=${memLogin.id}&pwd=${memLogin.pwd}" type="button">login</a>
	</form> --%>
</body>
</html>
	
