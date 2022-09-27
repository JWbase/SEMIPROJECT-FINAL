package kr.co.ansany.member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.member.model.service.MemberService;
import kr.co.ansany.member.model.vo.Member;
import kr.co.ansany.member.model.vo.MyQnAData;

/**
 * Servlet implementation class myPageQnADeleteServlet
 */
@WebServlet(name = "myPageQnADelete", urlPatterns = { "/myPageQnADelete.do" })
public class myPageQnADeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myPageQnADeleteServlet() {
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
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		String memberId = request.getParameter("memberId");
		//3. 비즈니스 로직
		MemberService service = new MemberService();
		MyQnAData mqd = service.deleteQnA(qnaNo);
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(mqd!=null) {
			if(mqd.getQnaFilepath() != null) {
				String root = getServletContext().getRealPath("/");
				String deleteFile = root+"upload/"+mqd.getQnaFilepath();
				File delFile = new File(deleteFile);
				delFile.delete();
			}
			request.setAttribute("title", "삭제완료");
			request.setAttribute("msg", "삭제가 완료되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/myPageFrm.do?memberId="+memberId);
		}else {
			request.setAttribute("title", "삭제실패");
			request.setAttribute("msg", "관리자에게 문의하세요");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/myPageFrm.do?qnaNo="+qnaNo);
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
