package com.semi.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.model.service.BoardService;
import com.semi.board.model.vo.Board;

/**
 * Servlet implementation class BoardSerchServlet
 */
@WebServlet("/board/serch")
public class BoardSerchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSerchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cPage;
		String serch = request.getParameter("serch");
		if(request.getParameter("serch").equals("")) {
			serch = request.getParameter("hSerch");
		}
		System.out.println("\n");
		System.out.println(serch);
		System.out.println("\n");
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));// request에 parameter에서 cPage(현제 보고있는 페이지 값을
																	// 가져옴)
		} catch (NumberFormatException e) {
			cPage = 1;// request에 parameter에 값이을 불러올때 문제가 생길시 현제 cPage를 1로 대입
		}
		int numPerPage = 15;// 게시판에 보여줄 게시글 수 제한
		List<Board> boardList = new BoardService().getSerchBoard(serch,cPage,numPerPage);
		
		int pageBarSize = 5;// 게시판 네비게이터의 목록 크기를 정해줌
		int totalData = new BoardService().getSerchTotal(serch);// 게시판의 총 게시글 수를 가져옴
		int totalPage = (int) (Math.ceil((double) totalData / numPerPage));// 총 게시글수를 최대 데이터로 나눠 준후 이것을 올림하여 총 페이지
																			// 수를 정함
		int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;// 네비게이터의 번호의 시작을 정해줌
		int pageEnd = pageNo + pageBarSize - 1;// 네비게이터의 마지막 번호를 정해줌
		String pageBar = "";
		if (pageNo == 1) {
			pageBar = "<li class='page-item'>" + "<a class='page-link text-dark'aria-label='Previous'>"
					+ "<span aria-hidden='true'>&laquo;</span>" + "<span class='sr-only'>Previous</span>" + "</a>"
					+ "</li>";
		} else {
			pageBar = "<li class='page-item'>" + "<a class='page-link text-dark' href='" + request.getContextPath()
					+ "/board/serch?cPage=" + (pageNo - 1) + "&serch="+serch+"' aria-label='Previous'>"
					+ "<span aria-hidden='true'>&laquo;</span>" + "<span class='sr-only'>Previous</span>" + "</a>"
					+ "</li>";
		}

		// 연결되는 페이지 번호 출력하기
		while (!(pageNo > pageEnd || pageNo > totalPage)) {
			if (cPage == pageNo) {
				pageBar += "<li class='page-item'><a class='page-link text-dark'>" + pageNo + "</a></li>";
			} else {
				pageBar += "<li class='page-item'><a class='page-link text-dark' href='" + request.getContextPath()
						+ "/board/serch?cPage=" + pageNo + "&serch="+serch+"'>" + pageNo + "</a></li>";
			}
			pageNo++;
		}
		if (pageNo > totalPage) {
			pageBar += "<li class='page-item'>" + "<a class='page-link text-dark' aria-label='Next'>"
					+ "<span aria-hidden='true'>&raquo;</span>" + "<span class='sr-only'>Next</span>" + "</a>"
					+ "</li>";
		} else {
			pageBar += "<li class='page-item'>" + "<a class='page-link text-dark' href='" + request.getContextPath()
					+ "/board/serch?cPage=" + pageNo +  "' aria-label='Next'>" + "<span aria-hidden='true'>&raquo;</span>"
					+ "<span class='sr-only'>Next</span>" + "</a>" + "</li>";
		}
		System.out.println("pageBar : \n" + pageBar);
		System.out.println("pageNo : " + pageNo);
		System.out.println("pageEnd : " + pageEnd);
		System.out.println("totalData : " + totalData);
		System.out.println("totalPage : " + totalPage);

		request.setAttribute("boardList", boardList);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("serch","");
		request.getRequestDispatcher("/views/board/board.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
