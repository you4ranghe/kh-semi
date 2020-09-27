package com.semi.partner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.partner.model.service.PartnerService;
import com.semi.product.model.vo.Product;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/partner/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pNum=Integer.parseInt(request.getParameter("pNum"));
		
		int result=new PartnerService().deleteProduct(pNum);
		
		String msg="";
		String loc="";
		
		
		if(result==1) {
			msg="상품이 삭제되었습니다.";
			loc="/partner/partnerProductList";
		}else {
			msg="삭제에 실패하였습니다.";
			loc="/partner/partnerProductList";
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
