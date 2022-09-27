package kr.co.ansany.cart.model.vo;

import java.sql.Date;

public class Order {
	private int orderNo;
	private String memberId;
	private int productNo;
	private int totalPrice;
	private String orderName;
	private String orderAddr;
	private String orderPhone;
	private Date orderDate;
	private int status;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderNo, String memberId, int productNo, int totalPrice, String orderName, String orderAddr,
			String orderPhone, Date orderDate, int status) {
		super();
		this.orderNo = orderNo;
		this.memberId = memberId;
		this.productNo = productNo;
		this.totalPrice = totalPrice;
		this.orderName = orderName;
		this.orderAddr = orderAddr;
		this.orderPhone = orderPhone;
		this.orderDate = orderDate;
		this.status = status;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderAddr() {
		return orderAddr;
	}
	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}
	public String getOrderPhone() {
		return orderPhone;
	}
	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}