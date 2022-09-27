package kr.co.ansany.order.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.order.model.service.OrderService;

/**
 * Servlet implementation class UpdateOrderStatusServlet
 */
@WebServlet(name = "UpdateOrderStatus", urlPatterns = { "/updateOrderStatus.do" })
public class UpdateOrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String orderNo = request.getParameter("orderNo");
		String status = request.getParameter("status");
		OrderService service = new OrderService();
		int result = service.updateOrderStatus(orderNo, status);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "변경 성공");
			request.setAttribute("msg", "배송상태 변경에 성공했습니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "변경 실패");
			request.setAttribute("msg", "배송상태 변경 중 문제가 생겼습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/orderList.do");
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
