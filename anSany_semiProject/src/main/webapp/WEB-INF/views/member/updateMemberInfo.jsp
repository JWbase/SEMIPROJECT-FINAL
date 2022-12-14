<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<!--css-->
<link rel="stylesheet" href="css/updateMemberInfo.css">
<!--fonts-->
<link rel="stylesheet" href="css/Noto_Sans.css">
<!-- 구글 아이콘 -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<!--jquery -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<content>
	<div class="memberInfo-wrap">
		<div class="memberInfo-header">
			<h1>회원정보 수정</h1>
			<div class="span-wrap">
				<div class="span-box-left">
					<span class="material-symbols-outlined">chevron_left</span> <a
						href="/myPageFrm.do?memberId=<%=m.getMemberId() %>" class="myPageLink">마이페이지</a>
				</div>
				<div class="span-box-right">
					<a href="javasript:void(0);" class="withdrawalLink" name="withdrawal">회원탈퇴</a>
					<span class="material-symbols-outlined">chevron_right</span>
				</div>
			</div>
		</div>
	</div>
	<div class="memberInfo-content">
		<div class="updateMemberInfo">
			<form action="/updateMemberInfo.do" method="post" name="updateMemberFrm" autocomplete="off">
				<div class="update-box">
					<label for="memberId">아이디</label> <input type="text"
						name="memberId" id="memberId" class="update-input-form"
						value="<%=m.getMemberId() %>" disabled>
				</div>
				<div class="update-box">
					<label for="memberPw">비밀번호</label> <input type="password"
						name="memberPw" id="memberPw" class="update-input-form"
						value="<%=m.getMemberPw() %>"> <span class="comment"></span>
				</div>
				<div class="update-box">
					<label for="memberPwRe">비밀번호 확인</label> <input type="password"
						name="memberPwRe" id="memberPwRe" class="short-input-form"
						placeholder="비밀번호" required> <span class="comment"></span>
					<button type="submit" class="updateOne-btn" action="/changeMemberPw.do">비밀번호 변경</button>
				</div>
				<div class="update-box">
					<label for="memberEmail">이메일</label> <input type="text"
						name="memberEmail" id="memberEmail" class="short-input-form"
						placeholder="이메일 (ex : ansany@gmail.com)"
						value="<%=m.getMemberEmail()%>"> <span class="comment"></span>
					<button type="button" id="sendEmailBtn" class="sendEmailBtn">인증메일전송</button>
					<!--display: none-->
					<div id="auth">
						<input type="text" id="authCode" placeholder="인증코드입력">
						<button class="inputCode" id="authBtn">인증하기</button>
						<!--시간제한용-->
						<div class="timeBox">
							<span id="timeZone"></span> <span id="authMsg"></span>
						</div>
					</div>
					<span class="comment"></span>
				</div>
				<div class="update-box">
					<label for="memberName">이름</label> <input type="text"
						name="memberName" id="memberName" class="update-input-form" value="<%=m.getMemberName()%>"
						disabled>
				</div>
				<div class="update-box">
					<label for="memberBirth">생년월일</label> <input type="text"
						name="memberBirth" id="memberBirth" class="update-input-form" value="<%=m.getMemberBirth()%>"
						disabled>
				</div>
				<div class="update-box">
					<label for="memberPhone">휴대폰번호</label> <input type="text"
						name="memberPhone" id="memberPhone" class="short-input-form"
						value="<%=m.getMemberPhone()%>"> <span class="comment"></span>
					<button type="submit" class="updateOne-btn" action="/changeMemberPhone.do">번호 변경</button>
				</div>
				<div class="update-box">
					<label for="memberAddr">주소</label> 
					<input type="text" name="memberAddr1" id="memberAddr" class="short-input-form" value="<%=m.getMemberAddr()%>" readonly>
					<button class="searchAddr" name="searchAddr" id="searchAddr" type="button"
						onclick="searchPost();">주소변경</button>
					<input type="text" name="memberAddr2" id="memberAddr2" class="update-input-form" readonly> 
					<input type="text" name="memberAddr3" id="detailAddress" class="update-input-form">
				</div>
				<div class="update-box">
					<label for="memberLevel">회원등급</label>
					<%if(m.getMemberLevel()==1) {%>
					<input type="text" name="memberLevel" id="memberLevel"
						class="update-input-form" value="관리자" disabled>
					<%}else if(m.getMemberLevel()==2){%>
					<input type="text" name="memberLevel" id="memberLevel"
						class="update-input-form" value="VIP" disabled>
					<%}else if(m.getMemberLevel()==3) {%>
					<input type="text" name="memberLevel" id="memberLevel"
						class="update-input-form" value="member" disabled>
					<%} %>
				</div>
				<div class="update-box">
					<label for="enrollDate">가입일</label> <input type="text"
						name="enrollDate" id="enrollDate" class="update-input-form"
						value="<%=m.getEnrollDate() %>" disabled>
				</div>
				<div class="memberInfo-footer">
					<div class="updateBtn-box">
						<button type="button" class="cansleInfo-btn">취소</button>
						<button type="submit" class="updateInfo-btn">저장</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	</content>
	<!-- content 끝-->
	    <div class="modal-wrap">
        <div class="modal">
            <div class="delete-box">
                    <div class="deleteTitle">
                        <h1>안사니 탈퇴전 확인하세요</h1>
                        <div class="delete-header">
                            <span>탈퇴하시면 이용중인 안사니 멤버십 혜택은 모두 사라지며</span>
                            <span>관련 데이터 일부는 복구가 불가능합니다</span>
                        </div>
                        <div class="delete-content">
                            <ul class="contentBox">
                                <li>작성하신 글,사진과 주문내역 모든 정보가 삭제됩니다</li>
                                <li>타인 글의 작성된 댓글은 삭제되지 않으니 미리 확인하세요</li>
                            </ul>
                            <div class="delete-box">
                                <input type="checkbox" class="delete_check" id="deleteChk" name="deleteChk">
                                <label for="deleteChk">안내사항을 모두 확인하였으며 이에 동의합니다</label>
                            </div>
                        </div>
                        <div class="deleteBtnBox">
                            <button type="button" class="backBtn" id="backBtn">취소</button>
                            <button type="submmit" class="deleteBtn" id="deleteBtn">탈퇴</button>
                        </div>
                    </div>
            	</div>
        </div>
    </div><!--modal 끝-->
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	<!-- script 끝 -->
	<script src="/js/updateMemberInfo.js"></script>
	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script>
			function addrSlice() {
				const addr = $("#memberAddr").val();
				const splitWord = addr.split("*");
				for(let i=0; i<splitWord.length; i++){
				}
				$("#memberAddr").val(splitWord[0]);
				$("#memberAddr2").val(splitWord[1]);
				$("#detailAddress").val(splitWord[2]);
			}
			addrSlice();
		</script>
</body>
</html>