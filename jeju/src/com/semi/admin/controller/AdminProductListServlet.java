package com.semi.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.admin.model.service.AdminService;
import com.semi.product.model.service.ProductService;
import com.semi.product.model.vo.Product;

/**
 * Servlet implementation class AdminProductListServlet
 */
@WebServlet("/admin/productList")
public class AdminProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProductListServlet() {
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
		//상품객체 리스트에 담아오고 페이징 처리
		List<Product> list=new AdminService().selectProductList(cPage,numPerPage);
		
		System.out.println("상품받아온것 "+list);
	
		int pageBarSize=5;
		
		//상품객체 총 데이터객수 조회
		int totalData=new AdminService().selectProductCount();
		
		int totalPage=(int)(Math.ceil((double)totalData/numPerPage));//2

		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		String pageBar="";

		if(pageNo==1) {
			pageBar="<span>[이전]</span>";
		}else {
			pageBar="<a href='"+request.getContextPath()
			+"/admin/productList?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'>[이전]</a>";		
		}
		

		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()+
						"/admin/productList?cPage="+pageNo+"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		

		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
			
		}else {
			pageBar+="<a href='"+request.getContextPath()+
					"/admin/productList?cPage="+pageNo+"&numPerPage="+numPerPage+"'>[다음]</a>";
		}

		request.setAttribute("products", list);
		request.setAttribute("pageBar",pageBar);

		request.getRequestDispatcher("/views/admin/productList.jsp")
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
