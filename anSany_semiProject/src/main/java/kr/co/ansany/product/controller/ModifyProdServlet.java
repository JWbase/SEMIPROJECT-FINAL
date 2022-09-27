package kr.co.ansany.product.controller;

import java.io.File;
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
 * Servlet implementation class ModifyProdServlet
 */
@WebServlet(name = "ModifyProd", urlPatterns = { "/modifyProd.do" })
public class ModifyProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyProdServlet() {
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
		
		int productNo = Integer.parseInt(mRequest.getParameter("productNo"));
		int cateCode = Integer.parseInt(mRequest.getParameter("cateCode"));
		String productName = mRequest.getParameter("productName");
		int productPrice = Integer.parseInt(mRequest.getParameter("productPrice"));
		int productQty = Integer.parseInt(mRequest.getParameter("productQty"));
		String productInfo = mRequest.getParameter("productInfo");
		
		String status = mRequest.getParameter("status");
		String productImg = mRequest.getFilesystemName("upFile");
		String oldImg = mRequest.getParameter("oldProdImg");
		if(status.equals("stay")) {
			productImg = oldImg;
		}
		Product p = new Product(productNo, cateCode, productName, productPrice, productQty, productImg, productInfo);
		ProductService service = new ProductService();
		int result = service.modifyProd(p);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "수정 완료");
			request.setAttribute("msg", "상품수정이 수정되었습니다");
			request.setAttribute("icon", "success");
//			if(status.equals("delete")) {
//				File delFile = new File(saveDirectory+"/"+productImg);
//				delFile.delete();
//			}
		}else {
			request.setAttribute("title", "수정 실패");
			request.setAttribute("msg", "상품 수정에 실패했습니다.");
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
