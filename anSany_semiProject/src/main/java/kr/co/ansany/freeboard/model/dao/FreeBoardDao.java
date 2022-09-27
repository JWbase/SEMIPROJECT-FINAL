package kr.co.ansany.freeboard.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.co.ansany.freeboard.model.vo.FreeBoard;
import kr.co.ansany.freeboard.model.vo.FreeBoardComment;
import kr.co.ansany.notice.model.vo.Notice;
import kr.co.ansany.photo.model.vo.PhotoComment;

public class FreeBoardDao {

	public ArrayList<FreeBoard> selectFreeBoardList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FreeBoard> list = new ArrayList<FreeBoard>();
		String query = "select * from (select rownum as rnum, n.* from (select * from freeboard_tbl order by freeboard_no desc)n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				FreeBoard f = new FreeBoard();
				f.setFreeBoardNo(rset.getInt("FreeBoard_No"));
				f.setFreeBoardTitle(rset.getString("FreeBoard_title"));
				f.setFreeBoardWriter(rset.getString("FreeBoard_writer"));
				f.setFreeBoardContent(rset.getString("FreeBoard_content"));
				f.setFreeBoardReadCount(rset.getInt("FreeBoard_readcount"));
				f.setFreeBoardDate(rset.getString("FreeBoard_date"));
				f.setFreeBoardFilename(rset.getString("FreeBoard_filename"));
				f.setFreeBoardFilepath(rset.getString("FreeBoard_filepath"));
				list.add(f);
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

	public int selectFreeBoardCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from freeboard_tbl";
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

