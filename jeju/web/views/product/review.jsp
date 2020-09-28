<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	WishList wl = (WishList)request.getAttribute("wishlist");
	
	Review r = (Review)request.getAttribute("review");
	List<Review> rlist = (List)request.getAttribute("reviewList"); 

%>

<%@ include file="/views/common/header.jsp" %>

    
<!DOCTYPE html>

<link rel="shortcut icon" type="image/x-icon"
	href="<%=request.getContextPath() %>/img/favicon.png">
<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/magnific-popup.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/themify-icons.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/nice-select.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/flaticon.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/gijgo.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/animate.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/slick.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/slicknav.css">
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">

<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/style.css">

<!-- <link rel="stylesheet" href="css/responsive.css"> -->

<!--써치 필터 css-->
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/jisun_search-filter.css">
<!-- 디테일 상품 본문 css -->
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/jisun_detail-product.css">
	
	
	
	
<section>


			<div class="comment-form">
						<h4>LEAVE A REVIEW</h4>
						
						<form class="form-contact comment_form" action="<%=request.getContextPath()%>/review/reviewEndServlet" id="commentForm" method="post">
						
							<div class="row">
							
							<!-- 리뷰번호 -->
							<!-- <input type="hidden" name="reviewNum"> -->
							 <input type="hidden" value="${p.pNum}" name="pNum" > 
							<input type="hidden" value="${r.poNum}" name="poNum">
							<input type="hidden" name="reviewLevel" value="1">
							<input type="hidden" name="productRef"  value="${p.pNum}">
							<input type="hidden" name="reviewRef" value="0">
							
							<!-- 리뷰제목 -->
							<div class="col-sm-6">
									<div class="form-group">
										<input class="form-control" name="reviewTitle" id="reviewTitle" type="text" placeholder="Write title">
									</div>
								</div>
								
								
								
								
							<!-- 작성자 -->
							<div class="col-sm-6">
								<div class="form-group">
									<input class="form-control" name="reviewWriter" id="reviewWriter" type="text" value="<%=logginedMember.getUserId()%>" placeholder="Name" readonly>
								</div>
							</div>
							
								
								<!-- 리뷰내용 -->
								<div class="col-12">
									<div class="form-group">
										<textarea class="form-control w-100" name="reviewContents"
											id="reviewContents" cols="30" rows="9"
											 placeholder="Write Comment"></textarea>
									</div>
								</div>
								
								
								<!-- 등록날짜 -->
								<div class="col-sm-6">
									<div class="form-group">
<!-- 										<input class="form-control" name="registerDate" 
										id="registerDate" type="text"> -->
										 <input type='date' id='currentDate' class="form-control">
										 
									</div>
								</div>
								</div>
						<script>
						  document.getElementById('currentDate').value = new Date().toISOString().substring(0, 10);;
						</script>
																
								<!-- 별점 -->
								<div class="col-sm-6">
 								 <select name="reviewScore" class="starRev">
									<option value='1' class="starR on">★</option>
									<option value='2' class="starR">★★</option>
									<option value='3' class="starR">★★★</option>
									<option value='4' class="starR">★★★★</option>
									<option value='5' class="starR">★★★★★</option>
 								</select> 
 								 </div>
 								<!--  <select class="starRev">
									<input type="radio" class="starR on">별1</span> 
									<span class="starR">별2</span>
									<span class="starR">별3</span> 
									<span class="starR">별4</span> 
									<span class="starR">별5</span> 
								</div>
 -->
							<input type="hidden" value="{pm.po_num}">
							<div class="form-group">
								<button type="submit" class="button button-contactForm btn_1 boxed-btn" 
								onclick = "function validate();" >
									Leave Review</button>
							</div>
							
							
						</form>
				
				
				<script>
						function validate(){
							const content=$("[reviewWriter=reviewContents]").val();
							if(content.trim().length==0){
								alert("내용을 입력해주세요!");
								$("[reviewWriter=reviewContents]").focus();
								return false;
							}
						}
					
				</script> 
				
				
						
					</div>




</section>



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
				
			
<!-- </body> -->

<!-- </html> -->

<%@ include file="/views/common/footer.jsp"%>
