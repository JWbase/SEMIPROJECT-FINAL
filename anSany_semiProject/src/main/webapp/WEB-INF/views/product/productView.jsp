<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.ansany.product.model.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Product p = (Product)request.getAttribute("p");
    	int productCount = 0;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" /> 
<title>제품 상세 페이지</title>
<link rel="stylesheet" href="css/productView.css">
<link rel="stylesheet" href="css/Noto_Sans.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<!-- productView 시작 -->
	<div class="product-view-wrapper">
        <div class="product-view-img">
            <img src="/upload/prodImg/<%=p.getProductImg()%>">
        </div>
        <div class="product-view-content">
            <div class="product-view-info">
                <p class="product-message">NEW</p>
                <p class="product-name"><%=p.getProductName()%></p>
                <p class="product-info"><%=p.getProductInfo()%></p>
                <p class="product-comment">이 제품은 기획전을 통해 구매하시면 더 많은 혜택을 받으실 수 있습니다.</p>
                <div class="product-price-div">
                   	<p class="product-price"></p><p class="product-price-won">원</p>
                    <p class="product-delivery">무료배송</p>
                </div>
                <p class="membership-comment">회원별 할인 혜택<span class="icon-question">!</span></p>
                <ul class="membership-ul">
                    <li class="vip">
                        <span class="vip-mark"></span>
                        <div class="save-info">
                            <span class="percent">VIP 10%</span><br>
                            <span class="num-vip"></span>
                        </div>
                    </li>
                    <li class="membership">
                        <span class="membership-mark"></span>
                        <div class="save-info">
                            <span class="percent">MEMBERSHIP 5%</span><br>
                            <span class="num-membership"></span>
                        </div>
                    </li>
                </ul>
                <div class="product-select-box">
                    <p>제품선택</p>
                    <select name="select-btn" id="select-btn">
                        <option value="" disabled selected>제품을 선택하세요.</option>
                        <option value="" id="select-option">제품명 : <%=p.getProductName()%></option>
                    </select>
                    <div class="product-option-box">
                        <p>제품</p>
                        <span>제품명 : <%=p.getProductName()%></span>
                        <div class="count-box">
                            <button class="minus">-</button>
                            <input type="text" class="count" value="" readonly="readonly">
                            <button class="plus">+</button>
                            <p id="productPrice-won">원</p><span class="product-price-sum"></span>
                        </div>
                    </div>
                </div>
                <div class="product-result-price">
                    <p>총 상품금액 (총</p><p class="count"></p><p>개)</p>
                    <span>원</span><span class="product-price-sum"></span>
                </div>
                <div class="result-btn-box">
                    <ul>
                        <a href="#" class="heart-btn"><li></li></a>
                        <a class="cart-btn"><li></li></a>
                        <a href="#" class="gift-btn"><li></li></a>
                        <a class="buy-btn"><li>구매하기</li></a>
                    </ul>
                </div>
            </div>
        </div>
    </div>
	<!-- productView 끝 -->
	<script>
		<%-- 세자리 콤마 추가 정규 표현식 --%>
		 function addComma(value){
	   	 	value = value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	   	 	return value;
	    };
	    <%-- 세자리 콤마 제거 정규 표현식 --%>
	    function removeComma(value){
	        value = value.toString().replace(/[^\d]+/g, "");
	        return value; 
	    }

	    
	    $(".num-vip").append(addComma(<%=(int)(p.getProductPrice()*0.1)%>));
	    $(".num-membership").append(addComma(<%=(int)(p.getProductPrice()*0.05)%>));
	    $(".product-price").append(addComma(<%=p.getProductPrice()%>));
	    <%-- 제품 선택하면 감춰놨던 div 나오도록 하는 코드 --%>
	    $("#select-btn").on("change",function(){
	    	$(".product-option-box").css("display","inline-block");
	    	$(".product-result-price").css("display","inherit");
	    	$(".plus").click();
	    	
	    });
	    
	    <%-- 제품 상세페이지에서 제품 수량 조절 버튼(-,+) 동작 코드 --%>
	    // 수량 증가(+)버튼 클릭 시 1개 증가
        $(".plus").on("click",function(){
            let productCount = $(this).prev();
            <%-- 20개 이상 구매 시 차단(?) --%>
            if(productCount.val()>=20){
                alert("그만 사셈..");
            }else{
                let productPrice = $(".product-price");
                $(".count").val(Number(productCount.val())+1);
                $(".count").text(Number(productCount.val()));
                <%-- 계산을 위해 콤마 제거--%>
                removeComma($(".product-price-sum").text());
                <%-- 콤마 제거한 뒤 수량 곱하기 가격 실행 후 변수에 값 대입 --%>
                let productPriceSum = Number(removeComma($(".product-price").text()))*Number(productCount.val());
                console.log(productPriceSum);
                <%-- 가격 계산 후 다시 콤마 추가 후 값 추가 --%>
                addComma(productPriceSum);
                console.log(addComma(productPriceSum));
                $(".product-price-sum").text(addComma(productPriceSum));
            }
        });
	 	// 수량 증가(-)버튼 클릭 시 1개 감소. 1 밑으로는 안내려감
	    $(".minus").on("click",function(){
	        let productCount = $(this).next();
	        let productPrice = $(this).prev();
	        if(productCount.val()>1){
		        $(".count").val(Number(productCount.val())-1);
		        $(".count").text(Number(productCount.val()));
	        }
	        <%-- 계산을 위해 콤마 제거--%>
	        removeComma($(".product-price-sum").text());
	        <%-- 콤마 제거한 뒤 수량 곱하기 가격 실행 후 변수에 값 대입 --%>
	        let productPriceSum = Number(removeComma($(".product-price").text()))*Number(productCount.val());
	        console.log(productPriceSum);
	        <%-- 가격 계산 후 다시 콤마 추가 후 값 추가 --%>
	        addComma(productPriceSum);
	        console.log(addComma(productPriceSum));
	        $(".product-price-sum").text(addComma(productPriceSum));
	    });
	 	
	 	// 장바구니 누르면 정보 넘겨주기
	    $(".cart-btn").on("click", function() {
	        let productNo = <%=p.getProductNo()%>; //product_no역할
	        let productCount = Number($(".plus").prev().text()); //order_qty역할
	        //cart_no는 cart_sequence.nextval로 추가, member_id는 세션 값 불러와서 추가
	        $.ajax({
	            url : "/cartInsert.do",
	            type : "get",
	            data : {
	                productNo : productNo,
	                productCount : productCount
	            },
	            success : function(data) {
	            	if (data == 1) {
	                    alert("선택하신 상품을 장바구니에 담았습니다.");
	                } else {
	                    alert(data);
	                    window.location.href = '/loginFrm.do';
	                }
	            }
	        });
	    });
	 	
	 // 바로 구매하기 누르면 정보 넘겨주기 - 장바구니페이지 이동
	    $(".buy-btn").on("click", function() {
	        let productNo = <%=p.getProductNo()%>; //product_no역할
	        let productCount = Number($(".plus").prev().text()); //order_qty역할
	        //cart_no는 cart_sequence.nextval로 추가, member_id는 세션 값 불러와서 추가
	        $.ajax({
	            url : "/cartInsert.do",
	            type : "get",
	            data : {
	                productNo : productNo,
	                productCount : productCount
	            },
	            success : function(data) {
	                if (data == 1) {
	                    window.location.href = '/cartView.do';
	                } else {
	                    alert(data);
	                    window.location.href = '/loginFrm.do';
	                }
	            }
	        });
	    });
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>