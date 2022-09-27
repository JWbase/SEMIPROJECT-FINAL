package kr.co.ansany.review.controller;

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
 * Servlet implementation class ReviewUpdateFrmServlet
 */
@WebServlet(name = "ReviewUpdateFrm", urlPatterns = { "/reviewUpdateFrm.do" })
public class ReviewUpdateFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateFrmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		ReviewService service = new ReviewService();
		Review r = service.getReview(reviewNo);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/review/updateReviewFrm.jsp");
		request.setAttribute("r", r);
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
