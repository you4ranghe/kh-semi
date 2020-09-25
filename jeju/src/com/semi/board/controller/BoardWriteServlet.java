package com.semi.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.board.model.service.BoardService;
import com.semi.board.model.service.CommentService;
import com.semi.board.model.vo.Board;
import com.semi.board.model.vo.Comment;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();//세션가져옴
		Member logginedMember = (Member)session.getAttribute("logginedMember");//세션에 로그인된 아이디가 있는지 확인
		if(logginedMember == null) {
			request.setAttribute("msg", "회원만 접근 가능합니다. 로그인 해주세요!");
			request.setAttribute("loc", "/member/login");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/views/board/write.jsp");
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
