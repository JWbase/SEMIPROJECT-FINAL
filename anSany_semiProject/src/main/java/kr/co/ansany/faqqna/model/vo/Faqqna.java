package kr.co.ansany.faqqna.model.vo;

public class Faqqna {
	private int qnaNo;
	private String qnaTitle;
	private String qnaWriter;
	private String qnaContent;
	private int qnaReadCount;
	private String qnaDate;
	private String qnaFilepath;
	private String qnaFileName;
	private int qnaCateNo;
	private int qnaStatus;
	public Faqqna() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Faqqna(int qnaNo, String qnaTitle, String qnaWriter, String qnaContent, int qnaReadCount, String qnaDate,
			String qnaFilepath, String qnaFileName, int qnaCateNo, int qnaStatus) {
		super();
		this.qnaNo = qnaNo;
		this.qnaTitle = qnaTitle;
		this.qnaWriter = qnaWriter;
		this.qnaContent = qnaContent;
		this.qnaReadCount = qnaReadCount;
		this.qnaDate = qnaDate;
		this.qnaFilepath = qnaFilepath;
		this.qnaFileName = qnaFileName;
		this.qnaCateNo = qnaCateNo;
		this.qnaStatus = qnaStatus;
	}
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaWriter() {
		return qnaWriter;
	}
	public void setQnaWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}
	public String getQnaContentBr() {
		return qnaContent.replaceAll("\r\n", "<br>");
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public int getQnaReadCount() {
		return qnaReadCount;
	}
	public void setQnaReadCount(int qnaReadCount) {
		this.qnaReadCount = qnaReadCount;
	}
	public String getQnaDate() {
		return qnaDate;
	}
	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}
	public String getQnaFilepath() {
		return qnaFilepath;
	}
	public void setQnaFilepath(String qnaFilepath) {
		this.qnaFilepath = qnaFilepath;
	}
	public String getQnaFileName() {
		return qnaFileName;
	}
	public void setQnaFileName(String qnaFileName) {
		this.qnaFileName = qnaFileName;
	}
	public int getQnaCateNo() {
		return qnaCateNo;
	}
	public void setQnaCateNo(int qnaCateNo) {
		this.qnaCateNo = qnaCateNo;
	}
	public int getQnaStatus() {
		return qnaStatus;
	}
	public void setQnaStatus(int qnaStatus) {
		this.qnaStatus = qnaStatus;
	}
	
	
}
