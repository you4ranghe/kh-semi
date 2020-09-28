package com.semi.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.semi.board.model.service.BoardService;
import com.semi.board.model.vo.Board;
import com.semi.common.BoardFileRename;

/**
 * Servlet implementation class BoardWiteEndServlet
 */
@WebServlet("/board/writeEnd")
public class BoardWiteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardWiteEndServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// enctype이 multipartform인지확인
		int result = 0;
		Board b = null;
		if (!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "[encytpe] 관리 자에게 문의");
			request.setAttribute("loc", "/board");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}

		String path = getServletContext().getRealPath("/upload/board");

		int maxSize = 1024 * 1024 * 100;// 100MB
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "UTF-8", new BoardFileRename());
		System.out.println("title : " + mr.getParameter("title"));
		System.out.println("content : " + mr.getParameter("content"));
		System.out.println("userId : " + mr.getParameter("userId"));
		System.out.println("oFN : " + mr.getOriginalFileName("upfile"));
		System.out.println("rFN : " + mr.getFilesystemName("upfile"));
		if (mr.getOriginalFileName("upfile") != null) {
			String oriName = mr.getOriginalFileName("upfile");
			System.out.println("파일이름 : " + oriName);
			String ext = "";
			int dot = oriName.lastIndexOf(".");
			if (dot > -1) {
				ext = oriName.substring(dot);
			}
			System.out.println("확장자명 : " + ext);
			if (!(ext.equals(".jpg") || ext.equals(".png") || ext.equals(".PNG") || ext.equals(".JPG"))) {
				request.setAttribute("msg", "이미지 일만 첨부하실수 있습니다!");
				request.setAttribute("loc", "/board/write");
				File files = new File(path+"/"+mr.getFilesystemName("upfile"));
				if (files.exists()) {
					if (files.delete()) {
						System.out.println("파일삭제 성공");
					} else {
						System.out.println("파일삭제 실패");
					}
				} else {
					System.out.println("파일이 존재하지 않습니다.");
				}
				request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
				return;
			}
		}
		b = new Board();
		b.setBoardTitle(mr.getParameter("title"));
		b.setBoardContent(mr.getParameter("content"));
		b.setUserId(mr.getParameter("userId"));
		if (mr.getOriginalFileName("upfile") != null) {
			b.setOriginalFN(mr.getOriginalFileName("upfile"));
			b.setRenameFN(mr.getFilesystemName("upfile"));
		}
		result = new BoardService().insertBoard(b);

		String msg = "";
		String loc = "/board";
		if (result > 0) {
			msg = "게시글 등록 성공!";
		} else {
			msg = "게시글 등록 실패!";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);

		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);

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
