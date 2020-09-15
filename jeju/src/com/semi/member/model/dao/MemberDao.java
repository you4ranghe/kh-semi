package com.semi.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import static com.semi.common.JDBCTemplate.close;
import com.member.model.vo.Member;

public class MemberDao {
	private Properties prop=new Properties();
	
	
	public MemberDao() {
//      프로퍼티파일 가져오기
      try {
         String fileName=MemberDao.class.getResource("/sql/member/member_sql.properties").getPath();
         prop.load(new FileReader(fileName));
      }catch(IOException e) {
         e.printStackTrace();
      }
   }
	
	public Member loginMember(Connection conn,String id,String pw) {
		PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      Member m=null;
	      
	      try {
	         pstmt=conn.prepareStatement(prop.getProperty("selectMember"));
	         pstmt.setNString(1,id);
	         pstmt.setNString(2,pw);
	         rs=pstmt.executeQuery();
	         if(rs.next()) {
	            m=new Member();
	            m.setUserId(rs.getString("userId"));
	            m.setPassword(rs.getString("password"));
	            m.setUserName(rs.getString("username"));
	            m.setAge(rs.getInt("age"));
	            m.setGender(rs.getString("gender"));
	            m.setEmail(rs.getString("email"));
	            m.setPhone(rs.getString("phone"));
	            m.setAddress(rs.getString("address"));
	            m.setHobby(rs.getString("hobby"));
	            m.setEnrolldate(rs.getDate("enrolldate"));
	         }
	         
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rs);
	         close(pstmt);
	      }
	      
	      return m;
	}

}
