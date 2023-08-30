<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
<link rel="stylesheet" href="../resources/css/notice/modifyCss.css">
</head>
<body>
	<div class="container">
		<jsp:include page="../include/header_mini.jsp"></jsp:include>
		<main>
			<form action="/notice/modify.do" method="post" enctype="multipart/form-data">
				<input type="hidden" name="noticeNo" value="${noticeOne.noticeNo }">
				<input type="hidden" name="noticeFilename" value="${noticeOne.noticeFilename }">
				<input type="hidden" name="noticeFileRename" value="${noticeOne.noticeFileRename }">
				<input type="hidden" name="noticeFilepath" value="${noticeOne.noticeFilepath }">
				<input type="hidden" name="noticeFilelength" value="${noticeOne.noticeFilelength }">
					<div class="noticeInfo_Field">
						<div class="noticeSubject">
							<input type="text" name="noticeSubject" id="noticeSubject" value="${noticeOne.noticeSubject }" placeholder="제목">
						</div>
						<div class="noticeWriter">
							<input type="text" name="noticeWriter" id="noticeWriter" value="${noticeOne.noticeWriter }" placeholder="작성자">
						</div>
						<div class="noticeContent">
							<textarea rows="4" cols="60"  name="noticeContent" id="noticeContent" placeholder="내용">${noticeOne.noticeContent }</textarea>
						</div>
						<div class="uploadFile">
							<input type="file" name="uploadFile" id="uploadFile" placeholder="첨부파일">
							<a href="../resources/nuploadFiles/${noticeOne.noticeFilename }" download>${noticeOne.noticeFilename }</a>
						</div>
						<div class="noticeModifyBtn">
							<input type="submit" value="수정하기">
						</div>
					</div>
			</form>
		</main>
		<footer>
			<div class="footer"></div>
		</footer>
	</div>
</body>
</html>