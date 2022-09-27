package kr.co.ansany.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.notice.model.service.NoticeService;
import kr.co.ansany.notice.model.vo.Notice;
import kr.co.ansany.notice.model.vo.NoticePageData;

/**
 * Servlet implementation class SearchNoticeServlet
 */
@WebServlet(name = "SearchNotice", urlPatterns = { "/searchNotice.do" })
public class SearchNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchNoticeServlet() {
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

		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		int searchCategory = Integer.parseInt(request.getParameter("searchCategory"));
		String searchKeyWord = request.getParameter("searchKeyWord");

		NoticeService service = new NoticeService();
		NoticePageData npd = service.searchNotice(searchCategory, searchKeyWord, reqPage);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticeList.jsp");
		request.setAttribute("list", npd.getList());
		request.setAttribute("pageNavi", npd.getPageNavi());
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