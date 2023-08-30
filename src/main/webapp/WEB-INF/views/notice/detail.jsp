<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 상세조회</title>
		<link rel="stylesheet" href="/resources/css/notice/detailCss.css" />
	</head>
	<body>
	<div class="container">
		<jsp:include page="../include/header_mini.jsp"></jsp:include>
	        <div class="notice_field">
	            <div class="notice_no">
		            <label>글번호 : </label>
					<span>${requestScope.notice.noticeNo }</span>
	            </div>
	            <div class="notice_date">
		            <label>작성일 : </label>
					<span>${requestScope.notice.nCreateDate }</span>
	            </div>
	            <div class="notice_writer">
		            <label>글쓴이 : </label>
					<span>${requestScope.notice.noticeWriter }</span>
	            </div>
	            <div class="notice_subject">
		            <label>제목 : </label>
					<span>${notice.noticeSubject }</span>
	            </div>
	            <div class="notice_content">
		            <label>내용</label>
					<p>${notice.noticeContent }</p>
	            </div>
	            <div class="notice_content">
		            <label>첨부파일 : </label>
					<a href="../resources/nuploadFiles/${notice.noticeFileRename }" download>${notice.noticeFilename }</a>
	            </div>
			</div>
			<div class="noticeBtn">
	            <button class="goToList" href="javascript:void(0)" onclick="goToList();">목록으로 이동</button>
	            <button class="modify" onclick="modifyCheck();">수정하기</button>
	            <button class="delete" href="javascript:void(0)" onclick="deleteCheck();">삭제하기</button>
	        </div>
		<script>
			const goToList = () => {
				const noticeNo = '${notice.noticeNo}';
				location.href = "/notice/list.do?currentPage=1";
			}
			
			function modifyCheck() {
				const noticeNo = "${notice.noticeNo }";
				location.href="/notice/modify.do?noticeNo="+noticeNo;
			}
			
			const deleteCheck = () => {
				const noticeNo = '${notice.noticeNo}';
				if(confirm("정말로 삭제하십니까?")) {
					location.href = "/notice/delete.do?noticeNo="+noticeNo;
				}
			}
 		</script>
	</body>
</html>