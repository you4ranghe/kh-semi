<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<style>
	textarea{
		resize:none;
	}
	
	table{
	margin :20px;
	
	}
	td,th{
	padding :10px;
	}
	input.long{
	width :900px;
	}

</style>
<section>

<div id="container">
	<form action="<%=request.getContextPath() %>/partner/addProduct" method="post" enctype="multipart/form-data">
		<table class="table-bordered" >
			<tr>
				<th>상품 이름</th>
				<td><input type="text" name="name" required class="long"></td>
			
			</tr>
			<tr>
				<th>상품 이름(영어)</th>
				<td><input type="text" name="engName" required class="long"></td>
			
			</tr>
			<tr>
				<th>상품 이름(한글)</th>
				<td><input type="text" name="korName" required class="long"></td>
			
			</tr>
			<tr>
				<th>어른 상품 가격</th>
				<td><input type="number" name="adultPrice" required></td>
			
			</tr>
			<tr>
				<th>어린이 상품 가격</th>
				<td><input type="text" name="childPrice" required></td>
			
			</tr>
			<tr>
				<th>판매 시작 날짜</th>
				<td><input type="date" name="dateStart" required></td>
			
			</tr>
			<tr>
				<th>판매 종료 날짜</th>
				<td><input type="date" name="dateFinish" required></td>
			
			</tr>
			<tr>
				<th>시작 시간</th>
				<td><input type="text" name="time" required></td>
			
			</tr>
			<tr>
				<th>슬라이더 사진</th>
				<td><input type="file" name="slider" required></td>
			
			</tr>
			<tr>
				<th>메인 사진</th>
				<td><input type="file" name="main" required></td>
			
			</tr>
			<tr>
				<th>상품 요약</th>
				<td><textarea name="point" required cols="100" rows="5">상품에 대한 핵심 정보들을 간단하게 작성해주세요 !</textarea></td>
			
			</tr>
			<tr>
				<th>상품 소개</th>
				<td><textarea name="intd" required cols="100" rows="5">상품에 대한 홍보 문구를 작성해주세요 !</textarea></td>
			
			</tr>
			<tr>
				<th>상품 설명</th>
				<td><textarea name="info" required cols="100" rows="30">상품에 대한 상세정보들을 작성해주세요 !</textarea></td>
			
			</tr>
			
			<tr>
				<th>소요시간 설명</th>
				<td><textarea name="runtime" id="runtime" required cols="100" rows="5">??</textarea></td>
			
			</tr>
			<tr>
				<th>여행 루트 사진</th>
				<td><input type="file" name="route" required></td>
			
			</tr>
			<tr>
				<th>유의사항</th>
				<td><textarea name="precaution" id="precaution" required cols="100" rows="5"></textarea></td>
			
			</tr>
			<tr>
				<th>지도 주소</th>
				<td>
					<input type="text" id="sample6_address" name="address" placeholder="주소">
					<input type="button" onclick="sample6_execDaumPostcode()" value="주소찾기"><br>
					<input type="text" id="sample6_detailAddress" name="detailAddress" placeholder="상세주소">
					<input type="text" id="sample6_extraAddress" name="extraAddress" placeholder="참고항목">
					

				</td>
			
			</tr>
			<tr>
				<th>지도경로</th>
				<td><textarea name="map" required cols="100" rows="5"></textarea></td>
			
			</tr>
			
			
			<tr>
				<td colspan="2">
				
				<input type="submit" value="등록하기" class="btn btn-primary">
				<input type="reset" value="취소하기" class="btn btn-danger">
				</td>
			</tr>
		
		</table>
	
	
	</form>


</div>

<script>
	$('#runtime').on('keyup', function() {
	
		if($(this).val().length > 160) {
	
	alert("글자수는 160자 이내로 제한됩니다.");
	
			$(this).val($(this).val().substring(0, 160));
	
		}

});
	function sample6_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수
	
	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    document.getElementById("sample6_extraAddress").value = extraAddr;
	                
	                } else {
	                    document.getElementById("sample6_extraAddress").value = '';
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                /* document.getElementById('sample6_postcode').value = data.zonecode; */
	                document.getElementById("sample6_address").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("sample6_detailAddress").focus();
	            }
	        }).open();
	    }

</script>



</section>

<%@ include file="/views/common/footer.jsp"%>