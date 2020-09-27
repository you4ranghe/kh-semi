 package com.semi.partner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.partner.model.service.PartnerService;
import com.semi.partner.model.vo.Partner;
import com.semi.payend.model.vo.payEnd;

/**
 * Servlet implementation class PartnerOrderListServlet
 */
@WebServlet("/partner/partnerOrderList")
public class PartnerOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartnerOrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest)request).getSession(false);
		Partner p = (Partner)(session.getAttribute("logginedPartner"));
			
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
			
		}catch(NumberFormatException e) {
			cPage=1;
		}
		
		int numPerPage=5; //한페이지 당 데이터수
		
		List<payEnd> list=new PartnerService().selectPartnerOrderList(cPage,numPerPage,p.getPartnerId());
		for(payEnd pe:list) {
			System.out.println("pe"+pe.getPayName());
		}
		int totalData=new PartnerService().selectPartnerOrderListCount(p.getPartnerId());
		
		int totalPage=(int)(Math.ceil((double)totalData/numPerPage));
		
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		String pageBar="";
		
		/*
		 * if(pageNo==1) { pageBar+="<span>[이전]</span>"; }else {
		 * pageBar+="<a href='"+request.getContextPath()+"/partnerOrderList?"
		 * +"&cPage="+(pageNo-1)+"'>[이전]</a>"; }
		 * 
		 * while(!(pageNo>pageEnd||pageNo>totalPage)) { if(cPage==pageNo) {
		 * pageBar+="<span>"+pageNo+"</span>"; }else {
		 * pageBar+="<a href='"+request.getContextPath()+"/partnerOrderList?" +
		 * "&cPage="+pageNo+"'>"+pageNo+"</a>"; } pageNo++; }
		 * 
		 * if(pageNo>totalPage) { pageBar+="<span>[다음]</span>"; }else{
		 * pageBar+="<a href='"+request.getContextPath()+"/partnerOrderList?"
		 * +"&cPage="+(pageNo)+"'>[다음]</a>";
		 * 
		 * }
		 */
				
		if (pageNo == 1) {
			pageBar = "<li class='page-item'>" + "<a class='page-link text-dark'aria-label='Previous'>"
					+ "<span aria-hidden='true'>&laquo;</span>" + "<span class='sr-only'>Previous</span>" + "</a>"
					+ "</li>";
		} else {
			pageBar = "<li class='page-item'>" + "<a class='page-link text-dark' href='" + request.getContextPath()
					+ "/partner/partnerOrderList?cPage=" + (pageNo - 1) + "' aria-label='Previous'>"
					+ "<span aria-hidden='true'>&laquo;</span>" + "<span class='sr-only'>Previous</span>" + "</a>"
					+ "</li>";
		}

		// 연결되는 페이지 번호 출력하기
		while (!(pageNo > pageEnd || pageNo > totalPage)) {
			if (cPage == pageNo) {
				pageBar += "<li class='page-item active'><a class='page-link text-dark'>" + pageNo + "</a></li>";
			} else {
				pageBar += "<li class='page-item'><a class='page-link text-dark' href='" + request.getContextPath()
						+ "/partner/partnerOrderList?cPage=" + pageNo + "'>" + pageNo + "</a></li>";
			}
			pageNo++;
		}
		if (pageNo > totalPage) {
			pageBar += "<li class='page-item'>" + "<a class='page-link text-dark' aria-label='Next'>"
					+ "<span aria-hidden='true'>&raquo;</span>" + "<span class='sr-only'>Next</span>" + "</a>"
					+ "</li>";
		} else {
			pageBar += "<li class='page-item'>" + "<a class='page-link text-dark' href='" + request.getContextPath()
					+ "/partner/partnerOrderList?cPage=" + pageNo + "' aria-label='Next'>" + "<span aria-hidden='true'>&raquo;</span>"
					+ "<span class='sr-only'>Next</span>" + "</a>" + "</li>";
		}
	
		request.setAttribute("list", list);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/views/partner/partnerOrderList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
