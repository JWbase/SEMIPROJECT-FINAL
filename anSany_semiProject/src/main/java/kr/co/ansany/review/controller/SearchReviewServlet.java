package kr.co.ansany.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.review.model.service.ReviewService;
import kr.co.ansany.review.model.vo.ReviewPageData;

/**
 * Servlet implementation class SearchReviewServlet
 */
@WebServlet(name = "SearchReview", urlPatterns = { "/searchReview.do" })
public class SearchReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchReviewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		int searchCategory = Integer.parseInt(request.getParameter("searchCategory"));
		String searchKeyWord = request.getParameter("searchKeyWord");

		ReviewService service = new ReviewService();
		ReviewPageData rpd = service.searchReview(searchCategory, searchKeyWord, reqPage);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/review/reviewList.jsp");
		request.setAttribute("list", rpd.getList());
		request.setAttribute("pageNavi", rpd.getPageNavi());
		request.setAttribute("searchCategory", searchCategory);
		request.setAttribute("searchKeyWord", searchKeyWord);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
