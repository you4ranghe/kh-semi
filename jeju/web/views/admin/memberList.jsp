<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%
	List<Member> list=(List)request.getAttribute("members");
	String type=request.getParameter("searchType");
	String keyword=request.getParameter("searchkeyword");
	String numPerPage=request.getParameter("numPerPage");
%>    
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/memberList.css" type="text/css">
<%@ include file="/views/common/header.jsp" %>

<div class="memberList_img"></div>
<div id="title"><h2 id="h2">gotJeju 회원관리</h2></div>

<div id="search-container">

	<select  id="searchType">
		<option value="userId" <%=type!=null && type.equals("user_id")?"selected":"" %>>아이디</option>
		<option value="userName" <%=type!=null && type.equals("user_name")?"selected":"" %>>이름</option>
		<option value="gender" <%=type!=null && type.equals("gender")?"selected":"" %>>성별</option>			
	</select>
	
	<div id="numPerpage-container">
		<form id="numperPageFrm" name="numPerPagetFrm" action="<%=request.getContextPath()%>/admin/memberList">
			<input type="hidden" name="cPage" value='<%=request.getParameter("cPage") %>'>
		<select name="numPerPage" id="numPerPage">
			<option	value="10" <%=numPerPage!=null&&numPerPage.equals("10")?"selected":"" %>>10</option>
			<option	value="5" <%=numPerPage==null||numPerPage.equals("5")?"selected":"" %>>5</option>
			<option	value="3" <%=numPerPage!=null&&numPerPage.equals("3")?"selected":"" %>>3</option>
		</select>
		</form>
	</div>
	
	<div id="search-userId">
		<form action="<%=request.getContextPath()%>/admin/memberSearch">
			<input type="hidden" name="searchType" value="user_id">
			<input class="search-input" type="text" name="searchkeyword" size="25" autocomplete="off"
			placeholder="조회할 아이디를 입력하세요" value="<%=type!=null&&type.equals("user_id")?keyword:""%>">
			<input type="hidden" name="numPerPage" value='<%=numPerPage==null?"5":numPerPage%>'>
			<button class="search-btn" type="submit">검색</button>
		</form>
	</div>
	
	<div id="search-userName">
		<form action="<%=request.getContextPath()%>/admin/memberSearch">
			<input type="hidden" name="searchType" value="user_name">
			<input class="search-input" type="text" name="searchkeyword" size="25" autocomplete="off"
			placeholder="조회할 이름를 입력하세요" value="<%=type!=null&&type.equals("user_name")?keyword:""%>">
			<input type="hidden" name="numPerPage" value='<%=numPerPage==null?"5":numPerPage%>'>
			<button class="search-btn"  type="submit">검색</button>
		</form>
	</div>
	
	<div id="search-gender">
		<form action="<%=request.getContextPath()%>/admin/memberSearch">
			<input class="search-input" type="hidden" name="searchType" value="gender">
			<label><input type="radio" name="searchkeyword" value="M"
				<%=type!=null&&type.equals("gender")&&keyword.equals("M")?"checked":""%>>남</label>
				<label><input type="radio" name="searchkeyword" value="F"
					<%=type!=null&&type.equals("gender")&&keyword.equals("F")?"checked":""%>>여</label>
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
								<th>회원번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일</th>
			</tr>
		<thead>

		<tbody>
		<%for(Member m : list) {%>
			<tr>
				<td>
					<a href="<%=request.getContextPath()%>/admin/memberView?userId=<%=m.getUserId() %>">
						<%=m.getUserId() %></a>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/admin/memberView?userId=<%=m.getUserId() %>">
					<%=m.getUserNum()%></a>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/admin/memberView?userId=<%=m.getUserId() %>">
					<%=m.getUserName() %></a>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/admin/memberView?userId=<%=m.getUserId() %>">
						<%=m.getGender() %></a>
				</td>
				<td><a href="<%=request.getContextPath()%>/admin/memberView?userId=<%=m.getUserId() %>">
					<%=m.getAge() %></a>
				</td>
				<td><a href="<%=request.getContextPath()%>/admin/memberView?userId=<%=m.getUserId() %>">
					<%=m.getEmail() %></a>
				</td>
				<td><a href="<%=request.getContextPath()%>/admin/memberView?userId=<%=m.getUserId() %>">
					<%=m.getPhone() %></a>
				</td>
				<td><a href="<%=request.getContextPath()%>/admin/memberView?userId=<%=m.getUserId() %>">
					<%=m.getAddress() %></a>
				</td>
				<td><a href="<%=request.getContextPath()%>/admin/memberView?userId=<%=m.getUserId() %>">
					<%=m.getEnrolldate() %></a>
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











