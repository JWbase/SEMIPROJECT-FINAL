<%@page import="kr.co.ansany.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style>
	.page-content{
		padding-top: 81px;
		background-color: #fff;
		height: 100%;
	}
	.admin-wrap>ul>a:nth-child(2){
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
	        <a href="//prodList.do?reqPage=1"><li>상품 목록/수정</li></a>
	        <a href="/orderList.do"><li>주문내역 확인</li></a>
	      </ul>
	      <div class="content-wrap">
	      	<div class="tabcontent">
	      	  <div class="contentHead">
		          <h2>회원 조회/수정</h2>
		          <button class="btn btn-dark adminLogout">로그아웃</button>        	
        	</div>
	      	
	            <table class="table findMembertbl">
	              <tr>
	                <th scop="col">조회분류</th>
	                <th scop="col"></th>
	                <th scop="col"></th>
	              </tr>
	              <tr>
	                <td>
	                  <select class="btn btn-outline-dark">
	                    <option value = "noCate" selected>조회분류</option>
	                    <option value="memberNo">회원번호</option>
	                    <option value="memberId">회원아이디</option>
	                    <option value="memberName">회원이름</option>
	                  </select>
	                </td>
	                <td>
	                  <input type="text" class="form-control">
	                </td>
	                <td>
	                  <button type="button" class="btn btn-outline-dark searchBtn">검색</button>
	                </td>
	              </tr>
	            </table>
           
	      	</div>
	      	<div>
	      		<table class="table result">

	      		</table>
	      	</div>
	      </div>
	     </div>
    </div>
	
	
        <script src="/js/admin1.js"></script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>