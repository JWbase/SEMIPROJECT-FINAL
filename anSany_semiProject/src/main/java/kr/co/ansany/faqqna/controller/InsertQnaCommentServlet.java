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
 * Servlet implementation class InsertQnaCommentServlet
 */
@WebServlet(name = "InsertQnaComment", urlPatterns = { "/insertQnaComment.do" })
public class InsertQnaCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertQnaCommentServlet() {
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
		FaqqnaComment fc = new FaqqnaComment();
		fc.setQcWriter(request.getParameter("qcWriter"));
		fc.setQnaRef(Integer.parseInt(request.getParameter("qnaRef")));
		fc.setQcRef(Integer.parseInt(request.getParameter("qcRef")));
		fc.setQcContent(request.getParameter("qcContent"));
		
		//비즈니스로직
		FaqqnaService service = new FaqqnaService();
		int result = service.insertQnaComment(fc);
		//결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("title", "등록완료");
			request.setAttribute("msg", "답변이 등록 되었습니다.");
			request.setAttribute("icon", "success");
		} else {
			request.setAttribute("title", "등록실패");
			request.setAttribute("msg", "등록 중 오류가 발생 하였습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/faqqnaView.do?qnaNo="+fc.getQnaRef());
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
