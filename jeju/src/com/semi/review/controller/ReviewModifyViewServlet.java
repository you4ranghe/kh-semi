package com.semi.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.product.model.service.ProductService;
import com.semi.review.model.vo.Review;

/**
 * Servlet implementation class ReviewModifyViewServlet
 */
@WebServlet("/ReviewModifyViewServlet")
public class ReviewModifyViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewModifyViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userId = request.getParameter("userId");
		int reviewNum = Integer.parseInt(request.getParameter("reviewNum"));

		List<Review> reviewList = new ProductService().selectReviewModifyList(userId,reviewNum);
		System.out.println("모디파이뷰서블릿리스트="+reviewList);
//		List<Review> reviewList = new ProductService().selectReviewModifyList();
		request.setAttribute("reviewList", reviewList);
		request.getRequestDispatcher("/views/product/reviewModify.jsp")
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
