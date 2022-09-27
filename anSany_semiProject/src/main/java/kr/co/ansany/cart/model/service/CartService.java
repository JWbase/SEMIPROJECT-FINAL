package kr.co.ansany.cart.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import common.JDBCTemplate;
import kr.co.ansany.cart.model.dao.CartDao;
import kr.co.ansany.cart.model.vo.Cart;

public class CartService {
	private CartDao dao;

	public CartService() {
		super();
		dao = new CartDao();
	}

	public ArrayList<Cart> selectAllCart(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Cart> list = dao.selectAllCart(conn,memberId);
		JDBCTemplate.close(conn);
		return list;
	}

	public boolean deleteCartAll(String sCart) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result = true;
		//구분자[/]제거
		StringTokenizer sT = new StringTokenizer(sCart,"/"); 
		//cartNo갯수만큼 삭제, 삭제실패 시 반복문 종료
		while(sT.hasMoreTokens()) {
			int cartNo = Integer.parseInt(sT.nextToken());
			int daoResult = dao.deleteCart(conn, cartNo);
			if(daoResult == 0) {
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

	public boolean deleteCartOne(int cartNo) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result = true;
		int daoResult = dao.deleteCart(conn, cartNo);
		if(daoResult == 0) {
			result = false;
		}
		if(result) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public boolean updateCart(String sCartNo, String sCartCnt) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result = true;
		//구분자[/]제거
		StringTokenizer sT1 = new StringTokenizer(sCartNo,"/");
		StringTokenizer sT2 = new StringTokenizer(sCartCnt,"/");
		//cartNo갯수만큼 수정, 수정실패 시 반복문 종료
		while(sT1.hasMoreTokens()) {
			int cartNo = Integer.parseInt(sT1.nextToken());
			int cartCount = Integer.parseInt(sT2.nextToken());
			int daoResult = dao.updateCart(conn, cartNo, cartCount);
			if(daoResult == 0) {
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

	public ArrayList<Cart> selectUpdatedCart(int[] cartNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Cart> list = new ArrayList<Cart>();
		for(int i=0;i<cartNo.length;i++) {
			int cNo = cartNo[i];
			Cart one = dao.selectOneCart(conn, cNo);
			list.add(one);
		}
		JDBCTemplate.close(conn);
		return list;
	}
	
	public boolean insertOrder(String memberId, int[] productNo, int totalPrice, String orderName, String orderAddr,
			String orderPhone) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result = true;
		for(int i=0;i<productNo.length;i++) {
			int pNo = productNo[i];
			int daoResult = dao.insertOneOrder(conn, memberId, pNo, totalPrice, orderName, orderAddr, orderPhone);
			if(daoResult == 0) {
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

	public int insertCart(String memberId, int productNo, int productCount) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertCart(conn,productNo,memberId,productCount);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
