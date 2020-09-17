package com.semi.member.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.semi.member.model.vo.Member;



public class MemberDao {
	
	private Properties prop= new Properties();
	
	public MemberDao() {
		
		try {
			String fileName=MemberDao.class.getResource("/sql/member/member_sql.properties").getPath();
			prop.load(new FileReader(fileName));
		}catch(IOException e) {
			e.printStackTrace();
		}


	}
	//로그인 dao
	public Member loginMember(Connection conn, String id, String pw) {
		
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		Member m =null;
		
		try {
			pstmt= conn.prepareStatement(prop.getProperty("loginMember"));
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
			m=new Member();
			m.setUserNum(rs.getInt("user_num"));
			m.setUserId(rs.getString("user_id"));
			m.setPassword(rs.getString("password"));
			m.setUserName(rs.getString("user_name"));
			m.setGender(rs.getString("gender"));
			m.setAge(rs.getInt("age"));
			m.setEmail(rs.getString("email"));
			m.setPhone(rs.getString("phone"));
			m.setAddress(rs.getString("address"));
			m.setEnrolldate(rs.getDate("enrolldate"));

			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(conn);
		}return m;
		
		
	}

}
