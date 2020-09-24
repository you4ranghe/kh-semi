package com.semi.payment.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.semi.payment.dao.PaymentDao;
import com.semi.payment.model.vo.Payment;

public class PaymentService {

	private PaymentDao dao = new PaymentDao();
	
	public int insertProduct(Payment pm) {
		Connection conn=getConnection();
		int result=dao.insertProduct(conn,pm);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}
