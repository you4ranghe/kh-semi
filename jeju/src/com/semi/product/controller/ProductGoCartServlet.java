package com.semi.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.payment.model.vo.Payment;
import com.semi.payment.service.PaymentService;

/**
 * Servlet implementation class ProductGoCartServlet
 */
@WebServlet("/product/productGoCart")
public class ProductGoCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductGoCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		Payment pm = new Payment();
		
		/*
		 * pm.setPoNum(request.getParameter("po_num"));
		 * pm.setpNum(Integer.parseInt(request.getParameter("p_num")));
		 * pm.setPoType(request.getParameter("po_type"));
		 * pm.setPoDate(request.getParameter("po_date"));
		 */
		pm.setpCountA(Integer.parseInt(request.getParameter("p_count_a")));
		pm.setpCountC(Integer.parseInt(request.getParameter("p_count_c")));
		pm.setpDateStart(request.getParameter("p_date_start"));
		pm.setpDateFinish(request.getParameter("p_date_finish"));
		pm.setpTime(request.getParameter("p_time"));
		pm.setTotalPrice(Integer.parseInt(request.getParameter("total_price")));
		
		int result=new PaymentService().insertProduct(pm);
		
		String msg="";
		String loc="/";
		if(result>0) {
			msg="주문하신 상품이 결제창에 담겼습니다";
		}else {
			msg="옵션을 다시 선택해주세요";
			loc="/product/productList";
		}
		request.setAttribute("msg",msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/product/productList.jsp")
		.forward(request, response); //추후에 결제창 페이지로 바꾸기 !!!!!!
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
