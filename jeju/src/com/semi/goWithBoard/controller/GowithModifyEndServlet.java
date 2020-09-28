package com.semi.goWithBoard.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.semi.common.GowithFileRename;
import com.semi.goWithBoard.model.service.GowithService;
import com.semi.goWithBoard.model.vo.GFile;
import com.semi.goWithBoard.model.vo.Gowith;

/**
 * Servlet implementation class GowithModifyEndServlet
 */
@WebServlet("/modifyEnd")
public class GowithModifyEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GowithModifyEndServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(1);
		int result = 0;
		boolean[] file = new boolean[5];

		if (!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "[encytpe] 관리 자에게 문의");
			request.setAttribute("loc", "/board");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		System.out.println(2);
		String path = getServletContext().getRealPath("/upload/gowith");
		System.out.println(3);
		int maxSize = 1024 * 1024 * 100;// 100MB
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "UTF-8", new GowithFileRename());
		System.out.println("========================= GowithWriteEndServlet ===========================");
		System.out.println("title : " + mr.getParameter("title"));
		System.out.println("userId : " + mr.getParameter("userId"));
		System.out.println("start :" + mr.getParameter("start"));
		System.out.println("end :" + mr.getParameter("end"));
		System.out.println("recruitmentEnd :" + mr.getParameter("recruitmentEnd"));
		System.out.println("totalP : " + mr.getParameter("totalP"));
		System.out.println("recruitmentP : " + mr.getParameter("recruitmentP"));
		System.out.println("mP : " + mr.getParameter("mP"));
		System.out.println("fP : " + mr.getParameter("fP"));
		System.out.println("MP : " + mr.getParameter("MP"));
		System.out.println("FP : " + mr.getParameter("FP"));
		System.out.println("contact : " + mr.getParameter("contact"));
		System.out.println("schedule : " + mr.getParameter("schedule"));
		System.out.println("comment : " + mr.getParameter("comment"));
		System.out.println("출발장소 : " + mr.getParameter("destination"));
		Date recruitmentEnd = null;
		LocalDateTime start = null;
		LocalDateTime end = null;
		Date dstart = null;
		Date dend = null;
		int gowithNo = Integer.parseInt(mr.getParameter("gowithNo"));
		System.out.println(4);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			recruitmentEnd = (Date) sdf.parse(mr.getParameter("recruitmentEnd"));
			System.out.println(recruitmentEnd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(5);
		try {
			start = LocalDateTime.parse(mr.getParameter("start"));
			end = LocalDateTime.parse(mr.getParameter("end"));
			dstart = Date.from(start.atZone(ZoneId.systemDefault()).toInstant());
			dend = Date.from(end.atZone(ZoneId.systemDefault()).toInstant());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(6);

		for (int i = 0; i < 5; i++) {
			if (mr.getOriginalFileName("upfile" + i) != null) {
				System.out.println("oFN" + i + " : " + mr.getOriginalFileName("upfile" + i));
				System.out.println("rFN" + i + " : " + mr.getFilesystemName("upfile" + i));
				GFile gf = new GFile();
			}
		}
		System.out.println("===========================================================================");
		System.out.println(7);
		Gowith gN = new GowithService().getGowithForNo(gowithNo);
		Gowith g = new Gowith();
		g.setWriteDate(gN.getWriteDate());
		g.setGowhitNo(gowithNo);
		g.setUserId(mr.getParameter("userId"));
		g.setGowithTitle(mr.getParameter("title"));
		g.setTravelStart(dstart);
		g.setTravelEnd(dend);
		g.setRecruitmentEnd(recruitmentEnd);
		g.setTotalPerson(Integer.parseInt(mr.getParameter("totalP")));
		g.setRecruitmentPerson(Integer.parseInt(mr.getParameter("recruitmentP")));
		g.setNowGenderM(Integer.parseInt(mr.getParameter("mP")));
		g.setNowGenderF(Integer.parseInt(mr.getParameter("fP")));
		g.setRecruitmentGenderM(Integer.parseInt(mr.getParameter("MP")));
		g.setRecruitmentGenderF(Integer.parseInt(mr.getParameter("FP")));
		g.setContact(mr.getParameter("contact"));
		g.setSchedule(mr.getParameter("schedule"));
		g.setComment(mr.getParameter("comment"));
		g.setDestination(mr.getParameter("destination"));
		g.setgRecommend(gN.getgRecommend());
		g.setgHits(gN.getgHits());
		System.out.println("Gowith : " + g);
		System.out.println(8);
		for (int i = 0; i < 5; i++) {
			if (mr.getOriginalFileName("upfile" + i) != null) {
				String oriName = mr.getOriginalFileName("upfile" + i);
				System.out.println("파일이름 : " + oriName);
				String ext = "";
				int dot = oriName.lastIndexOf(".");
				if (dot > -1) {
					ext = oriName.substring(dot);
				}
				System.out.println("확장자명 : " + ext);
				if (!(ext.equals(".jpg") || ext.equals(".png") || ext.equals(".PNG") || ext.equals(".JPG"))) {// 파일확장자가
																												// 이미지가
																												// 아닌게
																												// 들어오면
																												// 전부
																												// 삭제후
																												// 다시
																												// 페이지를
																												// 요청
					for (int o = 0; o < 5; o++) {
						String filePath = path + "/" + mr.getFilesystemName("upfile" + o);
						File files = new File(filePath);
						if (files.exists()) {
							if (files.delete()) {
								System.out.println("파일삭제 성공");
							} else {
								System.out.println("파일삭제 실패");
							}
						} else {
							System.out.println("파일이 존재하지 않습니다.");
						}
					}
					request.setAttribute("msg", "이미지 일만 첨부하실수 있습니다!");
					request.setAttribute("loc", "/gowith/modify?gowithNo=" + gowithNo);
					request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
					return;
				} else {
					file[i] = true;// 파일이 널이 아닐때 만 true 값을 넣어준다

				}
			}
		}
		// 게시판 DB에 추가하는 로직
		System.out.println(10);
		
		new GowithService().updateGowith(g);
		
		System.out.println(11);
		new GowithService().deleteGFile(gowithNo);
		System.out.println(12);
		if (gowithNo > 0) {
			for (int i = 0; i < 5; i++) {// 파일 추가 로직
				if (file[i] == true) {
					GFile gf = new GFile();
					gf.setGowithNo(gowithNo);
					gf.setFileName(mr.getOriginalFileName("upfile" + i));
					gf.setFileRename(mr.getFilesystemName("upfile" + i));
					int gfresult = new GowithService().insertGF(gf);
					if(gfresult>0) {
						System.out.println("파일 등록 성공");
					}
				}
			}
		}
		System.out.println(13);
		request.setAttribute("msg", "게시글 수정 성공!");
		request.setAttribute("loc", "/gowith");
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
