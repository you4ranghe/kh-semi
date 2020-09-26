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
import com.semi.product.model.vo.Wish;
import com.semi.review.model.vo.Review;


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
	
	public List<Product> selectAllProductList(Connection conn,int cPage,int numPerPage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectProductList2"));
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
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
	
	
	
	
	
	
	
	
	
	public List<Product> selectProductList(Connection conn, int pNum){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList();

		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectProductList"));
			pstmt.setInt(1, pNum);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				Product p = new Product();

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
               p.setpMapAddress(rs.getString("p_map_address"));
               p.setpMap(rs.getString("p_map"));
               p.setpScore(rs.getInt("p_score"));
               p.setPartnerId(rs.getString("partner_id"));
	               
	           list.add(p);
	           
	    
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		
			
		}return list;
	}
	
	
	
	
	
	
	
	
	public Product selectProductOne(Connection conn, int pNum) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Product p =null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectProductOne"));
			pstmt.setInt(1, pNum);
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
		}return p;
		
	}
	
	
	
	
	public List<Product> selectSearchProductList(Connection conn,String search,int cPage,int numPerPage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectSearchProductList"));

			pstmt.setString(1, "%"+search+"%");
			pstmt.setString(2, "%"+search+"%");
			pstmt.setString(3, "%"+search+"%");
			pstmt.setString(4, "%"+search+"%");
			pstmt.setInt(5, (cPage-1)*numPerPage+1);
			pstmt.setInt(6, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setpNum(rs.getInt("p_num"));
				p.setpName(rs.getString("p_name"));
				p.setpBigNameEng(rs.getString("p_big_name_eng"));
				p.setpBigNameKor(rs.getString("p_big_name_kor"));
				p.setpMap(rs.getString("p_map_address"));
				p.setTitleImgPath(rs.getString("img_path"));
				list.add(p);
				
			}
			for(Product p:list) {
				System.out.println("상품이름"+p.getpName());
			}
			System.out.println();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return list;
	}
	
	
	
	
	
	public int selectProductCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectProductCount"));

			rs=pstmt.executeQuery();
		
			if(rs.next()) {
				result=rs.getInt(1);
			}
			System.out.println("전체 상품 몇개?"+ result);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}
	
	public int selectSearchProductCount(Connection conn,String search) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectSearchProductCount"));

			pstmt.setString(1, "%"+search+"%");
			pstmt.setString(2, "%"+search+"%");
			pstmt.setString(3, "%"+search+"%");
			pstmt.setString(4, "%"+search+"%");
			rs=pstmt.executeQuery();
		
			if(rs.next()) {
				result=rs.getInt(1);
			}
			System.out.println("검색된 상품 몇개?"+ result);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}
	
	public int clickHeart(Connection conn,int productNum,String userId) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("clickHeart"));
			pstmt.setString(1, userId);
			pstmt.setInt(2, productNum);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	public List<Wish> checkWish(Connection conn, String userId) {
		PreparedStatement pstmt=null;
		List<Wish> wishlist=new ArrayList();
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("checkWish"));
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Wish w=new Wish();
				w.setpNum(rs.getInt("p_num"));
				w.setUserId(rs.getString("use_id"));
				wishlist.add(w);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return wishlist;
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
//			pstmt.setString(19, p.getPartnerId());
			pstmt.setString(19, "user01");
			
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateProduct(Connection conn,Product p) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateProduct"));
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/////////리뷰
	
	public int confirmReview(Connection conn, Review r) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("confirmReview"));

			pstmt.setInt(1, r.getpNum());
			pstmt.setString(2, r.getUserId());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	
	public int insertReview(Connection conn, Review r) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertReview"));
			System.out.println(prop.getProperty("insertReview"));
			pstmt.setInt(1,r.getReviewScore());
			pstmt.setString(2, r.getReviewTitle());
			pstmt.setString(3, r.getReviewContents());
			pstmt.setString(4, r.getReviewWriter());
			
			pstmt.setInt(5, r.getpNum());
			pstmt.setString(6, r.getUserId());
			pstmt.setInt(7, r.getpNum());
			pstmt.setString(8, r.getUserId());


			
			System.out.println(r.getReviewScore());
			System.out.println(r.getReviewTitle());
			System.out.println(r.getReviewContents());
			System.out.println(r.getReviewWriter());
			System.out.println(r.getPoNum());
			System.out.println(r.getpNum());
			System.out.println(r.getUserId());
			

			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	
	public List<Review> selectReviewList(Connection conn, int pNum){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Review> list = new ArrayList();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectReviewList"));
			pstmt. setInt(1,pNum);

			rs = pstmt.executeQuery();
	
			while(rs.next()) {
				Review r = new Review();
				r.setReviewNum(rs.getInt(1));
				r.setReviewScore(rs.getInt(2));
				r.setReviewTitle(rs.getString(3));
				r.setReviewContents(rs.getString(4));
				r.setReviewWriter(rs.getString(5));
				r.setPoNum(rs.getString(6));
				r.setRegisterDate(rs.getDate(7));
				r.setReviewViews(rs.getInt(8));
				r.setpNum(rs.getInt(9));
				r.setUserId(rs.getString(10));
				

				list.add(r);
				System.out.println("리스트dao="+list);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return list;
	}
	
	
	
	public int reviewModify(Connection conn, Review r) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("reviewModify"));

			pstmt.setInt(1,r.getReviewScore());
			pstmt.setString(2, r.getReviewTitle());
			pstmt.setString(3, r.getReviewContents());
			pstmt.setString(4, r.getReviewWriter());
			pstmt.setString(5, r.getPoNum());
			pstmt.setInt(6, r.getpNum());
			pstmt.setString(7, r.getUserId());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	
	}
	
	
	
	public List<Review> selectReviewModifyList(Connection conn, String userId, int reviewNum){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Review> list = new ArrayList();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectReviewModifyList"));
			pstmt. setString(1,userId);
			pstmt.setInt(2, reviewNum);

			rs = pstmt.executeQuery();
	
			while(rs.next()) {
				Review r = new Review();
				r.setReviewNum(rs.getInt(1));
				r.setReviewScore(rs.getInt(2));
				r.setReviewTitle(rs.getString(3));
				r.setReviewContents(rs.getString(4));
				r.setReviewWriter(rs.getString(5));
				r.setPoNum(rs.getString(6));
				r.setRegisterDate(rs.getDate(7));
				r.setReviewViews(rs.getInt(8));
				r.setpNum(rs.getInt(9));
				r.setUserId(rs.getString(10));
				

				list.add(r);
				System.out.println("모디파이리스트dao="+list);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return list;
	}
	
	
	
	
	
	public int deleteReview(Connection conn, String userId, int reviewNum) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteReview"));
			pstmt.setNString(1, userId);
			pstmt.setInt(2, reviewNum);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
				
	}
	
	
}
