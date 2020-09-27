package com.semi.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.common.AESCrypto;
import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;
import com.semi.partner.model.service.PartnerService;
import com.semi.partner.model.vo.Partner;

/**
 * Servlet implementation class LoginEndServlet
 */
@WebServlet(name="login", urlPatterns="/member/loginEnd")
public class LoginEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id= request.getParameter("id");

		String pw =request.getParameter("password");

		
//		String id =(String)request.getAttribute("id");
//		String pw =(String)request.getAttribute("password");
		
	  //복호화하면 넘어간다 대신 화면에서 넘어오는건 못가져간다.
	 //
		
		System.out.println("아이디 : "+id +"패스워드: "+pw);

		System.out.println("id : "+id+": "+"pw : "+pw);
		
		Member m = new MemberService().loginMember(id,pw);
		Partner p = new PartnerService().selectPartner(id);
		
		System.out.println("파트너 : "+p);	
		System.out.println("회원 : "+m);
		
		HttpSession session=request.getSession();
		
		if(m!=null) {

			session.setAttribute("logginedMember",m);	
			
		if(p!=null && p.getPartnerStatus().equals("Y")) {
			session.setAttribute("logginedPartner", p);
			
		}

			response.sendRedirect(request.getContextPath()); 
			
		}else {

			request.setAttribute("msg", "아이디나 비밀번호가 일치하지 않습니다");
			request.setAttribute("loc", "/member/login");

			RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg.jsp");
			rd.forward(request, response);
			
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
