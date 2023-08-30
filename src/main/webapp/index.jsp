<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다나온다 숍</title>
<link rel="stylesheet" href="../resources/css/mainPage/mainPageCss.css" />
</head>
<body>
	<div class="container">
		<jsp:include page="WEB-INF/views/include/header.jsp"></jsp:include>
		<div class="banner_box">
			<div class="banner_contents">
				<div class="banner">
					<div class="banner_information_box">
						<div class="banner_title">
							<a href="/notice/list.do?currentPage=1">공지사항</a>
						</div>
						<div class="banner_description">description</div>
					</div>
					<div class="image"></div>
				</div>
				<div class="bullet_list">
					<li></li>
					<li></li>
					<li></li>
				</div>
			</div>
		</div>

		<div class="main_contents_box">
			<div class="array">
				<div class="item">
					<a href="/products/productDetail.do">
						<div class="thumbnail">
							<img src="/resources/images/product/graphic_card_thumbnail.jpg" />
						</div>
						<div class="product_information">
							<div class="name">상품이름: 상품이름</div>
							<div class="description">상품설명: 상품설명</div>
							<div class="amount">상품가격: 100,000</div>
						</div>
					</a>
				</div>

				<div class="item">
					<a href="/products/productDetail.do">
						<div class="thumbnail">
							<img src="/resources/images/product/graphic_card_thumbnail.jpg" />
						</div>
						<div class="product_information">
							<div class="name">상품이름: 상품이름</div>
							<div class="description">상품설명: 상품설명</div>
							<div class="amount">상품가격: 100,000</div>
						</div>
					</a>
				</div>

				<div class="item">
					<a href="/products/productDetail.do">
						<div class="thumbnail">
							<img src="/resources/images/product/graphic_card_thumbnail.jpg" />
						</div>
						<div class="product_information">
							<div class="name">상품이름: 상품이름</div>
							<div class="description">상품설명: 상품설명</div>
							<div class="amount">상품가격: 100,000</div>
						</div>
					</a>
				</div>

				<div class="item">
					<a href="/products/productDetail.do">
						<div class="thumbnail">
							<img src="/resources/images/product/graphic_card_thumbnail.jpg" />
						</div>
						<div class="product_information">
							<div class="name">상품이름: 상품이름</div>
							<div class="description">상품설명: 상품설명</div>
							<div class="amount">상품가격: 100,000</div>
						</div>
					</a>
				</div>

				<div class="item">
					<a href="/products/productDetail.do">
						<div class="thumbnail">
							<img src="/resources/images/product/graphic_card_thumbnail.jpg" />
						</div>
						<div class="product_information">
							<div class="name">상품이름: 상품이름</div>
							<div class="description">상품설명: 상품설명</div>
							<div class="amount">상품가격: 100,000</div>
						</div>
					</a>
				</div>

				<div class="item">
					<a href="/products/productDetail.do">
						<div class="thumbnail">
							<img src="/resources/images/product/graphic_card_thumbnail.jpg" />
						</div>
						<div class="product_information">
							<div class="name">상품이름: 상품이름</div>
							<div class="description">상품설명: 상품설명</div>
							<div class="amount">상품가격: 100,000</div>
						</div>
					</a>
				</div>

				<div class="item">
					<a href="/products/productDetail.do">
						<div class="thumbnail">
							<img src="/resources/images/product/graphic_card_thumbnail.jpg" />
						</div>
						<div class="product_information">
							<div class="name">상품이름: 상품이름</div>
							<div class="description">상품설명: 상품설명</div>
							<div class="amount">상품가격: 100,000</div>
						</div>
					</a>
				</div>

				<div class="item">
					<a href="/products/productDetail.do">
						<div class="thumbnail">
							<img src="/resources/images/product/graphic_card_thumbnail.jpg" />
						</div>
						<div class="product_information">
							<div class="name">상품이름: 상품이름</div>
							<div class="description">상품설명: 상품설명</div>
							<div class="amount">상품가격: 100,000</div>
						</div>
					</a>
				</div>

				<div class="item">
					<a href="/products/productDetail.do">
						<div class="thumbnail">
							<img src="/resources/images/product/graphic_card_thumbnail.jpg" />
						</div>
						<div class="product_information">
							<div class="name">상품이름: 상품이름</div>
							<div class="description">상품설명: 상품설명</div>
							<div class="amount">상품가격: 100,000</div>
						</div>
					</a>
				</div>
				<div class="item">
					<a href="/products/productDetail.do">
						<div class="thumbnail">
							<img src="/resources/images/product/graphic_card_thumbnail.jpg" />
						</div>
						<div class="product_information">
							<div class="name">상품이름: 상품이름</div>
							<div class="description">상품설명: 상품설명</div>
							<div class="amount">상품가격: 100,000</div>
						</div>
					</a>
				</div>
			</div>
			<div class="fixed_bar"></div>
		</div>


		<main>
			<!-- 배너 -->
			<div></div>
			<!-- 메인 컨텐츠 -->
			<div>
				<!-- 최신 상품목록 -->
				<div>
					<div></div>
				</div>
				<!-- 사이드바 -->
				<div>
					<div></div>
				</div>
			</div>
		</main>

		<footer>
			<div></div>
		</footer>
	</div>
</body>
<script>
	const cardArray = [ {
		img : null,
		name : 'name',
		description : 'description',
		amount : 100000,
	}, {
		img : null,
		name : 'name',
		description : 'description',
		amount : 100000,
	}, {
		img : null,
		name : 'name',
		description : 'description',
		amount : 100000,
	}, {
		img : null,
		name : 'name',
		description : 'description',
		amount : 100000,
	}, {
		img : null,
		name : 'name',
		description : 'description',
		amount : 100000,
	}, {
		img : null,
		name : 'name',
		description : 'description',
		amount : 100000,
	}, ];
</script>
</html>