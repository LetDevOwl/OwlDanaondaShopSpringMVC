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
	<header>
		<div class="header">
			<div class="category">
				<details>
					<summary></summary>
					<ul>
						<li><a href="/products/productList.do">
								<h3>PC주요부품</h3>
						</a></li>
						<li><a href="/products/productList.do">
								<h3>PC저장장치</h3>
						</a></li>
						<li><a href="/products/productList.do">
								<h3>모니터/사운드</h3>
						</a></li>
						<li><a href="/products/productList.do">
								<h3>PC주변기기</h3>
						</a></li>
						<li><a href="/products/productList.do">
								<h3>복합기/프린터/소프트웨어</h3>
						</a></li>
						<li><a href="/notice/list.do">
								<h3>공지사항</h3>
						</a></li>
					</ul>
				</details>
			</div>
			<div class="logoImg">
				<img src="/resources/images/computet_icon.png" />
			</div>
			<a href="/index.jsp">
				<div class="title">DANAONDA SHOP</div>
			</a>
			<div class="login_register_box">
				<c:if test="${userId ne null }">
					<a href="/user/logout.do" class="logout" style="margin-right: 8px">로그아웃</a>
					<div class="vertical_devider"></div>
					<a href="/user/mypage.do" class="myPage">마이페이지</a>
				</c:if>
				<c:if test="${userId eq null }">
					<a href="/user/login.do" class="login">로그인</a>
					<div class="vertical_devider"></div>
					<a href="/user/register.do" class="login">회원가입</a>
				</c:if>
			</div>
		</div>
	</header>
	<main>
		<hr />
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
						<c:forEach var="notice" items="${sList }" varStatus="i">
							<tr>
								<td>${i.count }</td>
								<td>${notice.noticeSubject }</td>
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
								<c:forEach begin="${pInfo.startNavi }" end="${pInfo.endNavi }" var="p">
									<c:url var="pageUrl" value="/notice/search.do">
										<c:param name="page" value="${p }"></c:param>
										<c:param name="searchCondition" value="${searchCondition }"></c:param>
										<c:param name="searchKeyword" value="${searchKeyword }"></c:param>
									</c:url>
									<a href="${pageUrl }">${p }</a>&nbsp;
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td colspan="4">
								<form action="/notice/search.do" method="get">
									<select name="searchCondition">
										<option value="all" <c:if test="${searchCondition == 'all' }">selected</c:if>>전체</option>
										<option value="writer" <c:if test="${searchCondition == 'writer' }">selected</c:if>>작성자</option>
										<option value="title" <c:if test="${searchCondition == 'title' }">selected</c:if>>제목</option>
										<option value="content" <c:if test="${searchCondition == 'content' }">selected</c:if>>내용</option>
									</select>
									<input type="text" name="searchKeyword" placeholder="검색어를 입력하세요" value="${searchKeyword }">
									<input type="submit" value="검색">
								</form>
							</td>
							<td>
							<button>글쓰기</button>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
<!-- 			<div class="noticeInsert"> -->
<!-- 				<a href="/notice/insert.do">글쓰기</a> -->
<!-- 			</div> -->
		</div>
	</main>
	<footer></footer>
</body>
</html>