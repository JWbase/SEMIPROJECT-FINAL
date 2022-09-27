package kr.co.ansany.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.co.ansany.product.model.vo.Product;

public class ProductDao {

	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from product_tbl";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return totalCount;
	}

	public ArrayList<Product> moreProduct(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		String query = "select * from (select rownum as rnum, p.* from (select * from product_tbl order by 1 desc)p) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product p = new Product();
				p.setProductNo(rset.getInt("product_no"));
				p.setCateCode(rset.getInt("cate_code"));
				p.setProductName(rset.getString("product_name"));
				p.setProductInfo(rset.getString("product_info"));
				p.setProductImg(rset.getString("product_img"));
				p.setProductPrice(rset.getInt("product_price"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public Product selectOneProduct(Connection conn, int productNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product p = new Product();
		String query = "select * from product_tbl where product_no=? order by 1";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				p = new Product();
				p.setProductNo(rset.getInt("product_no"));
				p.setCateCode(rset.getInt("cate_code"));
				p.setProductName(rset.getString("product_name"));
				p.setProductInfo(rset.getString("product_info"));
				p.setProductImg(rset.getString("product_img"));
				p.setProductPrice(rset.getInt("product_price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return p;
	}
	// 혜규
	public int insertProduct(Connection conn, Product p) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into product_tbl values (product_seq.nextval,?,?,?,?,?,?)";		
		try {
			pstmt = conn.prepareStatement(query);			
				pstmt.setInt(1, p.getCateCode());
				pstmt.setString(2, p.getProductName());
				pstmt.setInt(3, p.getProductPrice());
				pstmt.setInt(4, p.getProductQty());
				pstmt.setString(5, p.getProductImg());
				pstmt.setString(6, p.getProductInfo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteProd(Connection conn, int prodNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from product_tbl where product_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, prodNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Product selectProduct(Connection conn, String prodNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product p = null;
		String query = "select * from product_tbl where product_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prodNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				p = new Product();
				p.setProductImg(rset.getString("product_img"));
				p.setProductInfo(rset.getString("product_info"));
				p.setProductName(rset.getString("product_name"));
				p.setProductNo(rset.getInt("product_no"));
				p.setProductPrice(rset.getInt("product_price"));
				p.setProductQty(rset.getInt("product_Qty"));		
				p.setCateCode(rset.getInt("cate_code"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return p;
	}

	public ArrayList<Product> selectAllProducts(Connection conn, int start, int end) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> products = new ArrayList<Product>();
		String query = "SELECT * FROM(SELECT ROWNUM AS RNUM, N.* FROM(SELECT * FROM PRODUCT_TBL ORDER BY PRODUCT_NO DESC)n) WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,start);
			pstmt.setInt(2,end);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				int productNo = rset.getInt("product_no");
				int cateCode = rset.getInt("cate_code");
				String productName = rset.getString("product_name");
				int productPrice = rset.getInt("product_price");
				int productQty = rset.getInt("product_qty");
				String productImg = rset.getString("product_img");
				String productInfo = rset.getString("product_info");
				Product p = new Product(productNo, cateCode, productName, productPrice, productQty, productImg, productInfo);
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return products;
	}

	public int modifyProd(Connection conn, Product p) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update product_tbl set cate_code=?, product_name=?, product_price=?, product_qty=?, product_img=?, product_info=? where product_no=?";
		try {
			pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, p.getCateCode());
				pstmt.setString(2, p.getProductName());
				pstmt.setInt(3, p.getProductPrice());
				pstmt.setInt(4, p.getProductQty());
				pstmt.setString(5, p.getProductImg());
				pstmt.setString(6, p.getProductInfo());
				pstmt.setInt(7, p.getProductNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Product> selectCatgory1(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> products = new ArrayList<Product>();
		String query = "select * from product_tbl where cate_code=5001";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				int productNo = rset.getInt("product_no");
				int cateCode = rset.getInt("cate_code");
				String productName = rset.getString("product_name");
				int productPrice = rset.getInt("product_price");
				int productQty = rset.getInt("product_qty");
				String productImg = rset.getString("product_img");
				String productInfo = rset.getString("product_info");
				Product p = new Product(productNo, cateCode, productName, productPrice, productQty, productImg, productInfo);
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return products;
	}

	public int catgory1Count(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from product_tbl where cate_code=5001";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return totalCount;
	}

	public ArrayList<Product> selectCatgory2(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> products = new ArrayList<Product>();
		String query = "select * from product_tbl where cate_code=6001";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				int productNo = rset.getInt("product_no");
				int cateCode = rset.getInt("cate_code");
				String productName = rset.getString("product_name");
				int productPrice = rset.getInt("product_price");
				int productQty = rset.getInt("product_qty");
				String productImg = rset.getString("product_img");
				String productInfo = rset.getString("product_info");
				Product p = new Product(productNo, cateCode, productName, productPrice, productQty, productImg, productInfo);
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return products;
	}


	public ArrayList<Product> getProdList(Connection conn, String categoryCode) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		String query = "select * from product_tbl where cate_code=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, categoryCode);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int productNo = rset.getInt("product_no");
				int cateCode = rset.getInt("cate_code");
				String productName = rset.getString("product_name");
				int productPrice = rset.getInt("product_price");
				int productQty = rset.getInt("product_qty");
				String productImg = rset.getString("product_img");
				String productInfo = rset.getString("product_info");
				Product p = new Product(productNo, cateCode, productName, productPrice, productQty, productImg, productInfo);
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public ArrayList<Product> selectCatgory3(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> products = new ArrayList<Product>();
		String query = "select * from product_tbl where cate_code=7001";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				int productNo = rset.getInt("product_no");
				int cateCode = rset.getInt("cate_code");
				String productName = rset.getString("product_name");
				int productPrice = rset.getInt("product_price");
				int productQty = rset.getInt("product_qty");
				String productImg = rset.getString("product_img");
				String productInfo = rset.getString("product_info");
				Product p = new Product(productNo, cateCode, productName, productPrice, productQty, productImg, productInfo);
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return products;
	}
	public ArrayList<Product> selectCatgory4(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> products = new ArrayList<Product>();
		String query = "select * from product_tbl where cate_code=8001";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				int productNo = rset.getInt("product_no");
				int cateCode = rset.getInt("cate_code");
				String productName = rset.getString("product_name");
				int productPrice = rset.getInt("product_price");
				int productQty = rset.getInt("product_qty");
				String productImg = rset.getString("product_img");
				String productInfo = rset.getString("product_info");
				Product p = new Product(productNo, cateCode, productName, productPrice, productQty, productImg, productInfo);
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return products;
	}

	public int selectProductCount(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from PRODUCT_TBL";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return totalCount;
	}

	public int prodCount1(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int prodCount = 0;
		String query = "select count(*) as cnt from product_tbl where cate_code=5001";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				prodCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return prodCount;
	}

	public ArrayList<Product> cate1Product(Connection conn, int start, int end) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		String query = "select * from (select rownum as rnum, p.* from (select * from product_tbl where cate_code=5001 order by 1 desc)p) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product p = new Product();
				p.setProductNo(rset.getInt("product_no"));
				p.setCateCode(rset.getInt("cate_code"));
				p.setProductName(rset.getString("product_name"));
				p.setProductInfo(rset.getString("product_info"));
				p.setProductImg(rset.getString("product_img"));
				p.setProductPrice(rset.getInt("product_price"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Product> cate2Product(Connection conn, int start, int end) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		String query = "select * from (select rownum as rnum, p.* from (select * from product_tbl where cate_code=6001 order by 1 desc)p) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product p = new Product();
				p.setProductNo(rset.getInt("product_no"));
				p.setCateCode(rset.getInt("cate_code"));
				p.setProductName(rset.getString("product_name"));
				p.setProductInfo(rset.getString("product_info"));
				p.setProductImg(rset.getString("product_img"));
				p.setProductPrice(rset.getInt("product_price"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int prodCount2(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int prodCount = 0;
		String query = "select count(*) as cnt from product_tbl where cate_code=6001";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				prodCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return prodCount;
	}

	public int prodCount3(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int prodCount = 0;
		String query = "select count(*) as cnt from product_tbl where cate_code=7001";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				prodCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return prodCount;
	}

	public ArrayList<Product> cate3Product(Connection conn, int start, int end) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		String query = "select * from (select rownum as rnum, p.* from (select * from product_tbl where cate_code=7001 order by 1 desc)p) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product p = new Product();
				p.setProductNo(rset.getInt("product_no"));
				p.setCateCode(rset.getInt("cate_code"));
				p.setProductName(rset.getString("product_name"));
				p.setProductInfo(rset.getString("product_info"));
				p.setProductImg(rset.getString("product_img"));
				p.setProductPrice(rset.getInt("product_price"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Product> cate4Product(Connection conn, int start, int end) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		String query = "select * from (select rownum as rnum, p.* from (select * from product_tbl where cate_code=8001 order by 1 desc)p) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product p = new Product();
				p.setProductNo(rset.getInt("product_no"));
				p.setCateCode(rset.getInt("cate_code"));
				p.setProductName(rset.getString("product_name"));
				p.setProductInfo(rset.getString("product_info"));
				p.setProductImg(rset.getString("product_img"));
				p.setProductPrice(rset.getInt("product_price"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int prodCount4(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int prodCount = 0;
		String query = "select count(*) as cnt from product_tbl where cate_code=8001";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				prodCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return prodCount;
	}
	



}
