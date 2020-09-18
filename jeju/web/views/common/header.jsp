<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.member.model.vo.Member,com.semi.common.listener.LoginCheckListener" %>
<%
	Member logginedMember = (Member)session.getAttribute("logginedMember");
	int connectCount=LoginCheckListener.getConnectCount();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JEJU</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/header.css" type="text/css">
        
    <!-- 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
    <!-- jQuery -->
	<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/popper.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-multiselect.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-multiselect.css">

    <!-- 템플릿링크들 -->
     <!-- <link rel="manifest" href="site.webmanifest"> -->

    <link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath() %>/img/favicon.png">

    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-multiselect.css">
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
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
    
    
    
    <!-- fontawesome에서 아이콘쓸때 -->
    <script src="https://kit.fontawesome.com/27fabf8f47.js" crossorigin="anonymous"></script>

</head>  
<body>
    <header>
        <div class="header-area ">
            <div id="sticky-header" class="main-header-area">
                <div class="container-fluid">
                    <div class="header_bottom_border">
                        <div class="row align-items-center">
                            <div class="col-xl-2 col-lg-2">
                                <div class="logo">
                                    <a href="index.html">
                                        <img src="<%=request.getContextPath() %>/img/logo.png" alt=""><!--이미지로고바꾸면됨-->
                                    </a>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6">
                                <div class="main-menu  d-none d-lg-block">
                                    <nav>
                                        <ul id="navigation">
                                            <li><a class="active" href="<%=request.getContextPath()%>">Home</a></li>
                                            <li><a href="#">About <i class="ti-angle-down"></i></a>
                                                <ul class="submenu">
                                                        <li><a href="<%=request.getContextPath()%>/views/introduce/companyIntroduce.jsp">About Us</a></li>
                                                        <li><a href="elements.html">About Jeju</a></li>
                                                </ul>
                                            </li>
                                            
                                            <li><a class="" href="travel_destination.html">Travel</a></l/li>
                                            <li><a href="#">Community <i class="ti-angle-down"></i></a>
                                                <ul class="submenu">
                                                        <li><a href="destination_details.html">동행구하기</a></li>
                                                        <li><a href="elements.html">Q&A</a></li>
                                                </ul>
                                            </li>
                                                                          
                                        </ul>
                                    </nav>
                                </div>
                            </div>
             
                       
             
                            <div class="col-xl-3 col-lg-4 d-none d-lg-block">
                                <div class="social_wrap d-flex align-items-center justify-content-end">
                                    <div class="number">
                                        <p> <i class="fa fa-phone"></i> email주소</p>
                                    </div>
                                    <!-- sns연결 -->
                                    <div class="social_links d-none d-xl-block">
                                        <ul>
                                            <li><a href="#"> <i class="fa fa-instagram"></i> </a></li>
                                            <li><a href="#"> <i class="fa fa-facebook"></i> </a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div clas="col-xl-1 col-lg-4 d-none d-lg-block">
                                    <div class="main-menu  d-none d-lg-block">
                                    <nav>
                                        <ul id="navigation2">
                                            <li><i class="fas fa-user-circle fa-2x"></i>
												<ul class="submenu">
												<%if(logginedMember==null){ %>
                                                        <li><a href="<%=request.getContextPath()%>/member/enroll">회원가입</a></li>
                                                        <li><a href="<%=request.getContextPath() %>/member/login" >로그인</a></li>
	                                         	<%}else{%>
	                                         			<li><%=logginedMember.getUserName()%>님, 안녕하세요</li>
	                                         			<li><a href="<%=request.getContextPath()%>/member/mypage?userId=<%=logginedMember.getUserId()%>">마이페이지</a></li>
	                                         			<li><a href="<%=request.getContextPath()%>/member/logout">로그아웃</a></li>
                                   				<%} %>
                                   				<%if(logginedMember!=null&&logginedMember.getUserId().equals("admin")){ %>
                                   						<li><a href="<%=request.getContextPath()%>/admin/memberList">회원관리</a></li>
	                                         	<%} %>
                                                </ul>
											</li>
                                        </ul>
                                    </nav>
                                	</div>
                            </div>
                            
                            <div class="col-12">
                                <div class="mobile_menu d-block d-lg-none"></div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </header>
    
   
    <!-- header-end -->

 