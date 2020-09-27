<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/views/common/header.jsp" %>
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/adminPartnerView.css" type="text/css">

<%
	Partner p=(Partner)request.getAttribute("partnerView");
	Member m=(Member)request.getAttribute("memberView");
%>

<div class="mypage_img"></div>
<section id="mypage-bar">
<h2>파트너 정보보기</h2>
<br>
<h5><a href="<%=request.getContextPath()%>/admin/memberList">&nbsp;회원 관리</a></h5>
<h5><a href="<%=request.getContextPath()%>/partner/partnerList">&nbsp;파트너 관리</a></h5>
<h5><a href="<%=request.getContextPath()%>/admin/productList">&nbsp;상품 관리</a></h5>
<h5><a href="<%=request.getContextPath()%>/admin/paymentList">&nbsp;결제 관리</a></h5>
<h5><a href="<%=request.getContextPath()%>/member/logout">&nbsp;로그아웃</a></h5>
</section>
<section id="member-viewForm">
	<form id="MypageFrm" action="<%=request.getContextPath() %>/admin/acceptPartner?partnerId=<%=p.getPartnerId() %>" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td class="int-area">
					<input type="text" name="userId" id="userId_" value="<%=m.getUserId()%>"readonly>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td class="int-area">
					<input type="text" name="userName" id="userName" value="<%=m.getUserName() %>" required autocomplete="off" readonly>
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td class="int-area">
					<input type="number" name="age" id="age" min="0" value="<%=m.getAge()%>" autocomplete="off" required readonly>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td class="int-area">
					<input type="email" name="email" id="email" value="<%=m.getEmail()%>" autocomplete="off"  required readonly>
				</td>
			</tr>
			<tr>
				<th>연락처(핸드폰)</th>
				<td class="int-area">
					<input type="tel" name="phone" id="phone" maxlength="11" value="<%=m.getPhone()%>" autocomplete="off"  required readonly>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td class="int-area">
					<input type="text" name="address" id="address" value="<%=m.getAddress()%>"autocomplete="off" required readonly>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td class="int-area">
					<input type="text" value="<%=m.getGender() %>"autocomplete="off" required readonly>
				</td>
			</tr>
			
			<tr>
				<th>파트너 닉네임</th>
				<td class="int-area">
					<input type="text" name="partner_nick" id="partner_nick" value="<%=p.getPartnerNick()%>"autocomplete="off" required readonly>
				</td>
			</tr>
			
			<tr>
				<th>회원 가입일</th>
				<td class="int-area">
					<input type="text" name="p_enrolldate" id="p_enrolldate" value="<%=m.getEnrolldate()%>"autocomplete="off" required readonly>
				</td>
			</tr>
			
			<tr>
				<th>파트너 가입일</th>
				<td class="int-area">
					<input type="text" name="p_enrolldate" id="p_enrolldate" value="<%=p.getpEnrolldate()%>"autocomplete="off" required readonly>
					<%-- <label for="address"><%=m.getAddress() %></label> --%>
				</td>
			</tr>
			
			<tr>
				<th>승인여부</th>
				<td class="int-area">
					<input type="text" name="partnerStatus" id="partnerStatus" value="<%=p.getPartnerStatus() %>" readonly>
				</td>
			</tr>
			
			 <tr>
				<th>
					<img id="Loading" src="<%=request.getContextPath() %>/upload/partner/<%=p.getPartnerImgRename() %>">
				</th>
				<td class="btn-area">
					<button id="btn3" type="submit"  onclick="acceptPartner();">파트너 승인하기</button>
				</td>
				<td class="btn-area">
					<button id="btn2" type="button"  onclick="deleteMember();">파트너 제외하기</button>
				</td>
			</tr> 
		</table>
	</form>
</section>

<script>
//유효성 검사
	   function deleteMember(){
		if(
			confirm("해당 회원을 정말로 탈퇴 시키겠습니까?"))
			location.assign('<%=request.getContextPath()%>/admin/deletePartner?partnerId=<%=p.getPartnerId() %>');
		
		}
		
		
</script>
	
	
<%@ include file="/views/common/footer.jsp" %>