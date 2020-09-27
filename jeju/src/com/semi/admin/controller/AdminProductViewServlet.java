package com.semi.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.partner.model.service.PartnerService;
import com.semi.partner.model.vo.Partner;
import com.semi.product.model.service.ProductService;
import com.semi.product.model.vo.Product;

/**
 * Servlet implementation class AdminProductViewServlet
 */
@WebServlet("/admin/productView")
public class AdminProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProductViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pNum=Integer.parseInt(request.getParameter("pNum"));
		String partnerId=request.getParameter("partnerId");
//		System.out.println("판매자아이디: " + partnerId);
//		System.out.println("상품번호:" +pNum);
		Product product = new ProductService().selectProductOne(pNum);
		Partner partner = new PartnerService().selectPartner(partnerId);
		
		request.setAttribute("PartnerView", partner);
		request.setAttribute("ProductView", product);
//		System.out.println("최종가져온 partner정보:" + partner);
//		System.out.println("최종가져온 product정보:" + product);
		request.getRequestDispatcher("/views/admin/adminProductView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
