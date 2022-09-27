package kr.co.ansany.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.member.model.service.MemberService;

/**
 * Servlet implementation class changeMemberPwServlet
 */
@WebServlet(name = "changeMemberPw", urlPatterns = { "/changeMemberPw.do" })
public class changeMemberPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeMemberPwServlet() {
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
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberPw);
		//3. 비즈니스로직
		MemberService service= new MemberService();
		int result = service.changePw(memberId,memberPw);
		//4. 결과처리
		
		if(result>0) {
			response.sendRedirect("/updateMemberInfo.do");
		}else {
			//정보변경 실패
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "정보변경 실패");
			request.setAttribute("msg", "정보변경중 문제가 발생했습니다.");
			request.setAttribute("icon", "warning");
			request.setAttribute("loc", "/updateMemberInfo.do");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
