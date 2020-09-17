<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@page import="com.member.model.vo.Member" %>    
<%
	Member loginUser2=(Member)session.getAttribute("loginUser");
%>

<section>
		<%=loginUser2.getUserId() %>님의 예약이 완료되었습니다.
		<button>예약조회</button> <button>다른 상품 추가예약</button>
	
</section>

<%@ include file="/views/common/footer.jsp" %>