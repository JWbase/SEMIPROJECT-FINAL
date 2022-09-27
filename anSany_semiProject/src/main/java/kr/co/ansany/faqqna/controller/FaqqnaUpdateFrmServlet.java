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
 * Servlet implementation class FaqqnaUpdateFrmServlet
 */
@WebServlet(name = "FaqqnaUpdateFrm", urlPatterns = { "/faqqnaUpdateFrm.do" })
public class FaqqnaUpdateFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqqnaUpdateFrmServlet() {
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
		Faqqna faq = service.getFaqqna(qnaNo);
		//결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/faqqna/faqqnaUpdateFrm.jsp");
		request.setAttribute("faq", faq);
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
