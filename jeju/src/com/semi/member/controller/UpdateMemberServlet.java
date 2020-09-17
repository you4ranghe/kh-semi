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
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/member/updateMember")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Member m = new Member();
		m.setUserId(request.getParameter("userId"));
		m.setUserName(request.getParameter("userName"));
		m.setAge(Integer.parseInt(request.getParameter("age")));
		m.setAddress(request.getParameter("address"));
		m.setGender(request.getParameter("gender"));

		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		try {
			m.setEmail(AESCrypto.encrypt(email));
			m.setPhone(AESCrypto.encrypt(phone));			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		int result=new MemberService().updateMember(m);
		
		String msg="";
		String loc="/";
		
		if(result>0) {
			msg="개인정보 수정 완료";
			
		}else {
			
			msg="개인정보 수정에 실패하였습니다.";
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
