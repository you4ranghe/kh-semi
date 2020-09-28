package com.semi.review.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.product.model.service.ProductService;
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
		
		int reviewScore = Integer.parseInt(request.getParameter("reviewScore"));
		String reviewTitle = request.getParameter("reviewTitle");
		String reviewContents = request.getParameter("reviewContents");
		String reviewWriter = request.getParameter("reviewWriter");
		String poNum = request.getParameter("poNum");
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		String userId = request.getParameter("userId");


		
		Review r = new Review(0,reviewScore,reviewTitle,reviewContents,reviewWriter,poNum,null,0,pNum,userId);
		//int result = new ProductService().insertReview(r);

		int result1 = new ProductService().confirmReview(r);
		

		
		String msg="";
		String loc="";
		
		if(result1>0) {
			
			int result = new ProductService().insertReview(r);
		
			
					if(result>0) {
						
						msg="리뷰 등록 성공!";
						loc="/product/productList?pNum="+pNum;
						
						response.setContentType("text/html; charset=UTF-8"); 
						PrintWriter writer = response.getWriter();
						writer.println("<script>alert('리뷰 등록 성공!'); location.href='product/productList?pNum='+pNum</script>");
						writer.close();
						


					}else {
						
						
						msg="리뷰 등록 실패!";
						loc="/product/productList?pNum="+pNum;
						
						
					}
			
					
		}else {
			msg="구매하신 회원만 리뷰 작성이 가능합니다";
			loc="/product/productList?pNum="+pNum;
			
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
