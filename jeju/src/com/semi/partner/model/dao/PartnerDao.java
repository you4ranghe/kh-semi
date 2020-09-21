package com.semi.partner.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.semi.partner.model.vo.Partner;

public class PartnerDao {
	
	private Properties prop = new Properties();
	
	public PartnerDao() {
		
		try {
			String fileName=PartnerDao.class.getResource("/sql/partner/partner_sql.properties").getPath();
			prop.load(new FileReader(fileName));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//파트너 가입 서비스
	public int insertPartner(Connection conn ,Partner p) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("inserPartner"));
			pstmt.setString(1, p.getPartnerId());
			pstmt.setString(2,p.getPartnerImgOriginal());
			pstmt.setString(3, p.getPartnerImgRename());
			pstmt.setString(4, p.getIdCardImgOriginal());
			pstmt.setString(5, p.getIdCardImgRename());
			pstmt.setString(6, p.getPartnerNick());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
	}
	
	//파트너 아이디로 조회
	public Partner selectPartner(Connection conn, String userId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Partner p=null;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectPartner"));
			pstmt.setString(1, userId);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				p=new Partner();
				p.setIdCardImgOriginal(rs.getString("id_card_img_original"));
				p.setIdCardImgRename(rs.getString("id_card_img_rename"));
				p.setPartnerId(rs.getString("partner_id"));
				p.setPartnerImgOriginal(rs.getString("partner_img_original"));
				p.setPartnerImgRename(rs.getString("partner_img_rename"));
				p.setPartnerNick(rs.getString("partner_nick"));
				p.setPartnerNum(rs.getInt("partner_num"));
				p.setpEnrolldate(rs.getDate("p_enrolldate"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return p;
	}

}//클래스
