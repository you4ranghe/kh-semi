<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.product.model.vo.Product,java.util.List" %>
<%@ include file="/views/common/header.jsp"%>


<%
	List<Product> list=(List)request.getAttribute("list");
	String searchWord=request.getParameter("searchWord");
	
	
%>
<style>
	.thumbnail{
		background-color: rgb(244, 244, 244);
		radius : 10px;
		margin:20px;
	}
	.img-div{
		ba
	}

</style>
<section>
	<div class="row">
		<%for(Product p:list){ %>
		  <div class="col-sm-6 col-lg-4">
		    <div class="thumbnail img-div">
		      <a href=""><img src="<%=request.getContextPath() %>/upload/product/<%=p.getTitleImgPath() %>" alt="..." width="400px" height="200px" class="img-rounded"></a>
		      <div class="caption">
		        <h3><%=p.getpName() %></h3>
		        <p><%=p.getpNum() %></p>
		      </div>
		    </div>
		  </div>
		
	
	<%} %>
			</div>
	
	<div id="pageBar" class="col-lg-12 text-center">
	<%=request.getAttribute("pageBar") %>
	
	</div>
</section>

<%@ include file="/views/common/footer.jsp"%>