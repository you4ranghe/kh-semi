<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@page import="com.semi.member.model.vo.Member" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Map" %>    
<%
	Member logginedMember2 = (Member)session.getAttribute("logginedMember");
	ArrayList<Map<String, Object>> detailList =(ArrayList<Map<String, Object>>)request.getAttribute("detailList");
	String date="";
%>
<style>
input{
		margin:10px;
		
		text-align:center;
		/* height:25px; */
		background-color: transparent;
  		border:none;
   		border-bottom:1px solid #999;
   		font-weight: bold;
  		font-size: 15px; color:dodgerblue;
   		outline: none;
	}
	input:focus{
		border: 1px solid #0af; 
		outline: none; 
		-moz-box-shadow: 0px 0px 15px rgba(0, 170, 255,.5);
		-webkit-box-shadow: 0px 0px 15px rgba(0, 170, 255,.5);
		box-shadow: 0px 0px 15px rgba(0, 170, 255,.5);
	}
	#payContent div{
		border:1opx solid gray;
		margin-bottom:50px;
		box-shadow: 30px 30px 70px rgba(0,0,0,0.2);
		border-radius:10px;
		padding:30px;

		font-weight: bold; 
		color:gray;
		font-family: 돋움체;

	}
	th{
    color:yellowgreen;
    font-size:15px;
    font-weight: bold;
	}


	.int-area input{
    width: 100%;
    padding : 20px 10px 10px;
    background-color: transparent;
    border:none;
    border-bottom:1px solid #999;
    font-weight: bold;
    font-size: 15px; color:dodgerblue;
    outline: none;
	}
	
	#productContent{
		width:800px;
		height:500px;
	}
	 #orderContent{
		width:800px;
		height:300px;
	}
	
	#reservation{
		width:800px;
		height:300px;
	}
	
/* 	#paytype{
		width:800px;
		height:200px;
	} */
	
	
	#payContent{
		margin-left:600px;
		
		margin-top:100px;
	}
	#payContent div table{
		margin-left:50px;
		
	}
	#productContent {
		
	
	}
	#orderContent input{
		width:350px;
		margin-left:100px;
	}
	#reservation input{
		width:350px;
		margin-left:100px;
	}
	strong{
		font-size:20px;
	}
	#paybtn{
		margin-left:200px; 
		margin-top:20px; 
		margin-bottom:50px;
		width:100px;
		height:50px;
		border-radius:10px;
	}
	#payreset{
		margin-left:200px;
	 	width:100px;
	 	height:50px;
	 	border-radius:10px;
	}
</style>

<section id="payContent" style="width:1250px;">

	
	<strong>결제상품 상세 내역</strong>
	<%for(Map<String,Object>m:detailList){ %>
	<div id="productContent">
		<table>
			<tr>
				<td rowspan="5">
					<img alt="" src="<%=request.getContextPath() %>/upload/product/<%=m.get("imag")%>" width="200px" height="200px" >
				</td>
			</tr>
			<tr>
				<td>
					상품번호
				</td>
				<td>
					<input type="text" readonly value="<%=m.get("pNum")%>" name="productNum"> 
				</td>
			</tr>
			<tr>
				<td>
					상품명
				</td>
				<td>
					<input type="text" value="<%=m.get("pName")%>" readonly>
				</td>
				
			</tr>
			<tr>
				<td>
					인원수 
				</td>
				<td>
					어린이 : <input type="text" name="chaildNum" value="<%=m.get("pCountC")%>"style="width:30px;" readonly> 어른 : <input type="text" name="adultNum"value="<%=m.get("pCountA") %>"style="width:30px;" readonly>
				</td>
				
			</tr>
			<tr>
				<td>
					일정
				</td>
				<td>	
						<%date=(String)m.get("pDateStart"); %>
						<%=date.substring(0, 10) %> 
				</td>
				
			</tr>
			<tr>
				<td colspan="3">
					<textarea rows="7" cols="70" style="margin-top:15px;  resize: none;  font-weight: bold; color:gray" readonly> <%=m.get("pInfo") %>
				
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<p style="float:right;">총가격 : <%=m.get("price") %></p> <input type="hidden" name="totalPrice">			
				</td>
			</tr>
		</table>
		
	</div>
	
	
	<strong>예약인 대표 정보</strong>
	<div id="reservation">
		 
		<table>
			<tr>
				<td>
					예약인 성명
				</td>
				<td>
					<input type="text" value="<%=m.get("payUserName") %>" id="payuser" name="payuser" readonly>
				</td>	
			</tr>
			<tr>
				<td>
					예약인 주소
				</td>
				<td>
					<input type="text" id="payaddress" value="<%=m.get("payAddress") %>" name="payaddress" readonly>
				<!-- 	<input type="text" id="sample6_postcode" placeholder="우편번호" style="">
					<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" id="sample6_address" placeholder="주소"><br>
					<input type="text" id="sample6_detailAddress" placeholder="상세주소">
					<input type="text" id="sample6_extraAddress" placeholder="참고항목"> -->
				</td>
			</tr>
			<tr>
				<td>
					예약인 전화번호
				</td>
				<td>
					<input type="text" id="payphone" name="payphone"value="<%=m.get("payPhone")%>" readonly>
				</td>
			</tr>
			<tr>
				<td>
					이메일
				</td>
				<td>
					<input type="text" id="payemail" name="payemail" readonly value="<%=m.get("payEmail")%>">
				</td>
			</tr>
		</table>
		
	</div>
		<strong>결제 방법</strong>
	<div id="paytype" style="width:800px;">
		<%=m.get("poType") %>
	

	<%} %>
	</div>
	
	</section>
	<%@ include file="/views/common/footer.jsp" %>
