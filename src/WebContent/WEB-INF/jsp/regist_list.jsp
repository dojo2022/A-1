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
    <header>
    </header>
    <main>
        <h1>行きたい場所リスト登録</h1>
        <form method="post" action="/lunchBox/RegistListServlet">
            <h2>店名 ※必須</h2>
            <input type="text" name="RES_NAME" placeholder="店舗名(例:鳥貴族 新宿店)まで入力してください">
            <h2>ジャンル</h2>
            <select name="CATEGORY" id="">
                <option value="">選択してください</option>
                <option value="japan">和食</option>
                <option value="china">中華</option>
                <option value="western">洋食</option>
                <option value="italy">イタリアン</option>
                <option value="bread">パン</option>
                <option value="ra-men">ラーメン</option>
                <option value="other">その他</option>
            </select>
            <h2>メモ</h2>
            <textarea name="TOGO_MEMO" cols="40" rows="5" placeholder="Add Text"></textarea>
            <input type="submit" name="tuGoRegist" value="登録する">
        </form>
    </main>
</body>
</html>