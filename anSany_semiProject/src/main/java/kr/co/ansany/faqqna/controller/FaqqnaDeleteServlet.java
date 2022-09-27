package kr.co.ansany.faqqna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.faqqna.model.service.FaqqnaService;
import kr.co.ansany.faqqna.model.vo.Faqqna;

/**
 * Servlet implementation class FaqqnaDeleteServlet
 */
@WebServlet(name = "FaqqnaDelete", urlPatterns = { "/faqqnaDelete.do" })
public class FaqqnaDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqqnaDeleteServlet() {
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
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		//비즈니스로직
		FaqqnaService service = new FaqqnaService();
		Faqqna faq = service.deleteQna(qnaNo);
		//결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(faq !=null) {
			request.setAttribute("title", "삭제완료!");
			request.setAttribute("msg", "삭제가 완료되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/faqqnaList.do?reqPage=1");
		} else {
			request.setAttribute("title", "삭제실패");
			request.setAttribute("msg", "삭제중 오류가 발생하였습니다. 관리자에게 문의하세요.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/faqqnaView.do?qnaNo="+qnaNo);
		}
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
