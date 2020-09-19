package com.semi.wishList.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.semi.wishList.model.dao.WishListDao;
import com.semi.wishList.model.vo.WishList;

public class WishListService {

	private WishListDao dao = new WishListDao();
	
	public int insertWishList(WishList wl) {
		Connection conn = getConnection();
		int result = dao.insertWishList(conn,wl);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}
