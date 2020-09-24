<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%
	List<Partner> list=(List)request.getAttribute("partners");
	String type=request.getParameter("searchType");
	String keyword=request.getParameter("searchkeyword");
	String numPerPage=request.getParameter("numPerPage");
%>    
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/partnerList.css" type="text/css">
<%@ include file="/views/common/header.jsp" %>

<div class="memberList_img"></div>
<div id="title"><h2 id="h2">gotJeju 파트너 관리</h2></div>

<div id="search-container">

	<select  id="searchType">
		<option value="userId" <%=type!=null && type.equals("partner_id")?"selected":"" %>>아이디</option>
		<option value="userName" <%=type!=null && type.equals("partner_nick")?"selected":"" %>>닉네임</option>
		<option value="gender" <%=type!=null && type.equals("partner_status")?"selected":"" %>>승인여부</option>		
					
	</select>
	
	<div id="numPerpage-container">
		<form id="numperPageFrm" name="numPerPagetFrm" action="<%=request.getContextPath()%>/admin/partnerList">
			<input type="hidden" name="cPage" value='<%=request.getParameter("cPage") %>'>
		<select name="numPerPage" id="numPerPage">
			<option	value="10" <%=numPerPage!=null&&numPerPage.equals("10")?"selected":"" %>>10</option>
			<option	value="5" <%=numPerPage==null||numPerPage.equals("5")?"selected":"" %>>5</option>
			<option	value="3" <%=numPerPage!=null&&numPerPage.equals("3")?"selected":"" %>>3</option>
		</select>
		</form>
	</div>
	
	<div id="search-userId">
		<form action="<%=request.getContextPath()%>/admin/partnerSearch">
			<input type="hidden" name="searchType" value="partner_id">
			<input class="search-input" type="text" name="searchkeyword" size="25" autocomplete="off"
			placeholder="조회할  파트너 아이디를 입력하세요" value="<%=type!=null&&type.equals("partner_id")?keyword:""%>">
			<input type="hidden" name="numPerPage" value='<%=numPerPage==null?"5":numPerPage%>'>
			<button class="search-btn" type="submit">검색</button>
		</form>
	</div>
	
	<div id="search-userName">
		<form action="<%=request.getContextPath()%>/admin/partnerSearch">
			<input type="hidden" name="searchType" value="partner_nick">
			<input class="search-input" type="text" name="searchkeyword" size="25" autocomplete="off"
			placeholder="조회할 파트너 닉네임을 입력하세요" value="<%=type!=null&&type.equals("partner_nick")?keyword:""%>">
			<input type="hidden" name="numPerPage" value='<%=numPerPage==null?"5":numPerPage%>'>
			<button class="search-btn"  type="submit">검색</button>
		</form>
	</div>
	
		<div id="search-gender">
			<form action="<%=request.getContextPath()%>/admin/partnerSearch">
				<input class="search-input" type="hidden" name="searchType" value="partner_status">
				<label><input type="radio" name="searchkeyword" value="Y"
				<%=type!=null&&type.equals("partner_status")&&keyword.equals("Y")?"checked":""%>>승인</label>
				<label><input type="radio" name="searchkeyword" value="N"
					<%=type!=null&&type.equals("partner_status")&&keyword.equals("N")?"checked":""%>>대기</label>
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
								<th>파트너 번호</th>
								<th>파트너 아이디</th>
								<th>파트너 닉네임</th>
								<th>파트너 등록일</th>
								<th>파트너 승인여부</th>
							</tr>
		<thead>

		<tbody>
		<%for(Partner p : list) {%>
			<tr>
				<td>
					<a href="<%=request.getContextPath()%>/admin/partnerView?partnerId=<%=p.getPartnerId() %>">
						<%=p.getPartnerNum() %></a>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/admin/partnerView?partnerId=<%=p.getPartnerId()  %>">
					<%=p.getPartnerId()%></a>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/admin/partnerView?partnerId=<%=p.getPartnerId()  %>">
					<%=p.getPartnerNick()%></a>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/admin/partnerView?partnerId=<%=p.getPartnerId()  %>">
						<%=p.getpEnrolldate()%></a>
				</td>
						<td>
					<a href="<%=request.getContextPath()%>/admin/partnerView?partnerId=<%=p.getPartnerId()  %>">
						<%=p.getPartnerStatus()%></a>
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











