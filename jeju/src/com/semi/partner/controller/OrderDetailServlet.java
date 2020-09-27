package com.semi.partner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;
import com.semi.partner.model.service.PartnerService;
import com.semi.payend.model.vo.payEnd;

/**
 * Servlet implementation class OrderDetailServlet
 */
@WebServlet("/partner/orderDetail")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int payNum=Integer.parseInt(request.getParameter("pe"));
		/*
		 * HttpSession session=request.getSession(); Partner
		 * t=(Partner)session.getAttribute("logginedPartner");
		 */
		payEnd pe=new PartnerService().selectOrder(payNum);
		Member m=new MemberService().selectMemberId(pe.getUserId());
		request.setAttribute("m", m);
		request.setAttribute("pe", pe);
		request.getRequestDispatcher("/views/partner/orderDetail.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
