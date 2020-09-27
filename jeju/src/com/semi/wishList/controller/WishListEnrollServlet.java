package com.semi.wishList.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.wishList.model.service.WishListService;
import com.semi.wishList.model.vo.WishList;

/**
 * Servlet implementation class wishListEnrollServlet
 */
@WebServlet("/wishListEnroll")
public class WishListEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WishListEnrollServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	
		 WishList we=new WishList();
		  
		 we.setUserId(request.getParameter("userId"));
		 we.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		 we.setPageAddress(request.getParameter("pageAddress"));
		 
		 System.out.println(request.getParameter("pageAddress"));
		 
		 int result=new WishListService().insertWish(we);
		 request.setAttribute("we", we);

		 
		 String msg="";
		 String loc="";
		 if(result>0) {
			msg="등록 성공";
			loc="/";
		 }else {
			msg="등록실패";
			loc="/";
		 }
			request.setAttribute("msg",msg);
			request.setAttribute("loc", loc);

		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
