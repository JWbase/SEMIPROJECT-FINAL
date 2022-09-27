package kr.co.ansany.faqqna.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.co.ansany.faqqna.model.dao.FaqqnaDao;
import kr.co.ansany.faqqna.model.vo.Faqqna;
import kr.co.ansany.faqqna.model.vo.FaqqnaComment;
import kr.co.ansany.faqqna.model.vo.FaqqnaPageData;
import kr.co.ansany.faqqna.model.vo.FaqqnaViewData;

public class FaqqnaService {
	private FaqqnaDao dao;

	public FaqqnaService() {
		super();
		dao = new FaqqnaDao();
	}

	public FaqqnaPageData selectFaqqnaList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		//한페이지 당 게시물 수
		int numPerPage = 10;
		
		int end = numPerPage*reqPage;
		int start = end-numPerPage+1;
		
		ArrayList<Faqqna> faqlist = dao.selectFaqqnaList(conn,start,end);
		
		
		//페이징 처리
		int totalCount = dao.selectQnaCount(conn);
		//전체페이지
		int totalPage = 0;
		if(totalCount%numPerPage ==0) {
			totalPage = totalCount/numPerPage;
		} else {
			totalPage = totalCount/numPerPage+1;
		}
		//페이지 네비게이션 사이즈
		int pageNaviSize = 5;
		
		//페이지 네비게이션 시작번호
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		
		//페이지 네비게이션 제작 시작
		String pageNavi = "<nav aria-label='Page navigation example'>";
        pageNavi += "<ul class='pagination'>";
        if (pageNo != 1) {
            pageNavi += "<li class='page-item'><a class='page-link' href='/faqqnaList.do?reqPage=" + (pageNo - 1) + "&type=qna'>Previous</a></li>";
        }

        for (int i = 0; i < pageNaviSize; i++) {
            if (pageNo == reqPage) {
                pageNavi += "<li class='page-item active' aria-current='page'><a class='page-link' href='/faqqnaList.do?reqPage="+ pageNo + "&type=qna'>";
		pageNavi += pageNo + "</a></li>";
            } else {
                pageNavi += "<li class='page-item'><a class='page-link' href='/faqqnaList.do?reqPage=" + pageNo + "&type=qna'>";
		pageNavi += pageNo + "</a></li>";
            }
            pageNo++;
            if (pageNo > totalPage) {
                break;
            }
        }

        if (pageNo <= totalPage) {
            pageNavi += "<li class='page-item'><a class='page-link' href='/faqqnaList.do?reqPage="+pageNo+"&type=qna'>Next</a></li>";
        }
        pageNavi += "</ul>";
        pageNavi += "</nav>";
        FaqqnaPageData fpd = new FaqqnaPageData(faqlist, pageNavi);
        JDBCTemplate.close(conn);

        return fpd;
	}

	public int insertQna(Faqqna faq) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertQna(conn, faq);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public FaqqnaViewData selectOneQna(int qnaNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateQnaReadCount(conn, qnaNo);
		if(result > 0) {
			Faqqna faq = dao.selectOneQna(conn, qnaNo);
			//공지사항 상세내용 조회 후에 해당 공지사항에 작성된 댓글도 모두 조회
			//1. 일반댓글 조회
			FaqqnaComment fc = dao.selectFaqComment(conn, qnaNo);
//			ArrayList<FaqqnaComment> faqCommentList = dao.selectFaqCommentList(conn,qnaNo);
			FaqqnaViewData fvd = new FaqqnaViewData(faq, fc);
			JDBCTemplate.commit(conn);
			JDBCTemplate.close(conn);
			return fvd;
		} else {
			JDBCTemplate.rollback(conn);
			JDBCTemplate.close(conn);
			return null;
		}
	}

	public Faqqna getFaqqna(int qnaNo) {
		Connection conn = JDBCTemplate.getConnection();
		Faqqna faq = dao.selectOneQna(conn, qnaNo);
		JDBCTemplate.close(conn);
		return faq;
	}

	public Faqqna deleteQna(int qnaNo) {
		Connection conn = JDBCTemplate.getConnection();
		//조회
		Faqqna faq = dao.selectOneQna(conn, qnaNo);
		int result = dao.deleteQna(conn, qnaNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
			faq = null;
		}
		JDBCTemplate.close(conn);
		return faq;
	}

	public int updateQna(Faqqna faq) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateQna(conn, faq);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertQnaComment(FaqqnaComment fc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertQnaComment(conn, fc);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateQnaComment(FaqqnaComment fc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateQnaComment(conn, fc);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteQnaComm(int fcNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.deleteQnaComm(conn, fcNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
