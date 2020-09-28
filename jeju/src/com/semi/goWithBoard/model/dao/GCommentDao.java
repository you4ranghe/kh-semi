package com.semi.goWithBoard.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.board.model.vo.Comment;
import com.semi.goWithBoard.model.vo.GComment;

public class GCommentDao {

private Properties prop = new Properties();
	
	public GCommentDao() {
		String fileName = "";
		try {
			fileName = GCommentDao.class.getResource("/sql/gowith/comment_sql.properties").getPath();
			prop.load(new FileReader(fileName));
		}catch(NullPointerException e) {
			System.out.println("파일 경로를 찾을 수 없음 확인 바람");
			System.out.println("fileName (파일경로) : "+fileName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<GComment> getComment(int gowithNo, Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GComment> commentList = new ArrayList();
		System.out.println("getComment 들어옴");
		try {
			pstmt = conn.prepareStatement(prop.getProperty("getComment"));
			pstmt.setInt(1, gowithNo);
			System.out.println(" getComment 안에  boardNo : "+gowithNo);
			rs = pstmt.executeQuery();
			System.out.println(prop.getProperty("getComment"));
			while(rs.next()) {
				System.out.println("rs안에 들어옴");
				GComment gc = new GComment();
				gc.setUserId(rs.getString("USER_ID"));
				gc.setGowithNo(rs.getInt("GOWITH_NO"));
				gc.setgComment(rs.getString("G_COMMENT"));
				gc.setCommentPosition(rs.getInt("COMMENT_POSITION"));
				gc.setReplyPosition(rs.getInt("REPLY_POSITION"));
				gc.setWriteDate(rs.getDate("WRITE_DATE"));
				System.out.println("\n");
				System.out.println(gc);
				System.out.println("\n");
				commentList.add(gc);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return commentList;
	}
	
	public int addComment(GComment gc, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("addComment"));
			pstmt.setInt(1, gc.getGowithNo());
			pstmt.setString(2, gc.getUserId());
			pstmt.setString(3, gc.getgComment());
			pstmt.setInt(4, gc.getCommentPosition());
			pstmt.setInt(5, gc.getReplyPosition());
			result = pstmt.executeUpdate();
			System.out.println("Comment : "+gc);
			System.out.println("result : "+result);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
