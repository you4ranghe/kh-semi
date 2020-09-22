package com.semi.wishList.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.wishList.model.service.WishListService;

/**
 * Servlet implementation class wishListDeleteServlet
 */
@WebServlet("/wishListDelete")
public class WishListDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishListDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pName=request.getParameter("pName");
		String userId=request.getParameter("userId");
		
		int result=new WishListService().deleteWish(pName,userId);
		
//		 String msg="";
//		 String loc="/";
//		 if(result>0) {
//			msg="삭제 성공";
//		 }else {
//			msg="삭제 실패";
//			loc="/wishList";
//		}
//		request.setAttribute("msg", msg);
//		request.setAttribute("loc", loc);
//		

		ArrayList<Map<String, Object>> list = new WishListService().selectWish(userId);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/wishlist/wishListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
