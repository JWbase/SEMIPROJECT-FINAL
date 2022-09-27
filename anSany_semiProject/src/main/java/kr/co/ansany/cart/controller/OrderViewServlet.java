package kr.co.ansany.cart.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ansany.cart.model.service.CartService;
import kr.co.ansany.cart.model.vo.Cart;
import kr.co.ansany.member.model.vo.Member;

/**
 * Servlet implementation class OrderViewServlet
 */
@WebServlet(name = "OrderView", urlPatterns = { "/orderView.do" })
public class OrderViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2.값추출
		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("m");
		String[] cartNoArr = request.getParameterValues("cart-no");
		// 2-1.형변환 후 cartNo배열에 추가...
		int cartNo[] = new int[cartNoArr.length];
		for (int i = 0; i < cartNoArr.length; i++) {
			cartNo[i] = Integer.parseInt(cartNoArr[i]);
		}
		// 3.비즈니스로직
		CartService service = new CartService();
		ArrayList<Cart> orderList = service.selectUpdatedCart(cartNo);
		
		// 4.결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/cart/order.jsp");
		request.setAttribute("m", m);
		request.setAttribute("orderList", orderList);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
