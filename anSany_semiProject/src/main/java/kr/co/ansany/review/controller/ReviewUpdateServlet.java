package kr.co.ansany.review.controller;

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

import kr.co.ansany.review.model.service.ReviewService;
import kr.co.ansany.review.model.vo.Review;

/**
 * Servlet implementation class ReviewUpdateServlet
 */
@WebServlet(name = "ReviewUpdate", urlPatterns = { "/reviewUpdate.do" })
public class ReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/review";

		int maxSize = 10 * 1024 * 1024;

		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());
		
		int reviewNo = Integer.parseInt(mRequest.getParameter("reviewNo"));
		String reviewTitle = mRequest.getParameter("reviewTitle");
		String reviewContent = mRequest.getParameter("reviewContent");
		String status = mRequest.getParameter("status");
		String fileName = mRequest.getOriginalFileName("upfile");
		String filePath = mRequest.getFilesystemName("upfile");

		String oldFilename = mRequest.getParameter("oldFilename");
		String oldFilepath = mRequest.getParameter("oldFilepath");

		if (oldFilename != null && status.equals("stay")) {
			fileName = oldFilename;
			filePath = oldFilepath;
		}
		
		Review r = new Review();
		r.setReviewNo(reviewNo);
		r.setReviewTitle(reviewTitle);
		r.setReviewContent(reviewContent);
		r.setReviewFilename(fileName);
		r.setReviewFilepath(filePath);
		
		ReviewService service = new ReviewService();
		int result = service.updateReview(r);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if (result > 0) {
			request.setAttribute("title", "변경완료");
			request.setAttribute("msg", "게시글 수정완료");
			request.setAttribute("icon", "success");
			if (status.equals("delete")) {
				File delFile = new File(saveDirectory + "/" + oldFilepath);
				delFile.delete();
			}
		} else {
			request.setAttribute("title", "변경실패");
			request.setAttribute("msg", "다시 확인해주세요.");
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
