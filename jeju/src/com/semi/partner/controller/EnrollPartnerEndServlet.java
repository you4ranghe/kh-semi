package com.semi.partner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.common.MyFileRename;
import com.semi.partner.model.service.PartnerService;
import com.semi.partner.model.vo.Partner;

/**
 * Servlet implementation class EnrollPartnerEnd
 */

@WebServlet("/member/enrollPartnerEnd")

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
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "파트너 신청 오류[form:enctype 관리자에게 문의해주세요]");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		System.out.println(getServletContext().getRealPath("/"));
		
		String path=getServletContext().getRealPath("/")+"upload/partner";
		int maxSize=1024*1024*10;
		String encode="utf-8";
		
//		MultipartRequest mr=new MultipartRequest(request, path, maxSize, encode, new DefaultFileRenamePolicy());
		MultipartRequest mr=new MultipartRequest(request, path, maxSize, encode, new MyFileRename());
		
		Partner p = new Partner();
		p.setIdCardImgOriginal(mr.getOriginalFileName("idcard"));
		p.setIdCardImgRename(mr.getFilesystemName("idcard"));
		p.setPartnerImgOriginal(mr.getOriginalFileName("profile"));
		p.setPartnerImgRename(mr.getFilesystemName("profile"));
		p.setPartnerId(mr.getParameter("userId"));
		p.setPartnerNick(mr.getParameter("nickname"));
		
		System.out.println(p);
		
		int result = new PartnerService().insertPartner(p);
	
		String msg="";
		String loc="/";
		
		if(result>0) {
			msg="파트너 신청에 성공하였습니다 :-)";
		
		}
		else {
			msg="파트너 신청에 실패하였습니다";
		
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
