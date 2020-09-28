package com.semi.board.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.board.model.vo.Board;
public class BoardDao {

	private Properties prop = new Properties();

	public BoardDao() {
		String fileName = "";
		try {
			fileName = BoardDao.class.getResource("/sql/board/board_sql.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (NullPointerException e) {
			System.out.println("파일 경로를 찾을 수 없음 확인 바람");
			System.out.println("fileName (파일경로) : " + fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Board> getBoard(int cPage, int numPerPage, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> boardList = new ArrayList();

		try {
			pstmt = conn.prepareStatement(prop.getProperty("getBoard"));
			pstmt.setInt(1, (cPage - 1) * numPerPage + 1);
			pstmt.setInt(2, cPage * numPerPage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board b = new Board();
				b.setBoardNo(rs.getInt("BOARD_NO"));
				b.setBoardTitle(rs.getString("BOARD_TITLE"));
				b.setBoardContent(rs.getString("BOARD_CONTENT"));
				b.setUserId(rs.getString("USER_ID"));
				b.setOriginalFN(rs.getString("ORIGINAL_FN"));
				b.setRenameFN(rs.getString("RENAME_FN"));
				b.setBoardDate(rs.getDate("BOARD_DATE"));
				b.setBoardRecommend(rs.getInt("BOARD_RECOMMEND"));
				b.setBoardHits(rs.getInt("BOARD_HITS"));
				boardList.add(b);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardDao.getBoard() <<-- 에러 발생!!");
			System.out.println("cPage : " + cPage);
			System.out.println("numPerPage : " + numPerPage);
		} finally {
			close(rs);
			close(pstmt);
		}

		return boardList;

	}

	public int getTotalDataCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(prop.getProperty("getTotalDataCount"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("COUNT(*)");
			}
		} catch (Exception e) {

		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	public Board boardNo(int boardNo, Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board b = null;

		try {
			pstmt = conn.prepareStatement(prop.getProperty("boardNo"));
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				b = new Board();
				b.setBoardNo(rs.getInt("BOARD_NO"));
				b.setBoardTitle(rs.getString("BOARD_TITLE"));
				b.setBoardContent(rs.getString("BOARD_CONTENT"));
				b.setUserId(rs.getString("USER_ID"));
				b.setOriginalFN(rs.getString("ORIGINAL_FN"));
				b.setRenameFN(rs.getString("RENAME_FN"));
				b.setBoardDate(rs.getDate("BOARD_DATE"));
				b.setBoardRecommend(rs.getInt("BOARD_RECOMMEND"));
				b.setBoardHits(rs.getInt("BOARD_HITS"));
				
			} else {
				System.out.println("DB ResultSet에 아무것도 없음");
			}
		} catch (Exception e) {

		} finally {
			close(rs);
			close(pstmt);
		}

		return b;
	}

	public int insertBoard(Board b, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println(b);
		if (b.getOriginalFN() == null) {
			try {
				pstmt = conn.prepareStatement(prop.getProperty("insertBoardNullFile"));
				pstmt.setString(1, b.getBoardTitle());
				pstmt.setString(2, b.getBoardContent());
				pstmt.setString(3, b.getUserId());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		} else {
			try {
				pstmt = conn.prepareStatement(prop.getProperty("insertBoard"));
				pstmt.setString(1, b.getBoardTitle());
				pstmt.setString(2, b.getBoardContent());
				pstmt.setString(3, b.getUserId());
				pstmt.setString(4, b.getOriginalFN());
				pstmt.setString(5, b.getRenameFN());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		}
		return result;
	}

	public List<Board> getSearchBoard(String search, String searchType, int cPage, int numPerPage, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> boardList = new ArrayList();

		try {
			String sql = prop.getProperty("getSearchBoard");
			pstmt = conn.prepareStatement(sql.replace("$type", searchType));
			
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, (cPage - 1) * numPerPage + 1);
			pstmt.setInt(3, cPage * numPerPage);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board b = new Board();
				b.setBoardNo(rs.getInt("BOARD_NO"));
				b.setBoardTitle(rs.getString("BOARD_TITLE"));
				b.setBoardContent(rs.getString("BOARD_CONTENT"));
				b.setUserId(rs.getString("USER_ID"));
				b.setOriginalFN(rs.getString("ORIGINAL_FN"));
				b.setRenameFN(rs.getString("RENAME_FN"));
				b.setBoardDate(rs.getDate("BOARD_DATE"));
				b.setBoardRecommend(rs.getInt("BOARD_RECOMMEND"));
				b.setBoardHits(rs.getInt("BOARD_HITS"));
				boardList.add(b);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardDao.getBoard() <<-- 에러 발생!!");
			System.out.println("cPage : " + cPage);
			System.out.println("numPerPage : " + numPerPage);
		} finally {
			close(rs);
			close(pstmt);
		}

		return boardList;

	}

	public int getSearchTotal(String search, String searchType, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			String sql = prop.getProperty("getSearchTotal");
			pstmt = conn.prepareStatement(sql.replace("$type", searchType));
			pstmt.setString(1, "%" + search + "%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("COUNT(*)");
			}
		} catch (Exception e) {

		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}
	
	public boolean checkHits(int boardNo, String userId, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean check = false;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("checkHist"));
			pstmt.setString(1, userId);
			pstmt.setInt(2, boardNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return check;
	}
	public int addHits(int boardNo, String userId, Connection conn) {
		System.out.println("addHitsdao들어와짐");
		System.out.println("boardNo "+boardNo);
		System.out.println("userId "+userId);
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			System.out.println("트라이 들어옴");
			pstmt = conn.prepareStatement(prop.getProperty("addHits"));
			System.out.println("프로퍼티 에서 쿼리문 가져옴");
			System.out.println(prop.getProperty("addHits"));
			pstmt.setString(1, userId);
			pstmt.setInt(2, boardNo);
			result = pstmt.executeUpdate();
			System.out.println("업데이트 완료 ");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}System.out.println("addHist나감");
		return result;
		
	}
	
	public int updateBoard(Board b, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println("업데이트 보드 들어와짐?");
		if(b.getOriginalFN() == null) {
			//파일이 없을때 
			try {
				pstmt = conn.prepareStatement(prop.getProperty("updateBoardFN"));
				pstmt.setInt(1, b.getBoardNo());
				pstmt.setString(2, b.getBoardTitle());
				pstmt.setString(3, b.getBoardContent());
				pstmt.setString(4, b.getUserId());
				pstmt.setDate(5, new java.sql.Date(b.getBoardDate().getTime()));
				pstmt.setInt(6, b.getBoardRecommend());
				pstmt.setInt(7, b.getBoardHits());
				pstmt.setInt(8, b.getBoardNo());
				
				result = pstmt.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
		}else {
			//파일이 있을때
			try {
				pstmt = conn.prepareStatement(prop.getProperty("updateBoard"));
				pstmt.setInt(1, b.getBoardNo());
				pstmt.setString(2, b.getBoardTitle());
				pstmt.setString(3, b.getBoardContent());
				pstmt.setString(4, b.getUserId());
				pstmt.setString(5, b.getOriginalFN());
				pstmt.setString(6, b.getRenameFN());
				pstmt.setDate(7, new java.sql.Date(b.getBoardDate().getTime()));
				pstmt.setInt(8, b.getBoardRecommend());
				pstmt.setInt(9, b.getBoardHits());
				pstmt.setInt(10, b.getBoardNo());
				
				result = pstmt.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
		}
		
		return result;
	}

}
