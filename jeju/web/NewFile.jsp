<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<style>
	.thumbnail{
		background-color: rgb(244, 244, 244);
		radius : 10px;
		margin:20px;
	}
	.img-div{
		/* 둥글고 좀 여유있게 하기 */
	
	}
	.wish{
		width:20px;
		height:20px;
	
	}
	
	

</style>
<section>
	<div style="position: absolute;">

        <div style="position: relative;"><img src="<%=request.getContextPath()%>/upload/product/jejuimg1.jpg"></img></div>

    </div>

    <div style="position: absolute;">

        <div style="position: relative; top: 40px; left: 400px;"><img src="<%=request.getContextPath()%>/img/product/pinkheart.png" class="wish"></img></div>
	
    </div>

</section>

