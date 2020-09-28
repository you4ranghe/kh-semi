package com.semi.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.AESCrypto;
import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;
import com.semi.partner.model.service.PartnerService;
import com.semi.partner.model.vo.Partner;

/**
 * Servlet implementation class AdminPartnerViewServlet
 */
@WebServlet("/admin/partnerView")
public class AdminPartnerViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPartnerViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String partnerId=request.getParameter("partnerId");
		Partner p = new PartnerService().selectPartner(partnerId);
		Member m = new MemberService().selectMemberId(partnerId);
		
		String email=m.getEmail();
		String phone=m.getPhone();
		
		System.out.println(email+" : "+ phone);
		
		try {
			System.out.println(email);
			System.out.println(phone);
			m.setEmail(AESCrypto.decrypt(email));
			m.setPhone(AESCrypto.decrypt(phone));
			System.out.println(m.getEmail());
			System.out.println(m.getPhone());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("partnerView", p);
		request.setAttribute("memberView", m);
		request.getRequestDispatcher("/views/admin/adminPartnerView.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
