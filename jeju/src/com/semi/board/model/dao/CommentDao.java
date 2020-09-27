package com.semi.board.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.board.model.vo.Comment;

public class CommentDao {
	
	private Properties prop = new Properties();
	
	public CommentDao() {
		String fileName = "";
		try {
			fileName = CommentDao.class.getResource("/sql/board/comment_sql.properties").getPath();
			prop.load(new FileReader(fileName));
		}catch(NullPointerException e) {
			System.out.println("파일 경로를 찾을 수 없음 확인 바람");
			System.out.println("fileName (파일경로) : "+fileName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Comment> getComment(int boardNo, Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Comment> commentList = new ArrayList();
		System.out.println("getComment 들어옴");
		try {
			pstmt = conn.prepareStatement(prop.getProperty("getComment"));
			pstmt.setInt(1, boardNo);
			System.out.println(" getComment 안에  boardNo : "+boardNo);
			rs = pstmt.executeQuery();
			System.out.println(prop.getProperty("getComment"));
			System.out.println("try문 안에 들어옴");
			while(rs.next()) {
				System.out.println("rs안에 들어옴");
				Comment c = new Comment();
				c.setUserId(rs.getString("USER_ID"));
				c.setBoardNo(rs.getInt("BOARD_NO"));
				c.setCommentContent(rs.getString("COMMENT_CONTENT"));
				c.setCommentPosition(rs.getInt("COMMENT_POSITION"));
				c.setReplyPosition(rs.getInt("REPLY_POSITION"));
				System.out.println("\n");
				System.out.println(c);
				System.out.println("\n");
				commentList.add(c);
				
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
	
	public int addComment(Comment c, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("addComment"));
			pstmt.setString(1, c.getUserId());
			pstmt.setInt(2, c.getBoardNo());
			pstmt.setString(3, c.getCommentContent());
			pstmt.setInt(4, c.getCommentPosition());
			pstmt.setInt(5, c.getReplyPosition());
			result = pstmt.executeUpdate();
			System.out.println("Comment : "+c);
			System.out.println("result : "+result);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
