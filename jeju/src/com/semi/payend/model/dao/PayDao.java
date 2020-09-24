package com.semi.payend.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import static com.semi.common.JDBCTemplate.close;
import com.semi.payend.model.vo.payEnd;

public class PayDao {
	
	private Properties prop=new Properties();
	
	public PayDao() {
		try {
			String fileName=PayDao.class.getResource("/sql/pay/pay_sql.properties").getPath();
			prop.load(new FileReader(fileName));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertPay(Connection conn,payEnd pe) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			System.out.println("여기들옴?");
			pstmt=conn.prepareStatement(prop.getProperty("insertPay"));
			pstmt.setString(1, pe.getPayType());
			pstmt.setInt(2, pe.getTotalPrice());
			pstmt.setInt(3, pe.getProductNum());
			pstmt.setString(4, pe.getUserId());
			pstmt.setInt(5, pe.getAdultNum());
			pstmt.setInt(6, pe.getChildNum());
			pstmt.setString(7, pe.getDateStart());
			pstmt.setString(8, pe.getPayName());
			pstmt.setString(9, pe.getPayAddress());
			pstmt.setString(10, pe.getPayPhone());
			pstmt.setString(11, pe.getPayEmail());
			System.out.println("여기는?");
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public ArrayList<Map<String, Object>> selectPay(Connection conn,String userId){
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			
			pstmt=conn.prepareStatement(prop.getProperty("selectPay"));
			pstmt.setString(1, userId);
			System.out.println(userId);
			rs=pstmt.executeQuery();
			
	
		
			while(rs.next()) {
			
				Map<String, Object> map = new HashMap<String, Object>();

				map.put("payOrderDate",rs.getString("PO_DATE"));
				map.put("pDateStart",rs.getString("P_DATE_START"));
				map.put("pInfo",rs.getString("p_info"));
				map.put("pImgPath",rs.getString("p_img_path"));
				map.put("price",rs.getString("TOTAL_PRICE"));
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
	
}
