package kr.co.ansany.faqqna.controller;

import java.io.File;
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
 * Servlet implementation class FaqqnaUpdateServlet
 */
@WebServlet(name = "FaqqnaUpdate", urlPatterns = { "/faqqnaUpdate.do" })
public class FaqqnaUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqqnaUpdateServlet() {
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
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/faqqna";
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize,"UTF-8", new DefaultFileRenamePolicy());
		
		int qnaCateNo = Integer.parseInt(mRequest.getParameter("qnaCateNo"));
		String qnaTitle = mRequest.getParameter("qnaTitle");
		int faqNo = Integer.parseInt(mRequest.getParameter("faqNo"));
		String qnaContent = mRequest.getParameter("qnaContent");
		
		String status = mRequest.getParameter("status");
		
		String filename = mRequest.getOriginalFileName("qnaUpfile");
		String filepath = mRequest.getFilesystemName("qnaUpfile");
		
		String oldFilename = mRequest.getParameter("oldFilename");
		String oldFilepath = mRequest.getParameter("oldFilepath");
		
		if(oldFilename != null && status.equals("stay")) {
			filename = oldFilename;
			filepath = oldFilepath;
		}
		Faqqna faq = new Faqqna();
		faq.setQnaCateNo(qnaCateNo);
		faq.setQnaTitle(qnaTitle);
		faq.setQnaNo(faqNo);
		faq.setQnaContent(qnaContent);
		faq.setQnaFileName(filename);
		faq.setQnaFilepath(filepath);
		
		//비즈니스로직
		FaqqnaService service = new FaqqnaService();
		int result = service.updateQna(faq);
		//결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("title", "수정완료!");
			request.setAttribute("msg", "문의사항 수정완료!");
			request.setAttribute("icon", "success");
			if(status.equals("delete")) {
				File delFile = new File(saveDirectory+"/"+oldFilepath);
				delFile.delete();
			}
		} else {
			request.setAttribute("title", "수정실패");
			request.setAttribute("msg", "문의사항수정 중 에러가 발생하였습니다. 관리자에게 문의하세요.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/faqqnaView.do?qnaNo="+faqNo);
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
