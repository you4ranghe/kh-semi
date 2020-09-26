package com.semi.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.admin.model.service.AdminService;
import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;
import com.semi.partner.model.service.PartnerService;
import com.semi.partner.model.vo.Partner;
import com.semi.payment.model.vo.Payment;
import com.semi.product.model.service.ProductService;
import com.semi.product.model.vo.Product;

/**
 * Servlet implementation class AdminPaymentViewServlet
 */
@WebServlet("/admin/paymentView")
public class AdminPaymentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPaymentViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int poNum=Integer.parseInt(request.getParameter("poNum"));
		String userId=request.getParameter("userId");
		int pNum=Integer.parseInt(request.getParameter("pNum"));
		
		//결제 번호로 결제내역 테이블 가져오기
		Payment payment = new AdminService().selectPaymentOne(poNum);
		Partner partner = new PartnerService().selectPartner(userId);
		Member member =new MemberService().selectMemberId(userId);
		Product product =new ProductService().selectProductOne(pNum);
	
		
		request.setAttribute("MemberView", member);
		request.setAttribute("PaymentView", payment);
		request.setAttribute("PartnerView", partner);
		request.setAttribute("ProductView", product);
		request.getRequestDispatcher("/views/admin/adminPaymentView.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
