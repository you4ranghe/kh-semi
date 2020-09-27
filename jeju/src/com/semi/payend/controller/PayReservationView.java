package com.semi.payend.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.payend.model.service.PayService;
import com.semi.wishList.model.service.WishListService;

/**
 * Servlet implementation class PayReservationView
 */
@WebServlet("/payReservation")
public class PayReservationView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayReservationView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String userId=request.getParameter("userId");
//		
//		ArrayList<Map<String, Object>> reserveList = new PayService().selectPay(userId);
//		request.setAttribute("reserveList", reserveList);
//		request.getRequestDispatcher("/views/pay/payReservationView.jsp").forward(request, response);
		
		
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		int numPerPage=5;
		String userId=request.getParameter("userId");
		ArrayList<Map<String, Object>> reserveList = new PayService().selectPay(userId,cPage,numPerPage);
		int totalData=new PayService().selectPayCount(userId);
		int totalPage=(int)(Math.ceil((double)totalData/numPerPage));
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		
		String pageBar="";
		if(pageNo==1) {
			pageBar="<span>[이전]</span>";
		}else {
			pageBar="<a href='"+request.getContextPath()+"/payReservation?cPage="+(pageNo-1)+"&userId="+(userId)+"'>[이전]</a>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()+"/payReservation?cPage="+(pageNo)+"&userId="+(userId)+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()+"/payReservation?cPage="+(pageNo)+"&userId="+(userId)+"'>[다음]</a>";
		}
		
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("reserveList", reserveList);
		request.getRequestDispatcher("/views/pay/payReservationView.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
