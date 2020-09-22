package com.semi.partner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.semi.common.MyFileRename;
import com.semi.partner.model.service.PartnerService;
import com.semi.partner.model.vo.Partner;

/**
 * Servlet implementation class UpdatePartnerServlet
 */
@WebServlet("/partner/updatePartner")
public class UpdatePartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePartnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "파트너 정보 수정오류[form:enctype 관리자에게 문의해주세요]");
			request.setAttribute("loc","/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		String path = getServletContext().getRealPath("/")+"upload/partner";
		String encode="utf-8";
		int MaxSize=1024*1024*10;
		MultipartRequest mr = new MultipartRequest(request, path, MaxSize, encode, new MyFileRename());
		
		Partner p  = new Partner();
		p.setIdCardImgOriginal(mr.getOriginalFileName("idcard"));
		p.setIdCardImgRename(mr.getFilesystemName("idcard"));
		p.setPartnerId(mr.getParameter("partnerId"));
		p.setPartnerImgOriginal(mr.getOriginalFileName("profile"));
		p.setPartnerImgRename(mr.getFilesystemName("profile"));
		p.setPartnerNick(mr.getParameter("partnerNick"));
		
		int result = new PartnerService().updatePartner(p);
		
		String msg="";
		String loc="/";
		
		if(result>0) {
			msg="파트너 정보를 성공적으로 수정하였습니다";
		}else {
			msg="파트저 정보 수정에 실패하였습니다";
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
