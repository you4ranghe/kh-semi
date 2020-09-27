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
<h1>파트너 상세<br>정보보기</h1>
<br>
<h5><a href="<%=request.getContextPath()%>/partner/partnerList">&nbsp;파트너 관리페이지</a></h5>
<h5><a href="<%=request.getContextPath()%>/member/logout">&nbsp;로그아웃</a></h5>
</section>
<section id="member-viewForm">
	<form id="MypageFrm" action="<%=request.getContextPath() %>/admin/acceptPartner?partnerId=<%=p.getPartnerId() %>" method="post">
		<table>
			<tr>
				<th>아이디(파트너 아이디)</th>
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
				<td class="gender">
					<%=m.getGender() %>
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
				<th>파트너 승인여부</th>
				<td class="int-area">
					<input type="text" name="partnerStatus" id="partnerStatus" value="<%=p.getPartnerStatus() %>" readonly>
				</td>
			</tr>
			
			 <tr>
			<!-- 	<td class="btn-area">
					<button id="btn2" type="submit"  onclick="deleteMember();">파트너 제외하기</button>
				</td> -->
				<td class="btn-area">
					<button id="btn2" type="button"  onclick="deleteMember();">파트너 제외하기</button>
				</td>
				<td class="btn-area">
					<button id="btn3" type="submit"  onclick="acceptPartner();">파트너 승인하기</button>
				</td>
				<td class="btn-area">
					<img id="Loading" src="<%=request.getContextPath() %>/upload/partner/<%=p.getPartnerImgRename() %>">
				</td>
			</tr> 
		</table>
	</form>
</section>

<script>
//유효성 검사
	   function deleteMember(){
		confirm("해당 회원을 정말로 탈퇴 시키겠습니까?");
		location.assign('<%=request.getContextPath()%>/admin/deletePartner?partnerId=<%=p.getPartnerId() %>');
		
		}
		function acceptPartner(){
		confirm("해당 회원을 파트너로 승인하시겠습니까?");
		}
</script>
	
	
<%@ include file="/views/common/footer.jsp" %>