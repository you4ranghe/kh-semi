package com.semi.partner.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;

import com.semi.partner.model.vo.Partner;

import static com.semi.common.JDBCTemplate.rollback;
import static com.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.semi.partner.model.dao.PartnerDao;
import com.semi.product.model.vo.Product;


public class PartnerService {
	
	private PartnerDao dao=new PartnerDao();
	

	//파트너 등록 서비스
	public int insertPartner(Partner p) {
		Connection conn=getConnection();
		int result= dao.insertPartner(conn, p);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//파트너 아이디로 조회하는 서비스
	public Partner selectPartner(String userId) {
		Connection conn=getConnection();
		Partner p = dao.selectPartner(conn, userId);
		close(conn);
		return p;
	}
	
	//파트너 정보 수정 서비스
	public int updatePartner(Partner p) {
		Connection conn=getConnection();
		int result = dao.updatePartner(conn,p);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//파트너 탈퇴 서비스
	public int deletePartner(String partnerId) {
		Connection conn=getConnection();
		int result=dao.deletePartner(conn,partnerId);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

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
