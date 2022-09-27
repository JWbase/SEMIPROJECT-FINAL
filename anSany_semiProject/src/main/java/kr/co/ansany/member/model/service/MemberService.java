package kr.co.ansany.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import common.JDBCTemplate;
import kr.co.ansany.member.model.dao.MemberDao;
import kr.co.ansany.member.model.vo.Member;
import kr.co.ansany.member.model.vo.MyPageOrderData;
import kr.co.ansany.member.model.vo.MyQnAData;
import kr.co.ansany.member.model.vo.MypageList;

public class MemberService {
	private MemberDao dao;

	public MemberService() {
		super();
		dao= new MemberDao();
	}
	//login
	public Member selectOneMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = dao.selectOneMember(conn,member);
		JDBCTemplate.close(conn);
		return m;
	}

	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertMember(conn,m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	//id를 통한 update
	public Member selectOneMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = dao.selectChkMember(conn, memberId);
		JDBCTemplate.close(conn);
		return m;
	}
	public int deleteMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.deleteMember(conn,memberId);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public int updateMemberInfo(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateMemberInfo(conn, member);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public MypageList myPageList(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<MyPageOrderData>list = dao.myPageList(conn,memberId);
		ArrayList<MyQnAData>qnalist = dao.myQnAList(conn,memberId);
		
		MypageList mpl = new MypageList(list, qnalist);
		
		JDBCTemplate.close(conn);
		return mpl;
	}
	public MyQnAData deleteQnA(int qnaNo) {
		Connection conn = JDBCTemplate.getConnection();
		MyQnAData mqd = dao.selectOneQnA(conn,qnaNo);
		int result = dao.deleteQna(conn,qnaNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
			
			mqd = null;
		}
		JDBCTemplate.close(conn);
		return mqd;
	}
	public ArrayList<Member> selectAllMember() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = dao.selectAllMember(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int changeLevel(int memberNo, int memberLevel) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changeLevel(conn, memberNo, memberLevel);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}		
		return result;
	}

	public ArrayList<Member> searchMember(String searchCate, String searchInput) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new ArrayList<Member>();
		if(searchCate.equals("memberNo")) {
			list = dao.searchMember1(conn,searchInput);			
		}else if(searchCate.equals("memberId")) {
			list = dao.searchMember2(conn,searchInput);
		}else if(searchCate.equals("memberName")) {
			list = dao.searchMember3(conn,searchInput);
		}		
		JDBCTemplate.close(conn);
		return list;
	}

	public boolean chkedChangeLevel(String num, String level) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		
		StringTokenizer sT1 = new StringTokenizer(num,"/");
		StringTokenizer sT2 = new StringTokenizer(level,"/");
		boolean result = true;
		while(sT1.hasMoreTokens()) {
			int memberNo = Integer.parseInt(sT1.nextToken());
			int memberLevel = Integer.parseInt(sT2.nextToken());
			int changeResult = dao.changeLevel(conn, memberNo, memberLevel);
			if(changeResult==0) {
				result = false;
				break;
			}
		}
		if(result) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	public int changePw(String memberId, String memberPw) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changePw(conn,memberId,memberPw);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public int changePhone(String memberId, String memberPhone) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changePhone(conn,memberId,memberPhone);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	
}
