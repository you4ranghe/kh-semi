package com.semi.goWithBoard.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.semi.board.model.vo.Board;
import com.semi.goWithBoard.model.dao.GowithDao;
import com.semi.goWithBoard.model.vo.GFile;
import com.semi.goWithBoard.model.vo.Gowith;

public class GowithService {
	
	private GowithDao dao = new GowithDao();
	
	public List<Gowith> getGowith(int cPage, int numPerPage){
		
		Connection conn = getConnection();
		List<Gowith> gowithList = dao.getGowith(cPage, numPerPage, conn);
		close(conn);
		return gowithList;
	}
	
	public int getTotalDataCount() {
		
		Connection conn = getConnection();
		int result = dao.getTotalDataCount(conn);
		close(conn);
		return result;
	}
	
	public List<Gowith> getSearchGowith(String serch, String searchType, int cPage, int numPerPage){
		Connection conn = getConnection();
		List<Gowith> gowithList = dao.getSearchGowith(serch, searchType, cPage, numPerPage, conn);
		close(conn);
		return gowithList;
	}
	
	public int getSearchTotal(String serch, String searchType) {
		Connection conn = getConnection();
		int result = dao.getSearchTotal(serch, searchType, conn);
		close(conn);
		return result;
	}
	
	public int insertGowith(Gowith g) {
		Connection conn = getConnection();
		int result = dao.insertGowith(g, conn);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int getGowithNoLast(String userId) {
		Connection conn = getConnection();
		int gowithNo = dao.getGowithNoLast(userId,conn);
		close(conn);
		return gowithNo;
	}
	
	public int insertGF(GFile gf) {
		Connection conn = getConnection();
		int gfresult = dao.insertGF(gf, conn);
		
		if(gfresult>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return gfresult;
	}
	
	public Gowith getGowithForNo(int gowithNo) {
		Connection conn = getConnection();
		Gowith g = dao.getGowithForNo(gowithNo, conn);
		close(conn);
		return g;
	}
	
	public List<GFile> getGFile(int gowithNo){
		Connection conn = getConnection();
		List<GFile> gfl = dao.getGFile(gowithNo, conn);
		close(conn);
		return gfl;
	}
	
	public boolean checkHits(int gowithNo, String userId) {
		Connection conn = getConnection();
		boolean check = dao.checkHits(gowithNo, userId, conn);
		close(conn);
		return check;
	}
	
	public int addHits(int gowithNo, String userId) {
		Connection conn = getConnection();

		int result = dao.addHits(gowithNo, userId, conn);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public int updateGowith(Gowith g) {
		Connection conn = getConnection();

		int result = dao.updateGowith(g, conn);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
}
