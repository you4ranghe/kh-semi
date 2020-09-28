<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.semi.member.model.vo.Member" %>    
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Map" %>
<%
	Member logginedMember2 = (Member)session.getAttribute("logginedMember");

	ArrayList<Map<String, Object>> wishList =(ArrayList<Map<String, Object>>)request.getAttribute("list");
	int count=0;

	String startDate="";
	String endDate="";
	String info="";

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
	button{
		
    
    left:110px;
    top:10px;
    width:100px ;height:50px;
    background : darkgray;
    color : #fff;
    font-size:15px;
    border:none;
    border-radius:10px;
    font-weight: bold;
    cursor:pointer;
    margin:5px;


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

						<td width="20%" height="300px">
																																			
							<img alt="" src="<%=request.getContextPath()%>/upload/product/<%=m.get("imag")%>" width="250px" height="250px" style=" border-radius: 50%;" >
							<br>
						</td>
						<td width="55%">
	
							 <a href="<%=m.get("pageAddress")%>">
                        
                           <h2 style="font-size:25px;font-weight:bolder"><%=m.get("pName") %></h2>
                     
                           <%if(((String)m.get("pInfo")).length()>200) {%>
                              <%info=((String)m.get("pInfo")).substring(0,200)+"...."; %>
                           <%}else{ %>
                              <%info= (String)m.get("pInfo");%>
                           <%} %>
                           <p>
                              <%=info%>
                           </p>
                     
                        
                     </a>
								
								
							
								
						
						</td>
						<td width="9%">

							<p style="margin-left:20px; "> 

								<%startDate=(String)m.get("pDateStart"); %>
								<%endDate=(String)m.get("pDateFinish"); %>
								 <%=startDate.substring(0, 10) %> ~ <%=endDate.substring(0, 10) %>
							</p>
						</td>
						<td width="20%">
							<form action="<%=request.getContextPath()%>/wishListDelete">
								<button >삭제하기</button>

								<input type="hidden" name="userId" value="<%=logginedMember2.getUserId()%>">
								<input type="hidden" name="pName" value="<%=m.get("pName")%>">
							</form>
						</td>
						
					</tr>
		 	<%} %>


			<%}else{ %>

				<div style="positon:relative;left: 100px; margin-left:400px; margin-top:150px;" id="elseDiv">

					<p style="font-size:20px;font-weight:bolder">위시리스트가 존재하지 않습니다. 마음에 드는 상품들을 위시리스트에 추가해보세요</p>

					
				
				</div>
			<%} %>
	
		
				
			
				
			</table>
		
	</div>
	


</section>
<%@ include file="/views/common/footer.jsp" %>