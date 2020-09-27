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
		width:320px;
		height:350px;
		
	}
	.prmar{
		margin:20px;
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
	 div.pname{
      	margin:10px;
      	width:295px;
      	height:100px;
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

	.prtitle{
		width:340px;
		height:90px;
	
	}
   
	
	
	.addpadding{
    		padding-bottom:10px;
    	}
    .clearboth{
    	/* clear:both; */
    }
   
    .sidebarmy{
    	float:left;
    
    	height:1000px;
    }
    .panel-last{
    height:500px
    }
.part-title{
		margin:20px;
	
	}

</style>
<section>

	<h3 class="part-title">&nbsp&nbsp&nbsp&nbsp내 상품 보기</h3>
	
	 <div class="row">
	<%-- <div id="sidebar"  class="col-lg-2">
		<!-- 사이드 바 메뉴-->
		  <!-- 패널 타이틀1 -->
		<div class="sidebarmy panel panel-info ">
		    <div class="panel-heading">
		      <h4 class="panel-title title-color border-bottom addpadding">Product</h4>
		      
		    </div>
		    <!-- 사이드바 메뉴목록1 -->
		    <ul class="list-group">
		      <li class="list-group-item list-group-item-action border-0"><a href="<%=request.getContextPath()%>/partner/addProduct">상품 등록하기</a></li>
		      <li class="list-group-item list-group-item-action border-0"><a href="<%=request.getContextPath()%>/partner/partnerProductList">내 상품 보기</a></li>
		      <!-- <li class="list-group-item list-group-item-action border-0"><a href="#">ECMAScript5</a></li> -->
		    </ul>
		</div>
		<br>
		  <!-- 패널 타이틀2 -->
		<div class="panel panel-default">
		  <div class="panel-heading">
		    <h4 class="panel-title addpadding">Profile</h4>
		  <hr>
		  </div>
		    <!-- 사이드바 메뉴목록2 -->
		      <ul class="list-group">
		        <li class="list-group-item border-0"><a href="<%=request.getContextPath() %>/partner/partnerView?partnerId=<%=logginedPartner.getPartnerId() %>">파트너 프로필 수정</a></li>
		        <li class="list-group-item border-0"><a href="#"></a></li>
		      </ul>
		</div>      
		  <!-- 패널 타이틀3 -->
		<div class="panel panel-info panel-last">
		  <div class="panel-heading">
		    <h4 class="panel-title"></h4>
		  </div>
		      <!-- 사이드바 메뉴목록3 -->
		      <ul class="list-group">
		        <li class="list-group-item border-0"><a href="#"></a></li>
		        <li class="list-group-item border-0"><a href="#"></a></li>
		      </ul>
		    </div>
		</div>  --%>
		<style>
			.partner-navi>ul>li{
			float:left;
			padding:5px;
			}
		</style>

		<div class="container">
		<div class="row">
		<div class="col-lg-12 text-center">
			<div class="partner-navi text-center" >
				<ul>
					<li><a href="<%=request.getContextPath() %>/partner/partnerView?partnerId=<%=logginedPartner.getPartnerId() %>">  ♥ 파트너 프로필</a><li>
					<li><a href="<%=request.getContextPath()%>/partner/partnerProductList">  ♥ 내 상품 보기</a><li>
					<li><a href="<%=request.getContextPath()%>/partner/partnerOrderList">  ♥ 판매 내역 조회하기</a></li>
					<li><a href="<%=request.getContextPath()%>/partner/addProduct">  ♥ 상품 등록하기</a></li>
				</ul>
			</div>
			</div>
			</div>
		</div>
		<div class="container">
		<div class="row"> 
		<!-- <div class="col-lg-10"> -->
		<%for(Product p:list){ %>
		  <div class="col-sm-6 col-lg-3 prmar">
		    <div class="thumbnail img-div">
		    
		    	
		      <a href="<%=request.getContextPath()%>/product/productList?pNum=<%=p.getpNum()%>"><img src="<%=request.getContextPath() %>/upload/product/<%=p.getTitleImgPath() %>"  alt="..." width="320px" height="150px" class="img-rounded"></a>
		      
		      <div class="caption" >
		      
		        <div class="pname"><h3><%=p.getpName() %></h3></div>
		        <p><%=p.getpPriceC() %>₩~</p> 
		        <a href="<%=request.getContextPath()%>/partner/updateProduct?pNum=<%=p.getpNum()%>"><button type="button" class="btn btn-default btn-sm">수정하기</button></a>
		        <a href="<%=request.getContextPath()%>/partner/deleteProduct?pNum=<%=p.getpNum()%>" onclick="return confirm('정말 삭제하시겠습니까?');"><button type="button" class="btn btn-danger btn-sm" >삭제하기</button></a>
		       </div>
		        <input type="hidden" name="pNum" value=<%=p.getpNum() %> >
		       
		      </div>
		    </div>
	<%} %>
		  </div>
		</div> 
		</div>
	<nav aria-label="Page navigation example text-center" style="margin-bottom: 20px;">
                <ul id="pageNavUl" class="pagination justify-content-center text-center">
                    <%=request.getAttribute("pageBar") %>
                </ul>
            </nav>
	<%-- <div id="pageBar" class="col-lg-12 text-center">
		<%=request.getAttribute("pageBar") %>
	
	</div>  --%>
	
	
	
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
	/*Menu-toggle*/
	$("#menu-toggle").click(function(e) {
	    e.preventDefault();
	    $("#wrapper").toggleClass("active");
	});

	/*Scroll Spy*/
	$('body').scrollspy({ target: '#spy', offset:80});

	/*Smooth link animation*/
	$('a[href*=#]:not([href=#])').click(function() {
	    if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

	        var target = $(this.hash);
	        target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
	        if (target.length) {
	            $('html,body').animate({
	                scrollTop: target.offset().top
	            }, 1000);
	            return false;
	        }
	    }
	});

</script>

<%@ include file="/views/common/footer.jsp"%>