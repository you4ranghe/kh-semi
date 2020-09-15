package com.partnerBoard.model.service;


import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.partnerBoard.model.dao.PartnerBoardDao;
import com.partnerBoard.model.vo.PartnerBoard;

public class PartnerBoardService {
	
	private PartnerBoardDao dao=new PartnerBoardDao(); 
	
	public List<PartnerBoard> selectBoardList(int cPage,int numPerPage) {
		Connection conn=getConnection();
		List<PartnerBoard> list=dao.selectBoardList(conn,cPage,numPerPage);
		close(conn);
		return list;
		
	}
	
	public int selectBoardCount() {
		Connection conn=getConnection();
		int count=dao.selectBoardCount(conn);
		close(conn);
		return count;
	}
	

}
