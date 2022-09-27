package kr.co.ansany.faqqna.model.vo;

import java.util.ArrayList;

public class FaqqnaPageData {
	private ArrayList<Faqqna> qnaList;
	private String qnaPageNavi;
	public FaqqnaPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FaqqnaPageData(ArrayList<Faqqna> qnaList, String qnaPageNavi) {
		super();
		this.qnaList = qnaList;
		this.qnaPageNavi = qnaPageNavi;
	}
	public ArrayList<Faqqna> getQnaList() {
		return qnaList;
	}
	public void setQnaList(ArrayList<Faqqna> qnaList) {
		this.qnaList = qnaList;
	}
	public String getQnaPageNavi() {
		return qnaPageNavi;
	}
	public void setQnaPageNavi(String qnaPageNavi) {
		this.qnaPageNavi = qnaPageNavi;
	}
	
}
