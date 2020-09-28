package com.semi.wishList.controller;

import java.io.IOException;

import java.io.PrintWriter;

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

		 int result=new WishListService().insertWish(we);

		 response.setContentType("text/html; charset=UTF-8"); 
		 PrintWriter writer = response.getWriter(); 
		if(result>0) {
		 writer.println("<script>alert('위시리스트 등록')</script>"); 
		}else {
		 writer.println("<script>alert('이미 등록된 상품입니다.')</script>"); 
		}
		
		 writer.close();



		

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
