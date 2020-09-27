package com.semi.partner.model.dao;


import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.partner.model.vo.Partner;
import com.semi.payend.model.vo.payEnd;
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
	

	//파트너 가입 서비스 dao
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
	
	//파트너 아이디로 조회 dao
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
					p.setPartnerStatus(rs.getString("partner_status"));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}return p;
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
				p.setpPriceC(rs.getInt("p_price_c"));
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

		
	

		

  //파트너 정보 수정 dao
  public int updatePartner(Connection conn, Partner p) {
     PreparedStatement pstmt=null;
		  int result=0;
  try {
			pstmt=conn.prepareStatement(prop.getProperty("updatePartner"));
			pstmt.setString(1, p.getPartnerImgOriginal());
			pstmt.setString(2, p.getPartnerImgRename());
//			pstmt.setString(3, p.getIdCardImgOriginal());
//			pstmt.setString(4, p.getIdCardImgRename());
			pstmt.setString(3, p.getPartnerNick());
			pstmt.setString(4, p.getPartnerId());
    result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
    }finally {
			close(pstmt);
		}return result;
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
      }finally {
			close(pstmt);
		}return result;
	}

			
			

	
	
	//회원 탈퇴 dao
	public int deletePartner(Connection conn, String partnerId) {
  	PreparedStatement pstmt=null;
		int result=0;
		
		try {
      	pstmt=conn.prepareStatement(prop.getProperty("deletePartner"));
			pstmt.setString(1, partnerId);
			
			result=pstmt.executeUpdate();
      	}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
    }return result;
	}
	
	public Product selectProduct(Connection conn,int pNum) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Product p=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectOneProduct"));
			pstmt.setInt(1, pNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				p=new Product();
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
				p.setpIntd(rs.getString("p_intd"));
				p.setpPointInfo(rs.getString("p_point_info"));
				p.setRuntime(rs.getString("runtime"));
				p.setScheduleImgPath(rs.getString("schedule_img_path"));
				p.setPrecaution(rs.getString("precaution"));
				p.setpMapAddress(rs.getString("p_map_address"));
				p.setpMap(rs.getString("p_map"));
				p.setpScore(rs.getInt("p_score"));
				p.setPartnerId(rs.getString("partner_id"));
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return p;
	}
	
	public int addProduct(Connection conn, Product p) {
    	PreparedStatement pstmt=null;
		int result=0;
		
		try {
      		pstmt=conn.prepareStatement(prop.getProperty("addProduct"));
			pstmt.setString(1, p.getpBigNameEng());
			pstmt.setString(2, p.getpBigNameKor());
			pstmt.setString(3, p.getpName());
			pstmt.setInt(4, p.getpPriceA());
			pstmt.setInt(5, p.getpPriceC());
			pstmt.setDate(6, p.getpDateStart());
			pstmt.setDate(7, p.getpDateFinish());
			pstmt.setString(8, p.getpTime());
			pstmt.setString(9, p.getTitleImgPath());
			pstmt.setString(10, p.getpImgPath());
			pstmt.setString(11, p.getpInfo());
			pstmt.setString(12, p.getpPointInfo());
			pstmt.setString(13, p.getpIntd());
			pstmt.setString(14, p.getRuntime());
			pstmt.setString(15, p.getScheduleImgPath());
			pstmt.setString(16, p.getPrecaution());
			pstmt.setString(17, p.getpMapAddress());
			pstmt.setString(18, p.getpMap());
			pstmt.setString(19, p.getPartnerId());
			
			
			result=pstmt.executeUpdate();
      	}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
      }
		
		return result;
	}
	


	public int updateProduct(Connection conn, Product p) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			
