package com.semi.admin.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.semi.admin.model.dao.AdminDao;
import com.semi.member.model.vo.Member;
import com.semi.partner.model.vo.Partner;
import com.semi.payment.model.vo.Payment;
import com.semi.product.model.vo.Product;


public class AdminService {

	private AdminDao dao=new AdminDao();
	//========결제내역 관리==========
	//결제내역 리스트에 담아오고 페이징 처리
	public List<Payment>selectPaymentList(int cPage, int numPerPage){	
		Connection conn=getConnection();
		List<Payment> list=dao.selectPaymentList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	//결제내역 총 데이터객수 조회
	public int selectPaymentCount() {
		Connection conn=getConnection();
		int count=dao.selectPaymentCount(conn);
		close(conn);
		return count;
	}
	
	//검색키워드와 타입에 다른 결제 내역 객체 리스트에 담아오는 서비스
	public List<Payment> selectPaymentSearch(String type,String keyword,int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Payment> list=dao.selectPaymentSearch(conn,type, keyword,cPage,numPerpage);
		close(conn);
		return list;
	}
	
	//검색키워드 타입에 다른 결제 내역 객체 총 수 조회 서비스
	public int selectPaymentSearchCount(String type, String keyword) {
		Connection conn=getConnection();
		int count=dao.selectPaymentSearchCount(conn,type, keyword);
		close(conn);
		return count;
	}
	
	//결제 번호로 결제내역 테이블 가져오기
	public Payment selectPaymentOne(int poNum) {
		Connection conn = getConnection();
		Payment p  =dao.selectPaymentOne(conn,poNum);
		close(conn);
		return p;
	}
	
	
	//========상품 관리==========
	//상품 객체 리스에 담아오기 페이징 처리
	public List<Product>selectProductList(int cPage, int numPerPage){	
		Connection conn=getConnection();
		List<Product> list=dao.selectProductList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	//상품 객체 총 데이터 수 가져오기
	public int selectProductCount() {
		Connection conn=getConnection();
		int count=dao.selectProductCount(conn);
		close(conn);
		return count;
	}
	
	//검색키워드와 타입에 다른 상품객체 리스트에 담아오는 서비스
	public List<Product> selectProductSearch(String type,String keyword,int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Product> list=dao.selectProductSearch(conn,type, keyword,cPage,numPerpage);
		close(conn);
		return list;
	}
	
	//검색키워드 타입에 다른 상품객체 총 수 조회 서비스
	public int selectProductSearchCount(String type, String keyword) {
		Connection conn=getConnection();
		int count=dao.selectProductSearchCount(conn,type, keyword);
		close(conn);
		return count;
	}
	
	
	//========멤버 관리==========
	//멤버 객체 리스트 담오이기 페이징 처리
	public List<Member> selectMemberList(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Member> list=dao.selectMemberList(conn,cPage,numPerpage);
		close(conn);
		return list;
	}
	
	//검색키워드와 타입에 다른 회원객체 리스트에 담아오는 서비스
	public List<Member> selectMemberSearch(String type, String keyword,int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Member> list=dao.selectMemberSearch(conn,type, keyword,cPage,numPerpage);
		close(conn);
		return list;
	}
	
	//멤버객체 총 데이터 수 조회 서비스
	public int selectMemberCount() {
		Connection conn=getConnection();
		int count=dao.selectMemberCount(conn);
		close(conn);
		return count;
	}
	//검색키워드 타입에 다른 멤버객체 총 수 조회 서비스
	public int selectMemberSearchCount(String type, String keyword) {
		Connection conn=getConnection();
		int count=dao.selectMemberSearchCount(conn,type, keyword);
		close(conn);
		return count;
	}
	

	//강제 회원 탈퇴 서비스
	public int adminDeleteMember(String userId) {
		Connection conn=getConnection();
		int result=dao.adminDeleteMember(conn,userId);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	//========파트너 관리==========
	//파트너 정보 보기 서비스
	public List<Partner> selectPartnerList(int cPage,int numPerPage){
		Connection conn=getConnection();
		List<Partner>list =dao.selectPartnerList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	//검색한 파트너 조회 서비스
	public int selectPartnerSearchCount(String type, String keyword) {
		Connection conn=getConnection();
		int count=dao.selectPartnerSearchCount(conn,type, keyword);
		close(conn);
		return count;
	}
	
	//총파트너 인원 가져오는 서비스
	public int selectPartnerCount() {
		Connection conn = getConnection();
		int totalCount = dao.selectPartnerCount(conn);
		close(conn);
		return totalCount;
	}
	
	//타입,키워드에 다른 파트너 조회 서비스
	public List<Partner> selectPartnerSearch(String type, String keyword,int cPage,int numPerPage){
		Connection conn=getConnection();
		List<Partner>list=dao.selectPartnerSearch(conn,type,keyword,cPage,numPerPage);
		close(conn);
		return list;
	}
	
	//파트너 탈퇴 서비스
	public int deletePartner(String partnerId) {
		Connection conn = getConnection();
		int result =dao.deletePartner(conn,partnerId);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	
	//파트너 승인 서비스
	public int acceptPartner(String partnerId) {
		Connection conn= getConnection();
		int result=dao.acceptPartner(conn,partnerId);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}
	

	
}












