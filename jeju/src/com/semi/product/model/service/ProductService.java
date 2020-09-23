package com.semi.product.model.service;

import java.sql.Connection;
import java.util.List;

import com.semi.product.model.dao.ProductDao;
import com.semi.product.model.vo.Product;

import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.rollback;
import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;

public class ProductService {

	private ProductDao dao = new ProductDao();
	
	public List<Product> selectProductList(){
		Connection conn = getConnection();
		List<Product> list = dao.selectProductList(conn);

		close(conn);
		return list;
	
	}
	
	public int selectProductCount() {
		Connection conn = getConnection();
		int count = dao.selectProductCount(conn);
		close(conn);
		return count;
	}
	
	public Product selectBoardOne(int no) {
		Connection conn=getConnection();
		Product p =dao.selectProductOne(conn,no);
		
		
		close(conn);
		return p;
	}
}
