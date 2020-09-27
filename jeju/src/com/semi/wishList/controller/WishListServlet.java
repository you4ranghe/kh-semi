package com.semi.wishList.controller;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Map;


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

		String userId=request.getParameter("userId");
		System.out.println("들어오나 확인"+userId);
	
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
