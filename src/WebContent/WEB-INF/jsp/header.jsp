<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LunchBox</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<link href="css/header.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- ヘッダーロゴ -->
	<div class = topmenu>
	<header>
		<h1 class = "headerLogo"><a href = "/lunchBox/TimelineServlet"><img src = "/lunchBox/img/headerLogo.png" alt="LunchBox"></a></h1>
	</header>
	</div>

	<div id="nav-wrapper" class="nav-wrapper">
	  <div class="hamburger" id="js-hamburger">
	    <span class="hamburger__line hamburger__line--1"></span>
	    <span class="hamburger__line hamburger__line--2"></span>
	    <span class="hamburger__line hamburger__line--3"></span>
	  </div>
	  <nav class="sp-nav">
	  	<div class = "greeting"><b>ようこそ、<span class = "name">${user.accountName}</span>さん</b></div>
	    <ul>
	      <li><a href="/lunchBox/TimelineServlet">タイムライン</a></li>
	      <li><a href= "/lunchBox/MyPageServlet">マイページ</a></li>
	      <li id="regist">登録</li>
	      <div class = "hidden" id = "hidden">
		      <li><a href= "/lunchBox/RegistLunchServlet">ランチ日記登録</a></li>
		      <li><a href = "/lunchBox/RegistHandmadeServlet">手作り日記登録</a></li>
		      <li><a href = "/lunchBox/RegistListServlet">行きたい場所リスト登録</a></li>
	      </div>
	      <li><a href ="/lunchBox/SettingsServlet">設定</a></li>
	      <li><a href ="/lunchBox/LogoutServlet">ログアウト</a></li>
	    </ul>
	  </nav>
	  <div class="black-bg" id="js-black-bg"></div>
	 </div>


</body>
</html>