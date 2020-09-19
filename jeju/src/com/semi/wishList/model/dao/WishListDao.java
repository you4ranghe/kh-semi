package com.semi.wishList.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.semi.payment.dao.PaymentDao;
import com.semi.wishList.model.vo.WishList;

public class WishListDao {


	private Properties prop = new Properties();
	
	public WishListDao() {
		try {
			String fileName=PaymentDao.class.getResource("/sql/wish/wish_sql.properties").getPath();
			prop.load(new FileReader(fileName));		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int insertWishList(Connection conn, WishList wl) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt= conn.prepareStatement(prop.getProperty("insertWishList"));
			
			pstmt.setString(1, wl.getUserId());
			pstmt.setInt(2, wl.getpNum());
			
			
			System.out.println(wl.getpNum());
			System.out.println(wl.getUserId());
			
			result=pstmt.executeUpdate();
		 
		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}return result;

	}
	
}
