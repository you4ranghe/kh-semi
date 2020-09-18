package com.semi.product.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.payment.model.service.PaymentService;
import com.semi.payment.model.vo.Payment;

/**
 * Servlet implementation class ProductGoCartServlet
 */
@WebServlet("/product/productGoCart")
public class ProductGoCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductGoCartServlet() {
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
		request.setCharacterEncoding("UTF-8");
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		
		String poNum = request.getParameter("poNum");
		String poType = request.getParameter("poNum");
		
		Date paydate = null;
		try {
			paydate = df.parse(request.getParameter("poDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date datestart=null;
		try {
			 datestart = df.parse(request.getParameter("pDateStart"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int totalprice = Integer.parseInt(request.getParameter("totalPrice"));
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		String userId = request.getParameter("userId");
		int counta = Integer.parseInt(request.getParameter("pCountA")); 
		int countc = Integer.parseInt(request.getParameter("pCountC"));



		

		
//		System.out.println(paydate+datestart+counta+countc+pTime+totalprice+pNum+userId);
		
		//Payment pm = new Payment(null,paydate,null,);
		
		System.out.println(poNum+poType+paydate+datestart+totalprice+pNum+userId+counta+countc);
		
		Payment pm = new Payment (null,null,null,datestart,totalprice,0,userId,counta,countc);
		
		int result = new PaymentService().insertProduct(pm);
		
		String msg="";
		String loc="";
		
		if(result>0) {
			msg="등록 성공!";
			loc="/";
		}else {
			msg="등록 실패!";
			loc="/";
		}
		request.setAttribute("msg",msg);
		request.setAttribute("loc",loc);
		request.getRequestDispatcher("/views/common/msg.jsp")
		.forward(request, response);
		
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
