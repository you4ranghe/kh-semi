package com.semi.admin.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.semi.admin.model.dao.AdminDao;
import com.semi.member.model.vo.Member;

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
	
	
}












