package kr.co.ansany.review.model.service;

import kr.co.ansany.review.model.vo.Review;
import kr.co.ansany.review.model.vo.ReviewComment;
import kr.co.ansany.review.model.vo.ReviewPageData;
import kr.co.ansany.review.model.vo.ReviewViewData;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.co.ansany.review.model.dao.ReviewDao;

public class ReviewService {

	private ReviewDao dao;

	public ReviewService() {
		super();
		dao = new ReviewDao();
	}

	public ReviewPageData selectReviewList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10; // 페이지당 게시물 수
		int end = numPerPage * reqPage;
		int start = end - numPerPage + 1;
		ArrayList<Review> list = dao.selectReviewList(conn, start, end);
		int totalCount = dao.selectReviewCount(conn);
		int totalPage = 0;
		if (totalCount % numPerPage == 0) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}

		int pageNaviSize = 10;
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;

		String pageNavi = "<nav aria-label='Page navigation example'>";
		pageNavi += "<ul class='pagination'>";
		if (pageNo != 1) {
			pageNavi += "<li class='page-item'><a class='page-link' href='/reviewList.do?reqPage=" + (pageNo - 1)
					+ "'>Previous</a></li>";
		}
		for (int i = 0; i < pageNaviSize; i++) {
			if (pageNo == reqPage) {
				pageNavi += "<li class='page-item active' aria-current='page'><a class='page-link' href='/reviewList.do?reqPage="
						+ pageNo + "'>" + pageNo + "</a></li>";
			} else {
				pageNavi += "<li class='page-item'><a class='page-link' href='/reviewList.do?reqPage=" + pageNo + "'>"
						+ pageNo + "</a></li>";
			}
			pageNo++;
			if (pageNo > totalPage) {
				break;
			}
		}

		if (pageNo <= totalPage) {
			pageNavi += "<li class='page-item'><a class='page-link' href='/reviewList.do?reqPage=" + pageNo
					+ "'>Next</a></li>";
		}
		pageNavi += "</ul>";
		pageNavi += "</nav>";
		ReviewPageData fpd = new ReviewPageData(list, pageNavi);
		JDBCTemplate.close(conn);

		return fpd;
	}

	public int insertReview(Review r) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertReview(conn, r);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ReviewViewData selectOneReview(int reviewNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateReadCount(conn, reviewNo);
		if (result > 0) {
			JDBCTemplate.commit(conn);
			Review r = dao.selectOneReview(conn, reviewNo);

			ArrayList<ReviewComment> commentList = dao.selectReviewCommentList(conn, reviewNo);
			ArrayList<ReviewComment> reCommentList = dao.selectReviewReCommentList(conn, reviewNo);

			ReviewViewData rvd = new ReviewViewData(r, commentList, reCommentList);

			JDBCTemplate.close(conn);
			return rvd;
		} else {
			JDBCTemplate.rollback(conn);
			JDBCTemplate.close(conn);
			return null;
		}
	}

	public Review getReview(int reviewNo) {
		Connection conn = JDBCTemplate.getConnection();
		Review r = dao.selectOneReview(conn, reviewNo);
		JDBCTemplate.close(conn);
		return r;
	}

	public int updateReview(Review r) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateReview(conn, r);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertReviewComment(ReviewComment rc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertReviewComment(conn, rc);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Review deleteReview(int reviewNo) {
		Connection conn = JDBCTemplate.getConnection();
		Review r = dao.selectOneReview(conn, reviewNo);
		int result = dao.deleteReview(conn, reviewNo);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
			r = null;
		}
		JDBCTemplate.close(conn);
		return r;
	}

	public int deleteReviewComment(int rCommentNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.deleteNoticeComment(conn, rCommentNo);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateReviewComment(ReviewComment rc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateFreeBoardComment(conn, rc);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ReviewPageData searchReview(int searchCategory, String searchKeyWord, int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10; // 페이지당 게시물 수
		int end = numPerPage * reqPage;
		int start = end - numPerPage + 1;

		ArrayList<Review> list = dao.searchReview(conn, searchCategory, searchKeyWord, start, end);
		int totalCount = dao.selectReviewCount(conn, searchCategory, searchKeyWord);
		
		int totalPage = 0;
		if (totalCount % numPerPage == 0) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}

		int pageNaviSize = 10;
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;

		String pageNavi = "<nav aria-label='Page navigation example'>";
		pageNavi += "<ul class='pagination'>";
		if (pageNo != 1) {
			pageNavi += "<li class='page-item'><a class='page-link' href='/searchReview.do?reqPage=" + (pageNo - 1)
					+ "&searchCategory=" + searchCategory + "&searchKeyWord=" + searchKeyWord + "'>Previous</a></li>";
		}
		for (int i = 0; i < pageNaviSize; i++) {
			if (pageNo == reqPage) {
				pageNavi += "<li class='page-item active' aria-current='page'><a class='page-link' href='/searchReview.do?reqPage="
						+ pageNo + "&searchCategory=" + searchCategory + "&searchKeyWord=" + searchKeyWord + "'>"
						+ pageNo + "</a></li>";
			} else {
				pageNavi += "<li class='page-item'><a class='page-link' href='/searchReview.do?reqPage=" + pageNo
						+ "&searchCategory=" + searchCategory + "&searchKeyWord=" + searchKeyWord + "'>" + pageNo
						+ "</a></li>";
			}
			pageNo++;
			if (pageNo > totalPage) {
				break;
			}
		}

		if (pageNo <= totalPage) {
			pageNavi += "<li class='page-item'><a class='page-link' href='/searchReview.do?reqPage=" + pageNo +"&searchCategory=" + searchCategory + "&searchKeyWord=" + searchKeyWord + "'>Next</a></li>";
		}
		pageNavi += "</ul>";
		pageNavi += "</nav>";
		ReviewPageData fpd = new ReviewPageData(list, pageNavi);
		JDBCTemplate.close(conn);

		return fpd;
	}

}
