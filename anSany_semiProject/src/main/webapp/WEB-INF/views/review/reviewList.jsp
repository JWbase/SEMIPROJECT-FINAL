<%@page import="oracle.net.aso.n"%>
<%@page import="kr.co.ansany.review.model.vo.Review"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<Review> list = (ArrayList<Review>) request.getAttribute("list");
String pageNavi = (String) request.getAttribute("pageNavi");
Integer searchCategory = (Integer) request.getAttribute("searchCategory");
String searchKeyWord = (String) request.getAttribute("searchKeyWord");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매후기 목록</title>
<link rel="stylesheet" href="/css/bootstrap.css" />
<link rel="stylesheet" href="/css/Noto_Sans.css" />
<style>
.header-logo>a>img {
	margin-bottom: 14px;
}

.board_wrap {
	width: 100%;
	max-width: 1920px;
	margin: auto;
	padding-top: 81px;
	padding-bottom: 81px;
	background-color: #fff;
}

tbody {
	text-align: center;
}

tbody tr>td:nth-child(2) {
	text-align: left;
	padding-left: 30px;
}

.page-navi {
	width: 1280px;
	margin: 0 auto;
	padding: 40px 0 20px;
	float: none;
	font-family: ns-bold;
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

.tablink:hover {
	color: #ea0029;
}

.tablink.active {
	color: #ea0029;
}

.table_wrap {
	width: 100%;
	padding-top: 5px;
	padding-bottom: 30px;
}

.pagination {
	justify-content: center;
	align-items: center;
}

.pagination a {
	color: black;
}

.table {
	width: 1280px;
	margin: 0 auto;
	margin-bottom: 50px;
	text-align: center;
}

.table>tr>td>a {
	text-decoration: none;
	color: black;
}

.table:hover>tr>td>a {
	background-color: white;
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

.top-wrap {
	width: 1280px;
	margin: 0 auto;
	overflow: hidden;
}

.top-wrap>div>a {
	display: block;
	width: 100px;
	line-height: 30px;
	height: 30px;
	text-decoration: none;
	color: black;
	border: 1px solid black;
	border-radius: 30px;
	font-weight: 600;
	text-align: center;
	float: left;
}

.top-wrap>div>a:hover {
	background-color: #5865f5;
	color: white;
	border-color: #5865f5;
}

.table-hover {
	border-top: 1.5px solid #000;
}

.table-hover>thead>tr {
	border-bottom: 1.5px solid #000;
}

.table-hover>thead>tr>th {
	color: #000;
}

.top-logo {
	text-align: center;
	margin-bottom: 50px;
}

.top-logo>img {
	width: 200px;
}

.row {
	float: right;
}

.btn-control {
	border: 0;
	color: #fff;
	background: #000;
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="board_wrap">
		<nav class="page-navi">
			<ul>
				<li><a href="/noticeList.do?reqPage=1"> <span
						class="tablink">공지사항</span>
				</a></li>
				<li><a href="/reviewList.do?reqPage=1"> <span
						class="tablink">구매후기</span>
				</a></li>
				<li><a href="/photoList.do"> <span class="tablink">사진전</span>
				</a></li>
				<li><a href="/freeBoardList.do?reqPage=1"> <span
						class="tablink">자유게시판</span>
				</a></li>

			</ul>
		</nav>
		<div class="top-logo">
			<img src="/img/logo.png">
		</div>
		<div class="top-wrap">
			<div class="row">
				<form method="get" action="/searchReview.do">
					<table class="pull-right">
						<%
						if (searchKeyWord != null && searchCategory == 1) {
						%>
						<tr>
							<td><input type="hidden" value=1 name="reqPage"></td>
							<td><select class="form-select form-select-sm"
								name="searchCategory">
									<option value="1" selected="selected">제목</option>
									<option value="2">내용</option>
									<option value="3">작성자</option>
							</select></td>
							<td style="padding-left: 5px; padding-right: 5px;"><input
								type="text" class="form-control form-control-sm"
								placeholder="검색어 입력" name="searchKeyWord"
								value="<%=searchKeyWord%>" required></td>
							<td><button type="submit"
									class="btn-control form-control-sm">검색</button></td>
						</tr>
						<%
						} else if (searchKeyWord != null && searchCategory == 2) {
						%>
						<tr>
							<td><input type="hidden" value=1 name="reqPage"></td>
							<td><select class="form-select form-select-sm"
								name="searchCategory">
									<option value="1">제목</option>
									<option value="2" selected="selected">내용</option>
									<option value="3">작성자</option>
							</select></td>
							<td style="padding-left: 5px; padding-right: 5px;"><input
								type="text" class="form-control form-control-sm"
								placeholder="검색어 입력" name="searchKeyWord"
								value="<%=searchKeyWord%>" required></td>
							<td><button type="submit"
									class="btn-control form-control-sm">검색</button></td>
						</tr>
						<%
						} else if (searchKeyWord != null && searchCategory == 3) {
						%>
						<tr>
							<td><input type="hidden" value=1 name="reqPage"></td>
							<td><select class="form-select form-select-sm"
								name="searchCategory">
									<option value="1">제목</option>
									<option value="2">내용</option>
									<option value="3" selected="selected">작성자</option>
							</select></td>
							<td style="padding-left: 5px; padding-right: 5px;"><input
								type="text" class="form-control form-control-sm"
								placeholder="검색어 입력" name="searchKeyWord"
								value="<%=searchKeyWord%>" required></td>
							<td><button type="submit"
									class="btn-control form-control-sm">검색</button></td>
						</tr>
						<%
						} else {
						%>
						<tr>
							<td><input type="hidden" value=1 name="reqPage"></td>
							<td><select class="form-select form-select-sm"
								name="searchCategory">
									<option value="1">제목</option>
									<option value="2">내용</option>
									<option value="3">작성자</option>
							</select></td>
							<td style="padding-left: 5px; padding-right: 5px;"><input
								type="text" class="form-control form-control-sm"
								placeholder="검색어 입력" name="searchKeyWord"></td>
							<td><button type="submit"
									class="btn-control form-control-sm">검색</button></td>
						</tr>
						<%
						}
						%>
					</table>
				</form>
			</div>

			<%
			if (m != null) {
			%>
			<div>
				<a href="/reviewWriteFrm.do">글쓰기</a>
			</div>
			<%
			}
			%>
		</div>
		<div class="table_wrap">
			<table class="table table-hover">
				<thead class="table">
					<tr>
						<th scope="col" style="width: 10%;">번호</th>
						<th scope="col" style="width: 55%;">제목</th>
						<th scope="col" style="width: 10%;">작성자</th>
						<th scope="col" style="width: 15%;">등록일</th>
						<th scope="col" style="width: 10%;">조회수</th>
					</tr>
				</thead>
				<%
				for (Review r : list) {
				%>
				<tbody class="table">
					<tr>
						<th scope="row"><%=r.getReviewNo()%></th>
						<td><a href="/reviewView.do?reviewNo=<%=r.getReviewNo()%>"><%=r.getReviewTitle()%></a></td>
						<td><%=r.getReviewWriter()%></td>
						<td><%=r.getReviewDate()%></td>
						<td><%=r.getReviewReadCount()%></td>
					</tr>
				</tbody>
				<%
				}
				%>
			</table>
			<div class="pageNavi"><%=pageNavi%></div>
		</div>
	</div>
	<script>
		$(".tablink:eq(1)").addClass("active");

		$(".tablink").on("click", function() {
			const selectedIndex = $(".tablink").index(this);
			$(".tablink").each(function(index, item) {
				if (index != selectedIndex) {
					$(item).removeClass("active");
				} else {
					$(item).addClass("active");
				}
			});
		});
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>