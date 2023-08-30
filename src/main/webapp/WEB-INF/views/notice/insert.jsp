<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
<link rel="stylesheet" href="../resources/css/notice/insertCss.css">
</head>
<body>
	<div class="container">
		<jsp:include page="../include/header_mini.jsp"></jsp:include>
		<main>
			<form action="/notice/insert.do" method="post" enctype="multipart/form-data">
				<div class="noticeInfo_Field">
					<div class="noticeSubject">
						<input type="text" name="noticeSubject" id="noticeSubject" placeholder="제목">
					</div>
					<div class="noticeWriter">
						<input type="text" name="noticeWriter" id="noticeWriter" placeholder="작성자">
					</div>
					<div class="noticeContent">
						<textarea rows="4" cols="60"  name="noticeContent" id="noticeContent" placeholder="내용"></textarea>
					</div>
					<div class="uploadFile">
						<a href="../resources/nuploadFiles/${noticeOne.noticeFilename }" download>${noticeOne.noticeFilename }</a>
						<input type="file" name="uploadFile" id="uploadFile" placeholder="첨부파일">
					</div>
					<div class="noticeInsertBtn">
						<input type="submit" value="작성">
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