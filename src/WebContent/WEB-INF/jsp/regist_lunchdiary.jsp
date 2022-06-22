<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="js/diary_form.js"></script>
<link href="css/diary_form.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="header.jsp" />

<h2>ランチ日記新規登録</h2>

<!-- <div id="radioBtn">
	<label><input type="radio" name="lunch" value="lunch_regist" checked="checked">外食</label>
	<label><input type="radio" name="lunch" value="handmade_regist">手作り</label>
</div>
 -->
<!-------------------- ランチ日記登録フォーム -------------------------->
<form method="POST" action="/lunchBox/RegistLunchServlet"enctype="multipart/form-data">
<div id="displayBox">
	<div class="cm_box active">
		<div class = "dt">お店の名前<span class =required>※必須</span></div>
			<input type="text" name="resName"><br>
		<div class = "dt">写真</div>
			<input type="file" name="foodPhoto" accept="image/*" onchange="previewImage(this);">
			<canvas id="preview" style="max-width:200px;"></canvas><br>
		<div class = "dt">ジャンル</div>
			<select name=category>
			<option value="">選択してください</option>
				<option value="和食">和食</option>
				<option value="中華">中華</option>
				<option value="洋食">洋食</option>
				<option value="イタリアン">イタリアン</option>
				<option value="パン">パン</option>
				<option value="ラーメン">ラーメン</option>
				<option value="その他">その他</option>
			</select><br>
		<div class = "dt">店内利用</div>
			<select name="style">
				<option value="">選択してください</option>
				<option value="イートイン">イートイン</option>
				<option value="テイクアウト">テイクアウト</option>
			</select><br>
		<div class = "dt">日付<span class ="required">※必須</span></div>
			<input type="date" name="date"><br>
		<div class = "dt">料理名</div>
			<input type="text" name="foodName" value="" placeholder="例：オムライス"><br>
		<div class = "dt">費用</div>
			<select name="cost">
				<option value="">選択してください</option>
				<option value="～５００円">～５００円</option>
				<option value="～８００円">～８００円</option>
				<option value="～１０００円">～１０００円</option>
				<option value="～１２００円">～１２００円</option>
				<option value="～１５００円">～１５００円</option>
				<option value="１５００円～">１５００円～</option>
			</select><br>
		<div class = "dt">提供時間</div>
			<select name="time">
				<option value="">選択してください</option>
				<option value="５分未満">５分未満</option>
				<option value="５～１０分">５～１０分</option>
				<option value="１０分～１５分">１０分～１５分</option>
				<option value="１５分以上">１５分以上</option>
			</select><br>
		<div class = "dt">会社からの所要時間</div>
			<select name="distance">
				<option value="">選択してください</option>
				<option value="３分未満">３分未満</option>
				<option value="３～５分">３～５分</option>
				<option value="５～７分">５～７分</option>
				<option value="７～１０分">７～１０分</option>
				<option value="１０分以上">１０分以上</option>
			</select><br>
		<div class = "dt">評価</div>
			<input id="star5" type="radio" name="star" value="5" />
    		<label for="star5">★</label>
   			<input id="star4" type="radio" name="star" value="4" />
   			<label for="star4">★</label>
   		 	<input id="star3" type="radio" name="star" value="3" />
    		<label for="star3">★</label>
    		<input id="star2" type="radio" name="star" value="2" />
    		<label for="star2">★</label>
    		<input id="star1" type="radio" name="star" value="1" />
    		<label for="star1">★</label><br>
		<div class = "dt">感想</div>
			<textarea name="feeling"  placeholder="ここに記入してください"></textarea><br>
		<!-- 登録ボタン -->
		<input type="submit" name="registNewAccount" value="登録する" class = "submitBtn"><br>
	</div>
</div>
</form>

<!------------------------ 手作り日記登録 ---------------------->
<form method="POST" action="/lunchBox/RegistHandmadeServlet"enctype="multipart/form-data">
	<div class="cm_box">
		<p>料理名<br>
			<input type="text" name="foodName" value="" placeholder="例：オムライス"><br></p>

		<p>写真<br>
			<input type="file" name="foodPhoto" accept="image/*" onchange="previewImage(this);"></p>
			<canvas id="preview" style="max-width:200px;"></canvas><br>
		<p>所要時間<br>
			<select name="cookTime">
				<option value="">選択してください</option>
				<option value="５分未満">５分未満</option>
				<option value="５～１０分">５～１０分</option>
				<option value="１０～１５分">１０～１５分</option>
				<option value="１５分以上">１５分以上</option>
			</select>
		</p>

		<p>日付※必須<br>
			<input type="date" name="date"></p>


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
			<input id="star5" type="radio" name="star" value="5" />
    		<label for="star5">★</label>
   			<input id="star4" type="radio" name="star" value="4" />
   			<label for="star4">★</label>
   		 	<input id="star3" type="radio" name="star" value="3" />
    		<label for="star3">★</label>
    		<input id="star2" type="radio" name="star" value="2" />
    		<label for="star2">★</label>
    		<input id="star1" type="radio" name="star" value="1" />
    		<label for="star1">★</label>
		</p>


		<p>感想（自由記入）<br>
			<textarea name="feeling" placeholder="ここに記入してください"></textarea>
		</p>

		<input type="submit" name="registNewAccount" value="登録する" class = "submitBtn"><br>
</div>
</form>
</body>
</html>