package com.semi.pay.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.AESCrypto;
import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class PayListServlet
 */
@WebServlet(name="payList", urlPatterns="/payList")
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
		String imageFile=request.getParameter("titleImgPath");
		System.out.println("확인하기");
		System.out.println(imageFile);
		int productNum=Integer.parseInt(request.getParameter("pNum"));
		String productName=request.getParameter("pName");
		int productPrice=Integer.parseInt(request.getParameter("totalPrice"));
		String productInfo=request.getParameter("pInfo");
		String dateStart=request.getParameter("pDateStart");
		int chaildNum=Integer.parseInt(request.getParameter("pCountC"));
		int adultNum=Integer.parseInt(request.getParameter("pCountA"));
		
		
		String userId=request.getParameter("userId");
		Member m = new MemberService().selectMemberId(userId);
		String email=m.getEmail();
		String phone=m.getPhone();
		
		System.out.println(email+" : "+phone);
		
		try {
			m.setEmail(AESCrypto.decrypt(email));
			m.setPhone(AESCrypto.decrypt(phone));
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("member", m);
		System.out.println(dateStart);
		System.out.println(chaildNum+"  "+adultNum);
		
		request.setAttribute("imageFile", imageFile);
		request.setAttribute("productNum", productNum);
		request.setAttribute("productName", productName);
		request.setAttribute("productPrice", productPrice);
		request.setAttribute("productInfo", productInfo);
		request.setAttribute("dateStart", dateStart);
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
