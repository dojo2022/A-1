<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>行きたい場所リスト編集・削除</title>

<script type="text/javascript" src="js/list_form.js"></script>
<link href="css/list_form.css" rel="stylesheet" type="text/css" />

</head>
<body>

<jsp:include page="header.jsp" />

    <header>
    </header>
    <main>
	    <div class="display">
	        <h1 class="list_title">行きたい場所リスト編集・削除</h1>
	        <div class="form_box">
		        <div class="form_con">
			        <form method="post" action="/lunchBox/RegistListServlet">
						<input type="hidden" name="EMAIL_ADDRESS" value="${user.emailAddress}">
			            <h3>&nbsp;店名 ※必須</h3>
			            <input type="text" name="RES_NAME" placeholder="店舗名(例:鳥貴族 新宿店)まで入力してください" class="form_unit" value="とりきぞく" required="required">
			            <h3>&nbsp;ジャンル</h3>
			            <select name="CATEGORY" id="editcategory" class="form_unit">
			                <option value="">選択してください</option>
			                <option value="和食">和食</option>
			                <option value="中華">中華</option>
			                <option value="洋食">洋食</option>
			                <option value="イタリアン">イタリアン</option>
			                <option value="パン">パン</option>
			                <option value="ラーメン">ラーメン</option>
			                <option value="その他">その他</option>
			            </select>
			            <h3>&nbsp;メモ</h3>
			            <textarea name="TOGO_MEMO" cols="55" rows="5" placeholder="Add Text" class="form_unit" id="editToGoMemo"></textarea><br>
			            <input type="text" name="LIST_ID"  value="2">
			            <div class="list_button">
			            <input type="submit" name="toGoEdit" value="編集する" >
			            <input type="submit" name="toGoDelete" value="削除する" >
			            </div>
			        </form>
			        <p>${requestmsg}</p>
		        </div>
	        </div>
		</div>
	</main>
</body>
</html>