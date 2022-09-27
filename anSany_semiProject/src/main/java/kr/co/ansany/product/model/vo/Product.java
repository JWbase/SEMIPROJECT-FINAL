package kr.co.ansany.product.model.vo;

public class Product {
	private int productNo;
	private int cateCode;
	private String productName;
	private int productPrice;
	private int productQty;
	private String productImg;
	private String productInfo;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productNo, int cateCode, String productName, int productPrice, int productQty, String productImg,
			String productInfo) {
		super();
		this.productNo = productNo;
		this.cateCode = cateCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQty = productQty;
		this.productImg = productImg;
		this.productInfo = productInfo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getCateCode() {
		return cateCode;
	}
	public void setCateCode(int cateCode) {
		this.cateCode = cateCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public String getProductInfoBr() {
		return productInfo.replaceAll("\r\n", "<br>");
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	 
}
