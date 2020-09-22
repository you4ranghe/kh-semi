<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>


<style>
	#content_login{
		height:500px;
	}
	#login_table{
		margin-left:700px;
		margin-top:300px;
	}
</style>

	<section id="content">
		   <div id=content_login>
        <form action="<%=request.getContextPath() %>/login" method="post">
        	<table id="login_table">
        		<tr>
        			<td>아이디  </td>
        			<td><input type="text" id="userId" name="userId"></td>
        		</tr>
        		
        		<tr>
        			<td>비밀번호</td>
        			<td> <input type="password" id="password" name="password"></td>
        		</tr>
        		<tr>
        			<td><input type="submit" value="로그인"></td>
        			<td><input type="reset"value="리셋"></td>
        		</tr>
        	</table>
        </form>
        	
        </div>
		
		
		
	</section>
	
	
<%@ include file="/views/common/footer.jsp" %>