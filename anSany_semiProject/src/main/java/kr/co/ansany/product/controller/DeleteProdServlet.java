package kr.co.ansany.product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.product.model.service.ProductService;
import kr.co.ansany.product.model.vo.Product;

/**
 * Servlet implementation class DeleteProdServlet
 */
@WebServlet(name = "DeleteProd", urlPatterns = { "/deleteProd.do" })
public class DeleteProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		
		ProductService service = new ProductService();
		Product p = service.deleteProd(prodNo);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(p!=null) {
			if(p.getProductImg()!=null) {
				String rout = getServletContext().getRealPath("/");
				String deleteFile = rout+"upload/prodImg"+p.getProductImg();
				File delFile = new File(deleteFile);
				delFile.delete();
			}
			request.setAttribute("title", "삭제 완료");
			request.setAttribute("msg", "제품 삭제가 완료되었습니다");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "삭제 실패");
			request.setAttribute("msg", "제품 삭제에 실패했습니다");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/prodList.do?reqPage=1");
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
