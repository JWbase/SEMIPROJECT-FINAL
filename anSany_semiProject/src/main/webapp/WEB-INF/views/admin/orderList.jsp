<%@page import="kr.co.ansany.order.model.vo.Order"%>
<%@page import="kr.co.ansany.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% ArrayList<Order> list = (ArrayList<Order>)request.getAttribute("list"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역확인</title>
   <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
   <link rel="stylesheet" href="/css/header.css">
   <link rel="stylesheet" href="/css/footer.css">
   <link rel="stylesheet" href="/css/admin1.css">
   <link rel="stylesheet" href="/css/bootstrap.css">
   <link rel="stylesheet" href="/css/Noto_Sans.css">
</head>
<style>
	.page-content{
		padding-top: 81px;
		background-color: #fff;
		height: 100%;
	}
	.admin-wrap>ul>a:last-child{
		border-bottom: 3px solid #F05454;
	  	font-weight: bold;
  		color: #F05454;
	}
</style>
<body style="background-color: #fff;">
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
	    <div class="admin-wrap">
	      <ul class="tabs">
	      	      	<a href="/adminPage.do"><li>전체회원 목록</li></a>
			        <a href="/searchMemberFrm.do"><li>회원 조회/수정</li></a>
			        <a href="/productInsertFrm.do"><li>상품등록</li></a>
			        <a href="/prodList.do?reqPage=1"><li>상품 목록/수정</li></a>
			        <a href="/orderList.do"><li>주문내역 확인</li></a>
	      </ul>
	      <div class="content-wrap">
	      	<div class="tabcontent">
	      		<div class="contentHead">
		          <h2>주문내역확인</h2>
		          <button class="btn btn-dark adminLogout">로그아웃</button>        	
        	</div>
	      		<table class="table">
	      			<tr>
	      				<th scope="col">선택</th>
	      				<th scope="col">주문번호</th>
	      				<th scope="col">회원아이디</th>
	      				<th scope="col">제품번호</th>
	      				<th scope="col">총금액</th>
	      				<th scope="col">주문자이름</th>
	      				<th scope="col">배송주소</th>
	      				<th scope="col">주문자번호</th>
	      				<th scope="col">주문날짜</th>
	      				<th scope="col">배송상태</th>
	      				<th scope="col">배송변경</th>
	      			</tr>
	      			<%for(Order o : list){ %>
	      			<tr>
	      				<td>
	      					<input type="checkbox" class= "chkBox"> 
	      				</td>
	      				<td><%=o.getOrderNo() %></td>
	      				<td><%=o.getMemberId() %></td>
	      				<td><%=o.getProductNo() %></td>
	      				<td><%=o.getTotalPrice() %></td>
	      				<td><%=o.getOrderName() %></td>
	      				<td><%=o.getOrderAddr() %></td>
	      				<td><%=o.getOrderPhone() %></td>
	      				<td><%=o.getOrderDate() %></td>
	      				<%if(o.getStatus()==1){ %>
	      				<td>
	      					<select class="btn btn-outline-dark">
	      						<option value="1" selected>결제완료</option>
	      						<option value="2">제품준비중</option>
	      						<option value="3">배송중</option>
	      						<option value="4">배송완료</option>
	      					</select>
	      				</td>
	      				<%} %>
	      				<%if(o.getStatus()==2){ %>
	      				<td>
	      					<select class="btn btn-outline-dark">
	      						<option value="1">결제완료</option>
	      						<option value="2" selected>제품준비중</option>
	      						<option value="3">배송중</option>
	      						<option value="4">배송완료</option>
	      					</select>
	      				</td>
	      				<%} %>
	      				<%if(o.getStatus()==3){ %>
	      				<td>
	      					<select class="btn btn-outline-dark">
	      						<option value="1">결제완료</option>
	      						<option value="2">제품준비중</option>
	      						<option value="3" selected>배송중</option>
	      						<option value="4">배송완료</option>
	      					</select>
	      				</td>
	      				<%} %>
	      				<%if(o.getStatus()==4){ %>
	      				<td>
	      					<select class="btn btn-outline-dark">
	      						<option value="1">결제완료</option>
	      						<option value="2">제품준비중</option>
	      						<option value="3">배송중</option>
	      						<option value="4" selected>배송완료</option>
	      					</select>
	      				</td>
	      				<%} %>
	      				<td>
	      					<button class="btn btn-outline-dark orderstatus">변경</button>
	      				</td>
	      			</tr>
	      			<%} %>
	      		</table>
	      		<button class="btn btn-outline-dark chkOrders" style="font-size: 20px;">선택 배송상태 변경</button>
	      	</div>
	      </div>
	     </div>
    </div>
	
	
        <script src="/js/admin1.js"></script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>