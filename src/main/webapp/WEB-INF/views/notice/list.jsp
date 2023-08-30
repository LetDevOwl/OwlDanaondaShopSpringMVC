<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록 조회</title>
<link rel="stylesheet" href="/resources/css/notice/listCss.css" />
</head>
<body>
	<jsp:include page="../include/header.jsp"></jsp:include>
	<main>
		<div class="noticeMain">
			<div class="noticeList">
				<h1>공지사항 목록</h1>
				<table>
					<colgroup>
						<col width="10%">
						<col width="35%">
						<col width="10%">
						<col width="25%">
						<col width="10%">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성날짜</th>
							<th>첨부파일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="notice" items="${nList }" varStatus="i">
							<tr>
								<td>${i.count }</td>
								<td><a href="/notice/detail.do?noticeNo=${notice.noticeNo }">${notice.noticeSubject }</a></td>
								<td>${notice.noticeWriter }</td>
								<td>
									<fmt:formatDate pattern="yyyy-mm-dd" value="${notice.nCreateDate }"/>
								</td>
								<td>
									<c:if test="${!empty notice.noticeFilename }">0</c:if>
									<c:if test="${empty notice.noticeFilename }">X</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr align="center">
							<td colspan="5">
								<c:if test="${pInfo.startNavi != 1 }">
									<a href="/notice/list.do?page=${pInfo.startNavi - 1 }">[이전]</a>
								</c:if>
								<c:forEach begin="${pInfo.startNavi }" end="${pInfo.endNavi }" var="p">
									<c:url var="pageUrl" value="/notice/list.do">
										<c:param name="page" value="${p }"></c:param>
									</c:url>
									<a href="${pageUrl }">${p }</a>&nbsp;
								</c:forEach>
								<c:if test="${pInfo.endNavi != pInfo.naviTotalCount }">
									<a href="/notice/list.do?page=${pInfo.endNavi + 1 }">[다음]</a>
								</c:if>
							</td>
						</tr>
						<tr>
							<td colspan="4">
								<form action="/notice/search.do" method="get">
									<select name="searchCondition">
										<option value="all">전체</option>
										<option value="writer">작성자</option>
										<option value="title">제목</option>
										<option value="content">내용</option>
									</select>
									<input type="text" name="searchKeyword" placeholder="검색어를 입력하세요">
									<input type="submit" value="검색">
								</form>
							</td>
							<td>
								<div class="noticeInsert">
									<a href="/notice/insert.do">글쓰기</a>
								</div>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
			
		</div>
	</main>
	<footer></footer>
</body>
</html>