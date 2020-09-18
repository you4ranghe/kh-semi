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
	
	
	public Product selectProductList(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product p = null;
		
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectProductList"));
			rs = pstmt.executeQuery();
					
			while(rs.next()) {
				p = new Product();
				p.setpNum(rs.getString("p_num"));
				p.setpBigNameEng(rs.getString("p_big_name_eng"));
				p.setpBigNameKor(rs.getString("p_big_name_kor"));
				p.setpName(rs.getString("p_name"));
				p.setpPriceA(rs.getInt("p_price_a"));
				p.setpPriceC(rs.getInt("p_price_c"));
				p.setpCountA(rs.getInt("p_count_a"));
				p.setpCountC(rs.getInt("p_count_c"));
				p.setpPlace(rs.getString("p_place"));
				p.setpWish(rs.getString("p_wish"));
				p.setpDateStart(rs.getDate("p_date_start"));
				p.setpDateFinish(rs.getDate("p_date_finish"));
				p.setpTime(rs.getString("p_time"));
				p.setpPeriod(rs.getString("p_period"));
				
               p.setgNum(rs.getString("g_num"));
               p.setTitleImgPath(rs.getString("title_img_path"));
               p.setpInfo(rs.getString("p_info"));
               p.setpPointInfo(rs.getString("p_point_info"));
               p.setpIntd(rs.getString("p_intd"));
               p.setRuntime(rs.getString("runtime"));
               p.setSchedule(rs.getString("schedule"));
               p.setPrecaution(rs.getString("precaution"));
               p.setpMapName(rs.getString("p_map_name"));
               p.setpMap(rs.getString("p_map"));
	               
	               
				System.out.println(rs.getString("p_name"));
//				
				//list.add(p);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		
			
		}return p;
	}
	
	public List<Product> filterProductList(Connection conn,Product p){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty(""));
			pstmt.setString(1, "");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
}
