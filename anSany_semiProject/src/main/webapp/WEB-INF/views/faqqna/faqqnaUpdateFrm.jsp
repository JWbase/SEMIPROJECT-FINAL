<%@page import="kr.co.ansany.faqqna.model.vo.Faqqna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Faqqna faq = (Faqqna)request.getAttribute("faq");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 서비스</title>
<link rel="stylesheet" href="css/qnaWriteFrm.css">
<link rel="stylesheet" href="css/Noto_Sans.css">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="qnaWrite-wrap"  style="padding-top: 30px;">
        <div class="qnaWrite-content">
            <div class="qnaWrite-topTitle">QnA 수정</div>
            <form action="/faqqnaUpdate.do" method="post" enctype="multipart/form-data">
                <table class="qnaWrite-Frm">
                    <tr>
                        <th class="qnaWrite-top" style="width: 15%;">분류</th>
                        <td style="width: 20%;">
                        	<%if(faq.getQnaCateNo()==1) {%>
                            <select name="qnaCateNo" id="qna-CateNo">
                                <option value="1" selected>주문/결제</option>
                                <option value="2">세금계산서/영수증</option>
                                <option value="3">배송</option>
                                <option value="4">취소/환불/AS</option>
                                <option value="5">회원관련</option>
                                <option value="6">기타문의</option>
                            </select>
                        	<%}else if(faq.getQnaCateNo()==2) {%>
                        	<select name="qnaCateNo" id="qna-CateNo">
                                <option value="1">주문/결제</option>
                                <option value="2" selected>세금계산서/영수증</option>
                                <option value="3">배송</option>
                                <option value="4">취소/환불/AS</option>
                                <option value="5">회원관련</option>
                                <option value="6">기타문의</option>
                            </select>
                        	<%}else if(faq.getQnaCateNo()==3) {%>
                        	<select name="qnaCateNo" id="qna-CateNo">
                                <option value="1">주문/결제</option>
                                <option value="2">세금계산서/영수증</option>
                                <option value="3" selected>배송</option>
                                <option value="4">취소/환불/AS</option>
                                <option value="5">회원관련</option>
                                <option value="6">기타문의</option>
                            </select>
                        	<%}else if(faq.getQnaCateNo()==4) {%>
                        	<select name="qnaCateNo" id="qna-CateNo">
                                <option value="1">주문/결제</option>
                                <option value="2">세금계산서/영수증</option>
                                <option value="3">배송</option>
                                <option value="4" selected>취소/환불/AS</option>
                                <option value="5">회원관련</option>
                                <option value="6">기타문의</option>
                            </select>
                        	<%}else if(faq.getQnaCateNo()==5) {%>
                        	<select name="qnaCateNo" id="qna-CateNo">
                                <option value="1">주문/결제</option>
                                <option value="2">세금계산서/영수증</option>
                                <option value="3">배송</option>
                                <option value="4">취소/환불/AS</option>
                                <option value="5" selected>회원관련</option>
                                <option value="6">기타문의</option>
                            </select>
                        	<%}else if(faq.getQnaCateNo()==6) {%>
                        	<select name="qnaCateNo" id="qna-CateNo">
                                <option value="1">주문/결제</option>
                                <option value="2">세금계산서/영수증</option>
                                <option value="3">배송</option>
                                <option value="4">취소/환불/AS</option>
                                <option value="5">회원관련</option>
                                <option value="6" selected>기타문의</option>
                            </select>
                        	<%} %>
                            
                        </td>
                        <th class="qnaWrite-top" style="width: 15%;">제목</th>
                        <td class="qnaWrite-sub" style="width: 50%;">
                        	<input type="hidden" name="faqNo" value="<%=faq.getQnaNo() %>">
                        	<input type="hidden" name="status" value="stay">
                        	
                        	<input type="text" name="qnaTitle" value="<%=faq.getQnaTitle() %>">
                        </td>
                    </tr>
                    <tr>
                        <th class="qnaWrite-top">작성자</th>
                        <td class="qnaWrite-sub">
                        	<%=m.getMemberId() %>
                        	<input type="hidden" name="qnaWriter" value="<%=m.getMemberId() %>">
                        </td>
                        <th class="qnaWrite-top">첨부파일</th>
                        <td class="qnaWrite-sub">
                        	<%if(faq.getQnaFilepath() != null) {%>
                        	<img src="/img/file.png" width="16px" class="delFile">
							<span class="delFile"><%=faq.getQnaFileName() %></span>
							<button type="button" class="delFile">삭제</button>
							<input type="file" name="qnaUpfile" style="display:none;">
							<input type="hidden" name="oldFilename" value="<%=faq.getQnaFileName()%>">
							<input type="hidden" name="oldFilepath" value="<%=faq.getQnaFilepath()%>">
                        	<%}else { %>
                        	<input type="file" name="qnaUpfile">
                        	<%} %>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4" style="border: none;">
                            <textarea name="qnaContent" id="qnaWrite-area" style="height: 500px; width: 98%;"><%=faq.getQnaContent() %></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4" style="height: 50px; border: none; line-height: 50px;">
                            <button type="submit" class="qna-Write-Btn">문의사항 수정</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    <script>
	    $("button.delFile").on("click",function(){
			$(".delFile").hide();
			$(this).next().show();
			$("[name=status]").val("delete");
		});
    </script>
</body>
</html>