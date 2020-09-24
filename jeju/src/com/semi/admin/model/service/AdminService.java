package com.semi.admin.model.service;

import static com.semi.common.JDBCTemplate.close;

import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;


import java.sql.Connection;
import java.util.List;

import com.semi.admin.model.dao.AdminDao;
import com.semi.member.model.vo.Member;

import com.semi.partner.model.vo.Partner;


public class AdminService {

	private AdminDao dao=new AdminDao();
	
	public List<Member> selectMemberList(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Member> list=dao.selectMemberList(conn,cPage,numPerpage);
		close(conn);
		return list;
	}
	

	public List<Member> selectMemberSearch(String type, String keyword,int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Member> list=dao.selectMemberSearch(conn,type, keyword,cPage,numPerpage);
		close(conn);
		return list;
	}
	

	public int selectMemberCount() {
		Connection conn=getConnection();
		int count=dao.selectMemberCount(conn);
		close(conn);
		return count;
	}

	public int selectMemberSearchCount(String type, String keyword) {
		Connection conn=getConnection();
		int count=dao.selectMemberSearchCount(conn,type, keyword);
		close(conn);
		return count;
	}
	

	//강제 회원 탈퇴 서비스
	public int adminDeleteMember(String userId) {
		Connection conn=getConnection();
		int result=dao.adminDeleteMember(conn,userId);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//파트너 정보 보기 서비스
	public List<Partner> selectPartnerList(int cPage,int numPerPage){
		Connection conn=getConnection();
		List<Partner>list =dao.selectPartnerList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	//검색한 파트너 조회 서비스
	public int selectPartnerSearchCount(String type, String keyword) {
		Connection conn=getConnection();
		int count=dao.selectPartnerSearchCount(conn,type, keyword);
		close(conn);
		return count;
	}
	
	//총파트너 인원 가져오는 서비스
	public int selectPartnerCount() {
		Connection conn = getConnection();
		int totalCount = dao.selectPartnerCount(conn);
		close(conn);
		return totalCount;
	}
	
	//타입,키워드에 다른 파트너 조회 서비스
	public List<Partner> selectPartnerSearch(String type, String keyword,int cPage,int numPerPage){
		Connection conn=getConnection();
		List<Partner>list=dao.selectPartnerSearch(conn,type,keyword,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	//파트너 탈퇴 서비스
	public int deletePartner(String partnerId) {
		Connection conn = getConnection();
		int result =dao.deletePartner(conn,partnerId);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	
	//파트너 승인 서비스
	public int acceptPartner(String partnerId) {
		Connection conn= getConnection();
		int result=dao.acceptPartner(conn,partnerId);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	

	
}












