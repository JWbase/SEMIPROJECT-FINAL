<%@page import="javax.swing.plaf.synth.SynthOptionPaneUI"%>
<%@page import="kr.co.ansany.freeboard.model.vo.FreeBoardComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.ansany.freeboard.model.vo.FreeBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
FreeBoard f = (FreeBoard) request.getAttribute("f");
ArrayList<FreeBoardComment> commentList = (ArrayList<FreeBoardComment>) request.getAttribute("commentList");
ArrayList<FreeBoardComment> reCommentList = (ArrayList<FreeBoardComment>) request.getAttribute("reCommentList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<link rel="stylesheet" href="/css/bootstrap.css" />
<link rel="stylesheet" href="/css/Noto_Sans.css" />
<style>
.header-logo>a>img {
	margin-bottom: 14px;
}

p {
	margin: 0;
}

.page-content {
	padding-top: 81px;
}

.table {
	text-align: center;
}

.page-wrap {
	padding-top: 50px;
	padding-bottom: 100px;
	background-color: #fff;
}

.page-content {
	width: 960px;
	margin: 0 auto;
}

.input-form {
	width: 100%;
	display: block;
	padding: 0.8rem;
	background-color: #fff;
	outline: none;
	box-sizing: border-box;
}

.page-title {
	padding: 20px 0px;
	padding-left: 10px;
	font-size: 1.5rem;
	font-family: ns-bold;
}

#freeBoardContent {
	min-height: 300px;
	text-align: left;
	padding-left: 10px;
}

.wrap-bottom {
	width: 960x;
	margin: 0 auto;
	margin-bottom: 36px;
}

.wrap-bottom>div>a{
	display: block;
	width: 80px;
	line-height: 24px;
	height: 24px;
	text-decoration: none;
	color: black;
	border: 1px solid black;
	border-radius: 30px;
	font-weight: 600;
	text-align: center;
	float: right;
	font-size: 14px;
}

.wrap-bottom>div>button {
	display: block;
	width: 80px;
	line-height: 24px;
	height: 24px;
	text-decoration: none;
	color: black;
	border: 1px solid black;
	border-radius: 30px;
	font-weight: 600;
	text-align: center;
	float: right;
	font-size: 14px;
	background-color: #000;
	color: #fff;
	margin-left: 10px;
	padding: 0;
}

.wrap-bottom>div>button:hover {
	background-color: #5865f5;
	color: white;
	border-color: #5865f5;
}

.wrap-bottom>div>a:hover {
	background-color: #000;
	color: #fff;
	border-color: #fff;
}

.td-title {
	width: 300px
}

th {
	vertical-align: middle;
}

.inputCommentBox>form>ul {
	list-style-type: none;
	display: flex;
}

.inputCommentBox>form>ul>li:first-child {
	width: 15%;
	display: flex;
	justify-content: center;
	align-items: center;
}

.inputCommentBox>form>ul>li:first-child>span {
	font-size: 80px;
}

.inputCommentBox>form>ul>li:nth-child(2) {
	width: 75%
}

.inputCommentBox>form>ul>li:nth-child(2)>textarea.input-form {
	height: 96px;
	min-height: 96px;
	resize: none;
}

.inputCommentBox>form>ul>li:last-child>button {
	height: 96px;
	border: 1px solid black;
	background-color: black;
	color: #fff;
}

.inputRecommentBox {
	margin: 30px 0px;
	display: none;
}

.inputRecommentBox>form>ul {
	list-style-type: none;
	display: flex;
}

.inputRecommentBox>form>ul>li:first-child {
	width: 15%;
	display: flex;
	justify-content: center;
	align-items: center;
}

.inputRecommentBox>form>ul>li:first-child>span {
	font-size: 50px;
}

.inputRecommentBox>form>ul>li:nth-last-child(2) {
	width: 75%;
}

.inputRecommentBox>form>ul>li:nth-last-child(2)>textarea.input-form {
	height: 96px;
	min-height: 96px;
	resize: none;
}

.inputRecommentBox>form>ul>li:last-child {
	width: 10%;
}

.inputRecommentBox>form>ul>li:last-child>button {
	height: 96px;
	border: 1px solid black;
	background-color: black;
	color: #fff;
}

/* 댓글관련 css */
.posting-comment {
	display: flex;
	border-top: 2px solid #ccc;
	list-style-type: none;
}

.posting-comment>li {
	box-sizing: border-box;
}

.posting-comment>li:first-child {
	width: 15%;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100px;
	border-right: 1px solid #ccc;
}

.posting-comment.reply>li:first-child {
	width: 20%;
}

.posting-comment>li:first-child .material-icons {
	font-size: 80px;
}

.posting-comment.reply>li:first-child .material-icons:first-child {
	font-size: 40px;
}

