<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- jQuery -->
	<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css" type="text/css">
    <title>Jeju_LoginPage</title>
</head>
<body>
    <h2 id="h2"><a href="">havebeenJeju</a>&nbsp;에서 지금까지 경험하지 못했던 <br>색다른 제주도여행을 시작해보세요</h2>
    <section class="login-form">
        <h1>LOGIN</h1>
                <form id="loginFrm" action="<%=request.getContextPath()%>/member/loginEnd" method="post">
                    <div class="int-area">
                        <input type="text" name="id" id="id"
                        autocomplete="off" required>
                        <label for="id">USER NAME</label>
                    </div>
                    <div class="int-area">
                        <input type="password" name="pw" id="pw"
                        autocomplete="off" required>
                        <label for="pw">PASSWORD</label>
                    </div>
                    <div class="btn-area">
                        <button id="btn" type="submit" onclick="fn_login_validate();">LOGIN</button>
                        <button id="btn2" type="button" onlcick="">JOIN US</button>
                    </div>
                    <div class="caption">
                        <a href="">Forgot Password?</a>
                    </div>
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