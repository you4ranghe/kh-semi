package com.semi.review.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.semi.review.model.dao.ReviewDao;
import com.semi.review.model.vo.Review;

public class ReviewService {

	private ReviewDao dao = new ReviewDao();
	
	public int insertReview(Review r) {
		Connection conn = getConnection();
		int result = dao.insertReview(conn,r);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public Review selectReviewList(){
		Connection conn = getConnection();
		Review r = dao.selectReviewList(conn);
		close(conn);
		return r;
	}
	
	public int selectReviewCount() {
		Connection conn = getConnection();
		int count = dao.selectReviewCount(conn);
		close(conn);
		return count;
	}
}
