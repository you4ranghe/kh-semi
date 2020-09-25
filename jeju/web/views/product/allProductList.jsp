<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.product.model.vo.Product,java.util.List" %>
<%@ include file="/views/common/header.jsp"%>


<%
	List<Product> list=(List)request.getAttribute("list");
	
%>
<style>
	.addmargin{
		margin:20px;
	}
	.thumbnail{
		background-color: rgb(244, 244, 244);
		radius : 10px;
		/* margin:20px; */
	}
	.img-div{
		width: 400px; 
		height:350px;
		
	
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
	 h3.pname{
     	margin:10px;
      }
      h5{
     padding : 10px;
      float:left;
      }
      h4#price{
      float:right;
	
	paddingadd{
		
	}
	
	
</style>
<section>

	<h3> 전체 상품 보기</h3>
	<div class="row">
		
		<%for(Product p:list){ %>
		  <div class="col-sm-6 col-lg-4 border paddingadd">
		    <div class="thumbnail img-div">
		    

		    	
		      <a href="<%=request.getContextPath()%>/product/productList?pNum=<%=p.getpNum()%>"><img src="<%=request.getContextPath() %>/upload/product/<%=p.getTitleImgPath() %>"  alt="..." width="400px" height="200px" class="img-rounded"></a>
		      <%-- <a href="" onclick="clickheart();"><img src="<%=request.getContextPath()%>/img/product/transheart.png" class="wish"></a> --%>

		      <span class="heartspan"><i class="fas fa-heart wish" onclick="javascript:clickheart();"></i></span>
		      <div class="caption" >
		        <h3 class="pname"><%=p.getpName() %></h3>
		        <p><%=p.getpPriceC() %>₩~</p>
		        <input type="hidden" name=pNum value=<%=p.getpNum() %> >
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
	$(".heartspan").on('click','i',function(event){
		$(event.target).toggleClass("wishclick");
		console.log($(this).parent().next().children("input").val());
		$.ajax({
			
			url:"<%=request.getContextPath()%>/product/clickHeart.do",
			 <%-- "userId":<%=logginedMember.getUserId()%>, --%>
			data:{"productNum":$(this).parent().next().children("input").val()},
			dataType:"json",
			success:function(data){
				
			},
			error:function(re,s,e){
				console.log(s);
				console.log(e);
			}
		});
	
		});
	
		
	<%-- $(function(){
		});
	 function clickheart(){
		
		$.ajax({
			url:"<%=request.getContextPath()%>/product/clickheart.do",
			data: "userId":<%=logginedMember.getUserId()%>, "productNum":$(this).next().children("input").val()
		
		});
		};
	 --%>
	 
</script>
<%@ include file="/views/common/footer.jsp"%>