package kr.co.ansany.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.member.model.service.MemberService;
import kr.co.ansany.member.model.vo.MyPageOrderData;
import kr.co.ansany.member.model.vo.MypageList;

/**
 * Servlet implementation class myPageFrmServlet
 */
@WebServlet(name = "myPageFrm", urlPatterns = { "/myPageFrm.do" })
public class myPageFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myPageFrmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		String memberId = request.getParameter("memberId");
		//3. 비즈니스처리
		MemberService service = new MemberService();
		MypageList mpl = service.myPageList(memberId);
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/myPage.jsp");
		
		request.setAttribute("mqd", mpl.getMqd());
		request.setAttribute("mpod", mpl.getMpod());
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
