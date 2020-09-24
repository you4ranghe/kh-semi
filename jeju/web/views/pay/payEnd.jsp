<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@page import="com.semi.member.model.vo.Member" %>    
<%
	Member logginedMember2 = (Member)session.getAttribute("logginedMember");
%>

<section style="width:1200px;height:500px;">
	<div style="margin-left:700px;margin-top:300px;width:100%">
		<h2><%=logginedMember2.getUserId() %>님의 예약이 완료되었습니다.</h2>
	
	</div>
</section>

<%@ include file="/views/common/footer.jsp" %>