<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<style type="text/css">
	.modal_wrap{
        display: none;
        width: 500px;
        height: 500px;
        position: absolute;
        top:50%;
        left: 50%;
        margin: -250px 0 0 -250px;
        background:#eee;
        z-index: 2;
        border-radius: 15px;
    }
    .black_bg{
        display: none;
        position: absolute;
        content: "";
        width: 100%;
        height: 100%;
        background-color:rgba(0, 0,0, 0.5);
        top:0;
        left: 0;
        z-index: 1;
    }
    .modal_close{
        width: 26px;
        height: 26px;
        position: absolute;
        top: -30px;
        right: 0;
    }
    .modal_close> a{
        display: block;
        width: 100%;
        height: 100%;
        background:url(https://img.icons8.com/metro/26/000000/close-window.png);
        text-indent: -9999px;
    }
    h1 {
    	text-align: center;
    	font-size: 30px;
    	color: black;
    }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	window.onload = function() {
	
	function onClick() {
	    document.querySelector('.modal_wrap').style.display ='block';
	    document.querySelector('.black_bg').style.display ='block';
	}   
	function offClick() {
	    document.querySelector('.modal_wrap').style.display ='none';
	    document.querySelector('.black_bg').style.display ='none';
	}
	
	document.getElementById('modal_btn').addEventListener('click', onClick);
	document.querySelector('.modal_close').addEventListener('click', offClick);
	
	};
</script>
</head>
<body>
	<article>
		<h1>로그인</h1>
		<form action="login.Azero" method="post">
			<fieldset>
				<legend></legend>
				<label>User ID</label>
				<input name="id" type="text">
				<label>Password</label>
				<input name="pwd" type="password">
			</fieldset>
			<div id="buttons">
				<button type='button' id="modal_btn">아이디 찾기</button>
					<div class="black_bg"></div>
					<div class="modal_wrap">
					    <div class="modal_close"><a href="#">close</a></div>
					    <div>
					       <h1>아이디 찾기</h1><br>
								Email :  <input type="text" name="email"><br>
								<input type="submit" value="찾기" class="submit">
							<table id="zipcode">
								<c:forEach items="${sessionScope.email }" var="MemberDTO">
									<tr>
										<td>
											<input type="text" id="email" >
										</td>
									</tr>
								</c:forEach>
							</table>
					    </div>
					</div>
					<button type='button' id="modal_btn">비밀번호 찾기</button>
					<div class="black_bg"></div>
					<div class="modal_wrap">
					    <div class="modal_close"><a href="#">close</a></div>
					    <div>
					       <h1>비밀번호 찾기</h1><br>
								ID :  <input type="text" name="id">
								Email : <input type="text" name="eamil"><br>
								<input type="submit" value="찾기" class="submit">
							<table id="zipcode">
								<c:forEach items="${sessionScope.email }" var="MemberDTO">
									<tr>
										<td>
											<input type="text" id="email" >
										</td>
									</tr>
								</c:forEach>
							</table>
					    </div>
					</div>
					<button type='button' id="modal_btn">회원 가입</button>
					<div class="black_bg"></div>
					<div class="modal_wrap">
					    <div class="modal_close"><a href="#">close</a></div>
					    <div>
					       <h1>Sign Up</h1><br>
								ID : <input type="text" name="id"><br>
								Pwd : <input type="password" name="pwd"><br>
									  <input type="password" name="rePwd"><br>
								Email : <input type="text" name="email"><br>
								<input type="submit" value="OK" class="submit">
					    </div>
					</div>
				
			</div>
			<div>
				<input type="submit" value="로그인" class="submit">
				<input type="button" value="비밀번호 찾기" class="submit" onclick="location='findidform.Azero'">
				<input type="button" value="회원가입" class="cancel" onclick="location='contract.Azero'">
			</div>
		</form>
	</article>
	
</body>
</html>
<%@ include file="../footer.jsp" %>