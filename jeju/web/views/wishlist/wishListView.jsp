<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.member.model.vo.Member" %>    
<%
	Member loginUser2=(Member)session.getAttribute("loginUser");
%>
<%@ include file="/views/common/header.jsp" %>
<style>
	#wish_content{
		height:1000px;
		width:90%;
	}
	#wishId{
		margin-left:90px;
		margin-top:100px;
		font-size:30px;
	}
	#wishTable{
		margin-top:40px;
		margin-left:200px;
		border-collapse: seperate;
		border-spacing:100px;
	}
		
	#wishTable>tbody tr td{
		border-collapse: seperate;
		border-spacing:100px ;
	}
	

</style>



<section id="wishSection">
	
	<div id="wish_content" >
		<div id="wishId"><strong><%=loginUser2.getUserId() %>님의 위시리스트<hr></strong></div>	
		<form action="">
			<table id="wishTable">
				<tr id="wishtr">
					<td width="5%" height="300px">
						
						<img alt="" src="<%=request.getContextPath()%>/img/instagram/1.png" width="250px" height="250px" style=" border-radius: 50%;" >
						<br>
					</td>
					<td width="40%">
						
						상품설명 상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품
						설명상품설명상품설명상품설명
						상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명
					</td>
					<td width="10%">
						<button>삭제하기</button>
					</td>
					
				</tr>

				
				<tr>
					<td width="5%" height="300px">
						
						<img alt="" src="<%=request.getContextPath()%>/img/instagram/2.png" width="250px" height="250px" style=" border-radius: 50%;" >
					
					</td>
					<td>
						
						상품설명 상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품
						설명상품설명상품설명상품설명
						상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명
					</td>
					<td>
						<button>삭제하기</button>
					</td>
				</tr>
				
				
				<tr>
					<td width="5%" height="300px">
						
						<img alt="" src="<%=request.getContextPath()%>/img/instagram/3.png" width="250px" height="250px" style=" border-radius: 50%;" >
					
					</td>
					<td>
						
						상품설명 상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품
						설명상품설명상품설명상품설명
						상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명상품설명
					</td>
					<td>
						<button>삭제하기</button>
					</td>
				</tr>
			
				
			</table>
		
		</form>
	</div>
	


</section>
<%@ include file="/views/common/footer.jsp" %>