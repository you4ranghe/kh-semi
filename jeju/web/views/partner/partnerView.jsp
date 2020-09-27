<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/views/common/header.jsp" %>
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/partnerView.css" type="text/css">
<%
	Partner p =(Partner)request.getAttribute("partner");
%>

<div class="mypage_img"></div>

<section id="mypage-bar">
<h1>PartnerPage</h1>
<br>
<h5><a href="<%=request.getContextPath()%>/partner/partnerView?partnerId=<%=p.getPartnerId()%>">&nbsp;파트너 정보수정</a></h5>
<h5><a href="<%=request.getContextPath()%>/partner/deletePartner?partnerId=<%=p.getPartnerId()%>">&nbsp;파트너 탈퇴</a></h5>
<h5><a href="<%=request.getContextPath()%>/member/logout">&nbsp;로그아웃</a></h5>
</section>
<section id="member-viewForm">
	<form id="MypageFrm" action="<%=request.getContextPath() %>/partner/updatePartner?partnerId=<%=p.getPartnerId()%>" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>아이디</th>
				<td class="int-area">
					<input type="text" name="partnerId" id="partnerId" value="<%=p.getPartnerId()%>"readonly>			
				</td>
			</tr>

			<tr>
				<th>파트너 닉네임</th>
				<td class="int-area">
					<input type="text" name="partnerNick" id="partnerNick" value="<%=p.getPartnerNick()%>" autocomplete="off"  required>
				</td>
			</tr>
			
				<!--프로필 이미지가 존재할경우 -->
				<!--  두개의 name= 'profile' 이 값이 존재하기 때문에 hidden값으로 넘기는걸 다르게 넘긴다--> 
				<%if(p.getPartnerImgRename()!=null){ %>
				<tr>
				<th>프로필사진</th>
						<td>
						<!-- 여기는 표현만 해주기 위한부분 -->
						<img  id="Loading" src="<%=request.getContextPath() %>/upload/partner/<%=p.getPartnerImgRename() %>">
						</td>
				</tr>
				<tr><td></td>		
						<td class="file_input">
						<label>사진첨부
						<pre class="brush.html"><input type="file" id="profile_original" name="profile_original" onchange="LoadImg(this);" ></pre>
						</label>
						
						<input type="hidden" name="profile_older" value="<%=p.getPartnerImgRename() %>" > 	
						
						
						
					</td>
				<tr>
				<!-- 프로필 이미지가 존재하지 않을경우 -->
				<%}else{%>
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
							<pre class="brush.html"><input type="file" id="profile" name="profile_original" onchange="LoadImg(this);" ></pre>
						</label>
					</td>
				</tr>
						
				<%} %>
			
	
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
//파일다운로드 서블릿이동
function fileDownload(oriname,rename){
	const url="<%=request.getContextPath()%>/partner/partnerFileDown";
	
	let oName=encodeURIComponent(oriname);
	
	location.assign(url+'?oName='+oName+'&rName='+rename);
}


//파일업로드시 이미지 출력
	function LoadImg(value){
		if(value.files&&value.files[0]){
			var reader =new FileReader();
			reader.onload=function(e){
				$("#Loading").attr("src",e.target.result);
			}
			reader.readAsDataURL(value.files[0]);
		}
	}
	
	
//파트너 닉네임 유효성 검사
function update_validate(){
	
	var nickname = document.getElementById('partnerNick').value;

 	if (nickname == null || nickname == "") {
 		alert("닉네임 입력은 필수입니다.");
        nickname.focus();
        return false;
 		}
var profile = document.getElementById('profile').value;
 	
 	if (profile == null || profile == "") {
 		alert("프로필 첨부 파일은 필수 입니다.");
        return false;
 		}
 	
}
</script>
<%@ include file="/views/common/footer.jsp" %>