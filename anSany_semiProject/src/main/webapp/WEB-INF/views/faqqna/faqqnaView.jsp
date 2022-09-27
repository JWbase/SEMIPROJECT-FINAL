<%@page import="kr.co.ansany.faqqna.model.vo.FaqqnaComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.ansany.faqqna.model.vo.Faqqna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Faqqna faq = (Faqqna) request.getAttribute("faq");
FaqqnaComment fc = (FaqqnaComment) request.getAttribute("commentList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 서비스</title>
<link rel="stylesheet" href="/css/qnaView.css">
<link rel="stylesheet" href="css/Noto_Sans.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="qna-content-wrap">
		<div class="qna-views-content">
			<table class="qna-views-table">
				<tr class="qna-views-top">
					<th style="width: 15%;">분류</th>
					<th style="width: 45%;">제목</th>
					<th style="width: 15%;">작성자</th>
					<th style="width: 15%;">작성일</th>
					<th style="width: 10%;">조회수</th>
				</tr>
				<tr>
					<%
					if (faq.getQnaCateNo() == 1) {
					%>
					<td>주문/결제</td>
					<%
					} else if (faq.getQnaCateNo() == 2) {
					%>
					<td>세금계산서/영수증</td>
					<%
					} else if (faq.getQnaCateNo() == 3) {
					%>
					<td>배송</td>
					<%
					} else if (faq.getQnaCateNo() == 4) {
					%>
					<td>취소/환불/AS</td>
					<%
					} else if (faq.getQnaCateNo() == 5) {
					%>
					<td>회원관련</td>
					<%
					} else if (faq.getQnaCateNo() == 6) {
					%>
					<td>기타문의</td>
					<%
					}
					%>
					<td><%=faq.getQnaTitle()%></td>
					<td><%=faq.getQnaWriter()%></td>
					<td><%=faq.getQnaDate()%></td>
					<td><%=faq.getQnaReadCount()%></td>
				</tr>
				<tr>
					<th class="qna-views-top">첨부파일</th>
					<td colspan="4">
						<%
						if (faq.getQnaFileName() != null) {
						%> <img src="/img/file.png" width="16px"> <a
						href="/faqqnaFileDown.do?qnaNo=<%=faq.getQnaNo()%>"><%=faq.getQnaFileName()%></a>
						<%
						}
						%>
					</td>
				</tr>
				<tr>
					<th class="qna-views-top">내용</th>
					<td colspan="4">
						<div class="qna-views-qnacontent"
							style="overflow: auto; text-align: left; padding-left: 5px;">
							<%=faq.getQnaContentBr()%>
						</div>
					</td>
				</tr>
				<%
				if (m != null && faq.getQnaWriter().equals(m.getMemberId())) {
				%>
				<tr>
					<th colspan="5" class="qnaBtn">
						<%
						if (fc == null) {
						%>
						<div class="qnaUpdateBtn">
							<a href="/faqqnaUpdateFrm.do?qnaNo=<%=faq.getQnaNo()%>">수정</a>
						</div> 
						<%
						}
 						%>
						<div class="qnaUpdateBtn">
							<a href="javascript:void(0)"
								onclick="qnaDelete(<%=faq.getQnaNo()%>)">삭제</a>
						</div>
					</th>
				</tr>
				<%
				}
				%>
			</table>

			<%
			if (fc == null) {
			%>
			<%
			if (m.getMemberLevel() == 1) {
			%>
			<div class="commentBox">
				<form action="/insertQnaComment.do" method="post">
					<div class="comment-info">
						<div class="comment-wrap">
							<div class="info-icon">
								<span class="material-icons" style="font-size: 50px;">account_circle</span>
							</div>
							<div class="comment-user-info" style="border: none">
								<input type="hidden" name="qcWriter"
									value="<%=m.getMemberId()%>"> <input type="hidden"
									name="qnaRef" value="<%=faq.getQnaNo()%>"> <input
									type="hidden" name="qcRef" value="0">
								<p></p>
								<p></p>
							</div>
							<div class="comment-text">
								<textarea id="comment-textarea" name="qcContent"></textarea>
							</div>
							<div class="commentBtn">
								<button type="submit" class="commentButton">등록</button>
							</div>
						</div>
					</div>
				</form>
			</div>
			<%
			}
			%>
			<%
			} else {
			%>

			<div class="commentBox">

				<div class="comment-info">
					<div class="comment-wrap">
						<div class="info-icon">
							<span class="material-icons" style="font-size: 50px;">account_circle</span>
						</div>
						<div class="comm-user-info" style="border: none;">
							<p><%=fc.getQcWriter()%></p>
							<p><%=fc.getQcDate()%></p>
						</div>
						<div class="comment-text">
							<textarea class="comment-textBox" name="commenttextContent"
								readonly><%=fc.getQcContent()%></textarea>
						</div>

						<%
						if (m.getMemberLevel() == 1) {
						%>
						<div class="qnaComm-btn">
							<div class="commUpdateBtn">
								<a href="javascript:void(0)"
									onclick="qnaCommUpdate(this,<%=fc.getQcNo()%>,<%=faq.getQnaNo()%>);">수정</a>
							</div>
							<div class="commDelBtn">
								<a href="javascript:void(0)"
									onclick="qnaCommDelete(this,<%=fc.getQcNo()%>,<%=faq.getQnaNo()%>);">삭제</a>
							</div>
						</div>
						<%
						}
						%>
					</div>
				</div>

			</div>
			<%
			}
			%>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	<script>
    	function qnaDelete(qnaNo){
    		if(confirm("문의사항을 삭제하시겠습니까?")){
    			location.href="/faqqnaDelete.do?qnaNo="+qnaNo;
    		}
    	}
    	function qnaCommUpdate(obj,fcNo,qnaNo){
    		$(obj).parent().parent().prev().children().attr('readonly',false).css("background-color","lightcyan").focus();
    		$(obj).text("완료");
    		$(obj).attr("onclick","commUpdateComplete(this,"+fcNo+","+qnaNo+")");
    		
    		$(obj).parent().next().children().text("취소");
    		$(obj).parent().next().children().attr("onclick","commUpdateCancel(this,"+fcNo+","+qnaNo+")");
    	}
    	function commUpdateCancel(obj,fcNo,qnaNo){
    		$(obj).parent().parent().prev().children().attr('readonly',true).css("background-color","white");
    		
    		$(obj).parent().prev().children().text("수정");
    		$(obj).parent().prev().children().attr("onclick","qnaCommUpdate(this,"+fcNo+","+qnaNo+")");

    		$(obj).text("삭제");
    		$(obj).attr("onclick","qnaCommDelete(this,"+fcNo+","+qnaNo+")");
    	}
    	function commUpdateComplete(obj,fcNo,qnaNo){
    		//form태그 생성
    		const form = $("<form action='/qnaCommUpdate.do' method='post'></form>")
    		//input태그 생성
    		const fcInput = $("<input type='text' name='fcNo'>");
    		//fcNo값 세팅
    		fcInput.val(fcNo);
    		//form태그에 추가
    		form.append(fcInput);
    		//input태그 생성(qnaNo);
    		const qnaInput = $("<input type='text' name='qnaNo'>");
    		qnaInput.val(qnaNo);
    		form.append(qnaInput);
    		//textarea
    		console.log($(obj).parent().parent().prev().children());
    		const fcContent = $(obj).parent().parent().prev().children().clone();
    		form.append(fcContent);
    		$("body").append(form);
    		
    		form.submit();
    	}
    	function qnaCommDelete(obj,fcNo,qnaNo){
    		if(confirm("삭제하시겠습니까?")){
    				location.href="/qnaCommDelete.do?fcNo="+fcNo+"&qnaNo="+qnaNo;
    			}
    		}
    	
    </script>
</body>
</html>