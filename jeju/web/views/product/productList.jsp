<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@page import="com.semi.member.model.vo.Member" %>    
<%
	Member loginUser2=(Member)session.getAttribute("loginUser");
%>

<section>
	
	<form action="<%=request.getContextPath() %>/payList" id="payFrm">
		<input type="hidden" id="pay" value="서귀포시 상품" name="pay">
		<!--여기에는 메인 상품 원래대로-->
	</form>
	
	
	<form action="wishListEnroll" id="wishFrm" target="iframe">
		<input type="hidden" name="productFilepath">
		<input type="hidden" name="productNum">
		<input type="hidden" name="productName" value="서귀포">
		<input type="hidden" name="productInfo">
		<input type="hidden" id="pageaddress" name="pageaddress" value="window.location.href">
	</form>
	<button  id="paybtn">결제하기</button>
	<button  id="wishbtn">위시리스트 추가</button>
	<iframe src="#" name="iframe" style="width:1px; height:1px; border:0; visibility:hidden;"></iframe>
	
</section>

<script>
	
		$("#paybtn").click(e=>{
			
			<%if(loginUser2==null){%>
				alert("로그인이 필요합니다");
			<%}else{%>
		
			
				
				$("#payFrm").submit();
			<%}%> 
				
		
		})
			$("#wishbtn").click(e=>{
			
			<%if(loginUser2==null){%>
				alert("로그인이 필요합니다");
			<%}else{%>
		
			
				
				$("#wishFrm").submit();
			<%}%> 
				
		
		})

		
</script>
<%@ include file="/views/common/footer.jsp" %>