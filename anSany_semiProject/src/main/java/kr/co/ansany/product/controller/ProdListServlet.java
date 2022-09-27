package kr.co.ansany.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.product.model.service.ProductService;
import kr.co.ansany.product.model.vo.Product;
import kr.co.ansany.product.model.vo.ProductPage;

/**
 * Servlet implementation class ProdListServlet
 */
@WebServlet(name = "ProdList", urlPatterns = { "/prodList.do" })
public class ProdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		ProductService service = new ProductService();
		ProductPage prodP = service.selectAllProduct(reqPage);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/prodList.jsp");
		request.setAttribute("list", prodP.getList());
		request.setAttribute("pageNavi", prodP.getPageNavi());
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
