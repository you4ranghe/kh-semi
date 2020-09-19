package com.semi.payment.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.semi.payment.model.vo.Payment;

public class PaymentDao {

	private Properties prop = new Properties();
	
	public PaymentDao() {
		try {
			String fileName=PaymentDao.class.getResource("/sql/payment/payment_sql.properties").getPath();
			prop.load(new FileReader(fileName));		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int insertProduct(Connection conn, Payment pm) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertProduct"));

		

			pstmt.setDate(1, pm.getpDateStart());
			pstmt.setInt(2, pm.getTotalPrice());
			pstmt.setInt(3, pm.getpNum());
			pstmt.setString(4, pm.getUserId());
			pstmt.setInt(5, pm.getpCountA());
			pstmt.setInt(6, pm.getpCountC());


			System.out.println(pm.getpDateStart());
			System.out.println(pm.getTotalPrice());
			System.out.println(pm.getpNum());
			System.out.println(pm.getUserId());
			System.out.println(pm.getpCountA());
			System.out.println(pm.getpCountC());
			
			result=pstmt.executeUpdate();
			 
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
}
