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

<!-- 이 페이지 적용할 CSS -->
<style>
	/* section */

#localimg{
    padding:0px;
    margin:0px;
    width: 100%;
    height:400px;
    background-image: url("https://travelblog.expedia.co.kr/wp-content/uploads/2016/06/03.jpg");
}
#localimg>h1{
    padding-top:100px;
    margin-left:100px;
}
#localimg>h3{
    padding-left:100px;
}

#categorybtn{
    width:100%;
    height:60px;
}
#catagorybtn>div>button{
   /*  width:70px;
    height:40px;
    border-radius: 25px;
    border: 1px black solid;
    margin-left: 30px;
    margin-top:10px;
    margin-bottom:10px; */
    /* margin:30px;
    padding :30px; */
}
.catediv{
    position: relative;
    float :left;
}
.cate-content{
    display: none;
    position:absolute;
   	clear:both;
    /* background-color :  white;
    margin-left:35px;
    padding  :20px;
    width:80px;
    border-radius: 20px;
    border:1px gray solid; */
}
.check-content{
	clear:both;
    background-color :  white;
    margin-left:35px;
    padding  :20px;
    width:120px;
    border-radius: 20px;
    border:none;
}
.catediv:hover .cate-content {
    display: block;
    clear:both;
   
   
  }
#categorybtn>div{
   /*  float: left; */
}
hr{
   clear:both;
}
.travels{
    width:370px;
    height:270px;
    border :1px black solid;
    border-radius: 20px;
    margin:50px;
}
.travels img{
    width:370px;
    height:160px;
    padding:0px;
    margin:0px;
    border-top-left-radius: 20px;
    border-top-right-radius: 20px;
}
.travels>h3,h4{
    margin:10px;
}
.travels>h4{
    text-align: right;
}

#datepicker{
	width:100px;
	float :left;
}
.catebtn{
	float:left;
	
	margin:10px;
}
button+div{
	clear:both;
}
.btn{
	padding: 20px;
}
</style>




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
    <!-- <div class="where_togo_area">
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
    </div> -->
 
 
    <div id=categorybtn>
    <div>
    	
    
    </div>
    <form id="catefrm" action="">
    <div id="areadiv" class="dropdown catediv">
        
        <button id="areabtn" data-toggle="dropdown" class="genric-btn info radius">지역별</button>
            <ul class="dropdown-menu check-content">
                <li><label><input type="checkbox" name="place" id="place0" value="동제주시" checked> 동제주시</label> </li>
                <li><label><input type="checkbox" name="place" id="place1" value="서제주시" checked> 서제주시</label> </li>
                <li><label><input type="checkbox" name="place" id="place2" value="서귀포시" checked> 서귀포시</label> </li>
                <li><label><input type="checkbox" name="place" id="place3" value="제주시" checked> 제주시</label> </li>
            </ul>
        
    </div>
    <div id="datediv" class="catediv">
        <!-- <button id="datepicker" class="btn">날짜</button>
            <div class="cate-content"> -->
               <input id="datepicker" name="startdate" autocomplete="off" placeholder="날짜" class="catebtn genric-btn info radius">
           <!--  </div> -->

    
    </div>
  
    <div id="tastediv" class="dropdown catediv">
        
            <button id="tastebtn" class="genric-btn info radius" data-toggle="dropdown"> 취향별</button>
            <ul class="dropdown-menu check-content" role="menu">
                
                <li><label><input type="checkbox" name="favor" id="favor0" value="산" checked> 산</label></li>
                <li><label><input type="checkbox" name="favor" id="favor1" value="바다" checked> 바다</label></li>
                <li><label><input type="checkbox" name="favor" id="favor2" value="레저" checked> 레저</label></li>
                <li><label><input type="checkbox" name="favor" id="favor3" value="휴양" checked> 휴양</label></li>
                <li><label><input type="checkbox" name="favor" id="favor4" value="캠핑" checked> 캠핑</label></li>
            </ul>
    </div>
    
    <div class="search_btn">
        <button id="searchbtn" class="catebtn genric-btn default radius" type="submit" >Search</button>
     </div>
     </form>
    <hr>
</div>


    <div id="products-list-container"> 
        <div class="travels" z-index="10">
            <img src="https://www.lottehotel.com/content/dam/lotte-hotel/lotte/jeju/overview/introduction/g-0809.jpg.thumb.768.768.jpg" alt="" z-index="1">
            <h4>제주 어쩌구 저쩌구 투어</h4>
			<h5>3.5</h5>
            <h4 id="price">50000원</h4>
        </div>
    </div>


</section>

      <style>
      h5{
      padding : 10px;
      float:left;
      }
      h4#price{
      float:right;
      
      }
	</style>
	
	<script> 
	
       $(document).ready(function() {
           $('#area-select').multiselect();
       });
       $("#datepicker2").datepicker();
       $(function() {
           //input을 datepicker로 선언
           $("#datepicker").datepicker({
               dateFormat: 'yy-mm-dd' //Input Display Format 변경
               ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
               ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
               ,changeYear: true //콤보박스에서 년 선택 가능
               ,changeMonth: true //콤보박스에서 월 선택 가능                
               ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
               ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
               ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
               ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
               ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
               ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
               ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
               ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
               ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
               ,minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
               ,maxDate: "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                
           });                    
           
           //초기값을 오늘 날짜로 설정
           $('#datepicker').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)            
       });
       
       
	</script>
	
	
<%@ include file="/views/common/footer.jsp" %>