package com.semi.wishList.model.dao;


import java.io.FileReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.semi.wishList.model.vo.WishList;
import static com.semi.common.JDBCTemplate.close;

public class WishListDao {
	private Properties prop=new Properties();
	
	public WishListDao() {
		
		  try { 
			  String fileName=WishListDao.class.getResource("/sql/wish/wish_sql.properties").getPath();
			  prop.load(new FileReader(fileName));
		  }catch(IOException e) { 
			  e.printStackTrace(); 
		}
		  
		 
	}
	
	
	public int insertWish(Connection conn,WishList w) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertWish"));
			pstmt.setString(1, w.getUserId());
			pstmt.setInt(2, w.getProductNum());
			pstmt.setString(3, w.getPageAddress());
			result=pstmt.executeUpdate();
			
			System.out.println(w.getPageAddress());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
	}
	
	public ArrayList<Map<String, Object>> selectWish(Connection conn,String userId){
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {

			pstmt=conn.prepareStatement(prop.getProperty("selectWish"));
			pstmt.setString(1, userId);
			System.out.println(userId);
			rs=pstmt.executeQuery();
			

			System.out.println("여기는 트라이 안");
			
			while(rs.next()) {
				System.out.println("여기 왜안들어오지");
				Map<String, Object> map = new HashMap<String, Object>();

				map.put("pName",rs.getString("P_NAME"));
				map.put("pDateStart",rs.getString("P_DATE_START"));
				map.put("pDateFinish",rs.getString("P_DATE_FINISH"));
				map.put("pInfo",rs.getString("P_INFO"));
				map.put("pImgPath",rs.getString("P_IMG_PATH"));
				map.put("runTime",rs.getString("RUNTIME"));
				map.put("pageAddress",rs.getString("PAGEADDRESS"));

				map.put("imag",rs.getString("TITLE_IMG_PATH"));
				

				list.add(map);
			
				
			}
			
			for(Map<String, Object> map : list){
				for(Map.Entry<String, Object> entry:map.entrySet()){
				        String key = entry.getKey();
				        Object value = entry.getValue();
				     System.out.println("key: " + key + " | value: " + value);
				}
			}
				


		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;	
		
	}
	
	public int deleteWish(Connection conn,String pName,String userId) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteWish"));
			pstmt.setString(1, userId);
			pstmt.setString(2, pName);
			result=pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


}
