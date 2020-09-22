<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@page import="com.semi.member.model.vo.Member" %>   

<%
	Member logginedMember2 = (Member)session.getAttribute("logginedMember");

%>

<section>
	
	<form action="<%=request.getContextPath() %>/payList" id="payFrm">
		<input type="hidden" id="productName" value="서귀포시 상품" name="productName">
		<input type="hidden" id="productPrice" value="50000" name="productPrice">
		<input type="hidden" id="productInfo" value="이거는 제주도 상품으로 서귀포를 시작으로 제주도 구석구석을 탐험하는 패키지입니당 하하하 호호호" name="productInfo">
		<input type="date" id="dateStart" value="" name="dateStart">
		<input type="date" id="dateEnd" value="" name="dateEnd">
		<input type="hidden" id="childNum" value="2" name="chaildNum">
		<input type="hidden" id="adultNum" value="5" name="adultNum">
		<input type="hidden" id="pageAddress" name="pageAddress" value="<%=request.getRequestURI()%>">
		<select name="date">
			<option>2019/09/12~2019/09/15</option>
			<option>2019/09/15~2019/09/20</option>
			<option>2019/09/17~2019/09/19</option>
		<%-- 	<option><%=여기에 변수 %></option> --%>
		</select>
		<!--여기에는 메인 상품 원래대로-->
	</form>
	
	
	<form action="wishListEnroll" id="wishFrm" target="iframe">

		<input type="hidden" name="userId" value="<%=logginedMember2.getUserId()%>">
		<input type="hidden" name="productNum" value="1">
		<input type="hidden" id="pageAddress" name="pageAddress" value="<%=request.getRequestURI()%>">
	</form>
	<button  id="paybtn">결제하기</button>
	<button  id="wishbtn">위시리스트 추가</button>
	<iframe src="#" name="iframe" style="width:1px; height:1px; border:0; visibility:hidden;"></iframe>
	
</section>

<script>
	
		$("#paybtn").click(e=>{
			
			<%if(logginedMember2==null){%>
				alert("로그인이 필요합니다");
			<%}else{%>
		
			
				
				$("#payFrm").submit();
			<%}%> 
				
		
		})
			$("#wishbtn").click(e=>{
			
			<%if(logginedMember2==null){%>
				alert("로그인이 필요합니다");
			<%}else{%>
		
			
				
				$("#wishFrm").submit();
			<%}%> 
				
		
		})

		
</script>
<%@ include file="/views/common/footer.jsp" %>