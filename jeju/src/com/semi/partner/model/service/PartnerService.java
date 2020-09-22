package com.semi.partner.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.semi.partner.model.dao.PartnerDao;
import com.semi.partner.model.vo.Partner;

public class PartnerService {
	
	private PartnerDao dao=new PartnerDao();
	
	//파트너 등록 서비스
	public int insertPartner(Partner p) {
		Connection conn=getConnection();
		int result= dao.insertPartner(conn, p);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//파트너 아이디로 조회하는 서비스
	public Partner selectPartner(String userId) {
		Connection conn=getConnection();
		Partner p = dao.selectPartner(conn, userId);
		close(conn);
		return p;
	}
	
	//파트너 정보 수정 서비스
	public int updatePartner(Partner p) {
		Connection conn=getConnection();
		int result = dao.updatePartner(conn,p);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//파트너 탈퇴 서비스
	public int deletePartner(String partnerId) {
		Connection conn=getConnection();
		int result=dao.deletePartner(conn,partnerId);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}
