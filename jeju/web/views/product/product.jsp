<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@page import = "java.util.List"%>
    <%@page import="com.semi.product.model.vo.Product"%>
    <%@page import="com.semi.payment.model.vo.Payment"%>
    <%@page import="com.semi.wishList.model.vo.WishList"%>

<%
	Product p = (Product)request.getAttribute("product");
	Payment pm = (Payment)request.getAttribute("payment");
	WishList wl = (WishList)request.getAttribute("wishlist");
%>    

<%@ include file="/views/common/header.jsp" %>

<!DOCTYPE html>
<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>GotJeju</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- <link rel="manifest" href="site.webmanifest"> -->
        <link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath() %>/img/favicon.png">
        <!-- Place favicon.ico in the root directory -->

        <!-- CSS here -->
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/owl.carousel.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/magnific-popup.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/themify-icons.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/nice-select.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/flaticon.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/gijgo.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/animate.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/slick.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/slicknav.css">
        <link
            rel="stylesheet"
            href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">

        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">

        <!-- <link rel="stylesheet" href="css/responsive.css"> -->

        <!--써치 필터 css-->
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jisun_search-filter.css"> 
        <!-- 디테일 상품 본문 css -->
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jisun_detail-product.css">

    </head>

    <body>
        <!--[if lte IE 9]> <p class="browserupgrade">You are using an
        <strong>outdated</strong> browser. Please <a
        href="https://browsehappy.com/">upgrade your browser</a> to improve your
        experience and security.</p> <![endif]-->

        

        <div class="destination_banner_wrap overlay">
            <div class="destination_text text-center">
        
                <h3>${p.pBigNameEng}</h3> 
                <p> ${p.pBigNameKor}</p>
            </div>
        </div>
        
        

     	 
        <!-- 데스티네이션 -->
        <!-- <div class="destination_details_info"> <div class="container"> <div
        class="row justify-content-center"> <div class="col-lg-8 col-md-9"> <div
        class="destination_info"> <h3>Description</h3> <p>There are many variations of
        passages of Lorem Ipsum available, but the majority have suffered alteration in
        some form, by injected humour, or randomised words which don't look even
        slightly believable. If you are going to use a passage of Lorem Ipsum, you need
        to be sure there isn't anything embarrassing.</p> <p>Variations of passages of
        lorem Ipsum available, but the majority have suffered alteration in some form,
        by injected humour, or randomised words which don't look even slightly
        believable. If you are going to use a passage of Lorem Ipsum, you need to be
        sure there isn't anything embarrassing.</p> <div class="single_destination">
        <h4>Day-01</h4> <p>There are many variations of passages of Lorem Ipsum
        available, but the majority have suffered alteration in some form, by injected
        humour, or randomised words.</p> </div> <div class="single_destination">
        <h4>Day-02</h4> <p>There are many variations of passages of Lorem Ipsum
        available, but the majority have suffered alteration in some form, by injected
        humour, or randomised words.</p> </div> <div class="single_destination">
        <h4>Day-03</h4> <p>There are many variations of passages of Lorem Ipsum
        available, but the majority have suffered alteration in some form, by injected
        humour, or randomised words.</p> </div> </div> <div class="bordered_1px"></div>
        <div class="contact_join"> <h3>Contact for join</h3> <form action="#"> <div
        class="row"> <div class="col-lg-6 col-md-6"> <div class="single_input"> <input
        type="text" placeholder="Your Name"> </div> </div> <div class="col-lg-6
        col-md-6"> <div class="single_input"> <input type="text" placeholder="Phone
        no."> </div> </div> <div class="col-lg-12"> <div class="single_input"> <textarea
        name="" id="" cols="30" rows="10"placeholder="Message" ></textarea> </div>
        </div> <div class="col-lg-12"> <div class="submit_btn"> <button
        class="boxed-btn4" type="submit">submit</button> </div> </div> </div> </form>
        </div> </div> </div> </div> </div> -->
        <!-- 데스티네이션 끝 -->
        
        
        
 <!-- 써치필터 Section Begin -->
        
            <section class="search-filter">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                        
                            <form action="<%=request.getContextPath() %>/product/productGoCart" method="post" class="check-form" name="price_exec">
                            
                                <h4>Check Option</h4>
                                <div class="datepicker">
                                    <p>From</p>
                                    <input type="date" name="pDateStart" min="${p.pDateStart}" max="${p.pDateFinish}" >
                                    <input type="hidden" name="poDate">
                                    <!-- <img src="img/calendar.png" alt=""> -->
                                </div>
