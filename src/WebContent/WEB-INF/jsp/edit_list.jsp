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
    <header>
    </header>
    <main>
        <h1>行きたい場所リスト編集・削除</h1>
            <form method="post" action="/lunchBox/EditListServlet">
                <h2>店名 ※必須</h2>
                <input type="text" name="RES_NAME" placeholder="店舗名(例:鳥貴族 新宿店)まで入力してください" ><!-- あとでvalue値にスコープで挿入  -->
                <h2>ジャンル</h2>
                <select name="CATEGORY" id="" ><!-- あとでvalue値にスコープで挿入  -->
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
                <textarea name="TOGO_MEMO" cols="40" rows="5" placeholder="Add Text" ><!-- あとでvalue値にスコープで挿入  --></textarea><br>
                <p></p>
                <input type="submit" name="tuGoUpdate" value="更新する">
                <input type="submit" name="tuGoDelete" value="削除する">
            </form>
    </main>
</body>
</html>