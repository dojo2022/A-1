<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ </title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css">
<link href="css/mypage.css" rel="stylesheet" type="text/css" />

</head>
<jsp:include page="header.jsp" />
<body>

<h1>結果出力欄</h1>
<!--プロフィール-->
<div class = prof>
	<div class="right">
		<img src = "/lunchBox/images/${user.icon}"width="150px" height="150px">
	</div>
	<div class="left">
		氏名：<c:out value="${user.accountName}"/><br>
		部署名：<c:out value="${user.depName}"/><br>
		Email:<a href="mailto:${user.emailAddress}">${user.emailAddress}</a><br>

	</div>
</div>

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

				<img src = "/lunchBox/images/${e.hdFoodPhoto}" width="193px" height="130px"><br>
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
		<!-- 手作り記録コメント・リアクション表示 -->
			<form method="POST" action="MyPageServlet">
			<c:forEach var="hc" items="${HdComment}">
				<c:if test="${hc.handmadeId == e.handmadeId}">
					${hc.accountName}：
					${hc.hdComment}<br>
				</c:if>
			</c:forEach>
			<input type="text" name="hd_comment" placeholder="コメントを入力してください">
			<input type="submit" name="hc_submit" value="送信する"><br>
			<c:forEach var="lr" items="${hdReactionList}">
				<c:if test="${lr.handmadeId == e.handmadeId}">
					${lr.countHdToEat}|
					${lr.countHdToTell}|
					${lr.countHdToUse}|
				</c:if>
			</c:forEach>
			<input type="button" name="hdbtn" value="食べたい">
			<input type="button" name="hdbtn" value="教えて">
			<input type="button" name="hdbtn" value="参考にします"><br>
				<hr>
			</form>
		</c:forEach>
	</div>

 <!-- ランチ日記タブ  ----------------------------------------------------->
	<div class="panel is-show">
		<c:if test="${myLunch == null }">
			登録はありません。
		</c:if>

<input type="hidden" name="mailAddress" id="emailAddress" value="${user.emailAddress}">
<c:forEach var="e" items="${myLunch}" varStatus="status">
<div class="ld">
	<b>${e.accountName}</b>
	<a href="mailto:${e.emailAddress}">${e.emailAddress}</a>
	<span class="date">食べた日：${e.ldDate}</span>
	<span class="category"><b>${e.ldCategory}</b></span><br>



	<%-- ${e.ldFoodPhoto} --%>
	<div class=diarydata>
		<div class = "foodphoto">
			<img src = "/lunchBox/images/${e.ldFoodPhoto}" width="250px" height="180px"><br>
		</div>
		<div class="titles">
		<span class="foodName"><b>${e.ldFoodName}</b></span><br>
		<a href="http://maps.google.co.jp/maps?q=${e.ldResName}" target="_new">${e.ldResName}</a><br>

		<span class="smallTitle">会社からの所要時間：${e.distance}<br>
		費用：${e.ldCost}<br>
		提供時間：${e.time}<br>
		利用：${e.style}<br>
		評価：<span class="star">★</span>${e.ldStar}<br>
		メモ：${e.ldFeeling}<br>
		</span>
		<input type="hidden" name="lunch_id" value="${e.lunchId}" id="lunch_id${status.index}">
		</div>
	</div>


		<c:forEach var="lr" items="${ldReactionList}">
		<c:if test="${lr.lunchId == e.lunchId}">
			<div class="buttons">
			<input type="button" name="to" value="行きたい" onclick="goAjax1(${status.index})" class="toGo">${lr.countLdToGo}
			<input type="button" name="to" value="教えて" onclick="goAjax2(${status.index})" class="toTell">${lr.countLdToTell}
			<input type="button" name="to" value="参考にします" onclick="goAjax3(${status.index})" class="toUse">${lr.countLdToUse}<br>
			</div>
		</c:if>
		</c:forEach>

			<!--lunch_reactionのランチIDとallLunchのランチIDが一致するものの行きたいリアクションについて取得する（1or行がない）-->
			<c:forEach var="a" items="${ldr}" varStatus="st">
				<c:if test="${a.lunchId == e.lunchId and a.ldToGo ==1}">
					<input type = "hidden" name="iki" id="iki${st.index}${status.index}" value="${a.ldToGo}${st.index}">
				</c:if>
				<c:if test="${a.lunchId!= e.lunchId}">
					<input type = "hidden" name="iki" id="iki${st.index}${status.index}" value="">
				</c:if>
				<c:if test="${a.lunchId == e.lunchId and a.ldToTell ==1}">
					<input type = "hidden" name="oshi" id="oshi${st.index}${status.index}" value="${a.ldToTell}${st.index}">
				</c:if>
				<c:if test="${a.lunchId!= e.lunchId}">
					<input type = "hidden" name="oshi" id="oshi${st.index}${status.index}" value="">
				</c:if>
				<c:if test="${a.lunchId == e.lunchId and a.ldToUse ==1}">
					<input type = "hidden" name="san" id="san${st.index}${status.index}" value="${a.ldToUse}${st.index}">
				</c:if>
				<c:if test="${a.lunchId!= e.lunchId}">
					<input type = "hidden" name="san" id="san${st.index}${status.index}" value="">
				</c:if>
			</c:forEach>
 		<input type = "hidden" name="iki" id="iki0${status.index}" value="">
		<input type = "hidden" name="oshi" id="oshi0${status.index}" value="">
 		<input type = "hidden" name="san" id="san0${status.index}" value="">

		<div class="commentArea">
 		<input type="text" name="ld_comment" placeholder="コメントを入力してください" id="ld_comment" class="inputText">
		<input type="button" name="send_comment" value="送信" onclick="goAjax4(${status.index})" class="sendText"><br>
		</div>
		<c:forEach var="lc" items="${LdComment}" varStatus="vst">
			<c:if test="${lc.lunchId == e.lunchId}">
				<div class="commentArea">
					${lc.accountName}：
					${lc.ldComment}<br>
				</div>
			</c:if>
		</c:forEach>

