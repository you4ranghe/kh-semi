package com.semi.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.model.service.CommentService;
import com.semi.board.model.vo.Comment;

/**
 * Servlet implementation class AddCommentServlet
 */
@WebServlet("/boardView/addComment")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("userId"));
		System.out.println(request.getParameter("boardNo"));
		System.out.println(request.getParameter("comment"));
		System.out.println(request.getParameter("commentPosition"));
		System.out.println(request.getParameter("replyPosition"));
		String userId = request.getParameter("userId");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String commentContent = request.getParameter("comment");
		int commentPosition = Integer.parseInt(request.getParameter("commentPosition"));
		int replyPosition = Integer.parseInt(request.getParameter("replyPosition"));
		Comment c = new Comment(userId, boardNo, commentContent, commentPosition, replyPosition);
		
		System.out.println("parseInt밑에");
		
		int result = new CommentService().addComment(c);
		
		if(result==0) {
			request.setAttribute("msg", "내용을 입력해주세요!");
			request.setAttribute("loc", "/boardView?boardNo="+boardNo);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/boardView?boardNo="+boardNo);
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
