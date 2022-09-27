<%@page import="kr.co.ansany.product.model.vo.Product"%>
<%@page import="kr.co.ansany.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    ArrayList<Product> list =(ArrayList<Product>)request.getAttribute("list");  
    String pageNavi = (String)request.getAttribute("pageNavi");
    %>

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
	.admin-wrap>ul>a:nth-child(4){
		border-bottom: 3px solid #F05454;
	  	font-weight: bold;
  		color: #F05454;
	}

.page-navi {
	width: 100%;
	margin: 0 auto;
	padding: 40px 20px;
	float: none;
}

.page-navi ul {
	
	display: flex;
	align-items: center;
	justify-content: space-around;
	text-align: center;
	list-style: none;
	padding-left: 0;
	border-bottom: 2px solid #888;
}

.page-navi span {
	font-weight: 600;
}

.page-navi a {
	display: block;
	position: relative;
	font-weight: 600px;
	font-size: 22px;
	line-height: 50px;
	text-decoration: none;
	color: #010101;
	border-bottom: 2px solid transparent;
}

.pagination {
	justify-content: center;
	align-items: center;
	
}

.pagination a {
	color: black;
}
	.pageNavi {
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
	      	<div class="tabcontent" id="productList">
	      		<div class="contentHead">
		          <h2>상품목록/수정</h2>
		          <button class="btn btn-dark adminLogout">로그아웃</button>        	
        	</div>
	      		<table class="table">
		      		<tr>
		              <th scope="col">상품번호</th>
		              <th scope="col">
		              	<select class="btn btn-light selectCateCode">
		              		<option value="5678" selected>카테고리코드</option>
		              		<option value="5001">헤드폰/이어폰</option>
		              		<option value="6001">스피커</option>
		              		<option value="7001">턴테이블</option>
		              		<option value="8001">워크맨</option>
		              	</select>
		              </th>
		              <th scope="col">상품명</th>
		              <th scope="col">상품가격</th>
		              <th scope="col">재고</th>
		              <th scope="col">이미지</th>             
		              <th scope="col">수정</th>
		              <th scope="col">삭제</th>
		            </tr>
		         </table>
		         <table class="table allProdList">
		            <%for(Product p : list){ %>
		            <tr>
		            	<td><%=p.getProductNo() %></td>
		            	<%if (p.getCateCode()==5001){ %>
		            	<td>헤드폰/이어폰</td>
		            	<%} %>
		            	<%if (p.getCateCode()==6001){ %>
		            	<td>스피커</td>
		            	<%} %>
		            	<%if (p.getCateCode()==7001){ %>
		            	<td>턴테이블</td>
		            	<%} %>
		            	<%if (p.getCateCode()==8001){ %>
		            	<td>워크맨</td>
		            	<%} %>
		            	<td><%=p.getProductName() %></td>
		            	<td><%=p.getProductPrice() %></td>
		            	<td><%=p.getProductQty() %></td>
		            	<td><img src="/upload/prodImg/<%=p.getProductImg()%>" style="width:100px; height: 100px;"> </td>		            	
		            	<td>
		            		<button type="button" class="btn btn-outline-dark modification">수정하기</button>
		            	</td>
		            	<td>
		            		<button type="button" class="btn btn-outline-danger deleteProd">삭제</button>
		            	</td>
		            </tr>
		            <%} %>	       		           
	      		</table>
	      		<table class="table showProdCategory" style="display: none">
	      		<!-- 조회된 카테고리 리스트 불러오기 -->
	      		</table>
				<div class="pageNavi allProdList"><%=pageNavi %></div>            
	      	</div>
	      </div>
	     </div>
    </div>
	
	
        <script src="/js/admin1.js"></script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>