package kr.co.ansany.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.review.model.service.ReviewService;


/**
 * Servlet implementation class DeleteReviewCommentServlet
 */
@WebServlet(name = "DeleteReviewComment", urlPatterns = { "/deleteReviewComment.do" })
public class DeleteReviewCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReviewCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int rCommentNo = Integer.parseInt(request.getParameter("rCommentNo"));
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		ReviewService service = new ReviewService();
		int result = service.deleteReviewComment(rCommentNo);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if (result > 0) {
			request.setAttribute("title", "삭제 성공");
			request.setAttribute("msg", "삭제가 완료되었습니다.");
			request.setAttribute("icon", "success");
		} else {
			request.setAttribute("title", "삭제 실패");
			request.setAttribute("msg", "삭제에 실패했습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/reviewView.do?reviewNo=" + reviewNo);
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
