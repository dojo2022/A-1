<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
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
	        <input type="text" name="emailAddress" placeholder="メールアドレス" required>
	      </p>
	      <p>
	        <input type="password" name="pw" placeholder="パスワード" required>
	         <span class="field-icon">
            <i toggle="#password-field" class="mdi mdi-eye toggle-password"></i>
          </span>
	      </p>
	      <p>
 			<c:if test="${errMsg == 'メールアドレス、もしくはパスワードが異なります' }">
				メールアドレスまたはパスワードが間違っています！
			</c:if>
	      </p>
	      <p>
	        <input type="submit" name="loginButton" value="ログイン">
	      </p>
	        <a href ="/lunchBox/RegistUserServlet">新規会員登録</a>
	</form>
</body>
</html>