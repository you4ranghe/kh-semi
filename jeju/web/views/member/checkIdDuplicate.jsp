<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.semi.member.model.vo.Member"%>
<%
Member m = (Member)request.getAttribute("checkId");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복검사</title>
</head>
<body>
	<div id="checkId-container">
	
	<%if(m==null) {%>
		[<span><%=request.getParameter("userId") %></span>]는 사용이 가능합니다
		<br><br>
		<button type="button" onclick="useThisId();">사용하기</button>
	<%}else{ %>
		[<span id="duplicated"><%=request.getParameter("userId") %></span>]는 현재 사용중인 아이디 입니다.
		<br><br>
		<form action="<%=request.getContextPath() %>/checkIdDuplicate" method="post">
		<input type="text" name="userId" id="userId">
		<input type="submit" value="중복검사" onclick="return id_validate();">
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
	div#checkId-container{text-align:center;padding-top:50px;}
	span#duplicated{color:red;font-weight:bolder;}

</style>

</html>