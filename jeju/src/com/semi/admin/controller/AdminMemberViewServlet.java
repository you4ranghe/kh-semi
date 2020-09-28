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

/**
 * Servlet implementation class AdminMemberViewServlet
 */
@WebServlet("/admin/memberView")
public class AdminMemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId=request.getParameter("userId");
		Member m = new MemberService().selectMemberId(userId);
		
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
		
		request.setAttribute("memberView", m);
		request.getRequestDispatcher("/views/admin/adminMemberView.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
