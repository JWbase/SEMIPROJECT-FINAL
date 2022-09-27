package kr.co.ansany.faqqna.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ansany.faqqna.model.service.FaqqnaService;
import kr.co.ansany.faqqna.model.vo.Faqqna;

/**
 * Servlet implementation class FaqqnaFileDownServlet
 */
@WebServlet(name = "FaqqnaFileDown", urlPatterns = { "/faqqnaFileDown.do" })
public class FaqqnaFileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqqnaFileDownServlet() {
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
		//사용자에게 다운로드할 파일과 현재 서블릿 연결
		String root = getServletContext().getRealPath("/");
		String downFile = root+"upload/faqqna/"+faq.getQnaFilepath();
		//스트림생성
		FileInputStream fis = new FileInputStream(downFile);
		BufferedInputStream bis = new BufferedInputStream(fis);
		//파일을 내보내기위한 스트림
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		//파일명 처리
		String resFilename = new String(faq.getQnaFileName().getBytes("UTF-8"),"ISO-8859-1");
		//파일 다운로드를위한 HTTP 헤더설정
		response.setContentType("appliction/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="+resFilename);
		//파일전송
		while(true) {
			int read = bis.read();
			if(read != -1) {
				bos.write(read);
			} else {
				break;
			}
		}
		bos.close();
		bis.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
