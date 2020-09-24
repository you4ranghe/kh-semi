<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@page import="com.semi.member.model.vo.Member" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Map" %>
    
<%
	Member logginedMember2 = (Member)session.getAttribute("logginedMember");
	ArrayList<Map<String, Object>> reserveList =(ArrayList<Map<String, Object>>)request.getAttribute("reserveList");
	int count=0;
%>
<style>
	#reserve_content{
		width:90%;
	}
	#reserveTitle{
		margin-left:90px;
		margin-top:100px;
		font-size:30px;
	}
	#reserveTable{
		margin-top:40px;
		margin-left:200px;

	}
</style>
<section>
<%for(Map<String,Object>m:reserveList){ 
		count++;
 	} %>
		
	<div id="reserve_content" >
		<div id="reserveTitle"><strong><%=logginedMember2.getUserId() %>님의 예약 내역<hr></strong></div>	
				<table id="reserveTable">
				<%if(count!=0){ %>
			 	<%for(Map<String,Object>m:reserveList){ %>
					<tr id="reservetr">
						<td width="25%" height="300px">
							
							<img alt="" src="<%=request.getContextPath()%>/img/instagram/1.png" width="250px" height="250px" style=" border-radius: 50%;" >
							<br>
						</td>
						<td width="30%">
		
							<%=m.get("pInfo") %>
						</td>
						<td width="15%">
							<%=m.get("pDateStart") %>
						</td>
						<td width="20%">
							<%=m.get("price") %>
						</td>
						<td width="15%">
							<%=m.get("payOrderDate") %>
						</td>
					</tr>
		 	<%} %>
			<%}else{ %>
				<div style="margin-left:400px; margin-top:200px;" id="elseDiv">
					<h3>예약내역이 존재하지 않습니다.마음에 드는 상품들을 위시리스트에 추가해보세요</h3>
					
				
				</div>
			<%} %>
	
		
				
			
				
			</table>
		
	</div>
	
</section>
<%@ include file="/views/common/footer.jsp" %>