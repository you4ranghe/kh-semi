<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/views/common/header.jsp" %>
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/deletePartner.css" type="text/css">
<%
	Partner p =(Partner)request.getAttribute("partner");
%>

<div class="deletePartner_img">

<section id="mypage-bar">
<h1 id="h1title">PartnerPage</h1>
<br>
<h5 class="h5title"><a href="<%=request.getContextPath()%>/partner/partnerView?partnerId=<%=p.getPartnerId()%>">&nbsp;파트너 정보수정</a></h5>
<h5 class="h5title"><a href="<%=request.getContextPath()%>/partner/deletePartner?partnerId=<%=p.getPartnerId()%>">&nbsp;파트너 탈퇴</a></h5>
<h5 class="h5title"><a href="<%=request.getContextPath()%>/member/logout">&nbsp;로그아웃</a></h5>
</section>
    <section id="member-viewForm">
        <form id="MypageFrm" action="<%=request.getContextPath() %>/partner/deletePartnerEnd?partnerId=<%=p.getPartnerId() %>" method="post">     
            <table>
                <!--            <tr>
                    <th>비밀번호 확인</th>
                    <td class="int-area">
                        <input type="password" name="password" id="password_" required autocomplete="off">
                        <label for="password_">4~18개의 영대소문자, 숫자조합</label>
                    </td>
                </tr> -->
                <h3 id="h3title"><%=p.getPartnerNick()%>님, 파트너를 탈퇴하시겠습니까?</h3>
                
                 <tr>
                    <td class="btn-area">
                        <button id="btn2" type="submit"  onclick="delete_partner();">탈퇴하기</button>
                    </td>
                    <td>
                        <button id="btn3" type="button" onclick="location.assign('<%=request.getContextPath()%>');">취소</button>
                    </td>
                </tr> 
            </table>
        </form>
    </section>
</div>
    
    <script>
    function delete_partner(){
    	confirm("파트너를 탈퇴하시겠습니까?");
    }
    
    
/* 	function delete_member(){
		if(confirm("정말로 탈퇴하시겠습니까?")){                                       
			
		//비밀번호 유효성 검사
        let regPw=/^.*(?=^.{4,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
	        if(!regPw.test($("#password_").val())){
	            alert("비밀번호는 4~15자리 이내 숫자,문자,특수기호 포함되어야 합니다");
	            $("#password_").val("");
	            $("#password_").focus();
	            return false;
			}
		}
    } */
    
    </script>

	
	
<%@ include file="/views/common/footer.jsp" %>