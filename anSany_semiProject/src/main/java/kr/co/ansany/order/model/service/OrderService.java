package kr.co.ansany.order.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import common.JDBCTemplate;
import kr.co.ansany.order.model.dao.OrderDao;
import kr.co.ansany.order.model.vo.Order;

public class OrderService {
	OrderDao dao = new OrderDao();

	public OrderService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Order> selectAllOrders() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Order> list = dao.selectAllOrders(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int updateOrderStatus(String orderNo, String status) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateOrderStatus(conn, orderNo, status);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public boolean updateChkedOrderStatus(String num, String ship) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		StringTokenizer sT1 = new StringTokenizer(num,"/");
		StringTokenizer sT2 = new StringTokenizer(ship,"/");
		boolean result = true;
		while(sT1.hasMoreTokens()) {
	
			String orderNo = sT1.nextToken();
			String status = sT2.nextToken();
			int updateResult = dao.updateOrderStatus(conn, orderNo, status);
			if(updateResult==0) {
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
	
}
