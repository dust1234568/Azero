<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div id="item">
			<img alt="" src="images/product_img/${productDetail.p_img}">
			<h3>${productDetail.p_name}</h3>
			<p><fmt:formatNumber value="${productDetail.p_price2}" type="currency"></fmt:formatNumber></p>
		</div>
	</div>
</body>
</html>
<%@ include file="../footer.jsp"%>