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
<!------------ 画面に表示される部分 -------------------->
<body>
<jsp:include page="header.jsp" />

<h2>手作り日記新規登録</h2>

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