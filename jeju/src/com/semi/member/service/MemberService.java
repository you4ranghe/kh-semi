package com.semi.member.service;

import java.sql.Connection;

import com.semi.member.model.dao.MemberDao;
import com.semi.member.model.vo.Member;
import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.rollback;

public class MemberService {
	
	private MemberDao dao=new MemberDao();
	
	//로그인 서비스
	public Member loginMember(String id, String pw) {
		Connection conn =getConnection();
		Member m = dao.loginMember(conn, id, pw);
		
		close(conn);
		return m;

	}
	
	//회원가입 서비스
	public int insertMember(Member m) {
		Connection conn =getConnection();
		int result=dao.insertMember(conn,m);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	

}
