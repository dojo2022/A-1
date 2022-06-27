<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ランチ日記更新削除</title>
<script type="text/javascript" src="js/diary_form.js"></script>
<link href="css/diary_form.css" rel="stylesheet" type="text/css" />
</head>
<body>



<p>登録内容</p>
<!-- <input type="radio" id="disp" name="contentsRadio" onclick="buttonClick()">外食
<input type="radio" id="hide" name="contentsRadio" onclick="buttonClick()">手作り -->
<div>
<form method="POST" action="/lunchBox/EditLunchServlet" enctype="multipart/form-data">


		<p>お店の名前※必須<br>
		<input type="text" name="resName"  value="${ldResName}">
		</p>









		<p>写真<br>
		< <input type="hidden" name = "image_file" id="image_file" value="images/${user.ldFoodPhoto}">
			 <input type="file" name="foodPhoto" accept="image/*"  onchange="previewImage(this);"value="${user.ldFoodPhoto}">
		</p>


		<p>ジャンル<br>
			<select name="ldCategory" >
				<option value="">選択してください</option>
				<option value="japan"<c:if test="${category=='japan' }"> selected </c:if>>和食</option>
				<option value="中華"<c:if test="${ldCategory=='中華' }"> selected </c:if>>中華</option>
				<option value="洋食"<c:if test="${ldCategory=='洋食' }"> selected </c:if>>洋食</option>
				<option value="イタリアン"<c:if test="${ldCategory=='イタリアン' }"> selected </c:if>>イタリアン</option>
				<option value="パン"<c:if test="${ldCategory=='パン' }"> selected </c:if>>パン</option>
				<option value="ラーメン"<c:if test="${ldCategory=='ラーメン' }"> selected </c:if>>ラーメン</option>
				<option value="その他"<c:if test="${ldCategory=='その他' }"> selected </c:if>>その他</option>
			</select>
		</p>

		<p>店内利用<br>
			<select name="style">
				<option value="">選択してください</option>
				<option value="イートイン"<c:if test="${style=='イートイン' }"> selected </c:if>>イートイン</option>
				<option value="テイクアウト"<c:if test="${style=='テイクアウト' }"> selected </c:if>>テイクアウト</option>
			</select>
		</p>

		<p>日付※必須</p>
			<input type="date" name="date" value="${ldDate}" >

		<p>料理名<br>
			<input type="text" name="foodName" value="${ldFoodName}" placeholder="例：オムライス"><br>
		</p>

		<p>費用<br>
			<select name="ldCost" >
				<option value="">選択してください</option>
				<option value="～５００円"<c:if test="${ldCost=='～５００円' }"> selected </c:if>>～５００円</option>
				<option value="～８００円"<c:if test="${ldCost=='～８００円' }"> selected </c:if>>～８００円</option>
				<option value="～１０００円"<c:if test="${ldCost=='～１０００円' }"> selected </c:if>>～１０００円</option>
				<option value="～１２００円"<c:if test="${ldCost=='～１２００円' }"> selected </c:if>>～１２００円</option>
				<option value="～１５００円"<c:if test="${ldCost=='～１５００円' }"> selected </c:if>>～１５００円</option>
				<option value="１５００円～"<c:if test="${ldCost=='１５００～円' }"> selected </c:if>>１５００円～</option>
			</select>
		</p>

		<p>提供時間<br>
			<select name="time">
				<option value="">選択してください</option>
				<option value="５分未満"<c:if test="${time=='５分未満' }"> selected </c:if>>５分未満</option>
				<option value="５～１０分"<c:if test="${time=='５～１０分' }"> selected </c:if>>５～１０分</option>
				<option value="１０～１５分"<c:if test="${time=='１０～１５分' }"> selected </c:if>>１０～１５分</option>
				<option value="１５分以上"<c:if test="${time=='１５分以上' }"> selected </c:if>>１５分以上</option>
			</select>
		</p>

		<p>会社からの所要時間<br>
			<select name="distance">
				<option value="">選択してください</option>
				<option value="３分未満"<c:if test="${distance=='３分未満' }"> selected </c:if>>３分未満</option>
				<option value="３～５分"<c:if test="${distance=='３～５分' }"> selected </c:if>>３～５分</option>
				<option value="５～７分"<c:if test="${distance=='５～７分' }"> selected </c:if>>５～７分</option>
				<option value="７～１０分"<c:if test="${distance=='７～１０分' }"> selected </c:if>>７～１０分</option>
				<option value="１０分以上"<c:if test="${distance=='１０分以上' }"> selected </c:if>>１０分以上</option>
			</select>
		</p>

		<p>評価<br></p>
			<div class="rate-form">
				  <input id="star5" type="radio" name="ldStar" value="5"<c:if test="${ldStar =='5'}">checked</c:if>>
				 <label for="star5">★</label>
				  <input id="star4" type="radio" name="ldStar" value="4"<c:if test="${ldStar =='4'}">checked</c:if>>
				  <label for="star4">★</label>
				  <input id="star3" type="radio" name="ldStar" value="3"<c:if test="${ldStar =='3'}">checked</c:if>>
				  <label for="star3">★</label>
				  <input id="star2" type="radio" name="ldStar" value="2"<c:if test="${ldStar =='2'}">checked</c:if>>
				  <label for="star2">★</label>
				  <input id="star1" type="radio" name="ldStar" value="1"<c:if test="${ldStar =='1'}">checked</c:if>>
				  <label for="star1">★</label>
			</div>








		<p>感想<br>
			<textarea  name="feeling"  placeholder="ここに記入してください">${ldFeeling} </textarea>
		</p>


		<input type="hidden" name="lunchId" value="${lunchId }">
		<input type="submit" name="updateButton" value="更新する"><br>



		<input type="submit" name="deleteButton" value="削除する"><br>
	</form>

	</div>







	<!--登録されている写真を射影！？  -->
<script>
function previewImage(obj){
	//alert("aaa");
	var fileReader = new FileReader();

	// 読み込み後に実行する処理
	fileReader.onload = (function() {

		// canvas にプレビュー画像を表示
		var canvas = document.getElementById('preview');
		var ctx = canvas.getContext('2d');
		var image = new Image();
		image.src = fileReader.result;

		console.log(fileReader.result) // ← (確認用)

		images.onload = (function () {
			canvas.width = image.width;
			canvas.height = image.height;
			ctx.drawImage(image, 0, 0);
		});
	});
	// 画像読み込み
	fileReader.readAsDataURL(obj.files[0]);
	console.log(fileReader.result) // ← (確認用)null
}

//読み込まれた時に行う処理


	var fileReader = new FileReader();

	// 読み込み後に実行する処理
	/* fileReader.onload = (function() { */
		// canvas にプレビュー画像を表示
		var canvas = document.getElementById('preview');
		var ctx = canvas.getContext('2d');
		var image = new Image();
		/* alert(document.getElementById("image_file").value); */
		image.src = document.getElementById("image_file").value;

		/* console.log(fileReader.result) */ // ← (確認用)

		image.onload = (function () {
			canvas.width = image.width;
			canvas.height = image.height;
			ctx.drawImage(image, 0, 0);
		});
	/* }); */
	// 画像読み込み
	/* fileReader.readAsDataURL(obj.files[0]); */

	/* console.log(fileReader.result)  */// ← (確認用)null


</script>






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