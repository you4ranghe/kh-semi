<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@page import="com.member.model.vo.Member" %>    
<%
	Member loginUser2=(Member)session.getAttribute("loginUser");
%>

<section>
	
	<form action="">
		<button onclick="paybtn();">결제하기</button>	
	</form>
	
</section>


<script>
	function paybtn(){
		if(loginUser==null){
			alert("로그인이 필요합니다")
		}
		else{
			this.submit();	
		}
	}


</script>
<%@ include file="/views/common/footer.jsp" %>