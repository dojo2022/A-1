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
<!--プロフィール-->
<c:out value="${user.accountName}"/><br>
<c:out value="${user.depName}"/><br>
<a href="mailto:${user.emailAddress}">${user.emailAddress}</a><br>
<img src = "/lunchBox/image/${user.icon}">

<ul class="tab-group">
  <li class="tab">手作り記録</li>
  <li class="tab is-active">ランチ日記</li>
  <li class="tab">行きたい場所リスト</li>
</ul>

<!--タブを切り替えて表示するコンテンツ-->
 <!-- 手作り日記タブ  ----------------------------------------------------->
<div class="panel-group">
  <div class="panel">
       <c:if test="${myHandmade == null }">
			登録はありません。
		</c:if>
 		<c:forEach var="e" items="${myHandmade}" >
 		<form method="POST" action="EditHandmadeServlet">
			${e.handmadeId}<br>
			${e.accountName}<br>
			${e.emailAddress}<br>
			${e.hdFoodType}<br>
			<%-- ${e.hdFoodPhoto}<br> --%>
			<img src = "/lunchBox/image/${e.hdFoodPhoto}">
			${e.hdCategory}<br>
			${e.hdDate}<br>
			${e.hdFoodName}<br>
			${e.hdCost}<br>
			${e.hdStar}<br>
			${e.hdFeeling}<br>
			${e.cooktime}<br>
			${e.ldRegistTime}<br>
			<input type="hidden" name="handmadeId" value="${e.handmadeId}">
			<input type="hidden" name="foodPhoto" value="${e.hdFoodPhoto}">
			<input type="hidden" name="date" value="${e.hdDate}">
			<input type="hidden" name="foodName" value="${e.hdFoodName}">
			<input type="hidden" name="cost" value="${e.hdCost}">
			<input type="hidden" name="star" value="${e.hdStar}">
			<input type="hidden" name="feeling" value="${e.hdFeeling}">
			<input type="hidden" name="cookTime" value="${e.cooktime}">
		<input type="submit" name="SUBMIT" value="編集">
		</form>
		<!-- 手作りランチ日記コメント・リアクション表示 -->
		<form method="POST" action="MyPageServlet">
		<c:forEach var="hc" items="${HdComment}">
		<c:if test="${hc.handmadeId == e.handmadeId}">
			${hc.accountName}：
			${hc.hdComment}<br>
		</c:if>
		</c:forEach>
			<input type="text" name="hd_comment" placeholder="コメントを入力してください">
			<input type="submit" name="hc_submit" value="送信する"><br>
			<hr>
		</form>
		</c:forEach>
  </div>

 <!-- ランチ日記タブ  ----------------------------------------------------->
  <div class="panel is-show">
  <c:if test="${myLunch == null }">
			登録はありません。
  </c:if>
 		<c:forEach var="e" items="${myLunch}" >
		<form method="POST" action="MyPageServlet">
			${e.lunchId}<br>
			${e.accountName}<br>
			${e.ldResName}<br>
			<input type="hidden" name="ld_res_name" value="${e.ldResName}">
			${e.ldFoodPhoto}<br>
			${e.ldCategory}<br>
			${e.style}<br>
			${e.ldDate}<br>
			${e.ldFoodName}<br>
			${e.ldCost}<br>
			${e.time}<br>
			${e.distance}<br>
			${e.ldStar}<br>
			${e.ldFeeling}<br>
			<input type="hidden" name="lunch_id" value="${e.lunchId}">
			<input type="hidden" name="resName" value="${e.ldResName}">
			<input type="hidden" name="foodPhoto" value="${e.hdFoodPhoto}">
			<input type="hidden" name="category" value="${e.ldCategory}">
			<input type="hidden" name="style" value="${e.style}">
			<input type="hidden" name="date" value="${e.ldDate}">
			<input type="hidden" name="foodName" value="${e.ldFoodName}">
			<input type="hidden" name="cost" value="${e.ldCost}">
			<input type="hidden" name="time" value="${e.time}">
			<input type="hidden" name="distance" value="${e.distance}">
			<input type="hidden" name="Star" value="${e.ldStar}">
			<input type="hidden" name="feeling" value="${e.ldFeeling}">
		<!-- 外食ランチ日記更新削除 -->
		<a href="/lunchBox/EditLunchServlet" class="editLunch"><button type="button">編集</button></a><br>


		<c:forEach var="lc" items="${LdComment}">
		<c:if test="${lc.lunchId == e.lunchId}">
			${lc.accountName}：
			${lc.ldComment}<br>
		</c:if>
		</c:forEach>
			<input type="text" name="ld_comment" placeholder="コメントを入力してください">
			<input type="submit" name="lc_submit" value="送信する"><br>
		<c:forEach var="lr" items="${ldReactionList}">
		<c:if test="${lr.lunchId == e.lunchId}">
			${lr.countLdToGo}|
			${lr.countLdToTell}|
			${lr.countLdToUse}|
		</c:if>
		</c:forEach>
		<input type="button" name="ToGo" value="行きたい">
		<input type="button" name="ToTellMe" value="教えて">
		<input type="button" name="ToUseidea" value="参考にします"><br>
	</form>
		</c:forEach>
  </div>



   <!-- 行きたい場所リストタブ  ----------------------------------------------------->
  <div class="panel">
  		行きたい場所リスト
 <c:if test="${myList == null }">
			登録はありません。
 </c:if>
	<table>
			<tr>
				<th>お店の名前</th>
				<th>ジャンル</th>
				<th>メモ</th>
				<th>リアクション</th>
				<th>編集</th>
			</tr>
			<c:forEach var="e" items="${myList}" >
				<tr>
					<td width ="240px">${e.listResName}</td>
					<td width ="150px">${e.listCategory}</td>
					<td width ="200px">${e.togoMemo}</td>
					<%-- <td width ="260px">${e.}<br>${e.}<br>${e.}</td> --%>
					<td >
				<form method="POST" action="RegistListServlet">
				<input type="hidden" name="list_id" value="${e.listId}">
				<input type="hidden" name="list_category" value="${e.listCategory}">
				<input type="hidden" name="togo_memo" value="${e.togoMemo}">
				<a href="/lunchBox/EditListServlet" class="editLunch"><button type="button">編集</button></a>
				</form>
			</c:forEach>
		</table>
 </div>

  		<!-- 行きたい場所リスト更新編集 -->



  		<c:forEach var="liList" items="${liList}" >
  		<!--liListがbeansであり、 青いliListはその＄liListの情報が入っている。
  		また、青いliListはbeansLiListみたいにした方がbeansから１つ１つのデータを取るというイメージがわかりやすい。 -->
			${liList.list_id}<br>
			${liList.email_address}<br>
			${liList.res_name}<br>
			${liList.category}<br>
			<%-- <c:forEach var="" items=""> --%>
			${liList.togo_memo}<br>
			${liList.range}<br>
			${liList.list_flag}<br>
			<!--.はGETの代わり。つまり、JSPで画面にこれを表示してくれという意味。  -->
			<%-- </c:forEach> --%>
  		</c:forEach>
  </div>
</div>


<!-- 外食ランチ日記更新削除
 <a href="/lunchBox/EditLunchServlet" class="editLunch"><button type="button">編集</button></a>
行きたい場所リスト更新編集
<a href="/lunchBox/EditListServlet" class="editLunch"><button type="button">編集</button></a>
手作りランチ日記更新削除
<a href="/lunchBox/EditHandmadeServlet" class="editLunch"><button type="button">編集</button></a> -->


<!-- </form> -->
<!-- コントロールシフト/でコメントアウト -->

</body>
</html>