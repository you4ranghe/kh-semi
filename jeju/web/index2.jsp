<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<script src="<%=request.getContextPath() %>/js/popper.min.js"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>

<!-- Include the plugin's CSS and JS: -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-multiselect.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-multiselect.css" type="text/css"/>

<section id="content">
	<!-- slider_area_start 대형이미지 슬라이더 -->
    <div class="slider_area">
        <div class="slider_active owl-carousel">
        <!-- 여기가 사진 하나시작 -->
            <div class="single_slider  d-flex align-items-center slider_bg_1 overlay">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-xl-12 col-md-12">
                            <div class="slider_text text-center">
                                <h3>서귀포시</h3>
                                <p></p>
                                <a href="#" class="boxed-btn3">상품 보기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="single_slider  d-flex align-items-center slider_bg_2 overlay">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-xl-12 col-md-12">
                            <div class="slider_text text-center">
                                <h3>동제주시</h3>
                                <p></p>
                                <a href="#" class="boxed-btn3">상품 보기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="single_slider  d-flex align-items-center slider_bg_3 overlay">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-xl-12 col-md-12">
                            <div class="slider_text text-center">
                                <h3>서제주시</h3>
                                <p></p>
                                <a href="#" class="boxed-btn3">상품 보기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="single_slider  d-flex align-items-center slider_bg_3 overlay">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-xl-12 col-md-12">
                            <div class="slider_text text-center">
                                <h3>제주시</h3>
                                <p></p>
                                <a href="#" class="boxed-btn3">상품 보기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- slider_area_end -->

    <!-- where_togo_area_start 취향날짜선택 우리 내용으로 바꾸면 됨-->
    <div class="where_togo_area">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-3">
                    <div class="form_area">
                        <h3>검색하기</h3>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="search_wrap">
                        <form class="search_form" action="#">
                             <div class="input_field">
                            	<select id="area-select" multiple="multiple">
							        <option data-display="cheese">서귀포시</option>
							        <option value="tomatoes">제주시</option>
							        <option value="mozarella">동제주시</option>
							        <option value="mushrooms">서제주시</option>
							    </select> 
                               
                            </div>
                            <div class="input_field">
                                <input id="datepicker" placeholder="Date">
                            </div>
                            <div class="input_field">
                                <select>
                                    <option data-display="Travel type">Travel type</option>
                                    <option value="1">Some option</option>
                                    <option value="2">Another option</option>
                                </select>
                            </div>
                            <div class="search_btn">
                                <button class="boxed-btn4 " type="submit" >Search</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div>
    	
    	
    </div>
    <style>
    	#area-select{
    		width:5px;
    		height:5px;
    	}
    </style>
	
    
       어디갔니
		 
	<script> 
       $(document).ready(function() {
           $('#area-select').multiselect();
       });
       $("#datepicker").datepicker();
	</script>
	
	
<%@ include file="/views/common/footer.jsp" %>