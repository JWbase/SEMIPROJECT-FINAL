<%@page import="kr.co.ansany.cart.model.vo.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Member member = (Member)request.getAttribute("m");
    ArrayList<Cart> list = (ArrayList<Cart>)request.getAttribute("orderList");
	int orderPrice = 0;
	int totalPrice = 0;
	int discountPrice = 0;
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AN SANY 주문결제</title>
<link rel="stylesheet" href="css/Noto_Sans.css">
<link rel="stylesheet" href="css/order.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="content">
        <div class="order-wrap">
            <div class="order-content">
                <div class="order-title"><h1>주문·결제</h1></div>
                <!-- 주문 단계 표시 -->
                <div class="order-step-wrap">
                    <div class="order-step">
                        <div class="order-step-circle complete-step"><span
                                class="material-symbols-outlined">local_mall</span></div>
                        <p>장바구니</p>
                    </div>
                    <div class="order-step-line active-step">
                    </div>
                    <div class="order-step">
                        <div class="order-step-circle active-step"><span
                                class="material-symbols-outlined">barcode_scanner</span></div>
                        <p>주문·결제</p>
                    </div>
                    <div class="order-step-line">
                    </div>
                    <div class="order-step">
                        <div class="order-step-circle"><span class="material-symbols-outlined">check_circle</span></div>
                        <p>주문 완료</p>
                    </div>
                </div>
                <!-- 구매할 제품 표시 -->
                <div class="cart-table">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">제품</th>
                                <th>가격</th>
                                <th>수량</th>
                                <th>합계</th>
                                <th><span>회원 금액</span></th>
                            </tr>
                        </thead>
                        <tbody>
	                        <%
				            for(int i=0; i<list.size(); i++) {
							%>
                            <tr>
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
                                    <input type="text" class="cart-count-value" name="cart-count" value="<%=list.get(i).getOrderQty() %>">
                                    <span>개</span>
                                </td>
                                <td class="cart-pricesum">
                                    <input class="cart-pricesum-value" name="cart-pricesum" value="<%=list.get(i).getProductPrice()*list.get(i).getOrderQty() %>" readonly>
                                    <span>원</span>
                                    <%orderPrice += list.get(i).getProductPrice()*list.get(i).getOrderQty(); %>
                                </td>
                                <td class="cart-totalPrice">
                                	<%if(m.getMemberLevel()==2 || m.getMemberLevel()==1) {%>
	                                    <input class="cart-totalprice-value" name="cart-totalprice" value="<%=list.get(i).getProductPrice()*list.get(i).getOrderQty()*0.9 %>" readonly>
	                                    <input name="discount-Price" value="<%=(list.get(i).getProductPrice()*list.get(i).getOrderQty())*0.1 %>" style="display:none;">
	                                    <%totalPrice += (list.get(i).getProductPrice()*list.get(i).getOrderQty())*0.9; %>
	                                    <%discountPrice += (list.get(i).getProductPrice()*list.get(i).getOrderQty())*0.1; %>
                                    <%}else if(m.getMemberLevel()==3){%>
	                                    <input class="cart-totalprice-value" name="cart-totalprice" value="<%=list.get(i).getProductPrice()*list.get(i).getOrderQty()*0.95 %>" readonly>
	                                    <input name="discount-price" value="<%=(list.get(i).getProductPrice()*list.get(i).getOrderQty())*0.05 %>" style="display:none;">
	                                	<%totalPrice += (list.get(i).getProductPrice()*list.get(i).getOrderQty())*0.95; %>
	                                	<%discountPrice += (list.get(i).getProductPrice()*list.get(i).getOrderQty())*0.05; %>
                                    <%} %>
                                    <span>원</span>
                                </td>
                            </tr>
                            <%
				            }
	                        %>
                        </tbody>
                    </table>
                </div>
                <!-- 주문결제창 -->
                <div class="order-table">
                    <!-- 주문정보 입력창 -->
                    <form action="/orderComplete.do" method="post">
						<%
						for(int i=0; i<list.size(); i++) {
						%>
						<input type="hidden" name="cart-no" value="<%=list.get(i).getCartNo() %>" class="cart-no">
						<input type="hidden" name="product-no" value="<%=list.get(i).getProductNo() %>">
                    	<%
                    	}
                    	%>
                    	<input type="hidden" name="total-price" value="<%=totalPrice%>">
                    	<input type="hidden" name="member-id" value="<%=member.getMemberId()%>">
                    <div class="order-left">
                        <div class="order-info">
                            <a class="order-toggle">주문자 정보
                                <span class="material-symbols-outlined">expand_less</span>
                            </a>
                            <div class="orderer">
                                <div>
                                    <label for="orderer-name">이름 <span class="require">*</span></label>
                                    <input type="text" name="orderer-name" class="require-val" id="orderer-name" value="<%=member.getMemberName() %>">
                                </div>
                                <div>
                                    <label for="orderer-email">이메일 <span class="require">*</span></label>
                                    <input type="text" name="orderer-email" class="require-val" id="orderer-email" value="<%=member.getMemberEmail() %>">
                                </div>
                                <div>
                                    <label for="orderer-phone">전화번호 <span class="require">*</span></label>
                                    <input type="text" name="orderer-phone" class="require-val" id="orderer-phone" value="<%=member.getMemberPhone() %>">
                                </div>
                            </div>
                        </div>
                        <div class="order-info">
                            <a class="order-toggle">배송지 정보
                                <span class="material-symbols-outlined">expand_less</span>
                            </a>
                            <div class="delivery">
                                <div>
                                    <input type="checkbox" id="get-orderer">
                                    <label for="get-orderer" id="get-orderer2"></label>
                                    <label for="get-orderer" id="get-orderer-info">주문자 정보와 동일</label>
                                </div>
                                <div>
                                    <label for="delivery-name">수령인 <span class="require">*</span></label>
                                    <input type="text" name="delivery-name" class="require-val" id="delivery-name" placeholder="이름을 입력하세요.">
                                </div>
                                <div>
                                    <label for="delivery-name">전화번호 <span class="require">*</span></label>
                                    <input type="text" name="delivery-phone" class="require-val" id="delivery-phone" placeholder="입력 예) 010-0000-0000">
                                </div>
                                <div>
                                    <label for="search-address">주소 <span class="require">*</span></label>
                                    <div class="address">
                                        <input type="text" onclick="search()" name="delivery-address" class="require-val" id="sample4_postcode" placeholder="우편번호" readonly>
                                        <input type="button" value="우편번호 검색" id="search-address"><br>
                                        <input type="text" onclick="search()" name="delivery-address" class="require-val" id="sample4_address" placeholder="주소" readonly>
                                        
                                        <span id="guide" style="color:#999;display:none"></span>
                                        <input type="text" name="delivery-address" class="require-val" id="sample4_detailAddress" placeholder="상세주소를 입력해주세요.">
                                    </div>
                                </div>
                                <div>
                                    <label for="delivery-memo">배송요청사항</label>
                                    <input type="text" name="delivery-memo" id="delivery-memo" placeholder="택배기사님께 요청하실 내용을 입력하세요.">
                                </div>
                            </div>
                        </div>
                        <div class="order-info">
                            <a class="order-toggle">할인 정보
                                <span class="material-symbols-outlined">expand_less</span>
                            </a>
                            <div class="discount">
                            <table>
                                <tr>
                                    <th colspan="2">회원 등급별 할인</th>
                                </tr>
                                <tr>
                                    <th>안사니 VIP회원</th>
                                    <td><i>10% 할인</i></td>
                                </tr>
                                <tr>
                                    <th>안사니 일반회원</th>
                                    <td><i>5% 할인</i></td>
                                </tr>
                            </table>
                            
                            </div>
                        </div>
                    </div>
                    </form>
                    <!-- 결제창 -->
                    <div class="order-right">
                        <div class="total-price">
                            <p>결제 예정 금액</p>
                            <p id="total-price">
                                <span id="total-price"><%=totalPrice%></span>
                                <span>원</span>
                            </p>
                        </div>
                        <div class="price-info">
                            <div>주문 금액</div>
                            <div>
                                <span id="order-price"><%=orderPrice%></span>
                                <span>원</span>
                            </div>
                            <div class="discount-price">할인 금액</div>
                            <div class="discount-price">
                                <span>- </span>
                                <span id="discount-price"><%=discountPrice%></span>
                                <span>원</span>
                            </div>
                        </div>
                        <div class="payment">
                            <div>
                                <input type="checkbox" name="payment-agree" id="payment-agree">
                                <label for="payment-agree" id="payment-agree2"></label>
                                <label for="payment-agree">
                                    <p>[필수] 주문할 제품의 거래조건을 확인하였으며, 구매에 동의하시겠습니까?<span>(전자상거래법 제8조 제2항)</span></p>
                                </label>
                            </div>
                            <button type="button" id="payment">결제</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