.posting-comment.reply>li:last-child {
	display: flex;
	flex-direction: column;
	width: 80%;
}

.posting-comment>li:last-child {
	display: flex;
	flex-direction: column;
	width: 85%;
}

.posting-comment>li:last-child>p {
	width: 100%;
	padding: 5px;
	box-sizing: border-box;
}

.posting-comment>li:last-child>.comment-info>span {
	padding: 0px 10px;
}

.posting-comment>li:last-child>.comment-info>span:not(:last-child) {
	border-right: 2px solid #ccc;
}

.posting-comment>li:last-child>.comment-content {
	padding: 0px 15px;
}

.posting-comment>li:last-child>.comment-link {
	text-align: right;
}

.posting-comment>li:last-child>.comment-link>a {
	margin: 0px 5px;
}

.posting-comment>li:last-child>.comment-link>a:hover {
	text-decoration: underline;
}

.comment-link>a {
	text-decoration: none;
	color: #000;
}

.material-icons {
	color: #222222;
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-wrap">
		<div class="page-content">
			<div class="page-title">자유게시판</div>
			<%
			if (m != null) {
			%>
			<%
			if (f.getFreeBoardWriter().equals(m.getMemberId())) {
			%>
			<div class="wrap-bottom">
				<div>
					<button onclick="freeBoardDelete(<%=f.getFreeBoardNo()%>);">삭제</button>
					<a
						href="/freeBoardUpdateFrm.do?freeBoardNo=<%=f.getFreeBoardNo()%>">수정</a>
				</div>
			</div>
			<%
			} else if (m.getMemberLevel() == 1) {
			%>
			<div class="wrap-bottom">
				<div>
					<button onclick="freeBoardDelete(<%=f.getFreeBoardNo()%>);">삭제</button>
				</div>
			</div>
			<%
			}
			%>
			<%
			}
			%>

			<table class="table table-group-divider" id="freeBoardView">
				<tr class="table-secondary">
					<th>제목</th>
					<td colspan="3" class="td-title"><%=f.getFreeBoardTitle()%></td>
					<th>작성자</th>
					<td><%=f.getFreeBoardWriter()%></td>
					<th>조회수</th>
					<td><%=f.getFreeBoardReadCount()%></td>
					<th>작성일</th>
					<td><%=f.getFreeBoardDate()%></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="9">
						<%
						if (f.getFreeBoardFilename() != null) {
						%> <img src="/img/file.png" width="16px"> <a
						href="/freeBoardFileDown.do?freeBoardNo=<%=f.getFreeBoardNo()%>"><%=f.getFreeBoardFilename()%></a>
						<%
						}
						%>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="9">
						<div id="freeBoardContent"><%=f.getfreeBoardContentBr()%></div>
					</td>
				</tr>
			</table>

			<%
			if (m != null) {
			%>

			<div class="inputCommentBox">
				<form action="/insertFcomment.do" method="post">
					<ul>
						<li><span class="material-icons">person</span></li>
						<li><input type="hidden" name="fCommentWriter"
							value="<%=m.getMemberId()%>"> <input type="hidden"
							name="freeBoardRef" value="<%=f.getFreeBoardNo()%>"> <input
							type="hidden" name="fCommentRef" value="0"> <textarea
								class="input-form" name="fCommentContent"></textarea></li>
						<li>
							<button type="submit" class="btn-repl">댓글쓰기</button>
						</li>
					</ul>
				</form>
			</div>
			<%
			}
			%>
			<div class="commentBox">
				<%
				for (FreeBoardComment fc : commentList) {
				%>
				<ul class="posting-comment">
					<li><span class="material-icons">person</span></li>
					<li>
						<p class="comment-info">
							<span><%=fc.getfCommentWriter()%></span> <span><%=fc.getfCommentDate()%></span>
						</p>
						<p class="comment-content"><%=fc.getfCommentContent()%></p>
						<textarea name="fCommentContent" class="input-form"
							style="min-height: 96px; display: none;"><%=fc.getfCommentContent()%></textarea>
						<p class="comment-link">
							<%
							if (m != null) {
							%>
							<%
							if (m.getMemberId().equals(fc.getfCommentWriter())) {
							%>
							<a href="javascript:void(0)"
								onclick="modifyComment(this,<%=fc.getfCommentNo()%>, <%=f.getFreeBoardNo()%>);">수정</a>
							<a href="javascript:void(0)"
								onclick="deleteComment(this,<%=fc.getfCommentNo()%>, <%=f.getFreeBoardNo()%>);">삭제</a>
							<%
							}
							%>
							<a href="javascript:void(0)" class="recShow">답글</a>
							<%
							}
							%>
						</p>
					</li>
				</ul>

				<%
				for (FreeBoardComment fct : reCommentList) {
				%>
				<%
				if (fct.getfCommentRef() == fc.getfCommentNo()) {
				%>
				<ul class="posting-comment reply">
					<li><span class="material-icons">subdirectory_arrow_right</span>
						<span class="material-icons">person</span></li>
					<li>
						<p class="comment-info">
							<span><%=fct.getfCommentWriter()%></span> <span><%=fct.getfCommentDate()%></span>
						</p>
						<p class="comment-content"><%=fct.getfCommentContent()%></p> <textarea
							name="fCommentContent" class="input-form"
							style="min-height: 96px; display: none;"><%=fct.getfCommentContent()%></textarea>
						<p class="comment-link">
							<%
							if (m != null) {
							%>
							<%
							if (m.getMemberId().equals(fct.getfCommentWriter())) {
							%>
							<a href="javascript:void(0)"
								onclick="modifyComment(this,<%=fct.getfCommentNo()%>, <%=f.getFreeBoardNo()%>);">수정</a>
							<a href="javascript:void(0)"
								onclick="deleteComment(this,<%=fct.getfCommentNo()%>, <%=f.getFreeBoardNo()%>);">삭제</a>
							<%
							}
							%>
							<%
							}
							%>
						</p>
					</li>
				</ul>
				<%
				}
				%>
				<%
				}
				%>
				<%
				if (m != null) {
				%>
				<div class="inputRecommentBox">
					<form action="/insertFcomment.do" method="post">
						<ul>
							<li><span class="material-icons">subdirectory_arrow_right</span>
							</li>
							<li><input type="hidden" name="fCommentWriter"
								value="<%=m.getMemberId()%>"> <input type="hidden"
								name="freeBoardRef" value="<%=f.getFreeBoardNo()%>"> <input
								type="hidden" name="fCommentRef" value="<%=fc.getfCommentNo()%>">
								<textarea class="input-form" name="fCommentContent"></textarea></li>
							<li>
								<button type="submit" class="btn-repl">댓글쓰기</button>
							</li>
						</ul>
					</form>
				</div>
				<%
				} // 답글달기 form 조건문
				%>
				<%
				} // 댓글종료 반복문 종료
				%>
			</div>
		</div>
	</div>
	<script>
		function freeBoardDelete(freeBoardNo){
			if(confirm("삭제하시겠습니까?")) {
				location.href="/freeBoardDelete.do?freeBoardNo="+freeBoardNo;
			}
		}
		
		$(".recShow").on("click",function(){
			const idx = $(".recShow").index(this);
			if($(this).text() == "답글") {
				$(this).text("취소");
			} else {
				$(this).text("답글");
			}
			$(".inputRecommentBox").eq(idx).toggle();
			$(".inputRecommentBox").eq(idx).find("textarea").focus();
		});
		
		function modifyComment(obj,fCommentNo,freeBoardNo) {
			$(obj).parent().prev().show();
			$(obj).parent().prev().prev().hide();
			$(obj).text("수정");
			$(obj).attr("onclick","modifyComplete(this,"+fCommentNo+","+freeBoardNo+")");
			
			$(obj).next().text("취소");
			$(obj).next().attr("onclick","modifyCancle(this,"+fCommentNo+","+freeBoardNo+")");
			
			$(obj).next().next().hide();
		}
		function modifyCancle(obj,fCommentNo,freeBoardNo){
			$(obj).parent().prev().hide();
			$(obj).parent().prev().prev().show();
			
			$(obj).prev().text("수정");
			$(obj).prev().attr("onclick","modifyComment(this,"+fCommentNo+","+freeBoardNo+")");
			$(obj).text("삭제");
			$(obj).attr("onclick","deleteComment(this,"+fCommentNo+","+freeBoardNo+")");
			$(obj).next().show();
		}
		
		function modifyComplete(obj,fCommentNo,freeBoardNo){
			const form = $("<form action='/freeBoardCommentUpdate.do' method='post'></form>");
			const fCommentInput = $("<input type ='text' name='fCommentNo'>");
			fCommentInput.val(fCommentNo);
			form.append(fCommentInput);
			const freeBoardInput = $("<input type='text' name='freeBoardNo'>");
			freeBoardInput.val(freeBoardNo);
			form.append(freeBoardInput);
			const fCommentContent = $(obj).parent().prev();
			form.append(fCommentContent);
			$("body").append(form);
			form.submit();
		}
		
		function deleteComment(obj,fCommentNo,freeBoardNo){
			if(confirm("댓글을 삭제하시겠습니까?")){
				location.href = "/deleteFreeBoardComment.do?fCommentNo="+fCommentNo+"&freeBoardNo="+freeBoardNo;
			}
		}
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>