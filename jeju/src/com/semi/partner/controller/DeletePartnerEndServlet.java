package com.semi.partner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.partner.model.service.PartnerService;

/**
 * Servlet implementation class DeletePartnerEndServlet
 */
@WebServlet("/partner/deletePartnerEnd")
public class DeletePartnerEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePartnerEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String partnerId = request.getParameter("partnerId");
		System.out.println(partnerId);
		
		int result=new PartnerService().deletePartner(partnerId);
		System.out.println("결과 : "+result);
		
		String msg="";
		String loc="/";
		
		if(result>0) {
			msg="파트너를 탈퇴하셨습니다. 언제든지 다시 파트너를 신청할수 있습니다.";
		}else {
			msg="파트너 탈퇴에 실패하였습니다";
		}
		request.setAttribute("msg",msg);
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
