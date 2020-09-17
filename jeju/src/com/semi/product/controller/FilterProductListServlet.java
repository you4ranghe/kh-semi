package com.semi.product.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.product.model.vo.Product;

/**
 * Servlet implementation class SelectProductListServlet
 */
@WebServlet("/filterProductList")
public class FilterProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		Product p=new Product();
		p.setPdPlace(String.join(",",request.getParameterValues("place")));
		p.setPdWish(String.join(",", request.getParameterValues("favor")));
		
		String date = request.getParameter("startdate");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date d=null;
		try {
			d = sf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		p.setPdDateStart(d);
		
		List<Product> list=new ProductService().filterProductList(p);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
