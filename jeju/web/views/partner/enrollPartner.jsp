<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.semi.member.model.vo.Member"%>
<%Member m = (Member)request.getAttribute("members");%>    
 
<%@ include file="/views/common/header.jsp" %>
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/enrollPartner.css" type="text/css">


<section id="member-viewForm">
	<form id="MypageFrm" action="<%=request.getContextPath() %>/partner/enrollPartnerEnd?userId=<%=m.getUserId() %>" method="post" enctype="multipart/form-data">
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
					<%-- <label for="userName"><%=m.getUserName() %></label> --%>
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
				<th>프로필사진</th>
					<td>
						<img id="Loading"></td>
					<td>
			</tr>
			<tr>
				<td></td>
				<td class="file_input">
					<label>사진첨부
						<pre class="brush.html"><input type="file" id="profile" name="profile" onchange="LoadImg(this);" required></pre>
					</label>
				</td>
			</tr>
			
			<tr>
				<th>주민등록사진</th>
					<td>
						<img id="Loading2"></td>
					<td>
			</tr>
			<tr>
				<td></td>
				<td class="file_input">
					<label>사진첨부
						<pre class="brush.html"><input type="file" id="idcard" name="idcard" onchange="LoadImg2(this);" required></pre>
					</label>
				</td>
			</tr>
			
			<tr>
				<th>파트너 닉네임</th>
				<td class="int-area">
					<input type="text" name="nickname" id="nickname" autocomplete="off" required>
				</td>
			</tr>
			
			 <tr>
			<td class="btn-area">
				<button id="btn2" type="submit"  onclick="return enroll_partner();">파트너 등록</button>
			</td>
			<td>
				<button id="btn3" type="reset">취소</button>
			</td>
			</tr> 
		</table>
	</form>
	

</section>

<script>
function LoadImg(value){
if(value.files&&value.files[0]){
	var reader =new FileReader();
	reader.onload=function(e){
		$("#Loading").attr("src",e.target.result);
	}
	reader.readAsDataURL(value.files[0]);
}
}

function LoadImg2(value){
if(value.files&&value.files[0]){
	var reader =new FileReader();
	reader.onload=function(e){
		$("#Loading2").attr("src",e.target.result);
	}
	reader.readAsDataURL(value.files[0]);
}
}

function enroll_partner(){
	
	var nickname = document.getElementById('nickname').value;

 	if (nickname == null || nickname == "") {
 		alert("닉네임 입력은 필수입니다.");
        nickname.focus();
        return false;
 		}
	
	
	
}

    

</script>
<%@ include file="/views/common/footer.jsp" %>