<script>
	//주소 입력창 클릭 시 우편번호검색 버튼 작동
	function search(){
		$("#search-address").click();
	}
	
	//주문자 정보와 동일 체크시 입력한 주문자 이름,전화번호&로그인한 회원의 주소 불러옴
	$("#get-orderer").on("change",function(){
		//입력란 선언
		const name = $("#delivery-name");
		const phone = $("#delivery-phone");
		const postcode = $("#sample4_postcode");
		const address = $("#sample4_address");
		const detailAddr = $("#sample4_detailAddress");
		//회원주소 불러오기, 구분자 선언
		const addr = "<%=member.getMemberAddr()%>";
        const splitWord = addr.split("*");
        //체크상태에 따라 입력값 달라짐
		if($(this).is(":checked")){
			name.val($("#orderer-name").val());
			phone.val($("#orderer-phone").val());
			postcode.val(splitWord[0]);
	        address.val(splitWord[1]);
	        detailAddr.val(splitWord[2]);
		}else{
			name.val("");
			phone.val("");
			postcode.val("");
	        address.val("");
	        detailAddr.val("");
		}
	});
	
	$("#payment").on("click", function() {
	//필수동의 체크해야 결제가능
		if ($("#payment-agree").is(":checked")) {
			let requireVal = $(".require-val");
			let check = 1;
			requireVal.each(function(index, item) {
				//input의 공백제거한 value값 검사
				if ($(item).val().trim() == '') {
					check = 0;
					console.log("옆 라벨"+$(item).siblings("label").text());
					console.log("부모 라벨"+$(item).parent().siblings("label").text());
				}else{
					console.log($(item).val());
				}
			});
			//필수정보 입력해야 결제가능
			if (check == 1) {
				//주문목록 가져오기
				let cartNo = $(".cart-no");
				//배열 만들어서 카트번호 넣기
				let sCartArray = new Array();
				cartNo.each(function(index, item) {
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
				$("form").submit();
			}else{
				alert("필수정보* 를 입력해 주세요.");
			}
		} else {
			alert("필수확인 항목을 확인해 주세요.");
		}
	});

	//숫자 세자리마다 콤마(,)찍는 함수
	function addComma(value) {
		value = value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		return value;
	}
	//가격단위 콤마 추가
	function calOrderPrice() {
		let cartPrice = $(".cart-price-value");
		let cartPricesum = $(".cart-pricesum-value");
		let cartTotalPrice = $(".cart-totalprice-value");
		let orderPrice = $("#order-price");
		let discountPrice = $("#discount-price");
		let totalOrderPrice = $("#total-price");
		//콤마 추가해서 리턴할 변수
		let commaCP = 0;
		let commaCPS = 0;
		let commaTCP = 0;
		let commaOP = 0;
		let commaDP = 0;
		let commaTOP = 0;
		//가격
		cartPrice.each(function(index, item) {
			commaCP = addComma($(item).val());
			$(item).val(commaCP);
		});
		//가격*수량 합계
		cartPricesum.each(function(index, item) {
			commaCPS = addComma($(item).val());
			$(item).val(commaCPS);
		});
		//합계*할인율 금액
		cartTotalPrice.each(function(index, item) {
			const ctp = Number($(item).val());
			commaTCP = addComma(ctp);
			$(item).val(commaTCP);
		});
		//주문금액
		commaOP = addComma(orderPrice.text());
		orderPrice.text(commaOP);
		//할인금액
		commaDP = addComma(discountPrice.text());
		discountPrice.text(commaDP);
		//결제예상금액
		commaTOP = addComma(totalOrderPrice.text());
		totalOrderPrice.text(commaTOP);
	}
	calOrderPrice();
</script>
<script src="js/header.js"></script>
<script src="js/order.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</html>