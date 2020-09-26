package com.semi.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.product.model.service.ProductService;
import com.semi.product.model.vo.Product;
import com.semi.review.model.vo.Review;

/**
 * Servlet implementation class ReviewConfirmServlet
 */
@WebServlet("/review/reviewConfirm")
public class ReviewConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		int reviewScore = Integer.parseInt(request.getParameter("reviewScore"));
		String reviewTitle = request.getParameter("reviewTitle");
		String reviewContents = request.getParameter("reviewContents");
		String reviewWriter = request.getParameter("reviewWriter");
		String poNum = request.getParameter("poNum");
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		String userId = request.getParameter("userId");
		
		Review r = new Review(0,reviewScore,reviewTitle,reviewContents,reviewWriter,poNum,null,0,pNum,userId);
		
		System.out.println("여기는 서블릿 r="+r);
		System.out.println("서블릿pNum="+pNum);
		System.out.println("서블릿userid="+userId);
		

	
		
		String loc="";
		String msg = "";
		
		

		
		
		
		
		if(result==0) {
			
			result = new ProductService().insertReview(r,pNum,userId);
			
			System.out.println("poNum="+poNum);
			System.out.println("여기는서블릿"+r);
			System.out.println("result"+result);
			
			loc="/product/productList?pNum="+pNum;
			

			if(result>0) {
				msg="리뷰 등록 성공!";

			}else {
				msg="리뷰 등록 실패!";

			}
			request.setAttribute("msg",msg);
			request.setAttribute("loc",loc);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			
		}	else {
				
			msg ="상품을 구매하신 분만 리뷰를 작성할 수 있습니다";
			loc="/product/productList?pNum="+pNum;
			System.out.println("작성x result="+result);
			System.out.println("작성xpoNum="+poNum);
		
		
		request.setAttribute("msg",msg);
		request.setAttribute("loc",loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
