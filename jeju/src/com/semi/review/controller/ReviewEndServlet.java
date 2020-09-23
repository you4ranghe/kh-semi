package com.semi.review.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.review.model.service.ReviewService;
import com.semi.review.model.vo.Review;

/**
 * Servlet implementation class ReviewEndServlet
 */
@WebServlet("/review/reviewEndServlet")
public class ReviewEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		//int reviewNum = Integer.parseInt(request.getParameter("reviewNum"));
		int reviewScore = Integer.parseInt(request.getParameter("reviewScore"));
		String reviewTitle = request.getParameter("reviewTitle");
		String reviewContents = request.getParameter("reviewContents");
		String reviewWriter = request.getParameter("reviewWriter");
//		String poNum = request.getParameter("poNum");
//		String registerDate = request.getParameter("registerDate");
//		Date rd = Date.valueOf(registerDate);
		//int reviewViews = request.getParameter("reviewViews");
		int pNum = Integer.parseInt(request.getParameter("pNum"));

		
		System.out.println(reviewScore+" "+reviewTitle+" "+reviewContents+" "+reviewWriter+" "+pNum);
		
		Review r = new Review(0,reviewScore,reviewTitle,reviewContents,reviewWriter,null,null,0,pNum);
		
		int result = new ReviewService().insertReview(r);
		
		String msg="";
//		String loc="/review/reviewList";
		String loc="/product/productList";
		
		if(result>0) {
			msg="리뷰 등록 성공!";

		}else {
			msg="리뷰 등록 실패!";

		}
		request.setAttribute("msg",msg);
		request.setAttribute("loc",loc);
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
