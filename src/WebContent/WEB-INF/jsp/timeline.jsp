<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LunchBox|タイムライン</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="js/timeline.js"></script>
<link href="css/timeline.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="header.jsp" />


<header>



<div class="searchBox">
<div id="radioBtn">
	<label><input name="lunch" type="radio" value="lunch_diary" checked="checked" />ランチ日記</label>
	<label><input name="lunch" type="radio" value="handmade_diary" />手作り日記</label>
</div>

<div id="displayBox">
	<div class="cm_box active">
<form method="POST" action="/lunchBox/SearchServlet" target="_new">
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
				<option value="100～300円">100円～300円</option>
				<option value="300円～500円">300円～500円</option>
				<option value="500～700円">500円～700円</option>
				<option value="700円～1000円">700円～1000円</option>
				<option value="1000円以上">1000円以上</option>
			</select>
			<input type="text" name="resName" placeholder="店名">
			<input type="submit" name="searchSubmit" value="検索">
</form>
	</div>
	<div class="cm_box">
<form method="POST" action="/lunchBox/SearchServlet" target="_new">
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
</form>
	</div>
</div>
</div>
<!--タブ-->
<ul class="tab-group">
  <li class="tab is-active">ランチ日記</li>
  <li class="tab">手作り記録</li>
</ul>
</header>

<main>
${comment_result}
<!--タブを切り替えて表示するコンテンツ-->
<div class="panel-group">
  <div class="panel is-show">

<c:forEach var="e" items="${allLunch}" >
<form method="POST" action="TimelineServlet">
	${e.accountName}<br>
	${e.ldFoodType}<br>
	${e.ldResName}<br>
	${e.ldFoodPhoto}<br>
	${e.ldCategory}<br>
	${e.style}<br>
	${e.ldDate}<br>
	${e.ldFoodName}<br>
	${e.ldCost}<br>
	${e.time}<br>
	${e.distance}<br>
	${e.ldStar}<br>
	${e.ldFeeling}<br>
	<input type="hidden" name="lunch_id" value="${e.lunchId}">
	<c:forEach var="lc" items="${LdComment}">
	<c:if test="${lc.lunchId == e.lunchId}">
		${lc.accountName}：
		${lc.ldComment}<br>
	</c:if>
	</c:forEach>
		<input type="text" name="ld_comment" placeholder="コメントを入力してください">
		<input type="submit" name="send_comment" value="ランチ日記コメントを送信する"><br>
	<c:forEach var="lr" items="${ldReactionList}">
	<c:if test="${lr.lunchId == e.lunchId}">
		${lr.countLdToGo}|
		${lr.countLdToTell}|
		${lr.countLdToUse}|
	</c:if>
	</c:forEach>
		<input type="submit" name="to" value="行きたい">
		<input type="submit" name="to" value="教えて">
		<input type="submit" name="to" value="参考にします"><br>
</form>
</c:forEach>
	</div>
  <div class="panel">
<c:forEach var="e" items="${myHandmade}" >
<form method="POST" action="TimelineServlet">
		${e.handmadeId}<br>
		${e.accountName}<br>
		${e.emailAddress}<br>
		${e.hdFoodType}<br>
		${e.hdFoodPhoto}<br>
		${e.hdCategory}<br>
		${e.hdDate}<br>
		${e.hdFoodName}<br>
		${e.hdCost}<br>
		${e.hdStar}<br>
		${e.hdFeeling}<br>
		${e.cooktime}<br>
		${e.ldRegistTime}<br>
	<input type="hidden" name="handmade_id" value="${e.handmadeId}">
	<c:forEach var="hc" items="${HdComment}">
	<c:if test="${hc.handmadeId == e.handmadeId}">
		${hc.accountName}：
		${hc.hdComment}<br>
	</c:if>
	</c:forEach>
	<input type="text" name="hd_comment" placeholder="コメントを入力してください">
	<input type="submit" name="send_comment" value="手作り記録コメントを送信する"><br>
	<c:forEach var="hr" items="${hdReactionList}">
	<c:if test="${hr.handmadeId == e.handmadeId}">
		${hr.countHdToEat}|
		${hr.countHdToTell}|
		${hr.countHdToUse}|
	</c:if>
	</c:forEach>
		<input type="submit" name="hdbtn" value="食べたい">
		<input type="submit" name="hdbtn" value="教えて">
		<input type="submit" name="hdbtn" value="参考にします"><br>
	</form>
</c:forEach>
	</div>
</div>





</main>

<script>
jQuery(function($){
  $('.tab').click(function(){
    $('.is-active').removeClass('is-active');
    $(this).addClass('is-active');
    $('.is-show').removeClass('is-show');
    // クリックしたタブからインデックス番号を取得
    const index = $(this).index();
    // クリックしたタブと同じインデックス番号をもつコンテンツを表
    $('.panel').eq(index).addClass('is-show');
  });
});
/*
<a href="#" id="link">
$(function() {

	// テキストフォームを監視して入力があるたびに実行
	$('#link').change(function() {

		// テキストを取得
		var param = $(this).val();

		// リンクを書き換え
		$('#link').attr('href', 'http://maps.google.co.jp/maps?q=' + param);

	});

});
 */
</script>
</body>
</html>