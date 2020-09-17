<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/views/common/header.jsp" %>
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mypage.css" type="text/css">
<%
	Member m=(Member)request.getAttribute("member");
%>
<div class="mypage-div">
	<h1>Mypage</h1>
	<h5><a href="#">개인정보 수정하기</a></h5>
	<h5><a href="<%=request.getContextPath()%>/updatePassword?userId=<%=m.getUserId()%>">비밀번호 수정</a></h5>
</div>

<section id="member-viewForm">
<input id="" type="button" value="중복검사" onclick="id_duplicate();">
	<form id="MypageFrm" action="" method="post">
		<table id="mypage-tbl">
			<tr>
				<th>아이디</th>
				<td class="int-area">
					<input type="text" name="userId" id="userId_" value="<%=m.getUserId()%>"readonly>
					
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td class="int-area">
					<input type="text" name="userName" id="userName" required autocomplete="off">
					<label for="userName"><%=m.getUserName() %></label>
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td class="int-area">
					<input type="number" name="age" id="age" min="0" autocomplete="off" required>
					<label for="age"><%=m.getAge() %></label>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td class="int-area">
					<input type="email" name="email" id="email" autocomplete="off"  required>
					 <label for="email"><%=m.getEmail() %></label>
				</td>
			</tr>
			<tr>
				<th>연락처(핸드폰)</th>
				<td class="int-area">
					<input type="tel" name="phone" id="phone" maxlength="11" autocomplete="off"  required>
					<label for="phone"><%=m.getPhone() %></label>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td class="int-area">
					<input type="text" name="address" id="address" autocomplete="off" required>
					<label for="address"><%=m.getAddress() %></label>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td class="gender">
					<input type="radio" name="gender" id="gender0" value="M">
					<label for="gender0">남</label>
					<input type="radio" name="gender" id="gender1" value="F">
					<label for="gender1">여</label>
				</td>
			</tr>
			
			 <tr>
			<td class="btn-area">
				<button id="" type="submit"  onclick="return enroll_validate();">정보수정</button>
			</td>
			<td>
				<button id="" type="reset">취소</button>
			</td>
			</tr> 
		</table>
	</form>
	

</section>
	
	
<%@ include file="/views/common/footer.jsp" %>