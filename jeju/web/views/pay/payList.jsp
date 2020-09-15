<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@page import="com.member.model.vo.Member" %>    
<%
	Member loginUser2=(Member)session.getAttribute("loginUser");
	String product=(String)request.getAttribute("product");
	
	
%>
<style>
	input{
		margin:10px;
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
		border:1px solid gray;
		width:800px;
		height:500px;
		margin-bottom:50px;
		
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
<h2>상품설명</h2>
<div>
	
</div>
<h2>주문자 정보</h2>
<div>
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
	</table>
</div>
<strong>상품수령 정보</strong> <label><input type="checkbox" id="paycheck"> 주문자와 정보가 같으면 체크하세요</label>
<div>
	 
	<table>
		<tr>
			<td>
				수령인 성명
			</td>
			<td>
				<input type="text" value="" id="payuser">
			</td>	
		</tr>
		<tr>
			<td>
				수령인 주소
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
				수령인 전화번호
			</td>
			<td>
				<input type="text" id="payphone" value="">
			</td>
		</tr>
	</table>

	
</div>
<div>
	결제 방법
</div>
<script>


    $("#paycheck").change(function(){
        if($("#paycheck").is(":checked")){
            $("#payuser").val("<%=loginUser2.getUserName()%>");
          	$("#payphone").val("<%=loginUser2.getPhone()%>");
        }else{
            $("#payuser").val(null);
            $("#payphone").val(null);
         
        }
    });



</script>
 
 <button>결제하기</button> <button>취소</button>
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
</section>
<%@ include file="/views/common/footer.jsp" %>