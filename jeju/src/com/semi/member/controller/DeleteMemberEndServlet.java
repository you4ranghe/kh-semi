package com.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.service.MemberService;

/**
 * Servlet implementation class DeleteMemberEndServlet
 */
@WebServlet(name="deleteMember",urlPatterns="/member/deleteMemberEnd")
public class DeleteMemberEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		
		int result=new MemberService().deleteMemer(userId,password);
		
		String msg="";
		String loc="/";
		
		if(result>0) {
			msg="탈퇴하셨습니다. 다음에 또 뵙겠습니다 :-)";
			loc="/member/logout";
		}else {
			msg="탈퇴에 실패하셨습니다. 비밀번호를 확인해주세요";
			loc="/member/deleteMember?userId="+userId;
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
