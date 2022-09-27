<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div class="qnaWrite-wrap">
        <div class="qnaWrite-content">
            <div class="qnaWrite-topTitle">QnA</div>
            <form action="/faqqnaWrite.do" method="post" enctype="multipart/form-data">
                <table class="qnaWrite-Frm">
                    <tr>
                        <th class="qnaWrite-top" style="width: 15%;">분류</th>
                        <td style="width: 20%;">
                            <select name="qnaCateNo" id="qna-CateNo">
                                <option value="1">주문/결제</option>
                                <option value="2">세금계산서/영수증</option>
                                <option value="3">배송</option>
                                <option value="4">취소/환불/AS</option>
                                <option value="5">회원관련</option>
                                <option value="6">기타문의</option>
                            </select>
                        </td>
                        <th class="qnaWrite-top" style="width: 15%;">제목</th>
                        <td class="qnaWrite-sub" style="width: 50%;"><input type="text" name="qnaTitle"></td>
                    </tr>
                    <tr>
                        <th class="qnaWrite-top">작성자</th>
                        <td class="qnaWrite-sub">
                        	<%=m.getMemberId() %>
                        	<input type="hidden" name="qnaWriter" value="<%=m.getMemberId() %>">
                        </td>
                        <th class="qnaWrite-top">첨부파일</th>
                        <td class="qnaWrite-sub"><input type="file" name="qnaUpfile"></td>
                    </tr>
                    <tr>
                        <td colspan="4" style="border: none;">
                            <textarea name="qnaContent" id="qnaWrite-area" style="height: 500px; width: 98%;"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4" style="height: 50px; border: none; line-height: 50px;">
                            <button type="submit" class="qna-Write-Btn">문의사항 작성</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>