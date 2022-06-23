<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>行きたい場所リスト編集・削除</title>

<!-- <script type="text/javascript" src="js/list_form.js"></script> -->
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
			        <form method="post" action="/lunchBox/EditListServlet">
						<input type="hidden" name="EMAIL_ADDRESS" value="${user.emailAddress}">
			            <h3>&nbsp;店名 ※必須</h3>
			            <input type="text" name="RES_NAME" placeholder="店舗名(例:鳥貴族 新宿店)まで入力してください" class="form_unit" value="${ここにスコープを挿入}" required="required">
			            <h3>&nbsp;ジャンル</h3>
			            <select name="CATEGORY" id="editCategory" class="form_unit">
			                <option value="">選択してください</option>
			                <option value="和食" <c:if test=${test=="和食"}>selected</c:if>>和食</option>
			                <option value="中華" <c:if test=${test=="中華"}>selected</c:if>>中華</option>
			                <option value="洋食" <c:if test=${test=="洋食"}>selected</c:if>>洋食</option>
			                <option value="イタリアン" <c:if test=${test=="イタリアン"}>selected</c:if>>イタリアン</option>
			                <option value="パン" <c:if test=${test=="パン"}>selected</c:if>>パン</option>
			                <option value="ラーメン" <c:if test=${test=="ラーメン"}>selected</c:if>>ラーメン</option>
			                <option value="その他" <c:if test=${test=="その他"}>selected</c:if>>その他</option>
			            </select>
			            <h3>&nbsp;メモ</h3>
			            <textarea name="TOGO_MEMO" cols="55" rows="5" placeholder="Add Text" class="form_unit" id="editToGoMemo" >${ここにスコープを挿入}</textarea><br>
			            <p class="errmsg" id="error_message"><br>${msg}</p>
			            <input type="hidden" name="LIST_ID"  value="2">
			            <div class="list_button">
			            <input type="submit" name="toGoEdit" value="編集する" >
			            <input type="submit" name="toGoDelete" value="削除する" >
			            </div>
			        </form>

		        </div>
	        </div>
		</div>
	</main>
<script>

'use strict';


<%-- let ctgr = window.sessionStorage.getItem(['']); --%>

/* let editCategory = document.getElementById('editCategory');
editCategory.value = 'テスト';
//これいらないかも

let editToGoMemo = document.getElementById('editToGoMemo');
editToGoMemo.value = 'テスト'; */
//これもいらないかも

</script>
</body>
</html>