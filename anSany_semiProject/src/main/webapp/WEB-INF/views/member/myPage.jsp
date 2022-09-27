<%@page import="kr.co.ansany.member.model.vo.MyPageOrderData"%>
<%@page import="kr.co.ansany.member.model.vo.MyQnAData"%>
<%@page import="kr.co.ansany.member.model.vo.MypageList"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<MyQnAData> mqd = (ArrayList<MyQnAData>) request.getAttribute("mqd");
ArrayList<MyPageOrderData> mpod = (ArrayList<MyPageOrderData>) request.getAttribute("mpod");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<!--css-->
<link rel="stylesheet" href="/css/myPage.css">
<!--fonts-->
<link rel="stylesheet" href="/css/Noto_Sans.css">
<!--jquery-->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<content>
	<div class="mypage-wrap">
		<div class="mypage-header">
			<h1>마이페이지</h1>

			<form id="frm">
				<input type="hidden" name="memberId" id="memberId"
					value="<%=m.getMemberId()%>">
			</form>
			<div class="span-wrap">

				<span class="welecome"><%=m.getMemberName()%>님 안녕하세요 :)</span> <a
					href="/logout.do" class="logoutLink" name="logout">로그아웃</a>
			</div>
			<ul class="header-box">
				<%
				if (m.getMemberLevel() == 1) {
				%>
				<a href="/membership.do"><li class="oneMemberLevel">회원등급:
						관리자</li></a>
				<%
				} else if (m.getMemberLevel() == 2) {
				%>
				<a href="/membership.do"><li class="oneMemberLevel">회원등급:
						VIP</li></a>
				<%
				} else {
				%>
				<a href="/membership.do"><li class="oneMemberLevel">회원등급:
						MEMBER</li></a>
				<%
				}
				%>
				<a href="/updateMemberInfoFrm.do"><li class="oneMemberInfo">회원정보수정</li></a>
				<a href="/cartView.do"><li class="oneMembercart">장바구니</li></a>
			</ul>
		</div>
		<div class="mypage-content">
			<div class="memberOrder_tbl">
				<h1>주문내역</h1>
				<table>
					<colgroup>
						<col style="width: 120px;">
						<col style="width: 160px;">
						<col>
						<col style="width: 160px;">
						<col style="width: 160px;">
					</colgroup>
					<tread>
					<tr>
						<th scope="col">주문일</th>
						<th scope="col">주문번호</th>
						<th scope="col">상품정보</th>
						<th scope="col">배송상태</th>
						<th scope="col">상품가격</th>
					</tr>
					</tread>
					<tbody>
						<%
						for (MyPageOrderData md : mpod) {
						%>
						<tr>
							<td scope="col"><%=md.getOrderDate()%></td>
							<td scope="col"><%=md.getOrderNo()%></td>
							<td scope="col" id="imgtd"><img
								src="/upload/prodImg/<%=md.getProductImg()%>"
								style="width: 100px; height: 100px;"> <span><%=md.getProductName()%></span></td>
							<%
							if (md.getStatus() == 1) {
							%>
							<td scope="col">결제완료</td>
							<%
							} else if (md.getStatus() == 2) {
							%>
							<td scope="col">제품준비중</td>
							<%
							} else if (md.getStatus() == 3) {
							%>
							<td scope="col">배송중</td>
							<%
							} else if (md.getStatus() == 4) {
							%>
							<td scope="col">배송완료</td>
							<%
							}
							%>
							<td scope="col" class="productPrice"><%=md.getProductPrice()%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
				<p>
					작성 가능한 구매후기가 있어요 구매후기를 작성하신 고객님께 <strong class="reserve">적립금</strong>
					을 지급해 드립니다
				</p>
			</div>
			<div class="myBoardView_tbl">
				<h1>1:1 문의내역</h1>
				<table>
					<colgroup>
						<col style="width: 120px;">
						<col>
						<col style="width: 160px;">
						<col style="width: 160px;">
						<col style="width: 100px;">
					</colgroup>
					<tread>
					<tr>
						<th scope="col">상담구분</th>
						<th scope="col">상담제목</th>
						<th scope="col">작성일</th>
						<th scope="col">답변유무</th>
						<th scope="col">삭제</th>
					</tr>
					</tread>
					<tbody>
						<%
						for (MyQnAData mq : mqd) {
						%>
						<tr>
							<%
							if (mq.getQnaCateNo() == 1) {
							%>
							<td>주문/결제</td>
							<%
							} else if (mq.getQnaCateNo() == 2) {
							%>
							<td>세금계산서</td>
							<%
							} else if (mq.getQnaCateNo() == 3) {
							%>
							<td>배송</td>
							<%
							} else if (mq.getQnaCateNo() == 4) {
							%>
							<td>취소/환불/AS</td>
							<%
							} else if (mq.getQnaCateNo() == 5) {
							%>
							<td>회원관련</td>
							<%
							} else if (mq.getQnaCateNo() == 6) {
							%>
							<td>기타문의</td>
							<%
							}
							%>
							<td><%=mq.getQnaTitle()%></td>
							<td><%=mq.getQnaDate()%></td>
							<%
							if (mq.getQnaStatus() == 0) {
							%>
							<td>답변대기중</td>
							<%
							} else if (mq.getQnaStatus() == 1) {
							%>
							<td>답변완료</td>
							<%
							}
							%>
							<%
							if (m != null && mq.getQnaWriter().equals(m.getMemberId())) {
							%>
							<td class="colDelete-btn">
								<button type="button"
									onclick="myPageQnADelete(<%=mq.getQnaNo()%>,'<%=m.getMemberId()%>');">삭제</button>
							</td>
							<%
							}
							%>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
				<!--table 끝-->
			</div>
		</div>
	</div>
	</content>
	<!--컨텐츠 끝-->
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	<script src="/js/myPage.js"></script>
	<script>
function addComma(value){
    value = value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    return value;
};
addComma($(".productPrice"));
</script>
</body>
</html>