<%--                                 <div class="datepicker">
                                    <p>To</p>
                                <input type="date" name="pDateFinish" min="2020-01-01" max="2020-12-31" value="${pm.pDateFinish}">
                                    <!-- <img src="img/calendar.png" alt=""> -->
                                </div> --%>
                                
                                
                                
                                <div class="room-quantity">
                                
										Total <span id='total_price' name='total_price'>0</span>원
										
										<input type=hidden name='total_price' value='${p.pPriceA}'>
										<input type=hidden name='total_price2' value='${p.pPriceC}'>
										
										<input type=hidden name='totalPrice' value='0'>
										
										Adult <select name='pCountA' onChange='change_price();' >
												    <option value='0'>0</option>
												    <option value='1'>1</option>
												    <option value='2'>2</option>
												    <option value='3'>3</option>
												    <option value='4'>4</option>
												    <option value='5'>5</option>
												    <option value='6'>6</option>
												    <option value='7'>7</option>
												    <option value='8'>8</option>
												    <option value='9'>9</option>
												    <option value='10'>10</option>
										    	</select>
										  
										Child <select name='pCountC' onChange='change_price();'>
												    <option value='0'>0</option>
												    <option value='1'>1</option>
												    <option value='2'>2</option>
												    <option value='3'>3</option>
												    <option value='4'>4</option>
												    <option value='5'>5</option>
												    <option value='6'>6</option>
												    <option value='7'>7</option>
												    <option value='8'>8</option>
												    <option value='9'>9</option>
												    <option value='10'>10</option>
												</select>
										      
										<script>
										
										function change_price(value){
										    
										    var f=document.price_exec;
										    original_price=parseInt(f.total_price.value);
										
										    ok_price=(original_price * f.pCountA.value) + (original_price * f.pCountC.value);
										
										    var checked_price=''+ok_price;
										
										    if(checked_price.length-1>=6){
										   
										        alength=checked_price.length-1;
										       
										        count_r=parseInt(alength%3);
										        count_r=3-count_r;
										        count=parseInt(checked_price.length-1)+parseInt(count_r);
										        count_rd=parseInt((alength+1)%3);
										        first=((count/3-1)*3)-2;
										        second=first-3;
										        third=0;
										        ook_price_1=checked_price.substr(first,3);
										        ook_price_2=checked_price.substr(second,3)+',';
										        if(checked_price.substr(third,count_rd)!=''){
										            ook_price_3=checked_price.substr(third,count_rd)+',';
										        }else{
										            ook_price_3='';
										        }
										        print_price=ook_price_3+ook_price_2+ook_price_1;
										
										    }else if(checked_price.length-1>4 && checked_price.length-1<6){
										        ook_price_1=checked_price.substr(3,3);
										        ook_price_2=checked_price.substr(0,checked_price.length-3);
										        print_price=ook_price_2+','+ook_price_1;
										    }else{
										        print_price=checked_price;
										    }
										    total_price.innerHTML=print_price;
										    f.totalPrice.value=ok_price;
										}
										
										change_price();
										</script>
                                    <%-- <div class="single-quantity">
                                        <p>Adults</p>
                                        <input type="number" class="pro-qty" min="0" step="1" size="5" value="${p.pCountA}" name="getsu" onclick='change_price();'>
                                    </div>
                                    
                                    
                                    <div class="single-quantity">
                                        <p>Children</p>
                                         <input type="number" class="pro-qty" min="0" step="1" size="5" value="${p.pCountC}" name="getsu" onclick='change_price();'>
                                        
                                    </div> --%>
                                    <!-- <div class="single-quantity last">
                                        <p>Rooms</p>
                                        <div class="pro-qty"><input type="text" value="0"></div>
                                    </div> -->
                                   
                                </div>
                                
                                
                                
                                
                                <div class="room-selector">
                                    <p>Time</p>
                                    <select class="suit-select" name="pTime">
                                        <option>Check your Time</option>
                                        <option value="09:00">09:00</option>
                                        <option value="12:00">12:00</option>
                                        <option value="15:00">15:00</option>

                                    </select>
                                </div>
                                
                                
                                <!-- 아이디넘기기 -->
                                <input type="hidden" name="userId" value="<%=logginedMember.getUserId()%>">
                                <input type="hidden" name="pNum" value='${p.pNum}'>
                                
                                
                                
                                <button type="submit">buy</button>
                               
                                
                            </form>
                            
                        </div>
                    </div>
                </div>
            </section>
	  
      
