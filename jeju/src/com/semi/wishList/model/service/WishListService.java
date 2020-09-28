package com.semi.wishList.model.service;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import com.semi.wishList.model.dao.WishListDao;
import com.semi.wishList.model.vo.WishList;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.rollback;
import static com.semi.common.JDBCTemplate.close;

public class WishListService {
	
	  private WishListDao dao=new WishListDao();
	  
	  
	  public int insertWish(WishList we) { 
		  Connection conn=getConnection();
		  int result=dao.insertWish(conn,we); 
		  if(result>0) commit(conn); 
		  else rollback(conn); 
		  close(conn); 
		  return result; 
	  }
	 
	  public ArrayList<Map<String, Object>> selectWish(String userId){
		  Connection conn=getConnection();
		  ArrayList<Map<String, Object>> list = dao.selectWish(conn,userId);
		  close(conn);
		  return list;
	  }
	  
	  public int deleteWish(String pName,String userId) {
		  Connection conn=getConnection();
		  int result=dao.deleteWish(conn,pName,userId);
		  if(result>0) commit(conn);
		  else rollback(conn);
		  close(conn);
		  return result;
		  
				  
		  
		 
	  }
	  
	  public int countWish(String userId) {
	        Connection conn=getConnection();
	        int count =dao.countWish(conn,userId);
	        close(conn);
	        return count;
	     }


}
