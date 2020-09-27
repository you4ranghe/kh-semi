package com.semi.partner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.member.model.vo.Member;
import com.semi.partner.model.service.PartnerService;
import com.semi.product.model.vo.Product;

/**
 * Servlet implementation class PartnerProductListServlet
 */
@WebServlet("/partner/partnerProductList")
public class PartnerProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartnerProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		//아직 파트너가 없어서 멤버로 ..
		//session.getAttribute("logginedPartner");
		
		Member m=(Member)session.getAttribute("logginedMember");
		
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
			
		}catch(NumberFormatException e) {
			cPage=1;
		}
		
		int numPerPage=6; //한페이지 당 데이터수
		
		List<Product> list=new PartnerService().selectPartnerProductList(cPage,numPerPage,m.getUserId());
		
		int totalData=new PartnerService().selectPartnerProductCount(m.getUserId());
		int totalPage=(int)(Math.ceil((double)totalData/numPerPage));
		
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		String pageBar="";
		
		if(pageNo==1) {
			pageBar+="<span>[이전]</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()+"/partner/partnerProductList?"
					+"&cPage="+(pageNo-1)+"'>[이전]</a>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()+"/partner/partnerProductList?"
						+ "&cPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
			
		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
		}else{
			pageBar+="<a href='"+request.getContextPath()+"/partner/partnerProductList?"
					+"&cPage="+(pageNo)+"'>[다음]</a>";
							
		}
				
	
		request.setAttribute("list", list);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/views/partner/partnerProductList.jsp").forward(request, response);;
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