<!-- Search Filter Section End -->



        <!--================Blog Area =================-->
        <section class="blog_area single-post-area section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 posts-list">

                        <div class="single-post">
                            <div class="feature-img">
                                <img class="img-fluid" src="<%=request.getContextPath() %>/img/destination/jeju_yacht.png" alt="">
                            </div>

                            <div class="blog_details">
                                <h2>${p.pBigNameKor}
                                
                                
                                  <a class="heart-button" href="<%=request.getContextPath()%>/wishList?userId=<%=logginedMember.getUserId()%>
                                  &&pNum=${p.pNum}">
                                        ♥
                                    </a>
                                          	 
                       
<!--                                   <script>
                                 	
                                  $.ajaxSettings.traditional = true;
                                  
                                    $.ajax({
                                    	var id = document.getElementsByName("userId");
                                    	var num = document.getElementsByName("pNum");
									    url: '/views/wishlist/wishListView.jsp',
									    type: 'post',
									    data: {"id":id,
									       			"num":num,

									    success: function (data) {
									            alert("데이터 전송 성공");
									        }
									});
                                    </script>   -->
                                <%--     <script>
										$("#ajax").click(e => {
											$.ajax({
												url:'<%=request.getContextPath()%>/wishList',
												type:"get",
												data: {userId: "${pm.userId}",
									       					pNum: "${pm.pNum}"},
												success: data => {
													console.log(data);
													$("#ajax").html(data);
												}
											})
										})
								</script> --%>
                                    
                                </h2>
                                <!-- <ul class="blog-info-link mt-3 mb-4">
                                    <li>
                                        <a href="#">
                                            <i class="fas fa-location-arrow"></i>
                                            제주도&nbsp;</a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            - 서귀포시
                                        </a>
                                    </li>
                                </ul> -->
<%--  <%} %> --%>
                                <!-----♥♥♥♥♥♥♥간단한 상품정보♥♥♥♥♥♥♥----->
                                <div class="product-benefit">
                                    <hr>
                                    <!---->
                                    <div class="critical-info">
                                        <!-- <i class="far fa-clock"></i> -->
                                        <span>
                                        	<p style="white-space: pre-line;">
                                        	${p.pPointInfo}
                                        	</p>
                                        </span>
                                    </div>

                                   <!--  <div class="critical-info">
                                        <i class="fab fa-glide"></i>
                                        <span>
                                            한국어,영어 가이드</span>
                                    </div>

                                    <div class="critical-info">
                                        <i class="fas fa-ticket-alt"></i>
                                        <span>현장에서 전자바우처를 제시해주세요.</span>
                                    </div> -->

                                    <hr>
                                </div>
                                <!-----♥♥♥♥♥♥♥간단한 상품정보 끝♥♥♥♥♥♥♥----->

                                <p class="excert" style="white-space: pre-line;">
                                    ${p.pInfo}
                                </p>
                                <!-- <p style="white-space: pre-line;">
                                    Did you know that you can enjoy a luxury yacht trip on a small travel budget?
                                    Let's go to the Grand Blue yacht experience with Jeju! From Seogwipo Daepo Port,
                                    you will board the Grand Blue Yacht and follow the dolphin spotting route,
                                    passing the columnar joint. While sailing, you can enjoy the beautiful scenery
                                    of Jeju Island to your heart's content. In addition to this, you can experience
                                    fishing directly at the fishing spot, You can relax with beer and wine on board.
                                    Enjoy a luxurious yacht experience at a reasonable price!
                                </p> -->
                                <div class="quote-wrapper">
                                    <div id="product-info-sec" class="info-section">

                                        <h3 class="info-title">PRODUCT DESCRIPTION</h3>

                                        <div>
                                            <a
                                                href="#none"
                                                id="explain"
                                                onclick="if(hide2.style.display=='none')
                            {hide2.style.display='';explain.innerText='▲FOLD'}
                            else {hide2.style.display='none';explain.innerText='▶MORE'}">▶MORE</a>
                                            <div id="hide2" style="display: none">
                                                <div class="info-sec-collapsable expand">
                                                    <div>
	                                                    <p style="white-space: pre-line;">
	                                                    	${p.pIntd}
	                                                    </p>
                                                        <!-- <p>【POINTS】</p>
                                                        <p>・ 8월 31일 13:00까지 저렴한 한정특가로 예약해보세요! 12월 31일까지 체험할 수 있습니다!</p>
                                                        <p>・ 제주도의 절경! 주상절리 대를 직접 감상해보세요.</p>
                                                        <p>・ 시원한 맥주를 마시고 낚시를 하며 최고의 여유로움을 만끽해보세요.</p>
                                                        <p>・ 매우 고급스러운 선상은 가히 요트계의 페라리라고 불릴만합니다.</p>
                                                        <p><br><br>【INFORMATION】</p>
                                                        <p>・ 집합시간 : 체험 시간대 20분 전까지</p>
                                                        <p>・ 집합장소 : 제주도 특별자치도 서귀포시 대포로 172-7번지<br>・ 총 소요시간 : 약 60분<br>・ 영업시간 : 09:00-17:30<br>・ 체험시간 : 09:30, 10:50, 13:20, 14:40, 16:00, 17:30<br>(날씨 혹은 선박 상태에 따라 시간이 조정되거나 취소될 수 있습니다.)<br>・ 교통안내 : 600번 버스 탑승 후 대포항에서 하차해 도보 5분 후 그랑블루 GRANDEBLEU 사무실 도착<br><br><br>【INTRODUCTION】<br>요트
                                                            위에서 감상하는 아름다운 바다 풍경, 셀럽들의 화려한 선상파티, 요트에서 여유롭게 술 한 잔 등등 우리 모두 한 번쯤은 꿈꿔봤지만, 만만치 않은
                                                            가격 때문에 매번 포기하기 일쑤였죠. 그래서 KKday가 준비했습니다! 합리적인 가격의 제주도 그랑블루 요트 체험! 호화로운 선상에서 아름다운
                                                            제주도의 풍경을 감상할 수 있을 뿐만 아니라, 돌고래 출몰 노선을 따라 최고의 절경「주상절리 대」까지 유람할 수 있어요. 이 외에도, 시원한
                                                            맥주와 풍부한 맛의 와인을 무제한으로 마시고 여유로운 낚시 또한 즐길 수 있답니다.
                                                            <br><br>항해 노선 :
                                                            <br>대포항 - 주상절리 대 - 바다낚시, 돌고래 감상 - 선상 자유활동 - 대포항<br><br><br>【OPTION】<br>체험 포함 내용 :
                                                            <br>주상절리 대 감상 (개별 사진 촬영 가능)<br>바다 낚시 (15-20분)<br>돌고래 흔적 탐색 (돌고래 감상)<br><br><br>【NOTICE】<br>・ 본 체험에는 생선회 제공이 포함되어 있지 않습니다.<br>・ 요트 체험 시 맥주, 와인 그리고 과일을 제공하나, 바다 낚시 체험 시 알코올 음료를 제공하지 않습니다.<br>・ 만 3세 미만의 아동은 무료 참여가 가능하며, 만 3세 이상의 아동은 체험 티켓을 예매해야 합니다.<br>・ 날씨 혹은 선박 상태에 따라 체험 시간이 조정되거나 취소될 수 있습니다.<br><br><br>【HOW TO USE】<br>체험 시간 20분 전까지 매표소에서 신분증과 전자바우처 제시 후 승선신청표를 작성해 주시기 바랍니다.</p> -->
                                                    </div>

                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>

                                <!-----♥♥♥♥♥♥♥일정소개사진♥♥♥♥♥♥♥----->
                                <div id="schedule-sec" class="info-section">
                                    <h3 class="info-title">SCHEDULE</h3>

                                    <div>
                                        <a
                                            href="#none"
                                            id="schedule"
                                            onclick="if(hide3.style.display=='none')
											    {hide3.style.display='';schedule.innerText='▲FOLD'}
											    else {hide3.style.display='none';schedule.innerText='▶MORE'}">▶MORE</a>
                                        <div id="hide3" style="display: none">
                                            <div class="info-sec-collapsable expand">

                                                <i class="fas fa-clock"></i>
                                                <span>${p.runtime}</span></div>

                                            <div>

                                                <ul class="time-info">
                                                    <li class="time-info-spot">

                                                        <div class="pd-info-img">
                                                        	<img src="${p.scheduleImgPath}">
                                                           <%--  <img src="<%=request.getContextPath() %>/img/destination/jeju1.jpg" alt=""> --%>
                                                        </div>
                                                    </li>
                                                   <%--  <li>
                                                        <div class="pd-info-img">
                                                            <img src="<%=request.getContextPath() %>/img/destination/jeju2.jpg" alt="">
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="pd-info-img">
                                                            <img src="<%=request.getContextPath() %>/img/destination/jeju3.jpg" alt="">
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="pd-info-img">
                                                            <img src="<%=request.getContextPath() %>/img/destination/jeju4.jpg" alt="">
                                                        </div>
                                                    </li> --%>
                                                </ul>

                                            </div>
                                        </div>
                                    </div>

                                </div>
                                
                                <!-- 일정소개사진 끝 -->

                            </div>

                        </div>

                        <div class="navigation-top">
                            <div class="d-sm-flex justify-content-between text-center">
                                <p class="like-info">
                                    <span class="align-middle">
                                        <i class="fa fa-heart"></i>
                                    </span>
                                    Lily and 4 people like this</p>
                                <div class="col-sm-4 text-center my-2 my-sm-0">
                                    <!-- <p class="comment-count"><span class="align-middle"><i class="fa
                                    fa-comment"></i></span> 06 Comments</p> -->
                                </div>
                                <ul class="social-icons">
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-facebook-f"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-twitter"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-dribbble"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-behance"></i>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <!-- <div class="navigation-area"> <div class="row"> <div class="col-lg-6
                            col-md-6 col-12 nav-left flex-row d-flex justify-content-start
                            align-items-center"> <div class="thumb"> <a href="#"> <img class="img-fluid"
                            src="img/post/preview.png" alt=""> </a> </div> <div class="arrow"> <a href="#">
                            <span class="lnr text-white ti-arrow-left"></span> </a> </div> <div
                            class="detials"> <p>Prev Post</p> <a href="#"> <h4>Space The Final Frontier</h4>
                            </a> </div> </div> <div class="col-lg-6 col-md-6 col-12 nav-right flex-row
                            d-flex justify-content-end align-items-center"> <div class="detials"> <p>Next
                            Post</p> <a href="#"> <h4>Telescopes 101</h4> </a> </div> <div class="arrow"> <a
                            href="#"> <span class="lnr text-white ti-arrow-right"></span> </a> </div> <div
                            class="thumb"> <a href="#"> <img class="img-fluid" src="img/post/next.png"
                            alt=""> </a> </div> </div> </div> </div> -->
                        </div>





                        <div class="blog-author">
                            <div class="media align-items-center">
                                <img src="img/destination/yoo.jpg" alt="">
                                <div class="media-body">
                                    <div class="board bg-highlihgt mt-20" id="becareful">
                                        <h4 class="info-subtitle mt-0">NOTICE</h4>

                                        <div class="mt-10">
                                            <ul>
                                                <li>
                                                    <p>${p.precaution}</p>
                                                </li>
                                               <!--  <li>
                                                    <p>승전 전, 반드시 승선신청표를 작성해 주셔야 합니다. 또한 현장 직원에게 신분증을 제시해 주시기 바랍니다.</p>
                                                </li>
                                                <li>
                                                    <p>본 체험 참여 시 하이힐 착용을 금지합니다.</p>
                                                </li>
                                                <li>
                                                    <p>요트 탑승 시 현장 직원의 안내에 협조해 주시기 바랍니다. 만일 안내 미협조로 인한 부상 및 귀중품 분실 시, 이에 대한 책임은 모두 승객
                                                        본인에게 있습니다.</p>
                                                </li>
                                                <li>
                                                    <p>항상 아동의 안전에 주의해 주시기 바랍니다.</p>
                                                </li>
                                                <li>
                                                    <p>날씨 혹은 선박 상태에 따라 체험 시간이 조정되거나 취소될 수 있습니다.</p>
                                                </li> -->
                                            </ul>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>





                        <!-----♥♥♥♥♥♥♥집합장소 지도♥♥♥♥♥♥♥----->
                        <!-- <div id="meeting-sec" class="info-section2"> <h3 class="info-title">집합
                        장소</h3> -->

                        <!-- <div> -->
                        <div class="map-board">

                            <div class="board-title">
                                <h3 class="info-title">MEETING PLACE</h3>
                                <h4>위치：GRANDEBLEU 탑승장소</h4>
                                <div class="text-grey">${p.pMapName}</div>
                            </div>

                            <hr>

                            <div class="pd-info-img">
                                <div class="embed-responsive embed-responsive-16by9">
                                   <!--  <iframe
                                        src="https://www.google.com/maps/embed?pb=!1m10!1m8!1m3!1d26624.14631548044!2d126.3802559!3d33.4748746!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sko!2skr!4v1597559729830!5m2!1sko!2skr"
                                        width="600"
                                        height="450"
                                        frameborder="0"
                                        style="border: 0px;"
                                        allowfullscreen="allowfullscreen"
                                        aria-hidden="false"
                                        tabindex="0"></iframe> -->
                                        <iframe   src="${p.pMap}"
                                        width="600"
                                        height="450"
                                        frameborder="0"
                                        style="border: 0px;"
                                        allowfullscreen="allowfullscreen"
                                        aria-hidden="false"
                                        tabindex="0"></iframe>
                                </div>
                            </div>

                        </div>
                        <!-----♥♥♥♥♥♥♥집합장소 지도 끝♥♥♥♥♥♥♥----->






                        <div class="comments-area">
                            <h4>REVIEW</h4>
                            <div class="comment-list">
                                <div class="single-comment justify-content-between d-flex">
                                    <div class="user justify-content-between d-flex">
                                        <div class="thumb">
                                            <img src="<%=request.getContextPath() %>/img/comment/comment_1.png" alt="">
                                        </div>
                                        <div class="desc">
                                            <p class="comment">
                                                Multiply sea night grass fourth day sea lesser rule open subdue female fill
                                                which them Blessed, give fill lesser bearing multiply sea night grass fourth day
                                                sea lesser
                                            </p>
                                            <div class="d-flex justify-content-between">
                                                <div class="d-flex align-items-center">
                                                    <h5>
                                                        <a href="#">Emilly Blunt</a>
                                                    </h5>
                                                    <p class="date">December 4, 2020 at 3:12 pm
                                                    </p>
                                                </div>
                                                <div class="reply-btn">
                                                    <a href="#" class="btn-reply text-uppercase">reply</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="comment-list">
                                <div class="single-comment justify-content-between d-flex">
                                    <div class="user justify-content-between d-flex">
                                        <div class="thumb">
                                            <img src="<%=request.getContextPath() %>/img/comment/comment_2.png" alt="">
                                        </div>
                                        <div class="desc">
                                            <p class="comment">
                                                Multiply sea night grass fourth day sea lesser rule open subdue female fill
                                                which them Blessed, give fill lesser bearing multiply sea night grass fourth day
                                                sea lesser
                                            </p>
                                            <div class="d-flex justify-content-between">
                                                <div class="d-flex align-items-center">
                                                    <h5>
                                                        <a href="#">Emilly Blunt</a>
                                                    </h5>
                                                    <p class="date">December 4, 2017 at 3:12 pm
                                                    </p>
                                                </div>
                                                <div class="reply-btn">
                                                    <a href="#" class="btn-reply text-uppercase">reply</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="comment-list">
                                <div class="single-comment justify-content-between d-flex">
                                    <div class="user justify-content-between d-flex">
                                        <div class="thumb">
                                            <img src="<%=request.getContextPath() %>/img/comment/comment_3.png" alt="">
                                        </div>
                                        <div class="desc">
                                            <p class="comment">
                                                Multiply sea night grass fourth day sea lesser rule open subdue female fill
                                                which them Blessed, give fill lesser bearing multiply sea night grass fourth day
                                                sea lesser
                                            </p>
                                            <div class="d-flex justify-content-between">
                                                <div class="d-flex align-items-center">
                                                    <h5>
                                                        <a href="#">Emilly Blunt</a>
                                                    </h5>
                                                    <p class="date">December 4, 2017 at 3:12 pm
                                                    </p>
                                                </div>
                                                <div class="reply-btn">
                                                    <a href="#" class="btn-reply text-uppercase">reply</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>






                        <div class="comment-form">
                            <h4>LEAVE A REVIEW</h4>
                            <form class="form-contact comment_form" action="#" id="commentForm">
                                <div class="row">
                                    <div class="col-12">
                                        <div class="form-group">
                                            <textarea
                                                class="form-control w-100"
                                                name="comment"
                                                id="comment"
                                                cols="30"
                                                rows="9"
                                                placeholder="Write Comment"></textarea>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <input
                                                class="form-control"
                                                name="name"
                                                id="name"
                                                type="text"
                                                placeholder="Name">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <input
                                                class="form-control"
                                                name="review-password"
                                                id="review-password"
                                                type="password"
                                                placeholder="Passwrod">
                                        </div>
                                    </div>
                                   <input type="hidden" name="rate" id="rate" value="0"/>
                                   
  

                                
                                <div class="starRev">
  <span class="starR on">별1</span>
  <span class="starR">별2</span>
  <span class="starR">별3</span>
  <span class="starR">별4</span>
  <span class="starR">별5</span>
