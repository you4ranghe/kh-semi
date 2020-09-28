package com.semi.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.model.service.BoardService;
import com.semi.board.model.vo.Board;

/**
 * Servlet implementation class AddHitsServlet
 */
@WebServlet("/addHits")
public class AddHitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHitsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String userId = request.getParameter("userId");
		
		int result = 0;
		
		System.out.println("boardNo :"+boardNo);
		System.out.println("userId : "+userId);
		System.out.println(new BoardService().checkHits(boardNo,userId));
		if(!(new BoardService().checkHits(boardNo,userId))) {
			result = new BoardService().addHits(boardNo,userId);
			if(result>0) {
				Board b = new BoardService().boardNo(boardNo);
				int hits = b.getBoardHits()+1;
				System.out.println(b.getBoardDate());
				System.out.println("\n\nBoard 의  hit : "+b.getBoardHits());
				b.setBoardHits(hits);
				System.out.println("Board 의 수정된 hit : "+ b.getBoardHits());
				int update = new BoardService().updateBoard(b);
				System.out.println(update);
				if(update>0) {
					request.getRequestDispatcher("/boardView?boardNo="+boardNo).forward(request, response);
				}else {
					request.setAttribute("msg", "추천실패! 관리자에게 문의 !");
					request.setAttribute("loc", "/boardView?boardNo="+boardNo);
					request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
					return;
				}
				
			}else {
				request.setAttribute("msg", "추천실패! 관리자에게 문의 !");
				request.setAttribute("loc", "/boardView?boardNo="+boardNo);
				request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
				return;
			}
		}else {
			request.setAttribute("msg", "이미추천하신 글입니다");
			request.setAttribute("loc", "/boardView?boardNo="+boardNo);
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
