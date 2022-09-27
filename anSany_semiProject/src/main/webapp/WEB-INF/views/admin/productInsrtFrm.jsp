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
<style>
	.page-content{
		padding-top: 81px;
		background-color: #fff;
		height: 100%;
	}
	.admin-wrap>ul>a:nth-child(3){
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
	        <a href="/prodList.do?reqPage=1"><li>상품 목록/수정</li></a>
	        <a href="/orderList.do"><li>주문내역 확인</li></a>
	      </ul>
	      <div class="content-wrap">
	      	<div class="tabcontent linkprod">
	      	  <div class="contentHead">
		          <h2>상품 등록</h2>
		          <button class="btn btn-dark adminLogout">로그아웃</button>        	
        	</div>
	      		<form action = "productInsert.do" method="post" enctype="multipart/form-data">
	      		<table class="table">    		
	      		<tr>
	      		  <th scop="col">상품번호</th>
	              <td>
	                <input type="text" name="productNo" class="form-control" disabled>
	              </td>
	            </tr>
	            <tr>
	              <th scop="col">카테고리 코드</th>
	              <td class="selectTd">
	                <select name="cateCode" >
	                	<option>선택</option>
	                	<option value="5001">헤드폰/이어폰</option>
	                	<option value="6001">스피커</option>
	                	<option value="7001">턴테이블</option>
	                	<option value="8001">워크맨</option>
	                </select>
	              </td>
	            </tr>
	            <tr>
	              <th scop="col">상품명</th>
	              <td>
	                <input type="text" name="productName" class="form-control">
	              </td>
	            </tr>
	            <tr>
	              <th scop="col">상품가격</th>
	              <td>
	                <div class="input-group">
	                  <input type="text" name="productPrice" class="form-control" placeholder=", 제외 ex)990000">
	                  <span class="input-group-text">원</span>                 
	                </div>
	              </td>
	            </tr>
	            <tr>
	              <th scop="col">수량</th>
	              <td>
	                <div class="input-group">
	                  <input type="text" name="productQty" class="form-control">
	                  <span class="input-group-text">개</span>                 
	                </div>
	              </td>
	            </tr>
	            <tr>
	              <th scop="col">상품이미지</th>
	              <td>
	                <input type="file" class="form-control" name="imageFile" accept=".jpg, .png, .jpeg, gif">
	              </td>
	            </tr>
	            <tr>
	              <th scop="col">상품정보</th>
	              <td>
	                <textarea class="form-control" name="productInfo" rows="10"></textarea>
	              </td>
	            </tr>        
	      		</table>
                <div class="btn-lists">                 
                  <button type="submit" class="btn btn-outline-success" style="font-weight: bold; font-size: 1.1em;">상품 등록</button>
                  <button type="button" class="btn btn-outline-dark"><a href="productInsertFrm.do">취소</a></button>
                  <button type="button" class="btn btn-outline-dark"><a href="prodList.do?reqPage=1">상품목록 보러가기</a></button>           
                </div>
	      		</form>
	      	</div>
	      </div>
	     </div>
    </div>
	
	
        <script src="/js/admin1.js"></script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>