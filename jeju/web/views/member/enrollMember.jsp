<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- jQuery -->
	<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/enrollMember.css" type="text/css">
    <title>Jeju_LoginPage</title>
</head>
<body>
    <h1 id="title">회원가입</h1>
    <h2 id="h2"><a href="">havebeenJeju</a>&nbsp;에서 지금까지 경험하지 못했던 <br>색다른 제주도여행을 시작해보세요</h2>
    <input id="btn1"type="button" value="중복검사" onclick="fn_id_duplicate();">
    <section class="login-form">
                <form id="loginFrm" action="<%=request.getContextPath()%>/member/EnrollEnd" method="post">
                    <table>
                        <tr>
                            <th>아이디</th>
                            <td class="int-area">
                                <input type="text" name="userId" id="userId_" required>
                                <label for="userId">4~18개의 영대소문자, 숫자조합</label>
                            </td>
                        </tr>
                        <tr>
                            <th>패스워드</th>
                            <td class="int-area">
                                <input type="password" name="password" id="password_" required>
                                <label for="password_">4~18개의 영대소문자, 숫자조합</label>
                            </td>
                        </tr>
                        <tr>
                            <th>패스워드확인</th>
                            <td class="int-area"><input type="password" id="password_2" placeholder="비밀번호 확인">
                                
                            </td>
                        </tr>
                        <tr>
                            <th>이름</th>
                            <td class="int-area">
                                <input type="text" name="userName" id="userName" required>
                            </td>
                        </tr>
                        <tr>
                            <th>나이</th>
                            <td class="int-area">
                                <input type="number" name="age" id="age" min="0">
                            </td>
                        </tr>
                        <tr>
                            <th>이메일</th>
                            <td class="int-area">
                                <input type="email" name="email" id="email">
                            </td>
                        </tr>
                        <tr>
                            <th>휴대폰</th>
                            <td class="int-area">
                                <input type="tel" name="phone" id="phone" maxlength="11">
                            </td>
                        </tr>
                        <tr>
                            <th>주소</th>
                            <td class="int-area">
                                <input type="text" name="address" id="address">
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
                            <button id="btn2" type="submit" onclick="">가입하기</button>
                        </td>
                        <td>
                            <button id="btn3" type="reset" onlcick="">취소</button>
                        </td>
                        </tr>
                    </table>
                </form>

        </section>

        <script>
        
        
        //아이디,비밀번호 미입력시 에니메이션
            let id=$("#id");
            let pw=$("#pw");
            let btn=$("#btn");

            $(btn).on('click',function(){
                if($(id).val()==""){
                    $(id).next('label').addClass('warning');
                    setTimeout(function(){
                        $('label').removeClass('warning')
                    },1500)
                }
                else if($(pw).val()==""){
                    $(pw).next('label').addClass('warning');
                    setTimeout(function(){
                        $('label').removeClass('warning')
                    },1500)
                }
            });

/* 		function fn_login_validate(){
			let id=$("#id").val();
			let password=$("#pw").val()
			//아이디가 4글자 미만이면 안됨.
			if(id.trim().length<8){
				alert("아이디는 8글자 이상입니다.");
				$("#id").focus();
				return false;
			}
			//패스워드를 입력하지 않으면 안됨.
			if(password.trim().length==0){
				alert("비밀번호를 입력해주세요");
				$("#pw").focus();
				return false;
			}
		} */

        </script>

    
</body>
</html>