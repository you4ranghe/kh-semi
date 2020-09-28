package com.semi.goWithBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.goWithBoard.model.service.GCommentService;
import com.semi.goWithBoard.model.service.GowithService;
import com.semi.goWithBoard.model.vo.GComment;
import com.semi.goWithBoard.model.vo.GFile;
import com.semi.goWithBoard.model.vo.Gowith;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class GowithViewServlet
 */
@WebServlet("/gowithView")
public class GowithViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GowithViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();// 세션가져옴
		Member logginedMember = (Member) session.getAttribute("logginedMember");// 세션에 로그인된 아이디가 있는지 확인

		if (logginedMember == null) {
			request.setAttribute("msg", "회원만 접근 가능합니다. 로그인 해주세요!");
			request.setAttribute("loc", "/member/login");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		} else {
			int gowithNo = Integer.parseInt(request.getParameter("gowithNo"));
			Gowith g = new GowithService().getGowithForNo(gowithNo);
			List<GFile> gfl = new GowithService().getGFile(gowithNo);
			List<GComment> gc = new GCommentService().getComment(gowithNo);
			System.out.println("=============================GowithView==================================");
			System.out.println(g);
			System.out.println(gfl);
			System.out.println(gc);
			System.out.println("=========================================================================");
			request.setAttribute("comment", gc);
			request.setAttribute("list", gfl);
			request.setAttribute("Gowith", g);
			request.getRequestDispatcher("/views/gowith/view.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
