package kr.co.ansany.faqqna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.ansany.faqqna.model.service.FaqqnaService;
import kr.co.ansany.faqqna.model.vo.Faqqna;

/**
 * Servlet implementation class FaqqnaWriteServlet
 */
@WebServlet(name = "FaqqnaWrite", urlPatterns = { "/faqqnaWrite.do" })
public class FaqqnaWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqqnaWriteServlet() {
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
		String root = getServletContext().getRealPath("/"); //web-app의 절대경로
		String saveDirectory = root+"upload/faqqna";
		//파일업로드 최대용량 설정
		int maxSize = 10*1024*1024;
		
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize,"UTF-8", new DefaultFileRenamePolicy());
		int qnaCateNo = Integer.parseInt(mRequest.getParameter("qnaCateNo"));
		String qnaTitle = mRequest.getParameter("qnaTitle");
		String qnaWriter = mRequest.getParameter("qnaWriter");
		String qnaContent = mRequest.getParameter("qnaContent");
		String qnaFilename = mRequest.getOriginalFileName("qnaUpfile");
		String qnaFilepath = mRequest.getFilesystemName("qnaUpfile");
		Faqqna faq = new Faqqna();
		faq.setQnaCateNo(qnaCateNo);
		faq.setQnaTitle(qnaTitle);
		faq.setQnaWriter(qnaWriter);
		faq.setQnaContent(qnaContent);
		faq.setQnaFileName(qnaFilename);
		faq.setQnaFilepath(qnaFilepath);
		//3.비즈니스로직
		FaqqnaService service = new FaqqnaService();
		int result = service.insertQna(faq);
		//4.결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("title", "문의완료!");
			request.setAttribute("msg", "문의사항이 등록되었습니다.");
			request.setAttribute("icon", "success");
		} else {
			request.setAttribute("title", "등록실패");
			request.setAttribute("msg", "문의사항등록 중 오류가 발생 하였습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/faqqnaList.do?reqPage=1&type=faq");
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
