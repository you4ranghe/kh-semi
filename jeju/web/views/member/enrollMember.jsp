<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- jQuery -->
	<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/enrollMember.css" type="text/css">
    <title>Jeju_LoginPage</title>
</head>
<body>
    <section class="login-form">
        <h1 id="title">회원가입</h1>
        <h2 id="h2"><a href="<%=request.getContextPath() %>">gotJeju</a>&nbsp;에서 지금까지 경험하지 못했던 <br>색다른 제주도여행을 시작해보세요</h2>
        <input id="btn1" type="button" value="중복검사" onclick="id_duplicate();">
        <!-- <input id="btn4" type="button" onclick="sample6_execDaumPostcode()" value="주소검색"> -->
        
                <form id="memberEnrollFrm" action="<%=request.getContextPath()%>/member/EnrollEnd" method="post">
                    <table id="enroll-tbl">
                        <tr>
                            <th>아이디</th>
                            <td class="int-area">
                                <input type="text" name="userId" id="userId_" required autocomplete="off">
                                <label for="userId_">4~18개의 영대소문자, 숫자조합</label>
                            </td>
                        </tr>
                        <tr>
                            <th>패스워드</th>
                            <td class="int-area">
                                <input type="password" name="password" id="password_" required autocomplete="off">
                                <label for="password_">4~18개의 영대소문자, 숫자조합</label>
                            </td>
                        </tr>
                        <tr>
                            <th>패스워드확인</th>
                            <td class="int-area">
                            <input type="password" id="password_2" autocomplete="off" required>
                            <label for="password_2">비밀번호 확인</label>
                                
                            </td>
                        </tr>
                        <tr>
                            <th>이름</th>
                            <td class="int-area">
                                <input type="text" name="userName" id="userName" required autocomplete="off">
                                <label for="userName">한글 2~4글자</label>
                            </td>
                        </tr>
                        <tr>
                            <th>나이</th>
                            <td class="int-area">
                                <input type="number" name="age" id="age" min="0" autocomplete="off" required>
                                <label for="age">제주도가기 딱 좋을나이</label>
                            </td>
                        </tr>
                        <tr>
                            <th>이메일</th>
                            <td class="int-area">
                                <input type="email" name="email" id="email" autocomplete="off"  required>
                            	 <label for="email">ex)letsgo@gotjeju.com</label>
                            </td>
                        </tr>
                        <tr>
                            <th>연락처(핸드폰)</th>
                            <td class="int-area">
                                <input type="tel" name="phone" id="phone" maxlength="11" autocomplete="off"  required>
                            	<label for="phone">(-)을 제외하고 입력해주세요</label>
                            </td>
                        </tr>
                <!--        <tr>
                            <th>주소</th>
                            <td class="int-area">
                                <input type="text" name="address" id="address" autocomplete="off" required>
                                <label for="address">주소를 입력해주세요</label>
                            </td>
                        </tr>  -->
			   			 <tr>
							<th>주소</th>
							<td class="int-area">
								<input  name="address" type="text" id="sample6_postcode" placeholder="우편번호" autocomplete="off" required>
								<input name="address" type="text" id="sample6_address" placeholder="주소" autocomplete="off" ><br>
								<input name="address" type="text" id="sample6_detailAddress" placeholder="상세주소" autocomplete="off" required>
								<input  name="address" type="text" id="sample6_extraAddress" placeholder="참고항목" autocomplete="off" required>
								<button id="address_btn" type="button" onclick="sample6_execDaumPostcode()">주소검색</button><br>
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
                            <button id="btn2" type="submit"  onclick="return enroll_validate();">가입하기</button>
                        </td>
                        <td>
                            <button id="btn3" type="reset">취소</button>
                        </td>
                        </tr>
                    </table>
                </form>
                	<!-- 아이디 중복검사 폼 -->
					<form action="" name="checkIdDuplicate">
					<!-- 유저가 입력한 아이디를 집어넣고 전송 hidden-->
					<input type="hidden" name="userId"> 
					</form>

        </section>

        <script>
		//비밀번호 일치여부 확인체크
		$(function(){
			$("#password_2").blur(e=>{
			let pw=$("#password_").val();
			let pwck=$(e.target).val();
				if(pw.trim()!=pwck.trim()){
					alert("비밀번호가 일치하지 않습니다");
					$("#password_").val("");
					$(e.target).val("");
					$("#password_").focus();
				}
			})
		});
       //유효성 검사
	   function enroll_validate(){
        	
	   
            //아이디 
            //첫글자 영소문자, 4~15자로 만들어지고
            // 반드시 한개이상의 숫자가 포함 영문,숫자로만 작성
            let regId=/^[a-z](?=.*?[\d])[a-z\dA-Z]{4,15}$/;
            if(!regId.test($("#userId_").val())){
                alert("아이디는 첫글자가 영소문자이고 4~15의 영문자,숫자로 입력해야합니다.");
                $("#userId_").val("");
                $("#userId_").focus();
                return false;
            }
            
			//비밀번호
            let regPw=/^.*(?=^.{4,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
            if(!regPw.test($("#password_").val())){
                alert("비밀번호는 4~15자리 이내 숫자,문자,특수기호 포함되어야 합니다");
                $("#password_").val("");
                $("#password_").focus();
                return false;
            } 
            
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
            
	   } //유효성 검사 버튼 
	   
	   //아이디 중복검사
	   function id_duplicate(){
			let id=$("#userId_").val().trim();
			if(id.length<4){
				alert("아이디는 4글자 이상입력하세요!");
				return;
			}
			
			//중복확인 할 새창을 뛰우기
			const url="<%=request.getContextPath()%>/checkIdDuplicate"
			const title="checkIdDuplicate";
			const status = "left=500px,top=150px,width=500px,height=180px";
			
			open("",title,status);
			
			checkIdDuplicate.target=title; 
			checkIdDuplicate.action=url; 
			checkIdDuplicate.method="post";
			
			checkIdDuplicate.userId.value=id;
			checkIdDuplicate.submit();
			
		}
	   
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

    
</body>
</html>