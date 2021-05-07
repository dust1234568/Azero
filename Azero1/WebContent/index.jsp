<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Azero</title>
<link href="css/board.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	  $(".tab_title li").click(function() {
	    var idx = $(this).index();
	    $(".tab_title li").removeClass("on");
	    $(".tab_title li").eq(idx).addClass("on");
	    $(".tab_cont > div").hide();
	    $(".tab_cont > div").eq(idx).show();
	  })
	});
</script>
</head>
<body id="wrap">
<%@ include file="../header.jsp" %>
	<div id="main_img">
		<img alt="main_img" src="img/core-img/logo2.png">
	</div>
	<div id="front">
		<div class="container">
	  <ul class="tab_title">
	    <li class="on">
	    	<a href="#"><span>인기</span></a>
	    </li>
	    <li>
	    	<a href="#"><span>추천</span></a>
	    </li>
	    <li>
	    	<a href="#"><span>카테고리1</span></a>
	    </li>
	    <li>
	    	<a href="#"><span>카테고리2</span></a>
	    </li>
	  </ul>
	  <div class="tab_cont">
	  	<!-- 인기 영화 -->
	    <div class="on">
			<div id="bestProduct">
				<c:forEach items="${newProductList}" var="newProductDto">
					<div id="item">
						<a href="product_detail.Azero?movieNo=${newProductDto.p_code}">
							<img alt="" src="images/product_img/${newProductDto.p_img}">
							<h3>${newProductDto.p_name}</h3>
						</a>
					</div>
				</c:forEach>
			</div>
	    </div>
	    <!-- 추천 영화 -->
	    <div>
			<div id="bestProduct">
				<c:forEach items="${newProductList}" var="newProductDto">
					<div id="item">
						<a href="product_detail.Azero?movieNo=${newProductDto.p_code}">
							<img alt="" src="images/product_img/${newProductDto.p_img}">
							<h3>${newProductDto.p_name}</h3>
						</a>
					</div>
				</c:forEach>
			</div>
	    </div>
	    <!--카테고리1 -->
	    <div>
			<div id="bestProduct">
				<c:forEach items="${newProductList}" var="newProductDto">
					<div id="item">
						<a href="product_detail.Azero?movieNo=${newProductDto.p_code}">
							<img alt="" src="images/product_img/${newProductDto.p_img}">
							<h3>${newProductDto.p_name}</h3>
						</a>
					</div>
				</c:forEach>
			</div>
	    </div>
	    <!-- 카테고리2 -->
	    <div>
			<div id="bestProduct">
				<c:forEach items="${newProductList}" var="newProductDto">
					<div id="item">
						<a href="product_detail.Azero?movieNo=${newProductDto.p_code}">
							<img alt="" src="images/product_img/${newProductDto.p_img}">
							<h3>${newProductDto.p_name}</h3>
						</a>
					</div>
				</c:forEach>
			</div>
	  	</div>
	  </div>
	</div>
		<div id="bestProduct">
			<c:forEach items="${bestProductList}" var="bestProductDto">
				<div id="item">
					<a href="product_detail.Azero?movieNo=${newProductDto.p_code}">
						<img alt="" src="images/product_img/${newProductDto.p_img}">
						<h3>${newProductDto.p_name}</h3>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>
<%@ include file="../footer.jsp" %>
</body>
</html>