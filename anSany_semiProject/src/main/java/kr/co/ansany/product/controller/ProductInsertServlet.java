package kr.co.ansany.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.ansany.product.model.service.ProductService;
import kr.co.ansany.product.model.vo.Product;

/**
 * Servlet implementation class ProductInsertServlet
 */
@WebServlet(name = "ProductInsert", urlPatterns = { "/productInsert.do" })
public class ProductInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String rout = getServletContext().getRealPath("/"); 
		String saveDirectory = rout+"upload/prodImg";
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		int cateCode = Integer.parseInt(mRequest.getParameter("cateCode"));
		String productName = mRequest.getParameter("productName");
		int productPrice = Integer.parseInt(mRequest.getParameter("productPrice"));
		int productQty = Integer.parseInt(mRequest.getParameter("productQty"));
		String productImg = mRequest.getFilesystemName("imageFile");
		String productInfo = mRequest.getParameter("productInfo");
		Product p = new Product();
		ProductService service = new ProductService();
		p.setCateCode(cateCode);
		p.setProductImg(productImg);
		p.setProductInfo(productInfo);
		p.setProductName(productName);
		p.setProductPrice(productPrice);
		p.setProductQty(productQty);
		int result = service.insertProduct(p);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "등록완료");
			request.setAttribute("msg", "등록이 완료되었습니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "등록 실패");
			request.setAttribute("msg", "등록에 실패했습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/productInsertFrm.do");
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
