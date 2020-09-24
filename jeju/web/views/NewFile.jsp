<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/27fabf8f47.js" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xl-2">
				<button class="genric-btn info radius btn-block">ㅠㅠ제발</button>
					
			</div>
			<div class="input-group">
				<span class="input-group-addon">@</span>
				<input type="text" class="form-control">
			</div>
				
				
				
				<input id="date" autocomplete="false">
		</div>
		
	
	</div>
	
	<div class="box">
	  <div class="container-1">
	      <span class="icon"><i class="fa fa-search"></i></span>
	      <input type="search" id="search" placeholder="Search..." />
	  </div>
	</div>
	<style>

 
	.box{
	  margin: 100px auto;
	  width: 300px;
	  height: 50px;
	
	}
	.container-1{
	  width: 300px;
	  vertical-align: middle;
	  white-space: nowrap;
	  position: relative;
	}
	.container-1 input#search{
	  width: 300px;
	  height: 50px;
	  background: pink;
	  border: none;
	  font-size: 10pt;
	  float: left;
	  color: pink;
	  padding-left: 45px;
	  -webkit-border-radius: 5px;
	  -moz-border-radius: 5px;
	  border-radius: 5px;
	}
	.container-1 .icon{
	  position: absolute;
	  top: 50%;
	  margin-left: 17px;
	  margin-top: 17px;
	  z-index: 1;
	  color: #4f5b66;
	}


	</style>
</body>
</html>