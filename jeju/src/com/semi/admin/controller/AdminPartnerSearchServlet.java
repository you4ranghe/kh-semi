package com.semi.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.admin.model.service.AdminService;
import com.semi.partner.model.vo.Partner;

/**
 * Servlet implementation class AdminPartnerSearchServlet
 */
@WebServlet("/admin/partnerSearch")
public class AdminPartnerSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPartnerSearchServlet() {
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
		
		List<Partner> list=new AdminService().selectPartnerSearch(type,keyword,cPage,numPerPage);
		
		int totalData=new AdminService().selectMemberSearchCount(type,keyword);
		int totalPage=(int)(Math.ceil((double)totalData/numPerPage));
		
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		String pageBar="";
		
		if(pageNo==1) {
			pageBar="<span>[이전]</span>";
		}else {
			pageBar="<a href='"+request.getContextPath()
					+ "/admin/partnerSearch?cPage="+(pageNo-1)
					+"&searchType="+type+"&searchkeyword="+keyword
					+"&numPerPage="+numPerPage+"'>[이전]</a>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()
				+"/admin/partnerSearch?cPage="+pageNo
				+"&searchType="+type+"&searchkeyword="+keyword
				+"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/admin/partnerSearch?cPage="+pageNo
			+"&searchType="+type+"&searchkeyword="+keyword
			+"&numPerPage="+numPerPage+"'>[다음]</a>";
		}
		
		request.setAttribute("pageBar",pageBar);
		
		request.setAttribute("partners",list);
		
		request.getRequestDispatcher("/views/admin/partnerList.jsp")
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