	public int insertFreeBoard(Connection conn, FreeBoard p) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into freeboard_tbl values(freeboard_seq.nextval,?,?,?,0,to_char(sysdate, 'yyyy-mm-dd'),?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getFreeBoardTitle());
			pstmt.setString(2, p.getFreeBoardWriter());
			pstmt.setString(3, p.getFreeBoardContent());
			pstmt.setString(4, p.getFreeBoardFilename());
			pstmt.setString(5, p.getFreeBoardFilepath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public FreeBoard selectOneFreeBoard(Connection conn, int freeBoardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		FreeBoard f = null;
		String query = "select * from freeBoard_tbl where freeBoard_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeBoardNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				f = new FreeBoard();
				f.setFreeBoardFilename(rset.getString("FreeBoard_filename"));
				f.setFreeBoardFilepath(rset.getString("FreeBoard_filepath"));
				f.setFreeBoardContent(rset.getString("FreeBoard_content"));
				f.setFreeBoardDate(rset.getString("FreeBoard_date"));
				f.setFreeBoardNo(rset.getInt("FreeBoard_no"));
				f.setFreeBoardReadCount(rset.getInt("FreeBoard_readcount"));
				f.setFreeBoardTitle(rset.getString("FreeBoard_title"));
				f.setFreeBoardWriter(rset.getString("FreeBoard_writer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return f;
	}

	public int updateReadCount(Connection conn, int freeBoardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update freeBoard_tbl set freeBoard_readcount = freeBoard_readcount + 1 where freeBoard_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeBoardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteFreeBoard(Connection conn, int freeBoardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from freeboard_tbl where freeboard_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeBoardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateFreeBoard(Connection conn, FreeBoard f) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update freeboard_tbl set freeboard_title=?, freeboard_content=?, freeboard_filename=?, freeboard_filepath=? where freeboard_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, f.getFreeBoardTitle());
			pstmt.setString(2, f.getFreeBoardContent());
			pstmt.setString(3, f.getFreeBoardFilename());
			pstmt.setString(4, f.getFreeBoardFilepath());
			pstmt.setInt(5, f.getFreeBoardNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertFreeBoardComment(Connection conn, FreeBoardComment fc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into freeboard_comment_tbl values(fcomment_seq.nextval,?,?,to_char(sysdate,'yyyy-mm-dd'),?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fc.getfCommentWriter());
			pstmt.setString(2, fc.getfCommentContent());
			pstmt.setInt(3, fc.getFreeBoardRef());
			pstmt.setString(4, (fc.getfCommentRef() == 0) ? null : String.valueOf(fc.getfCommentRef()));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteNoticeComment(Connection conn, int fCommentNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from freeboard_comment_tbl where fComment_No = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fCommentNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateFreeBoardComment(Connection conn, FreeBoardComment fc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update freeboard_comment_tbl set fComment_content= ? where fComment_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fc.getfCommentContent());
			pstmt.setInt(2, fc.getfCommentNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}

		return result;
	}

	public ArrayList<FreeBoardComment> selectFreeBoardCommentList(Connection conn, int freeBoardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FreeBoardComment> list = new ArrayList<FreeBoardComment>();
		String query = "select * from freeboard_comment_tbl where freeboard_ref = ? and fcomment_ref is null order by 1";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeBoardNo);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				FreeBoardComment fc = new FreeBoardComment();
				fc.setfCommentContent(rset.getString("fcomment_content"));
				fc.setfCommentDate(rset.getString("fcomment_date"));
				fc.setfCommentNo(rset.getInt("fcomment_no"));
				fc.setfCommentRef(rset.getInt("fcomment_ref"));
				fc.setfCommentWriter(rset.getString("fcomment_writer"));
				fc.setFreeBoardRef(rset.getInt("freeboard_ref"));
				list.add(fc);
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

	public ArrayList<FreeBoardComment> selectFreeBoardReCommentList(Connection conn, int freeBoardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FreeBoardComment> list = new ArrayList<FreeBoardComment>();
		String query = "select * from freeboard_comment_tbl where freeboard_ref = ? and fcomment_ref is not null order by 1";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeBoardNo);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				FreeBoardComment fc = new FreeBoardComment();
				fc.setfCommentContent(rset.getString("fcomment_content"));
				fc.setfCommentDate(rset.getString("fcomment_date"));
				fc.setfCommentNo(rset.getInt("fcomment_no"));
				fc.setfCommentRef(rset.getInt("fcomment_ref"));
				fc.setfCommentWriter(rset.getString("fcomment_writer"));
				fc.setFreeBoardRef(rset.getInt("freeboard_ref"));
				list.add(fc);
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

	public ArrayList<FreeBoard> searchFreeBoard(Connection conn, int searchCategory, String searchKeyWord, int start,
			int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FreeBoard> list = new ArrayList<>();
		if (searchCategory == 1) {
			try {
				pstmt = conn.prepareStatement(
						"select * from (select rownum as rnum, n.* from (select * from freeboard_tbl where freeboard_title like ? order by freeboard_no desc)n) where rnum between ? and ?");
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
						"select * from (select rownum as rnum, n.* from (select * from freeboard_tbl where freeboard_content like ? order by freeboard_no desc)n) where rnum between ? and ?");
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
						"select * from (select rownum as rnum, n.* from (select * from freeboard_tbl where freeboard_writer like ? order by freeboard_no desc)n) where rnum between ? and ?");
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
				FreeBoard f = new FreeBoard();
				f.setFreeBoardFilename(rset.getString("FreeBoard_filename"));
				f.setFreeBoardFilepath(rset.getString("FreeBoard_filepath"));
				f.setFreeBoardContent(rset.getString("FreeBoard_content"));
				f.setFreeBoardDate(rset.getString("FreeBoard_date"));
				f.setFreeBoardNo(rset.getInt("FreeBoard_no"));
				f.setFreeBoardReadCount(rset.getInt("FreeBoard_readcount"));
				f.setFreeBoardTitle(rset.getString("FreeBoard_title"));
				f.setFreeBoardWriter(rset.getString("FreeBoard_writer"));
				list.add(f);
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

	public int selectFreeBoardCount(Connection conn, int searchCategory, String searchKeyWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		if (searchCategory == 1) {
			try {
				pstmt = conn.prepareStatement(
						"select count(*) as cnt from freeboard_tbl where freeboard_title like ? order by freeboard_no desc");
				pstmt.setString(1, "%" + searchKeyWord + "%");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (searchCategory == 2) {
			try {
				pstmt = conn.prepareStatement(
						"select count(*) as cnt from freeboard_tbl where freeboard_content like ? order by freeboard_no desc");
				pstmt.setString(1, "%" + searchKeyWord + "%");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (searchCategory == 3) {
			try {
				pstmt = conn.prepareStatement(
						"select count(*) as cnt from freeboard_tbl where freeboard_writer like ? order by freeboard_no desc");
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