package com.semi.member.controller;

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
 * Servlet implementation class EnrollMemberEndServlet
 */
@WebServlet(name="enrollMember",urlPatterns="/member/EnrollEnd")
public class EnrollMemberEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollMemberEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m =new Member();
		m.setPassword(request.getParameter("password"));
		m.setAddress(request.getParameter("address"));
		m.setAge(Integer.parseInt(request.getParameter("age")));
		m.setGender(request.getParameter("gender"));
		m.setUserId(request.getParameter("userId"));
		m.setUserName(request.getParameter("userName"));
		
//		m.setAddress(String.join(",", request.getParameterValues("address")));
		
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		
		try {
		m.setEmail(AESCrypto.encrypt(email));
		m.setPhone(AESCrypto.encrypt(phone));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//파리미터엔 name값이 들어간다!
		System.out.println(m);
		
		int result = new MemberService().insertMember(m);
		
		System.out.println(result);
		System.out.println(m);
		
		String msg="";
		String loc="/";
		if(result>0) {
			msg="회원가입 성공! 로그인해주세요";
			loc="/member/login";
		}else {
			msg="회원가입 실패";
			loc="/member/EnrollEnd";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
