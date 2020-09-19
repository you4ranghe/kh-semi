package com.semi.wishList.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.wishList.model.service.WishListService;
import com.semi.wishList.model.vo.WishList;

/**
 * Servlet implementation class WishListServlet
 */
@WebServlet("/wishList")
public class WishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

			
		String userId = request.getParameter("userId");
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		
		System.out.println(request.getParameter("pNum"));
		System.out.println(request.getParameter("userId"));


		WishList wl = new WishList(userId,pNum);
		int result = new WishListService().insertWishList(wl);
		
		String msg="";
		String loc="";
		
		if(result>0) {
			msg="위시리스트에 담기 성공!";
			loc="/views/wishlist/wishListView.jsp";
		}else {
			msg="실패!";
			loc="/";
		}
		request.setAttribute("msg",msg);
		request.setAttribute("loc",loc);
		request.getRequestDispatcher("/views/common/msg.jsp")
		.forward(request, response);
		
			}
		
		//request.getRequestDispatcher("/views/wishlist/wishListView.jsp").forward(request, response);
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