//			updateProduct=UPDATE PRODUCT SET P_BIG_NAME_ENG=?, p_big_name_kor=?,p_name=?,
//			p_price_a=?,p_price_c=?,p_date_start=?,p_date_finish=?,p_time=?,
//			title_img_path=?,p_img_path=?,p_info=?,p_intd=?,p_point_info=?,runtime=?,
//			SChedule_img_path=?,precaution=?,p_map_address=?,p_map=? WHERE P_NUM=? AND PARTNER_ID=?
			
			pstmt=conn.prepareStatement(prop.getProperty("updateProduct"));
			pstmt.setString(1, p.getpBigNameEng());
			pstmt.setString(2, p.getpBigNameKor());
			pstmt.setString(3, p.getpName());
			pstmt.setInt(4, p.getpPriceA());
			pstmt.setInt(5, p.getpPriceC());
			pstmt.setDate(6, p.getpDateStart());
			pstmt.setDate(7, p.getpDateFinish());
			pstmt.setString(8, p.getpTime());
			pstmt.setString(9, p.getTitleImgPath());
			pstmt.setString(10, p.getpImgPath());
			pstmt.setString(11, p.getpInfo());
			pstmt.setString(12, p.getpIntd());
			pstmt.setString(13, p.getpPointInfo());
			pstmt.setString(14, p.getRuntime());
			pstmt.setString(15, p.getScheduleImgPath());
			pstmt.setString(16, p.getPrecaution());
			pstmt.setString(17, p.getpMapAddress());
			pstmt.setString(18, p.getpMap());
			pstmt.setInt(19, p.getpNum());
			pstmt.setString(20, p.getPartnerId());
			
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<payEnd> SelectPartnerOrderList(Connection conn,int cPage, int numPerPage,String partnerId){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<payEnd> list=new ArrayList();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectPartnerOrderList"));
			pstmt.setString(1, partnerId);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			rs=pstmt.executeQuery();
			/*
			 * PO_NUM PO_TYPE PO_DATE TOTAL_PRICE P_NUM USER_ID P_COUNT_A P_COUNT_C
			 * P_DATE_START PAY_USER_NAME PAY_ADDRESS PAY_PHONE PAY_EMAIL
			 */
			while(rs.next()) {
				payEnd pe=new payEnd();
				pe.setPayNum(rs.getInt("po_num"));
				pe.setPayType(rs.getString("po_type"));
				pe.setPayDate(rs.getDate("po_date"));
				pe.setTotalPrice(rs.getInt("total_price"));
				pe.setProductNum(rs.getInt("p_num"));
				pe.setUserId(rs.getString("user_id"));
				pe.setChildNum(rs.getInt("p_count_c"));
				pe.setAdultNum(rs.getInt("p_count_a"));
				pe.setDateStart(rs.getString("p_date_start"));
				pe.setPayName(rs.getString("pay_user_name"));
				pe.setPayAddress(rs.getString("pay_address"));
				pe.setPayPhone(rs.getString("pay_phone"));
				pe.setPayEmail(rs.getString("pay_email"));
				
				list.add(pe);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

	
	
	

	
	public int selectPartnerOrderListCount(Connection conn, String partnerId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectPartnerOrderListCount"));
			pstmt.setString(1, partnerId);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return count;
		
	}

	public Product titlePath(Connection conn,int num) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Product p=null;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("titlePath"));
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				p=new Product();
				p.setTitleImgPath(rs.getString(1));
				p.setpName(rs.getString(2));
					
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return p;
		

	}
	
	public payEnd selectOrder(Connection conn,int poNum) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		payEnd pe=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectOrder"));
			pstmt.setInt(1, poNum);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				pe=new payEnd();
				pe.setPayNum(rs.getInt("po_num"));
				pe.setPayType(rs.getString("po_type"));
				pe.setPayDate(rs.getDate("po_date"));
				pe.setTotalPrice(rs.getInt("total_price"));
				pe.setProductNum(rs.getInt("p_num"));
				pe.setUserId(rs.getString("user_id"));
				pe.setChildNum(rs.getInt("p_count_c"));
				pe.setAdultNum(rs.getInt("p_count_a"));
				pe.setDateStart(rs.getString("p_date_start"));
				pe.setPayName(rs.getString("pay_user_name"));
				pe.setPayAddress(rs.getString("pay_address"));
				pe.setPayPhone(rs.getString("pay_phone"));
				pe.setPayEmail(rs.getString("pay_email"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return pe;
	}
	
	


}//클래스


