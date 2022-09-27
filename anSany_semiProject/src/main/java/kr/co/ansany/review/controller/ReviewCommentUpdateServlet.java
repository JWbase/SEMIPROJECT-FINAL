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
import kr.co.ansany.review.model.vo.ReviewComment;


/**
 * Servlet implementation class ReviewCommentUpdateServlet
 */
@WebServlet(name = "ReviewCommentUpdate", urlPatterns = { "/reviewCommentUpdate.do" })
public class ReviewCommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCommentUpdateServlet() {
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
		String rCommentContent = request.getParameter("rCommentContent");
		ReviewComment rc = new ReviewComment();
		rc.setrCommentNo(rCommentNo);
		rc.setrCommentContent(rCommentContent);
		
		ReviewService service = new ReviewService();
		int result = service.updateReviewComment(rc);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("title", "성공");
			request.setAttribute("msg", "댓글이 수정되었습니다.");
			request.setAttribute("icon", "success");
		} else {
			request.setAttribute("title", "실패");
			request.setAttribute("msg", "댓글 수정 실패");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/freeBoardView.do?reviewNo="+reviewNo);
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