<!--   <span class="starR">별6</span>
  <span class="starR">별7</span>
  <span class="starR">별8</span>
  <span class="starR">별9</span>
  <span class="starR">별10</span> -->
</div>
                                
                                
                                
                                
                                
                                
                                
                                </div>
                                
                                
                                
                                <div class="form-group">
                                    <button type="submit" class="button button-contactForm btn_1 boxed-btn">Send Message</button>
                                </div>
                            </form>
                        </div>
                    </div>






                    <div class="col-lg-4">
                        <div class="blog_right_sidebar">
                            <aside class="single_sidebar_widget search_widget">
                                <!-- <form action="#">
                                    <div class="form-group">
                                        <div class="input-group mb-3">
                                            <input
                                                type="text"
                                                class="form-control"
                                                placeholder='Search Keyword'
                                                onfocus="this.placeholder = ''"
                                                onblur="this.placeholder = 'Search Keyword'">
                                            <div class="input-group-append">
                                                <button class="btn" type="button">
                                                    <i class="ti-search"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                    <button
                                        class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
                                        type="submit">Search</button>
                                </form> -->
                                <div id="product-price-box">
                                    <li>
                                        <a href="#" class="d-flex">
                                            <p>ADULT &nbsp;</p>
                                            <p>${p.pPriceA}</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex">
                                            <p>CHILDREN &nbsp;</p>
                                            <p>${p.pPriceC}</p>
                                        </a>
                                    </li>
                                    
                                </div>
                                
                               <!--  원래가격 : <span id='total_price'>0</span>원
                                <form name='price_exec' method='get' onSubmit='submit_value();'> -->

                               <!--  금액 : <input type="text" name="sum" size="11" readonly> 원 -->
                                
                            </aside>
                            <!-- <aside class="single_sidebar_widget post_category_widget">
                                <h4 class="widget_title">Category</h4>
                                <ul class="list cat-list">
                                    <li>
                                        <a href="#" class="d-flex">
                                            <p>Resaurant food</p>
                                            <p>(37)</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex">
                                            <p>Travel news</p>
                                            <p>(10)</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex">
                                            <p>Modern technology</p>
                                            <p>(03)</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex">
                                            <p>Product</p>
                                            <p>(11)</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex">
                                            <p>Inspiration</p>
                                            <p>(21)</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex">
                                            <p>Health Care</p>
                                            <p>(21)</p>
                                        </a>
                                    </li>
                                </ul>
                            </aside> -->
                            <!-- <aside class="single_sidebar_widget popular_post_widget"> <h3
                            class="widget_title">Recent Post</h3> <div class="media post_item"> <img
                            src="img/post/post_1.png" alt="post"> <div class="media-body"> <a
                            href="single-blog.html"> <h3>From life was you fish...</h3> </a> <p>January 12,
                            2019</p> </div> </div> <div class="media post_item"> <img
                            src="img/post/post_2.png" alt="post"> <div class="media-body"> <a
                            href="single-blog.html"> <h3>The Amazing Hubble</h3> </a> <p>02 Hours ago</p>
                            </div> </div> <div class="media post_item"> <img src="img/post/post_3.png"
                            alt="post"> <div class="media-body"> <a href="single-blog.html"> <h3>Astronomy
                            Or Astrology</h3> </a> <p>03 Hours ago</p> </div> </div> <div class="media
                            post_item"> <img src="img/post/post_4.png" alt="post"> <div class="media-body">
                            <a href="single-blog.html"> <h3>Asteroids telescope</h3> </a> <p>01 Hours
                            ago</p> </div> </div> </aside> -->
                            <!-- <aside class="single_sidebar_widget tag_cloud_widget"> <h4
                            class="widget_title">Tag Clouds</h4> <ul class="list"> <li> <a
                            href="#">project</a> </li> <li> <a href="#">love</a> </li> <li> <a
                            href="#">technology</a> </li> <li> <a href="#">travel</a> </li> <li> <a
                            href="#">restaurant</a> </li> <li> <a href="#">life style</a> </li> <li> <a
                            href="#">design</a> </li> <li> <a href="#">illustration</a> </li> </ul> </aside>
                            <aside class="single_sidebar_widget instagram_feeds"> <h4
                            class="widget_title">Instagram Feeds</h4> <ul class="instagram_row flex-wrap">
                            <li> <a href="#"> <img class="img-fluid" src="img/post/post_5.png" alt=""> </a>
                            </li> <li> <a href="#"> <img class="img-fluid" src="img/post/post_6.png" alt="">
                            </a> </li> <li> <a href="#"> <img class="img-fluid" src="img/post/post_7.png"
                            alt=""> </a> </li> <li> <a href="#"> <img class="img-fluid"
                            src="img/post/post_8.png" alt=""> </a> </li> <li> <a href="#"> <img
                            class="img-fluid" src="img/post/post_9.png" alt=""> </a> </li> <li> <a href="#">
                            <img class="img-fluid" src="img/post/post_10.png" alt=""> </a> </li> </ul>
                            </aside> -->
                            <!-- <aside class="single_sidebar_widget newsletter_widget"> <h4
                            class="widget_title">Newsletter</h4> <form action="#"> <div class="form-group">
                            <input type="email" class="form-control" onfocus="this.placeholder = ''"
                            onblur="this.placeholder = 'Enter email'" placeholder='Enter email' required>
                            </div> <button class="button rounded-0 primary-bg text-white w-100 btn_1
                            boxed-btn" type="submit">Subscribe</button> </form> </aside> -->
                        </div>
                    </div>

                    
                </div>
            </div>
        </section>
        <!--================ Blog Area end =================-->

    </div>
    <!-- </div> </div> -->

    <!-- newletter_area_start -->
    <div class="newletter_area overlay">
        <div class="container">
            <div class="row justify-content-center align-items-center">
                <div class="col-lg-10">
                    <div class="row align-items-center">
                        <div class="col-lg-5">
                            <div class="newsletter_text">
                                <h4>Subscribe Our Newsletter</h4>
                                <p>Subscribe newsletter to get offers and about new places to discover.</p>
                            </div>
                        </div>
                        <div class="col-lg-7">
                            <div class="mail_form">
                                <div class="row no-gutters">
                                    <div class="col-lg-9 col-md-8">
                                        <div class="newsletter_field">
                                            <input type="email" placeholder="Your mail">
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-md-4">
                                        <div class="newsletter_btn">
                                            <button class="boxed-btn4 " type="submit">Subscribe</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- newletter_area_end -->

    <div class="popular_places_area">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="section_title text-center mb_70">
                        <h3>More Places</h3>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-6">
                    <div class="single_place">
                        <div class="thumb">
                            <img src="<%=request.getContextPath() %>/img/place/1.png" alt="">
                            <a href="#" class="prise">$500</a>
                        </div>
                        <div class="place_info">
                            <a href="#">
                                <h3>California</h3>
                            </a>
                            <p>United State of America</p>
                            <div class="rating_days d-flex justify-content-between">
                                <span class="d-flex justify-content-center align-items-center">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <a href="#">(20 Review)</a>
                                </span>
                                <div class="days">
                                    <i class="fa fa-clock-o"></i>
                                    <a href="#">5 Days</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single_place">
                        <div class="thumb">
                            <img src="<%=request.getContextPath() %>/img/place/2.png" alt="">
                            <a href="#" class="prise">$500</a>
                        </div>
                        <div class="place_info">
                            <a href="#">
                                <h3>Korola Megna</h3>
                            </a>
                            <p>United State of America</p>
                            <div class="rating_days d-flex justify-content-between">
                                <span class="d-flex justify-content-center align-items-center">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <a href="#">(20 Review)</a>
                                </span>
                                <div class="days">
                                    <i class="fa fa-clock-o"></i>
                                    <a href="#">5 Days</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single_place">
                        <div class="thumb">
                            <img src="<%=request.getContextPath() %>/img/place/3.png" alt="">
                            <a href="#" class="prise">$500</a>
                        </div>
                        <div class="place_info">
                            <a href="#">
                                <h3>London</h3>
                            </a>
                            <p>United State of America</p>
                            <div class="rating_days d-flex justify-content-between">
                                <span class="d-flex justify-content-center align-items-center">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <a href="#">(20 Review)</a>
                                </span>
                                <div class="days">
                                    <i class="fa fa-clock-o"></i>
                                    <a href="#">5 Days</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <!-- Modal -->
                <div
                    class="modal fade custom_search_pop"
                    id="exampleModalCenter"
                    tabindex="-1"
                    role="dialog"
                    aria-labelledby="exampleModalCenterTitle"
                    aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="serch_form">
                                <input type="text" placeholder="Search">
                                <button type="submit">search</button>
                            </div>
                        </div>
                    </div>
                </div>
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
                <script>
                    $('#datepicker').datepicker({
                        iconsLibrary: 'fontawesome',
                        icons: {
                            rightIcon: '<span class="fa fa-caret-down"></span>'
                        }
                    });
                </script>

                <!-- 써치 필터 js -->
                <script src="<%=request.getContextPath() %>/js/js_cal/jquery-3.3.1.min.js"></script>
                <script src="<%=request.getContextPath() %>/js/js_cal/bootstrap.min.js"></script>
                <script src="<%=request.getContextPath() %>/js/js_cal/jquery.magnific-popup.min.js"></script>
                <script src="<%=request.getContextPath() %>/js/js_cal/jquery-ui.min.js"></script>
                <script src="<%=request.getContextPath() %>/js/js_cal/jquery.nice-select.min.js"></script>
                <script src="<%=request.getContextPath() %>/js/js_cal/jquery.slicknav.js"></script>
                <script src="<%=request.getContextPath() %>/js/js_cal/owl.carousel.min.js"></script>
                <script src="<%=request.getContextPath() %>/js/js_cal/main.js"></script>



            </body>

        </html>
        
<%@ include file="/views/common/footer.jsp" %>