<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.payend.model.vo.payEnd, com.semi.member.model.vo.Member" %>
<%@ include file="/views/common/header.jsp"%>


<%
	payEnd pe=(payEnd)request.getAttribute("pe");
	Member m=(Member)request.getAttribute("m");
%>

<style>
	div.sidebarr{
		
	}
	h3{
		width:100%;
	}
	.marginadd{
		margin:10px;
	}
</style>
<section>
	<h3> 예약 관리 </h3>
	<div class="row">
	<div class="col-md-2">
<!-- 사이드 바 메뉴-->
  <!-- 패널 타이틀1 -->
		<div class="panel panel-info">
		    <div class="panel-heading">
		      <h3 class="panel-title">Panel Title</h3>
		    </div>
		    <!-- 사이드바 메뉴목록1 -->
		    <ul class="list-group">
		      <li class="list-group-item"><a href="#">HTML</a></li>
		      <li class="list-group-item"><a href="#">CSS</a></li>
		      <li class="list-group-item"><a href="#">ECMAScript5</a></li>
		    </ul>
		</div>
		  <!-- 패널 타이틀2 -->
		<div class="panel panel-default">
		  <div class="panel-heading">
		    <h3 class="panel-title">Panel Title</h3>
		  </div>
		    <!-- 사이드바 메뉴목록2 -->
		      <ul class="list-group">
		        <li class="list-group-item"><a href="#">jQuery</a></li>
		        <li class="list-group-item"><a href="#">BootStrap</a></li>
		      </ul>
		</div>      
		  <!-- 패널 타이틀3 -->
		<div class="panel panel-info">
		  <div class="panel-heading">
		    <h3 class="panel-title">Panel Title</h3>
		  </div>
		      <!-- 사이드바 메뉴목록3 -->
		      <ul class="list-group">
		        <li class="list-group-item"><a href="#">About</a></li>
		        <li class="list-group-item"><a href="#">Help</a></li>
		      </ul>
		    </div>
		</div> 
	
	<div id="pe-table" class="col-md-9">
	<table class="table table-bordered">
		<tr>
			<th style="width: 14%">예약번호</th>
			<td><%=pe.getPayNum() %></td>
		</tr>
		<tr>
			<th style="width:14%">예약완료 시간</th>
			<td><%=pe.getPayDate() %></td>
		</tr>
		<tr>
			<th>주문자<br>(휴대전화)</th>
			<td><%=m.getUserName() %>(<%=m.getPhone() %>)</td>
		</tr>
		<tr>
			<th>예약인 대표<br>(휴대전화)</th>
			<td><%=pe.getPayName() %> (<%=pe.getPayPhone() %>****)</td>
		</tr>
		<tr>
			<th style="width: 14%">총 결제 금액<br>[결제수단]</th>
			<td><%=pe.getTotalPrice() %>원 [<%=pe.getPayType() %>]</td>
		</tr>
			<!-- <th style="width: 14%">이미지</th>
			<th style="width: 49%">상품 정보</th>
			<th style="width: 12%">인원</th> -->
			
		
	</table>
	
	
	
	
	<table class="table table-bordered">
		<tr>
			<th style="width: 13%">이미지</th>
			<th style="width: 63%">상품명</th>
			<th style="width: 12%">인원</th>
			<th style="width: 12%">총 결제 금액<br>[결제수단]</th>
			
		</tr>
		
		<tr>
			<td><img src="<%=request.getContextPath()%>/upload/product/<%=pe.getTitleImgPath()%>" width="100px" height="100px"></td>
			<td>
				<h3><%=pe.getProductName() %></h3><br>
				이용 날짜 : <%=(pe.getDateStart()).substring(0,10) %>
			</td>
			<td>
				<p>성인 : <%=pe.getAdultNum() %></p>
				<p>어린이 : <%=pe.getChildNum() %></p>
			</td>
			<td><%=pe.getTotalPrice() %> [<%=pe.getPayType() %>]</td>
		</tr>
		
	
	</table>

	
	
	</div>
	
</div>
<div class="container marginadd">
	<div class="row">
		<div class="col-lg-12 text-right">
			<a href="<%=request.getContextPath()%>/partner/deleteOrder?peNum=<%=pe.getPayNum()%>"><button class="btn btn-danger btn-sm">예약취소하기</button></a>
			<a href="<%=request.getContextPath()%>/partner/partnerOrderList"><button class="btn btn-default btn-sm">목록으로</button></a>
		
		</div>
		
		</div>
		
		</div>
</section>

<%@ include file="/views/common/footer.jsp"%>