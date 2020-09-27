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
 * Servlet implementation class AdminPaymentListServlet
 */
@WebServlet("/admin/paymentList")
public class AdminPaymentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPaymentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cPage;
		try{
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
		//결제내역 리스트에 담아오고 페이징 처리
		List<Payment> list=new AdminService().selectPaymentList(cPage,numPerPage);
		
		System.out.println("결제내역 테이블 "+list);
	
		int pageBarSize=5;
		
		//결제내역 총 데이터객수 조회
		int totalData=new AdminService().selectPaymentCount();
		
		int totalPage=(int)(Math.ceil((double)totalData/numPerPage));//2

		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		String pageBar="";

		if(pageNo==1) {
			pageBar="<span>[이전]</span>";
		}else {
			pageBar="<a href='"+request.getContextPath()
			+"/admin/paymentList?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'>[이전]</a>";		
		}
		

		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()+
						"/admin/paymentList?cPage="+pageNo+"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		

		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
			
		}else {
			pageBar+="<a href='"+request.getContextPath()+
					"/admin/paymentList?cPage="+pageNo+"&numPerPage="+numPerPage+"'>[다음]</a>";
		}

		request.setAttribute("payments", list);
		request.setAttribute("pageBar",pageBar);

		request.getRequestDispatcher("/views/admin/paymentList.jsp")
		.forward(request, response);
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
