<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
<link rel="stylesheet"
	href="/resources/css/products/productDetailPageCss.css" />
</head>
<body>
	<div class="container">
		<jsp:include page="../include/header.jsp"></jsp:include>
		<main>
			<div class="mainDiv">
				<div class="productDetailDiv">
					<div class="productImg">
						<img src="/resources/images/product/graphic_card.jpg" alt="상품 이미지" />
					</div>
					<div class="productExplain">
						<img src="/resources/images/product_explain/product_explain.png"
							alt="상품 설명" />
					</div>
				</div>
				<div class="buyDivWrapper">
					<div class="buyDiv">
						<div class="buyLayout">
							<div class="productName">
								<b>Geforce RTX 3070</b>
							</div>
							<hr />
							<div class="priceDiv">
								<div class="priceText">상품 가격</div>
								<div class="price">100,000원</div>
							</div>
							<div class="countDiv">
								<div class="countText">주문 수량</div>
								<div class="count">
									<input type="number" name="" id="productCount" placeholder="1" />
								</div>
							</div>
							<div class="deliWayDiv">
								<div class="deliWayText">배송 방법</div>
								<div class="deliWay">
									<select value="productDeli">
										<option value="parcel">택배</option>
										<option value="quick ">퀵 서비스</option>
										<option value="pickUp">직접수령</option>
									</select>
								</div>
							</div>
							<hr />
							<div class="totalPriceDiv">
								<div class="totalPriceText">총 합계금액 :</div>
								<div class="totalPrice">100,000원</div>
							</div>
							<div class="btnDiv">
								<div class="saveBtnDiv">
									<button class="saveBtn">장바구니</button>
								</div>
								<div class="buyBtnDiv">
									<button class="buyBtn">구매하기</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
		<footer></footer>
	</div>
</body>
</html>