<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
s	<table align="center" border="1" style="border-collapse: collapse;" width="80%">
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
</body>
</html>