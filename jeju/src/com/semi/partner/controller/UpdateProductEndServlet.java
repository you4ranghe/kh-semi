package com.semi.partner.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.member.model.vo.Member;
import com.semi.partner.model.service.PartnerService;
import com.semi.product.model.vo.Product;

/**
 * Servlet implementation class UpdateProductEndServlet
 */
@WebServlet("/partner/updateProductEnd")
public class UpdateProductEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. type multipart/formdata방식으로 왔는지 확인
		if(!ServletFileUpload.isMultipartContent(request)) {
			//잘못된 요청이기때문에 중단됨 
			request.setAttribute("msg", "상품등록 오류[form:enctype] 관리자에게 문의하세요." );
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		//2.파일 업로드 처리하기 ->서버에 클라이언트가 보내준 파일 저장
		//	1 ) 저장할 경로를 (path)가져온다.
		//		servletContext객체를 이용해서 현재 프로젝트(애플리케이션)가 저장된 위치를 확인할 수 있음
		System.out.println(getServletContext().getRealPath("/"));
		// 저장경로는 반드시 생성되어있어야함 ->없다고 생성해주지 않음
		String path=getServletContext().getRealPath("/")+"upload/product"; //업로드 절대경로
		//	2 ) 저장할 파일의 최대 크기를 설정
		int maxSize=1024*1024*30;
		//	3 ) 문자에 대한 인코딩 값 설정
		String encode="UTF-8";
		//	4 ) 업로드된 파일에 대한 rename처리
		//	*불특정 다수에게 전달되어 오는 파일은 중복되는 명칭이 있을수 있으므로
		//	rename처리 객체를 이영헤서 처리함 defultFileRenamePolicy ->cos에서 제공하는 기본 리네임객체
		//	(우리가 만들수도있음
		
		//	request로 전달한 데이터를 cos.jar에서 제공하는 MultipartRequest객체가 처리
		//	MultipartRequest객체를 생성 -> 생성자를 이용해서 생성
		//	매개변수 1 : HttpServletRequest, 2 : 파일 경로, 3 : 파일사이즈, 4 : 인코딩값, 5 : rename규칙객체
		
		//객체를 생성하는 순간 해당 경로(path)에 파일이 자동으로 업로드됨.
		MultipartRequest mr=new MultipartRequest(request, path, maxSize, encode, new DefaultFileRenamePolicy());
		
		//MultipartRequest객체를 생성해서 처리할 때는 클라이언트 파라미터를 받아올때도 
		//request가 아닌 생성된 MultipartRequest객체를 사용한다
			
		//클라이언트가 보내준 값 받기
		
		Product p=new Product();
		HttpSession session=request.getSession();
		Member m=(Member)session.getAttribute("logginedMember");
		//p.setPartnerId(m.getUserId());
		p.setpNum(Integer.parseInt(mr.getParameter("pNum")));
		p.setpName(mr.getParameter("name"));
		p.setpBigNameEng(mr.getParameter("engName"));
		p.setpBigNameKor(mr.getParameter("korName"));
		p.setpPriceA(Integer.parseInt(mr.getParameter("adultPrice")));
		p.setpPriceC(Integer.parseInt(mr.getParameter("childPrice")));
		
		System.out.println(mr.getParameter("dateStart"));
		java.sql.Date s = java.sql.Date.valueOf(mr.getParameter("dateStart"));
		p.setpDateStart(s);
		java.sql.Date e = java.sql.Date.valueOf(mr.getParameter("dateFinish"));
		p.setpDateFinish(e);
		
		p.setpTime(mr.getParameter("time"));
		
		p.setpPointInfo(mr.getParameter("point"));
		p.setpInfo(mr.getParameter("point"));
		p.setpIntd(mr.getParameter("intd"));
		p.setRuntime(mr.getParameter("runtime"));
		
		p.setPrecaution(mr.getParameter("precaution"));
		String map=mr.getParameter("address");
		p.setpMapAddress(map);
		p.setpMap(mr.getParameter("map"));
		
		//filepath는 리네임된 파일명을 가져와야함
		System.out.println(mr.getFilesystemName("slider"));
		if(mr.getFilesystemName("slider")!=null) {
			String slider=mr.getFilesystemName("slider");
			p.setTitleImgPath(slider);
			System.out.println(p.getTitleImgPath());
			//사용자가 전달한 파일명과 동일한 파일을 클라이언트에게 보내줌
			//1. 전송할 파일에 대한 경로를 가져옴
//			String filepath=getServletContext().getRealPath("/upload/product");
//			String file=request.getParameter("sliderorigin");
//			
			//파일 입출력을 위한 스트림열기
			//1.hard에 있는 파일을 RAM으로 가져옴.
//			File f=new File(filepath+"/"+file);
//			System.out.println("f.getname : "+f.getName());
//			f.delete();
		}else {
			p.setTitleImgPath(mr.getParameter("sliderorigin"));
		}
		
		if(mr.getFilesystemName("main")!=null) {
			String main=mr.getFilesystemName("main");
			p.setpImgPath(main);
			
		}else {
			p.setpImgPath(mr.getParameter("mainorigin"));
		}
		
		
		if(mr.getFilesystemName("route")!=null) {
			String route=mr.getFilesystemName("route");
			p.setScheduleImgPath(route);
			
		}else {
			p.setScheduleImgPath(mr.getParameter("routeorigin"));
		}	
		
//		p.setPartnerId(m.getUserId());
		
		
		int result=new PartnerService().updateProduct(p);
		String msg="";
		String loc="";
		if(result>0) {
			msg="상품이 수정되었습니다!";
			loc="/partner/partnerProductList";//나중에 바로 상세페이지로 옮겨가기
		}else {
			msg="상품 수정에 실패하였습니다.";
			loc="/partner/updateProduct?pNum="+p.getpNum(); //나중에 상품수정 페이지가는걸로 바꾸기
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
//		수정은 오리지널패쓰와 뉴패쓰를 나눈뒤 뉴패쓰가있으면 업뎃 아니면 유지
//		삭제하면 이미지도 삭제되어야함 ->file.remove사용해서 해보셈
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
