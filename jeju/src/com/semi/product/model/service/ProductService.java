package com.semi.product.model.service;

//import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.semi.product.model.dao.ProductDao;
import com.semi.product.model.vo.Product;

public class ProductService {

	private ProductDao dao=new ProductDao();
	
	public List<Product> filterProductList(Product p) {
		
		Connection conn=getConnection();
		List<Product> list=dao.filterProductList(conn,p);
		return list;
	}
	
	
	
	
}
