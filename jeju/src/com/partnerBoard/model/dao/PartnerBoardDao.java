package com.partnerBoard.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import static com.semi.common.JDBCTemplate.close;
import com.partnerBoard.model.vo.PartnerBoard;

public class PartnerBoardDao {
	private Properties prop=new Properties();

	
	public PartnerBoardDao() {
		try {
			String path=PartnerBoardDao.class.getResource("/sql/board/board_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	
	}

	public List<PartnerBoard> selectBoardList(Connection conn, int cPage,int numPerPage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<PartnerBoard> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectBordList"));
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				PartnerBoard p=new PartnerBoard();
				p.setBoardNo(rs.getInt("board_no"));
				p.setBoardTitle(rs.getString("board_title"));
				p.setBoardWriter(rs.getString("board_writer"));
				p.setBoardContent(rs.getNString("board_content"));
				p.setBoardOriginalFileName(rs.getString("board_original_filename"));
				p.setBoardRenamedFileName(rs.getString("board_renamed_filename"));
				p.setBoardDate(rs.getDate("board_date"));
				p.setBoardReadCount(rs.getInt("board_readcount"));
				list.add(p);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
		
	}
	
	public int selectBoardCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectBoardCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	
}
