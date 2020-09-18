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

		
			pstmt.setString(1, pm.getpDateStart());
			pstmt.setString(2, pm.getpDateFinish());
			pstmt.setString(3, pm.getpCountA());
			pstmt.setString(4, pm.getpCountC());
			pstmt.setString(5, pm.getpTime());
			pstmt.setString(6, pm.getTotalPrice());

			System.out.println(pm.getTotalPrice());
			System.out.println(pm.getpDateFinish());
			System.out.println(pm.getpDateStart());
			System.out.println(pm.getpCountA());
			System.out.println(pm.getpCountC());
			System.out.println(pm.getpTime());
			
			
			result=pstmt.executeUpdate();
			 
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
}
