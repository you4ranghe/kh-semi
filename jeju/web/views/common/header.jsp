<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>기준점</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/header.css" type="text/css">
        
    <!-- 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
    <!-- jQuery -->
	<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
    <!-- fontawesome에서 아이콘쓸때 -->
    <script src="https://kit.fontawesome.com/27fabf8f47.js"
      crossorigin="anonymous"></script>

</head>  
<body>
    <div id="page-container"> 
            <div id="content-wrap">
        <nav class="navbar">

            <div class="navbar_logo">
                <a href="mainhome.html">
                <i class="fas fa-globe-americas"></i>Jeju</a>
            </div>
    
            <ul class="navbar_menu">
                <li><a href="">PRODUCT</a>
                    <ul class="navbar_sub">
                        <li><a href="">상품1</a></li>
                        <li><a href="">상품2</a></li>
                    </ul>
                </li>
                <li><a href="">COMMUNITY</a>
                <ul class="navbar_sub">
                    <li><a href="">동행구하기</a></li>
                    <li><a href="">Q&A</a></li>
                </ul>
            </li>
                <li><a href="">ABOUT</a>
                <ul class="navbar_sub">
                    <li><a href="">ABOUT US</a></li>
                    <li><a href="">ABOUT JEJU</a></li>
                </ul>
            </li>
                <li><a href="">REVIEW</a>
                <ul class="navbar_sub">
                    <li><a href="">투어리뷰</a></li>
                    <li><a href="">가이드리뷰</a></li>
                </ul>
            </li>
            </ul>

            <div class="dropdown">
                <button class="dropbtn"></button>
                <div class="dropdown-content">
                    <a href="joinmember.html">회원가입</a>
                    <a href="">가이드 되기</a>
                    <a href="">장바구니</a>
                    <a href="">로그인</a>
                </div>
              </div> 
        </nav>