package kr.co.ansany.review.model.vo;

import java.util.ArrayList;

public class ReviewViewData {
	private Review r;
	private ArrayList<ReviewComment> commentList;
	private ArrayList<ReviewComment> reCommentList;

	public ReviewViewData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewViewData(Review r, ArrayList<ReviewComment> commentList, ArrayList<ReviewComment> reCommentList) {
		super();
		this.r = r;
		this.commentList = commentList;
		this.reCommentList = reCommentList;
	}

	public Review getR() {
		return r;
	}

	public void setR(Review r) {
		this.r = r;
	}

	public ArrayList<ReviewComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList<ReviewComment> commentList) {
		this.commentList = commentList;
	}

	public ArrayList<ReviewComment> getReCommentList() {
		return reCommentList;
	}

	public void setReCommentList(ArrayList<ReviewComment> reCommentList) {
		this.reCommentList = reCommentList;
	}

}
