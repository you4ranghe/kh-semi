2<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.semi.payment.model.vo.Payment,com.semi.member.model.vo.Member
    ,com.semi.product.model.vo.Product"%>
<%@ include file="/views/common/header.jsp" %>
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/adminPaymentView.css" type="text/css">

<%
	Partner partner=(Partner)request.getAttribute("PartnerView");
	Payment payment=(Payment)request.getAttribute("PaymentView");
	Member member=(Member)request.getAttribute("MemberView");
	Product product=(Product)request.getAttribute("ProductView");
%>

<div class="mypage_img"></div>
<section id="mypage-bar">
<h2>결제내역 보기</h2>
<br>
<h4><a href="<%=request.getContextPath()%>/admin/memberList">&nbsp;회원 관리</a></h4>
<h4><a href="<%=request.getContextPath()%>/partner/partnerList">&nbsp;파트너 관리</a></h4>
<h4><a href="<%=request.getContextPath()%>/admin/productList">&nbsp;상품 관리</a></h4>
<h4><a href="<%=request.getContextPath()%>/admin/paymentList">&nbsp;결제 관리</a></h4>
<h4><a href="<%=request.getContextPath()%>/member/logout">&nbsp;로그아웃</a></h4>
</section>
<section id="member-viewForm">
	<form id="MypageFrm" action="" method="post">
		<table>
			<tr>
				<th>판매자</th>
				<td class="int-area">
					<input type="text" value="<%=payment.getUserId()%>"readonly>
				</td>
			</tr>
			<tr>
				<th>결제자</th>
				<td class="int-area">
					<input type="text" value="<%=payment.getPayUserNam()%>"readonly>
				</td>
			</tr>
			<tr>
				<th>결제 총금액</th>
				<td class="int-area">
					<input type="text" value="<%=payment.getTotalPrice() %>"readonly>
				</td>
			</tr>
			<tr>
				<th>결제일</th>
				<td class="int-area">
					<input type="text" value="<%=payment.getPoDate()%>"readonly>
				</td>
			</tr>
			<tr>
				<th>결제방식</th>
				<td class="int-area">
					<input type="text" value="<%=payment.getPoType()%>"readonly>
				</td>
			</tr>
<%-- 			<tr>
				<th>결제자 연락처</th>
				<td class="int-area">
					<input type="text" value="<%=product.getpNum()%>"readonly>
				<%=product.getpPriceA()%>
				</td>
			</tr>
			<tr>
				<th>상품가격(어린이)</th>
				<td class="int-area">
					<input type="text" value="<%=product.getpNum()%>"readonly>
				<%=product.getpPriceC()%>
				</td>
			</tr>
			<tr>
				<th>여행지(출발장소)</th>
				<td class="int-area">
					<input type="text" value="<%=product.getpNum()%>"readonly>
				<%=product.getpMapAddress() %>
				</td>
			</tr>
			
			<tr>
				<th>출발시간</th>
				<td class="int-area">
					<input type="text" value="<%=product.getpNum()%>"readonly>
				<%=product.getpTime() %>
				</td>
			</tr> --%>
			
			<tr>
				<td class="btn-area">
					<button id="btn2" type="button"  onclick="searchPartner();">판매자 정보보기</button>
				</td>
				<td class="btn-area">
					<button id="btn3" type="button" onclick="partnerProduct();">등록된 상품보기</button>
				</td>
<!-- 				<td class="btn-area">
					<button id="btn3" type="submit" onclick="deleteProduct();">상품 삭제하기</button>
				</td> -->
				
			</tr> 
			
		</table>
	</form>
</section>

<script>
//유효성 검사
	   function partnerProduct(){

		location.assign('<%=request.getContextPath()%>/product/productList?pNum=<%=product.getpNum()%>');
		
		}

	   function searchPartner(){

		location.assign('<%=request.getContextPath()%>/admin/partnerView?partnerId=<%=payment.getUserId()%>');
		
		}
		
		function deleteProduct(){
		confirm("해당 상품을 정말로 삭제하시겠습니까?");
		}
</script>
	
	
<%@ include file="/views/common/footer.jsp" %>