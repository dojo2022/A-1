<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/diary_form.js"></script>
<link href="css/diary_form.css" rel="stylesheet" type="text/css" />
</head>
<body>

<form>

<p>登録内容</p>
<input type="radio" id="disp" name="contentsRadio" onclick="buttonClick()">外食
<input type="radio" id="hide" name="contentsRadio" onclick="buttonClick()">手作り

<div id="gaisyoku">
	<form method="POST" action="/lunchBox/RegistLunchServlet"enctype="multipart/form-data">
		<p>お店の名前※必須<br>
		<input type="text" name="resName"></p>

		<p>写真<br>
		<input type="file" name="foodPhoto" accept="image/*" onchange="previewImage(this);"></p>

		<p>ジャンル<br>
			<select name=category>
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
			<input type="date" name="date">

		<p>料理名<br>
			<input type="text" name="foodName" value="" placeholder="例：オムライス"><br></p>

		<p>費用<br>
			<select name="cost">
				<option value="">選択してください</option>
				<option value="～５００円">～５００円</option>
				<option value="～８００円">～８００円</option>
				<option value="～１０００円">～１０００円</option>
				<option value="～１２００円">～１２００円</option>
				<option value="～１５００円">～１５００円</option>
				<option value="１５００円～">１５００円～</option>
			</select></p>

		<p>提供時間<br>
			<select name="time">
				<option value="">選択してください</option>
				<option value="５分未満">５分未満</option>
				<option value="５～１０分">５～１０分</option>
				<option value="１０分～１５分">１０分～１５分</option>
				<option value="１５分以上">１５分以上</option>
			</select>
		</p>

		<p>会社からの所要時間<br>
			<select name="distance">
				<option value="">選択してください</option>
				<option value="３分未満">３分未満</option>
				<option value="３～５分">３～５分</option>
				<option value="５～７分">５～７分</option>
				<option value="７～１０分">７～１０分</option>
				<option value="１０分以上">１０分以上</option>
			</select>
		</p>

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

		<p>感想<br>
			<textarea name="feeling" value="" placeholder="ここに記入してください"></textarea>
		</p>

		<input type="submit" name="updateButton" value="更新する"><br>
		<input type="submit" name="deleteButton" value="削除する"><br>
	</form>
</div>


<div id="cook">
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
</div>
</form>

</body>
</html>