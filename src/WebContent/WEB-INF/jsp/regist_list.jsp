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
	        <h2 class="list_title">行きたい場所リスト登録</h2>
	        <div class="form_box">
		        <div class="form_con">
		        <table>
			        <form method="post" action="/lunchBox/RegistListServlet">
						<input type="hidden" name="EMAIL_ADDRESS" value="${user.emailAddress}">
						<tr>
						<th>
			            <h3>&nbsp;店名&nbsp;<span class="required">必須</h3>
			            </th>
			            <td>
			            <input type="text" name="RES_NAME" placeholder="店舗名(例:鳥貴族 新宿店)まで入力してください" class="form_unit" required="required">
			            </td>
			            </tr>
			            <tr>
			            <th>
			            <h3>&nbsp;ジャンル</h3>
			            </th>
			            <td>
			            <select name="category" id="" class="form_unit">
			                <option value="">選択してください</option>
			                <option value="和食">和食</option>
			                <option value="中華">中華</option>
			                <option value="洋食">洋食</option>
			                <option value="イタリアン">イタリアン</option>
			                <option value="パン">パン</option>
			                <option value="ラーメン">ラーメン</option>
			                <option value="その他">その他</option>
			            </select>
			            </td>
			            </tr>
			            <tr>
			            <th>
			            <h3>&nbsp;メモ</h3>※200字以内
			            </th>
			            <td>
			            <textarea name="TOGO_MEMO" cols="62" rows="4" placeholder="Add Text" class="form_unit" id="editToGoMemo"></textarea><br>
			            </td>
			            </tr>
			            <tr class="hidden">
			            <td colspan="2">
			            <p class="errmsg" id="error_message"><br>${msg}</p>
			            </td>
			            </tr>

						</table>
			            <div class="list_button">
			            <input type="submit" name="toGoRegist" value="登録する" >
			            </div>
					</form>
		        </div>
	        </div>
		</div>
	</main>

<script type="text/javascript">

</script>

</body>
</html>