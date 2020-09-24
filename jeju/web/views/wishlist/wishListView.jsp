<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.semi.member.model.vo.Member" %>    
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Map" %>
<%
	Member logginedMember2 = (Member)session.getAttribute("logginedMember");

	ArrayList<Map<String, Object>> wishList =(ArrayList<Map<String, Object>>)request.getAttribute("list");
	int count=0;
%>
<%@ include file="/views/common/header.jsp" %>
<style>
	#wish_content{
		/* height:2000px;
 */		width:90%;
	}
	#wishId{
		margin-left:90px;
		margin-top:100px;
		font-size:30px;
	}
	#wishTable{
		margin-top:40px;
		margin-left:200px;

	}
	#elseDiv{
		height:300px;
	}

</style>

<section id="wishSection">
	<%for(Map<String,Object>m:wishList){ 
		count++;
 	} %>
		
	<div id="wish_content" >
		<div id="wishId"><strong><%=logginedMember2.getUserId() %>님의 위시리스트<hr></strong></div>	
				<table id="wishTable">
				<%if(count!=0){ %>
			 	<%for(Map<String,Object>m:wishList){ %>
					<tr id="wishtr">
						<td width="25%" height="300px">
							
							<img alt="" src="<%=request.getContextPath()%>/img/instagram/1.png" width="250px" height="250px" style=" border-radius: 50%;" >
							<br>
						</td>
						<td width="50%">
							<h2><a href="<%=m.get("pageAddress")%>"><%=m.get("pName") %></a></h2>
							<%=m.get("pInfo") %>
						</td>
						<td width="15%">
							<%=m.get("pDateStart") %> ~<%=m.get("pDateFinish") %>
						</td>
						<td width="20%">
							<form action="<%=request.getContextPath()%>/wishListDelete">
								<button>삭제하기</button>
								<input type="hidden" name="userId" value="<%=logginedMember2.getUserId()%>">
								<input type="hidden" name="pName" value="<%=m.get("pName")%>">
							</form>
						</td>
						
					</tr>
		 	<%} %>
			<%}else{ %>
				<div style="margin-left:400px; margin-top:200px;" id="elseDiv">
					<h3>위시리스트가 존재하지 않습니다.마음에 드는 상품들을 위시리스트에 추가해보세요</h3>
					
				
				</div>
			<%} %>
	
		
				
			
				
			</table>
		
	</div>
	


</section>
<%@ include file="/views/common/footer.jsp" %>