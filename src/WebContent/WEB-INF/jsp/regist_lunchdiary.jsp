<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ランチ日記新規登録|LunchBox</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link href="css/diary_form.css" rel="stylesheet" type="text/css" />
</head>
<body>
<jsp:include page="header.jsp" />
<main>
<h2>ランチ日記新規登録</h2>

<!-------------------- ランチ日記登録フォーム -------------------------->
<table>
<form method="POST" action="/lunchBox/RegistLunchServlet" enctype="multipart/form-data" name = registLdForm id = registLdForm>
	<tr>
		<th>お店の名前　<span class =required>必須</span></th>
			<td><input type="text" name="resName" value = ${param.resName}><div id ="required1"></div></td>
	</tr>
	<tr>
		<th>写真</th>
			<td><input type="file" name="foodPhoto" accept="image/*" onchange="previewImage(this);"></td>
	</tr>
	<tr>
		<th>プレビュー<br><span class = "smallMessage">自動表示されます</span></th>
			<td><canvas id="preview" style="max-width:200px;"></canvas></td>
	</tr>
	<tr>
		<th>ジャンル</th>
			<td><select name=category>
			<option value="">選択してください</option>
				<option value="和食">和食</option>
				<option value="中華">中華</option>
				<option value="洋食">洋食</option>
				<option value="イタリアン">イタリアン</option>
				<option value="パン">パン</option>
				<option value="ラーメン">ラーメン</option>
				<option value="その他">その他</option>
			</select></td>
	</tr>
	<tr>
		<th>店内利用</th>
			<td>
			<select name="style">
				<option value="">選択してください</option>
				<option value="イートイン">イートイン</option>
				<option value="テイクアウト">テイクアウト</option>
			</select></td>
	</tr>
	<tr>
		<th>日付　<span class ="required">必須</span> </th>
			<td><input type="date" name="date" required><div id = "required2"></div></td>
	</tr>
	<tr>
		<th>料理名</th>
			<td><input type="text" name="foodName" value="" placeholder="例：オムライス"></td>
	</tr>
	<tr>
		<th>費用</th>
			<td><select name="cost">
				<option value="">選択してください</option>
				<option value="～５００円">～５００円</option>
				<option value="～８００円">～８００円</option>
				<option value="～１０００円">～１０００円</option>
				<option value="～１２００円">～１２００円</option>
				<option value="～１５００円">～１５００円</option>
				<option value="１５００円～">１５００円～</option>
			</select></td>
	</tr>
	<tr>
		<th>提供時間</th>
			<td><select name="time">
				<option value="">選択してください</option>
				<option value="５分未満">５分未満</option>
				<option value="５～１０分">５～１０分</option>
				<option value="１０分～１５分">１０分～１５分</option>
				<option value="１５分以上">１５分以上</option>
			</select></td>
	</tr>
	<tr>
		<th>会社からの所要時間</th>
			<td><select name="distance">
				<option value="">選択してください</option>
				<option value="３分未満">３分未満</option>
				<option value="３～５分">３～５分</option>
				<option value="５～７分">５～７分</option>
				<option value="７～１０分">７～１０分</option>
				<option value="１０分以上">１０分以上</option>
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
    		<input id="star1" type="radio" name="star" value="1"/>
    		<label for="star1" >★</label></div>
    	</td>
    </tr>
    <tr>
		<th>感想</th>
			<td><textarea name="feeling"  placeholder="ここに記入してください"></textarea></td>
	</tr>
</form>
</table>

		<!-- 登録ボタン -->
		<input type="submit" name="registNewAccount" value="登録する"  class = "submitBtn" id = "submitBtn" form = "registLdForm" onclick="return check()"><br>

<script type="text/javascript" src="js/diary_form.js"></script>
</main>
</body>
</html>