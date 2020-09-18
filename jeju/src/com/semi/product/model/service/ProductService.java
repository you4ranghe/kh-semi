package com.semi.product.model.service;

import java.sql.Connection;
import java.util.List;

import com.semi.product.model.dao.ProductDao;
import com.semi.product.model.vo.Product;
import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;

public class ProductService {

	private ProductDao dao = new ProductDao();
	
	public Product selectProductList(){
		Connection conn = getConnection();
		Product p = dao.selectProductList(conn);
		close(conn);
		System.out.println(p.toString());
		return p;
	
	}
}
