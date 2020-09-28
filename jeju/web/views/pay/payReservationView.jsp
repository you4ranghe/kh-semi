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

	String date="";
	String info="";

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

	th{
		text-align:center;

		
	}
	td{
		text-align:center;
		color:rgb(72, 71, 78);
	}
	 a:link { color:rgb(72, 71, 78); text-decoration: none;}

	div#pageBar{margin-top:10px; text-align:center; margin-bottom:50px;}
	div#pageBar span.cPage{color: #0066ff;}

</style>
<section>
<%for(Map<String,Object>m:reserveList){ 
		count++;
 	} %>
		
	<div id="reserve_content" >
		<div id="reserveTitle"><strong><%=logginedMember2.getUserId() %>님의 예약 내역<hr></strong></div>	
				<table id="reserveTable">
				<%if(count!=0){ %>

					<tr>
						<th>
						
						</th>
						
						<th>
						 상품 설명
						</th>						
						
						<th>
						 상품 날짜
						</th>
						
						<th>
						 총 가격
						</th>
						
						<th>
						 구매 일시
						</th>
						
			
					</tr>
						
			 	<%for(Map<String,Object>m:reserveList){ %>
					<tr id="reservetr">
						<td width="20%" height="300px">
							
							<img alt="" src="<%=request.getContextPath()%>/upload/product/<%=m.get("imag")%>" width="225px" height="225px"  >
							<br>
						</td>
						<td width="50%" style="font-size:15px;font-weight: bolder;">
						<a href="<%=request.getContextPath()%>/detailReserve?poNum=<%=m.get("poNum") %>&userId=<%=logginedMember2.getUserId() %>">
                        <%if(((String)m.get("pInfo")).length()>230) {%>
                              <%info=((String)m.get("pInfo")).substring(0,230)+"...."; %>
                           <%}else{ %>
                              <%info= (String)m.get("pInfo");%>
                           <%} %>
								<%=info%>
	                       </a>
							
						</td>
						<td width="10%">
						<p style="margin-left:20px;">
							<%date=(String)m.get("pDateStart"); %>
							 <%=date.substring(0, 10) %> 
						</p>
						 <%-- 	<%=m.get("pDateStart") %>  --%>
						</td>
						<td width="10%">
							<%=m.get("price") %>
						</td>
						<td width="10%">

							<%=m.get("payOrderDate") %>
						</td>
					</tr>
		 	<%} %>
			<%}else{ %>

				<div style="margin-left:700px; margin-top:300px;height:300px;" id="elseDiv">
					<p style="font-size:25px;font-weight:bolder">예약내역이 존재하지 않습니다.</p>

				
				</div>
			<%} %>
	
		
				
			
				
			</table>
		
	</div>

		<div id="pageBar">
			<%=request.getAttribute("pageBar") %>
		</div>

	
</section>
<%@ include file="/views/common/footer.jsp" %>