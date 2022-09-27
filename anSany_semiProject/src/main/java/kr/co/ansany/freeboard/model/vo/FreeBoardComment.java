package kr.co.ansany.freeboard.model.vo;

public class FreeBoardComment {
	private int fCommentNo;
	private String fCommentWriter;
	private String fCommentContent;
	private String fCommentDate;
	private int freeBoardRef;
	private int fCommentRef;

	public FreeBoardComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FreeBoardComment(int fCommentNo, String fCommentWriter, String fCommentContent, String fCommentDate,
			int freeBoardRef, int fCommentRef) {
		super();
		this.fCommentNo = fCommentNo;
		this.fCommentWriter = fCommentWriter;
		this.fCommentContent = fCommentContent;
		this.fCommentDate = fCommentDate;
		this.freeBoardRef = freeBoardRef;
		this.fCommentRef = fCommentRef;
	}

	public int getfCommentNo() {
		return fCommentNo;
	}

	public void setfCommentNo(int fCommentNo) {
		this.fCommentNo = fCommentNo;
	}

	public String getfCommentWriter() {
		return fCommentWriter;
	}

	public void setfCommentWriter(String fCommentWriter) {
		this.fCommentWriter = fCommentWriter;
	}

	public String getfCommentContentBr() {
		return fCommentContent.replaceAll("\r\n", "<br>");
	}

	public String getfCommentContent() {
		return fCommentContent;
	}

	public void setfCommentContent(String fCommentContent) {
		this.fCommentContent = fCommentContent;
	}

	public String getfCommentDate() {
		return fCommentDate;
	}

	public void setfCommentDate(String fCommentDate) {
		this.fCommentDate = fCommentDate;
	}

	public int getFreeBoardRef() {
		return freeBoardRef;
	}

	public void setFreeBoardRef(int freeBoardRef) {
		this.freeBoardRef = freeBoardRef;
	}

	public int getfCommentRef() {
		return fCommentRef;
	}

	public void setfCommentRef(int fCommentRef) {
		this.fCommentRef = fCommentRef;
	}

}
