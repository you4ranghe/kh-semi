package com.semi.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.product.model.service.ProductService;
import com.semi.review.model.vo.Review;

/**
 * Servlet implementation class ReviewModifyServlet
 */
@WebServlet("/review/reviewModify")
public class ReviewModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		Review r = new Review();
		List<Review> list = new ArrayList();
		System.out.println("리스트는?="+r);
		System.out.println("???????="+r);

		r.setReviewScore(Integer.parseInt(request.getParameter("reviewScore")));
		r.setReviewTitle(request.getParameter("reviewTitle"));
		r.setReviewContents(request.getParameter("reviewContents"));
		r.setReviewWriter(request.getParameter("reviewWriter"));
		r.setPoNum(request.getParameter("poNum"));
		

		
//		String RegisterDate = request.getParameter("registerDate");
//		Date rd = Date.valueOf(RegisterDate);
//		r.setRegisterDate(rd);
	
//		r.setReviewViews(Integer.parseInt(request.getParameter("reviewViews")));
		
		r.setpNum(Integer.parseInt(request.getParameter("pNum")));
		r.setUserId(request.getParameter("userId"));


		
		int result = new ProductService().reviewModify(r);
		
		String msg="";
		String loc="/";
		
		if(result>0) {
			msg="성공적으로 수정되었습니다.";
		}else {
			msg="수정에 실패했습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/common/msg.jsp")
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
