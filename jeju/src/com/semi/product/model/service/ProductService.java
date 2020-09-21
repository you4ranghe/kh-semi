package com.semi.product.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
//import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.semi.product.model.dao.ProductDao;
import com.semi.product.model.vo.Product;
import com.semi.product.model.vo.Wish;

public class ProductService {

	private ProductDao dao=new ProductDao();
	
	
	public List<Product> selectAllProductList(int cPage,int numPerPage){
		Connection conn=getConnection();
		List<Product> list=dao.selectAllProductList(conn,cPage,numPerPage);
		close(conn);
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
	
	public int selectProductCount() {
		Connection conn=getConnection();
		int count=dao.selectProductCount(conn);
		close(conn);
		return count;
		
	}
	
	public int selectSearchProductCount(String search) {
		Connection conn=getConnection();
		int count=dao.selectSearchProductCount(conn,search);
		
		close(conn);
		return count;
				
	}
	
	public int clickHeart(int productNum, String userId) {
		Connection conn=getConnection();
		int result=dao.clickHeart(conn,productNum,userId);
		
		if(result==1) commit(conn);
		else rollback(conn);
					
		close(conn);
		
		return result;
	}
	
	public List<Wish> checkWish(String userId) {
		Connection conn=getConnection();
		List<Wish> wishlist=dao.checkWish(conn,userId);
		close(conn);
		return wishlist;
	}
}
