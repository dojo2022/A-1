<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>設定</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<!-- <script type="text/javascript" src="js/settings.js"></script> -->
	<link href="css/settings.css" rel="stylesheet" type="text/css" />

</head>
<jsp:include page="header.jsp" />
<body>
<h1>設定</h1>



<!--< var="e" items="${cardList}" -->
	<form action="/lunchBox/SettingsServlet" method="post" enctype="multipart/form-data">

	<table class="tableForm" >

		<tr>
			<th colspan="2">
				<input type="hidden" name = "image_file" id="image_file" value="images/${user.icon }">
				<input type="file" name="icon" accept="image/*" onchange="previewImage(this);" value="${user.icon }" ><br>
			</th>
			<div class="center">
			<canvas id="preview" style="max-width:200px;" ></canvas>
			</div>
		</tr>
		<tr>
			<td class="tableLeft">
				名前<br><input type="text" name="accountName" value="${user.accountName}">
			</td>
			<td>
				パスワード<br><input type="password" name="pw" value="${user.pw}">
			</td>                   		 <!-- セッション領域からとってきたuserという箱-->
	 	</tr>
	 	<tr>
			<td class="tableLeft">
				部署名<br><input type="text" name="depName" value="${user.depName}">
			</td>
			<td>
				パスワード確認用<br><input type="password" name="pwCheck" value="">
			</td>
		</tr>
	 	<tr>
	 		<td class="tableLeft">
	 			メールアドレス<br><input type="email" name="emailAddress" value="${user.emailAddress}" readOnly>
	 		</td>
			<td>
				公開設定<!--  ${user.range}--><br>
				<c:if test="${user.range == 1 }">
					<input class="koukai" type="radio" name="range" value="1" id="one" checked >
					<label for="one">公開</label>
		 			<input type="radio" name="range" value="0"id="two" >
		  		    <label for="two">非公開</label>
	  		    </c:if>
	  		    <c:if test="${user.range == 0 }">
					<input class="koukai" type="radio" name="range" value="1" id="one"  >
					<label for="one">公開</label>
		 			<input type="radio" name="range" value="0"id="two" checked>
		  		    <label for="two">非公開</label>
	  		    </c:if>
	  		    	<!-- この下の４行はあとで消します -->
	  		   		<!--   <input class="koukai" type="radio" name="range" value="1" id="one"checked  >
					<label for="one">公開</label>
		 			<input type="radio" name="range" value="0"id="two" >
		  		    <label for="two">非公開</label>-->
	  		</td>
		</tr>
	</table>


<%--
		<input type="radio" name="range" value="${user.range}"id="one">
		<label for="one">公開</label>
		<input type="radio" name="range" value="${user.range}"id="two">
		<label for="two">非公開</label> --%>





<div class="kousin">
<!-- <input  type = button onclick= "history.back()" value="戻る">-->
<input type="submit" name="SUBMIT" value="更新する">
</div>
<div >
<p><a href="/lunchBox/LeaveServlet" class="leave">退会する方はこちら</a></p>
</div>








	</form>
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

		image.onload = (function () {
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
window.onload = function(){

	var fileReader = new FileReader();

	// 読み込み後に実行する処理
	/* fileReader.onload = (function() { */
		// canvas にプレビュー画像を表示
		var canvas = document.getElementById('preview');
		var ctx = canvas.getContext('2d');
		var image = new Image();
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
}
</script>





</body>
</html>