<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@page import="java.util.List"%>
<%@page import="com.semi.product.model.vo.Product"%>
<%@page import="com.semi.payment.model.vo.Payment"%>
<%@page import="com.semi.wishList.model.vo.WishList"%>
<%@page import="com.semi.review.model.vo.Review"%>

<%
	Product p = (Product)request.getAttribute("p");
	//List<Product> plist = (List)request.getAttribute("productList");
	
	Payment pm = (Payment)request.getAttribute("payment");
	
	WishList we = (WishList)request.getAttribute("we");
	
	Review r = (Review)request.getAttribute("review");
	List<Review> rlist = (List)request.getAttribute("reviewList"); 

%>


<!DOCTYPE html>
<section>
 
<form id="reviewFrm" action="/" method="post" >

 <c:forEach var="e" items="${reviewList}" >
<input type="text" value="${e.reviewScore}">
<input type="text" value="${e.reviewTitle}">
<input type="text" value="${e.reviewContents}">
<input type="text" value="${e.reviewWriter}">
<input type="text" value="${e.poNum}">
<input type="text" value="${e.pNum}">
<input type="hidden" value="${e.userId}">
</c:forEach>


<input type="button" value="리뷰 수정" onclick="fn_update_submit();">
<input type="button" value="리뷰 삭제" onclick="fn_delete_member();">


</form>

								<script>
								function fn_delete_member(){
						 			//id서버에 전송해서 그 id랑 일치하는 회원을 삭제
						 			<%-- <%=logginedMember.getUserId()%> --%>
						 			if(confirm("정말 삭제하시겠습니까?")){
						 				location.replace('<%=request.getContextPath()%>/member/deleteMember?userId=<%=logginedMember.getUserId()%>');
						 			}
						 				
						 			//delete from member where userId=?
						 		}
								
						 		function fn_update_submit(){
						 			const frm=$("#reviewFrm");
						 			const url="<%=request.getContextPath()%>/review/reviewModify";
						 			frm.attr({
						 				"action":url,
						 				"method":"post",
						 			});
						 			frm.submit();
						 		}
								
						 		
						 		
						 		
						 	<%-- 	
								$("#reviewFrm").keyup(e=>{
								         $.ajax({
								            url:"<%=request.getContextPath()%>/review/reviewModify",
								            data:{"nick":$(e.target).val()},
								            type:"post",
								            dataType:"html",
								            success:function(data){
								               $("#reviewFrm").html(data);
								               $("#reviewFrm").css({"display":"block"});
								            }
								         });
								      }); --%>
							    
								</script>
								
</section>
				<!-- link that opens popup -->
				<!-- <script
                src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                <script
                src="https://static.codepen.io/assets/common/stopExecutionOnTimeout-de7e2ef6bfefd24b79a3f68b414b87b8db5b08439cac3f1012092b2290c719cd.js"></script>
                <script src="
                https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js">
                </script> -->
				<!-- JS here -->
				<script src="<%=request.getContextPath() %>/js/vendor/modernizr-3.5.0.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/vendor/jquery-1.12.4.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/popper.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/owl.carousel.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/isotope.pkgd.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/ajax-form.js"></script>
				<script src="<%=request.getContextPath() %>/js/waypoints.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/jquery.counterup.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/imagesloaded.pkgd.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/scrollIt.js"></script>
				<script src="<%=request.getContextPath() %>/js/jquery.scrollUp.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/wow.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/nice-select.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/jquery.slicknav.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/jquery.magnific-popup.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/plugins.js"></script>
				<script src="<%=request.getContextPath() %>/js/gijgo.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/slick.min.js"></script>
				<!--contact js-->
				<script src="<%=request.getContextPath() %>/js/contact.js"></script>
				<script src="<%=request.getContextPath() %>/js/jquery.ajaxchimp.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/jquery.form.js"></script>
				<script src="<%=request.getContextPath() %>/js/jquery.validate.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/mail-script.js"></script>
				<script src="<%=request.getContextPath() %>/js/main.js"></script>
<!-- 				<script>
                    $('#datepicker').datepicker({
                        iconsLibrary: 'fontawesome',
                        icons: {
                            rightIcon: '<span class="fa fa-caret-down"></span>'
                        }
                    });
                </script> -->

				<!-- 써치 필터 js -->
				<script src="<%=request.getContextPath() %>/js/js_cal/jquery-3.3.1.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/js_cal/bootstrap.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/js_cal/jquery.magnific-popup.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/js_cal/jquery-ui.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/js_cal/jquery.nice-select.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/js_cal/jquery.slicknav.js"></script>
				<script src="<%=request.getContextPath() %>/js/js_cal/owl.carousel.min.js"></script>
				<script src="<%=request.getContextPath() %>/js/js_cal/main.js"></script>
				
			


