package com.semi.board.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.semi.board.model.dao.CommentDao;
import com.semi.board.model.vo.Comment;

public class CommentService {

	private CommentDao dao = new CommentDao();
	
	public List<Comment> getComment(int boardNo){
		
		Connection conn = getConnection();
		List<Comment> commentList = dao.getComment(boardNo, conn);
		close(conn);
		return commentList;
	}
	
	public int addComment(Comment c) {
		Connection conn = getConnection();
		int result = dao.addComment(c, conn);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}
