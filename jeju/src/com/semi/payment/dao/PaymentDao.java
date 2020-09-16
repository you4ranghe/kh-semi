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
//			pstmt.setString(1, pm.getPoNum());
//			pstmt.setInt(2, pm.getpNum());
//			pstmt.setString(3, pm.getPoType());
//			pstmt.setString(4, pm.getPoDate());
			pstmt.setInt(1, pm.getpCountA());
			pstmt.setInt(2, pm.getpCountC());
			pstmt.setString(3, pm.getpDateStart());
			pstmt.setString(4, pm.getpDateFinish());
			pstmt.setString(5, pm.getpTime());
			pstmt.setInt(6, pm.getTotalPrice());
			
			result=pstmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
}
