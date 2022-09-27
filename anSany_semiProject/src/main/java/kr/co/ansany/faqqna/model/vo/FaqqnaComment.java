package kr.co.ansany.faqqna.model.vo;

public class FaqqnaComment {
	private int qcNo;
	private String qcWriter;
	private String qcContent;
	private String qcDate;
	private int qnaRef;
	private int qcRef;
	
	
	public FaqqnaComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FaqqnaComment(int qcNo, String qcWriter, String qcContent, String qcDate, int qnaRef, int qcRef) {
		super();
		this.qcNo = qcNo;
		this.qcWriter = qcWriter;
		this.qcContent = qcContent;
		this.qcDate = qcDate;
		this.qnaRef = qnaRef;
		this.qcRef = qcRef;
	}

	public int getQcNo() {
		return qcNo;
	}
	public void setQcNo(int qcNo) {
		this.qcNo = qcNo;
	}
	public String getQcWriter() {
		return qcWriter;
	}
	public void setQcWriter(String qcWriter) {
		this.qcWriter = qcWriter;
	}
	public String getQcContentBR() {
		return qcContent.replaceAll("\r\n", "<br>");
	}
	public String getQcContent() {
		return qcContent;
	}
	public void setQcContent(String qcContent) {
		this.qcContent = qcContent;
	}
	public String getQcDate() {
		return qcDate;
	}
	public void setQcDate(String qcDate) {
		this.qcDate = qcDate;
	}
	public int getQnaRef() {
		return qnaRef;
	}
	public void setQnaRef(int qnaRef) {
		this.qnaRef = qnaRef;
	}
	public int getQcRef() {
		return qcRef;
	}
	public void setQcRef(int qcRef) {
		this.qcRef = qcRef;
	}
	
}
