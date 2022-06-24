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
			<td><input type="text" name="resName" value = "${param.resName}"><div id ="required1"></div></td>
	</tr>
	<tr>
		<th>写真</th>
			<td><input type="file" name="foodPhoto" accept="image/*" onchange="previewImage(this);" value = "${param.foodPhoto}"></td>
	</tr>
	<tr>
		<th>プレビュー<br><span class = "smallMessage">自動表示されます</span></th>
			<td><canvas id="preview" style="max-width:200px;"></canvas></td>
	</tr>
	<tr>
		<th>ジャンル</th>
			<td><select name=category>
			<option value="">選択してください</option>
				<option value="和食"><c:if test=${category=="和食"}selected></c:if>和食</option>
				<option value="中華"><c:if test=${category=="中華"}selected></c:if>中華</option>
				<option value="洋食"><c:if test=${category=="洋食"}selected></c:if>洋食</option>
				<option value="イタリアン"><c:if test=${category=="イタリアン"}selected></c:if>イタリアン</option>
				<option value="パン"><c:if test=${category=="パン"}selected></c:if>パン</option>
				<option value="ラーメン"><c:if test=${category=="ラーメン"}selected></c:if>ラーメン</option>
				<option value="その他"><c:if test=${category=="その他"}selected></c:if>その他</option>
			</select></td>
	</tr>
	<tr>
		<th>店内利用</th>
			<td>
			<select name="style">
				<option value="">選択してください</option>
				<option value="イートイン"><c:if test=${style=="イートイン"}selected></c:if>イートイン</option>
				<option value="テイクアウト"><c:if test=${style=="テイクアウト"}selected></c:if>テイクアウト</option>
			</select></td>
	</tr>
	<tr>
		<th>日付　<span class ="required">必須</span> </th>
			<td><input type="date" name="date"><div id = "required2" value = "${param.date}"></div></td>
	</tr>
	<tr>
		<th>料理名</th>
			<td><input type="text" name="foodName" value = "${param.foodName}" placeholder="例：オムライス"></td>
	</tr>
	<tr>
		<th>費用</th>
			<td><select name="cost">
				<option value="">選択してください</option>
				<option value="～５００円"><c:if test=${cost=="～５００円"}selected></c:if>～５００円</option>
				<option value="～８００円"><c:if test=${cost=="～８００円"}selected></c:if>～８００円</option>
				<option value="～１０００円"><c:if test=${cost=="～１０００円"}selected></c:if>～１０００円</option>
				<option value="～１２００円"><c:if test=${cost=="～１２００円"}selected></c:if>～１２００円</option>
				<option value="～１５００円"><c:if test=${cost=="～１５００円"}selected></c:if>～１５００円</option>
				<option value="１５００円～"><c:if test=${cost=="～８００円"}selected></c:if>１５００円～</option>
			</select></td>
	</tr>
	<tr>
		<th>提供時間</th>
			<td><select name="time">
				<option value="">選択してください</option>
				<option value="５分未満"><c:if test=${time=="５分未満"}selected></c:if>５分未満</option>
				<option value="５～１０分"><c:if test=${time=="５～１０分"}selected></c:if>５～１０分</option>
				<option value="１０分～１５分"><c:if test=${time=="１０分～１５分"}selected></c:if>１０分～１５分</option>
				<option value="１５分以上"><c:if test=${time=="１５分以上"}selected></c:if>１５分以上</option>
			</select></td>
	</tr>
	<tr>
		<th>会社からの所要時間</th>
			<td><select name="distance">
				<option value="">選択してください</option>
				<option value="３分未満"><c:if test=${distance=="３分未満"}selected></c:if>３分未満</option>
				<option value="３～５分"><c:if test=${distance=="３～５分"}selected></c:if>３～５分</option>
				<option value="５～７分"><c:if test=${distance=="５～７分"}selected></c:if>５～７分</option>
				<option value="７～１０分"><c:if test=${distance=="７～１０分"}selected></c:if>７～１０分</option>
				<option value="１０分以上"><c:if test=${distance=="１０分以上"}selected></c:if>１０分以上</option>
			</select></td>
	</tr>
	<tr>
		<th>評価</th>
		<td>
			<div class = "rate-form">
			<input id="star5" type="radio" name="star" value="5"><c:if test=${star =="5"}checked></c:if>
    		<label for="star5">★</label>
   			<input id="star4" type="radio" name="star" value="4"><c:if test=${star =="4"}checked></c:if>
   			<label for="star4">★</label>
   		 	<input id="star3" type="radio" name="star" value="3"><c:if test=${star =="3"}checked></c:if>
    		<label for="star3">★</label>
    		<input id="star2" type="radio" name="star" value="2"><c:if test=${star =="2"}checked></c:if>
    		<label for="star2">★</label>
    		<input id="star1" type="radio" name="star" value="1"><c:if test=${star =="1"}checked></c:if>
    		<label for="star1" >★</label></div>
    	</td>
    </tr>
    <tr>
		<th>感想</th>
			<td><textarea name="feeling"  placeholder="ここに記入してください" value = "${param.feeling}"></textarea></td>
	</tr>
</form>
</table>

		<!-- 登録ボタン -->
		<input type="submit" name="registLunchDiary" value="登録する"  class = "submitBtn" id = "submitBtn" form = "registLdForm" onclick="return ldCheck()"><br>

<script type="text/javascript" src="js/diary_form.js"></script>
</main>
</body>
</html>