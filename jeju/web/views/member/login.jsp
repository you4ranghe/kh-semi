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
    <h2 id="h2">당신의 <a href="">이번 제주도 여행도</a> 지금 바로 &nbsp; 
    <br><a href="<%=request.getContextPath()%>">gotJeju</a> 에서 함께해보세요</h2>
    <section class="login-form">
        <h1>LOGIN</h1>
                <form id="loginFrm" action="<%=request.getContextPath()%>/member/loginEnd" method="post">
                    <div class="int-area">
                        <input type="text" name="id" id="id"
                        autocomplete="off" required>
                        <label for="id">USER NAME</label>
                    </div>
                    <div class="int-area">
                        <input type="password" name="password" id="password"
                        autocomplete="off" required>
                        <label for="pw">PASSWORD</label>
                    </div>
                    <div class="btn-area">
                        <button id="btn" type="submit" onclick="fn_login_validate();">LOGIN</button>
                        <button id="btn2" type="button" onclick="location.assign('<%=request.getContextPath()%>/member/enroll');">JOIN US</button>
                    </div>
                    <div class="caption">
                        <a href="">Forgot Password?</a>
                    </div>
                </form>

        </section>

        <script>
        
        
        //아이디,비밀번호 미입력시 에니메이션
            let id=$("#id");
            let pw=$("#password");
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


        </script>

    
</body>
</html>