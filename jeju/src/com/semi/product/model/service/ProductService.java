package com.semi.product.model.service;

import static com.semi.common.JDBCTemplate.close;
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
	
	public Product selectProductList(){
		Connection conn = getConnection();
		Product p = dao.selectProductList(conn);
		close(conn);
		System.out.println(p.toString());
		return p;
	
	}
	public List<Product> selectSearchProductList(String search,int cPage,int numPerPage){
		
		Connection conn=getConnection();
		List<Product> list=dao.selectSearchProductList(conn,search,cPage,numPerPage);
		
		close(conn);
		
		return list;
		
	}
	
	public int selectSearchProductCount(String search) {
		Connection conn=getConnection();
		int count=dao.selectSearchProductCount(conn,search);
		
		close(conn);
		return count;
				
	}
	
}
