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

<body>

<div class="searchBox">
<div id="radioBtn">
	<label><input name="sample" type="radio" value="01" checked="checked" />ランチ日記</label>
	<label><input name="sample" type="radio" value="02" />手作り日記</label>
</div>

<div id="displayBox">
	<div class="cm_box active">
		<form method="POST" action="/lunchBox/SearchServlet">
			<select name="distance">
				<option value="">会社からの所要時間</option>
				<option value="選択肢1">3分未満</option>
				<option value="選択肢2">3～5分</option>
				<option value="選択肢3">5～7分</option>
				<option value="選択肢4">7～10分</option>
				<option value="選択肢5">10分以上</option>
			</select>
			<select name="time">
				<option value="">提供時間</option>
				<option value="選択肢1">5分未満</option>
				<option value="選択肢2">5～10分</option>
				<option value="選択肢3">10～15分</option>
				<option value="選択肢5">15分以上</option>
			</select>
			<select name="category">
				<option value="">ジャンル</option>
				<option value="選択肢1">和食</option>
				<option value="選択肢2">中華</option>
				<option value="選択肢3">洋食</option>
				<option value="選択肢4">イタリアン</option>
				<option value="選択肢5">パン</option>
				<option value="選択肢6">ラーメン</option>
				<option value="選択肢7">その他</option>
			</select>
			<select name="cost">
				<option value="">費用</option>
				<option value="選択肢1">100円未満</option>
				<option value="選択肢2">100～300円</option>
				<option value="選択肢3">300円～500円</option>
				<option value="選択肢4">500～700円</option>
				<option value="選択肢5">700円～1000円</option>
				<option value="選択肢6">1000円以上</option>
			</select>
			<input type="text" name="resName" placeholder="店名">
			<input type="submit" name="searchSubmit" value="検索">
		</form>
	</div>

	<div class="cm_box">
		<form method="POST" action="/lunchBox/SearchServlet">
			<select name="time">
				<option value="">所要時間</option>
				<option value="選択肢1">3分未満</option>
				<option value="選択肢2">3～5分</option>
				<option value="選択肢3">5～7分</option>
				<option value="選択肢4">7～10分</option>
				<option value="選択肢5">10分以上</option>
			</select>
			<input type="text" name="foodName" placeholder="料理名">
			<input type="submit" name="searchSubmit" value="検索">
		</form>
	</div>
</div>
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