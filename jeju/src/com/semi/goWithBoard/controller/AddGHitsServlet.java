package com.semi.goWithBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.model.service.BoardService;
import com.semi.board.model.vo.Board;
import com.semi.goWithBoard.model.service.GowithService;
import com.semi.goWithBoard.model.vo.Gowith;

/**
 * Servlet implementation class AddGHitsServlet
 */
@WebServlet("/addGHits")
public class AddGHitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGHitsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gowithNo = Integer.parseInt(request.getParameter("gowithNo"));
		String userId = request.getParameter("userId");
		int result = 0;
		if(!(new GowithService().checkHits(gowithNo,userId))) {
			result = new GowithService().addHits(gowithNo,userId);
			if(result>0) {
				Gowith g = new GowithService().getGowithForNo(gowithNo);
				int hits = g.getgHits()+1;
				g.setgHits(hits);
				int update = new GowithService().updateGowith(g);
				if(update>0) {
					request.getRequestDispatcher("/gowithView?gowithNo="+gowithNo).forward(request, response);
				}else {
					request.setAttribute("msg", "추천실패! 관리자에게 문의 !");
					request.setAttribute("loc", "/gowithView?gowithNo="+gowithNo);
					request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
					return;
				}
				
			}else {
				request.setAttribute("msg", "추천실패! 관리자에게 문의 !");
				request.setAttribute("loc", "/gowithView?gowithNo="+gowithNo);
				request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
				return;
			}
		}else {
			request.setAttribute("msg", "이미추천하신 글입니다");
			request.setAttribute("loc", "/gowithView?gowithNo="+gowithNo);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
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
