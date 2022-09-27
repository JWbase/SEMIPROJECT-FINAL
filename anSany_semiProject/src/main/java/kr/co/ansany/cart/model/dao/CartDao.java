package kr.co.ansany.cart.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.co.ansany.cart.model.vo.Cart;

public class CartDao {

	public ArrayList<Cart> selectAllCart(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Cart> list = new ArrayList<Cart>();
		String query = "select cart_no, product_img, product_name, product_price, order_qty from cart_tbl join product_tbl using(product_no) where member_id=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Cart c = new Cart();
				c.setCartNo(rset.getInt("cart_no"));
				c.setProductImg(rset.getString("product_img"));
				c.setProductName(rset.getString("product_name"));
				c.setProductPrice(rset.getInt("product_price"));
				c.setOrderQty(rset.getInt("order_qty"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int deleteCart(Connection conn, int cartNo) {
		PreparedStatement pstmt = null;
		int daoResult = 0;
		String query = "delete cart_tbl where cart_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cartNo);
			daoResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return daoResult;
	}

	public int updateCart(Connection conn, int cartNo, int cartCount) {
		PreparedStatement pstmt = null;
		int daoResult = 0;
		String query = "update cart_tbl set order_qty=? where cart_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cartCount);
			pstmt.setInt(2, cartNo);
			daoResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return daoResult;
	}

	public Cart selectOneCart(Connection conn, int cNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Cart one = null;
		String query = "select cart_no, product_no, product_img, product_name, product_price, order_qty from cart_tbl join product_tbl using(product_no) where cart_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				one = new Cart();
				one.setCartNo(rset.getInt("cart_no"));
				one.setProductNo(rset.getInt("product_no"));
				one.setProductImg(rset.getString("product_img"));
				one.setProductName(rset.getString("product_name"));
				one.setProductPrice(rset.getInt("product_price"));
				one.setOrderQty(rset.getInt("order_qty"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return one;
	}

	public int insertOneOrder(Connection conn, String memberId, int pNo, int totalPrice, String orderName, String orderAddr,
			String orderPhone) {
		PreparedStatement pstmt = null;
		int daoResult = 0;
		String query = "insert into order_tbl values(order_seq.nextval,?,?,?,?,?,?,sysdate,1)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setInt(2, pNo);
			pstmt.setInt(3, totalPrice);
			pstmt.setString(4, orderName);
			pstmt.setString(5, orderAddr);
			pstmt.setString(6, orderPhone);
			daoResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return daoResult;
	}

	public int insertCart(Connection conn, int productNo, String memberId, int productCount) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into cart_tbl values(cart_seq.nextval,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productNo);
			pstmt.setString(2, memberId);
			pstmt.setInt(3, productCount);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
