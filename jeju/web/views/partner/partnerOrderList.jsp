<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import ="java.util.List,com.semi.payend.model.vo.payEnd,java.text.SimpleDateFormat" %>

<%
	List<payEnd> list=(List)request.getAttribute("list");
	SimpleDateFormat fr = new SimpleDateFormat("yyyy-MM-dd");

%>


<style>
	div.sidebarr{
		
	}
	h3{
		width:100%;
	}

	.partner-navi>ul>li{
			float:left;
			padding:5px;
			}
	.table-mar{
		margin:50px;
	
	}
	.part-title{
		margin:20px;
	
	}
</style>
<section>
	<h3 class="part-title">&nbsp&nbsp예약 관리 </h3>
	<div class="container">
		<div class="row">
		<div class="col-lg-12 text-center">
			<div class="partner-navi text-center" >
				<ul>
					<li><a href="<%=request.getContextPath() %>/partner/partnerView?partnerId=<%=logginedPartner.getPartnerId() %>">  ♥ 파트너 프로필</a><li>
					<li><a href="<%=request.getContextPath()%>/partner/partnerProductList">  ♥ 내 상품 보기</a><li>
					<li><a href="<%=request.getContextPath()%>/partner/partnerOrderList">  ♥ 판매 내역 조회하기</a></li>
					<li><a href="<%=request.getContextPath()%>/partner/addProduct">  ♥ 상품 등록하기</a></li>
				</ul>
			</div>
			</div>
			</div>
		</div>
	<div class="row">
	<!-- <div class="col-md-2">
사이드 바 메뉴
  패널 타이틀1

		<div class="panel panel-info">
		    <div class="panel-heading">
		      <h3 class="panel-title">Panel Title</h3>
		    </div>

		    사이드바 메뉴목록1

		    <ul class="list-group">
		      <li class="list-group-item"><a href="#">HTML</a></li>
		      <li class="list-group-item"><a href="#">CSS</a></li>
		      <li class="list-group-item"><a href="#">ECMAScript5</a></li>
		    </ul>
		</div>

		  패널 타이틀2

		<div class="panel panel-default">
		  <div class="panel-heading">
		    <h3 class="panel-title">Panel Title</h3>
		  </div>

		    사이드바 메뉴목록2

		      <ul class="list-group">
		        <li class="list-group-item"><a href="#">jQuery</a></li>
		        <li class="list-group-item"><a href="#">BootStrap</a></li>
		      </ul>
		</div>      

		  패널 타이틀3

		<div class="panel panel-info">
		  <div class="panel-heading">
		    <h3 class="panel-title">Panel Title</h3>
		  </div>

		      사이드바 메뉴목록3

		      <ul class="list-group">
		        <li class="list-group-item"><a href="#">About</a></li>
		        <li class="list-group-item"><a href="#">Help</a></li>
		      </ul>
		    </div>

		</div>  -->
	
	<div id="table-container" class="col-md-9">
	<table class="table table-hover table-bordered table-mar">
		<tr>

			<th style="width: 14%">예약일자<br>[예약번호]</th>
			<th style="width: 13%">이미지</th>
			<th style="width: 49%">상품 정보</th>
			<th style="width: 12%">인원</th>
			<th style="width: 12%">결제 금액<br>[결제수단]</th>

		</tr>
		<%for(payEnd pe:list){ %>
		<tr>

			<td><a href="<%=request.getContextPath()%>/partner/orderDetail?pe=<%=pe.getPayNum()%>"><%=pe.getPayDate() %><br>[<%=pe.getPayNum() %>]</a></td>
			<td><a href="<%=request.getContextPath()%>/partner/orderDetail?pe=<%=pe.getPayNum()%>"><img src="<%=request.getContextPath()%>/upload/product/<%=pe.getTitleImgPath()%>" width="100px" height="100px"></a></td>
			<td><a href="<%=request.getContextPath()%>/partner/orderDetail?pe=<%=pe.getPayNum()%>">
			<h3><%=pe.getProductName() %></h3><br>
				이용 날짜 : <%=(pe.getDateStart()).substring(0,10) %></a>
			</td>
			<td><a href="<%=request.getContextPath()%>/partner/orderDetail?pe=<%=pe.getPayNum()%>">
				<p>성인 : <%=pe.getAdultNum() %></p>
				<p>어린이 : <%=pe.getChildNum() %></p></a>
			</td>
			<td><a href="<%=request.getContextPath()%>/partner/orderDetail?pe=<%=pe.getPayNum()%>"><%=pe.getTotalPrice() %> [<%=pe.getPayType() %>]</a></td>

		</tr>
		<%} %>
	
	</table>
	
	</div>
	
</div>
	 
	<nav aria-label="Page navigation example text-center" style="margin-bottom: 20px;">
                <ul id="pageNavUl" class="pagination justify-content-center text-center">
                    <%=request.getAttribute("pageBar") %>
                </ul>
            </nav>
	
</section>

<%@ include file="/views/common/footer.jsp"%>