package kr.co.ansany.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ansany.cart.model.service.CartService;
import kr.co.ansany.member.model.vo.Member;

/**
 * Servlet implementation class CartInsertServlet
 */
@WebServlet(name = "CartInsert", urlPatterns = { "/cartInsert.do" })
public class CartInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("utf-8");
		// 값추출
		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("m");
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		int productCount = Integer.parseInt(request.getParameter("productCount"));
		// 비즈니스로직
		// 결과처리: 로그인했을때만 장바구니 담고, 로그인안하면 로그인창 띄우기
		if(m != null) {
			String memberId = m.getMemberId();
			CartService service = new CartService();
			int result = service.insertCart(memberId,productNo, productCount);
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(result);
		}else {
			String result = "로그인이 필요합니다.";
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(result);
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
