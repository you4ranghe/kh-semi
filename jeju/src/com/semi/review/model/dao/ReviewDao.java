package com.semi.review.model.dao;


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

import com.semi.review.model.vo.Review;


public class ReviewDao {

	private Properties prop=new Properties();
	
	public ReviewDao() {
		try {
			String path=ReviewDao.class.getResource("/sql/review/review_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();	
		}
	}
	
	
	public int insertReview(Connection conn, Review r) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertReview"));
			pstmt.setInt(1,r.getReviewScore());
			pstmt.setString(2, r.getReviewTitle());
			pstmt.setString(3, r.getReviewContents());
			pstmt.setString(4, r.getReviewWriter());
//			pstmt.setString(5, r.getPoNum());
			pstmt.setInt(5, r.getpNum());
			
			System.out.println(r.getReviewScore());
			System.out.println(r.getReviewTitle());
			System.out.println(r.getReviewContents());
			System.out.println(r.getReviewWriter());
			//System.out.println(r.getPoNum());
			System.out.println(r.getpNum());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	public List<Review> selectReviewList(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Review> list = new ArrayList();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectReviewList"));
//			pstmt. setInt(1,no);

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

				
				list.add(r);
				
				

				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return list;
	}
	
	
	
	

	
	public int selectReviewCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectReviewCount"));
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
	
	
}
