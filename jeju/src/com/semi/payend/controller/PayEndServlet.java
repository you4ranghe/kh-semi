package com.semi.payend.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.payend.model.service.PayService;
import com.semi.payend.model.vo.payEnd;

/**
 * Servlet implementation class PayEndServlet
 */
@WebServlet("/payEnd")
public class PayEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		payEnd pe=new payEnd();
		
		pe.setPayNum(0);
		pe.setPayType(request.getParameter("payType"));
		pe.setPayDate(null);
		pe.setTotalPrice(Integer.parseInt(request.getParameter("totalPrice")));
		pe.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		pe.setUserId(request.getParameter("userId"));
		pe.setChildNum(Integer.parseInt(request.getParameter("chaildNum")));
		pe.setAdultNum(Integer.parseInt(request.getParameter("adultNum")));
		pe.setDateStart(request.getParameter("dateStart"));
		pe.setPayName(request.getParameter("payuser"));
		pe.setPayAddress(request.getParameter("payaddress"));
		pe.setPayPhone(request.getParameter("payphone"));
		pe.setPayEmail(request.getParameter("payemail"));
		System.out.println(pe);
		
		int result=new PayService().insertPay(pe);
		request.getRequestDispatcher("/views/pay/payEnd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
