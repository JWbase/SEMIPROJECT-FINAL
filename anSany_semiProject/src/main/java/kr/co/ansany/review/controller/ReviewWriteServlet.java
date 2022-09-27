package kr.co.ansany.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.ansany.review.model.service.ReviewService;
import kr.co.ansany.review.model.vo.Review;

/**
 * Servlet implementation class ReviewWriteServlet
 */
@WebServlet(name = "ReviewWrite", urlPatterns = { "/reviewWrite.do" })
public class ReviewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewWriteServlet() {
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
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/review";
		int maxSize = 10 * 1024 * 1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		String reviewTitle = mRequest.getParameter("reviewTitle");
		String reviewWriter = mRequest.getParameter("reviewWriter");
		String reviewContent = mRequest.getParameter("reviewContent");
		String reviewFilename = mRequest.getOriginalFileName("upfile");
		String reviewFilepath = mRequest.getFilesystemName("upfile");

		Review r = new Review();
		r.setReviewTitle(reviewTitle);
		r.setReviewWriter(reviewWriter);
		r.setReviewContent(reviewContent);
		r.setReviewFilename(reviewFilename);
		r.setReviewFilepath(reviewFilepath);

		ReviewService service = new ReviewService();
		int result = service.insertReview(r);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if (result > 0) {
			request.setAttribute("title", "성공");
			request.setAttribute("msg", "게시글이 등록 되었습니다.");
			request.setAttribute("icon", "success");
		} else {
			request.setAttribute("title", "실패");
			request.setAttribute("msg", "등록에 실패했습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/reviewList.do?reqPage=1");
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
