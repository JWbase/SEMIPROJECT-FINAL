<%@page import="kr.co.ansany.faqqna.model.vo.Faqqna"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<Faqqna> qnaList = (ArrayList<Faqqna>) request.getAttribute("qnaList");
String qnaPageNavi = (String) request.getAttribute("qnaPageNavi");
String type = (String) request.getAttribute("type");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 서비스</title>
<link rel="stylesheet" href="/css/faq.css">
<link rel="stylesheet" href="/css/qna.css">
<link rel="stylesheet" href="/css/Noto_Sans.css">
<!--  <link rel="stylesheet" href="/css/default.css"> -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link rel="stylesheet" href="/css/bootstrap.css" />
<link rel="stylesheet" href="css/Noto_Sans.css">
<style>
.header-logo>a>img {
	margin-bottom: 14.5px;
}
h1 {
	font-family: ns-bold;
}

.pageNavi {
	margin: 30px;
	color: black;
}

.pagination {
	justify-content: center;
	align-items: center;
}

.page-link {
	color: black;
}

.page-item.active .page-link {
	z-index: 1;
	color: #ccc;
	font-weight: bold;
	background-color: #333;
	border-color: #444;
}

.page-link:focus, .page-link:hover {
	color: #ccc;
	background-color: #222;
	border-color: #444;
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="faqqna-content">
		<div class="faqqna-wrap">
			<div class="qna-notice-head">
				<div class="faqqna-title">
					<h1>FAQ / Q&A</h1>
					<p>안사니스토어에 많이 물어보시는 질문과 새로운 소식을 만나보세요.</p>
				</div>
				<div class="faqqna-tab" value="<%=type%>">
					<ul>
						<li><a href="javascript:void(0)">FAQ</a></li>
						<li><a href="javascript:void(0)">Q&A</a></li>
					</ul>
				</div>
			</div>
			<div class="faq-content">
				<div class="faq-main">
					<div class="faq-top">
						<div class="faq-tab">
							<ul>
								<li><a href="javascript:void(0)">전체</a></li>
								<li><a href="javascript:void(0)">주문/결제</a></li>
								<li><a href="javascript:void(0)">세금계산서/영수증</a></li>
								<li><a href="javascript:void(0)">배송</a></li>
								<li><a href="javascript:void(0)">취소/환불/AS</a></li>
								<li><a href="javascript:void(0)">회원관련</a></li>
							</ul>
						</div>
					</div>
					<div class="faq-list">
						<div class="faq-mainlist">
							<div class="faq-questions">
								<div class="questions-div">

									<div class="faq-questions-head">
										<a href="javascript:void(0)"> <span class="faq-div">주문/결제</span>
											<span class="faq-div-title">Q. ESP상품의 결제 방법에는 무엇이 있나요?</span>
											<span class="material-icons">keyboard_arrow_down</span>
										</a>
									</div>
									<div class="faq-answer">
										<div class="faq-answerbox">
											<p>
												<span>ESP와 같은 무형 상품은 신용카드로 결제 가능하며, 가상계좌 결제는 사용하실 수
													없습니다.</span>
											</p>
										</div>
									</div>
								</div>

								<div class="questions-div">
									<div class="faq-questions-head">
										<a href="javascript:void(0)"> <span class="faq-div">주문/결제</span>
											<span class="faq-div-title">Q. ESP상품의 결제 방법에는 무엇이 있나요?</span>
											<span class="material-icons">keyboard_arrow_down</span>
										</a>
									</div>
									<div class="faq-answer">
										<div class="faq-answerbox">
											<p>
												<span>신용카드로 결제 가능하며, 가상계좌 결제는 사용하실 수 없습니다.</span>
											</p>
										</div>
									</div>
								</div>

								<div class="questions-div">
									<div class="faq-questions-head">
										<a href="javascript:void(0)"> <span class="faq-div">주문/결제</span>
											<span class="faq-div-title">Q. 가상계좌 이용 시 입금확인은 어떻게
												하나요?</span> <span class="material-icons">keyboard_arrow_down</span>
										</a>
									</div>
									<div class="faq-answer">
										<div class="faq-answerbox">
											<p>
												<span>주문 접수 시 주문 완료 메일과 SMS(주문자 핸드폰번호)를 통해 계좌번호를 보내
													드리오니</span>
											</p>
											<p>
												<span>해당 계좌로 입금해주시기 바랍니다.</span>
											</p>
											<p>
												<span>가상 계좌번호 입금 확인은 오전 및 오후 각각 2회씩 진행 되고 있습니다.</span>
											</p>
											<p>
												<span>입금 후 익일까지 확인이 되어 있지 않은 경우에는 소니스토어로 연락 주시기 바랍니다.</span>
											</p>
											<br>
											<p>
												<span>주문 후 3일 이내(영업일 기준)에 입금되지 않을 경우는 주문이 자동으로 취소됩니다.</span>
											</p>
											<p>
												<span>주문 취소 후 재 주문을 통해 가상계좌 번호를 재 발송 해 드리고 있습니다.</span>
											</p>
											<p>
												<span>주문 하실 때 입력하신 입금인명과 실제 입금하신 분의 이름이 똑같아야 입금확인이
													됩니다.</span>
											</p>
											<p>
												<span>만약 다를 경우 반드시 고객지원센터(1588-0000)나
													이메일(ansanystore@ansany.co.kr)로 연락 주시기 바랍니다.</span>
											</p>
										</div>
									</div>
								</div>

								<div class="questions-div">
									<div class="faq-questions-head">
										<a href="javascript:void(0)"> <span class="faq-div">주문/결제</span>
											<span class="faq-div-title">Q. 신용카드 무이자할부 혜택은 어디서
												확인하나요?</span> <span class="material-icons">keyboard_arrow_down</span>
										</a>
									</div>
									<div class="faq-answer">
										<div class="faq-answerbox">
											<p>
												<span>결제 페이지에서 확인하실 수 있습니다.</span>
											</p>
										</div>
									</div>
								</div>

								<div class="questions-div">
									<div class="faq-questions-head">
										<a href="javascript:void(0)"> <span class="faq-div">주문/결제</span>
											<span class="faq-div-title">Q. 대량 구매 문의는 어디로 해야 하나요?</span> <span
											class="material-icons">keyboard_arrow_down</span>
										</a>
									</div>
									<div class="faq-answer">
										<div class="faq-answerbox">
											<p>
												<span>B2B 기업체 특판 구매는</span><span
													style="color: rgb(100, 73, 173);">1)모델 2)수량 3)납기일
													4)납품처 5)제품 용도<span>의 정보가 필요합니다.</span>
												</span>
											</p>
											<p>
												<span>위의 정보를포함한 메일을 송부 부탁 드립니다.</span>
											</p>
										</div>
									</div>
								</div>

								<div class="questions-div">
									<div class="faq-questions-head">
										<a href="javascript:void(0)"> <span class="faq-div">세금계산서/영수증</span>
											<span class="faq-div-title">Q. 신용카드 영수증 출력은 어떻게 하나요?</span> <span
											class="material-icons">keyboard_arrow_down</span>
										</a>
									</div>
									<div class="faq-answer">
										<div class="faq-answerbox">
											<p>
												<span>신용카드 영수증은 고객님께서 입력해주신 e-mail로 보내 드리는 결제확인메일의 <영수증
														출력>버튼을 클릭하시면</span>
											</p>
											<p>
												<span>바로 출력 하실 수 있습니다.</span>
											</p>
											<p>
												<span>만약 e-mail을 지우셨을 경우 안사니사이트(www.ansany.com)의 사용내역
													및 청구내역 조회에서 발급 받으실 수 있습니다.</span>
											</p>
										</div>
									</div>
								</div>

								<div class="questions-div">
									<div class="faq-questions-head">
										<a href="javascript:void(0)"> <span class="faq-div">세금계산서/영수증</span>
											<span class="faq-div-title">Q. 현금영수증 및 세금계산서 발급은
												가능한가요?</span> <span class="material-icons">keyboard_arrow_down</span>
										</a>
									</div>
									<div class="faq-answer">
										<div class="faq-answerbox">
											<p>
												<span>가상 계좌 입금을 통한 결제일 경우, 현금 영수증 및 세금계산서가 발급 가능합니다.</span>
											</p>
											<p>
												<span>구매 결제창을 통해 현금 영수증 및 세금계산서 발급 신청을 할 수 있으나 누락 또는
													수정이 필요한 경우는</span>
											</p>
											<p>
												<span>고객지원센터1588-0000또는 안사니스토어(ansany@ansany.co.kr)로
													연락 주시기 바랍니다.</span>
											</p>
										</div>
									</div>
								</div>

								<div class="questions-div">
									<div class="faq-questions-head">
										<a href="javascript:void(0)"> <span class="faq-div">배송</span>
											<span class="faq-div-title">Q. 배송 일정 및 배송 현황 조회는 어디서
												하나요?</span> <span class="material-icons">keyboard_arrow_down</span>
										</a>
									</div>
									<div class="faq-answer">
										<div class="faq-answerbox">
											<p>
												<span>고객님께서 주문해주신 상품은 입금확인 후 발송 준비되며, 지역에 따라 3~7일 이내
													전국 어디든 배송 가능합니다.</span>
											</p>
											<p>
												<span>비회원의 예약판매 상품 등 일부 상품에 대해서는 상품 수급 사정에 의해 배송이 지연될
													수 있습니다.</span>
											</p>
											<p>
												<span>주문상품에 대한 상세한 확인 및 배송상황은 </span><span
													style="color: rgb(100, 73, 173); text-decoration: underline;">'마이
													페이지'</span><span>에서 모두 확인하실 수 있습니다.</span>
											</p>
										</div>
									</div>
								</div>

								<div class="questions-div">
									<div class="faq-questions-head">
										<a href="javascript:void(0)"> <span class="faq-div">배송</span>
											<span class="faq-div-title">Q. 배송료 부담은 누가하나요?</span> <span
											class="material-icons">keyboard_arrow_down</span>
										</a>
									</div>
									<div class="faq-answer">
										<div class="faq-answerbox">
											<p>
												<span>안사니스토어는 무료 배송을 원칙으로 하고 있습니다. 다만 산간 도서지방의 경우는 상품
													특성에 따라 부담하실 수도 있습니다.</span>
											</p>
										</div>
									</div>
								</div>

								<div class="questions-div">
									<div class="faq-questions-head">
										<a href="javascript:void(0)"> <span class="faq-div">취소/환불/AS</span>
											<span class="faq-div-title">Q. 주문취소 및 반품 신청은 어떻게 하나요?</span>
											<span class="material-icons">keyboard_arrow_down</span>
										</a>
									</div>
									<div class="faq-answer">
										<div class="faq-answerbox">
											<p>
												<span>주문취소 및 반품신청은 e-mail 및 고객지원센터로 요청하실 수 있습니다.</span>
											</p>
											<p>
												<span>(e-mail : ansany@ansony.co.kr / 전화 : 1588-0000)</span>
											</p>
											<br>
											<p>
												<span>e-mail을 통한 신청 시 운영시간 이후에는 익일 처리되므로 다소 지연될 수
													있습니다.</span>
											</p>
											<p>
												<span>구입하신 상품에 대해서는 제품을 받으신 날로부터</span><span
													style="color: rgb(100, 73, 173);">7일 이내에 교환 및 반품이 가능</span><span>합니다.</span>
											</p>
											<p>
												<span>단, 구입하신 상품의 내용이 표시, 광고 내용과 다르거나 계약 내용과 다르게 이행된
													경우에는</span>
											</p>
											<p>
												<span>해당상품을 공급 받은 날부터 3개월 이내, 그 사실을 안 날 또는 알 수 있었던
													날부터 30일 이내에 청약철회 가능합니다.</span>
											</p>
											<p>
												<span>제품하자가 아닌 변심으로 인한 반품 시에는 고객님께서 반품 비용을 부담하셔야 합니다.</span>
											</p>
										</div>
									</div>
								</div>

								<div class="questions-div">
									<div class="faq-questions-head">
										<a href="javascript:void(0)"> <span class="faq-div">취소/환불/AS</span>
											<span class="faq-div-title">Q. 가상 계좌 주문건의 경우,환불은 어떻게
												처리되나요?</span> <span class="material-icons">keyboard_arrow_down</span>
										</a>
									</div>
									<div class="faq-answer">
										<div class="faq-answerbox">
											<p>
												<span>가상 계좌 주문 취소 및 환불 요청은 “안사니 온라인 스토어 -> 마이페이지 ->
													주문/배송” 내역에서 취소신청이 가능합니다.</span>
											</p>
											<p>
												<span>고객지원 센터를 통해서 취소하시는 경우에는, 입금자 확인을 위해 고객센터 통화 후
													입금한 통장의 사본을 보내주셔야 합니다.</span>
											</p>
											<p>
												<span>환불 금액은 신청하신 날로부터 3영업일 이내에 완료됩니다.</span>
											</p>
											<p>
												<span>환불 관련 궁금하신 부분은 안사니 고객지원센터(1588-0000) 또는
													안사니스토어(ansany@ansany.co.kr)로 연락 바랍니다.</span>
											</p>
										</div>
									</div>
								</div>

								<div class="questions-div">
									<div class="faq-questions-head">
										<a href="javascript:void(0)"> <span class="faq-div">회원관련</span>
											<span class="faq-div-title">Q. 안사니스토어 회원 가입은 어떻게 해야
												하나요?</span> <span class="material-icons">keyboard_arrow_down</span>
										</a>
									</div>
									<div class="faq-answer">
										<div class="faq-answerbox">
											<p>
												<span>안사니스토어 온라인사이트에서 회원 가입을 하시면 누구나 안사니스토어 회원이 되실 수
													있습니다.</span>
											</p>
										</div>
									</div>
								</div>

								<div class="questions-div">
									<div class="faq-questions-head hidediv">
										<a href="javascript:void(0)"> <span class="faq-div">회원관련</span>
											<span class="faq-div-title">Q. 개명한 경우 이름을 어떻게 변경 하나요?</span>
											<span class="material-icons">keyboard_arrow_down</span>
										</a>
									</div>
									<div class="faq-answer">
										<div class="faq-answerbox">
											<p>
												<span>개명하신 경우 기존 아이디로 로그인 하신 후, 회원정보를 수정하실 수 있습니다.</span>
											</p>
											<p>
												<span>다만,개명한 이름으로 실명인증이 가능해야 합니다.</span>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="addfaq-Btn">
						<button>더보기 +</button>
					</div>
				</div>
			</div>
			<div class="qna-wrap">
				<div class="qna-content">
					<div class="qna-top-wrap">
						<%
						if (m != null) {
						%>
						<div>
							<a href="/faqqnaWriteFrm.do">문의하기</a>
						</div>
						<%
						}
						%>
					</div>
					<table class="qna-table">
						<tr class="qna-title">
							<th style="width: 7%;">번호</th>
							<th style="width: 15%;">문의유형</th>
							<th style="width: 32%;">제목</th>
							<th style="width: 9%;">작성자</th>
							<th style="width: 15%;">처리상태</th>
							<th style="width: 15%;">문의날짜</th>
							<th style="width: 7%;">조회수</th>
						</tr>
						<%
						for (Faqqna qna : qnaList) {
						%>
						<tr class="qna-answer">
							<td><%=qna.getQnaNo()%></td>
							<%
							if (qna.getQnaCateNo() == 1) {
							%>
							<td>주문/결제</td>
							<%
							} else if (qna.getQnaCateNo() == 2) {
							%>
							<td>세금계산서/영수증</td>
							<%
							} else if (qna.getQnaCateNo() == 3) {
							%>
							<td>배송</td>
							<%
							} else if (qna.getQnaCateNo() == 4) {
							%>
							<td>취소/환불/AS</td>
							<%
							} else if (qna.getQnaCateNo() == 5) {
							%>
							<td>회원관련</td>
							<%
							} else if (qna.getQnaCateNo() == 6) {
							%>
							<td>기타문의</td>
							<%
							}
							%>
							<%
							if (m != null) {
							%>
							<%
							if (m.getMemberId().equals(qna.getQnaWriter()) || m.getMemberLevel() == 1) {
							%>
							<td><a href="/faqqnaView.do?qnaNo=<%=qna.getQnaNo()%>"><%=qna.getQnaTitle()%></a></td>
							<%
							} else {
							%>
							<td><a href="javascript:void(0);"
								onclick="alert('작성자만 확인할 수 있습니다.');"><%=qna.getQnaTitle()%></a></td>
							<%
							}
							%>
							<%
							} else {
							%>
							<td><a href="javascript:void(0);"
								onclick="alert('작성자만 확인할 수 있습니다.');"><%=qna.getQnaTitle()%></a></td>
							<%
							}
							%>

							<td><%=qna.getQnaWriter()%></td>
							<%
							if (qna.getQnaStatus() == 0) {
							%>
							<td>답변대기중</td>
							<%
							} else if (qna.getQnaStatus() == 1) {
							%>
							<td>답변완료</td>
							<%
							}
							%>
							<td><%=qna.getQnaDate()%></td>
							<td><%=qna.getQnaReadCount()%></td>
						</tr>
						<%
						}
						%>
					</table>
					<div class="pageNavi"><%=qnaPageNavi%></div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	<script src="/js/faq.js"></script>
	<script>
		console.log($(".faqqna-tab").attr("value"));
		if ($(".faqqna-tab").attr("value") == "qna") {
			$(".faqqna-tab>ul").children().eq(1).click();
		}
	</script>
</body>
</html>