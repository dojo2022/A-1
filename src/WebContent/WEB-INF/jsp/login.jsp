<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<title>LunchBox</title>
</head>

<body>
	<h1 class="login_logo">
		<img src="/lunchBox/img/headerLogo.png" alt="LunchBox">
	</h1>
	<form method="POST" action="/lunchBox/LoginServlet">
		  <p>
	        <input type="text" name="emailAddress" placeholder="メールアドレス" value= "${emailAddress}" required>
	      </p>
	      <p>
	        <input type="password" name="pw" placeholder="パスワード" id="pw" required>
	      </p>
	      <p>
	        <label><input type="checkbox" name="ch" >パスワードの表示</label>
	      </p>
	      <p>
	      	${pwMsg}
 			${errMsg }
			${result}
	      </p>
	      <p>
	        <input type="submit" name="loginButton" value="ログイン">
	      </p>
	        <a href ="/lunchBox/RegistUserServlet">新規会員登録</a>
	</form>
	<script>
	//チェックボックスが変動したら
	jQuery('input[type=checkbox]').change(function() {
		//●●表示だったら
		if($('#pw').get(0).type == 'password'){
			//typeをtextに変更する
			$('#pw').get(0).type = 'text';
		//ちゃんと表示されていたら
		}else{
			//typeをpasswordに変更する
			$('#pw').get(0).type = 'password';
		}
	});
	</script>
</body>
</html>