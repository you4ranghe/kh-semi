<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.semi.payment.model.vo.Payment" %>
<%
	List<Payment> list=(List)request.getAttribute("payments");
	String type=request.getParameter("searchType");
	String keyword=request.getParameter("searchkeyword");
	String numPerPage=request.getParameter("numPerPage");
%>    
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/adminpaymentList.css" type="text/css">
<%@ include file="/views/common/header.jsp" %>

<div class="memberList_img"></div>
<div class="box">
	<h2 id="h2">결제 관리</h2>
	<ul>
		<li class="box"><a href="<%=request.getContextPath()%>/admin/memberList">회원 관리&nbsp;&nbsp;</a></li>
		<li class="box"><a href="<%=request.getContextPath()%>/admin/partnerList">파트너 관리&nbsp;&nbsp;</a></li>
		<li class="box"><a href="<%=request.getContextPath()%>/admin/productList">상품 관리&nbsp;&nbsp;</a></li>
		<li class="box"><a href="<%=request.getContextPath()%>/admin/paymentList">결제 관리</a></li>
	</ul>
</div>

<div id="search-container">

	<select  id="searchType">
		<option value="userId" <%=type!=null && type.equals("po_num")?"selected":"" %>>결제번호</option>
		<option value="userName" <%=type!=null && type.equals("user_id")?"selected":"" %>>판매자</option>
		<option value="gender" <%=type!=null && type.equals("pay_user_name")?"selected":"" %>>결제자</option>		
					
	</select>
	
	<div id="numPerpage-container">
		<form id="numperPageFrm" name="numPerPagetFrm" action="<%=request.getContextPath()%>/admin/paymentList">
			<input type="hidden" name="cPage" value='<%=request.getParameter("cPage") %>'>
		<select name="numPerPage" id="numPerPage">
			<option	value="10" <%=numPerPage!=null&&numPerPage.equals("10")?"selected":"" %>>10</option>
			<option	value="5" <%=numPerPage==null||numPerPage.equals("5")?"selected":"" %>>5</option>
			<option	value="3" <%=numPerPage!=null&&numPerPage.equals("3")?"selected":"" %>>3</option>
		</select>
		</form>
	</div>
	
	<div id="search-userId">
		<form action="<%=request.getContextPath()%>/admin/paymentSearch">
			<input type="hidden" name="searchType" value="po_num">
			<input class="search-input" type="text" name="searchkeyword" size="25" autocomplete="off"
			placeholder="조회할  결제 번호를 입력하세요" value="<%=type!=null&&type.equals("po_num")?keyword:""%>">
			<input type="hidden" name="numPerPage" value='<%=numPerPage==null?"5":numPerPage%>'>
			<button class="search-btn" type="submit">검색</button>
		</form>
	</div>
	
	<div id="search-userName">
		<form action="<%=request.getContextPath()%>/admin/paymentSearch">
			<input type="hidden" name="searchType" value="user_id">
			<input class="search-input" type="text" name="searchkeyword" size="25" autocomplete="off"
			placeholder="조회할 판매자 아이디을 입력하세요" value="<%=type!=null&&type.equals("user_id")?keyword:""%>">
			<input type="hidden" name="numPerPage" value='<%=numPerPage==null?"5":numPerPage%>'>
			<button class="search-btn"  type="submit">검색</button>
		</form>
	</div>
	
		<div id="search-gender">
		<form action="<%=request.getContextPath()%>/admin/paymentSearch">
			<input type="hidden" name="searchType" value="pay_user_name">
			<input class="search-input" type="text" name="searchkeyword" size="25" autocomplete="off"
			placeholder="조회할 결제자 이름을 입력하세요" value="<%=type!=null&&type.equals("pay_user_name")?keyword:""%>">
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
								<th>결제 번호</th>
								<th>결제자 이름</th>
								<th>총금액</th>
								<th>결제방식</th>
								<th>판매자 아이디</th>
							</tr>
		<thead>

		<tbody>
		<%for(Payment p : list) {%>
			<tr>
				<td>
					<a href="<%=request.getContextPath()%>/admin/paymentView?poNum=<%=p.getPoNum() %>&userId=<%=p.getUserId()%> &pNum=<%=p.getpNum()%>">
						<%=p.getpNum()%></a>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/admin/paymentView?poNum=<%=p.getPoNum() %>&userId=<%=p.getUserId()%> &pNum=<%=p.getpNum()%>">
						<%=p.getPoNum()%></a>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/admin/paymentView?poNum=<%=p.getPoNum()  %>&userId=<%=p.getUserId()%> &pNum=<%=p.getpNum()%>">
					<%=p.getPayUserNam()%></a>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/admin/paymentView?poNum=<%=p.getPoNum()  %>&userId=<%=p.getUserId()%> &pNum=<%=p.getpNum()%>">
					<%=p.getTotalPrice()%></a>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/admin/paymentView?poNum=<%=p.getPoNum()  %>&userId=<%=p.getUserId()%> &pNum=<%=p.getpNum()%>">
						<%=p.getPoType()%></a>
				</td>
						<td>
					<a href="<%=request.getContextPath()%>/admin/paymentView?poNum=<%=p.getPoNum()  %>&userId=<%=p.getUserId()%> &pNum=<%=p.getpNum()%>">
						<%=p.getUserId()%></a>
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











