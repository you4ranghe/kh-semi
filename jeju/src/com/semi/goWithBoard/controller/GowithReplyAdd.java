package com.semi.goWithBoard.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.goWithBoard.model.service.GCommentService;
import com.semi.goWithBoard.model.vo.GComment;

/**
 * Servlet implementation class GowithReplyAdd
 */
@WebServlet("/gowithView/addReply")
public class GowithReplyAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GowithReplyAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		int gowithNo = Integer.parseInt(request.getParameter("gowithNo"));
		String commentContent = request.getParameter("comment");
		int commentPosition = Integer.parseInt(request.getParameter("commentPosition"));
		int replyPosition = 1;
		if (request.getParameter("replyPosition").equals("")) {
			replyPosition = 1;
		} else {
			replyPosition = Integer.parseInt(request.getParameter("replyPosition"))+1;
		}
		GComment gc = new GComment(gowithNo, userId, commentContent, commentPosition, replyPosition, new Date());

		System.out.println("parseInt밑에");

		int result = new GCommentService().addComment(gc);

		if (result == 0) {
			request.setAttribute("msg", "내용을 입력해주세요!");
			request.setAttribute("loc", "/gowithView?gowithNo=" + gowithNo);
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/gowithView?gowithNo=" + gowithNo);
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
