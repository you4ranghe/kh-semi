package com.semi.admin.model.dao;

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

import com.semi.common.AESCrypto;
import com.semi.member.model.vo.Member;
import com.semi.partner.model.vo.Partner;
import com.semi.payment.model.vo.Payment;
import com.semi.product.model.vo.Product;

public class AdminDao {
	
	private Properties prop=new Properties();
	
	public AdminDao() {
		try {
			String path=AdminDao.class.getResource("/sql/admin/admin_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//=================결제내역 dao========================
	//결제내역 리스트에 담아오고 페이징 처리 dao
	public List<Payment> selectPaymentList(Connection conn,int cPage, int numPerPage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Payment> list=new ArrayList();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectPaymentList"));
			pstmt.setInt(1,(cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				Payment p=new Payment();
				
				p.setPoNum(rs.getString("po_num"));
				p.setPoType(rs.getString("po_type"));
				p.setPoDate(rs.getString("po_date"));
				p.setTotalPrice(rs.getInt("total_price"));
				p.setpNum(rs.getInt("p_num"));
				p.setUserId(rs.getString("user_id"));
				p.setpCountA(rs.getInt("p_count_a"));
				p.setpCountC(rs.getInt("p_count_c"));
				p.setpDateStart(rs.getDate("p_date_start"));
				p.setPayUserNam(rs.getString("pay_user_name"));
				p.setPayAddress(rs.getString("pay_address"));
				p.setPayPhone(rs.getString("pay_phone"));
				p.setPayPhone(rs.getString("pay_email"));
				
				list.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	
	//결제내역 총 데이터객수 조회 dao
		public int selectPaymentCount(Connection conn) {
			
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			int count=0;
			try {
				pstmt=conn.prepareStatement(prop.getProperty("selectPaymentCount"));
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					count=rs.getInt(1);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}return count;
		}
		
		//검색키워드와 타입에 다른 결제내역 객체 리스트에 담아오는 dao
		public List<Payment> selectPaymentSearch(Connection conn,String type,String keyword,int cPage, int numPerpage){
			
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			List<Payment> list=new ArrayList();
			try {
				String sql=prop.getProperty("selectPaymentSearch");
				
				pstmt=conn.prepareStatement(sql.replace("$type",type));
				pstmt.setString(1, "%"+keyword+"%");
				pstmt.setInt(2, (cPage-1)*numPerpage+1);
				pstmt.setInt(3, cPage*numPerpage);
				
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					
					Payment p=new Payment();
					
					p.setPoNum(rs.getString("po_num"));
					p.setPoType(rs.getString("po_type"));
					p.setPoDate(rs.getString("po_date"));
					p.setTotalPrice(rs.getInt("total_price"));
					p.setpNum(rs.getInt("p_num"));
					p.setUserId(rs.getString("user_id"));
					p.setpCountA(rs.getInt("p_count_a"));
					p.setpCountC(rs.getInt("p_count_c"));
					p.setpDateStart(rs.getDate("p_date_start"));
					p.setPayUserNam(rs.getString("pay_user_name"));
					p.setPayAddress(rs.getString("pay_address"));
					p.setPayPhone(rs.getString("pay_phone"));
					p.setPayPhone(rs.getString("pay_email"));
					
					list.add(p);
				}

			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return list;
			
		}
		
		//검색키워드 타입에 다른 결제내역 객체 총 수 조회 dao
		public int selectPaymentSearchCount(Connection conn, String type, String keyword) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			int count=0;
			String sql=prop.getProperty("selectPaymentSearchCount");
			try {
				pstmt=conn.prepareStatement(sql.replace("$type",type));
				pstmt.setString(1,"%"+keyword+"%");
				
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					count=rs.getInt(1);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return count;
			
		}
		
	//결제 번호로 결제내역 테이블 가져오기
	public Payment selectPaymentOne(Connection conn, int poNum) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Payment p =null;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectPaymentOne"));
			pstmt.setInt(1, poNum);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				p=new Payment();
				
				p.setPoNum(rs.getString("po_num"));
				p.setPoType(rs.getString("po_type"));
				p.setPoDate(rs.getString("po_date"));
				p.setTotalPrice(rs.getInt("total_price"));
				p.setpNum(rs.getInt("p_num"));
				p.setUserId(rs.getString("user_id"));
				p.setpCountA(rs.getInt("p_count_a"));
				p.setpCountC(rs.getInt("p_count_c"));
				p.setpDateStart(rs.getDate("p_date_start"));
				p.setPayUserNam(rs.getString("pay_user_name"));
				p.setPayAddress(rs.getString("pay_address"));
				p.setPayPhone(rs.getString("pay_phone"));
				p.setPayPhone(rs.getString("pay_email"));

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return p;
		
		
		
	}
	
	//=================상품관리 dao========================
	//상품객체 리스트에 담아가기 dao
	public List<Product> selectProductList(Connection conn,int cPage, int numPerPage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectProductList"));
			pstmt.setInt(1,(cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				Product p=new Product();
				p.setpNum(rs.getInt("p_num"));
				p.setpName(rs.getString("p_name"));
				p.setpBigNameEng(rs.getString("p_big_name_eng"));
				p.setpBigNameKor(rs.getString("p_big_name_kor"));
				p.setTitleImgPath(rs.getString("title_img_path"));
				p.setpPriceC(rs.getInt("p_price_c"));
				p.setPartnerId(rs.getString("partner_id"));
				p.setpDateStart(rs.getDate("p_date_start"));
				p.setpDateFinish(rs.getDate("p_date_finish"));
				p.setpTime(rs.getString("p_time"));
				p.setpMapAddress(rs.getString("p_map_address"));
				p.setpMap(rs.getString("p_map"));
				
				list.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	//상품 객체 총 데이터 수 조회dao
	public int selectProductCount(Connection conn) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectProductCount"));
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}return count;
	}
	
	//검색키워드와 타입에 다른 상품객체 리스트에 담아오는 dao
	public List<Product> selectProductSearch(Connection conn,String type,String keyword,int cPage, int numPerpage){
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList();
		try {
			String sql=prop.getProperty("selectProductSearch");
			
			pstmt=conn.prepareStatement(sql.replace("$type",type));
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Product p=new Product();
				p.setpNum(rs.getInt("p_num"));
				p.setpName(rs.getString("p_name"));
				p.setpBigNameEng(rs.getString("p_big_name_eng"));
				p.setpBigNameKor(rs.getString("p_big_name_kor"));
				p.setTitleImgPath(rs.getString("title_img_path"));
				p.setpPriceC(rs.getInt("p_price_c"));
				p.setPartnerId(rs.getString("partner_id"));
				p.setpDateStart(rs.getDate("p_date_start"));
				p.setpDateFinish(rs.getDate("p_date_finish"));
				p.setpTime(rs.getString("p_time"));
				p.setpMapAddress(rs.getString("p_map_address"));
				p.setpMap(rs.getString("p_map"));
				
				list.add(p);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
		
	}
	//검색키워드 타입에 다른 상품객체 총 수 조회 dao
	public int selectProductSearchCount(Connection conn, String type, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		String sql=prop.getProperty("selectProductSearchCount");
		try {
			pstmt=conn.prepareStatement(sql.replace("$type",type));
			pstmt.setString(1,"%"+keyword+"%");
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return count;
		
		
	}
	
	//=================회원관리 dao========================
	//멤버 객체 리스트에 담아가기 dao
	public List<Member> selectMemberList(Connection conn,int cPage, int numPerPage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberList"));
			pstmt.setInt(1,(cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m=new Member();

				m.setUserNum(rs.getInt("user_num"));
				m.setUserId(rs.getString("user_id"));
				m.setPassword(rs.getString("password"));
				m.setUserName(rs.getString("user_name"));
				m.setAge(rs.getInt("age"));
				m.setGender(rs.getString("gender"));

				
				try {
					m.setEmail(AESCrypto.decrypt(rs.getString("email")));
					m.setPhone(AESCrypto.decrypt(rs.getString("phone")));
					System.out.println(m.getEmail()+m.getAddress());
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				m.setAddress(rs.getString("address"));	
				m.setEnrolldate(rs.getDate("enrolldate"));
				

				//생성된 회원을 List에 넣어주기
				list.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	
	//검색키워드와 타입에 다른 상품객체 리스트에 담아오는 dao
	public List<Member> selectMemberSearch(Connection conn, String type, 
			String keyword, int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> list=new ArrayList();
		try {
			String sql=prop.getProperty("selectMemberSearch");
			pstmt=conn.prepareStatement(sql.replace("$type",type));
			pstmt.setString(1, "%"+keyword+"%");
			//페이징처리
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			///
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m=new Member();

				m.setUserNum(rs.getInt("user_num"));

				m.setUserId(rs.getString("user_id"));
				m.setPassword(rs.getString("password"));
				m.setUserName(rs.getString("user_name"));
				m.setAge(rs.getInt("age"));
				m.setGender(rs.getString("gender"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setEnrolldate(rs.getDate("enrolldate"));
				//생성된 회원을 List에 넣어주기
				list.add(m);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	//멤버객체 총 데이터 수 dao
	public int selectMemberCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberCount"));
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}return count;
	}
	
	//검색키워드 타입에 다른 회원객체 총 수 조회 dao
	public int selectMemberSearchCount(Connection conn, String type, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		String sql=prop.getProperty("selectMemberSearchCount");
		try {
			/* value.type.replace("_", ""); */
			pstmt=conn.prepareStatement(sql.replace("$type",type));
			pstmt.setString(1,"%"+keyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return count;
	}
	

	//강제 회원 탈퇴 dao
	public int adminDeleteMember(Connection conn, String userId) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("adminDeleteMember"));
			pstmt.setString(1, userId);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	//=================파트너 관리 dao========================
	
	//파트너 정보 보기 조회 dao
	public List<Partner> selectPartnerList(Connection conn, int cPage,int numPerPage){
		PreparedStatement pstmt=null;
		List<Partner>list=new ArrayList();
		ResultSet rs= null;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectPartnerList"));
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Partner p =new Partner();
				p.setPartnerNum(rs.getInt("partner_num"));
				p.setIdCardImgOriginal(rs.getString("id_card_img_original"));
				p.setIdCardImgRename(rs.getString("id_card_img_rename"));
				p.setPartnerId(rs.getString("partner_id"));
				p.setPartnerImgOriginal(rs.getString("partner_img_original"));
				p.setPartnerImgRename(rs.getString("partner_img_rename"));
				p.setPartnerNick(rs.getString("partner_nick"));
				p.setpEnrolldate(rs.getDate("p_enrolldate"));
				p.setPartnerStatus(rs.getString("partner_status"));
		
				list.add(p);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;

	}
	
	//키워드로 검색된 회원수 조회 dao
		public int selectPartnerSearchCount(Connection conn, String type, String keyword) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			int count=0;
			String sql=prop.getProperty("selectPartnerSearchCount");
			try {
				/* value.type.replace("_", ""); */
				pstmt=conn.prepareStatement(sql.replace("$type",type));
				pstmt.setString(1,"%"+keyword+"%");
				rs=pstmt.executeQuery();
				if(rs.next()) {
					count=rs.getInt(1);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return count;
		}
		
	
//총 파트너 인원 조회 dao
	public int selectPartnerCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int totalCount=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectPartnerCount"));
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				totalCount=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			close(rs);
			close(pstmt);
		}return totalCount;
	}
	
	//타입,키워드에 다른 파트너 조회 dao
	public List<Partner> selectPartnerSearch(Connection conn,String type,String keyword,int cPage,int numPerPage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Partner>list=new ArrayList();
		
		try {
			String sql=prop.getProperty("selectPartnerSearch");
			pstmt=conn.prepareStatement(sql.replace("$type", type));
			pstmt.setString(1, "%"+keyword +"%");
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			
			rs=pstmt.executeQuery();
		
			while(rs.next()) {
				Partner p =new Partner();
				p.setPartnerNum(rs.getInt("partner_num"));
				p.setIdCardImgOriginal(rs.getString("id_card_img_original"));
				p.setIdCardImgRename(rs.getString("id_card_img_rename"));
				p.setPartnerId(rs.getString("partner_id"));
				p.setPartnerImgOriginal(rs.getString("partner_img_original"));
				p.setPartnerImgRename(rs.getString("partner_img_rename"));
				p.setPartnerNick(rs.getString("partner_nick"));
				p.setpEnrolldate(rs.getDate("p_enrolldate"));
				p.setPartnerStatus(rs.getString("partner_status"));
		
				list.add(p);
			}
	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	
	//파트너 탈퇴 dao
//	public int deletePartner(Connection conn, String partnerId) {
//		PreparedStatement pstmt=null;
//		int result=0;
//		
//		try {
//			pstmt=conn.prepareStatement(prop.getProperty("deletePartenr"));
//			pstmt.setString(1, partnerId);
//			
//			result=pstmt.executeUpdate();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close(pstmt);
//		}return result;
//	}
	
	//파트너 탈퇴 dao
	   public int deletePartner(Connection conn, String partnerId) {
	      PreparedStatement pstmt=null;
	      int result=0;
	      
	      try {
	         pstmt=conn.prepareStatement(prop.getProperty("deletePartenr"));
	         pstmt.setString(1, "N");
	         pstmt.setString(2, partnerId);
	         
	         result=pstmt.executeUpdate();
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	      }return result;
	   }
	
	
	//파트너 승인 dao
	public int acceptPartner(Connection conn,String partnerId) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("acceptPartner"));
			
			pstmt.setString(1, "Y");
			pstmt.setString(2, partnerId);
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
}//클래스













