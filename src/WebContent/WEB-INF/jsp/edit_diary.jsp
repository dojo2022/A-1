<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ランチ日記更新削除</title>
<script type="text/javascript" src="js/diary_form.js"></script>
<link href="css/diary_form.css" rel="stylesheet" type="text/css" />
</head>
<body>

<form>

<p>登録内容</p>
<!-- <input type="radio" id="disp" name="contentsRadio" onclick="buttonClick()">外食
<input type="radio" id="hide" name="contentsRadio" onclick="buttonClick()">手作り -->


	<form method="POST" action="RegistLunchServlet"enctype="multipart/form-data">
		<p>お店の名前※必須<br>
		<input type="text" name="resName"  value="${ldResName}"></p>

		<p>写真<br>
		<input type="file" name="foodPhoto" accept="image/*" value="${foodPhoto}" onchange="previewImage(this);"></p>

		<p>ジャンル<br>
			<select name=category >
				<option value="">選択してください</option>
				<option value="japan">和食</option>
				<option value="china">中華</option>
				<option value="western">洋食</option>
				<option value="italy">イタリアン</option>
				<option value="bread">パン</option>
				<option value="ra-men">ラーメン</option>
				<option value="other">その他</option>
			</select></p>

		<p>店内利用<br>
			<select name="style">
				<option value="">選択してください</option>
				<option value="イートイン">イートイン</option>
				<option value="テイクアウト">テイクアウト</option>
			</select></p>

		<p>日付※必須</p>
			<input type="date" name="date" value="${LunchDiaryBeans.date}" >

		<p>料理名<br>
			<input type="text" name="foodName" value="${LunchDiaryBeans.foodName}" placeholder="例：オムライス"><br></p>

		<p>費用<br>
			<select name="ldCost" >
				<option value="">選択してください</option>
				<option value="～５００円"><c:if test=${test=="～５００円"}selected></c:if>～５００円</option>
				<option value="～８００円"><c:if test=${test=="～８００円"}selected></c:if> ～８００円</option>
				<option value="～１０００円"><c:if test=${test=="～１０００円"}selected></c:if> ～１０００円</option>
				<option value="～１２００円"><c:if test=${test=="～１２００円"}selected></c:if> ～１２００円</option>
				<option value="～１５００円"><c:if test=${test=="～１５００円"}selected></c:if> ～１５００円</option>
				<option value="１５００～円"><c:if test=${test=="１５００～円"}selected></c:if>１５００円～</option>
			</select></p>

		<p>提供時間<br>
			<select name="time">
				<option value="">選択してください</option>
				<option value="５分未満"><c:if test=${test=="５分未満"}selected></c:if>５分未満</option>
				<option value="５～１０分"><c:if test=${test=="５～１０分"}selected></c:if>５～１０分</option>
				<option value="１０分～１５分"><c:if test=${test=="１０分～１５分"}selected></c:if>１０～１５分</option>
				<option value="１５分以上"><c:if test=${test=="１５分以上"}selected></c:if>１５分以上</option>
			</select>
		</p>

		<p>会社からの所要時間<br>
			<select name="distance">
				<option value="">選択してください</option>
				<option value="３分未満"><c:if test=${test=="３分未満"}selected></c:if>～５００円</option>
				<option value="３～５分"><c:if test=${test=="３～５分"}selected></c:if>３～５分</option>
				<option value="５～７分">><c:if test=${test=="５～７分"}selected></c:if>５～７分</option>
				<option value="７～１０分">><c:if test=${test=="７～１０分"}selected></c:if>７～１０分</option>
				<option value="１０分以上">><c:if test=${test=="１０分以上"}selected></c:if>１０分以上</option>
			</select>
		</p>

		<p>評価<br>
			<div class="rate-form">
				  <input id="star1" type="radio" name="star" value="1"><c:if test=${star =="1"}checked></c:if>
				  <label for="star1">★</label>
				  <input id="star2" type="radio" name="star" value="2"><c:if test=${star =="2"}checked></c:if>
				  <label for="star2">★</label>
				  <input id="star3" type="radio" name="star" value="3"><c:if test=${star =="3"}checked></c:if>
				  <label for="star3">★</label>
				  <input id="star4" type="radio" name="star" value="4"><c:if test=${star =="4"}checked></c:if>
				  <label for="star4">★</label>
				  <input id="star5" type="radio" name="star" value="5"><c:if test=${star =="5"}checked></c:if>
				  <label for="star5">★</label>
			</div>
		</p>







		<p>感想<br>
			<textarea name="feeling"  placeholder="ここに記入してください"></textarea>
		</p>



		<input type="submit" name="updateButton" value="更新する"><br>
		<input type="submit" name="deleteButton" value="削除する"><br>
	</form>
	</var>



<!-- <div id="cook">
	<form method="POST" action="/lunchBox/RegistHandmadeServlet"enctype="multipart/form-data">

		<p>料理名<br>
			<input type="text" name="foodName" value="" placeholder="例：オムライス"><br></p>

		<p>写真<br>
			<input type="file" name="foodPhoto" accept="image/*" onchange="previewImage(this);"></p>

		<p>所要時間<br>
			<select name="cookTime">
				<option value="">選択してください</option>
				<option value="５分未満">５分未満</option>
				<option value="５～１０分">５～１０分</option>
				<option value="１０～１５分">１０～１５分</option>
				<option value="１５分以上">１５分以上</option>
			</select>
		</p>

		<p>日付※必須</p>
			<input type="date" name="date">


		<p>費用<br>
			<select name="cost">
				<option value="">選択してください</option>
				<option value="１００円未満">１００円未満</option>
				<option value="１００～３００円">１００～３００円</option>
				<option value="３００～５００円">３００～５００円</option>
				<option value="５００～７００円">５００～７００円</option>
				<option value="７００～１０００円">７００～１０００円</option>
				<option value="１０００円～">１０００円～</option>
			</select></p>


		<p>評価<br>
			<div class="rate-form">
				  <input id="star1" type="radio" name="star" value="1">
				  <label for="star1">★</label>
				  <input id="star2" type="radio" name="star" value="2">
				  <label for="star2">★</label>
				  <input id="star3" type="radio" name="star" value="3">
				  <label for="star3">★</label>
				  <input id="star4" type="radio" name="star" value="4">
				  <label for="star4">★</label>
				  <input id="star5" type="radio" name="star" value="5">
				  <label for="star5">★</label>
			</div>
		</p>


		<p>感想（自由記入）<br>
			<textarea name="feeling" value="" placeholder="ここに記入してください"></textarea>
		</p>

		<input type="submit" name="updateButton" value="更新する"><br>
		<input type="submit" name="deleteButton" value="削除する"><br>
	</form>
</div>-->
</form>

</body>
</html>