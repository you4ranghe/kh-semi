package com.semi.board.model.service;

import static com.semi.common.JDBCTemplate.rollback;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.semi.board.model.dao.BoardDao;
import com.semi.board.model.vo.Board;

public class BoardService {

	private BoardDao dao = new BoardDao();

	public List<Board> getBoard(int cPage, int numPerPage) {

		Connection conn = getConnection();
		List<Board> boardList = dao.getBoard(cPage, numPerPage, conn);
		close(conn);
		return boardList;
	}

	public int getTotalDataCount() {
		Connection conn = getConnection();
		int result = dao.getTotalDataCount(conn);
		close(conn);
		return result;
	}

	public Board boardNo(int boardNo) {
		Connection conn = getConnection();
		Board b = dao.boardNo(boardNo, conn);
		close(conn);
		return b;
	}

	public int insertBoard(Board b) {
		Connection conn = getConnection();
		int result = dao.insertBoard(b, conn);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public List<Board> getSerchBoard(String serch, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Board> boardList = dao.getSerchBoard(serch, cPage, numPerPage, conn);
		close(conn);
		return boardList;
	}

	public int getSerchTotal(String serch) {
		Connection conn = getConnection();
		int result = dao.getSerchTotal(serch, conn);
		close(conn);
		return result;
	}

	public boolean checkHits(int boardNo, String userId) {
		Connection conn = getConnection();
		boolean check = dao.checkHits(boardNo, userId, conn);
		close(conn);
		return check;
	}

	public int addHits(int boardNo, String userId) {
		Connection conn = getConnection();

		int result = dao.addHits(boardNo, userId, conn);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateBoard(Board b) {
		Connection conn = getConnection();

		int result = dao.updateBoard(b, conn);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
