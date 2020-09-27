<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.product.model.vo.Product,java.util.List" %>

<%
List<Product> list=(List)request.getAttribute("list");

%>
<style>
	.img-div{
		width: 400px; 
		height:350px;
		margin-bottom:20px;
		margin-left:10px
	}
	div.pname{
		widh:390px;
		height:80px;
	
	}

</style>
	<div class="row">
		<%for(Product p:list){ %>
		  <div class="col-sm-6 col-lg-4">
		    <div class="thumbnail img-div" >
		    
		    	
				<a href="<%=request.getContextPath() %>/product/productList?pNum=<%=p.getpNum()%>"><img src="<%=request.getContextPath() %>/upload/product/<%=p.getTitleImgPath() %>"  alt="..." width="400px" height="200px" class="img-rounded"></a> <!-- 이부분 지선수정 이미지패스 -->
		    	<%-- <a href=""><img src="<%=request.getContextPath() %>/upload/product/<%=p.getTitleImgPath() %>"  alt="..." width="400px" height="200px" class="img-rounded"></a> --%>
		      <%-- <a href="" onclick="clickheart();"><img src="<%=request.getContextPath()%>/img/product/transheart.png" class="wish"></a> --%>
		      <!-- <span class="heartspan"><i class="fas fa-heart wish" onclick="javascript:clickheart();"></i></span> -->
		      <div class="caption" >
		        <div class="pname"><h3><%=p.getpName() %></h3></div>
		        <p><%=p.getpPriceC() %>₩~</p>
		        <input type="hidden" name=pNum value=<%=p.getpNum() %> >
		      </div>
		    </div>
		  </div>
		
	
		<%} %>
	</div>


<script>
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


</script>
	