<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ page import="com.semi.product.model.vo.Product,java.util.List" %>

<%@ include file="/views/common/header.jsp" %>

<%
	List<Product> list=(List)request.getAttribute("list");
%>

<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<script src="<%=request.getContextPath() %>/js/popper.min.js"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script> --%>

<!-- Include the plugin's CSS and JS: -->
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-multiselect.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-multiselect.css" type="text/css"/>
 --%>
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
/* #categorybtn{
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
} */
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
	.thumbnail{
		background-color: rgb(244, 244, 244);
		radius : 10px;
		margin:20px;
	}
	.img-div{
		/* 둥글고 좀 여유있게 하기 */
	width :400px;
		
	
	}
	.wish,.wishclick{
		width:20px;
		height:20px;
		margin :10px;
	}
	.wish:hover,.wishclick:hover{
		transform: scale(1.5,1.5);
	}	
	.caption{
	margin:0px 10px 10px 10px;
	}
	.wishclick{
		color:red;
	}
	

	.more{
		font-size:15px;
		margin:10px;
		margin-left:50px;
		}


      h3{
      	/* margin:10px; */
      }
      h5{
      padding : 10px;
      float:left;
      }
      h4#price{
      float:right;
      
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
                                <a href="<%=request.getContextPath()%>/product/selectSearchProductList?searchWord=서귀포시" class="boxed-btn3">상품 보기</a>
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
                                <a href="<%=request.getContextPath()%>/product/selectSearchProductList?searchWord=동제주시" class="boxed-btn3">상품 보기</a>
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
                                <a href="<%=request.getContextPath()%>/product/selectSearchProductList?searchWord=서제주시" class="boxed-btn3">상품 보기</a>
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
                                <a href="<%=request.getContextPath()%>/product/selectSearchProductList?searchWord=제주시" class="boxed-btn3">상품 보기</a>
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
 
    <%-- <div class="container">
	  	<div class="row">
		    <form id="catefrm" action="<%=request.getContextPath()%>/filterProductList">
			    <div id="areadiv" class="dropdown">
			        
			        <button id="areabtn" data-toggle="dropdown" class="dropdown-toggle genric-btn info radius">지역별</button>
			            <ul class="dropdown-menu">
			                <li><label><input type="checkbox" name="place" id="place0" value="동제주시" checked> 동제주시</label> </li>
			                <li><label><input type="checkbox" name="place" id="place1" value="서제주시" checked> 서제주시</label> </li>
			                <li><label><input type="checkbox" name="place" id="place2" value="서귀포시" checked> 서귀포시</label> </li>
			                <li><label><input type="checkbox" name="place" id="place3" value="제주시" checked> 제주시</label> </li>
			            </ul>
			        
			    </div>
		    	<div id="datediv" class="col-xl-2">
		        
		        	<input id="datepicker" name="startdate" autocomplete="off" placeholder="날짜" class="genric-btn info radius">
		    
		    	</div>
		  
		     <div id="tastediv" class="dropdown btn-group col-xl-2">
		        
		            <button id="tastebtn" class="btn-block dropdown-toggle genric-btn info radius" data-toggle="dropdown"> 취향별</button>
		            <ul class="dropdown-menu" role="menu">
		                
		                <li><label><input type="checkbox" name="favor" id="favor0" value="산" checked> 산</label></li>
		                <li><label><input type="checkbox" name="favor" id="favor1" value="바다" checked> 바다</label></li>
		                <li><label><input type="checkbox" name="favor" id="favor2" value="레저" checked> 레저</label></li>
		                <li><label><input type="checkbox" name="favor" id="favor3" value="휴양" checked> 휴양</label></li>
		                <li><label><input type="checkbox" name="favor" id="favor4" value="캠핑" checked> 캠핑</label></li>
		            </ul>
		    </div>
		     
		    <div class="search_btn col-xl-2">
		        <button id="searchbtn" class="btn-block genric-btn default radius" type="submit" >Search</button>
		     </div>
		     </form>
		    <hr>
    </div>
</div>
 --%>
 	<br>
 	<h3>최근 등록된 상품<a href="<%=request.getContextPath()%>/product/allProductList" class="more">더보기</a></h3>
	
 	  <%-- <div class="row">
		<%for(Product p:list){ %>
		  <div class="col-sm-6 col-lg-4">
		    <div class="thumbnail img-div" >
		    
		    	
		      <a href=""><img src="<%=request.getContextPath() %>/upload/product/<%=p.getTitleImgPath() %>"  alt="..." width="400px" height="200px" class="img-rounded"></a>
		      <a href="" onclick="clickheart();"><img src="<%=request.getContextPath()%>/img/product/transheart.png" class="wish"></a>
		      <span class="heartspan"><i class="fas fa-heart wish" onclick="javascript:clickheart();"></i></span>
		      <div class="caption" >
		        <h3><%=p.getpName() %></h3>
		        <p><%=p.getpNum() %></p>
		        <input type="hidden" name=pNum value=<%=p.getpNum() %> >
		      </div>
		    </div>
		  </div>
		
	
	<%} %>
			</div>
 --%>			
			
	<div id="productList">
	
	
	</div>
			
	<a href="<%=request.getContextPath()%>/product/pagingTest"><button>테스트</button></a>

</section>



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
	
        $(document).ready(function() {
          
           $.ajax({
        	   url:"<%=request.getContextPath()%>/indexProductList",
  				dataType:"html",
  				success:data => {
				console.log(data);
				$("#productList").html(data);
				},
	  			error:function(re,s,e){
	  				console.log(s);
	  				console.log(e);
	  			}
        	   
           });
       });
       
       $(function() {
           //input을 datepicker로 선언
           $("#datepicker").datepicker({
               dateFormat: 'yyyy-mm-dd' //Input Display Format 변경
               ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
               ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
               ,changeYear: true //콤보박스에서 년 선택 가능
               ,changeMonth: true //콤보박스에서 월 선택 가능                
               ,showOn: "button" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
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