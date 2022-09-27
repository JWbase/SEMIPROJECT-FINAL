package kr.co.ansany.freeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.freeboard.model.service.FreeBoardService;
import kr.co.ansany.freeboard.model.vo.FreeBoardComment;

/**
 * Servlet implementation class InsertFcommentServlet
 */
@WebServlet(name = "InsertFcomment", urlPatterns = { "/insertFcomment.do" })
public class InsertFcommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFcommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		FreeBoardComment fc = new FreeBoardComment();
		fc.setfCommentWriter(request.getParameter("fCommentWriter"));
		fc.setFreeBoardRef(Integer.parseInt(request.getParameter("freeBoardRef")));
		fc.setfCommentRef(Integer.parseInt(request.getParameter("fCommentRef")));
		fc.setfCommentContent(request.getParameter("fCommentContent"));
		
		FreeBoardService service = new FreeBoardService();
		int result = service.insertFreeBoardComment(fc);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if (result > 0) {
			request.setAttribute("title", "성공");
			request.setAttribute("msg", "댓글 작성 완료");
			request.setAttribute("icon", "success");
		} else {
			request.setAttribute("title", "실패");
			request.setAttribute("msg", "댓글 작성 실패");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/freeBoardView.do?freeBoardNo=" + fc.getFreeBoardRef());
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
