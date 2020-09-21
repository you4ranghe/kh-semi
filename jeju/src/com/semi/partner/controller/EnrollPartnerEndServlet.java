package com.semi.partner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.partner.model.service.PartnerService;
import com.semi.partner.model.vo.Partner;

/**
 * Servlet implementation class EnrollPartnerEnd
 */
@WebServlet("/partner/enrollPartnerEnd")
public class EnrollPartnerEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollPartnerEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Partner p = new Partner();
		p.setIdCardImgOriginal(request.getParameter("idcard"));
		p.setIdCardImgRename(request.getParameter("idcard"));
		p.setPartnerId(request.getParameter("userId"));
		p.setPartnerImgOriginal(request.getParameter("profile"));
		p.setPartnerImgRename(request.getParameter("profile"));
		p.setPartnerNick(request.getParameter("nickname"));
		
		System.out.println(p);
		
		int result = new PartnerService().insertPartner(p);
	
		String msg="";
		String loc="/";
		
		if(result>0) {
			msg="파트너가 되신걸 환영합니다 :-)";
		
		}
		else {
			msg="파트너 등록에 실패하였습니다";
		
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
