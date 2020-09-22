package com.semi.pay.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PayListServlet
 */
@WebServlet("/payList")
public class PayListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String imageFile=request.getParameter("");
		String productNum=request.getParameter("");
		String productName=request.getParameter("productName");
		String productPrice=request.getParameter("productPrice");
		String productInfo=request.getParameter("productInfo");
		String date=request.getParameter("date");
		int chaildNum=Integer.parseInt(request.getParameter("chaildNum"));
		int adultNum=Integer.parseInt(request.getParameter("adultNum"));
		
		
		System.out.println(date);
		System.out.println(chaildNum+"  "+adultNum);
		
		request.setAttribute("productName", productName);
		request.setAttribute("productPrice", productPrice);
		request.setAttribute("productInfo", productInfo);
		request.setAttribute("date", date);
		request.setAttribute("chaildNum", chaildNum);
		request.setAttribute("adultNum",adultNum);
		/*
		 * request.setAttribute("dateStart", dateStart); request.setAttribute("dateEnd",
		 * dateEnd);
		 */
		
		
		request.getRequestDispatcher("/views/pay/payList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
