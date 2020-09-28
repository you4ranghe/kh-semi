package com.semi.goWithBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.goWithBoard.model.service.GowithService;
import com.semi.goWithBoard.model.vo.Gowith;

/**
 * Servlet implementation class GowithModifyServelt
 */
@WebServlet("/modify")
public class GowithModifyServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GowithModifyServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int gowithNo = Integer.parseInt(request.getParameter("gowithNo"));
		Gowith g = new GowithService().getGowithForNo(gowithNo);
		request.setAttribute("gowithNo", gowithNo);
		request.setAttribute("gowith", g);
		request.getRequestDispatcher("/views/gowith/modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
