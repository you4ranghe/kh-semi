package com.semi.member.model.service;

import com.member.model.vo.Member;
import com.semi.member.model.dao.MemberDao;

import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.close;
import java.sql.Connection;
import java.sql.SQLException;

public class MemberService {
	
	private MemberDao dao=new MemberDao();
	
	public Member loginMember(String id,String pw) {
		Connection conn=getConnection();
		Member m=dao.loginMember(conn,id,pw);
		try {
			if(conn!=null) {
				conn.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
		
		
	}
}
