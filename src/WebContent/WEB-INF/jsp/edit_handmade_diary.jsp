<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>手作り記録更新削除</title>

<script type="text/javascript" src="js/diary_form.js"></script>
<link href="css/diary_form.css" rel="stylesheet" type="text/css" />

</head>
<!---<jsp:include page="header.jsp" /> -->
<body>

<p>登録内容</p>

<div id="cook">
	<form method="POST" action="/lunchBox/EditHandmadeServlet"enctype="multipart/form-data">

	${ngMsg}
		<input type ="hidden" name="handmadeId" value="${handmadeId}">

		<p>料理名<br>
			<input type="text" name="foodName" placeholder="例：オムライス" value="${foodName}"><br></p>

		<p>写真<br>
			<input type="file" name="foodPhoto" accept="image/*" onchange="previewImage(this);" value="${foodPhoto}"></p>

		<p>所要時間<br>
			<select name="cookTime">
				<option value="">選択してください</option>
				<option value="５分未満"><c:if test=${cookTime == "５分未満"}selected></c:if>５分未満</option>
				<option value="５～１０分"><c:if test=${cookTime == "５分～１０分"}selected></c:if>５～１０分</option>
				<option value="１０～１５分"><c:if test=${cookTime == "１０分～１５分"}selected></c:if>１０～１５分</option>
				<option value="１５分以上"><c:if test=${cookTime == "１５分以上"}selected></c:if>１５分以上</option>
			</select>
		</p>

		<p>日付※必須</p>
			<input type="date" name="date" value="${date}">


		<p>費用<br>
			<select name="cost">
				<option value="">選択してください</option>
				<option value="１００円未満" ><c:if test=${cost == "１００円未満"}selected></c:if>１００円未満</option>
				<option value="１００～３００円" ><c:if test=${cost == "１００～３００円"}selected></c:if>１００～３００円</option>
				<option value="３００～５００円" ><c:if test=${cost == "３００～５００円"}selected></c:if>３００～５００円</option>
				<option value="５００～７００円" ><c:if test=${cost == "５００～７００円"}selected></c:if>５００～７００円</option>
				<option value="７００～１０００円"><c:if test=${cost == "７００～１０００円"}selected></c:if>７００～１０００円</option>
				<option value="１０００円～"><c:if test=${cost == "１０００円～"}selected></c:if>１０００円～</option>
			</select></p>


		<p>評価<br>
			<div class="rate-form">
				  <input id="star5" type="radio" name="star" value="5"><c:if test=${star =="5"}checked></c:if>
				  <label for="star5">★</label>
				  <input id="star4" type="radio" name="star" value="4"><c:if test=${star =="4"}checked></c:if>
				  <label for="star4">★</label>
				  <input id="star3" type="radio" name="star" value="3"><c:if test=${star =="3"}checked></c:if>
				  <label for="star3">★</label>
				  <input id="star2" type="radio" name="star" value="2"><c:if test=${star =="2"}checked></c:if>
				  <label for="star2">★</label>
				  <input id="star1" type="radio" name="star" value="1"><c:if test=${star =="1"}checked></c:if>
				  <label for="star1">★</label>
			</div>
		</p>


		<p>感想（自由記入）<br>
			<textarea name="feeling" value="" placeholder="ここに記入してください" ${feeling}></textarea>
		</p>

		<input type="submit" name="updateButton" value="更新する"><br>
		<input type="submit" name="deleteButton" value="削除する"><br>
	</form>
</div>
</form>



</body>
</html>