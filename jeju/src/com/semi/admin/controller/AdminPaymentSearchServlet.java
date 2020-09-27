package com.semi.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.admin.model.service.AdminService;
import com.semi.payment.model.vo.Payment;

/**
 * Servlet implementation class AdminPaymentSearchServlet
 */
@WebServlet("/admin/paymentSearch")
public class AdminPaymentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPaymentSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String type=request.getParameter("searchType");
		String keyword=request.getParameter("searchkeyword");
		
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
	
		int numPerPage;
		try {
			numPerPage=Integer.parseInt(request.getParameter("numPerPage"));
		}catch(NumberFormatException e) {
			numPerPage=5;
		}
		
		//검색키워드와 타입에 다른 결제내역 객체 리스트에 담아오는 서비스
		List<Payment> list=new AdminService().selectPaymentSearch(type,keyword,cPage,numPerPage);
		System.out.println("검색타입에 따른 list : "+list);
		//검색키워드 타입에 다른 결제내역 객체 총 수 조회 서비스
		int totalData=new AdminService().selectPaymentSearchCount(type,keyword);
		System.out.println("검색타입에 따른 갯수 : "+totalData);
		
		
		int totalPage=(int)(Math.ceil((double)totalData/numPerPage));
		
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		String pageBar="";
		
		if(pageNo==1) {
			pageBar="<span>[이전]</span>";
		}else {
			pageBar="<a href='"+request.getContextPath()
					+ "/admin/paymentSearch?cPage="+(pageNo-1)
					+"&searchType="+type+"&searchkeyword="+keyword
					+"&numPerPage="+numPerPage+"'>[이전]</a>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()
				+"/admin/paymentSearch?cPage="+pageNo
				+"&searchType="+type+"&searchkeyword="+keyword
				+"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/admin/paymentSearch?cPage="+pageNo
			+"&searchType="+type+"&searchkeyword="+keyword
			+"&numPerPage="+numPerPage+"'>[다음]</a>";
		}
		
		request.setAttribute("pageBar",pageBar);
		
		request.setAttribute("payments",list);
		
		request.getRequestDispatcher("/views/admin/paymentList.jsp")
		.forward(request,response);
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
