package com.semi.partner.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.rollback;
import static com.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.semi.partner.model.dao.PartnerDao;
import com.semi.product.model.vo.Product;

public class PartnerService {
	
	private PartnerDao dao=new PartnerDao();
	
	public List<Product> selectPartnerProductList(int cPage,int numPerPage,String userId){
		Connection conn=getConnection();
		List<Product> list=dao.selectPartnerProductList(conn,cPage,numPerPage,userId);
		close(conn);
		return list;
	}
	
	public int selectPartnerProductCount(String userId) {
		Connection conn=getConnection();
		int count=dao.selectPartnerProductCount(conn,userId);
		close(conn);
		return count;
		
	}
	
	public int deleteProduct(int pNum) {
		Connection conn=getConnection();
		int result=dao.deleteProduct(conn,pNum);
		if(result==1) commit(conn);
		else rollback(conn);
		
		return result;
		
	}
	public Product selectProduct(int pNum) {
		Connection conn=getConnection();
		Product p=dao.selectProduct(conn,pNum);
		
		close(conn);
		return p;
		
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

	
}
