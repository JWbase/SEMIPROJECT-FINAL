package kr.co.ansany.product.model.vo;

import java.util.ArrayList;

public class ProductPage {
	private ArrayList<Product> list;
	private String pageNavi;
	public ProductPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductPage(ArrayList<Product> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<Product> getList() {
		return list;
	}
	public void setList(ArrayList<Product> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

}
