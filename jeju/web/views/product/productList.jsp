<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@page import="com.member.model.vo.Member" %>    
<%
	Member loginUser2=(Member)session.getAttribute("loginUser");
%>

<section>
	
	<form action="<%=request.getContextPath() %>/payList" id="payBtn">
		<input type="hidden" id="pay" value="서귀포시 상품" name="pay">
	
	</form>
	<button  id="paybn">결제하기</button>
	
	
</section>


<script>
	
		$("#paybn").click(e=>{
			
			<%if(loginUser2==null){%>
				alert("로그인이 필요합니다");
			<%}else{%>
		
			
				
				$("#payBtn").submit();
			<%}%> 
				
		
		})

		
</script>
<%@ include file="/views/common/footer.jsp" %>