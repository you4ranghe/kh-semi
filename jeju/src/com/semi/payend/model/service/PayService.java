package com.semi.payend.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import com.semi.payend.model.dao.PayDao;
import com.semi.payend.model.vo.payEnd;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.rollback;

import static com.semi.common.JDBCTemplate.close;

public class PayService {
	private PayDao dao=new PayDao();
	
	public int insertPay(payEnd pe) {
		Connection conn=getConnection();
		int result=dao.insertPay(conn,pe);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}
//	  public ArrayList<Map<String, Object>> selectPay(String userId){
//		  Connection conn=getConnection();
//		  ArrayList<Map<String, Object>> list = dao.selectPay(conn,userId);
//		  close(conn);
//		  return list;
//	  }
//	  
	  public ArrayList<Map<String, Object>> selectPay(String userId,int cPage, int numPerPage){
		  Connection conn=getConnection();
		  ArrayList<Map<String, Object>> list = dao.selectPay(conn,userId,cPage, numPerPage);
		  close(conn);
		  return list;
	  }
	  
		public int selectPayCount(String userId) {
			Connection conn=getConnection();
			int count=dao.selectPayCount(conn,userId);
			close(conn);
			return count;
		}
		  public ArrayList<Map<String, Object>> selectDetail(String poNum){
			  Connection conn=getConnection();
			  ArrayList<Map<String, Object>> list = dao.selectDetail(conn,poNum);
			  close(conn);
			  return list;
		  }
}
