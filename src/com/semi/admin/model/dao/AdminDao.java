package com.semi.admin.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.member.model.vo.Member;
public class AdminDao {
	
	private Properties prop=new Properties();
	
	public AdminDao() {
		try {
			String path=AdminDao.class.getResource("/sql/admin/admin_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//전체회원 리스트 조회dao
	public List<Member> selectMemberList(Connection conn,int cPage, int numPerPage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberList"));
			pstmt.setInt(1,(cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m=new Member();
				m.setUserId(rs.getString("user_id"));
				m.setPassword(rs.getString("password"));
				m.setUserName(rs.getString("user_name"));
				m.setAge(rs.getInt("age"));
				m.setGender(rs.getString("gender"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setEnrolldate(rs.getDate("enrolldate"));
				//생성된 회원을 List에 넣어주기
				list.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	
	//키워드에 따른 검색된 회원 조회 서비스
	public List<Member> selectMemberSearch(Connection conn, String type, 
			String keyword, int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> list=new ArrayList();
		try {
			String sql=prop.getProperty("selectMemberSearch");
			pstmt=conn.prepareStatement(sql.replace("$type",type));
			pstmt.setString(1, "%"+keyword+"%");
			//페이징처리
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			///
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m=new Member();
				m.setUserId(rs.getString("user_id"));
				m.setPassword(rs.getString("password"));
				m.setUserName(rs.getString("user_name"));
				m.setAge(rs.getInt("age"));
				m.setGender(rs.getString("gender"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setEnrolldate(rs.getDate("enrolldate"));
				//생성된 회원을 List에 넣어주기
				list.add(m);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	//전체회원수 조회 dao
	public int selectMemberCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberCount"));
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}return count;
	}
	
	//키워드로 검색된 회원수 조회 dao
	public int selectMemberSearchCount(Connection conn, String type, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		String sql=prop.getProperty("selectMemberSearchCount");
		try {
			/* value.type.replace("_", ""); */
			pstmt=conn.prepareStatement(sql.replace("$type",type));
			pstmt.setString(1,"%"+keyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return count;
	}
	
	//강제 회원 탈퇴 dao
	public int adminDeleteMember(Connection conn, String userId) {
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("adminDeleteMember"));
			pstmt.setString(1, userId);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
}//클래스












