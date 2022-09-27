package kr.co.ansany.review.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.review.model.service.ReviewService;
import kr.co.ansany.review.model.vo.Review;

/**
 * Servlet implementation class ReviewDeleteServlet
 */
@WebServlet(name = "ReviewDelete", urlPatterns = { "/reviewDelete.do" })
public class ReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		ReviewService service = new ReviewService();
		Review r = service.deleteReview(reviewNo);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if (r != null) {
			
			if (r.getReviewFilepath() != null) {
				String root = getServletContext().getRealPath("/");
				String deleteFile = root + "upload/review/" + r.getReviewFilepath();
				File delFile = new File(deleteFile);
				delFile.delete();
			}
			request.setAttribute("title", "삭제완료");
			request.setAttribute("msg", "삭제가 완료되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/reviewList.do?reqPage=1");
		} else {
			request.setAttribute("title", "삭제실패");
			request.setAttribute("msg", "관리자에게 문의하세요.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/reviewView.do?reviewNo=" + reviewNo);
		}
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
