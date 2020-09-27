package com.semi.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.admin.model.service.AdminService;

/**
 * Servlet implementation class AdminPartnerDeleteServlet
 */
@WebServlet("/admin/deletePartner")
public class AdminPartnerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPartnerDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String partnerId=request.getParameter("partnerId");
		int result=new AdminService().deletePartner(partnerId);
		
		String msg="";
		String loc="/";
		
		if(result>0) {
			msg="해당회원을 성공적으로 파트너에서 제외했습니다.";
			loc="/partner/partnerList";
		}else {
			msg="해당회원의 파트너 제외에 실패하였습니다";
			loc="/partner/partnerList";
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