</div>
<form method="POST" action="EditLunchServlet">
				<input type="hidden" name="lunch_id" value="${e.lunchId}" id="lunch_id${status.index}">
				<input type="hidden" name="resName" value="${e.ldResName}">
				<input type="hidden" name="foodPhoto" value="${e.ldFoodPhoto}">
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
			<input type="submit" name="SUBMIT" value="編集" class="edit_btn">
		</form>
</c:forEach>




</div>

   <!-- 行きたい場所リストタブ  ----------------------------------------------------->
  <div class="panel">
 <c:if test="${myList == null }">
			登録はありません。
 </c:if>
	<table id="list_table">
	<thead>
			<tr>
				<th>お店の名前</th>
				<th>ジャンル</th>
				<th>メモ</th>
				<th></th>
			</tr>
	</thead>
	<tbody>
		<c:forEach var="e" items="${myList}" >
			<tr>
				<td>${e.listResName}</td>
				<td>${e.listCategory}</td>
				<td>${e.togoMemo}</td>
				<td>
					<form method="POST" action="EditListServlet">
					<input type="hidden" name="list_res_name" value="${e.listResName}">
					<input type="hidden" name="list_id" value="${e.listId}">
					<input type="hidden" name="list_category" value="${e.listCategory}">
					<input type="hidden" name="togo_memo" value="${e.togoMemo}">
					<input type="submit" name="SUBMIT" value="編集" class="sendText">
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
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



<!-- 外食ランチ日記更新削除
 <a href="/lunchBox/EditLunchServlet" class="editLunch"><button type="button">編集</button></a>
行きたい場所リスト更新編集
<a href="/lunchBox/EditListServlet" class="editLunch"><button type="button">編集</button></a>
手作りランチ日記更新削除
<a href="/lunchBox/EditHandmadeServlet" class="editLunch"><button type="button">編集</button></a> -->


<!-- </form> -->
<!-- コントロールシフト/でコメントアウト -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/mypage.js"></script>
</body>
</html>