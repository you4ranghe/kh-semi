package com.semi.goWithBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.goWithBoard.model.service.GowithService;

/**
 * Servlet implementation class GowithDelete
 */
@WebServlet("/deletes")
public class GowithDeleteServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GowithDeleteServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gowithNo = Integer.parseInt(request.getParameter("gowithNo"));
		System.out.println("들어와짐?");
		int result = new GowithService().delete(gowithNo);
		result += new GowithService().deleteGFile(gowithNo);
		result += new GowithService().deleteGhits(gowithNo);
		result += new GowithService().deleteGowith(gowithNo);
		System.out.println("처리됨?");
		System.out.println(result);
		if(result>0) {
			request.setAttribute("msg", "성공적으로 삭제 되었습니다.");
			request.setAttribute("loc", "/gowith");
			
		}else {
			request.setAttribute("msg", result);
			request.setAttribute("loc", "/gowith?gowithNo="+gowithNo);
			
		}
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
