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

		System.out.println("나 나오냐?????");
	      int result=0;
	       WishList we=new WishList();
	       String userId=request.getParameter("userId");
	       we.setUserId(request.getParameter("userId"));
	       we.setProductNum(Integer.parseInt(request.getParameter("productNum")));
	       we.setPageAddress(request.getParameter("pageAddress"));
	       response.setContentType("text/html; charset=UTF-8"); 
	       PrintWriter writer = response.getWriter(); 
	        
	       int count=new WishListService().countWish(userId);
	       
	       if(count<4) {
	        result=new WishListService().insertWish(we);
	           if(result>0) {
	              writer.println("<script>alert('위시리스트 등록')</script>"); 
	           }else {
	              writer.println("<script>alert('이미 등록된 상품입니다.')</script>"); 
	           }
	       }else {
	          writer.println("<script>alert('위시리스트는 4개까지 담을수 있습니다.')</script>");
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
