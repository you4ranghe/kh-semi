package com.semi.goWithBoard.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.semi.goWithBoard.model.dao.GCommentDao;
import com.semi.goWithBoard.model.vo.GComment;

public class GCommentService {
private GCommentDao dao = new GCommentDao();
	
	public List<GComment> getComment(int gowithNo){
		
		Connection conn = getConnection();
		List<GComment> commentList = dao.getComment(gowithNo, conn);
		close(conn);
		return commentList;
	}
	
	public int addComment(GComment gc) {
		Connection conn = getConnection();
		int result = dao.addComment(gc, conn);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}
