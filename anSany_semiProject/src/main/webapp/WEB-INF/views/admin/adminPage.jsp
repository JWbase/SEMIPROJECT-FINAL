<%@page import="kr.co.ansany.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지</title>
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
	.admin-wrap>ul>a:first-child{
		border-bottom: 3px solid #F05454;
	  	font-weight: bold;
  		color: #F05454;
	}
</style>
<body style="background-color: #fff;">
	<%@include file="/WEB-INF/views/common/header.jsp" %>
<div class="page-content">
    <div class="admin-wrap">
      <ul>
      	<a href="/adminPage.do"><li>전체회원 목록</li></a>
        <a href="/searchMemberFrm.do"><li>회원 조회/수정</li></a>
        <a href="/productInsertFrm.do"><li>상품등록</li></a>
        <a href="/prodList.do?reqPage=1"><li>상품 목록/수정</li></a>
        <a href="/orderList.do"><li>주문내역 확인</li></a>
      </ul>
      <div class="content-wrap">
        <div class="tabcontent">
        	<div class="contentHead">
		          <h2>전체회원 목록</h2>
		          <button class="btn btn-dark adminLogout">로그아웃</button>        	
        	</div>
          <table class="table">
            <tr>
              <th scope="col">선택</th>
              <th scope="col">회원번호</th>
              <th scope="col">회원아이디</th>
              <th scope="col">이름</th>
              <th scope="col">생년월일</th>
              <th scope="col">전화번호</th>
              <th scope="col">주소</th>
              <th scope="col">이메일</th>
              <th scope="col">가입일</th>
              <th scope="col">회원등급</th>
              <th scope="col">등급변경</th>
            </tr>
            <%for(Member member : list) {%>
            <tr>
              <td>
                <input type="checkbox" class="chk">
              </td>
              <td><%=member.getMemberNo() %></td>
              <td><%=member.getMemberId() %></td>
              <td><%=member.getMemberName() %></td>
              <td><%=member.getMemberBirth() %></td>
              <td><%=member.getMemberPhone() %></td>
              <td><%=member.getMemberAddr() %></td>
              <td><%=member.getMemberEmail() %></td>        
              <td><%=member.getEnrollDate() %></td>
 			  <td>
					<%if(member.getMemberLevel()==1) {%>
					<select class="btn btn-outline-dark">
						<option value="1" selected>관리자</option>
						<option value="2">정회원</option>
						<option value="3">준회원</option>						
					</select>
					<%}else if(member.getMemberLevel()==2){ %>
					<select class="btn btn-outline-dark">
						<option value="1">관리자</option>
						<option value="2" selected>정회원</option>
						<option value="3">준회원</option>						
					</select>
					<%}else if(member.getMemberLevel()==3){ %>
					<select class="btn btn-outline-dark">
						<option value="1">관리자</option>
						<option value="2">정회원</option>
						<option value="3" selected>준회원</option>						
					</select>
					<%} %>
				</td>                     
              <td>
                <button type="button" class="btn btn-outline-dark changeLevel">등급변경</button>
              </td>
            </tr>
            <%} %>
            <tr>
              <td colspan="11">
                <button type="button" class="btn btn-outline-dark chkedChange">선택 회원 등급 변경</button>
              </td>
            </tr>
          </table>
        </div>        
      </div>
    </div>
  </div>
        <script src="/js/admin1.js"></script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>