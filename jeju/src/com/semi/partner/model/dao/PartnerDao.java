package com.semi.partner.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.semi.common.JDBCTemplate.close;
import com.semi.product.model.dao.ProductDao;
import com.semi.product.model.vo.Product;

public class PartnerDao {
	
	private Properties prop = new Properties();
	
	public PartnerDao() {
		try {
			String path = ProductDao.class.getResource("/sql/partner/partner_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Product> selectPartnerProductList(Connection conn,int cPage,int numPerPage,String userId){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectPartnerProductList"));
			pstmt.setString(1, userId);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Product p=new Product();
				p.setpNum(rs.getInt("p_num"));
				p.setpName(rs.getString("p_name"));
				p.setpBigNameEng(rs.getString("p_big_name_eng"));
				p.setpBigNameKor(rs.getString("p_big_name_kor"));
				p.setpMap(rs.getString("p_map_address"));
				p.setTitleImgPath(rs.getString("title_img_path"));
				list.add(p);
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	public int selectPartnerProductCount(Connection conn,String userId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectPartnerProductCount"));
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
		
			if(rs.next()) {
				result=rs.getInt(1);
			}
			System.out.println("파트너 전체 상품 몇개?"+ result);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteProduct(Connection conn, int pNum) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteProduct"));
			pstmt.setInt(1, pNum);
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
		
	}
	
}
