<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.semi.member.model.vo.Member"%>
<%
Member m = (Member)request.getAttribute("checkId");
%>
	
	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>아이디 중복검사</title>
		</head>
		<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/checkIdDuplicate.css" type="text/css">
<body>
	<div id="checkId-container">
	
	<%if(m==null) {%>
		<span id="duplicated"><%=request.getParameter("userId") %></span>는 <mark>사용 가능</mark>합니다
		<br><br>
		<button class="submit_btn" type="button" onclick="useThisId();">사용하기</button>
	<%}else{ %>
		<mark><span id="duplicated"><%=request.getParameter("userId") %></span></mark>는 현재 사용중입니다.
		<br><br>
		<form action="<%=request.getContextPath() %>/checkIdDuplicate" method="post">
		<input type="text" name="userId" id="userId" autocomplete="off" required>
		<input class="submit_btn" type="submit" value="중복검사" onclick="return id_validate();">
		</form>
	
	<%} %>	
	
	</div>
</body>
<script>
	function id_validate(){
		let id=document.getElementById("userId").value;
		if(id.trim().length<4){
			alert("아이디는 4글자 이상 입력하세요");
			document.getElementById("userId").focus();
			return false;
		}
	}

	function useThisId(){
		const id = '<%=request.getParameter("userId")%>';
		opener.memberEnrollFrm.userId.value=id; 
		opener.memberEnrollFrm.password.focus(); 
		
		close();
	}


</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');


* {
    margin: 0; padding:0; box-sizing:border-box;
}
div#checkId-container{text-align:center;padding-top:50px;}
span#duplicated{color:red;font-weight:bolder;}

#userId{
    border-radius: 7px;
    width: 120px;
	height:35px;
	border:1px solid darkcyan;
	font-family: 'Do Hyeon', sans-serif;
	font-size: 20px;
}

.submit_btn{
	background-color:darkcyan;
	color:white;
	font-size: 20px;
	border:none;
	border-radius: 7px;
	height:35px;
	width:100px;
	
	font-family: 'Do Hyeon', sans-serif;

	
	
}

body{
    font-family: 'Do Hyeon', sans-serif;
    height:100%;
    background-color: beige;
    background-size : cover;
}


</style>


</html>