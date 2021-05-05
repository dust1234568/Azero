<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Azero</title>
</head>
<body id="wrap">
<%@ include file="../header.jsp" %>
	<div id="main_img">
		<img alt="main_img" src="images/product_img/w2.jpg">
	</div>
	<div id="front">
		<h2>New Item</h2>
		<div id="bestProduct"><!-- 컬랙션이름, 대명사 -->
			<c:forEach items="${newProductList}" var="newProductDto">
				<div id="item">
					<a href="product_detail.Azero?p_code=${newProductDto.p_code}">
						<img alt="" src="images/product_img/${newProductDto.p_img}">
						<h3>${newProductDto.p_name}</h3>
						<p><fmt:formatNumber value="${newProductDto.p_price2}" type="currency"></fmt:formatNumber></p>
					</a>
				</div>
			</c:forEach>
		</div>
		<h2>Best Item</h2>
		<div id="bestProduct">
			<c:forEach items="${bestProductList}" var="bestProductDto">
				<div id="item">
					<a href="product_detail.Azero?p_code=${bestProductDto.p_code}">
					<img alt="" src="images/product_img/${bestProductDto.p_img}">
						<h3>${bestProductDto.p_name}</h3>
						<p><fmt:formatNumber value="${bestProductDto.p_price2}" type="currency"></fmt:formatNumber></p>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>
<%@ include file="../footer.jsp" %>
</body>
</html>