package com.semi.admin.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.semi.admin.model.dao.AdminDao;
import com.semi.member.model.vo.Member;

public class AdminService {

	private AdminDao dao=new AdminDao();
	
	//회원정보보기 서비스
	public List<Member> selectMemberList(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Member> list=dao.selectMemberList(conn,cPage,numPerpage);
		close(conn);
		return list;
	}
	
	//키워드로 회원정보고 검색 서비스
	public List<Member> selectMemberSearch(String type, String keyword,int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Member> list=dao.selectMemberSearch(conn,type, keyword,cPage,numPerpage);
		close(conn);
		return list;
	}
	
	//전체 회원수 조회 서비스
	public int selectMemberCount() {
		Connection conn=getConnection();
		int count=dao.selectMemberCount(conn);
		close(conn);
		return count;
	}
	
	//검색한 회원수 조회 서비스
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
	
	
}












