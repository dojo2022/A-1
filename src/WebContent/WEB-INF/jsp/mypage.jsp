<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ </title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="js/mypage.js"></script>
<link href="css/mypage.css" rel="stylesheet" type="text/css" />
</head>
<jsp:include page="header.jsp" />
<body>



<%-- <form action="/lunchBox/MyPageServlet" method="post" enctype="multipart/form-data">
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
				${uList.accountName}
				<br><input type="hidden"  name="accountName" value="${e.accountName}" readOnly>
			</td>
	 	</tr>
	 	<tr>
			<td class="tableMypage">
				${uList.depname}
				<br><input type="text" name="depName" value="${e.depname}"readOnly>
			</td>
		</tr>
	 	<tr>
	 		<td class="tableMypage">
	 			<a href="#">${uList.emailAddress}</a>
	 			<br><input type="email" name="emailAddress" value="${e.emailAddress}" readOnly>
	 		</td>
		</tr>
		<!-- メールアドレスはリンクで飛んでメールができるようにする -->




<!-- ランチ日記のデータベース(LunchDiaryDAO)から取得 -->
		<tr>
	 		<td class="tableMypage">
	 			${lList.lunch_id}
	 		</td>
		</tr>

		<tr>
			<td class="tableMypage">
				${lList.res_name}
			</td>
		</tr>
		<tr>
			<td class="tableMypage">
				${lList.foodtype}
			</td>
		</tr>
		<tr>
			<td class="tableMypage">
				${lList.category}
			</td>
		</tr>
		<tr>
			<td class="tableMypage">
				${lList.style}
			</td>
		</tr>
		<tr>
			<td class="tableMypage">
				${lList.date}
			</td>
		</tr>
		<tr>
			<td class="tableMypage">
				${lList.foodName}
			</td>
		</tr>
		<tr>
			<td class="tableMypage">
				${lList.cost}
			</td>
		</tr><tr>
			<td class="tableMypage">
				${lList.time}
			</td>
		</tr>
		<tr>
			<td class="tableMypage">
				${lList.distance}
			</td>
		</tr><tr>
			<td class="tableMypage">
				${lList.star}
			</td>
		</tr>
		<tr>
			<td class="tableMypage">
				${lList.feeling}
			</td>
		</tr><tr>
			<td class="tableMypage">
				${lList.foodPhoto}
			</td>
		</tr>
 --%>









	<!-- </table> -->

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
		ここにデータベースの情報を貼り付ける！？！？
 		<c:forEach var="uList" items="${uList}" >
			${uList.name}

		</c:forEach>

  </div>
  <div class="panel is-show">
  		ここにデータベースの情報を貼り付ける！？！？
  		<c:forEach var="lList" items="${lList}" >

  		</c:forEach>

  </div>
  <div class="panel">
  		行きたい場所リストhogehoge
  		<c:forEach var="liList" items="${liList}" >
  		<!--liListがbeansであり、 青いliListはその＄liListの情報が入っている。
  		また、青いliListはbeansLiListみたいにした方がbeansから１つ１つのデータを取るというイメージがわかりやすい。 -->
			${liList.list_id}
			${liList.email_address}
			${liList.res_name}
			${liList.category}
			<%-- <c:forEach var="" items=""> --%>
			${liList.togo_memo}
			${liList.range}
			${liList.list_flag}
			<!--.はGETの代わり。つまり、JSPで画面にこれを表示してくれという意味。  -->
			<%-- </c:forEach> --%>
  		</c:forEach>
  </div>
</div>



<a href="/lunchBox/EditLunchServlet" class="editLunch"><button type="button">編集</button></a>

</form>

</body>
</html>