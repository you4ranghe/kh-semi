package com.semi.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.admin.model.service.AdminService;

/**
 * Servlet implementation class AdminAcceptPartnerServlet
 */
@WebServlet("/admin/acceptPartner")
public class AdminAcceptPartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAcceptPartnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String partnerId=request.getParameter("partnerId");
	
		//기본 디폴드값이'N'인 PARTNER_STATUS의 상태를 'Y'로 업데이트 해준다. 
		int result=new AdminService().acceptPartner(partnerId);
		
		System.out.println("승인결과: "+result);
		
		String msg="";
		String loc="/";
		
		if(result>0) {
			msg="정상적으로 파트너를 승인하였습니다";
			loc="/admin/partnerList";
		}else {
			msg="파트너 승인이 실패하였습니다";
			loc="/admin/partnerView";
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
