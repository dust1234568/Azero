<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- <c:set var="selAllBoardList" value="${selAllBoardList}"/>
<c:set var="boardListAllCnt" value="${boardListAllCnt}"/>
<c:set var="section" value="${section}"/>
<c:set var="pageNum" value="${pageNum}"/> --%>

<%@ include file="../header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">
	.cls1 {
		text-decoration: none;
		color: black;
	}
	
	.cls2 {
		text-align: center;
		font-size: 30px;
	}
</style>
<script type="text/javascript">
	function uLogin() {
		if (document.id.value = "") {
			alert("로그인이 되어 있지 않습니다.");
			location.href ="login_form.bizpoll";
		} else {
			location.href ="boardForm.bizpoll";
		}
	}
	
</script>
<script type="text/javascript">
	function boardWrite() {
		var id = "${sessionScope.loginUser.id}";
		
		if (id == "") {
			alert("로그인이 되어 있지 않습니다.");
			location.href ="login_form.bizpoll";
		} else {
			location.href ="boardForm.bizpoll";
		}
	}
</script>
</head>
<body>
	<h1 class="cls2">게시판</h1>
	<table align="center" border="1" style="border-collapse: collapse;" width="80%">
		<thead>
			<tr height="10"align="center"bgcolor="lightgray">
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty boardInfo.selAllBoardList}">
					<tr height="10">
						<th colspan="5">
							<p align="center">
								<b><span style="font-size: 20px;">등록된 글이 없습니다.</span></b>
							</p>
						</th>
					</tr>
				</c:when>
				<c:when test="${!empty boardInfo.selAllBoardList}">
					<c:forEach items="${boardInfo.selAllBoardList}" var="selAllBoardListDTO" varStatus="status">
						<tr>
							<td width="5%">${selAllBoardListDTO.articleNo}</td>
							<td width="20%">${selAllBoardListDTO.id}</td>
							<td width="45%" style="text-align: left;">
								<span style="padding-left: 10px;"></span>
								<c:choose>
									<c:when test="${selAllBoardListDTO.re_level > 1 }">
										<c:forEach begin="2" end="${selAllBoardListDTO.re_level }" step="1">
											<span style="padding-left: 20px;"></span>
										</c:forEach>
										<span style="font-size: 12px;">[답변]</span>
										<a class="cls1" href="boardView.bizpoll?articleNo=${selAllBoardListDTO.articleNo }">${selAllBoardListDTO.subject}</a>
									</c:when>
									<c:otherwise>
									<a class="cls1" href="boardView.bizpoll?articleNo=${selAllBoardListDTO.articleNo }">${selAllBoardListDTO.subject}</a>
								</c:otherwise>
								</c:choose>
							</td>
							<td width="20%"><fmt:formatDate value="${selAllBoardListDTO.reg_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td width="10%">${selAllBoardListDTO.readcount}</td>
						</tr>						
					</c:forEach>
				</c:when>
			</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5" align="center">
					<div class="cls2">
						<c:if test="${!empty boardInfo.boardListAllCnt}">
							<c:choose>
								<c:when test="${boardInfo.boardListAllCnt > 100 }">
									<c:forEach var="page" begin="1" end="10" step="1">
										<c:if test="${boardInfo.section > 1 && page == 1}">
											<a class="no-uline" href="boardList.bizpoll?section=${boardInfo.section-1}&pageNum=${(boardInfo.section-1)*10+1}">&nbsp;pre</a>
										</c:if>
										<a class="no-uline" href="boardList.bizpoll?section=${boardInfo.section }&pageNum=${page}">${(boardInfo.section-1)*10 + page} </a>
										<c:if test="${page == 10 }">
											<a class="no-uline" href="boardList.bizpoll?section=${boardInfo.section+1}&pageNum=${(boardInfo.section+1)*10+1}">&nbsp;next</a>
										</c:if>
									</c:forEach>
								</c:when>
								<c:when test="${boardInfo.boardListAllCnt == 100 }">
									<c:forEach var="page" begin="1" end="10" step="1">
										<a class="no-uline" href="#">${boardInfo.pageNum }</a>
									</c:forEach>
								</c:when>
								<c:when test="${boardInfo.boardListAllCnt < 100 }">
									<c:forEach var="page" begin="1" end="${boardInfo.boardListAllCnt/10 +1 }" step="1">
										<c:choose>
											<c:when test="${page == boardInfo.pageNum }">
												<a class="sel-page" href="boardList.bizpoll?section=${boardInfo.section }&pageNum=${page}">${page }</a>
											</c:when>
											<c:otherwise>
												<a class="no-uline" href="boardList.bizpoll?section=${boardInfo.section }&pageNum=${page}">${page }</a>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:when>
							</c:choose>
						</c:if>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="5" align="center">
					<form action="boardList.bizpoll" method="get">
						<select name="searchType" id="searchType">
							<option value="t" <c:out value="${boardInfo.searchType == 't' ? 'selected' : '' }"/>>제목</option>
							<option value="c" <c:out value="${boardInfo.searchType == 't' ? 'selected' : '' }"/>>내용</option>
							<option value="w" <c:out value="${boardInfo.searchType == 't' ? 'selected' : '' }"/>>작성자</option>
							<option value="tc" <c:out value="${boardInfo.searchType == 't' ? 'selected' : '' }"/>>제목 + 내용</option>
							<option value="cw" <c:out value="${boardInfo.searchType == 't' ? 'selected' : '' }"/>>내용 + 작성자</option>
							<option value="tcw" <c:out value="${boardInfo.searchType == 't' ? 'selected' : '' }"/>>제목 + 내용 + 작성자</option>
						</select>
						<input type="text" name="searchKeyword" id="searchKeyword" value="${boardInfo.searchKeyword }">
						<input type="submit" value="검색">
					</form>
				</td>
			</tr>
		</tfoot>
	</table>
	<a class="cls1" href="javascript:boardWrite()">
		<p class="cls2">글쓰기</p>
	</a>
	
	<%-- <a class="cls1" href="javascript:uLogin()">
		<input type="hidden" name="id" value="${sessionScope.loginUser.id}">
		<p class="cls2">글쓰기 1</p>
	</a>
	 --%>
	<%-- <form action="boardForm.bizpoll" name="frm" method="post" class="cls1">
		<input type="hidden" name="id" value="${sessionScope.loginUser.id}">
		<p class="cls2" href="javascript:uLogin()">글쓰기</p>
	</form> --%>
<%@ include file="../footer.jsp" %>
</body>
</html>