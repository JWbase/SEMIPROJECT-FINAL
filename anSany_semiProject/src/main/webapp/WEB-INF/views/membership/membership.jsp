<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버십</title>
<link rel="stylesheet" href="css/membership.css">
<link rel="stylesheet" href="css/Noto_Sans.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="membership-container">
		<div class="membership-con">
			<div class="membership-banner">
				<div class="membership-bannerImg">
					<div class="membership-bannerText">
						<p>등급 & 혜택 안내</p>
						<h1>안사니스토어 멤버십</h1>
						<span>안사니스토어 회원이 되시면 다양한 멤버십 혜택을 누리실 수 있습니다!</span>
					</div>
					<div class="membership-SubContainer">
						<div class="membership-bannerSubText">
							<span>안사니스토어 온라인 구매 시 금액대 관계 없이 모두 </span><span
								style="color: #5865f5; text-decoration: underline; text-underline-position: under;"><b>무료
									배송!</b></span>
						</div>
					</div>
				</div>
				<div class="membership-mainContainer">
					<div class="membership-content">
						<ul class="membership-tabs">
							<li><a href="javascript:void(0)">멤버십</a></li>
							<li><a href="javascript:void(0)">프리미엄 서비스</a></li>
						</ul>
					</div>
					<div>
						<div style="margin-top: 80px;">
							<div class="membership-contentArea">
								<div class="membership-contentText">
									<h2>멤버십 안내</h2>
									<span>안사니스토어에서 제품 구매시 멤버십 등급에 따라 <span class="saleText">(5
											~ 10%)할인</span>이 적용 됩니다.
									</span>
									<div>
										<p>*단, 일부 상품은 할인이 적용되지 않습니다. 상품을 구매하실 때 꼭 확인하시기 바랍니다.</p>
										<p style="font-size: 20px;">
											<b>- 안사니 스토어 -</b>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div>
						<div>
							<div class="membership-TableHead">
								<div class="membership-Thead">
									<div class="Thead-tabTitle" style="width: 240px;">구분</div>
									<div class="Thead-tabTitle">VIP 회원</div>
									<div class="Thead-tabTitle">MEMBERSHIP 회원</div>
								</div>
								<div class="membership-Thead">
									<div class="Tbody-subTitle" style="width: 240px;">회원등급</div>
									<div class="membership-vipImg">
										<img src="img/membership_vipmin.svg"
											style="padding-top: 20px;">
									</div>
									<div class="membership-vipImg">
										<img src="img/membership_family2.svg"
											style="padding-top: 20px;">
									</div>
								</div>
								<div class="membership-Thead">
									<div class="Tbody-subTitle" style="width: 240px;">등급기준</div>
									<div class="">
										<div class="membership-Tcontent">
											<p>
												구매금액(누적)이 <b>200만원 이상</b>이 되는
											</p>
											<p>시점 익일부터 VIP 혜택 2년 간 적용</p>
										</div>
									</div>
									<div class="">
										<div class="membership-Tcontent">
											<p>
												구매금액(누적)이 <b>200만원 미만</b>시 익일부터
											</p>
											<p>MEMBERSHIP 혜택 2년 간 적용</p>
										</div>
									</div>
								</div>
								<div class="membership-Thead">
									<div class="Tbody-subTitle" style="width: 240px;">할인혜택</div>
									<div class="">
										<div style="line-height: 80px; font-family: ns-m;">
											<p>
												제품 구매 시 결제 금액의 <b>10%</b> 할인
											</p>
										</div>
									</div>
									<div class="">
										<div style="line-height: 80px; font-family: ns-m;">
											<p>
												제품 구매 시 결제 금액의 <b>5%</b> 할인
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="prem-contentwrap">
				<div class="prem-topcontent">
					<div class="prem-topcontent-text">
						<h2>프리미엄 서비스란?</h2>
						<p>
							고객님께서 안사니제품을 구입하거나 사용 시에 보다 편리하게 사용하실 <br> 수 있도록 제공해 드리는 <b
								style="color: #5865f5;">안사니스토어만의 특별한 서비스</b>입니다.
						</p>
						<ul class="prem-serviceicon">
							<li class="prem-serviceicons">기프트
								<h3>선물하기 서비스</h3>
							</li>
							<li class="prem-serviceicons">운송
								<h3>퀵/친환경</h3>
								<h3 style="margin: 0;">패키지 서비스</h3>
							</li>
							<li class="prem-serviceicons">비디오
								<h3>영상 변환 서비스</h3>
							</li>
							<li class="prem-serviceicons">수리
								<h3>연장 서비스 플랜</h3>
							</li>
						</ul>
					</div>
				</div>
				<div class="prem-main-content">
					<div class="prem-main-contentwrap">
						<ul class="prem-main-one">
							<li class="prem-main-lione">
								<div class="prem-main-oneImg">
									<img src="img/premiumservice1.jpg" alt="">
								</div>
								<h3>선물하기 서비스</h3>
								<ul>
									<li>선물하기 서비스는 <b style="color: #5865f5;">안사니스토어 회원만</b>
										온라인 또는 앱에서 이용가능한 서비스입니다.
									</li>
									<li>선물하기 서비스는 <b style="color: #5865f5;">제품 1건의 구매</b>(결제건)에
										한해 이용이 가능합니다.
									</li>
								</ul>
								<p style="color: #666; font-size: 0.875em;">* 제품 1건 결제(구매
									수량은 여러개 가능), 복수 배송지 불가</p>
							</li>
							<li class="prem-main-litwo">
								<div class="prem-main-oneImg">
									<img src="img/premiumservice2.jpg" alt="">
								</div>
								<h3>퀵/친환경 패키지 서비스</h3>
								<ul>
									<li>안사니스토어에서는 온라인 주문 한정으로 친환경 패키징을 제공합니다.</li>
									<li>박스/완충 포장재/테이프 모두 종이를 사용하여 환경 보호에 기여합니다.</li>
									<li>또한 안전한 배송을 위해 300만원 이상의 제품은 화물배송으로 발송됩니다.</li>
									<li>퀵서비스는 구매 금액이 <b style="color: #5865f5;">5만원 이상</b>일 경우
										고객 요청에 따라 서울/경기 지역의 퀵서비스 지원이 가능하며,
									</li>
									<li>제품 구매 금액에 따라 배송 비용이 할증될 수 있습니다.<b
										style="color: #5865f5;">퀵서비스 비용은 고객 부담</b>입니다.
									</li>
									<li><br></li>
									<li><b style="color: #5865f5;">#안사니스토어 온라인</b></li>
									<li>* 일반배송 : CJ대한통운 택배배송</li>
									<li>* 화물배송 : 300만원이상</li>
									<li>* 퀵서비스 : 구매 금액이 5만원 이상의 경우 고객 요청에 따라 서울/경기 지역의 퀵서비스
										지원이 가능(비용 고객 부담)</li>
								</ul>
							</li>
							<li class="prem-main-lithree">
								<div class="prem-main-oneImg">
									<img src="img/premiumservice3.jpg" alt="">
								</div>
								<h3>영상변환 서비스</h3>
								<ul>
									<li>영상변환 서비스는 고객님께서 소장하고 계시는 비디오 테이프를 <b
										style="color: #5865f5;">USB 메모리 또는 DVD 디스크</b>로 변환하여 드리는
										서비스입니다.
									</li>
									<li>변환 가능한 테이프는 <b style="color: #5865f5;">6mm, 8mm 또는
											VHS 테이프</b>이며, 가까운 서비스 센터로 비디오 테이프를 가지고 방문하시면 변환 서비스를 받으실 수 있습니다.
									</li>
								</ul>
							</li>
							<li class="prem-main-litwo">
								<div class="prem-main-oneImg">
									<img src="img/premiumservice4.jpg" alt="">
								</div>
								<h3>연장 서비스 플랜</h3>
								<ul style="padding-bottom: 100px;">
									<li style="letter-spacing: -.105em;">연장 서비스 플랜은 소정의 비용으로
										제품 구입일로부터 2년 또는 3년 동안 횟수와 금액 상관 없이 안심하고 무상 수리를 받을 수 있는 프리미엄
										서비스입니다.</li>
									<li>안사니스토어 온라인 및 전화주문을 통해서 구매 가능합니다.</li>
									<li>연장 서비스 플랜 적용은<b style="color: #5865f5;">상품 구매일로부터
											7일</b> 이후 자동 적용됩니다.
									</li>
									<li>연장 서비스 플랜 상품은 <b style="color: #5865f5;">무형 상품</b>으로
										별도 배송되지 않습니다.
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script src="/js/membership.js"></script>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>