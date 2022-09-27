package kr.co.ansany.member.model.vo;

import java.util.ArrayList;

public class MypageList {
	private ArrayList<MyPageOrderData> mpod;
	private ArrayList<MyQnAData> mqd;
	public MypageList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MypageList(ArrayList<MyPageOrderData> mpod, ArrayList<MyQnAData> mqd) {
		super();
		this.mpod = mpod;
		this.mqd = mqd;
	}
	public ArrayList<MyPageOrderData> getMpod() {
		return mpod;
	}
	public void setMpod(ArrayList<MyPageOrderData> mpod) {
		this.mpod = mpod;
	}
	public ArrayList<MyQnAData> getMqd() {
		return mqd;
	}
	public void setMqd(ArrayList<MyQnAData> mqd) {
		this.mqd = mqd;
	}
	
	
}
