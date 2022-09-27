package kr.co.ansany.review.model.vo;

public class ReviewComment {
	private int rCommentNo;
	private String rCommentWriter;
	private String rCommentContent;
	private String rCommentDate;
	private int reviewRef;
	private int rCommentRef;

	public ReviewComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewComment(int rCommentNo, String rCommentWriter, String rCommentContent, String rCommentDate,
			int reivewRef, int rCommentRef) {
		super();
		this.rCommentNo = rCommentNo;
		this.rCommentWriter = rCommentWriter;
		this.rCommentContent = rCommentContent;
		this.rCommentDate = rCommentDate;
		this.reviewRef = reivewRef;
		this.rCommentRef = rCommentRef;
	}

	public int getrCommentNo() {
		return rCommentNo;
	}

	public void setrCommentNo(int rCommentNo) {
		this.rCommentNo = rCommentNo;
	}

	public String getrCommentWriter() {
		return rCommentWriter;
	}

	public void setrCommentWriter(String rCommentWriter) {
		this.rCommentWriter = rCommentWriter;
	}

	public String getrCommentContent() {
		return rCommentContent;
	}

	public String getrCommentContentBr() {
		return rCommentContent.replaceAll("\r\n", "<br>");
	}

	public void setrCommentContent(String rCommentContent) {
		this.rCommentContent = rCommentContent;
	}

	public String getrCommentDate() {
		return rCommentDate;
	}

	public void setrCommentDate(String rCommentDate) {
		this.rCommentDate = rCommentDate;
	}

	public int getReviewRef() {
		return reviewRef;
	}

	public void setReviewRef(int reivewRef) {
		this.reviewRef = reivewRef;
	}

	public int getrCommentRef() {
		return rCommentRef;
	}

	public void setrCommentRef(int rCommentRef) {
		this.rCommentRef = rCommentRef;
	}

}
