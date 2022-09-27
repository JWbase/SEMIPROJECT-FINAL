package kr.co.ansany.member.controller;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.member.model.service.MemberService;

/**
 * Servlet implementation class ChkedChangeLevelServlet
 */
@WebServlet(name = "ChkedChangeLevel", urlPatterns = { "/chkedChangeLevel.do" })
public class ChkedChangeLevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChkedChangeLevelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String no = request.getParameter("no");
		String level = request.getParameter("level");
		
		MemberService service = new MemberService();
		boolean result = service.chkedChangeLevel(no,level);	
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result) {
			request.setAttribute("title","등급 변경 성공");
			request.setAttribute("msg","회원 등급 변경에 성공했습니다.");
			request.setAttribute("icon","success");
		}else {		
			request.setAttribute("title","등급변경 실패");
			request.setAttribute("msg","등급변경 중 문제가 발생했습니다");
			request.setAttribute("icon","warning");
		}
		request.setAttribute("loc","/adminPage.do");
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
