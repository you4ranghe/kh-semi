<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@page import="com.member.model.vo.Member" %>    
<%
	Member loginUser2=(Member)session.getAttribute("loginUser");
	String product=(String)request.getAttribute("product");
	
	
%>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<style>
	input{
		margin:10px;
		border-radius: 5px;
		
		/* height:25px; */
	}
	input:focus{
		border: 1px solid #0af; 
		outline: none; 
		-moz-box-shadow: 0px 0px 15px rgba(0, 170, 255,.5);
		-webkit-box-shadow: 0px 0px 15px rgba(0, 170, 255,.5);
		box-shadow: 0px 0px 15px rgba(0, 170, 255,.5);
	}
	#payContent div{
		border:2px solid gray;
		width:800px;
		height:500px;
		margin-bottom:50px;
		box-shadow: 30px 30px 70px rgba(0,0,0,0.2);
		border-radius:10px;
		
		
	}
	#payContent{
		margin-left:500px;
		
		margin-top:100px;
	}
	#payContent div table{
		margin-left:30px;
		
	}
	
</style>

<section id="payContent">
<form action="<%=request.getContextPath()%>/payEnd" id="payFrm">

	<strong>상품정보</strong>
	<div id="productContent">
		<table>
			<tr>
				<td rowspan="5">
					<img alt="" src="" width="200px" height="200px">
				</td>
			</tr>
			<tr>
				<td>
					상품번호
				</td>
				<td>
					<input type="text">
				</td>
			</tr>
			<tr>
				<td>
					상품명
				</td>
				<td>
					<input type="text">
				</td>
				
			</tr>
			<tr>
				<td>
					인원수 
				</td>
				<td>
					어린이 : <input type="text" style="width:30px;"> 어른 : <input type="text" style="width:30px;">
				</td>
				
			</tr>
			<tr>
				<td>
					일정
				</td>
				<td>
					시작일 : <input type="text" style="width:70px;"> 마감일: <input type="text" style="width:70px;">
				</td>
				
			</tr>
			<tr>
				<td colspan="3">
					<textarea rows="7" cols="80">ㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇ
					ㅁㄴㅇㅁㄴㅇ	여기는 상품 설명을 씁시다요 ~~~~~~~~
						~~~~~~~~~~~~~~~~~~
				ㅁㄴㅇㅁㄴㅇ~~~~~~~~~~~~~~~~~~~
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<strong>총가격</strong> : 				
				</td>
			</tr>
		</table>
		
	</div>
	<strong>주문자 정보</strong>
	<div id="orderContent">
		<table>
			<tr>
				<td>
					주문자 성명
				</td>
				<td>
					<input type="text" value="<%=loginUser2.getUserName()%>">
				</td>	
			</tr>
			<tr>
				<td>
					주문자 주소
				</td>
				<td>
					<input type="text" value="<%=loginUser2.getAddress()%>">
				</td>
			</tr>
			<tr>
				<td>
					주문자 전화번호
				</td>
				<td>
					<input type="text" value="<%=loginUser2.getPhone()%>">
				</td>
			</tr>
			<tr>
				<td>
					이메일
				</td>
				<td>
					<input type="text" value="<%=loginUser2.getEmail()%>">
				</td>
			</tr>
		</table>
	</div>
	<strong>예약인 대표 정보</strong> <label><input type="checkbox" id="paycheck"> 주문자와 정보가 같으면 체크하세요</label>
	<div id="reservation">
		 
		<table>
			<tr>
				<td>
					예약인 성명
				</td>
				<td>
					<input type="text" value="" id="payuser">
				</td>	
			</tr>
			<tr>
				<td>
					예약인 주소
				</td>
				<td>
					<input type="text" id="sample6_postcode" placeholder="우편번호" style="">
					<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" id="sample6_address" placeholder="주소"><br>
					<input type="text" id="sample6_detailAddress" placeholder="상세주소">
					<input type="text" id="sample6_extraAddress" placeholder="참고항목">
				</td>
			</tr>
			<tr>
				<td>
					예약인 전화번호
				</td>
				<td>
					<input type="text" id="payphone" value="">
				</td>
			</tr>
			<tr>
				<td>
					이메일
				</td>
				<td>
					<input type="text" id="payemail" value="">
				</td>
			</tr>
		</table>
	
		
	</div>
		<strong>결제 방법</strong>
	<div>
	</div>
	<input type="submit" value="결제하기">
</form>
<script>


    $("#paycheck").change(function(){
        if($("#paycheck").is(":checked")){
            $("#payuser").val("<%=loginUser2.getUserName()%>");
          	$("#payphone").val("<%=loginUser2.getPhone()%>");
          	$("#payemail").val("<%=loginUser2.getEmail()%>");
        }else{
            $("#payuser").val(null);
            $("#payphone").val(null);
            $("#payemail").val(null);
         
        }
    });



</script>
 
 <!-- <button id="check_module" type="button">결제하기</button> <button>취소</button> -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
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
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>

<script>
$("#check_module").click(function () {
var IMP = window.IMP; // 생략가능
IMP.init('imp51030201');
// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
IMP.request_pay({
pg: 'inicis', // version 1.1.0부터 지원.
/*
'kakao':카카오페이,
html5_inicis':이니시스(웹표준결제)
'nice':나이스페이
'jtnet':제이티넷
'uplus':LG유플러스
'danal':다날
'payco':페이코
'syrup':시럽페이
'paypal':페이팔
*/
pay_method: 'card',
/*
'samsung':삼성페이,
'card':신용카드,
'trans':실시간계좌이체,
'vbank':가상계좌,
'phone':휴대폰소액결제
*/
merchant_uid: 'merchant_' + new Date().getTime(),
/*
merchant_uid에 경우
https://docs.iamport.kr/implementation/payment
위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
참고하세요.
나중에 포스팅 해볼게요.
*/
name: '주문명:결제테스트',
//결제창에서 보여질 이름
amount: 100,
//가격
buyer_email: 'iamport@siot.do',
buyer_name: '<%=loginUser2.getUserName()%>',
buyer_tel: '010-1234-5678',
buyer_addr: '서울특별시 강남구 삼성동',
buyer_postcode: '123-456',
m_redirect_url: 'https://www.yourdomain.com/payments/complete'
/*
모바일 결제시,
결제가 끝나고 랜딩되는 URL을 지정
(카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
*/
}, function (rsp) {
console.log(rsp);
if (rsp.success) {
var msg = '결제가 완료되었습니다.';
msg += '고유ID : ' + rsp.imp_uid;
msg += '상점 거래ID : ' + rsp.merchant_uid;
msg += '결제 금액 : ' + rsp.paid_amount;
msg += '카드 승인번호 : ' + rsp.apply_num;
$("#payFrm").submit();
} else {
var msg = '결제에 실패하였습니다.';
msg += '에러내용 : ' + rsp.error_msg;
}
alert(msg);
});
});
</script>


출처: https://minaminaworld.tistory.com/78 [미나미 블로그]
</section>
