package kr.co.ansany.faqqna.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.co.ansany.faqqna.model.vo.Faqqna;
import kr.co.ansany.faqqna.model.vo.FaqqnaComment;

public class FaqqnaDao {

	public ArrayList<Faqqna> selectFaqqnaList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Faqqna> faqlist = new ArrayList<Faqqna>();
//		String query = "SELECT * FROM(SELECT ROWNUM AS RNUM, N.* FROM (SELECT * FROM QNA_TBL ORDER BY QNA_NO DESC)N) WHERE RNUM BETWEEN ? AND ?";
		String query = "SELECT * FROM(SELECT ROWNUM AS RNUM, N.* FROM (select qna_no, qna_title, qna_writer, qna_content, qna_readcount, qna_date, qna_filepath, qna_filename, qna_cate_no,\r\n"
				+ "(select count(*) from qna_comment where qna_ref = qna_no) as commentCheck\r\n"
				+ "from qna_tbl ORDER BY QNA_NO DESC)N) WHERE RNUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Faqqna faq = new Faqqna();
				faq.setQnaNo(rset.getInt("qna_no"));
				faq.setQnaTitle(rset.getString("qna_title"));
				faq.setQnaWriter(rset.getString("qna_writer"));
				faq.setQnaContent(rset.getString("qna_content"));
				faq.setQnaReadCount(rset.getInt("qna_readcount"));
				faq.setQnaDate(rset.getString("qna_date"));
				faq.setQnaFilepath(rset.getString("qna_filepath"));
				faq.setQnaFileName(rset.getString("qna_filename"));
				faq.setQnaCateNo(rset.getInt("qna_cate_no"));
				faq.setQnaStatus(rset.getInt("commentCheck"));
				faqlist.add(faq);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return faqlist;
	}

	public int selectQnaCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from qna_tbl";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
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

	public int insertQna(Connection conn, Faqqna faq) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into qna_tbl values(qna_seq.nextval,?,?,?,0,to_char(sysdate,'yyyy-mm-dd'),?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, faq.getQnaTitle());
			pstmt.setString(2, faq.getQnaWriter());
			pstmt.setString(3, faq.getQnaContent());
			pstmt.setString(4, faq.getQnaFilepath());
			pstmt.setString(5, faq.getQnaFileName());
			pstmt.setInt(6, faq.getQnaCateNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Faqqna selectOneQna(Connection conn, int qnaNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Faqqna faq = null;
		String query = "select * from qna_tbl where qna_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				faq = new Faqqna();
				faq.setQnaFileName(rset.getString("Qna_filename"));
				faq.setQnaFilepath(rset.getString("Qna_filepath"));
				faq.setQnaContent(rset.getString("Qna_content"));
				faq.setQnaNo(rset.getInt("Qna_no"));
				faq.setQnaTitle(rset.getString("Qna_title"));
				faq.setQnaWriter(rset.getString("Qna_writer"));
				faq.setQnaReadCount(rset.getInt("Qna_readcount"));
				faq.setQnaDate(rset.getString("Qna_date"));
				faq.setQnaCateNo(rset.getInt("Qna_cate_no"));
//				faq.setQnaStatus(rset.getInt("Qna_status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return faq;
	}

	public int updateQnaReadCount(Connection conn, int qnaNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update qna_tbl set qna_readcount = qna_readcount+1 where qna_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteQna(Connection conn, int qnaNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from qna_tbl where qna_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateQna(Connection conn, Faqqna faq) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update qna_tbl set qna_title=?, qna_content=?, qna_filepath=?, qna_filename=?, qna_cate_no=? where qna_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, faq.getQnaTitle());
			pstmt.setString(2, faq.getQnaContent());
			pstmt.setString(3, faq.getQnaFilepath());
			pstmt.setString(4, faq.getQnaFileName());
			pstmt.setInt(5, faq.getQnaCateNo());
			pstmt.setInt(6, faq.getQnaNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertQnaComment(Connection conn, FaqqnaComment fc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into qna_comment values(qcommentseq.nextval,?,?,to_char(sysdate,'yyyy-mm-dd'),?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fc.getQcWriter());
			pstmt.setString(2, fc.getQcContent());
			pstmt.setInt(3, fc.getQnaRef());
			
			pstmt.setString(4, (fc.getQcRef()==0)?null:String.valueOf(fc.getQcRef()));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<FaqqnaComment> selectFaqCommentList(Connection conn, int qnaNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FaqqnaComment> list = new ArrayList<FaqqnaComment>();
		String query = "select * from qna_comment where qna_ref=? and qc_ref is null order by 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				FaqqnaComment fc = new FaqqnaComment();
				fc.setQcContent(rset.getString("qcomment_content"));
				fc.setQcDate(rset.getString("qcomment_date"));
				fc.setQcNo(rset.getInt("qcomment_no"));
				fc.setQcRef(rset.getInt("qc_ref"));
				fc.setQcWriter(rset.getString("qcomment_writer"));
				fc.setQnaRef(rset.getInt("qna_ref"));
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

	public FaqqnaComment selectFaqComment(Connection conn, int qnaNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		FaqqnaComment fc = null;
		String query = "select * from qna_comment where qna_ref=? and qc_ref is null order by 1";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				fc = new FaqqnaComment();
				fc.setQcNo(rset.getInt("qcomment_no"));
				fc.setQcWriter(rset.getString("qcomment_writer"));
				fc.setQcContent(rset.getString("qcomment_content"));
				fc.setQcDate(rset.getString("qcomment_date"));
				fc.setQnaRef(rset.getInt("qna_ref"));
				fc.setQcRef(rset.getInt("qc_ref"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return fc;
	}

	public int updateQnaComment(Connection conn, FaqqnaComment fc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update qna_comment set qcomment_content=? where qcomment_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fc.getQcContent());
			pstmt.setInt(2, fc.getQcNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteQnaComm(Connection conn, int fcNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from qna_comment where qcomment_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fcNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
