package kr.co.ansany.freeboard.model.vo;

import java.util.ArrayList;

public class FreeBoardViewData {
	private FreeBoard f;
	private ArrayList<FreeBoardComment> commentList;
	private ArrayList<FreeBoardComment> reCommentList;

	public FreeBoardViewData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FreeBoardViewData(FreeBoard f, ArrayList<FreeBoardComment> commentList,
			ArrayList<FreeBoardComment> reCommentList) {
		super();
		this.f = f;
		this.commentList = commentList;
		this.reCommentList = reCommentList;
	}

	public FreeBoard getF() {
		return f;
	}

	public void setF(FreeBoard f) {
		this.f = f;
	}

	public ArrayList<FreeBoardComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList<FreeBoardComment> commentList) {
		this.commentList = commentList;
	}

	public ArrayList<FreeBoardComment> getReCommentList() {
		return reCommentList;
	}

	public void setReCommentList(ArrayList<FreeBoardComment> reCommentList) {
		this.reCommentList = reCommentList;
	}

}
