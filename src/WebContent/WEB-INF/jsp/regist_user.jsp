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
<!--  --><h1 align="center">新規会員登録</h1>
<!-- -<h1 align="center"><img src="img/headerLogo.png"></h1>--->

<form method="POST" action="/lunchBox/regist_userServlet"enctype="multipart/form-data">
<div class="center"style="padding: 5px; margin-bottom: 0px; border: 3px solid #333333; border-radius: 10px;">

	<table>
	 <!-- - <caption>新規会員登録</caption>-->
			<tr>
			<th colspan="4"><input type="file" name="icon" accept="image/*" onchange="previewImage(this);"><br></th>
			<div class="center"><canvas id="preview" style="max-width:200px;"></canvas></div>
			</tr>

			<tr>
			<th>アカウント名</th>
				<td><input type="text" name="caccountName" value="" placeholder="例：山田太郎"><br></td>
			<th>部署名</th>
				<td><input type="text" name="depName" value="" placeholder="例：人事部"><br></td>
			</tr>

			<tr>
			<th>メールアドレス</th>
				<td><input type="text" name="emailAddress" value="" placeholder="例：luncBox@example.com"><br></td>
			<th>メールアドレス（確認用)</th>
				<td><input type="text" name="emailCheck" value="" placeholder="例：luncBox@example.com"><br></td>
			</tr>

			<tr>
			<th>パスワード</th>
				<td><input type="text" name="pw" value="" placeholder="8文字以上20字以内"><br></td>
			<th>パスワード（確認用）</th>
				<td><input type="text" name="pwCheck" value="" placeholder="8文字以上20字以内"><br></td>
			</tr>

			<tr>
			<div class="center">
			<th colspan="4"><input type="submit" name="registNewAccount" value="登録する"><br></th>
			</div>
			</tr>

	</table>
	</div>
</form>

</body>
</html>