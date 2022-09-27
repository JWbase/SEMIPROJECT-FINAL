package kr.co.ansany.member.model.vo;

public class MyQnAData {
	private int qnaCateNo;
	private String qnaTitle;
	private String qnaDate;
	private int qnaStatus;
	private String qnaWriter;
	private int qnaNo;
	private String qnaFilepath;
	private String qnaFilename;
	public MyQnAData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyQnAData(int qnaCateNo, String qnaTitle, String qnaDate, int qnaStatus, String qnaWriter, int qnaNo, String qnaFilepath, String qnaFilename) {
		super();
		this.qnaCateNo = qnaCateNo;
		this.qnaTitle = qnaTitle;
		this.qnaDate = qnaDate;
		this.qnaStatus = qnaStatus;
		this.qnaWriter = qnaWriter;
		this.qnaNo = qnaNo;
		this.qnaFilepath = qnaFilepath;
		this.qnaFilename = qnaFilename;
	}
	public int getQnaCateNo() {
		return qnaCateNo;
	}
	public void setQnaCateNo(int qnaCateNo) {
		this.qnaCateNo = qnaCateNo;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaDate() {
		return qnaDate;
	}
	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}
	public int getQnaStatus() {
		return qnaStatus;
	}
	public void setQnaStatus(int qnaStatus) {
		this.qnaStatus = qnaStatus;
	}
	public String getQnaWriter() {
		return qnaWriter;
	}
	public void setQnaWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getQnaFilepath() {
		return qnaFilepath;
	}
	public void setQnaFilepath(String qnaFilepath) {
		this.qnaFilepath = qnaFilepath;
	}
	public String getQnaFilename() {
		return qnaFilename;
	}
	public void setQnaFilename(String qnaFilename) {
		this.qnaFilename = qnaFilename;
	}
}
