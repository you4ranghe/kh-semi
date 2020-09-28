package com.semi.goWithBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.goWithBoard.model.service.GowithService;
import com.semi.goWithBoard.model.vo.Gowith;

/**
 * Servlet implementation class gowithServlet
 */
@WebServlet("/gowith")
public class GowithServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GowithServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage;//현제 페이지
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));// request에 parameter에서 cPage(현제 보고있는 페이지 값을
																	// 가져옴)
		} catch (NumberFormatException e) {
			cPage = 1;// request에 parameter에 값이을 불러올때 문제가 생길시 현제 cPage를 1로 대입
		}
		int numPerPage = 15;// 게시판에 보여줄 게시글 수 제한
		List<Gowith> gowithList = new GowithService().getGowith(cPage, numPerPage);
		int pageBarSize = 5;// 게시판 네비게이터의 목록 크기를 정해줌
		int totalData = new GowithService().getTotalDataCount();
		int totalPage = (int) (Math.ceil((double) totalData / numPerPage));
		int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
		int pageEnd = pageNo + pageBarSize - 1;
		String pageBar = "";
		if (pageNo == 1) {
			pageBar = "<li class='page-item'>" + "<a class='page-link text-dark'aria-label='Previous'>"
					+ "<span aria-hidden='true'>&laquo;</span>" + "<span class='sr-only'>Previous</span>" + "</a>"
					+ "</li>";
		} else {
			pageBar = "<li class='page-item'>" + "<a class='page-link text-dark' href='" + request.getContextPath()
					+ "/gowith?cPage=" + (pageNo - 1) + "' aria-label='Previous'>"
					+ "<span aria-hidden='true'>&laquo;</span>" + "<span class='sr-only'>Previous</span>" + "</a>"
					+ "</li>";
		}

		// 연결되는 페이지 번호 출력하기
		while (!(pageNo > pageEnd || pageNo > totalPage)) {
			if (cPage == pageNo) {
				pageBar += "<li class='page-item'><a class='page-link text-dark'>" + pageNo + "</a></li>";
			} else {
				pageBar += "<li class='page-item'><a class='page-link text-dark' href='" + request.getContextPath()
						+ "/gowith?cPage=" + pageNo + "'>" + pageNo + "</a></li>";
			}
			pageNo++;
		}
		if (pageNo > totalPage) {
			pageBar += "<li class='page-item'>" + "<a class='page-link text-dark' aria-label='Next'>"
					+ "<span aria-hidden='true'>&raquo;</span>" + "<span class='sr-only'>Next</span>" + "</a>"
					+ "</li>";
		} else {
			pageBar += "<li class='page-item'>" + "<a class='page-link text-dark' href='" + request.getContextPath()
					+ "/gowith?cPage=" + pageNo + "' aria-label='Next'>" + "<span aria-hidden='true'>&raquo;</span>"
					+ "<span class='sr-only'>Next</span>" + "</a>" + "</li>";
		}
		
		request.setAttribute("gowithList", gowithList);
		request.setAttribute("pageBar",pageBar);
		request.setAttribute("serch", "");
		request.getRequestDispatcher("/views/gowith/gowith.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
