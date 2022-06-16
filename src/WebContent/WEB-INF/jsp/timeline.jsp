<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LunchBox|タイムライン</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="js/timeline.js"></script>
<link href="css/timeline.css" rel="stylesheet" type="text/css" />
</head>

<header>
<jsp:include page="header.jsp" />
</header>

<body>

<div class="searchBox">
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<form method="POST" action="/lunchBox/SearchServlet" target="_new">
<div id="radioBtn">
	<label><input name="lunch" type="radio" value="lunch_diary" checked="checked" />ランチ日記</label>
	<label><input name="lunch" type="radio" value="handmade_diary" />手作り日記</label>
</div>

<div id="displayBox">
	<div class="cm_box active">

			<select name="distance">
				<option value="">会社からの所要時間</option>
				<option value="3分未満">3分未満</option>
				<option value="3～5分">3～5分</option>
				<option value="5～7分">5～7分</option>
				<option value="7～10分">7～10分</option>
				<option value="10分以上">10分以上</option>
			</select>
			<select name="time">
				<option value="">提供時間</option>
				<option value="5分未満">5分未満</option>
				<option value="5～10分">5～10分</option>
				<option value="10～15分">10～15分</option>
				<option value="15分以上">15分以上</option>
			</select>
			<select name="category">
				<option value="">ジャンル</option>
				<option value="和食">和食</option>
				<option value="中華">中華</option>
				<option value="洋食">洋食</option>
				<option value="イタリアン">イタリアン</option>
				<option value="パン">パン</option>
				<option value="ラーメン">ラーメン</option>
				<option value="その他">その他</option>
			</select>
			<select name="cost">
				<option value="">費用</option>
				<option value="100円未満">100円未満</option>
				<option value="100～300円">100～300円</option>
				<option value="300円～500円">300円～500円</option>
				<option value="500～700円">500～700円</option>
				<option value="700円～1000円">700円～1000円</option>
				<option value="1000円以上">1000円以上</option>
			</select>
			<input type="text" name="resName" placeholder="店名">
			<input type="submit" name="searchSubmit" value="検索">
	</div>
	<div class="cm_box">
			<select name="time">
				<option value="">所要時間</option>
				<option value="3分未満">3分未満</option>
				<option value="3～5分">3～5分</option>
				<option value="5～7分">5～7分</option>
				<option value="7～10分">7～10分</option>
				<option value="10分以上">10分以上</option>
			</select>
			<input type="text" name="foodName" placeholder="料理名">
			<input type="submit" name="searchSubmit" value="検索">

	</div>
</div>
</form>
</div>
<div class="diaryInfo">
テスト
	<c:forEach var="e" items="${diary}" >
	</c:forEach>
</div>
 <!--
<div class="hidden_box">
	<label for="label1"></label>
	<input type="checkbox" id="label1"/>
<div class="hidden_show">
<form method="POST" action="/lunchBox/SearchServlet">
	<select name="example">
		<option value="">会社からの所要時間</option>
		<option value="選択肢2">選択肢2</option>
		<option value="選択肢3">選択肢3</option>
	</select>
	<select name="example2">
		<option value="">提供時間</option>
		<option value="選択肢2">選択肢2</option>
		<option value="選択肢3">選択肢3</option>
	</select>
	<select name="example3">
		<option value="">ジャンル</option>
		<option value="選択肢2">選択肢2</option>
		<option value="選択肢3">選択肢3</option>
	</select>
	<select name="example4">
		<option value="">費用</option>
		<option value="選択肢2">選択肢2</option>
		<option value="選択肢3">選択肢3</option>
	</select>
	<input type="text" name="" placeholder="店名">
	<input type="submit" name="searchSubmit" value="検索">
</form>
</div>
</div>
 -->
</body>
</html>