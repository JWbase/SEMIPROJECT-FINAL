package kr.co.ansany.freeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.freeboard.model.service.FreeBoardService;
import kr.co.ansany.freeboard.model.vo.FreeBoardPageData;

/**
 * Servlet implementation class SearchFreeBoardServlet
 */
@WebServlet(name = "SearchFreeBoard", urlPatterns = { "/searchFreeBoard.do" })
public class SearchFreeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchFreeBoardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		int searchCategory = Integer.parseInt(request.getParameter("searchCategory"));
		String searchKeyWord = request.getParameter("searchKeyWord");

		FreeBoardService service = new FreeBoardService();
		FreeBoardPageData fpd = service.searchFreeBoard(searchCategory, searchKeyWord, reqPage);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/freeBoard/freeBoardList.jsp");
		request.setAttribute("list", fpd.getList());
		request.setAttribute("pageNavi", fpd.getPageNavi());
		request.setAttribute("searchCategory", searchCategory);
		request.setAttribute("searchKeyWord", searchKeyWord);
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
