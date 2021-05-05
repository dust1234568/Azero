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
<div id="wrap">
	<header>
		<div id="logo">
			<a href="index.Azero"><img alt="" src="images/product_img/w2.jpg" border="1" style="border-color: black" width="180" height="100"></a>
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
						<li style="color: orange">
							${sessionScope.loginUser.id }(${sessionScope.loginUser.email })
						</li>
						<li><a href="logout.Azero">LOGOUT</a></li>
						<li>|</li>
						<li><a href="mypages.Azero">MY PAGE</a></li>
					</c:otherwise>
				</c:choose>
				<li>|</li>
				<li><a>CART</a></li>
				<li>|</li>
				<li><a>Q&amp;A(1:1)</a></li>
				<li>|</li>
				<li><a>APP</a></li>
				<li>|</li>
				<li><a href="tabboard.Azero">Board</a></li>
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
	
