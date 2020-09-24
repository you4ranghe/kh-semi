package com.semi.product.model.service;

import java.sql.Connection;
import java.util.List;

import com.semi.product.model.dao.ProductDao;
import com.semi.product.model.vo.Product;
import com.semi.product.model.vo.Wish;
import com.semi.review.model.vo.Review;

import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.rollback;
import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;

public class ProductService {

	private ProductDao dao = new ProductDao();
	

	public Product selectProductOne(int pNum) {
		Connection conn=getConnection();
		Product p =dao.selectProductOne(conn,pNum);
		
		
		close(conn);
		return p;
	}
	
	
	
	
	
	
	
	
	// 정연
	
	
	public List<Product> selectAllProductList(int cPage,int numPerPage){
		Connection conn=getConnection();
		List<Product> list=dao.selectAllProductList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	public List<Product> selectProductList(int pNum){
		Connection conn = getConnection();
		List<Product> list = dao.selectProductList(conn,pNum);
		close(conn);
		//System.out.println(p.toString());
		return list;
	
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
	
	public int addProduct(Product p) {
		Connection conn=getConnection();
		int result=dao.addProduct(conn,p);
		if(result==1) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	public int updateProduct(Product p) {
		Connection conn=getConnection();
		int result=dao.updateProduct(conn, p);
		if(result==1) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}

	
	
	
	///////////리뷰
	
	public int insertReview(Review r) {
		Connection conn = getConnection();
		int result = dao.insertReview(conn,r);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	
	
	
	public List<Review> selectReviewList(int pNum){
		Connection conn = getConnection();
		List<Review> list = dao.selectReviewList(conn,pNum);
		close(conn);
		return list;
	}


	}
