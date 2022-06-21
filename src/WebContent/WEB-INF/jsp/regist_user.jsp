<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/regist_user.js"></script>
<link href="css/regist_user.css" rel="stylesheet" type="text/css" />
</head>
<body>

<h1 class="logo">
	<img src="/lunchBox/img/headerLogo.png" alt="LuchBox">
</h1>

<h2 align="center">新規会員登録</h2>
<!-- -<h1 align="center"><img src="img/headerLogo.png"></h1>--->

<form method="POST" action="/lunchBox/RegistUserServlet"enctype="multipart/form-data">
<!-- - <div class="center"style="padding: 5px; margin-bottom: 0px; border: 3px solid #333333; border-radius: 10px;">-->

	<table>
	 <!-- - <caption>新規会員登録</caption>-->
			<tr>
			<th colspan="4"><input type="file" name="icon" accept="image/*" onchange="previewImage(this);"><br></th>
			<div class="center"><canvas id="preview" style="max-width:200px;"></canvas></div>
			</tr>

			<tr>
			<th>アカウント名</th>
				<td><input type="text" name="accountName" value="" placeholder="例：山田太郎" required><br></td>
			<th>部署名</th>
				<td><input type="text" name="depName" value="" placeholder="例：人事部" required><br></td>
			</tr>

			<tr>
			<th>メールアドレス</th>
				<td><input type="email" name="emailAddress" value="" placeholder="例：luncBox@example.com" id="emailAddress" required><br></td>
			<th>メールアドレス（確認用)</th>
				<td><input type="email" name="emailCheck" value="" placeholder="例：luncBox@example.com" id="emailCheck" oninput="checkEmail" required><br></td>
			</tr>

			<tr>
			<th>パスワード</th>
				<td><input type="password" name="pw" value="" placeholder="8文字以上20字以内" id="pw" oninput="checkValue" required><br></td>
			<th>パスワード（確認用）</th>
				<td><input type="password" name="pwCheck" value="" placeholder="8文字以上20字以内" id="check" oninput="checkPassword"required><br></td>
			</tr>
			${pwMsg }

			<tr>
				<div class="center">
				<th colspan="4"><input type="submit" name="registNewAccount" value="登録する"><br></th>
			</div>
			</tr>

	</table>


	</div>
</form>
<script>
	//メールアドレスが確認ボックスと違った時の処理
	function checkEmail(emailCheck){

		var email1 = emailAddress.value;
		var email2 = emailCheck.value;

		if(email1 != email2){
			emailCheck.setCustomValidity("入力内容が一致しません。");
		}else{
			emailCheck.setCustomValidity('');
		}
	}



	//パスワードが確認ボックスと違った時の処理
	function checkPassword(pwCheck){

		var pw1 = pw.value;
		var pw2 = pwCheck.value;

		if(pw1 != pw2){
			pwCheck.setCustomValidity("入力内容が一致しません。");
		}else{
			pwCheck.setCustomValidity('');
		}
	}
</script>

</body>
</html>