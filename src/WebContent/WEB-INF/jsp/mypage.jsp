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




<form action="/lunchBox/MyPageServlet" method="post" enctype="multipart/form-data">

<table class="tableTotalMypage" >

		<tr>
			<th colspan="2">
			<!--  	<input type="file" name="icon" accept="image/*" onchange="previewImage(this);"><br>-->
			</th>
			<div class="mypagePhoto">
			<canvas id="preview" style="max-width:200px;"></canvas>
			</div>
		</tr>
		<tr>
			<td class="tableMypage">
				${e.accountName}
				<%-- <br><input type="hidden"  name="accountName" value="${e.accountName}" readOnly> --%>
			</td>
	 	</tr>
	 	<tr>
			<td class="tableMypage">
				${e.depname}
				<%-- <br><input type="text" name="depName" value="${e.depname}"readOnly> --%>
			</td>
		</tr>
	 	<tr>
	 		<td class="tableMypage">
	 			<a href="#">${e.emailAddress}</a>
	 			<br><input type="email" name="emailAddress" value="${e.emailAddress}" readOnly>
	 		</td>
		</tr>
	</table>

<h1>結果出力欄</h1>

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



<a><button type="button">編集</button></a>



</body>
</html>