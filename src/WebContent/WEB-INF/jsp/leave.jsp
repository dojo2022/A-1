<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/leave.js"></script>
<link href="css/leave.css" rel="stylesheet" type="text/css" />
<title>退会フォーム</title>
</head>
<body>
<jsp:include page="header.jsp" />

	<form method="POST" action="/lunchBox/LeaveServlet">
		<h1>退会</h1>
		<hr>
		<p>退会理由を教えてください</p>
		<p>
			<textarea name="reason" cols="100" rows="5" placeholder="例：退社するため"></textarea >
		</p>

		<input type="submit" name="leaveButton" value="設定に戻る">
		<input type="submit" name="leaveButton" onclick ="return confirm('本当に退会しますか？')" value="退会する" >
		${errMsg }
		<!-- <input type="submit" name="backSettings" value="設定に戻る"> -->
		<!-- <input type="submit" name="leaveButton" value="退会する"> -->

	</form>
</body>
</html>