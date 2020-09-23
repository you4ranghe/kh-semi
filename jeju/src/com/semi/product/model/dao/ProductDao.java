package com.semi.product.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import com.semi.product.model.vo.Product;

public class ProductDao {

	private Properties prop = new Properties();
	
	public ProductDao() {
		try {
			String path = ProductDao.class.getResource("/sql/product/product_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Product> selectProductList(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList();

		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectProductList"));
			rs = pstmt.executeQuery();
					
			while(rs.next()) {
				Product p = new Product();
				p.setpNum(rs.getInt("p_num"));
				p.setpBigNameEng(rs.getString("p_big_name_eng"));
				p.setpBigNameKor(rs.getString("p_big_name_kor"));
				p.setpName(rs.getString("p_name"));
				p.setpPriceA(rs.getInt("p_price_a"));
				p.setpPriceC(rs.getInt("p_price_c"));
				p.setpDateStart(rs.getDate("p_date_start"));
				p.setpDateFinish(rs.getDate("p_date_finish"));
				p.setpTime(rs.getString("p_time"));
				
               p.setTitleImgPath(rs.getString("title_img_path"));
               p.setpImgPath(rs.getString("p_img_path"));
               p.setpInfo(rs.getString("p_info"));
               p.setpPointInfo(rs.getString("p_point_info"));
               p.setpIntd(rs.getString("p_intd"));
               p.setRuntime(rs.getString("runtime"));
               p.setScheduleImgPath(rs.getString("schedule_img_path"));
               p.setPrecaution(rs.getString("precaution"));
               p.setpMapName(rs.getString("p_map_name"));
               p.setpMap(rs.getString("p_map"));
               p.setpScore(rs.getInt("p_score"));
               p.setPartnerNum(rs.getInt("partner_num"));
	               
	           list.add(p);
	           
	    
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		
			
		}return list;
	}
	
	public int selectProductCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectProductCount"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			
		}return result;
	}
	
	public Product selectProductOne(Connection conn, int no) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Product p =null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectProductOne"));
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				 p = new Product();
				p.setpNum(rs.getInt("p_num"));
				p.setpBigNameEng(rs.getString("p_big_name_eng"));
				p.setpBigNameKor(rs.getString("p_big_name_kor"));
				p.setpName(rs.getString("p_name"));
				p.setpPriceA(rs.getInt("p_price_a"));
				p.setpPriceC(rs.getInt("p_price_c"));
				p.setpDateStart(rs.getDate("p_date_start"));
				p.setpDateFinish(rs.getDate("p_date_finish"));
				p.setpTime(rs.getString("p_time"));
				
               p.setTitleImgPath(rs.getString("title_img_path"));
               p.setpImgPath(rs.getString("p_img_path"));
               p.setpInfo(rs.getString("p_info"));
               p.setpPointInfo(rs.getString("p_point_info"));
               p.setpIntd(rs.getString("p_intd"));
               p.setRuntime(rs.getString("runtime"));
               p.setScheduleImgPath(rs.getString("schedule_img_path"));
               p.setPrecaution(rs.getString("precaution"));
               p.setpMapName(rs.getString("p_map_name"));
               p.setpMap(rs.getString("p_map"));
               p.setpScore(rs.getInt("p_score"));
               p.setPartnerNum(rs.getInt("partner_num"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return p;
		
	}
	
}
