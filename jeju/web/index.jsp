<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%@page import="java.util.List,com.semi.product.model.vo.Product" %>
<%
	Member loggined=(Member)session.getAttribute("logginedMember");
	List<Product> list = (List)request.getAttribute("list");
%>

	<section id="content">
<%if(loggined!=null){%> 

		<button onclick="location.assign('<%=request.getContextPath() %>/product/productList')">버튼1</button>
		<button onclick="location.assign('<%=request.getContextPath() %>/views/product/product.jsp')">버튼2</button>
		<button onclick="location.assign('<%=request.getContextPath() %>/views/product/product.jsp')">버튼3</button>
		<button onclick="location.assign('<%=request.getContextPath() %>/views/product/product.jsp')">버튼4</button>
		<button onclick="location.assign('<%=request.getContextPath() %>/views/product/product.jsp')">버튼5</button>
		<button onclick="location.assign('<%=request.getContextPath() %>/views/product/product.jsp')">버튼6</button>
		<button onclick="location.assign('<%=request.getContextPath() %>/views/product/product.jsp')">버튼7</button>
		<button onclick="location.assign('<%=request.getContextPath() %>/views/product/product.jsp')">버튼8</button>
		<button onclick="location.assign('<%=request.getContextPath() %>/views/product/product.jsp')">버튼9</button>
		<button onclick="location.assign('<%=request.getContextPath() %>/views/product/product.jsp')">버튼10</button>
		

<% } %> 
		

	</section>
	
<%@ include file="/views/common/footer.jsp" %>

