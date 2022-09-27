package kr.co.ansany.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.co.ansany.freeboard.model.vo.FreeBoard;
import kr.co.ansany.review.model.vo.Review;
import kr.co.ansany.review.model.vo.ReviewComment;

public class ReviewDao {

	public ArrayList<Review> selectReviewList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> list = new ArrayList<Review>();
		String query = "select * from (select rownum as rnum, n.* from (select * from review_tbl order by review_no desc)n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Review r = new Review();
				r.setReviewNo(rset.getInt("Review_No"));
				r.setReviewTitle(rset.getString("Review_title"));
				r.setReviewWriter(rset.getString("Review_writer"));
				r.setReviewContent(rset.getString("Review_content"));
				r.setReviewReadCount(rset.getInt("Review_readcount"));
				r.setReviewDate(rset.getString("Review_date"));
				r.setReviewFilename(rset.getString("Review_filename"));
				r.setReviewFilepath(rset.getString("Review_filepath"));
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int selectReviewCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from review_tbl";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return totalCount;
	}

	public int insertReview(Connection conn, Review r) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into review_tbl values(review_seq.nextval,?,?,?,0,to_char(sysdate, 'yyyy-mm-dd'),?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getReviewTitle());
			pstmt.setString(2, r.getReviewWriter());
			pstmt.setString(3, r.getReviewContent());
			pstmt.setString(4, r.getReviewFilename());
			pstmt.setString(5, r.getReviewFilepath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public int updateReadCount(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update review_tbl set review_readcount = review_readcount + 1 where review_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Review selectOneReview(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review r = null;
		String query = "select * from review_tbl where review_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				r = new Review();
				r.setReviewFilename(rset.getString("review_filename"));
				r.setReviewFilepath(rset.getString("review_filepath"));
				r.setReviewContent(rset.getString("review_content"));
				r.setReviewDate(rset.getString("review_date"));
				r.setReviewNo(rset.getInt("review_no"));
				r.setReviewReadCount(rset.getInt("review_readcount"));
				r.setReviewTitle(rset.getString("review_title"));
				r.setReviewWriter(rset.getString("review_writer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return r;
	}

	public ArrayList<ReviewComment> selectReviewCommentList(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReviewComment> list = new ArrayList<ReviewComment>();
		String query = "select * from review_comment_tbl where review_ref = ? and rcomment_ref is null order by 1";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				ReviewComment rc = new ReviewComment();
				rc.setrCommentContent(rset.getString("rcomment_content"));
				rc.setrCommentDate(rset.getString("rcomment_date"));
				rc.setrCommentNo(rset.getInt("rcomment_no"));
				rc.setrCommentRef(rset.getInt("rcomment_ref"));
				rc.setrCommentWriter(rset.getString("rcomment_writer"));
				rc.setReviewRef(rset.getInt("review_ref"));
				list.add(rc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<ReviewComment> selectReviewReCommentList(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReviewComment> list = new ArrayList<ReviewComment>();
		String query = "select * from review_comment_tbl where review_ref = ? and rcomment_ref is not null order by 1";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				ReviewComment rc = new ReviewComment();
				rc.setrCommentContent(rset.getString("rcomment_content"));
				rc.setrCommentDate(rset.getString("rcomment_date"));
				rc.setrCommentNo(rset.getInt("rcomment_no"));
				rc.setrCommentRef(rset.getInt("rcomment_ref"));
				rc.setrCommentWriter(rset.getString("rcomment_writer"));
				rc.setReviewRef(rset.getInt("review_ref"));
				list.add(rc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int updateReview(Connection conn, Review r) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update review_tbl set review_title=?, review_content=?, review_filename=?, review_filepath=? where review_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getReviewTitle());
			pstmt.setString(2, r.getReviewContent());
			pstmt.setString(3, r.getReviewFilename());
			pstmt.setString(4, r.getReviewFilepath());
			pstmt.setInt(5, r.getReviewNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertReviewComment(Connection conn, ReviewComment rc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into review_comment_tbl values(rcomment_seq.nextval,?,?,to_char(sysdate,'yyyy-mm-dd'),?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rc.getrCommentWriter());
			pstmt.setString(2, rc.getrCommentContent());
			pstmt.setInt(3, rc.getReviewRef());
			pstmt.setString(4, (rc.getrCommentRef() == 0) ? null : String.valueOf(rc.getrCommentRef()));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteReview(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from review_tbl where review_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteNoticeComment(Connection conn, int rCommentNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from review_comment_tbl where rComment_No = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rCommentNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateFreeBoardComment(Connection conn, ReviewComment rc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update review_comment_tbl set rComment_content= ? where rComment_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rc.getrCommentContent());
			pstmt.setInt(2, rc.getrCommentNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}

		return result;
	}

	public ArrayList<Review> searchReview(Connection conn, int searchCategory, String searchKeyWord, int start,
			int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> list = new ArrayList<>();
		if (searchCategory == 1) {
			try {
				pstmt = conn.prepareStatement(
						"select * from (select rownum as rnum, n.* from (select * from review_tbl where review_title like ? order by review_no desc)n) where rnum between ? and ?");
				pstmt.setString(1, "%" + searchKeyWord + "%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (searchCategory == 2) {
			try {
				pstmt = conn.prepareStatement(
						"select * from (select rownum as rnum, n.* from (select * from review_tbl where review_content like ? order by review_no desc)n) where rnum between ? and ?");
				pstmt.setString(1, "%" + searchKeyWord + "%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (searchCategory == 3) {
			try {
				pstmt = conn.prepareStatement(
						"select * from (select rownum as rnum, n.* from (select * from review_tbl where review_writer like ? order by review_no desc)n) where rnum between ? and ?");
				pstmt.setString(1, "%" + searchKeyWord + "%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Review r = new Review();
				r.setReviewFilename(rset.getString("Review_filename"));
				r.setReviewFilepath(rset.getString("Review_filepath"));
				r.setReviewContent(rset.getString("Review_content"));
				r.setReviewDate(rset.getString("Review_date"));
				r.setReviewNo(rset.getInt("Review_no"));
				r.setReviewReadCount(rset.getInt("Review_readcount"));
				r.setReviewTitle(rset.getString("Review_title"));
				r.setReviewWriter(rset.getString("Review_writer"));
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int selectReviewCount(Connection conn, int searchCategory, String searchKeyWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		if (searchCategory == 1) {
			try {
				pstmt = conn.prepareStatement(
						"select count(*) as cnt from review_tbl where review_title like ? order by review_no desc");
				pstmt.setString(1, "%" + searchKeyWord + "%");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (searchCategory == 2) {
			try {
				pstmt = conn.prepareStatement(
						"select count(*) as cnt from review_tbl where review_content like ? order by review_no desc");
				pstmt.setString(1, "%" + searchKeyWord + "%");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (searchCategory == 3) {
			try {
				pstmt = conn.prepareStatement(
						"select count(*) as cnt from review_tbl where review_writer like ? order by review_no desc");
				pstmt.setString(1, "%" + searchKeyWord + "%");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			rset = pstmt.executeQuery();
			if (rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return totalCount;
	}
}
