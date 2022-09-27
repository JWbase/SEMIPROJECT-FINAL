package kr.co.ansany.faqqna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.faqqna.model.service.FaqqnaService;
import kr.co.ansany.faqqna.model.vo.FaqqnaComment;

/**
 * Servlet implementation class QnaCommDeleteServlet
 */
@WebServlet(name = "QnaCommDelete", urlPatterns = { "/qnaCommDelete.do" })
public class QnaCommDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaCommDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("utf-8");
		//값추출
		int fcNo = Integer.parseInt(request.getParameter("fcNo"));
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		//비즈니스로직
		FaqqnaService service = new FaqqnaService();
		int result = service.deleteQnaComm(fcNo);
		//결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("title", "삭제성공");
			request.setAttribute("msg", "삭제를 완료하였습니다.");
			request.setAttribute("icon", "success");
		} else {
			request.setAttribute("title", "삭제실패");
			request.setAttribute("msg", "삭제중 오류가 발생하였습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/faqqnaView.do?qnaNo="+qnaNo);
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
