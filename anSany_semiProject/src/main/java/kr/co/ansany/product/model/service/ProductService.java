package kr.co.ansany.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.co.ansany.product.model.dao.ProductDao;
import kr.co.ansany.product.model.vo.Product;
import kr.co.ansany.product.model.vo.ProductPage;

public class ProductService {
	private ProductDao dao;
	
	public ProductService() {
		super();
		dao = new ProductDao();
	}
	
	public int totalCount() {
		Connection conn = JDBCTemplate.getConnection();
		int totalCount = dao.totalCount(conn);
		JDBCTemplate.close(conn);
		return totalCount;
	}

	public ArrayList<Product> productMore(int start, int amount) {
		Connection conn = JDBCTemplate.getConnection();
		int end = start+amount-1;
		ArrayList<Product> list = dao.moreProduct(conn,start,end);
		JDBCTemplate.close(conn);
		return list;
	}

	public Product selectOneProduct(int productNo) {
		Connection conn = JDBCTemplate.getConnection();
		Product p = dao.selectOneProduct(conn, productNo);
		JDBCTemplate.close(conn);
		return p;
	}
	// 혜규
	public int insertProduct(Product p) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertProduct(conn, p);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Product deleteProd(int prodNo) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		Product p = dao.selectOneProduct(conn, prodNo);
		int result = dao.deleteProd(conn, prodNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
			p=null;
		}
		JDBCTemplate.close(conn);
		return p;
	}

	public Product selectProduct(String prodNo) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		Product p = dao.selectProduct(conn, prodNo);
		JDBCTemplate.close(conn);
		return p;
	}

	public ProductPage selectAllProduct(int reqPage) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 5;
		int end = numPerPage*reqPage;
		int start = end - numPerPage + 1;
		
		ArrayList<Product> list = dao.selectAllProducts(conn, start, end);
		
		int totalCount = dao.selectProductCount(conn);
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage + 1;
		}
		int pageNaviSize=5;
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		String pageNavi = "<nav aria-label='Page navigation example'>";
		pageNavi += "<ul class='pagination'>";
//		이전버튼
		if(pageNo !=1) {
			pageNavi += "<li class='page-item'><a class='page-link' href='/prodList.do?reqPage=" + (pageNo - 1)
					+ "'>Previous</a></li>";
		}
//		페이지숫자
		for(int i=0;i<pageNaviSize;i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li class='page-item active' aria-current='page'><a class='page-link' href='/prodList.do?reqPage="
						+ pageNo + "'>" + pageNo + "</a></li>";
			} else {
				pageNavi += "<li class='page-item'><a class='page-link' href='/prodList.do?reqPage=" + pageNo + "'>"
						+ pageNo + "</a></li>";
			}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
//		다음버튼
		if(pageNo<=totalPage) {
			pageNavi += "<li class='page-item'><a class='page-link' href='/prodList.do?reqPage=" + pageNo
					+ "'>Next</a></li>";
		}

		pageNavi += "</ul>";
		pageNavi += "</nav>";
		ProductPage npd = new ProductPage(list, pageNavi);
		JDBCTemplate.close(conn);
		return npd;
	}

	public int modifyProd(Product p) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.modifyProd(conn, p);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Product> selectCatgory1() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Product> list = dao.selectCatgory1(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectCatgory2() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Product> list = dao.selectCatgory2(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Product> selectCatgory3() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Product> list = dao.selectCatgory3(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Product> selectCatgory4() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Product> list = dao.selectCatgory4(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> getProdList(String cateCode) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Product> list = dao.getProdList(conn, cateCode);
		JDBCTemplate.close(conn);
		return list;
	}

	public int prodCount1() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int prodCount = dao.prodCount1(conn);
		JDBCTemplate.close(conn);
		return prodCount;
	}

	public ArrayList<Product> cate1tMore(int start, int amount) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int end = start+amount-1;
		ArrayList<Product> list = dao.cate1Product(conn,start,end);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> cate2tMore(int start, int amount) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int end = start+amount-1;
		ArrayList<Product> list = dao.cate2Product(conn,start,end);
		JDBCTemplate.close(conn);
		return list;
	}

	public int prodCount2() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int prodCount = dao.prodCount2(conn);
		JDBCTemplate.close(conn);
		return prodCount;
	}

	public int prodCount3() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int prodCount = dao.prodCount3(conn);
		JDBCTemplate.close(conn);
		return prodCount;
	}

	public ArrayList<Product> cate3tMore(int start, int amount) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int end = start+amount-1;
		ArrayList<Product> list = dao.cate3Product(conn,start,end);
		JDBCTemplate.close(conn);
		return list;
	}
	public ArrayList<Product> cate4tMore(int start, int amount) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int end = start+amount-1;
		ArrayList<Product> list = dao.cate4Product(conn,start,end);
		JDBCTemplate.close(conn);
		return list;
	}

	public int prodCount4() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int prodCount = dao.prodCount4(conn);
		JDBCTemplate.close(conn);
		return prodCount;
	}

}
