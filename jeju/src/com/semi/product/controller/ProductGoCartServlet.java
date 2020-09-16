package com.semi.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.payment.model.vo.Payment;
import com.semi.payment.service.PaymentService;

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
		
		String datestart = request.getParameter("pDateStart");
		String datefinish = request.getParameter("pDateFinish");
		String counta = request.getParameter("pCountA");
		String countc = request.getParameter("pCountC");
		String pTime = request.getParameter("pTime");
		String totalprice = request.getParameter("totalPrice");
		
		System.out.println(datestart+datefinish+counta+countc+pTime+totalprice);
		
		Payment pm = new Payment(null,0,null,null,datestart,datefinish,counta,countc,pTime,totalprice);
		
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
