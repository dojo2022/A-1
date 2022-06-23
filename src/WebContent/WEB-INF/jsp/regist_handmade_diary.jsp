<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>手作り日記新規登録</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="js/diary_form.js"></script>
<link href="css/diary_form.css" rel="stylesheet" type="text/css" />
</head>
<!------------ 画面に表示される部分 -------------------->
<body>
<main>
<jsp:include page="header.jsp" />

<h2>手作り日記新規登録</h2>

<!------------------------ 手作り日記登録 ---------------------->
<table>
<form method="POST" action="/lunchBox/RegistHandmadeServlet"enctype="multipart/form-data" name = "registHdForm" id = "registHdForm">
	<tr>
		<th>料理名　<span class =required>必須</span></th>
			<td><input type="text" name="foodName" value="" placeholder="例：オムライス"><div id = "required3"></div></td>
	</tr>
	<tr>
		<th>写真</th>
			<td><input type="file" name="foodPhoto" accept="image/*" onchange="previewImage(this);"></td>
	<tr>
		<th>プレビュー<br><span class = "smallMessage">自動表示されます</span></th>
			<td><canvas id="preview" style="max-width:200px;"></canvas></td>
	</tr>
	<tr>
		<th>所要時間</th>
			<td><select name="cookTime">
				<option value="">選択してください</option>
				<option value="５分未満">５分未満</option>
				<option value="５～１０分">５～１０分</option>
				<option value="１０～１５分">１０～１５分</option>
				<option value="１５分以上">１５分以上</option>
			</select></td>
	</tr>
	<tr>
		<th>日付　<span class =required>必須</span></th>
			<td><input type="date" name="date" value = "${param.date}"><div id = "required4"></div></td>
	</tr>
	<tr>
		<th>費用</th>
			<td><select name="cost">
				<option value="">選択してください</option>
				<option value="１００円未満">１００円未満</option>
				<option value="１００～３００円">１００～３００円</option>
				<option value="３００～５００円">３００～５００円</option>
				<option value="５００～７００円">５００～７００円</option>
				<option value="７００～１０００円">７００～１０００円</option>
				<option value="１０００円～">１０００円～</option>
			</select></td>
	</tr>
	<tr>
		<th>評価</th>
			<td>
			<div class = "rate-form">
			<input id="star5" type="radio" name="star" value="5" />
    		<label for="star5">★</label>
   			<input id="star4" type="radio" name="star" value="4" />
   			<label for="star4">★</label>
   		 	<input id="star3" type="radio" name="star" value="3" />
    		<label for="star3">★</label>
    		<input id="star2" type="radio" name="star" value="2" />
    		<label for="star2">★</label>
    		<input id="star1" type="radio" name="star" value="1" />
    		<label for="star1">★</label></div>
    		</td>
	</tr>
	<tr>
		<th>感想（自由記入）</th>
			<td><textarea name="feeling" placeholder="ここに記入してください" value = "${param.feeling}"></textarea></td>
	</tr>
</form>
</table>
		<!-- 登録ボタン -->
		<input type="submit" name="registNewAccount" value="登録する" class = "submitBtn" form = registHdForm onclick = "return hdCheck()"><br>

</main>
</body>
</html>