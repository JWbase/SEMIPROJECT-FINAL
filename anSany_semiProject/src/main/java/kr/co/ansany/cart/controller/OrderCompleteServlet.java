package kr.co.ansany.cart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.cart.model.service.CartService;

/**
 * Servlet implementation class OrderCompleteServlet
 */
@WebServlet(name = "OrderComplete", urlPatterns = { "/orderComplete.do" })
public class OrderCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		
		//2.값추출
		String memberId = request.getParameter("member-id");
		//2-1.제품번호 int배열로 처리
		String [] productNoArr = request.getParameterValues("product-no");
		int productNo[] = new int[productNoArr.length];
		for (int i=0; i<productNoArr.length; i++) {
			productNo[i] = Integer.parseInt(productNoArr[i]);
	    }
		int totalPrice = Integer.parseInt(request.getParameter("total-price"));
		String orderName = request.getParameter("orderer-name");
		String [] addressArr = request.getParameterValues("delivery-address");
		String orderAddr = String.join(" ",addressArr);
		System.out.println(orderAddr);
		String orderPhone = request.getParameter("orderer-phone");
		
		//3.비즈니스로직
		CartService service = new CartService();
		boolean result = service.insertOrder(memberId,productNo,totalPrice,orderName,orderAddr,orderPhone);
		
		//4.결과처리
		if(result) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/cart/orderComplete.jsp");
			view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/cart/msg.jsp");
			request.setAttribute("title", "결제 실패");
			request.setAttribute("msg", "결제에 실패했습니다.");
			request.setAttribute("loc", "/order.do");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
