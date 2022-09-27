package kr.co.ansany.faqqna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.faqqna.model.service.FaqqnaService;
import kr.co.ansany.faqqna.model.vo.Faqqna;
import kr.co.ansany.faqqna.model.vo.FaqqnaPageData;

/**
 * Servlet implementation class FaqqnaListServlet
 */
@WebServlet(name = "FaqqnaList", urlPatterns = { "/faqqnaList.do" })
public class FaqqnaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqqnaListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		String type = request.getParameter("type");
		//3.비즈니스로직
		FaqqnaService service = new FaqqnaService();
		FaqqnaPageData fpd = service.selectFaqqnaList(reqPage);
		//4.결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/faqqna/faqqna.jsp");
		request.setAttribute("qnaList", fpd.getQnaList());
		request.setAttribute("qnaPageNavi", fpd.getQnaPageNavi());
		request.setAttribute("type", type);
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
