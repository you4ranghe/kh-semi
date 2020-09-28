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

import com.semi.board.model.vo.Board;
import com.semi.goWithBoard.model.vo.GFile;
import com.semi.goWithBoard.model.vo.Gowith;

public class GowithDao {
	
	private Properties prop = new Properties();
	
	public GowithDao() {
		String fileName = "";
		try {
			fileName = GowithDao.class.getResource("/sql/gowith/gowith_sql.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (NullPointerException e) {
			System.out.println("파일 경로를 찾을 수 없음 확인 바람");
			System.out.println("fileName (파일경로) : " + fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Gowith> getGowith(int cPage, int numPerPage, Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Gowith> gowithList = new ArrayList();
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("getGowith"));
			pstmt.setInt(1, (cPage - 1) * numPerPage + 1);
			pstmt.setInt(2, cPage * numPerPage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Gowith g = new Gowith(rs.getInt("GOWITH_NO"),rs.getString("USER_ID"),rs.getString("GOWITH_TITLE"),rs.getDate("WRITE_DATE"),rs.getDate("TRAVEL_START"),rs.getDate("TRAVEL_END"),rs.getDate("RECRUITMENT_END"),rs.getString("SCHEDULE"),rs.getString("DESTINATION"),rs.getInt("TOTAL_PERSON"),rs.getInt("RECRUITMENT_PERSON"),rs.getInt("NOW_GENDER_M"),rs.getInt("NOW_GENDER_F"),rs.getInt("RECRUITMENT_GENDER_M"),rs.getInt("RECRUITMENT_GENDER_F"),rs.getString("CONTACT"),rs.getString("COMMENTS"),rs.getInt("G_RECOMMEND"),rs.getInt("G_HITS"));
				gowithList.add(g);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(conn);
		}return gowithList;
	}
	
	public int getTotalDataCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("getTotalDataCount"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("COUNT(*)");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
		
	}
	
	public List<Gowith> getSearchGowith(String search, String searchType, int cPage, int numPerPage, Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Gowith> gowithList = new ArrayList();
		
		try {
			String sql = prop.getProperty("getSearchGowith");
			pstmt = conn.prepareStatement(sql.replace("$type", searchType));
			
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, (cPage - 1) * numPerPage + 1);
			pstmt.setInt(3, cPage * numPerPage);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Gowith g = new Gowith(rs.getInt("GOWITH_NO"),rs.getString("USER_ID"),rs.getString("GOWITH_TITLE"),rs.getDate("WRITE_DATE"),rs.getDate("TRAVEL_START"),rs.getDate("TRAVEL_END"),rs.getDate("RECRUITMENT_END"),rs.getString("SCHEDULE"),rs.getString("DESTINATION"),rs.getInt("TOTAL_PERSON"),rs.getInt("RECRUITMENT_PERSON"),rs.getInt("NOW_GENDER_M"),rs.getInt("NOW_GENDER_F"),rs.getInt("RECRUITMENT_GENDER_M"),rs.getInt("RECRUITMENT_GENDER_F"),rs.getString("CONTACT"),rs.getString("COMMENTS"),rs.getInt("G_RECOMMEND"),rs.getInt("G_HITS"));
				gowithList.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return gowithList;
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
	
	public int insertGowith(Gowith g, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertGowith"));
			pstmt.setString(1, g.getUserId());
			pstmt.setString(2, g.getGowithTitle());
			pstmt.setDate(3, new java.sql.Date(g.getTravelStart().getTime()));
			pstmt.setDate(4, new java.sql.Date(g.getTravelEnd().getTime()));
			pstmt.setDate(5, new java.sql.Date(g.getRecruitmentEnd().getTime()));
			pstmt.setString(6, g.getSchedule());
			pstmt.setString(7, g.getDestination());
			pstmt.setInt(8, g.getTotalPerson());
			pstmt.setInt(9, g.getRecruitmentPerson());
			pstmt.setInt(10, g.getNowGenderM());
			pstmt.setInt(11, g.getNowGenderF());
			pstmt.setInt(12, g.getRecruitmentGenderM());
			pstmt.setInt(13, g.getRecruitmentGenderF());
			pstmt.setString(14, g.getContact());
			pstmt.setString(15, g.getComment());
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int getGowithNoLast(String userId, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int gowithNo = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("getGowithNoLast"));
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			rs.next();
			gowithNo = rs.getInt("GOWITH_NO");
			System.out.println("======================= getGowithNoLast ======================");
			System.out.println("gowithNo : "+gowithNo);
			System.out.println("==============================================================");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return gowithNo;
	}
	
	public int insertGF(GFile gf, Connection conn) {
		PreparedStatement pstmt = null;
		int gfresult = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("insertGF"));
			pstmt.setInt(1, gf.getGowithNo());
			pstmt.setString(2, gf.getFileName());
			pstmt.setString(3, gf.getFileRename());
			gfresult = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return gfresult;
	}
	
	public Gowith getGowithForNo(int gowithNo, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		Gowith g = null;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("getGowithForNo"));
			pstmt.setInt(1, gowithNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				g = new Gowith();
				g.setGowhitNo(rs.getInt("GOWITH_NO"));
				g.setUserId(rs.getString("USER_ID"));
				g.setGowithTitle(rs.getString("GOWITH_TITLE"));
				g.setWriteDate(rs.getDate("WRITE_DATE"));
				g.setTravelStart(rs.getDate("TRAVEL_START"));
				g.setTravelEnd(rs.getDate("TRAVEL_END"));
				g.setRecruitmentEnd(rs.getDate("RECRUITMENT_END"));
				g.setSchedule(rs.getString("SCHEDULE"));
				g.setDestination(rs.getString("DESTINATION"));
				g.setTotalPerson(rs.getInt("TOTAL_PERSON"));
				g.setRecruitmentPerson(rs.getInt("RECRUITMENT_PERSON"));
				g.setNowGenderM(rs.getInt("NOW_GENDER_M"));
				g.setNowGenderF(rs.getInt("NOW_GENDER_F"));
				g.setRecruitmentGenderM(rs.getInt("RECRUITMENT_GENDER_M"));
				g.setRecruitmentGenderF(rs.getInt("RECRUITMENT_GENDER_F"));
				g.setContact(rs.getString("CONTACT"));
				g.setComment(rs.getString("COMMENTS"));
				g.setgRecommend(rs.getInt("G_RECOMMEND"));
				g.setgHits(rs.getInt("G_HITS"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return g;
		
	}
	
	public List<GFile> getGFile(int gowithNo, Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GFile> gfl = new ArrayList();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("getGFile"));
			pstmt.setInt(1, gowithNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GFile gf = new GFile();
				gf.setFileName(rs.getString("FILE_NAME"));
				gf.setFileRename(rs.getString("FILE_RENAME"));
				gfl.add(gf);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return gfl;
	}
	
	public boolean checkHits(int gowithNo, String userId, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean check = false;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("checkHist"));
			pstmt.setString(1, userId);
			pstmt.setInt(2, gowithNo);
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
	
	public int addHits(int gowithNo, String userId, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(prop.getProperty("addHits"));
			pstmt.setString(1, userId);
			pstmt.setInt(2, gowithNo);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int updateGowith(Gowith g, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
			try {
				pstmt = conn.prepareStatement(prop.getProperty("updateGowith"));
				pstmt.setInt(1, g.getGowhitNo());
				pstmt.setString(2, g.getUserId());
				pstmt.setString(3, g.getGowithTitle());
				pstmt.setDate(4, new java.sql.Date(g.getWriteDate().getTime()));
				pstmt.setDate(5, new java.sql.Date(g.getTravelStart().getTime()));
				pstmt.setDate(6, new java.sql.Date(g.getTravelEnd().getTime()));
				pstmt.setDate(7, new java.sql.Date(g.getRecruitmentEnd().getTime()));
				pstmt.setString(8, g.getSchedule());
				pstmt.setString(9, g.getDestination());
				pstmt.setInt(10, g.getTotalPerson());
				pstmt.setInt(11, g.getRecruitmentPerson());
				pstmt.setInt(12, g.getNowGenderM());
				pstmt.setInt(13, g.getNowGenderF());
				pstmt.setInt(14, g.getRecruitmentGenderM());
				pstmt.setInt(15, g.getRecruitmentGenderF());
				pstmt.setString(16, g.getContact());
				pstmt.setString(17, g.getComment());
				pstmt.setInt(18, g.getgRecommend());
				pstmt.setInt(19, g.getgHits());
				pstmt.setInt(20, g.getGowhitNo());
				result = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
		
			
		
		return result;
	}
	
}
