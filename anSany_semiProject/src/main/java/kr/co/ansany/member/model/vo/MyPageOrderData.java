package kr.co.ansany.member.model.vo;

public class MyPageOrderData {
	
	private String orderDate;
	private int orderNo;
	private String productName;
	private int status;
	private int productPrice;
	private String productImg;
	public MyPageOrderData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyPageOrderData(String orderDate, int orderNo, String productName, int status, int productPrice,String productImg) {
		super();
		this.orderDate = orderDate;
		this.orderNo = orderNo;
		this.productName = productName;
		this.status = status;
		this.productPrice = productPrice;
		this.productImg = productImg;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	
	
}
