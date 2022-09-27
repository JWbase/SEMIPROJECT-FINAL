package kr.co.ansany.review.model.vo;

public class Review {
	private int reviewNo;
	private String reviewTitle;
	private String reviewWriter;
	private String reviewContent;
	private int reviewReadCount;
	private String reviewDate;
	private String reviewFilename;
	private String reviewFilepath;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int reviewNo, String reviewTitle, String reviewWriter, String reviewContent, int reviewReadCount,
			String reviewDate, String reviewFilename, String reviewFilepath) {
		super();
		this.reviewNo = reviewNo;
		this.reviewTitle = reviewTitle;
		this.reviewWriter = reviewWriter;
		this.reviewContent = reviewContent;
		this.reviewReadCount = reviewReadCount;
		this.reviewDate = reviewDate;
		this.reviewFilename = reviewFilename;
		this.reviewFilepath = reviewFilepath;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	
	public String getReviewContentBr() {
		return reviewContent.replaceAll("\r\n", "<br>");
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public int getReviewReadCount() {
		return reviewReadCount;
	}
	public void setReviewReadCount(int reviewReadCount) {
		this.reviewReadCount = reviewReadCount;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getReviewFilename() {
		return reviewFilename;
	}
	public void setReviewFilename(String reviewFilename) {
		this.reviewFilename = reviewFilename;
	}
	public String getReviewFilepath() {
		return reviewFilepath;
	}
	public void setReviewFilepath(String reviewFilepath) {
		this.reviewFilepath = reviewFilepath;
	}

}
