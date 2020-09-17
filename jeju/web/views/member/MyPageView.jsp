<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/views/common/header.jsp" %>
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mypage.css" type="text/css">
<%
	Member m=(Member)request.getAttribute("member");
%>

<div class="mypage_img"></div>
<!-- <input id="btn1" type="button" value="중복검사" onclick="id_duplicate();"> -->
<section id="mypage-bar">
<h1>Mypage</h1>
<br>
<h5><a href="#">&nbsp;개인정보 수정하기</a></h5>
<h5><a href="<%=request.getContextPath()%>/updatePassword?userId=<%=m.getUserId()%>">&nbsp;비밀번호 수정하기</a></h5>
</section>
<section id="member-viewForm">
	<form id="MypageFrm" action="<%=request.getContextPath() %>/member/updateMember?userId=<%=m.getUserId() %>" method="post">
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
					<input type="text" name="userName" id="userName" value="<%=m.getUserName() %>" required autocomplete="off">
					<%-- <label for="userName"><%=m.getUserName() %></label> --%>
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td class="int-area">
					<input type="number" name="age" id="age" min="0" value="<%=m.getAge()%>" autocomplete="off" required>
					<%-- <label for="age"><%=m.getAge() %></label> --%>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td class="int-area">
					<input type="email" name="email" id="email" value="<%=m.getEmail()%>" autocomplete="off"  required>
					 <%-- <label for="email"><%=m.getEmail() %></label> --%>
				</td>
			</tr>
			<tr>
				<th>연락처(핸드폰)</th>
				<td class="int-area">
					<input type="tel" name="phone" id="phone" maxlength="11" value="<%=m.getPhone()%>" autocomplete="off"  required>
					<%-- <label for="phone"><%=m.getPhone() %></label> --%>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td class="int-area">
					<input type="text" name="address" id="address" value="<%=m.getAddress()%>"autocomplete="off" required>
					<%-- <label for="address"><%=m.getAddress() %></label> --%>
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
				<button id="btn2" type="submit"  onclick="return update_validate();">수정</button>
			</td>
			<td>
				<button id="btn3" type="reset">취소</button>
			</td>
			</tr> 
		</table>
	</form>
	
	

</section>

<script>
//유효성 검사
	   function update_validate(){
        	
		   //이름
			let regName=/[가-힣]{2,4}/;
			if(!regName.test($("#userName").val())){
					alert("이름은 한글로 2~4글자로 입력해주세요!");
					$("#userName").val("");
					$("#userName").focus();
					return false;					
					}
            //이메일
            let regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; 
            if(!regEmail.test($("#email").val())){
            	alert("@포함한 이메일 형식을 지켜주세요");
            	$("#email").val("");
                $("#email").focus();
                return false;
            }
            //핸드폰
            let regPhone = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
            if(!regPhone.test($("#phone").val())){
            	alert("(-)을 제외한 핸드폰 연락처를 입력해주세요");
            	$("#phone").val("");
                $("#phone").focus();
                return false;
            }
            //성별
            let Category1 = $('#gender0');
            if($(':radio[name="gender"]:checked').length < 1){
                alert('성별을 선택해주세요');                        
                Category1.focus();
                return false;
            }
            
	   }
</script>
	
	
<%@ include file="/views/common/footer.jsp" %>