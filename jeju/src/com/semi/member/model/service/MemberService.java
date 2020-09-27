package com.semi.member.model.service;


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
	
	//아이디로 회원 조회하기
	public Member selectMemberId(String userId) {
		Connection conn=getConnection();
		Member m = dao.selectMemberId(conn,userId); 
		close(conn);
		return m;
	}
	
	//회원정보 수정 서비스
	public int updateMember(Member m) {
		Connection conn=getConnection();
		int result=dao.updateMember(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//비밀번호 변경 서비스
	public int updatePassword(String userId, String password) {
		Connection conn=getConnection();
		int result=dao.updatePassword(conn,userId,password);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//회원탈퇴 서비스
	public int deleteMemer(String userId, String password){
		Connection conn=getConnection();
		int result=dao.deleteMemer(conn,userId,password);
		if(result>0)commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}



}
