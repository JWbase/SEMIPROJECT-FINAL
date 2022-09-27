package kr.co.ansany.freeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.freeboard.model.service.FreeBoardService;

/**
 * Servlet implementation class DeleteFreeBoardCommentServlet
 */
@WebServlet(name = "DeleteFreeBoardComment", urlPatterns = { "/deleteFreeBoardComment.do" })
public class DeleteFreeBoardCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFreeBoardCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int fCommentNo = Integer.parseInt(request.getParameter("fCommentNo"));
		int freeBoardNo = Integer.parseInt(request.getParameter("freeBoardNo"));
		
		FreeBoardService service = new FreeBoardService();
		int result = service.deleteFreeBoardComment(fCommentNo);
		
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
		request.setAttribute("loc", "/freeBoardView.do?freeBoardNo=" + freeBoardNo);
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
