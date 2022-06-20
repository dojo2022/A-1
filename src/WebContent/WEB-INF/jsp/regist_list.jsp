<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>行きたい場所リスト登録</title>

<script type="text/javascript" src="js/list_form.js"></script>
<link href="css/list_form.css" rel="stylesheet" type="text/css" />

</head>
<body>

<jsp:include page="header.jsp" />

    <main>
	    <div class="display">
	        <h1 class="list_title">行きたい場所リスト登録</h1>
	        <div class="form_box">
		        <div class="form_con">
			        <form method="post" action="/lunchBox/RegistListServlet">
			            <h3>&nbsp;店名 ※必須</h3>
			            <input type="text" name="RES_NAME" placeholder="店舗名(例:鳥貴族 新宿店)まで入力してください" class="form_unit">
			            <h3>&nbsp;ジャンル</h3>
			            <select name="CATEGORY" id="" class="form_unit">
			                <option value="">選択してください</option>
			                <option value="japan">和食</option>
			                <option value="china">中華</option>
			                <option value="western">洋食</option>
			                <option value="italy">イタリアン</option>
			                <option value="bread">パン</option>
			                <option value="ra-men">ラーメン</option>
			                <option value="other">その他</option>
			            </select>
			            <h3>&nbsp;メモ</h3>
			            <textarea name="TOGO_MEMO" cols="55" rows="5" placeholder="Add Text" class="form_unit"></textarea><br>
			            <div class="list_button">
			            <input type="submit" name="toGoRegist" value="登録する" >
			            </div>
			        </form>
		        </div>
	        </div>
		</div>
	</main>
</body>
</html>