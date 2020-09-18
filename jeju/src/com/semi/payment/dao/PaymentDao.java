package com.semi.payment.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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

		
			pstmt.setString(1,pm.getPoNum());
			pstmt.setString(2, pm.getPoType());
			pstmt.setDate(3, (Date) pm.getPoDate());
			pstmt.setDate(4, (Date) pm.getpDateStart());
			pstmt.setInt(5, pm.getTotalPrice());
			pstmt.setInt(6, pm.getpNum());
			pstmt.setString(7, pm.getUserId());
			pstmt.setInt(8, pm.getpCountA());
			pstmt.setInt(9, pm.getpCountC());

			System.out.println(pm.getPoNum());
			System.out.println(pm.getPoType());
			System.out.println(pm.getPoDate());
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
