<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.semi.product.model.vo.Product" %>
<%
	List<Product> list=(List)request.getAttribute("products");
	String type=request.getParameter("searchType");
	String keyword=request.getParameter("searchkeyword");
	String numPerPage=request.getParameter("numPerPage");
%>    
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/adminProductList.css" type="text/css">
<%@ include file="/views/common/header.jsp" %>

<div class="memberList_img"></div>
<div class="box">
	<h2 id="h2">상품 관리</h2>
	<ul>
		<li class="box"><a href="<%=request.getContextPath()%>/admin/memberList">회원 관리&nbsp;&nbsp;</a></li>
		<li class="box"><a href="<%=request.getContextPath()%>/admin/partnerList">파트너 관리&nbsp;&nbsp;</a></li>
		<li class="box"><a href="<%=request.getContextPath()%>/admin/productList">상품 관리&nbsp;&nbsp;</a></li>
		<li class="box"><a href="<%=request.getContextPath()%>/admin/paymentList">결제 관리</a></li>
	</ul>
</div>

<div id="search-container">

	<select  id="searchType">
		<option value="userId" <%=type!=null && type.equals("partner_id")?"selected":"" %>>상품판매자</option>
		<option value="userName" <%=type!=null && type.equals("p_map_address")?"selected":"" %>>여행지역(출발지)</option>
		<option value="gender" <%=type!=null && type.equals("p_num")?"selected":"" %>>상품번호</option>			
	</select>
	
	<div id="numPerpage-container">
		<form id="numperPageFrm" name="numPerPagetFrm" action="<%=request.getContextPath()%>/admin/productList">
			<input type="hidden" name="cPage" value='<%=request.getParameter("cPage") %>'>
		<select name="numPerPage" id="numPerPage">
			<option	value="10" <%=numPerPage!=null&&numPerPage.equals("10")?"selected":"" %>>10</option>
			<option	value="5" <%=numPerPage==null||numPerPage.equals("5")?"selected":"" %>>5</option>
			<option	value="3" <%=numPerPage!=null&&numPerPage.equals("3")?"selected":"" %>>3</option>
		</select>
		</form>
	</div>
	
	<div id="search-userId">
		<form action="<%=request.getContextPath()%>/admin/productSearch">
			<input type="hidden" name="searchType" value="partner_id">
			<input class="search-input" type="text" name="searchkeyword" size="25" autocomplete="off"
			placeholder="조회할 상품판매자 아아디 입력하세요" value="<%=type!=null&&type.equals("partner_id")?keyword:""%>">
			<input type="hidden" name="numPerPage" value='<%=numPerPage==null?"5":numPerPage%>'>
			<button class="search-btn" type="submit">검색</button>
		</form>
	</div>
	
	<div id="search-userName">
		<form action="<%=request.getContextPath()%>/admin/productSearch">
			<input type="hidden" name="searchType" value="p_map_address">
			<input class="search-input" type="text" name="searchkeyword" size="25" autocomplete="off"
			placeholder="조회할 여행지(출발지)를 입력하세요" value="<%=type!=null&&type.equals("p_map_address")?keyword:""%>">
			<input type="hidden" name="numPerPage" value='<%=numPerPage==null?"5":numPerPage%>'>
			<button class="search-btn"  type="submit">검색</button>
		</form>
	</div>
	
	<div id="search-gender">
		<form action="<%=request.getContextPath()%>/admin/productSearch">
			<input type="hidden" name="searchType" value="p_num">
			<input class="search-input" type="text" name="searchkeyword" size="25" autocomplete="off"
			placeholder="조회할 상품번호를 입력하세요" value="<%=type!=null&&type.equals("p_num")?keyword:""%>">
			<input type="hidden" name="numPerPage" value='<%=numPerPage==null?"5":numPerPage%>'>
			<button class="search-btn"  type="submit">검색</button>
		</form>
	</div>
			
		</div>
		<section id="memberList-container">

				<div id="tbl-member-container">
					<table class="tbl-member">
						<thead>
							<tr>
								<th>상품번호</th>
								<th>판매자</th>
								<th>상품이름</th>
								<th>출발날짜</th>
								<th>종료날짜</th>
								<th>출발시간</th>
								<th>여행지(출발지)</th>
								


			</tr>
		<thead>

		<tbody>
		<%for(Product p : list) {%>
			<tr>
				<td>
					<a href="<%=request.getContextPath()%>/admin/productView?pNum=<%=p.getpNum() %>&partnerId=<%=p.getPartnerId()%>">
						<%=p.getpNum() %></a>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/admin/productView?pNum=<%=p.getpNum() %>&partnerId=<%=p.getPartnerId()%>">
					<%=p.getPartnerId()%></a>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/admin/productView?pNum=<%=p.getpNum() %>&partnerId=<%=p.getPartnerId()%>">
					<%=p.getpBigNameKor()%></a>
				</td>
				<td><a href="<%=request.getContextPath()%>/admin/productView?pNum=<%=p.getpNum() %>&partnerId=<%=p.getPartnerId()%>">
					<%=p.getpDateStart() %></a>
				</td>
				<td><a href="<%=request.getContextPath()%>/admin/productView?pNum=<%=p.getpNum() %>&partnerId=<%=p.getPartnerId()%>">
					<%=p.getpDateFinish() %></a>
				</td>
				<td><a href="<%=request.getContextPath()%>/admin/productView?pNum=<%=p.getpNum() %> &partnerId=<%=p.getPartnerId()%>">
					<%=p.getpTime()%></a>
				</td>
				<td><a href="<%=request.getContextPath()%>/admin/productView?pNum=<%=p.getpNum() %>&partnerId=<%=p.getPartnerId()%>">
					<%=p.getpMapAddress() %></a>
				</td>
		

			</tr>
		<%} %>	
		</tbody>
	</table>
</div>
	<div id="pageBar">
		<%=request.getAttribute("pageBar") %>
		</div>
	</section>

<script>
	//검색타입 체인지 이벤트
	$(function(){
		$("#searchType").change(e => {
			let userId=$("#search-userId");
			let userName=$("#search-userName");
			let gender=$("#search-gender");
			
			userId.css("display","none");
			userName.css("display","none");
			gender.css("display","none");
			
			let value=$(e.target).val();
			$("#search-"+value).css("display","inline-block");
		});
		$("#searchType").change();
		
		$("#numPerPage").change(e => {
			
			$("#numperPageFrm").submit();
		});
	})
</script>

<%@ include file="/views/common/footer.jsp" %>











