<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.product.model.vo.Product,java.util.List" %>
<%@ include file="/views/common/header.jsp"%>


<%
	List<Product> list=(List)request.getAttribute("list");
	
%>
<style>
	.thumbnail{
		background-color: rgb(244, 244, 244);
		radius : 10px;
		margin:20px;
	}
	.img-div{
		width:340px;
		height:150px;
	
	}
	.wish,.wishclick{
		width:20px;
		height:20px;
		margin :10px;
	}
	.wish:hover,.wishclick:hover{
		transform: scale(1.5,1.5);
	}	
	.caption{
	margin:0px 10px 10px 10px;
	}
	.wishclick{
		color:red;
	}
	 h3{
      	margin:10px;
      }
      h5{
      padding : 10px;
      float:left;
      }
      h4#price{
      float:right;

	.title-color{
		color:green;
	}
	
	.more{
		font-size:15px;
		margin:10px;
		margin-left:50px;
		}

	.paddingadd{
		box-sizing: content-box;
	}
	.prtitle{
		width:340px;
		height:90px;
	
	}
   
	
	
</style>
<section>
<%@ include file="/views/common/partnerSide.jsp"%>
<div class="clear-both"></div>
	<%-- <div class="col-lg-2">
		<!-- 사이드 바 메뉴-->
		  <!-- 패널 타이틀1 -->
		<div class="panel panel-info ">
		    <div class="panel-heading">
		      <h4 class="panel-title title-color">Product</h4>
		      <hr>
		    </div>
		    <!-- 사이드바 메뉴목록1 -->
		    <ul class="list-group ">
		      <li class="list-group-item border-0"><a href="<%=request.getContextPath()%>/partner/addProduct">상품 등록하기</a></li>
		      <li class="list-group-item border-0"><a href="#">CSS</a></li>
		      <li class="list-group-item border-0"><a href="#">ECMAScript5</a></li>
		    </ul>
		</div>
		  <!-- 패널 타이틀2 -->
		<div class="panel panel-default">
		  <div class="panel-heading">
		    <h4 class="panel-title addpadding">Panel Title</h4>
		  <hr>
		  </div>
		    <!-- 사이드바 메뉴목록2 -->
		      <ul class="list-group">
		        <li class="list-group-item border-0"><a href="#">jQuery</a></li>
		        <li class="list-group-item border-0"><a href="#">BootStrap</a></li>
		      </ul>
		</div>      
		  <!-- 패널 타이틀3 -->
		<div class="panel panel-info">
		  <div class="panel-heading">
		    <h4 class="panel-title">Panel Title</h4>
		  </div>
		      <!-- 사이드바 메뉴목록3 -->
		      <ul class="list-group">
		        <li class="list-group-item border-0"><a href="#">About</a></li>
		        <li class="list-group-item border-0"><a href="#">Help</a></li>
		      </ul>
		    </div>
		</div>  --%>
	<h3> 내 상품 보기</h3>
	<div class="row clear-both">
		<%for(Product p:list){ %>
		  <div class="col-sm-6 col-lg-4 paddingadd">
		    <div class="thumbnail img-div" >
		    
		    	
		      <a href="<%=request.getContextPath()%>/product/productList?pNum=<%=p.getpNum()%>"><img src="<%=request.getContextPath() %>/upload/product/<%=p.getTitleImgPath() %>"  alt="..." width="340px" height="200px" class="img-rounded"></a>
		      
		      <div class="caption" >
		      <div class>
		        <h3><%=p.getpName() %></h3>
		        <p><%=p.getpPriceC() %>~</p> 
		       </div>
		        <a href="<%=request.getContextPath()%>/partner/updateProduct?pNum=<%=p.getpNum()%>"><button type="button" class="btn btn-default btn-sm">수정하기</button></a>
		        <a href="<%=request.getContextPath()%>/partner/deleteProduct?pNum=<%=p.getpNum()%>" onclick="return confirm('정말 삭제하시겠습니까?');"><button type="button" class="btn btn-danger btn-sm" >삭제하기</button></a>
		        <input type="hidden" name="pNum" value=<%=p.getpNum() %> >
		       
		      </div>
		    </div>
		  </div>
		
	
	<%} %>
			</div>
			
	<div id="pageBar" class="col-lg-12 text-center">
		<%=request.getAttribute("pageBar") %>
	
	</div> 
	
	
	
</section>
<script>
<%-- $("#memberList").click(e=>{
	$.ajax({
		url:"<%=request.getContextPath()%>/ajax/memberList.do",
		data:{"cPage":$("#cPage").val(),"numPage":$("#numPage").val()},
		dataType:"json",
		success:function(data){
			console.log(data);
			let tbl=$("<table>");
			$.each(data,function(i,v){
				let tr=$("<tr>");
				let userNo=$("<td>").html(i+1);
				let userId=$("<td>").html(v["userId"]);
				let userName=$("<td>").html(v["userName"]);
				let gender=$("<td>").html(v["gender"]);
				let age=$("<td>").html(v["age"]);
				let phone=$("<td>").html(v["phone"]);
				let email=$("<td>").html(v["email"]);
				let hobby=$("<td>").html(v["hobby"]);
				let address=$("<td>").html(v["address"]);
				let enrolldate=$("<td>").html(v["enrolldate"]);
				
				tr.append(userId).append(userName).append(gender).append(age).append(phone);
				tbl.append(tr);
			
			});
			$("#result").html(tbl);
		},
		error:function(re,s,e){
			console.log(s);
			console.log(e);
		}
		
		
	}) --%>


</script>

<%@ include file="/views/common/footer.jsp"%>