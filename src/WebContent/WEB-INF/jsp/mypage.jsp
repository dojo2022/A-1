<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert </title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="js/mypage.js"></script>
<link href="css/mypage.css" rel="stylesheet" type="text/css" />
</head>
<jsp:include page="header.jsp" />
<body>

<h1 align="center">マイページ</h1>

<!--タブ-->
<ul class="tab-group">
  <li class="tab">手作り記録</li>
  <li class="tab is-active">ランチ日記</li>
  <li class="tab">行きたい場所リスト</li>
</ul>

<!--タブを切り替えて表示するコンテンツ-->
<div class="panel-group">
  <div class="panel">
		手作り記録hogehoge
  </div>
  <div class="panel is-show">
  		ランチ日記hogehoge
  </div>
  <div class="panel">
  		行きたい場所リストhogehoge
  </div>
</div>

<p id="sample">編集</p>
</body>
</html>