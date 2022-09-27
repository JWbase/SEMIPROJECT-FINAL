<%@page import="kr.co.ansany.cart.model.vo.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	ArrayList<Cart> list = (ArrayList<Cart>)request.getAttribute("list");
	int totalCount = 0;
	int totalPrice = 0;
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AN SANY 장바구니</title>
<link rel="stylesheet" href="css/Noto_Sans.css">
<link rel="stylesheet" href="css/cart.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="content">
		<div class="cart-wrap">
			<div class="cart-content">
				<div class="cart-title">
					<h1>장바구니</h1>
				</div>
				<!-- 주문 단계 표시 -->
				<div class="order-step-wrap">
					<div class="order-step">
						<div class="order-step-circle active-step">
							<span class="material-symbols-outlined">local_mall</span>
						</div>
						<p>장바구니</p>
					</div>
					<div class="order-step-line"></div>
					<div class="order-step">
						<div class="order-step-circle">
							<span class="material-symbols-outlined">barcode_scanner</span>
						</div>
						<p>주문·결제</p>
					</div>
					<div class="order-step-line"></div>
					<div class="order-step">
						<div class="order-step-circle">
							<span class="material-symbols-outlined">check_circle</span>
						</div>
						<p>주문 완료</p>
					</div>
				</div>
				<!-- 장바구니 목록 없는 경우 cart-empty표시-->
				<div class="cart-empty">
					<table>
						<tr>
							<td colspan="7">
								<div>
									<span>장바구니에 담긴 상품이 없습니다.</span>
								</div>
							</td>
						</tr>
					</table>
					<div class="btn-wrap empty">
						<button type="button" onclick="location.href='/'">쇼핑 계속
							하기</button>
					</div>
				</div>
				<!-- 장바구니 전체선택/선택삭제 버튼 -->
				<div class="cart-select">
					<div class="selectbox">
						<input type="checkbox" name="select-all" id="select-all">
						<label for="select-all" id="select-all2"></label> <label
							for="select-all">전체</label>
					</div>
					<div class="select-removebtn">
						<button type="button" id="select-removebtn">선택 삭제</button>
					</div>
				</div>
				<!-- 장바구니 목록 -->
				<div class="cart-table">
				<form action="/orderView.do" method="post">
					<table>
						<thead>
							<tr>
								<th colspan="3">제품</th>
								<th>가격</th>
								<th>수량</th>
								<th>합계</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<%
				            for(int i=0; i<list.size(); i++) {
							%>
							<tr>
								<td class="cart-checkbox">
									<input class="cart-no" name="cart-no" value="<%=list.get(i).getCartNo() %>">
									<input class="product-no" name="product-no" value="<%=list.get(i).getProductNo() %>">
									<input class="product-img" name="product-img" value="<%=list.get(i).getProductImg() %>">
									<input type="checkbox" name="select-one" id="cart-product<%=list.get(i)%>">
									<label for="cart-product<%=list.get(i)%>"></label>
								</td>
								<td class="cart-img">
									<img src="/upload/prodImg/<%=list.get(i).getProductImg() %>">
								</td>
								<td class="cart-name">
									<input type="text" class="cart-name-value" name="cart-name" value="<%=list.get(i).getProductName() %>" readonly>
								</td>
								<td class="cart-price">
									<input class="cart-price-value" name="cart-price" value="<%=list.get(i).getProductPrice() %>" readonly>
									<span>원</span>
								</td>
								<td class="cart-count">
									<div class="cart-count-wrap">
										<button type="button" class="cart-count-minus"><span class="material-symbols-outlined">remove</span></button>
										<input type="text" class="cart-count-value" name="cart-count" value="<%=list.get(i).getOrderQty() %>">
										<button type="button" class="cart-count-plus"><span class="material-symbols-outlined">add</span></button>
									</div>
								</td>
								<td class="cart-pricesum">
									<input class="cart-pricesum-value" name="cart-pricesum" value="<%=list.get(i).getProductPrice()*list.get(i).getOrderQty() %>" readonly>
									<span>원</span>
								</td>
								<td class="cart-remove">
									<button type="button" class="cart-removebtn">
										<span class="material-symbols-outlined">close</span>
									</button>
								</td>
							</tr>
							<%} %>
						</tbody>
						<!-- 결제예정금액 표시 -->
						<tfoot>
							<tr>
								<td colspan="7">
								<span class="tfoot-span1">결제 예정 금액</span>
								<span class="tfoot-span1">(총 </span>
								<input id="total-count" value="0" readonly>
								<span class="tfoot-span1">개)</span>
								<input id="total-price" value="0" readonly class="tfoot-span2">
								<span class="tfoot-span2">원</span></td>
							</tr>
							<tr>
								<td colspan="7"><span class="tfoot-span3">* 최종 결제금액은 회원등급별 할인율 적용에 따라 달라질 수 있습니다.</span></td>
							</tr>
						</tfoot>
					</table>
					<!-- 쇼핑 계속 / 구매 버튼 -->
					<div class="btn-wrap buy">
						<button type="button" onclick="location.href='#'">쇼핑 계속
							하기</button>
						<button type="button" id="orderDo">구매하기</button>
					</div>
					</form>
				</div>
				<!-- cart-table종료 -->
			</div>
			<!-- cart-content종료(width:1200px) -->
		</div>
		<!-- cart-wrap종료(width:100%) -->
	</div>
	<!-- content종료 -->
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
<script src="/js/cart.js"></script>
<script>
	//주문하기 버튼 누르면 submit실행
	$("#orderDo").on("click", function() {
		let selected = $(".cart-checkbox>input[type=checkbox]");
		let check = 0;
		selected.each(function(index,item){
			if($(item).prop("checked")){
				check = 1;
			}
		});
		//제품이 체크되어있지 않으면 submit안됨
		if(check == 1){
			$("form").submit();
		}else{
			alert("주문하실 제품을 선택해주세요.");
		}
	});

	//수량 변경 시 DB업데이트 함수 호출
	$(".cart-count-value").on("change", function() {
		countUpdate();
	});
	$(".cart-count-wrap>button").on("click", function() {
		countUpdate();
	});

	function countUpdate() {
		//모든목록, 카트번호, 수량 가져오기
		let selected = $(".cart-checkbox>input");
		let selectedNo = selected.siblings(".cart-no");
		let selectedCnt = selected.parent().siblings()
				.find(".cart-count-value");
		//배열 만들어서 카트번호 넣기
		let sCartNoArray = new Array();
		selectedNo.each(function(index, item) {
			sCartNoArray.push($(item).val());
		});
		let sCartCntArray = new Array();
		selectedCnt.each(function(index, item) {
			sCartCntArray.push($(item).val());
		});
		//전송하기위해 하나의 문자열로 처리
		sCartNo = sCartNoArray.join("/");
		sCartCnt = sCartCntArray.join("/");
		//문자열로 처리된 배열을 cartUpdate.do(service-dao)로 전달하여 수정
		$.ajax({
			url : "/cartUpdate.do",
			type : "get",
			data : {
				sCartNo : sCartNo,
				sCartCnt : sCartCnt
			},
			success : function(data) {
				if (data) {
					console.log("수정 완료");
				} else {
					console.log("수정 실패");
				}
			}
		});
	}

	//장바구니 선택삭제 버튼 누르면
	$("#select-removebtn").on("click", function() {
		//선택되어있는 제품들과 카트번호 가져오기
		let selected = $(".cart-checkbox>input:checked");
		let selectedNo = selected.siblings(".cart-no");
		//배열 만들어서 카트번호 넣기
		let sCartArray = new Array();
		selectedNo.each(function(index, item) {
			sCartArray.push($(item).val());
		});
		//전송하기위해 하나의 문자열로 처리
		sCart = sCartArray.join("/");
		//문자열로 처리된 배열을 cartDelete.do(service-dao)로 전달하여 Cart_TBL에서 삭제
		$.ajax({
			url : "/cartDeleteAll.do",
			type : "get",
			data : {
				sCart : sCart
			},
			success : function(data) {
				if (data) {
					console.log("삭제 성공");
				} else {
					console.log("삭제 실패");
				}
			}
		});
	});

	//목록별 삭제버튼 누르면 해당목록만 삭제
	$(".cart-removebtn").on("click", function() {
		let selectedNo = $(this).parent().siblings().find(".cart-no").val();
		console.log(selectedNo);
		$.ajax({
			url : "/cartDeleteOne.do",
			type : "get",
			data : {
				selectedNo : selectedNo
			},
			success : function(data) {
				if (data) {
					console.log("삭제 성공");
				} else {
					console.log("삭제 실패");
				}
			}
		});
	});
</script>
</html>